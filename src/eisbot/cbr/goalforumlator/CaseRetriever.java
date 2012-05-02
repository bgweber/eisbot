package eisbot.cbr.goalforumlator;

import java.util.ArrayList;

import abl.runtime.BehavingEntity;

import weka.core.Instance;
import weka.core.Instances;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Logger;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.abl.wmes.EnableCBRWME;
import eisbot.abl.wmes.ReplanWME;
import eisbot.abl.wmes.prediction.PredictionWME;
import eisbot.abl.wmes.prediction.TechPredictionWME;
import eisbot.abl.wmes.prediction.UnitPredictionWME;
import eisbot.abl.wmes.prediction.UpgradePredictionWME;
import eisbot.abl.wmes.requests.BuildingRequestWME;
import eisbot.abl.wmes.requests.ResearchRequestWME;
import eisbot.abl.wmes.requests.UnitRequestWME;
import eisbot.cbr.goalforumlator.filter.Filter;
import eisbot.cbr.goalforumlator.filter.UnitAndBothHeavyTimingFilter;
import eisbot.cbr.goalforumlator.io.InstanceImporter;
import eisbot.cbr.goalforumlator.retriever.BuildOrder;
import eisbot.cbr.goalforumlator.retriever.Retriever;
import eisbot.cbr.goalforumlator.retriever.TraceRetriever;
import eisbot.proxy.wmes.TechTypeWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.UpgradeTypeWME;
import eisbot.proxy.wmes.TechTypeWME.TechType;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;
import eisbot.proxy.wmes.UpgradeTypeWME.UpgradeType;

public class CaseRetriever {

	private static final String protossArffFile = "src/eisbot/cbr/data/tracesPvP-Protoss.arff";
	private static final String terranArffFile = "src/eisbot/cbr/data/tracesPvT-Protoss.arff";
	private static final String zergArffFile = "src/eisbot/cbr/data/tracesPvZ-Protoss.arff";
 
	private GameEncoder encoder;
	private ArrayList<Instances> traces;
		
	private Retriever retriever;
	private int windowSize;
	private int replanSize;
	private double sampleRatio;	
	private boolean running;	
	private Instance gameState;	
	long lastDebug;	
	ArrayList<BuildOrder> actions;	

	private Race race = Race.Protoss;
 
	private Filter filter = new UnitAndBothHeavyTimingFilter();;

	// Initial Case retriever properties
	public static int PlanningWindowSize = 10; 
	public static int ReplanningSize = 0;  
	public static double SamplingRatio = 1; 
	 
	public static boolean EnablePredictor = true;
	public static int PredictionWindowSize = 20;	
	public static int PredictionPeriod = 24*30; 

	public static boolean EnableGDA = true;
	public static int DiscrepancyPeriod = 24*30; 
 
	public void initialize() {
		retriever = new TraceRetriever();
		windowSize = PlanningWindowSize;
		replanSize = ReplanningSize;
		sampleRatio = SamplingRatio;
		running = false;	 	
		lastDebug = System.currentTimeMillis();		
		actions = new ArrayList<BuildOrder>();
	}
	 
	public CaseRetriever() throws Exception {
		Logger.print("CBR", "Using case retriever");
		initialize();
	}

