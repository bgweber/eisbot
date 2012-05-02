package eisbot.proxy.wmes;

import java.util.ArrayList;
import java.util.HashMap;

import wm.WME;
import eisbot.abl.StarCraftConstants.Race;
/**
 * Reference data about the upgrades in StarCraft.
 * 
 * A tech type is an upgrade that is an active upgrade, such as stim packs. 
 * While upgrade types are passive upgrades such as armor.
 */
public class UpgradeTypeWME extends WME {
	
	/** upgrade types */
	 public static int Terran_Infantry_Armor = 0;
	 public static int Terran_Vehicle_Plating = 1;
	 public static int Terran_Ship_Plating = 2;
	 public static int Zerg_Carapace = 3;
	 public static int Zerg_Flyer_Carapace = 4;
	 public static int Protoss_Armor = 5;
	 public static int Protoss_Plating = 6;
	 public static int Terran_Infantry_Weapons = 7;
	 public static int Terran_Vehicle_Weapons = 8;
	 public static int Terran_Ship_Weapons = 9;
	 public static int Zerg_Melee_Attacks = 10;
	 public static int Zerg_Missile_Attacks = 11;
	 public static int Zerg_Flyer_Attacks = 12;
	 public static int Protoss_Ground_Weapons = 13;
	 public static int Protoss_Air_Weapons = 14;
	 public static int Protoss_Plasma_Shields = 15;
	 public static int U_238_Shells = 16;
	 public static int Ion_Thrusters = 17;
	 public static int Titan_Reactor = 19;
	 public static int Ocular_Implants = 20;
	 public static int Moebius_Reactor = 21;
	 public static int Apollo_Reactor = 22;
	 public static int Colossus_Reactor = 23;
	 public static int Ventral_Sacs = 24;
	 public static int Antennae = 25;
	 public static int Pneumatized_Carapace = 26;
	 public static int Metabolic_Boost = 27;
	 public static int Adrenal_Glands = 28;
	 public static int Muscular_Augments = 29;
	 public static int Grooved_Spines = 30;
	 public static int Gamete_Meiosis = 31;
	 public static int Metasynaptic_Node = 32;
	 public static int Singularity_Charge = 33;
	 public static int Leg_Enhancements = 34;
	 public static int Scarab_Damage = 35;
	 public static int Reaver_Capacity = 36;
	 public static int Gravitic_Drive = 37;
	 public static int Sensor_Array = 38;
	 public static int Gravitic_Boosters = 39;
	 public static int Khaydarin_Amulet = 40;
	 public static int Apial_Sensors = 41;
	 public static int Gravitic_Thrusters = 42;
	 public static int Carrier_Capacity = 43;
	 public static int Khaydarin_Core = 44;
	 public static int Argus_Jewel = 47;
	 public static int Argus_Talisman = 49;
	 public static int Caduceus_Reactor = 51;
	 public static int Chitinous_Plating = 52;
	 public static int Anabolic_Synthesis = 53;
	 public static int Charon_Booster = 54;
	 public static int None = 61;
	 public static int Unknown = 62;
	 
	/** upgrade type identifier */
	private int id;

	/** name of the upgrade */
	private String name;
	
	/** id of the unit type that researches the upgrade */
	private int whatResearchesID;

	/** number of times the upgrade can be researched. usually 1, 3 for weapon upgrades */
	private int repeats;
	
	/** mineral cost of the upgrade */
	private int mineralsBase;
	
	/** increase in mineral cost per upgrade level */
	private int mineralsFactor;

	/** gas cost of the upgrade */
	private int gasBase;
	
	/** increase in gas cost per upgrade level */
	private int gasFactor;
	
	private static HashMap<Integer, UpgradeTypeWME> upgradeTypeMap;

	public UpgradeTypeWME(int id, String name, int whatResearchesID, int repeats, int mineralsBase, int mineralsFactor, int gasBase, int gasFactor) {
		this.id = id;
		this.name = name;
		this.whatResearchesID = whatResearchesID;
		this.repeats = repeats;
		this.mineralsBase = mineralsBase;
		this.mineralsFactor = mineralsFactor;
		this.gasBase = gasBase;
		this.gasFactor = gasFactor;
	}
	
