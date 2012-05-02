package eisbot.cbr.goalforumlator;

import java.util.ArrayList;
import java.util.HashMap;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.abl.wmes.ConstructionWME;
import eisbot.abl.wmes.TrainUnitWME;
import eisbot.abl.wmes.requests.BuildingRequestWME;
import eisbot.abl.wmes.requests.UnitRequestWME;
import eisbot.cbr.goalforumlator.filter.UnitAndBothHeavyTimingFilter;
import eisbot.proxy.wmes.TechTypeWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.UpgradeTypeWME;
import eisbot.proxy.wmes.TechTypeWME.TechType;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;
import eisbot.proxy.wmes.UpgradeTypeWME.UpgradeType;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
/**
 * Class for encoding the game as a feature vector representation.
 * 
 * The main function of this class is to provide a common definition for the StarCraft feature vector representation.
 * 
 * TODO: deal with imperfect information
 * 
 * Feature vector representation:
 * 
 * -map name, nominal 
 * -game cycle
 * -player unit counts
 * -player unit timings
 * -player research timings
 * -player upgrade timings
 * -enemy unit counts
 * -enemy unit timings
 * -enemy research timings
 * -enemy upgrade timings
 * -label
 */
public class GameEncoder {

	private Instances instances;
	private Instance lastInstance;

	private ArrayList<UnitType> playerTypes;
	private ArrayList<UnitType> enemyTypes;
	private ArrayList<TechType> playerResearch;
	private ArrayList<TechType> enemyResearch;
	private ArrayList<UpgradeType> playerUpgrades;
	private ArrayList<UpgradeType> enemyUpgrades;	
	
	public HashMap<Integer,Integer> typeMap = new HashMap<Integer, Integer>();	
	public HashMap<Integer,Integer> timingMap = new HashMap<Integer, Integer>();	
	public HashMap<Integer,Integer> researchMap = new HashMap<Integer, Integer>();	
	public HashMap<Integer,Integer> upgradesMap = new HashMap<Integer, Integer>();	
	public HashMap<Integer,Integer> enemyTypeMap = new HashMap<Integer, Integer>();	
	public HashMap<Integer,Integer> enemyTimingMap = new HashMap<Integer, Integer>();	
	public HashMap<Integer,Integer> enemyResearchMap = new HashMap<Integer, Integer>();	
	public HashMap<Integer,Integer> enemyUpgradesMap = new HashMap<Integer, Integer>();	
	
	public int typeIndex;
	public int timingIndex;
	public int researchIndex;
	public int upgradeIndex;
	public int enemyTypeIndex;
	public int enemyTimingIndex;
	public int enemyResearchIndex;
	public int enemyUpgradesIndex;
	public int classIndex;
	public int numAttributes;

	public int mapIndex = 0;
	public int winIndex = 1;
	public int traceIndex = 2;
	public int cycleIndex = 3;
	
	public Instances getInstancesCopy() {
		Instances copy = new Instances(instances);
		copy.delete();
		return copy;
	}
	
	public Instance newInstance() {
		Instance instance = new Instance(numAttributes);		
		instance.setDataset(instances);		
		
		for (int i=0; i<numAttributes; i++) {
			instance.setValue(i, 0);				
		}

		return instance;
	}

	private Race playerRace;
	private Race enemyRace;
	
