package eisbot.abl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import abl.runtime.BehavingEntity;
import eisbot.abl.StarCraftConstants.Order;
import eisbot.abl.wmes.KeyPressWME;
import eisbot.abl.wmes.SquadWME;
import eisbot.buildorder.BuildSelector;
import eisbot.cbr.goalforumlator.CaseRetriever;
import eisbot.gui.ABLPanel;
import eisbot.gui.ABTViewer;
import eisbot.gui.BehaviorProfiler;
import eisbot.gui.CommandLogPanel;
import eisbot.gui.LoggingPanel;
import eisbot.gui.ReconPanel;
import eisbot.gui.RequestPanel;
import eisbot.gui.SpeedPanel;
import eisbot.gui.StarCraftFrame;
import eisbot.gui.WMEPanel;
import eisbot.proxy.BWAPIEventListener;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.command.CommandQueue;
import eisbot.proxy.filter.ParticleFilter.ParticleFilterMode;
import eisbot.proxy.model.Unit;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
/**
 
Configuration Properties
  
 Agent Settings
	- ABLBotName (String): Name of the ABL bot to instantiate
	- BuildOrderScript (String): path of the build order to run

 Game Settings
 	- GameSettings.IgnoreBases (boolean): disbale BWTA?
	- GameSettings.IccupMode (boolean): run iccup script?
	- GameSettings.ShowGUI (boolean): show the agent GUI?
	- GameSettings.AutoRestart (boolean): restart games on game end?
	- GameSettings.UseManners (boolean): quit when loss is detected?
	- GameSettings.Fastest (boolean): setSpeed(0)?
	- GameSettings.UserInput (boolean): enable the user to perform actions?
	- GameSettings.QuitOnGameEnd (boolean): end this process when the game ends?
	- GameSettings.AutoCamera (boolean): Enables automatic camera positioning 
  
 Build Selection
	- BuildSelector.Epsilon (double): epsilon value for build order selection
	- BuildSelector.BaseCountWeight (double): base count weight for build order selection 
	- BuildSelector.ExpoChokeWeight (double): expo chokepoint weight for build order selection
	- BuildSelector.HistoryWeight (double): history (boredom) weight for build order selection
	- BuildSelector.HistorySize (iont): number of builds to maintain in history for computing resuse weight

 Particle Filter
	- ParticleFilter.Mode (enum): The type of particle filter to use. See ParticleFilter.ParticleFilterMode 

 Goal Formulator
	- GoalFormulator.Enable (boolean): Enable the CBR goal formulation component?
	- GoalFormulator.PlanningWindowSize (int): How many actions to plan ahead
	- GoalFormulator.ReplanningSize (int): Minimum action window size for triggering replanning
	- GoalFormulator.SamplingRatio (double): Ratio of training examples to use
 
 Opponent Predictor 
	- OpponentPredictor.Enable (boolean): Enable the opponent strategy prediction component?
	- OpponentPredictor.PredictionWindowSize (int): How far to look ahead in terms of build actions?
	- OpponentPredictor.PredictionPeriod (int): How frequent to run? (delay in game frames)

 Goal Driven Autonomy
	- GDA.Enable (boolean): Enable the opponent strategy prediction component?
	- GDA.DiscrepancyPeriod (int): How frequent to run? (delay in game frames)

 Misc
	- ICCupPassword
 */
public class ABLStarCraftBot implements BWAPIEventListener {

	private static ABLStarCraftBot thisInstance;	
	
	private CommandQueue commandQueue = new CommandQueue();;
	
	/** reference to JNI-BWAPI */ 
	private JNIBWAPI bwapi;
	
	private BehavingEntity ablBot; 
	
	private Game game;
	private long lastCameraUpdate = 0;  
	 
	private int drawBuildLocations = 0;
	private boolean drawParticles = false;