	/**
	 * Gets a upgrade type by ID.
	 */
	public static UpgradeTypeWME getType(int typeID) {
		if (upgradeTypeMap == null) {
			upgradeTypeMap = new HashMap<Integer, UpgradeTypeWME>();
			
			for (UpgradeTypeWME upgrade : getUpgradeTypes()) {
				upgradeTypeMap.put(upgrade.getId(), upgrade);
			}
		}
		
		return upgradeTypeMap.get(typeID);
	}

		
	public static ArrayList<UpgradeType> getTypes(Race race) {
		ArrayList<UpgradeType> types = new ArrayList<UpgradeType>();
		
		switch (race) {
		case Protoss:
			types.add(UpgradeType.Protoss_Armor);
			types.add(UpgradeType.Protoss_Plating);
			types.add(UpgradeType.Protoss_Ground_Weapons);
			types.add(UpgradeType.Protoss_Air_Weapons);
			types.add(UpgradeType.Protoss_Plasma_Shields);			
			types.add(UpgradeType.Singularity_Charge);
			types.add(UpgradeType.Leg_Enhancements);
			types.add(UpgradeType.Scarab_Damage);
			types.add(UpgradeType.Reaver_Capacity);
			types.add(UpgradeType.Carrier_Capacity);
			types.add(UpgradeType.Gravitic_Drive);	// shuttle speed
			types.add(UpgradeType.Sensor_Array);	// obs range			
			types.add(UpgradeType.Gravitic_Boosters); // obs speed			
			types.add(UpgradeType.Khaydarin_Amulet); // templar energy
			types.add(UpgradeType.Apial_Sensors); // scout range
			types.add(UpgradeType.Gravitic_Thrusters); // scout speed
			types.add(UpgradeType.Khaydarin_Core); // arbitor energy
			types.add(UpgradeType.Argus_Jewel); // corsair energy
			types.add(UpgradeType.Argus_Talisman); // dark archon energy
			break;
		case Terran:
			types.add(UpgradeType.Terran_Infantry_Armor);
			types.add(UpgradeType.Terran_Vehicle_Plating);
			types.add(UpgradeType.Terran_Ship_Plating);			
			types.add(UpgradeType.Terran_Infantry_Weapons);
			types.add(UpgradeType.Terran_Vehicle_Weapons);
			types.add(UpgradeType.Terran_Ship_Weapons);			
			types.add(UpgradeType.U_238_Shells);			
			types.add(UpgradeType.Ion_Thrusters); // vulture speed
			types.add(UpgradeType.Titan_Reactor); // vessel energy
			types.add(UpgradeType.Ocular_Implants); // ghost range
			types.add(UpgradeType.Moebius_Reactor); // ghost energy
			types.add(UpgradeType.Apollo_Reactor); // wraith energy
			types.add(UpgradeType.Colossus_Reactor); // bc energy
			types.add(UpgradeType.Caduceus_Reactor);	// medic energy
			types.add(UpgradeType.Charon_Booster);
			break;
		case Zerg:
			types.add(UpgradeType.Zerg_Carapace);
			types.add(UpgradeType.Zerg_Flyer_Carapace);
			types.add(UpgradeType.Zerg_Melee_Attacks);
			types.add(UpgradeType.Zerg_Missile_Attacks);
			types.add(UpgradeType.Zerg_Flyer_Attacks);
			types.add(UpgradeType.Chitinous_Plating);
			types.add(UpgradeType.Anabolic_Synthesis);			
			types.add(UpgradeType.Ventral_Sacs);
			types.add(UpgradeType.Antennae);
			types.add(UpgradeType.Pneumatized_Carapace);
			types.add(UpgradeType.Metabolic_Boost);
			types.add(UpgradeType.Adrenal_Glands);
			types.add(UpgradeType.Muscular_Augments);
			types.add(UpgradeType.Grooved_Spines);
			types.add(UpgradeType.Gamete_Meiosis);
			types.add(UpgradeType.Metasynaptic_Node);
			break;
		}
		
		return types;
	}
	
	/**
	 * Returns an ID for the upgrade type.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the name of the upgrade.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the type id of what researches this upgrade. 
	 */
	public int getWhatResearchesID() {
		return whatResearchesID;
	}
	
	/**
	 * Number of times the upgrade can be researched, usually 1, 3 or attack and armor upgrades.
	 */
	public int getRepeats() {
		return repeats;
	}

	/**
	 * Level 1 minerals cost of the upgrade.
	 */
	public int getMineralsBase() {
		return mineralsBase;
	}