	public static PredictionWME getPrediction(String attribute, int timing, int attributeID) {
		try {
			if (attribute.startsWith("enemy")) {
				attribute = attribute.substring("enemy".length());
				
				// unit type
				if (attribute.endsWith("Timing")) {
					attribute = attribute.substring(0, attribute.indexOf("Timing"));

					UnitType type = UnitType.valueOf(attribute);
					return new UnitPredictionWME(type, timing, attributeID);
				} 
				// filter out unit counts
				else if (attribute.endsWith("Count")) { }	
				// upgrade
				else {  
					try {
						UpgradeType upgrade = UpgradeType.valueOf(attribute);							
						return new UpgradePredictionWME(upgrade, timing);
					}
					catch (Exception e) { 
						TechType tech = TechType.valueOf(attribute);
						return new TechPredictionWME(tech, timing);
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void start(Race playerRace, final Race enemyRace) {
		Logger.print("CBR", "Starting the CBR component");
		running = true;
		
		new Thread() {
			public void run() { 
				Thread.currentThread().setName("CBR Retrieval Thread");
				 
				// load the correct race 
				try { 
					switch (enemyRace) {
					case Protoss: 
						encoder = new GameEncoder(race, Race.Protoss);
						traces = InstanceImporter.loadGames(encoder, filter, protossArffFile);					
						break;
					case Terran:
						encoder = new GameEncoder(race, Race.Terran);
						traces = InstanceImporter.loadGames(encoder, filter, terranArffFile);					
						break;
					case Zerg:
						encoder = new GameEncoder(race, Race.Zerg);
						traces = InstanceImporter.loadGames(encoder, filter, zergArffFile);					
						break;
					}
					 
					System.out.println("Training model");
					retriever.train(race, traces, sampleRatio);
					System.out.println("Model trained");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				// start the CBR opponent modeling thread
				if (EnablePredictor) {
					new Thread() {
						public void run() {
							Thread.currentThread().setName("CBR Opponent Modeling Thread");
							
							int nextUpdate = 0;
							
							while (running) {
								try {
									Thread.sleep(20);						
						
									// if the CBR component enabled?
									if (ABLStarCraftBot.getBehavingEntity().lookupWME(EnableCBRWME.class.getSimpleName()).size() == 0) {   
										continue;
									}

									if (ABLStarCraftBot.getGame().getGameFrame() >= nextUpdate) {
												
										// has a discrepancy occured? (GDA mode)
										boolean forceReplan = false;
										if (EnableGDA) {
											
											System.err.println("Checking for discrepancies"); 
											Logger.print("CBR", "Checking for discrepancies");
											int gameFrame = ABLStarCraftBot.getGame().getGameFrame();
							
											// DiscrepancyPeriod

											for (Object prediction : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME(PredictionWME.class.getSimpleName())) {
												if (gameFrame > DiscrepancyPeriod + ((PredictionWME)prediction).getTiming()) {
													forceReplan = true;
													break;
												}
											}
										}
										 
										// get opponent predictions
										Instance currentState = encoder.encodeGame(ABLStarCraftBot.getGame());
										ArrayList<PredictionWME> predictions = retriever.predictEnemyState(encoder, currentState, PredictionWindowSize);
	
										// update working memory
										synchronized (retriever) {
											
											ABLStarCraftBot.getBehavingEntity().deleteAllWMEClass("PredictionWME");
											for (PredictionWME prediction : predictions) { 
												
												// already encountered unit?
												if (prediction instanceof UnitPredictionWME && 
														ABLStarCraftBot.getGame().getRecon().getEnemyTypes().containsKey(((UnitPredictionWME)prediction).getTypeID())) {										
													continue;
												} 
												 
									        	ABLStarCraftBot.getBehavingEntity().addWME(prediction);
											}
										} 
	   
										// force a replan to occur (GDA mode)
										if (forceReplan) { 
											System.err.println("Discrepancy found, forcing replan");
											Logger.print("CBR", "Discrepancy found, forcing replan");
											BehavingEntity.getBehavingEntity().addWME(new ReplanWME());
										}
										
										nextUpdate = ABLStarCraftBot.getGame().getGameFrame() + PredictionPeriod; 
									}
								}
								catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}.start();
				}
			   
				while (running) {
					try {
						Thread.sleep(20);						
  						 						
						// if the CBR component enabled?
						if (ABLStarCraftBot.getBehavingEntity().lookupWME(EnableCBRWME.class.getSimpleName()).size() == 0) {
							continue;
						}
						
						// time to retrieve more actions?
						if (actions.size() <= replanSize || ABLStarCraftBot.getBehavingEntity().lookupWME(ReplanWME.class.getSimpleName()).size() > 0) {
							if (encoder == null) {
								continue; 
							} 
							 
							gameState = encoder.encodeGame(ABLStarCraftBot.getGame());

							// clear replan requests
							ABLStarCraftBot.getBehavingEntity().deleteAllWMEClass(ReplanWME.class.getSimpleName());
							Logger.print("CBR", "Game state: " + gameState);
							 
							if (gameState != null) {
								Instance currentState = gameState;
								Logger.print("CBR", "Running CBR");
								Logger.print("CBR", "-------------------------");

								// add enemy predictions
								synchronized (retriever) {
									for (Object obj : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME("UnitPredictionWME")) {
										UnitPredictionWME prediction = (UnitPredictionWME)obj;				  
										gameState.setValue(prediction.getAttribute(), prediction.getTiming()*UnitAndBothHeavyTimingFilter.TimingFactor);
									}								
								}
								
								// apply filter
//								filter.applyFiler(encoder, currentState);		 	
								 
								Logger.print("CBR", "Current state: " + currentState);
								for (int i=0; i<currentState.numAttributes(); i++) {
									if (currentState.value(i) > 0) {
										Logger.print("CBR", "  " + currentState.attribute(i).name() + ": " + currentState.value(i));
									}
								}
								    
								ArrayList<BuildOrder> orders = retriever.predictState(encoder, currentState, windowSize);
								actions = orders;

								StringBuffer buffer = new StringBuffer("Actions: ");
								for (BuildOrder action1 : actions) {
									buffer.append(" " + action1 + ", ");
								}
								
								Logger.print("CBR", buffer.toString()); 		
							}
						}

						// only allow 1 request at a time
						if (ABLStarCraftBot.getBehavingEntity().lookupWME(UnitRequestWME.class.getSimpleName()).size() == 0 &&
							ABLStarCraftBot.getBehavingEntity().lookupWME(BuildingRequestWME.class.getSimpleName()).size() == 0 &&
							ABLStarCraftBot.getBehavingEntity().lookupWME(ResearchRequestWME.class.getSimpleName()).size() == 0 &&
							actions.size() > 0) {

							BuildOrder action = actions.get(0);
							actions.remove(0);
//							Logger.print("CBR Full", action.toString());
							
							// dont build probes
							if (action.getUnitType() != null && action.getUnitType().equals(UnitType.Protoss_Probe)) {
								Logger.print("CBR", "Throwing away probe request");
								continue;
							}
							// dont build pylons
							else if (action.getUnitType() != null && action.getUnitType().equals(UnitType.Protoss_Pylon)) {
								Logger.print("CBR", "Throwing away pylon request");
								continue;
							}
							// dont build assimilators
							else if (action.getUnitType() != null && action.getUnitType().equals(UnitType.Protoss_Assimilator)) {
								Logger.print("CBR", "Throwing away assimilator request");
								continue;
							}
							
							// TODO: check for prereqs??
							Logger.print("CBR Attempted", action.toString());
							
							// process the build action
							if (action.getUnitType() != null) {
								UnitTypeWME unitType = UnitTypeWME.getType(action.getUnitType().ordinal());								
								
								// is this a unit request?
								if (!unitType.isBuilding()) {
									ABLStarCraftBot.getBehavingEntity().addWME(new UnitRequestWME(unitType));
								}
								// is this a building request?
								else {
									ABLStarCraftBot.getBehavingEntity().addWME(new BuildingRequestWME(unitType));
								}
							}
							// is this a research request
							else {
								if (action.getTechType() != null) {
									TechTypeWME techType = TechTypeWME.getType(action.getTechType().ordinal());
									ABLStarCraftBot.getBehavingEntity().addWME(new ResearchRequestWME(techType));
								}
								
								if (action.getUpgradeType() != null) {
									UpgradeTypeWME upgradeType = UpgradeTypeWME.getType(action.getUpgradeType().ordinal());
									ABLStarCraftBot.getBehavingEntity().addWME(new ResearchRequestWME(upgradeType));
								}								
							} 
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}				
				 
				Logger.print("CBR", "CBR Stopped");
			}
		}.start();
	}
	
	public void stop() {
		Logger.print("CBR", "Stopping the CBR component");
		encoder = null;
		running = false;	
		gameState = null;
		initialize();
	}
} 