	private StarCraftFrame gameFrame;
	private SpeedPanel speedPanel = null;
	private WMEPanel wmePanel = null;
	private ReconPanel reconPanel = null;
	private BehaviorProfiler profilerPanel = null;
	private RequestPanel requestPanel = null;
	private ABTViewer abtViewer;	
	private JFrame mainFrame;
 
	private int delay = 0;
	private int quitFrame = 0;

	// CBR properties 
	private CaseRetriever caseRetriever; 
	private static boolean goalFormulation = true; 

	// game settings 
	public static boolean IgnoreBases = false;	// for micro scenarios
	private static boolean showGUI = true; 
	private static boolean autoRestart = false;
	private static boolean useManners = false; 
	private static boolean fastest = true;   
	private static boolean userInput = true;
	private static boolean fogOfWar = false; 
	private static boolean quitOnGameEnd = false;
	private static boolean autoCamera = false;

	public static void main(String[] args) {
		System.out.println("EISBot Launching " + new Date());

		loadProperties();

		new ABLStarCraftBot(); 
	}
	
	public static void loadProperties() { 
		
		// game settings
		if (System.getProperty("GameSettings.IgnoreBases") != null) {
			IgnoreBases = Boolean.getBoolean("GameSettings.IgnoreBases");
		}

		if (System.getProperty("GameSettings.ShowGUI") != null) {
			 showGUI = Boolean.getBoolean("GameSettings.ShowGUI");
		}
		
		if (System.getProperty("GameSettings.AutoRestart") != null) {
			 autoRestart = Boolean.getBoolean("GameSettings.AutoRestart");
		}
		
		if (System.getProperty("GameSettings.UseManners") != null) {
			 useManners = Boolean.getBoolean("GameSettings.UseManners");
		}
		
		if (System.getProperty("GameSettings.Fastest") != null) {
			 fastest = Boolean.getBoolean("GameSettings.Fastest");
		}
		
		if (System.getProperty("GameSettings.UserInput") != null) {
			 userInput = Boolean.getBoolean("GameSettings.UserInput");
		}

		if (System.getProperty("GameSettings.QuitOnGameEnd") != null) {
			 quitOnGameEnd = Boolean.getBoolean("GameSettings.QuitOnGameEnd");
		}

		if (System.getProperty("GameSettings.AutoCamera") != null) { 
			 autoCamera = Boolean.getBoolean("GameSettings.AutoCamera");
		}

		// build selector
		if (System.getProperty("BuildSelector.Epsilon") != null) {
			BuildSelector.epsilon = Double.parseDouble(System.getProperty("BuildSelector.Epsilon"));
		}
		
		if (System.getProperty("BuildSelector.BaseCountWeight") != null) {
			BuildSelector.baseCountWeight = Double.parseDouble(System.getProperty("BuildSelector.BaseCountWeight"));
		}
		
		if (System.getProperty("BuildSelector.ExpoChokeWeight") != null) {
			BuildSelector.expoChokeWeight = Double.parseDouble(System.getProperty("BuildSelector.ExpoChokeWeight"));
		}

		if (System.getProperty("BuildSelector.HistoryWeight") != null) {
			BuildSelector.historyWeight = Double.parseDouble(System.getProperty("BuildSelector.HistoryWeight"));
		}

		if (System.getProperty("BuildSelector.HistorySize") != null) {
			BuildSelector.historySize = Integer.parseInt(System.getProperty("BuildSelector.HistorySize"));
		}

		// goal formulator
		if (System.getProperty("GoalFormulator.Enable") != null) {
			goalFormulation = Boolean.getBoolean("GoalFormulator.Enable");
		}

		if (System.getProperty("GoalFormulator.PlanningWindowSize") != null) {
			CaseRetriever.PlanningWindowSize = Integer.getInteger("GoalFormulator.PlanningWindowSize");
		}

		if (System.getProperty("GoalFormulator.ReplanningSize") != null) {
			CaseRetriever.ReplanningSize = Integer.getInteger("GoalFormulator.ReplanningSize");
		}

		if (System.getProperty("GoalFormulator.SamplingRatio") != null) {
			CaseRetriever.SamplingRatio = Double.parseDouble(System.getProperty("GoalFormulator.SamplingRatio"));
		}

		if (System.getProperty("OpponentPredictor.Enable") != null) {
			CaseRetriever.EnablePredictor = Boolean.getBoolean("OpponentPredictor.Enable");
		}

		if (System.getProperty("OpponentPredictor.PredictionWindowSize") != null) {
			CaseRetriever.PredictionWindowSize = Integer.getInteger("OpponentPredictor.PredictionWindowSize");
		}

		if (System.getProperty("OpponentPredictor.PredictionPeriod") != null) { 
			CaseRetriever.PredictionPeriod = Integer.getInteger("OpponentPredictor.PredictionPeriod");
		}

		if (System.getProperty("GDA.Enable") != null) {
			CaseRetriever.EnableGDA = Boolean.getBoolean("GDA.Enable");
		}

		if (System.getProperty("GDA.DiscrepancyPeriod") != null) { 
			CaseRetriever.DiscrepancyPeriod = Integer.getInteger("GDA.DiscrepancyPeriod");
		}
		
		// get the particle filter mode 
		ParticleFilterMode mode = ParticleFilterMode.OptimizedParticles;
		if (System.getProperty("ParticleFilter.Mode") != null) {
			mode = ParticleFilterMode.valueOf(System.getProperty("ParticleFilter.Mode"));
		}
		 
		switch (mode) {
		case PerfectInformation:
			fogOfWar = false;
			System.setProperty("IdentifyParticles", "" + false);  
			System.setProperty("DefaultParticles", "" + false);
			System.setProperty("UseTargetVector", "" + false);			
			break;
		case DefaultParticles:  
			fogOfWar = true;
			System.setProperty("IdentifyParticles", "" + false); 
			System.setProperty("DefaultParticles", "" + true);
			System.setProperty("UseTargetVector", "" + false);			
			break;
		case OptimizedParticles:  
			fogOfWar = true;
			System.setProperty("IdentifyParticles", "" + false); 
			System.setProperty("DefaultParticles", "" + false);
			System.setProperty("UseTargetVector", "" + false);			
			break;
		case DefaultIdentifyParticles: 
			fogOfWar = true;
			System.setProperty("IdentifyParticles", "" + true); 
			System.setProperty("DefaultParticles", "" + true);
			System.setProperty("UseTargetVector", "" + false);			
			break;
		case OptimizedIdentifyParticles: 
			fogOfWar = true; 
			System.setProperty("IdentifyParticles", "" + true); 
			System.setProperty("DefaultParticles", "" + false);
			System.setProperty("UseTargetVector", "" + false);			
			break;
		}

		// bot settings
		if (System.getProperty("ABLBotName") == null) {
			System.setProperty("ABLBotName", "ProtossBuildTransitionBot");
		}
 		
		// configuration summary
		System.out.println("Configution");
		System.out.println(" " + ((char)186) + " ABL Agent: " + System.getProperty("ABLBotName"));

		System.out.println(" " + ((char)186) + " Game Settings");
		System.out.println("   - Ignore terrain: " + IgnoreBases);     
		System.out.println("   - Show GUI: " + showGUI);     
		System.out.println("   - Auto restart: " + autoRestart);     
		System.out.println("   - Use manners: " + useManners);     
		System.out.println("   - Fastest: " + fastest);     
		System.out.println("   - User input: " + userInput);     
		System.out.println("   - Quit on game end: " + quitOnGameEnd);     
		System.out.println("   - Auto camera: " + autoCamera);     

		System.out.println(" " + ((char)186) + " Build Selection");
		System.out.println("   - Script path: " + System.getProperty("BuildOrderScript"));     
		System.out.println("   - Epsilon: " + BuildSelector.epsilon);     
		System.out.println("   - Base count weight: " + BuildSelector.baseCountWeight);     
		System.out.println("   - Expo chokepoint weight: " + BuildSelector.expoChokeWeight);     
		System.out.println("   - History weight: " + BuildSelector.historyWeight);     
		System.out.println("   - History size: " + BuildSelector.historySize);     
		 
		System.out.println(" " + ((char)186) + " Particle Filter");
		System.out.println("   - Mode: " + mode);     
	   		
		System.out.println(" " + ((char)186) + " Goal Formulator");
		System.out.println("   - enabled: " + goalFormulation);
		System.out.println("   - planning window size: " + CaseRetriever.PlanningWindowSize);
		System.out.println("   - replanning size: " + CaseRetriever.ReplanningSize);
		System.out.println("   - sampling ratio: " + CaseRetriever.SamplingRatio); 
 
		System.out.println(" " + ((char)186) + " Opponent Predictor");
		System.out.println("   - enabled: " + CaseRetriever.EnablePredictor);
		System.out.println("   - window size: " + CaseRetriever.PredictionWindowSize);
		System.out.println("   - prediction period: " + CaseRetriever.PredictionPeriod);		

		System.out.println(" " + ((char)186) + " Goal Driven Autonomy (Strategy)"); 
		System.out.println("   - enabled: " + CaseRetriever.EnableGDA);
		System.out.println("   - prediction period: " + CaseRetriever.DiscrepancyPeriod);		
	} 