	/**
	 * Level 1 gas cost of the upgrade.
	 */
	public int getMineralsFactor() {
		return mineralsFactor;
	}

	/**
	 * Addition minerals cost of the upgrade per level.
	 */
	public int getGasBase() {
		return gasBase;
	}

	/**
	 * Addition gas cost of the upgrade per level.
	 */
	public int getGasFactor() {
		return gasFactor;
	}

	public String toString() {
		return 
			"id:" + id + 
			" name:" + name + 
			" whatResearches:" + whatResearchesID + 
			" repeats:" + repeats + 
			" minsBase:" + mineralsBase + 
			" minsFactor:" + mineralsFactor + 
			" gasBase:" + gasBase + 
			" gasFactor:" + gasFactor;
	}

	/**
	 * Enumeration of the upgrade types.
	 */
	public enum UpgradeType {
		Terran_Infantry_Armor,
		Terran_Vehicle_Plating,
		Terran_Ship_Plating,
		Zerg_Carapace,
		Zerg_Flyer_Carapace,
		Protoss_Armor,
		Protoss_Plating,
		Terran_Infantry_Weapons,
		Terran_Vehicle_Weapons,
		Terran_Ship_Weapons,
		Zerg_Melee_Attacks,
		Zerg_Missile_Attacks,
		Zerg_Flyer_Attacks,
		Protoss_Ground_Weapons,
		Protoss_Air_Weapons,
		Protoss_Plasma_Shields,
		U_238_Shells,
		Ion_Thrusters,
		undefined0,
		Titan_Reactor,
		Ocular_Implants,
		Moebius_Reactor,
		Apollo_Reactor,
		Colossus_Reactor,
		Ventral_Sacs,
		Antennae,
		Pneumatized_Carapace,
		Metabolic_Boost,
		Adrenal_Glands,
		Muscular_Augments,
		Grooved_Spines,
		Gamete_Meiosis,
		Metasynaptic_Node,
		Singularity_Charge,
		Leg_Enhancements,
		Scarab_Damage,
		Reaver_Capacity,
		Gravitic_Drive,
		Sensor_Array,
		Gravitic_Boosters,
		Khaydarin_Amulet,
		Apial_Sensors,
		Gravitic_Thrusters,
		Carrier_Capacity,
		Khaydarin_Core,
		undefined1,
		undefined2,
		Argus_Jewel,
		undefined3,
		Argus_Talisman,
		undefined4,
		Caduceus_Reactor,
		Chitinous_Plating,
		Anabolic_Synthesis,
		Charon_Booster,
		undefined5,
		undefined6,
		undefined7,
		undefined8,
		undefined9,
		undefined10,
		None,
		Unknown
	};