	public GameEncoder(Race playerRace, Race enemyRace) {		
		this.playerRace = playerRace;
		this.enemyRace = enemyRace; 
		 
		playerTypes = UnitTypeWME.getTypes(playerRace);
		playerResearch = TechTypeWME.getTypes(playerRace);
		playerUpgrades = UpgradeTypeWME.getTypes(playerRace);
		enemyTypes = UnitTypeWME.getTypes(enemyRace);
		enemyResearch = TechTypeWME.getTypes(enemyRace);
		enemyUpgrades = UpgradeTypeWME.getTypes(enemyRace);

		// build the instances features
		String relation = "StarCraftGameState";
		int capacity = 0;
		FastVector attributes = new FastVector();
		FastVector labels = new FastVector();
		
		attributes.addElement(new Attribute("Map"));
		attributes.addElement(new Attribute("Won"));
		attributes.addElement(new Attribute("TraceID"));
		attributes.addElement(new Attribute("Cycle"));		

		typeIndex = attributes.size();
		for (UnitType type : playerTypes) {
			typeMap.put(type.ordinal(), attributes.size());
			attributes.addElement(new Attribute(type.name() + "Count"));
		}

		timingIndex = attributes.size();
		for (UnitType type : playerTypes) {
			timingMap.put(type.ordinal(), attributes.size());
			attributes.addElement(new Attribute(type.name() + "Timing"));
		}
		
		researchIndex = attributes.size();
		for (TechType type : playerResearch) {
			researchMap.put(type.ordinal(), attributes.size());
			attributes.addElement(new Attribute(type.name()));
		}
		
		upgradeIndex = attributes.size();
		for (UpgradeType type : playerUpgrades) {
			upgradesMap.put(type.ordinal(), attributes.size());
			attributes.addElement(new Attribute(type.name()));
		}

		enemyTypeIndex = attributes.size();
		for (UnitType type : enemyTypes) {
			enemyTypeMap.put(type.ordinal(), attributes.size());
			attributes.addElement(new Attribute("enemy" + type.name() + "Count"));
		}
				
		enemyTimingIndex =  attributes.size();
		for (UnitType type : enemyTypes) {
			enemyTimingMap.put(type.ordinal(), attributes.size());
			attributes.addElement(new Attribute("enemy" + type.name() + "Timing"));
		}

		enemyResearchIndex =  attributes.size();
		for (TechType type : enemyResearch) {
			enemyResearchMap.put(type.ordinal(), attributes.size());
			attributes.addElement(new Attribute("enemy" + type.name()));
		}
		
		enemyUpgradesIndex = attributes.size();
		for (UpgradeType type : enemyUpgrades) {
			enemyUpgradesMap.put(type.ordinal(), attributes.size());
			attributes.addElement(new Attribute("enemy" + type.name()));
		}

		for (int i=typeIndex; i<attributes.size(); i++) {
			Attribute att = (Attribute)attributes.elementAt(i);
			labels.addElement(att.name());
		}
		
		classIndex = attributes.size();
		attributes.addElement(new Attribute("Label", labels));
		numAttributes = attributes.size();
		instances = new Instances(relation, attributes, capacity);
		instances.setClassIndex(classIndex);
	
		lastInstance = new Instance(numAttributes);		
		lastInstance.setDataset(instances);		
		for (int i=0; i<numAttributes; i++) {
			lastInstance.setValue(i, 0);				
		}
	}