	public ABLStarCraftBot() { 
		thisInstance = this;

		// initialize the CBR component
		if (goalFormulation) { 
			try {
				caseRetriever = new CaseRetriever();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
 
		// connect to BWAPI 
		bwapi = new JNIBWAPI(ABLStarCraftBot.this);
		bwapi.start();
	}

	public static BehavingEntity getBehavingEntity() {
		return thisInstance.ablBot;
	}
		
	public static CommandQueue getQueue() {
		return thisInstance.commandQueue;
	}
	
	public static Game getGame() {
		return thisInstance.game;
	}
	
	public void connected() {
		System.out.println("Connected to StarCraft");
		bwapi.loadTypeData();
	}	

	public void gameStarted() { 
		quitFrame = 0;
		
		if (IgnoreBases == false) {
			bwapi.loadMapData(true);			
		} 
		 
		if (userInput) bwapi.enableUserInput();
		if (!fogOfWar) bwapi.enablePerfectInformation();
		if (fastest) bwapi.setGameSpeed(0);

		try {
			game = new Game(bwapi);
			commandQueue.clear();
			
			// Start the ABL agent
			ablBot = (BehavingEntity)Class.forName("eisbot.abl.java." + System.getProperty("ABLBotName")).newInstance();			
			ablBot.setUseSynchrousSensors();
			
			new Thread() {
				public void run() {
					Thread.currentThread().setName("Behaving Entity Thread");
					ablBot.startBehaving();			
				}
			}.start();			
		
			// set up the GUI components
			if (showGUI) {
				
				mainFrame = new JFrame("EISBot");
	    		JPanel flowPanel = new JPanel();
	    		JPanel panel = new JPanel();	    		
	    		
	    		panel.setLayout(new BorderLayout());
	    		speedPanel = new SpeedPanel(game);
	    		panel.add(speedPanel, BorderLayout.NORTH);
	    			    		
	    		ABLPanel ablPanel = new ABLPanel();
	    		ABLStarCraftBot.getBehavingEntity().addBehavingListener(ablPanel);
	    		
	    		wmePanel = new WMEPanel();
	    		panel.add(wmePanel, BorderLayout.WEST);
	    		panel.add(ablPanel, BorderLayout.SOUTH);
	    		panel.setBorder(BorderFactory.createTitledBorder("ABL"));
	    		
	    		CommandLogPanel logPanel = new CommandLogPanel();
	    		commandQueue.addCommandListener(logPanel);
	    		logPanel.setBorder(BorderFactory.createTitledBorder("Commands Issued"));
	    		
	    		flowPanel.setLayout(new BorderLayout());
	    		flowPanel.add(panel, BorderLayout.WEST);
	    		flowPanel.add(logPanel, BorderLayout.CENTER);
	    	    		
	    		JTabbedPane mainPanel = new JTabbedPane();
	    		mainPanel.setPreferredSize(new Dimension(600, 500));
	    		mainFrame.add(mainPanel);
	    		
	    		mainPanel.addTab("Controls", flowPanel);	    		
	    		mainFrame.pack(); 
	    		mainFrame.setVisible(true);
	    		
	    		// logging panel
	    		LoggingPanel loggingPanel = new LoggingPanel();
	    		Logger.addListener(loggingPanel);
	    		mainPanel.addTab("Logging", loggingPanel);	    			    				
	    		
	    		abtViewer = new ABTViewer();
	    		ablBot.addBehavingListener(abtViewer);
				mainPanel.addTab("ABL Tree", abtViewer);
				
				gameFrame = new StarCraftFrame(game);
				commandQueue.addCommandListener(gameFrame);
				
				panel = new JPanel();
				panel.setLayout(new BorderLayout());
				panel.add(gameFrame, BorderLayout.CENTER);
				panel.add(gameFrame.getLayerPanel(), BorderLayout.SOUTH);		    				
	    		mainPanel.addTab("Game View", panel);	    		
	    		
	    		reconPanel = new ReconPanel();
	    		mainPanel.addTab("Recon", reconPanel);	    		

	    		profilerPanel = new BehaviorProfiler();
	    		ablBot.addBehavingListener(profilerPanel);
	    		mainPanel.addTab("Profiler", profilerPanel);	    		

	    		requestPanel = new RequestPanel();
	    		mainPanel.addTab("Requests", requestPanel);	    		
			}			
			 
			if (caseRetriever != null) {
				game.setCaseRetriever(caseRetriever);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public void gameUpdate() {
		try {
			if (delay > 0) {
				Thread.sleep(delay);
			}
		} 
		catch (Exception e) {}
				
		game.update(bwapi); 
		commandQueue.processCommands(bwapi);
 
		// say gg, etc
		if (useManners) {
			useManners();
		}
		
		// draw build locations
		if (drawBuildLocations > 0) {
			game.getMap().drawLocations(bwapi, game, drawBuildLocations, drawPylons);
		}
		
		if (drawParticles) {   
			game.getParticleFilter().draw(bwapi);
		}   
   
		bwapi.drawText(8, 16, "FPS: " + bwapi.getFPS(), true);		

//		for (PlayerUnitWME unit : game.getPlayerUnits()) { 
//			bwapi.drawText(unit.getRealX() - 16, unit.getRealY() - 16, "" + unit.getActive(), false);	 	 
//		}

		if (drawOrders) { 
			for (PlayerUnitWME unit : game.getPlayerUnits()) {  
				bwapi.drawText(unit.getRealX() - 16, unit.getRealY(), "" + Order.values()[unit.getOrder()].toString(), false);		 
			}
		}
		
		if (drawSquadIDs) { 
			for (PlayerUnitWME unit : game.getPlayerUnits()) {   
				bwapi.drawText(unit.getRealX() - 16, unit.getRealY() - 16, "" + unit.getSquadID(), false);		 
			}
		}
		 
		for (Object squad : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME("SquadWME")) {
			((SquadWME)squad).draw(bwapi);
		}
	}	 
	
	public void menuUpdate(int menuFrame) {
	} 
	  
	public void useManners() { 
		if (game.getGameFrame() == 120) {
			bwapi.sendText("This is EISBot, an experiment at UC Santa Cruz."); 
		}
		else if (game.getGameFrame() == 240) {
			bwapi.sendText("By participating in this game, you acknowledge that you are at least 18 years of age.");
		} 
  
		// check for gg  
		if (quitFrame == 0) {
			int probeCount = 0;
			int nexusHealth = 0;
			
			for (Unit unit : bwapi.getMyUnits()) {
				if (unit.getTypeID() == StarCraftConstants.Protoss_Probe) {
					probeCount++;
				}
				else if (unit.getTypeID() == StarCraftConstants.Protoss_Nexus) {
					nexusHealth = Math.max(nexusHealth, unit.getHitPoints());
				}
			}
			
			if (probeCount < 3 || nexusHealth < 200) {
				quitFrame = bwapi.getFrameCount() + 120;
				bwapi.sendText("GG");
			}
		}
		 
		// leave the match
		if (quitFrame > 0 && bwapi.getFrameCount() >= quitFrame) {
			quitFrame = 0;
			bwapi.leaveGame(); 
		}
	} 
	
	public void killStarCraft() {
		
		// rest of this is for ICCup mode
		try {	    		
    		Process kill = Runtime.getRuntime().exec(new String[] {"TASKKILL", "/IM", "StarCraft.exe"});
    		kill.waitFor();
    		System.out.println("StarCraft exit code: " + kill.exitValue());
    		Thread.sleep(5000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public void gameEnded() { 
		System.err.println("Game ended: " + game.getGameFrame());
		
		if (quitOnGameEnd) {
			System.exit(0);
		}
 		
		// stop CBR component
		if (caseRetriever != null) {
			caseRetriever.stop();
		}

		if (showGUI) {
			game.stop();
			gameFrame.stop();
			wmePanel.stop();
			reconPanel.stop();
			profilerPanel.stop();
			requestPanel.stop();
			abtViewer.stop();
			mainFrame.setVisible(false);	    		
		}

		ablBot.stopBehaving();
	}
	
	boolean shiftPressed = false;
	boolean drawTerrain = false;
	boolean drawHealth = false;
	boolean drawIDs = false;
	boolean drawTargets = false;
	boolean drawPylons = false;
	boolean drawOrders = false;
	boolean drawSquadIDs = false;
	  
	public void keyPressed(int keyCode) {

		// change speed? 
		if (keyCode == 189) {
			delay+=10;
			System.out.println("Delay: " + delay);
		}
		else if (keyCode == 187) {
			if (delay > 0) delay-=10;
			System.out.println("Delay: " + delay); 
		}
  
		if (shiftPressed && keyCode == KeyEvent.VK_H) {	 
			JOptionPane.showMessageDialog(null, "EISBot hotkeys" +
					"\n + : speed up game speed" +
					"\n - : slow down game speed" +
					"\n shift-A : draw health bars" +
					"\n shift-B : show build locations" +
					"\n shift-I : draw unit IDs" +
					"\n shift-N : draw terrain" +
					"\n shift-O : draw orders" +
					"\n shift-P : draw particles" +
					"\n shift-R : restart game" +
					"\n shift-S : enable auto camera" +
					"\n shift-T : draw targets" +
					"\n shift-Y : draw pylon locations" +
					"\n shift-Q : draw squad IDs" +
					"" );
		}
		
		// make WMEs
		if (shiftPressed) {
			ABLStarCraftBot.getBehavingEntity().getWorkingMemory().addWME(new KeyPressWME(keyCode));
		}
		
		if (shiftPressed && keyCode == KeyEvent.VK_B) {	
			drawBuildLocations++;
			if (drawBuildLocations == 4) drawBuildLocations = 0;
		}
		 
		if (shiftPressed && keyCode == KeyEvent.VK_A) {	
			drawHealth = !drawHealth;
			bwapi.drawHealth(drawHealth);
		}
		if (shiftPressed && keyCode == KeyEvent.VK_N) {	
			drawTerrain = !drawTerrain;
			bwapi.drawTerrain(drawTerrain);
		}
		if (shiftPressed && keyCode == KeyEvent.VK_I) {	
			drawIDs = !drawIDs;
			bwapi.drawIDs(drawIDs);
		}
		if (shiftPressed && keyCode == KeyEvent.VK_Q) {	
			drawSquadIDs = !drawSquadIDs;
		}
		if (shiftPressed && keyCode == KeyEvent.VK_O) {	
			drawOrders = !drawOrders;
		}
		if (shiftPressed && keyCode == KeyEvent.VK_T) {	
			drawTargets = !drawTargets;
			bwapi.drawTargets(drawTargets);
		}
		if (shiftPressed && keyCode == KeyEvent.VK_Y) {	
			drawPylons = !drawPylons;
		}
		if (shiftPressed && keyCode == KeyEvent.VK_P) {	 
			drawParticles = !drawParticles;
		}
		if (shiftPressed && keyCode == KeyEvent.VK_S) {	 
			autoCamera = !autoCamera; 
		}
		if (shiftPressed && keyCode == KeyEvent.VK_R) {	 
			bwapi.restartGame();
		} 

		shiftPressed = (keyCode == 160);
	}
	
	public void matchEnded(boolean winner) { 
		System.out.println("Match ended: " + winner);

		
//		JOptionPane.showMessageDialog(null, "Match ended: " + winner + "   :" + bwapi.getFrameCount());	
		
//		for (PlayerScore score : bwapi.playerScores()) {
//			System.out.println("Player: " + score.getID());
//			System.out.println("  " + score.getBuildingScore());
//			System.out.println("  " + score.getCompletedUnits()); 
//			System.out.println("  " + score.getCumulativeMinerals());
//			System.out.println("  " + score.getCumulativeGas());
//			System.out.println("  " + score.getCustomScore());
//			System.out.println("  " + score.getDeadUnits());
//			System.out.println("  " + score.getKilledUnits());
//			System.out.println("  " + score.getKillScore());
//			System.out.println("  " + score.getRazingScore());
//			System.out.println("  " + score.getUnitScore());
//		}  
		
		if (autoRestart) {
			bwapi.restartGame();
		} 
	} 
	
	public void unitCreate(int unitID) { 
		if (autoCamera) {
			Unit unit = bwapi.getUnit(unitID);
			if (unit != null && unit.getTypeID() != StarCraftConstants.Resource_Mineral_Field &&  unit.getTypeID() != StarCraftConstants.Resource_Vespene_Geyser) {

				if (System.currentTimeMillis() - lastCameraUpdate > 8000) {				
					lastCameraUpdate = System.currentTimeMillis();
					bwapi.setCameraLocation(unit.getX() - 320, unit.getY() - 240);
				}
			}
		}
	}
  
	public void unitDestroy(int unitID) { 
		if (autoCamera) {
			Unit unit = bwapi.getUnit(unitID);
			if (unit != null) {
				if (System.currentTimeMillis() - lastCameraUpdate > 3000) {				
					lastCameraUpdate = System.currentTimeMillis();
					bwapi.setCameraLocation(unit.getX() - 320, unit.getY() - 240);
				}
			}
		}
	} 

	public void unitDiscover(int unitID) {   
		if (autoCamera) {
			Unit unit = bwapi.getUnit(unitID);
			if (unit != null && unit.getPlayerID() != 11) { 
				if (System.currentTimeMillis() - lastCameraUpdate > 4000) {				
					lastCameraUpdate = System.currentTimeMillis(); 
					bwapi.setCameraLocation(unit.getX() - 320, unit.getY() - 240);
				}
			}
		}		 
	} 
	
//	public void unitDestroy(int unitID) { }
	public void nukeDetect(int x, int y) { } 
	public void nukeDetect() { }
	public void playerLeft(int id) { }
	public void unitEvade(int unitID) { }
	public void unitHide(int unitID) { }
	public void unitMorph(int unitID) { }
	public void unitShow(int unitID) { }	
} 