	/**
	 * Returns a list of the upgrade types.
	 */
	public static ArrayList<UpgradeTypeWME> getUpgradeTypes() {
		ArrayList<UpgradeTypeWME> types = new ArrayList<UpgradeTypeWME>();
		types.add(new UpgradeTypeWME(0,"Terran_Infantry_Armor",122,3,100,75,75,75));
		types.add(new UpgradeTypeWME(1,"Terran_Vehicle_Plating",123,3,100,75,75,75));
		types.add(new UpgradeTypeWME(2,"Terran_Ship_Plating",123,3,150,75,75,75));
		types.add(new UpgradeTypeWME(3,"Zerg_Carapace",139,3,150,75,75,75));
		types.add(new UpgradeTypeWME(4,"Zerg_Flyer_Carapace",141,3,150,75,75,75));
		types.add(new UpgradeTypeWME(5,"Protoss_Armor",166,3,100,75,75,75));
		types.add(new UpgradeTypeWME(6,"Protoss_Plating",164,3,150,75,75,75));
		types.add(new UpgradeTypeWME(7,"Terran_Infantry_Weapons",122,3,100,75,75,75));
		types.add(new UpgradeTypeWME(8,"Terran_Vehicle_Weapons",123,3,100,75,75,75));
		types.add(new UpgradeTypeWME(9,"Terran_Ship_Weapons",123,3,100,50,50,50));
		types.add(new UpgradeTypeWME(10,"Zerg_Melee_Attacks",139,3,100,50,50,50));
		types.add(new UpgradeTypeWME(11,"Zerg_Missile_Attacks",139,3,100,50,50,50));
		types.add(new UpgradeTypeWME(12,"Zerg_Flyer_Attacks",141,3,100,75,75,75));
		types.add(new UpgradeTypeWME(13,"Protoss_Ground_Weapons",166,3,100,50,50,50));
		types.add(new UpgradeTypeWME(14,"Protoss_Air_Weapons",164,3,100,75,75,75));
		types.add(new UpgradeTypeWME(15,"Protoss_Plasma_Shields",166,3,200,100,100,100));
		types.add(new UpgradeTypeWME(16,"U_238_Shells",112,1,150,0,0,0));
		types.add(new UpgradeTypeWME(17,"Ion_Thrusters",120,1,100,0,0,0));
		types.add(new UpgradeTypeWME(19,"Titan_Reactor",116,1,150,0,0,0));
		types.add(new UpgradeTypeWME(20,"Ocular_Implants",117,1,100,0,0,0));
		types.add(new UpgradeTypeWME(21,"Moebius_Reactor",117,1,150,0,0,0));
		types.add(new UpgradeTypeWME(22,"Apollo_Reactor",115,1,200,0,0,0));
		types.add(new UpgradeTypeWME(23,"Colossus_Reactor",118,1,150,0,0,0));
		types.add(new UpgradeTypeWME(24,"Ventral_Sacs",132,1,200,0,0,0));
		types.add(new UpgradeTypeWME(25,"Antennae",132,1,150,0,0,0));
		types.add(new UpgradeTypeWME(26,"Pneumatized_Carapace",132,1,150,0,0,0));
		types.add(new UpgradeTypeWME(27,"Metabolic_Boost",142,1,100,0,0,0));
		types.add(new UpgradeTypeWME(28,"Adrenal_Glands",142,1,200,0,0,0));
		types.add(new UpgradeTypeWME(29,"Muscular_Augments",135,1,150,0,0,0));
		types.add(new UpgradeTypeWME(30,"Grooved_Spines",135,1,150,0,0,0));
		types.add(new UpgradeTypeWME(31,"Gamete_Meiosis",138,1,150,0,0,0));
		types.add(new UpgradeTypeWME(32,"Metasynaptic_Node",136,1,150,0,0,0));
		types.add(new UpgradeTypeWME(33,"Singularity_Charge",164,1,150,0,150,0));
		types.add(new UpgradeTypeWME(34,"Leg_Enhancements",163,1,150,0,0,0));
		types.add(new UpgradeTypeWME(35,"Scarab_Damage",171,1,200,0,0,0));
		types.add(new UpgradeTypeWME(36,"Reaver_Capacity",171,1,200,0,0,0));
		types.add(new UpgradeTypeWME(37,"Gravitic_Drive",171,1,200,0,0,0));
		types.add(new UpgradeTypeWME(38,"Sensor_Array",159,1,150,0,0,0));
		types.add(new UpgradeTypeWME(39,"Gravitic_Boosters",159,1,150,0,0,0));
		types.add(new UpgradeTypeWME(40,"Khaydarin_Amulet",165,1,150,0,0,0));
		types.add(new UpgradeTypeWME(41,"Apial_Sensors",165,1,100,0,0,0));
		types.add(new UpgradeTypeWME(42,"Gravitic_Thrusters",169,1,200,0,0,0));
		types.add(new UpgradeTypeWME(43,"Carrier_Capacity",169,1,100,0,0,0));
		types.add(new UpgradeTypeWME(44,"Khaydarin_Core",170,1,150,0,0,0));
		types.add(new UpgradeTypeWME(47,"Argus_Jewel",169,1,100,0,0,0));
		types.add(new UpgradeTypeWME(49,"Argus_Talisman",165,1,150,0,0,0));
		types.add(new UpgradeTypeWME(51,"Caduceus_Reactor",112,1,150,0,0,0));
		types.add(new UpgradeTypeWME(52,"Chitinous_Plating",140,1,150,0,0,0));
		types.add(new UpgradeTypeWME(53,"Anabolic_Synthesis",140,1,200,0,0,0));
		types.add(new UpgradeTypeWME(54,"Charon_Booster",120,1,100,0,0,0));
		types.add(new UpgradeTypeWME(61,"None",228,0,0,0,0,0));
		types.add(new UpgradeTypeWME(62,"Unknown",228,0,0,0,0,0));		
		return types;
	}
}