	public Instance encodeGame(Game game) {
		ArrayList<PlayerUnitWME> units = game.getPlayerUnits();
//		ArrayList<EnemyUnitWME> enemyUnits = game.getEnemyUnits();
		boolean[] research = game.getPlayer().getResearched();
		int[] upgrades = game.getPlayer().getUpgrades();
//		boolean[] enemyResearch = game.getEnemy().getResearched();
//		int[] enemyUpgrades= game.getEnemy().getUpgrades();
	
		Instance instance = new Instance(lastInstance);
		instance.setDataset(instances);

		// set map and frame
		instance.setValue(mapIndex, 0); // no map yet
		instance.setValue(winIndex, 0); // no win information
		instance.setValue(traceIndex, 0); // no traceID information
		instance.setValue(cycleIndex, game.getGameFrame()); // game cycle

		// player count
		for (UnitType type : playerTypes) {
			int count = 0;
			
			for (PlayerUnitWME unit : units) {		

				// special case, make all tanks look the same
				if (type.equals(UnitType.Terran_Siege_Tank_Tank_Mode) 
						&& unit.getType().equals(UnitType.Terran_Siege_Tank_Siege_Mode)) {
					count++;
				}
				
				if (unit.getTypeID() == type.ordinal()) {
					count++;
				}
			}
			
			instance.setValue(typeMap.get(type.ordinal()), count);  
			if (count > 0 && lastInstance.value(timingMap.get(type.ordinal())) == 0 && game.getRecon().getUnitTimings().containsKey(type.ordinal())) {
				instance.setValue(timingMap.get(type.ordinal()), UnitAndBothHeavyTimingFilter.TimingFactor * game.getRecon().getUnitTimings().get(type.ordinal()));
			} 
		}

//		// player research
//		for (TechType type : playerResearch) {
//			int index = type.ordinal();
//			if (lastInstance.value(researchMap.get(index)) == 0) {
//				if (research[index] == true) {
//					instance.setValue(researchMap.get(index), game.getGameFrame());
//				}
//			}
//		}
//
//		// player upgrades
//		for (UpgradeType type : playerUpgrades) {
//			int index = type.ordinal();
//			if (lastInstance.value(upgradesMap.get(index)) == 0) {
//				if (upgrades[index] > 0) {
//					instance.setValue(upgradesMap.get(index), game.getGameFrame());
//				}
//			}
//		}

		// enemy count
		for (UnitType type : enemyTypes) {
			int count = 0;
	
			if (game.getRecon().getEnemyTypes().containsKey(type.ordinal())) {
				count++;
			}

			instance.setValue(enemyTypeMap.get(type.ordinal()), count);
			if (count > 0 && lastInstance.value(enemyTimingMap.get(type.ordinal())) == 0) { 
				instance.setValue(enemyTimingMap.get(type.ordinal()), UnitAndBothHeavyTimingFilter.TimingFactor * game.getRecon().getEnemyTypes().get(type.ordinal()));
			}
		} 

//		// enemy research
//		for (TechType type : this.enemyResearch) {
//			int index = type.ordinal();			
//			if (lastInstance.value(enemyResearchMap.get(index)) == 0) {
//				if (enemyResearch[index] == true) {
//					instance.setValue(enemyResearchMap.get(index), game.getGameFrame()); 
//				}
//			}
//		}
//
//		// enemy upgrades
//		for (UpgradeType type : this.enemyUpgrades) {
//			int index = type.ordinal();			
//			if (lastInstance.value(enemyUpgradesMap.get(index)) == 0) {
//				if (enemyUpgrades[index] > 0) {
//					instance.setValue(enemyUpgradesMap.get(index), game.getGameFrame());
//				}
//			}
//		}


		// include WME state
		
		// units queued up
		for (Object obj : ABLStarCraftBot.getBehavingEntity().lookupWME(TrainUnitWME.class.getSimpleName())) {
			int feature =  typeMap.get(((TrainUnitWME)obj).getType());			
			instance.setValue(feature, instance.value(feature) + 1);
		}

		// buildings queued up
		for (Object obj : ABLStarCraftBot.getBehavingEntity().lookupWME(ConstructionWME.class.getSimpleName())) {
			int feature =  typeMap.get(((ConstructionWME)obj).getType());			
			instance.setValue(feature, instance.value(feature) + 1);
		}
		
		// units requests
		for (Object obj : ABLStarCraftBot.getBehavingEntity().lookupWME(UnitRequestWME.class.getSimpleName())) {
			int feature =  typeMap.get(((UnitRequestWME)obj).getType());
			instance.setValue(feature, instance.value(feature) + 1);
		}

		// building requests
		for (Object obj : ABLStarCraftBot.getBehavingEntity().lookupWME(BuildingRequestWME.class.getSimpleName())) {
			int feature =  typeMap.get(((BuildingRequestWME)obj).getType());
			instance.setValue(feature, instance.value(feature) + 1);
		}
		
		lastInstance = instance;
		return instance;
	}
	
	public Race getPlayerRace() {
		return playerRace;
	}

	public Race getEnemyRace() {
		return enemyRace;
	}

	public void print(Instance instance) {
		System.out.println(instance);
		for (int i=0; i<numAttributes; i++) {
			System.out.println(" " + instance.attribute(i).name() + " " + instance.value(i));
		}
	}
}
