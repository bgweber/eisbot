package eisbot.proxy.wmes;

import java.util.ArrayList;
import java.util.HashMap;

import wm.WME;
import eisbot.abl.StarCraftConstants;
import eisbot.abl.StarCraftConstants.Race;
/**
 * Represents a unit type in StarCraft.
 * 
 * Includes static utility methods to generic types for each race, such as workers
 *       
 * Note: Minerals and Gas and considered unit types.
 */
public class UnitTypeWME extends WME {
	
	/**
	 * Returns the worker type for the given race.
	 */
	public static int getWorkerType(int race) {
		switch (Race.values()[race]) {
			case Zerg:
				return Zerg_Drone;
			case Terran:
				return Terran_SCV;
			case Protoss:
				return Protoss_Probe;
		}
		
		return -1;
	}
	
	/**
	 * Returns the supply type (farm) for the given race.
	 */
	public static int getSupplyType(int race) {
		switch (Race.values()[race]) {
			case Zerg:
				return Zerg_Overlord;
			case Terran:
				return Terran_Supply_Depot;
			case Protoss:
				return Protoss_Pylon;
		}
		
		return -1;
	}
	
	/**
	 * Returns the main hall for the given race.
	 */
	public static int getCenterType(int race) {
		switch (Race.values()[race]) {
			case Zerg:
				return Zerg_Hatchery;
			case Terran:
				return Terran_Command_Center;
			case Protoss:
				return Protoss_Nexus;
		}
	
		return -1;		
	}

	/** A class for building sizes */
	public static class BuildingSize {
		public int width;
		public int height;
		public BuildingSize(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public static BuildingSize None = new BuildingSize(-1, -1);
		public static BuildingSize Mineral = new BuildingSize(2, 1);
		public static BuildingSize Tiny = new BuildingSize(2, 2);
		public static BuildingSize Small = new BuildingSize(3, 2);
		public static BuildingSize Geyser = new BuildingSize(4, 2);
		public static BuildingSize Large = new BuildingSize(4, 3);

		public static BuildingSize[] all = { None, Mineral, Tiny, Small, Geyser, Large };
	}

	/** Building classes */
	public enum BuildingClass {
		None, Production, Research, Supply, Turret, Addon, Center, Extractor, Bunker, Battery, Nydus, Special
	};

	/** constants */
	public static int Terran_Marine = 0;
	public static int Terran_Ghost = 1;
	public static int Terran_Vulture = 2;
	public static int Terran_Goliath = 3;
	public static int Terran_Siege_Tank_Tank_Mode = 5;
	public static int Terran_SCV = 7;
	public static int Terran_Wraith = 8;
	public static int Terran_Science_Vessel = 9;
	public static int Terran_Dropship = 11;
	public static int Terran_Battlecruiser = 12;
	public static int Terran_Vulture_Spider_Mine = 13;
	public static int Terran_Nuclear_Missile = 14;
	public static int Terran_Siege_Tank_Siege_Mode = 30;
	public static int Terran_Firebat = 32;
	public static int Spell_Scanner_Sweep = 33;
	public static int Terran_Medic = 34;
	public static int Zerg_Larva = 35;
	public static int Zerg_Egg = 36;
	public static int Zerg_Zergling = 37;
	public static int Zerg_Hydralisk = 38;
	public static int Zerg_Ultralisk = 39;
	public static int Zerg_Broodling = 40;
	public static int Zerg_Drone = 41;
	public static int Zerg_Overlord = 42;
	public static int Zerg_Mutalisk = 43;
	public static int Zerg_Guardian = 44;
	public static int Zerg_Queen = 45;
	public static int Zerg_Defiler = 46;
	public static int Zerg_Scourge = 47;
	public static int Zerg_Infested_Terran = 50;
	public static int Terran_Valkyrie = 58;
	public static int Zerg_Cocoon = 59;
	public static int Protoss_Corsair = 60;
	public static int Protoss_Dark_Templar = 61;
	public static int Zerg_Devourer = 62;
	public static int Protoss_Dark_Archon = 63;
	public static int Protoss_Probe = 64;
	public static int Protoss_Zealot = 65;
	public static int Protoss_Dragoon = 66;
	public static int Protoss_High_Templar = 67;
	public static int Protoss_Archon = 68;
	public static int Protoss_Shuttle = 69;
	public static int Protoss_Scout = 70;
	public static int Protoss_Arbiter = 71;
	public static int Protoss_Carrier = 72;
	public static int Protoss_Interceptor = 73;
	public static int Protoss_Reaver = 83;
	public static int Protoss_Observer = 84;
	public static int Protoss_Scarab = 85;
	public static int Critter_Rhynadon = 89;
	public static int Critter_Bengalaas = 90;
	public static int Critter_Scantid = 93;
	public static int Critter_Kakaru = 94;
	public static int Critter_Ragnasaur = 95;
	public static int Critter_Ursadon = 96;
	public static int Zerg_Lurker_Egg = 97;
	public static int Zerg_Lurker = 103;
	public static int Spell_Disruption_Web = 105;
	public static int Terran_Command_Center = 106;
	public static int Terran_Comsat_Station = 107;
	public static int Terran_Nuclear_Silo = 108;
	public static int Terran_Supply_Depot = 109;
	public static int Terran_Refinery = 110;
	public static int Terran_Barracks = 111;
	public static int Terran_Academy = 112;
	public static int Terran_Factory = 113;
	public static int Terran_Starport = 114;
	public static int Terran_Control_Tower = 115;
	public static int Terran_Science_Facility = 116;
	public static int Terran_Covert_Ops = 117;
	public static int Terran_Physics_Lab = 118;
	public static int Terran_Machine_Shop = 120;
	public static int Terran_Engineering_Bay = 122;
	public static int Terran_Armory = 123;
	public static int Terran_Missile_Turret = 124;
	public static int Terran_Bunker = 125;
	public static int Special_Crashed_Norad_II = 126;
	public static int Special_Ion_Cannon = 127;
	public static int Zerg_Infested_Command_Center = 130;
	public static int Zerg_Hatchery = 131;
	public static int Zerg_Lair = 132;
	public static int Zerg_Hive = 133;
	public static int Zerg_Nydus_Canal = 134;
	public static int Zerg_Hydralisk_Den = 135;
	public static int Zerg_Defiler_Mound = 136;
	public static int Zerg_Greater_Spire = 137;
	public static int Zerg_Queen_s_Nest = 138;
	public static int Zerg_Evolution_Chamber = 139;
	public static int Zerg_Ultralisk_Cavern = 140;
	public static int Zerg_Spire = 141;
	public static int Zerg_Spawning_Pool = 142;
	public static int Zerg_Creep_Colony = 143;
	public static int Zerg_Spore_Colony = 144;
	public static int Zerg_Sunken_Colony = 146;
	public static int Special_Overmind_With_Shell = 147;
	public static int Special_Overmind = 148;
	public static int Zerg_Extractor = 149;
	public static int Special_Mature_Chrysalis = 150;
	public static int Special_Cerebrate = 151;
	public static int Special_Cerebrate_Daggoth = 152;
	public static int Protoss_Nexus = 154;
	public static int Protoss_Robotics_Facility = 155;
	public static int Protoss_Pylon = 156;
	public static int Protoss_Assimilator = 157;
	public static int Protoss_Observatory = 159;
	public static int Protoss_Gateway = 160;
	public static int Protoss_Photon_Cannon = 162;
	public static int Protoss_Citadel_of_Adun = 163;
	public static int Protoss_Cybernetics_Core = 164;
	public static int Protoss_Templar_Archives = 165;
	public static int Protoss_Forge = 166;
	public static int Protoss_Stargate = 167;
	public static int Special_Stasis_Cell_Prison = 168;
	public static int Protoss_Fleet_Beacon = 169;
	public static int Protoss_Arbiter_Tribunal = 170;
	public static int Protoss_Robotics_Support_Bay = 171;
	public static int Protoss_Shield_Battery = 172;
	public static int Special_Khaydarin_Crystal_Form = 173;
	public static int Special_Protoss_Temple = 174;
	public static int Special_XelNaga_Temple = 175;
	public static int Resource_Mineral_Field = 176;
	public static int Resource_Vespene_Geyser = 188;
	public static int Special_Warp_Gate = 189;
	public static int Special_Psi_Disrupter = 190;
	public static int Special_Power_Generator = 200;
	public static int Special_Overmind_Cocoon = 201;
	public static int Spell_Dark_Swarm = 202;
	public static int None = 228;
	public static int Unknown = 229;
	 
	/** unit type identifier */
	private int id;
	
	/** the race of the unit type */
	private int race;
	
	/** the name of the type */
	private String name;
	
	/** mineral cost to produce */
	private int mineralsCost;
	
	/** gas cost to produce */
	private int gasCost;
	
	/** max hit points */
	private int maxHitPoints;
	
	/** max shields */
	private int maxShields;
	
	/** max energy, this should not be static */
	private int maxEnergy;
	
	/** time to produce the unit, specified in game frames */
	private int buildTime;
	
	/** does the type have an attack */
	private boolean canAttack;
	
	/** is the type mobile */
	private boolean canMove;

	/** width of the type in map tiles, note that units use a different size system than buildings */
	private int tileWidth;
	
	/** height of the type in map tiles, note that units use a different size system than buildings */
	private int tileHeight;

	/** building size: can be computed from width and height; only buildings have a useful value */
	private BuildingSize buildingSize;

	/** building class: sorts buildlings by function */
	private BuildingClass buildingClass;

	/** supply require to produce, double the value you'd expect */
	private int supplyRequired;
	
	/** supply provided by the type, double the value you'd expect */
	private int supplyProvided;

	/** vision range of the type */
	private int sightRange;
	
	/** minimum ground attack range, i think this pertains only to sieged up tanks */
	private int groundMinRange;
	
	/** maximum ground attack range */
	private int groundMaxRange;
	
	/** base damage dealt to ground units */
	private int groundDamage;

	/** maximum air attack range */
	private int airRange;
	
	/** base damage dealt to air units */
	private int airDamage;

	/** is this type a building */
	private boolean building;
	
	/** is this a flying type */
	private boolean flyer;
	
	/** is this type a spell caster */
	private boolean spellCaster;
	
	/** is this type a worker unit */
	private boolean worker;
	
	/** id of the unit type that produces this */
	private int whatBuilds;

	/** id of a required unit type */
	private int firstUnitReq = StarCraftConstants.NULL_UNIT;;

	/** id of an additional required unit type */
	private int secondUnitReq = StarCraftConstants.NULL_UNIT;;

	public UnitTypeWME(int id, Race race, String name, int mineralsCost, int gasCost, int maxHitPoints, 
			int maxShields, int maxEnergy, int buildTime, boolean canAttack, boolean canMove,
			int tileWidth, int tileHeight, BuildingClass cls, int supplyRequired, int supplyProvided,
			int sightRange, int groundMinRange, int groundMaxRange, int groundDamage,
			int airRange, int airDamage, boolean building, boolean flyer,
			boolean spellCaster, boolean worker, int whatBuilds, int firstUnitReq, int secondUnitReq) {

		this.id = id;
		this.race = race.ordinal();
		this.name = name;
		this.mineralsCost = mineralsCost;
		this.gasCost = gasCost;
		this.maxHitPoints = maxHitPoints;
		this.maxShields = maxShields;
		this.maxEnergy = maxEnergy;
		this.buildTime = buildTime;
		this.canAttack = canAttack;
		this.canMove = canMove;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.buildingClass = cls;
		this.supplyRequired = supplyRequired;
		this.supplyProvided = supplyProvided;
		this.sightRange = sightRange;
		this.groundMinRange = groundMinRange;
		this.groundMaxRange = groundMaxRange;
		this.groundDamage = groundDamage;
		this.airRange = airRange;
		this.airDamage = airDamage;
		this.building = building;
		this.flyer = flyer;
		this.spellCaster = spellCaster;
		this.worker = worker;
		this.whatBuilds = whatBuilds;		
		this.firstUnitReq = firstUnitReq;
		this.secondUnitReq = secondUnitReq;

		// Compute building size:
		if (this.building) {
			for (BuildingSize b : BuildingSize.all) {
				if (this.tileWidth == b.width && this.tileHeight == b.height) {
					this.buildingSize = b;
				}
			}
		}
	}
	 
	public boolean isDefensiveStructure() {
		return id == StarCraftConstants.Protoss_Photon_Cannon 
			|| id == StarCraftConstants.Terran_Bunker
			|| id == StarCraftConstants.Zerg_Sunken_Colony;
	}

	public static ArrayList<UnitType> getTypes(Race race) {
		ArrayList<UnitType> types = new ArrayList<UnitType>();
		
		for (UnitType type : UnitType.values()) {
			if (race.equals(Race.Protoss)) {
				if (type.name().startsWith("Protoss")) {
					types.add(type);
				}
			}						
			else if (race.equals(Race.Terran)) {
				if (type.name().startsWith("Terran")) {
					types.add(type);
				}
			}						
			else if (race.equals(Race.Zerg)) {
				if (type.name().startsWith("Zerg")) {
					types.add(type);
				}
			}						
		}
		
		return types;
	}

	/**
	 * Is this an add on type.
	 */
	public boolean isAddOn() {
		return id == UnitType.Terran_Comsat_Station.ordinal() ||
  	           id == UnitType.Terran_Nuclear_Silo.ordinal() ||
			   id == UnitType.Terran_Machine_Shop.ordinal() ||
  	           id == UnitType.Terran_Control_Tower.ordinal() ||
  	           id == UnitType.Terran_Physics_Lab.ordinal() ||
  	           id == UnitType.Terran_Covert_Ops.ordinal();
	}

	/**
	 * Whether this building type can build an add-on.
	 */
	public boolean canAddOn() {
		return id == UnitType.Terran_Factory.ordinal() ||
			   id == UnitType.Terran_Command_Center.ordinal() ||
			   id == UnitType.Terran_Starport.ordinal() ||
			   id == UnitType.Terran_Science_Facility.ordinal();
	}

	public int getFirstUnitReq() {
		return firstUnitReq;
	}

	public int getSecondUnitReq() {
		return secondUnitReq;
	}

	/**
	 * Returns the ID of the type.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Race the type belongs too.
	 */
	public int getRace() {
		return race;
	}

	/**
	 * The type name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Minerals cost to produce the type.
	 */
	public int getMineralsCost() {
		return mineralsCost;
	}
	
	/**
	 * Gas cost to produce the type.
	 */
	public int getGasCost() {
		return gasCost;
	}

	/**
	 * Max health of the type.
	 */
	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	/**
	 * Max shields of the type.
	 */
	public int getMaxShields() {
		return maxShields;
	}
	
	/**
	 * Max energy of the type.
	 */
	public int getMaxEnergy() {
		return maxEnergy;
	}
	
	/**
	 * Build time of the type. (in cycles?)
	 */
	public int getBuildTime() {
		return buildTime;
	}

	/**
	 * Is this an offensive unit?
	 */
	public boolean isCanAttack() {
		return canAttack;
	}

	/**
	 * Is this a mobile unit?
	 */
	public boolean isCanMove() {
		return canMove;
	}

	/**
	 * Width of the type (in tiles)
	 */
	public int getTileWidth() {
		return tileWidth;
	}
	
	/**
	 * Height of the type (in tiles)
	 */
	public int getTileHeight() {
		return tileHeight;
	}

	public BuildingSize getBuildingSize() {
		return this.buildingSize;
	}

	public BuildingClass getBuildingClass() {
		return this.buildingClass;
	}

	/**
	 * Supply used by the type (twice the value you would expect)
	 */
	public int getSupplyRequired() {
		return supplyRequired;
	}
	
	/**
	 * Supply provided by the type (twice the value you would expect)
	 */
	public int getSupplyProvided() {
		return supplyProvided;
	}
	
	/**
	 * Sight range of the type
	 */
	public int getSightRange() {
		return sightRange;
	}

	/**
	 * Minimum ground range, I think only used for sieged tanks
	 */
	public int getGroundMinRange() {
		return groundMinRange;
	}
	
	/**
	 * Max ground range
	 */
	public int getGroundMaxRange() {
		return groundMaxRange;
	}
	
	/**
	 * Ground damage
	 */
	public int getGroundDamage() {
		return groundDamage;
	}
	
	/**
	 * Air range
	 */
	public int getAirRange() {
		return airRange;
	}
	
	/**
	 * Air damage 
	 */
	public int getAirDamage() {
		return airDamage;
	}
	
	/**
	 * Is this a building type?
	 */
	public boolean isBuilding() {
		return building;
	}
	
	public boolean getIsBuilding() {
		return building;
	}
	
	/**
	 * Is this a mineral patch or vespene geyser?
	 */
	public boolean getIsResource() {
		return (id == Resource_Mineral_Field || id == Resource_Vespene_Geyser);
	}
	
	/**
	 * Is this a flying type?
	 */
	public boolean isFlyer() {
		return flyer;
	}
	
	/**
	 * Is this a spellcaster type?
	 */
	public boolean isSpellCaster() {
		return spellCaster;
	}
	
	/**
	 * Is this a worker type?
	 */
	public boolean isWorker() {
		return worker;
	}

	public boolean isFarm() {
		return id == getSupplyType(race);
	}

	/**
	 * Is this a center type?
	 */
	public boolean isCenter() {
		if (race == Race.Zerg.ordinal()) {
			return (id == Zerg_Hatchery || id == Zerg_Lair || id == Zerg_Hive);
		}
		return id == getCenterType(race);
	}

	/**
	 * ID of the type that builds this type.
	 */
	public int getWhatBuilds() {
		return whatBuilds;
	}

	public String toString() {
		return 
			"id:" + id +
			" race:" + race +
			" name:" + name +
			" minCost:" + mineralsCost +
			" gasCost:" + gasCost +
			" hitPoints:" + maxHitPoints +
			" shields:" + maxShields +
			" energy:" + maxEnergy +
			" buildTime:" + buildTime +
			" canMove:" + canMove +
			" canAttack:" + canAttack +
			" width:" + tileWidth +
			" height:" + tileHeight +
			" supplyRequired:" + supplyRequired +
			" supplyProvided:" + supplyProvided +
			" sight:" + sightRange  +
			" groundMaxRange:" + groundMaxRange +
			" groundMinRange:" + groundMinRange +
			" groundDamage:" + groundDamage +
			" airRange:" + airRange +
			" airDamage:" + airDamage +
			" building:" + building +
			" flyer:" + flyer +
			" spellcaster:" + spellCaster +
			" worker:" + worker + 	
			" whatBuilds:" + whatBuilds;			
	}
	
	/** 
	 * enumeration 
	 */
	public enum UnitType {
		Terran_Marine,
		Terran_Ghost,
		Terran_Vulture,
		Terran_Goliath,
		undefined0,
		Terran_Siege_Tank_Tank_Mode,
		undefined1,
		Terran_SCV,
		Terran_Wraith,
		Terran_Science_Vessel,
		undefined2,
		Terran_Dropship,
		Terran_Battlecruiser,
		Terran_Vulture_Spider_Mine,
		Terran_Nuclear_Missile,
		undefined3,
		undefined4,
		undefined5,
		undefined6,
		undefined7,
		undefined8,
		undefined9,
		undefined10,
		undefined11,
		undefined12,
		undefined13,
		undefined14,
		undefined15,
		undefined16,
		undefined17,
		Terran_Siege_Tank_Siege_Mode,
		undefined18,
		Terran_Firebat,
		Spell_Scanner_Sweep,
		Terran_Medic,
		Zerg_Larva,
		Zerg_Egg,
		Zerg_Zergling,
		Zerg_Hydralisk,
		Zerg_Ultralisk,
		Zerg_Broodling,
		Zerg_Drone,
		Zerg_Overlord,
		Zerg_Mutalisk,
		Zerg_Guardian,
		Zerg_Queen,
		Zerg_Defiler,
		Zerg_Scourge,
		undefined19,
		undefined20,
		Zerg_Infested_Terran,
		undefined21,
		undefined22,
		undefined23,
		undefined24,
		undefined25,
		undefined26,
		undefined27,
		Terran_Valkyrie,
		Zerg_Cocoon,
		Protoss_Corsair,
		Protoss_Dark_Templar,
		Zerg_Devourer,
		Protoss_Dark_Archon,
		Protoss_Probe,
		Protoss_Zealot,
		Protoss_Dragoon,
		Protoss_High_Templar,
		Protoss_Archon,
		Protoss_Shuttle,
		Protoss_Scout,
		Protoss_Arbiter,
		Protoss_Carrier,
		Protoss_Interceptor,
		undefined28,
		undefined29,
		undefined30,
		undefined31,
		undefined32,
		undefined33,
		undefined34,
		undefined35,
		undefined36,
		Protoss_Reaver,
		Protoss_Observer,
		Protoss_Scarab,
		undefined37,
		undefined38,
		undefined39,
		Critter_Rhynadon,
		Critter_Bengalaas,
		undefined40,
		undefined41,
		Critter_Scantid,
		Critter_Kakaru,
		Critter_Ragnasaur,
		Critter_Ursadon,
		Zerg_Lurker_Egg,
		undefined42,
		undefined43,
		undefined44,
		undefined45,
		undefined46,
		Zerg_Lurker,
		undefined47,
		Spell_Disruption_Web,
		Terran_Command_Center,
		Terran_Comsat_Station,
		Terran_Nuclear_Silo,
		Terran_Supply_Depot,
		Terran_Refinery,
		Terran_Barracks,
		Terran_Academy,
		Terran_Factory,
		Terran_Starport,
		Terran_Control_Tower,
		Terran_Science_Facility,
		Terran_Covert_Ops,
		Terran_Physics_Lab,
		undefined48,
		Terran_Machine_Shop,
		undefined49,
		Terran_Engineering_Bay,
		Terran_Armory,
		Terran_Missile_Turret,
		Terran_Bunker,
		Special_Crashed_Norad_II,
		Special_Ion_Cannon,
		undefined50,
		undefined51,
		Zerg_Infested_Command_Center,
		Zerg_Hatchery,
		Zerg_Lair,
		Zerg_Hive,
		Zerg_Nydus_Canal,
		Zerg_Hydralisk_Den,
		Zerg_Defiler_Mound,
		Zerg_Greater_Spire,
		Zerg_Queen_s_Nest,
		Zerg_Evolution_Chamber,
		Zerg_Ultralisk_Cavern,
		Zerg_Spire,
		Zerg_Spawning_Pool,
		Zerg_Creep_Colony,
		Zerg_Spore_Colony,
		undefined52,
		Zerg_Sunken_Colony,
		Special_Overmind_With_Shell,
		Special_Overmind,
		Zerg_Extractor,
		Special_Mature_Chrysalis,
		Special_Cerebrate,
		Special_Cerebrate_Daggoth,
		undefined53,
		Protoss_Nexus,
		Protoss_Robotics_Facility,
		Protoss_Pylon,
		Protoss_Assimilator,
		undefined54,
		Protoss_Observatory,
		Protoss_Gateway,
		undefined55,
		Protoss_Photon_Cannon,
		Protoss_Citadel_of_Adun,
		Protoss_Cybernetics_Core,
		Protoss_Templar_Archives,
		Protoss_Forge,
		Protoss_Stargate,
		Special_Stasis_Cell_Prison,
		Protoss_Fleet_Beacon,
		Protoss_Arbiter_Tribunal,
		Protoss_Robotics_Support_Bay,
		Protoss_Shield_Battery,
		Special_Khaydarin_Crystal_Form,
		Special_Protoss_Temple,
		Special_XelNaga_Temple,
		Resource_Mineral_Field,
		undefined56,
		undefined57,
		undefined58,
		undefined59,
		undefined60,
		undefined61,
		undefined62,
		undefined63,
		undefined64,
		undefined65,
		undefined66,
		Resource_Vespene_Geyser,
		Special_Warp_Gate,
		Special_Psi_Disrupter,
		undefined67,
		undefined68,
		undefined69,
		undefined70,
		undefined71,
		undefined72,
		undefined73,
		undefined74,
		undefined75,
		Special_Power_Generator,
		Special_Overmind_Cocoon,
		Spell_Dark_Swarm,
		undefined76,
		undefined77,
		undefined78,
		undefined79,
		undefined80,
		undefined81,
		undefined82,
		undefined83,
		undefined84,
		undefined85,
		undefined86,
		undefined87,
		undefined88,
		undefined89,
		undefined90,
		undefined91,
		undefined92,
		undefined93,
		undefined94,
		undefined95,
		undefined96,
		undefined97,
		undefined98,
		undefined99,
		undefined100,
		None,
		Unknown		
	}
	
	private static HashMap<Integer, UnitTypeWME> unitTypeMap;

	/**
	 * Gets a unit type by ID.
	 */
	public static UnitTypeWME getType(int typeID) {
		if (unitTypeMap == null) {
			unitTypeMap = getUnitTypeMap();
		}
		
		return unitTypeMap.get(typeID);
	}
	
	/**
	 * Returns a mapping of the types indexed by ID.
	 */
	public static HashMap<Integer, UnitTypeWME> getUnitTypeMap() {
		HashMap<Integer, UnitTypeWME> map = new HashMap<Integer, UnitTypeWME>();
		
		for (UnitTypeWME type : getUnitTypes()) {
			map.put(type.getId(), type);
		}
		
		return map;
	}
	
	/**
	 * Returns a list of the unit types.
	 */
	public static ArrayList<UnitTypeWME> getUnitTypes() {
		ArrayList<UnitTypeWME> types = new ArrayList<UnitTypeWME>();		
		types.add(new UnitTypeWME(0,Race.Terran,"Terran_Marine",50,0,40,0,0,360,false,false,1,1,BuildingClass.None,2,0,7,128,0,6,128,6,false,false,false,false,111, -1, -1));
		types.add(new UnitTypeWME(1,Race.Terran,"Terran_Ghost",25,75,45,0,200,750,false,false,1,1,BuildingClass.None,2,0,9,224,0,10,224,10,false,false,false,false,111, 112, 117));
		types.add(new UnitTypeWME(2,Race.Terran,"Terran_Vulture",75,0,80,0,0,450,false,false,1,1,BuildingClass.None,4,0,8,160,0,20,0,0,false,false,false,false,113, -1, -1));
		types.add(new UnitTypeWME(3,Race.Terran,"Terran_Goliath",100,50,125,0,0,600,false,false,1,1,BuildingClass.None,4,0,8,192,0,12,160,10,false,false,false,false,113, 123, -1));
		types.add(new UnitTypeWME(5,Race.Terran,"Terran_Siege_Tank_Tank_Mode",150,100,150,0,0,750,false,false,1,1,BuildingClass.None,4,0,10,224,0,30,0,0,false,false,false,false,113, 120, -1));
		types.add(new UnitTypeWME(7,Race.Terran,"Terran_SCV",50,0,60,0,0,300,false,false,1,1,BuildingClass.None,2,0,7,10,0,5,0,0,false,false,false,true,106, -1, -1));
		types.add(new UnitTypeWME(8,Race.Terran,"Terran_Wraith",150,100,120,0,200,900,false,false,1,1,BuildingClass.None,4,0,7,160,0,8,160,20,false,true,false,false,114, -1, -1));
		types.add(new UnitTypeWME(9,Race.Terran,"Terran_Science_Vessel",100,225,200,0,200,1200,false,false,2,2,BuildingClass.None,4,0,10,0,0,0,0,0,false,true,false,false,114, 115, 116));
		types.add(new UnitTypeWME(11,Race.Terran,"Terran_Dropship",100,100,150,0,0,750,false,false,2,2,BuildingClass.None,4,0,8,0,0,0,0,0,false,true,false,false,114, 115, -1));
		types.add(new UnitTypeWME(12,Race.Terran,"Terran_Battlecruiser",400,300,244,0,200,2000,false,false,2,2,BuildingClass.None,12,0,11,192,0,25,192,25,false,true,false,false,114, 115, 118));
		types.add(new UnitTypeWME(13,Race.Terran,"Terran_Vulture_Spider_Mine",1,0,20,0,0,1,false,false,1,1,BuildingClass.None,0,0,3,10,0,125,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(14,Race.Terran,"Terran_Nuclear_Missile",200,200,100,0,0,1500,false,false,1,1,BuildingClass.None,16,0,3,0,0,0,0,0,false,false,false,false,228, 106, 108));
		types.add(new UnitTypeWME(30,Race.Terran,"Terran_Siege_Tank_Siege_Mode",150,100,150,0,0,750,false,false,1,1,BuildingClass.None,4,0,10,384,64,70,0,0,false,false,false,false,113, 120, -1));
		types.add(new UnitTypeWME(32,Race.Terran,"Terran_Firebat",50,25,50,0,0,360,false,false,1,1,BuildingClass.None,2,0,7,32,0,8,0,0,false,false,false,false,111, 112, -1));
		types.add(new UnitTypeWME(33,Race.Terran,"Spell_Scanner_Sweep",0,0,0,0,0,1,false,false,1,1,BuildingClass.None,0,0,10,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(34,Race.Terran,"Terran_Medic",50,25,60,0,200,450,false,false,1,1,BuildingClass.None,2,0,9,0,0,0,0,0,false,false,false,false,111, 112, -1));
		types.add(new UnitTypeWME(35,Race.Zerg,"Zerg_Larva",1,1,25,0,0,1,false,false,1,1,BuildingClass.None,0,0,4,0,0,0,0,0,false,false,false,false,131, -1, -1));
		types.add(new UnitTypeWME(36,Race.Zerg,"Zerg_Egg",1,1,200,0,0,1,false,false,1,1,BuildingClass.None,0,0,4,0,0,0,0,0,false,false,false,false,35, -1, -1));
		types.add(new UnitTypeWME(37,Race.Zerg,"Zerg_Zergling",50,0,35,0,0,420,false,false,1,1,BuildingClass.None,1,0,5,15,0,5,0,0,false,false,false,false,35, 142, -1));
		types.add(new UnitTypeWME(38,Race.Zerg,"Zerg_Hydralisk",75,25,80,0,0,420,false,false,1,1,BuildingClass.None,2,0,6,128,0,10,128,10,false,false,false,false,35, 135, -1));
		types.add(new UnitTypeWME(39,Race.Zerg,"Zerg_Ultralisk",200,200,144,0,0,900,false,false,2,2,BuildingClass.None,8,0,7,25,0,20,0,0,false,false,false,false,35, 140, -1));
		types.add(new UnitTypeWME(40,Race.Zerg,"Zerg_Broodling",1,1,30,0,0,1,false,false,1,1,BuildingClass.None,0,0,5,2,0,4,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(41,Race.Zerg,"Zerg_Drone",50,0,40,0,0,300,false,false,1,1,BuildingClass.None,2,0,7,32,0,5,0,0,false,false,false,true,35, -1, -1));
		types.add(new UnitTypeWME(42,Race.Zerg,"Zerg_Overlord",100,0,200,0,0,600,false,false,2,2,BuildingClass.None,0,16,9,0,0,0,0,0,false,true,false,false,35, -1, -1));
		types.add(new UnitTypeWME(43,Race.Zerg,"Zerg_Mutalisk",100,100,120,0,0,600,false,false,2,2,BuildingClass.None,4,0,7,96,0,9,96,9,false,true,false,false,35, 141, -1));
		types.add(new UnitTypeWME(44,Race.Zerg,"Zerg_Guardian",50,100,150,0,0,600,false,false,2,2,BuildingClass.None,4,0,11,256,0,20,0,0,false,true,false,false,43, 137, -1));
		types.add(new UnitTypeWME(45,Race.Zerg,"Zerg_Queen",100,100,120,0,200,750,false,false,2,2,BuildingClass.None,4,0,10,0,0,0,0,0,false,true,false,false,35, 138, -1));
		types.add(new UnitTypeWME(46,Race.Zerg,"Zerg_Defiler",50,150,80,0,200,750,false,false,1,1,BuildingClass.None,4,0,10,0,0,0,0,0,false,false,false,false,35, 136, -1));
		types.add(new UnitTypeWME(47,Race.Zerg,"Zerg_Scourge",25,75,25,0,0,450,false,false,1,1,BuildingClass.None,1,0,5,0,0,0,3,110,false,true,false,false,35, 141, -1));
		types.add(new UnitTypeWME(50,Race.Zerg,"Zerg_Infested_Terran",100,50,60,0,0,600,false,false,1,1,BuildingClass.None,2,0,5,3,0,500,0,0,false,false,false,false,130, -1, -1));
		types.add(new UnitTypeWME(58,Race.Terran,"Terran_Valkyrie",250,125,200,0,0,750,false,false,2,2,BuildingClass.None,6,0,8,0,0,0,192,6,false,true,false,false,114, 115, 123));
		types.add(new UnitTypeWME(59,Race.Zerg,"Zerg_Cocoon",1,1,200,0,0,1,false,false,1,1,BuildingClass.None,0,0,4,0,0,0,0,0,false,false,false,false,43, 137, -1));
		types.add(new UnitTypeWME(60,Race.Protoss,"Protoss_Corsair",150,100,100,80,200,600,false,false,1,1,BuildingClass.None,4,0,9,0,0,0,160,5,false,true,false,false,167, -1, -1));
		types.add(new UnitTypeWME(61,Race.Protoss,"Protoss_Dark_Templar",125,100,80,40,0,750,false,false,1,1,BuildingClass.None,4,0,7,15,0,40,0,0,false,false,false,false,160, 165, -1));
		types.add(new UnitTypeWME(62,Race.Zerg,"Zerg_Devourer",150,50,250,0,0,600,false,false,2,2,BuildingClass.None,4,0,10,0,0,0,192,25,false,true,false,false,43, 137, -1));
		types.add(new UnitTypeWME(63,Race.Protoss,"Protoss_Dark_Archon",0,0,25,200,200,300,false,false,1,1,BuildingClass.None,8,0,10,0,0,0,0,0,false,false,false,false,61, -1, -1));
		types.add(new UnitTypeWME(64,Race.Protoss,"Protoss_Probe",50,0,20,20,0,300,false,false,1,1,BuildingClass.None,2,0,8,32,0,5,0,0,false,false,false,true,154, -1, -1));
		types.add(new UnitTypeWME(65,Race.Protoss,"Protoss_Zealot",100,0,100,60,0,600,false,false,1,1,BuildingClass.None,4,0,7,15,0,8,0,0,false,false,false,false,160, -1, -1));
		types.add(new UnitTypeWME(66,Race.Protoss,"Protoss_Dragoon",125,50,100,80,0,750,false,false,1,1,BuildingClass.None,4,0,8,128,0,20,128,20,false,false,false,false,160, 164, -1));
		types.add(new UnitTypeWME(67,Race.Protoss,"Protoss_High_Templar",50,150,40,40,200,750,false,false,1,1,BuildingClass.None,4,0,7,0,0,0,0,0,false,false,false,false,160, 165, -1));
		types.add(new UnitTypeWME(68,Race.Protoss,"Protoss_Archon",0,0,10,350,0,300,false,false,1,1,BuildingClass.None,8,0,8,64,0,30,64,30,false,false,false,false,67, -1, -1));
		types.add(new UnitTypeWME(69,Race.Protoss,"Protoss_Shuttle",200,0,80,60,0,900,false,false,2,1,BuildingClass.None,4,0,8,0,0,0,0,0,false,true,false,false,155, -1, -1));
		types.add(new UnitTypeWME(70,Race.Protoss,"Protoss_Scout",275,125,150,100,0,1200,false,false,2,1,BuildingClass.None,6,0,8,128,0,8,128,14,false,true,false,false,167, -1, -1));
		types.add(new UnitTypeWME(71,Race.Protoss,"Protoss_Arbiter",100,350,200,150,200,2400,false,false,2,2,BuildingClass.None,8,0,9,160,0,10,160,10,false,true,false,false,167, 170, -1));
		types.add(new UnitTypeWME(72,Race.Protoss,"Protoss_Carrier",350,250,44,150,0,2100,false,false,2,2,BuildingClass.None,12,0,11,0,0,0,0,0,false,true,false,false,167, 169, -1));
		types.add(new UnitTypeWME(73,Race.Protoss,"Protoss_Interceptor",25,0,40,40,0,300,false,false,1,1,BuildingClass.None,0,0,6,128,0,6,128,6,false,true,false,false,72, -1, -1));
		types.add(new UnitTypeWME(83,Race.Protoss,"Protoss_Reaver",200,100,100,80,0,1050,false,false,1,1,BuildingClass.None,8,0,10,0,0,0,0,0,false,false,false,false,155, 171, -1));
		types.add(new UnitTypeWME(84,Race.Protoss,"Protoss_Observer",25,75,40,20,0,600,false,false,1,1,BuildingClass.None,2,0,9,0,0,0,0,0,false,true,false,false,155, 159, -1));
		types.add(new UnitTypeWME(85,Race.Protoss,"Protoss_Scarab",15,0,20,10,0,105,false,false,1,1,BuildingClass.None,0,0,5,128,0,100,0,0,false,false,false,false,83, -1, -1));
		types.add(new UnitTypeWME(89,Race.Other,"Critter_Rhynadon",1,1,60,0,0,1,false,false,1,1,BuildingClass.None,0,0,7,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(90,Race.Other,"Critter_Bengalaas",1,1,60,0,0,1,false,false,1,1,BuildingClass.None,0,0,7,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(93,Race.Other,"Critter_Scantid",1,1,60,0,0,1,false,false,1,1,BuildingClass.None,0,0,7,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(94,Race.Other,"Critter_Kakaru",1,1,60,0,0,1,false,false,1,1,BuildingClass.None,0,0,7,0,0,0,0,0,false,true,false,false,228, -1, -1));
		types.add(new UnitTypeWME(95,Race.Other,"Critter_Ragnasaur",1,1,60,0,0,1,false,false,1,1,BuildingClass.None,0,0,7,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(96,Race.Other,"Critter_Ursadon",1,1,60,0,0,1,false,false,1,1,BuildingClass.None,0,0,7,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(97,Race.Zerg,"Zerg_Lurker_Egg",1,1,200,0,0,1,false,false,1,1,BuildingClass.None,0,0,4,0,0,0,0,0,false,false,false,false,38, -1, -1));
		types.add(new UnitTypeWME(103,Race.Zerg,"Zerg_Lurker",50,100,125,0,0,600,false,false,1,1,BuildingClass.None,4,0,8,192,0,20,0,0,false,false,false,false,38, -1, -1));
		types.add(new UnitTypeWME(105,Race.Other,"Spell_Disruption_Web",250,250,32,0,0,2400,false,false,4,3,BuildingClass.None,0,0,8,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(106,Race.Terran,"Terran_Command_Center",400,0,220,0,0,1800,false,false,4,3,BuildingClass.Center,0,20,10,0,0,0,0,0,true,false,false,false,7, -1, -1));
		types.add(new UnitTypeWME(107,Race.Terran,"Terran_Comsat_Station",50,50,244,0,200,600,false,false,2,2,BuildingClass.Addon,0,0,10,0,0,0,0,0,true,false,false,false,106, 112, -1));
		types.add(new UnitTypeWME(108,Race.Terran,"Terran_Nuclear_Silo",100,100,88,0,0,1200,false,false,2,2,BuildingClass.Addon,0,0,8,0,0,0,0,0,true,false,false,false,106, 116, 117));
		types.add(new UnitTypeWME(109,Race.Terran,"Terran_Supply_Depot",100,0,244,0,0,600,false,false,3,2,BuildingClass.Supply,0,16,8,0,0,0,0,0,true,false,false,false,7, -1, -1));
		types.add(new UnitTypeWME(110,Race.Terran,"Terran_Refinery",100,0,238,0,0,600,false,false,4,2,BuildingClass.Extractor,0,0,8,0,0,0,0,0,true,false,false,false,7, -1, -1));
		types.add(new UnitTypeWME(111,Race.Terran,"Terran_Barracks",150,0,232,0,0,1200,false,false,4,3,BuildingClass.Production,0,0,8,0,0,0,0,0,true,false,false,false,7, 106, -1));
		types.add(new UnitTypeWME(112,Race.Terran,"Terran_Academy",150,0,88,0,0,1200,false,false,3,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,7, 111, -1));
		types.add(new UnitTypeWME(113,Race.Terran,"Terran_Factory",200,100,226,0,0,1200,false,false,4,3,BuildingClass.Production,0,0,8,0,0,0,0,0,true,false,false,false,7, 111, -1));
		types.add(new UnitTypeWME(114,Race.Terran,"Terran_Starport",150,100,20,0,0,1050,false,false,4,3,BuildingClass.Production,0,0,10,0,0,0,0,0,true,false,false,false,7, 113, -1));
		types.add(new UnitTypeWME(115,Race.Terran,"Terran_Control_Tower",50,50,244,0,0,600,false,false,2,2,BuildingClass.Addon,0,0,8,0,0,0,0,0,true,false,false,false,114, -1, -1));
		types.add(new UnitTypeWME(116,Race.Terran,"Terran_Science_Facility",100,150,82,0,0,900,false,false,4,3,BuildingClass.Research,0,0,10,0,0,0,0,0,true,false,false,false,7, 114, -1));
		types.add(new UnitTypeWME(117,Race.Terran,"Terran_Covert_Ops",50,50,238,0,0,600,false,false,2,2,BuildingClass.Addon,0,0,8,0,0,0,0,0,true,false,false,false,116, -1, -1));
		types.add(new UnitTypeWME(118,Race.Terran,"Terran_Physics_Lab",50,50,88,0,0,600,false,false,2,2,BuildingClass.Addon,0,0,8,0,0,0,0,0,true,false,false,false,116, -1, -1));
		types.add(new UnitTypeWME(120,Race.Terran,"Terran_Machine_Shop",50,50,238,0,0,600,false,false,2,2,BuildingClass.Addon,0,0,8,0,0,0,0,0,true,false,false,false,113, -1, -1));
		types.add(new UnitTypeWME(122,Race.Terran,"Terran_Engineering_Bay",125,0,82,0,0,900,false,false,4,3,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,7, 106, -1));
		types.add(new UnitTypeWME(123,Race.Terran,"Terran_Armory",100,50,238,0,0,1200,false,false,3,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,7, 113, -1));
		types.add(new UnitTypeWME(124,Race.Terran,"Terran_Missile_Turret",75,0,200,0,0,450,false,false,2,2,BuildingClass.Turret,0,0,11,0,0,0,224,20,true,false,false,false,7,122, -1));
		types.add(new UnitTypeWME(125,Race.Terran,"Terran_Bunker",100,0,94,0,0,450,false,false,3,2,BuildingClass.Bunker,0,0,10,0,0,0,0,0,true,false,false,false,7, 111, -1));
		types.add(new UnitTypeWME(126,Race.None,"Special_Crashed_Norad_II",800,600,188,0,0,4800,false,false,3,2,BuildingClass.Special,0,0,10,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(127,Race.None,"Special_Ion_Cannon",200,0,208,0,0,900,false,false,3,2,BuildingClass.Special,0,0,8,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(130,Race.Zerg,"Zerg_Infested_Command_Center",1,1,220,0,0,1800,false,false,4,3,BuildingClass.Production,0,0,10,0,0,0,0,0,true,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(131,Race.Zerg,"Zerg_Hatchery",300,0,226,0,0,1800,false,false,4,3,BuildingClass.Center,0,2,9,0,0,0,0,0,true,false,false,false,41, -1, -1));
		types.add(new UnitTypeWME(132,Race.Zerg,"Zerg_Lair",150,100,8,0,0,1500,false,false,4,3,BuildingClass.Center,0,2,10,0,0,0,0,0,true,false,false,false,131, 142, -1));
		types.add(new UnitTypeWME(133,Race.Zerg,"Zerg_Hive",200,150,196,0,0,1800,false,false,4,3,BuildingClass.Center,0,2,11,0,0,0,0,0,true,false,false,false,132, 138, -1));
		types.add(new UnitTypeWME(134,Race.Zerg,"Zerg_Nydus_Canal",150,0,250,0,0,600,false,false,2,2,BuildingClass.Nydus,0,0,8,0,0,0,0,0,true,false,false,false,41, 133, -1));
		types.add(new UnitTypeWME(135,Race.Zerg,"Zerg_Hydralisk_Den",100,50,82,0,0,600,false,false,3,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,41, 142, -1));
		types.add(new UnitTypeWME(136,Race.Zerg,"Zerg_Defiler_Mound",100,100,82,0,0,900,false,false,4,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,41, 133, -1));
		types.add(new UnitTypeWME(137,Race.Zerg,"Zerg_Greater_Spire",100,150,232,0,0,1800,false,false,2,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,141, 133, -1));
		types.add(new UnitTypeWME(138,Race.Zerg,"Zerg_Queen_s_Nest",150,100,82,0,0,900,false,false,3,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,41, 132, -1));
		types.add(new UnitTypeWME(139,Race.Zerg,"Zerg_Evolution_Chamber",75,0,238,0,0,600,false,false,3,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,41, 131, -1));
		types.add(new UnitTypeWME(140,Race.Zerg,"Zerg_Ultralisk_Cavern",150,200,88,0,0,1200,false,false,3,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,41, 133, -1));
		types.add(new UnitTypeWME(141,Race.Zerg,"Zerg_Spire",200,150,88,0,0,1800,false,false,2,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,41, 132, -1));
		types.add(new UnitTypeWME(142,Race.Zerg,"Zerg_Spawning_Pool",200,0,238,0,0,1200,false,false,3,2,BuildingClass.Research,0,0,8,0,0,0,0,0,true,false,false,false,41, 131, -1));
		types.add(new UnitTypeWME(143,Race.Zerg,"Zerg_Creep_Colony",75,0,144,0,0,300,false,false,2,2,BuildingClass.Turret,0,0,10,0,0,0,0,0,true,false,false,false,41, -1, -1));
		types.add(new UnitTypeWME(144,Race.Zerg,"Zerg_Spore_Colony",50,0,144,0,0,300,false,false,2,2,BuildingClass.Turret,0,0,10,0,0,0,224,15,true,false,false,false,143, 139, -1));
		types.add(new UnitTypeWME(146,Race.Zerg,"Zerg_Sunken_Colony",50,0,44,0,0,300,false,false,2,2,BuildingClass.Turret,0,0,10,224,0,40,0,0,true,false,false,false,143, 142, -1));
		types.add(new UnitTypeWME(147,Race.None,"Special_Overmind_With_Shell",1,1,136,0,0,1,false,false,5,3,BuildingClass.Special,0,0,8,0,0,0,0,0,true,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(148,Race.None,"Special_Overmind",1,1,196,0,0,1,false,false,5,3,BuildingClass.Special,0,0,8,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(149,Race.Zerg,"Zerg_Extractor",50,0,238,0,0,600,false,false,4,2,BuildingClass.Extractor,0,0,7,0,0,0,0,0,true,false,false,false,41, -1, -1));
		types.add(new UnitTypeWME(150,Race.None,"Special_Mature_Chrysalis",0,0,250,0,0,0,false,false,2,2,BuildingClass.Special,0,0,8,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(151,Race.None,"Special_Cerebrate",0,0,220,0,0,0,false,false,3,2,BuildingClass.Special,0,0,8,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(152,Race.None,"Special_Cerebrate_Daggoth",0,0,220,0,0,0,false,false,3,2,BuildingClass.Special,0,0,8,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(154,Race.Protoss,"Protoss_Nexus",400,0,238,750,0,1800,false,false,4,3,BuildingClass.Center,0,18,11,0,0,0,0,0,true,false,false,false,64, -1, -1));
		types.add(new UnitTypeWME(155,Race.Protoss,"Protoss_Robotics_Facility",200,200,244,500,0,1200,false,false,3,2,BuildingClass.Production,0,0,10,0,0,0,0,0,true,false,false,false,64, 164, -1));
		types.add(new UnitTypeWME(156,Race.Protoss,"Protoss_Pylon",100,0,44,300,0,450,false,false,2,2,BuildingClass.Supply,0,16,8,0,0,0,0,0,true,false,false,false,64, -1, -1));
		types.add(new UnitTypeWME(157,Race.Protoss,"Protoss_Assimilator",100,0,194,450,0,600,false,false,4,2,BuildingClass.Extractor,0,0,10,0,0,0,0,0,true,false,false,false,64, -1, -1));
		types.add(new UnitTypeWME(159,Race.Protoss,"Protoss_Observatory",50,100,250,250,0,450,false,false,3,2,BuildingClass.Research,0,0,10,0,0,0,0,0,true,false,false,false,64, 155, -1));
		types.add(new UnitTypeWME(160,Race.Protoss,"Protoss_Gateway",150,0,244,500,0,900,false,false,4,3,BuildingClass.Production,0,0,10,0,0,0,0,0,true,false,false,false,64, 154, -1));
		types.add(new UnitTypeWME(162,Race.Protoss,"Protoss_Photon_Cannon",150,0,100,100,0,750,false,false,2,2,BuildingClass.Turret,0,0,11,224,0,20,224,20,true,false,false,false,64, 166, -1));
		types.add(new UnitTypeWME(163,Race.Protoss,"Protoss_Citadel_of_Adun",150,100,194,450,0,900,false,false,3,2,BuildingClass.Research,0,0,10,0,0,0,0,0,true,false,false,false,64, 164, -1));
		types.add(new UnitTypeWME(164,Race.Protoss,"Protoss_Cybernetics_Core",200,0,244,500,0,900,false,false,3,2,BuildingClass.Research,0,0,10,0,0,0,0,0,true,false,false,false,64, 160, -1));
		types.add(new UnitTypeWME(165,Race.Protoss,"Protoss_Templar_Archives",150,200,244,500,0,900,false,false,3,2,BuildingClass.Research,0,0,10,0,0,0,0,0,true,false,false,false,64, 163, -1));
		types.add(new UnitTypeWME(166,Race.Protoss,"Protoss_Forge",150,0,38,550,0,600,false,false,3,2,BuildingClass.Research,0,0,10,0,0,0,0,0,true,false,false,false,64, 154, -1));
		types.add(new UnitTypeWME(167,Race.Protoss,"Protoss_Stargate",150,150,88,600,0,1050,false,false,4,3,BuildingClass.Production,0,0,10,0,0,0,0,0,true,false,false,false,64, 164, -1));
		types.add(new UnitTypeWME(168,Race.None,"Special_Stasis_Cell_Prison",150,0,208,0,0,1,false,false,4,3,BuildingClass.Special,0,0,8,0,0,0,0,0,true,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(169,Race.Protoss,"Protoss_Fleet_Beacon",300,200,244,500,0,900,false,false,3,2,BuildingClass.Research,0,0,10,0,0,0,0,0,true,false,false,false,64, 167, -1));
		types.add(new UnitTypeWME(170,Race.Protoss,"Protoss_Arbiter_Tribunal",200,150,244,500,0,900,false,false,3,2,BuildingClass.Research,0,0,10,0,0,0,0,0,true,false,false,false,64, 165, 167));
		types.add(new UnitTypeWME(171,Race.Protoss,"Protoss_Robotics_Support_Bay",150,100,194,450,0,450,false,false,3,2,BuildingClass.Research,0,0,10,0,0,0,0,0,true,false,false,false,64, 155, -1));
		types.add(new UnitTypeWME(172,Race.Protoss,"Protoss_Shield_Battery",100,0,200,200,200,450,false,false,3,2,BuildingClass.Battery,0,0,10,0,0,0,0,0,true,false,false,false,64, 160, -1));
		types.add(new UnitTypeWME(173,Race.None,"Special_Khaydarin_Crystal_Form",250,0,160,0,0,1,false,false,4,3,BuildingClass.Special,0,0,10,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(174,Race.None,"Special_Protoss_Temple",250,0,220,0,0,1,false,false,7,3,BuildingClass.Special,0,0,10,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(175,Race.None,"Special_XelNaga_Temple",1500,500,136,0,0,4800,false,false,5,4,BuildingClass.Special,0,0,10,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(176,Race.Other,"Resource_Mineral_Field",1,1,160,0,0,1,false,false,2,1,BuildingClass.None,0,0,9,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(188,Race.Other,"Resource_Vespene_Geyser",1,1,160,0,0,1,false,false,4,2,BuildingClass.None,0,0,9,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(189,Race.None,"Special_Warp_Gate",600,200,188,0,0,2400,false,false,3,2,BuildingClass.Special,0,0,8,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(190,Race.None,"Special_Psi_Disrupter",1000,400,208,0,0,4800,false,false,5,3,BuildingClass.Special,0,0,10,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(200,Race.None,"Special_Power_Generator",200,50,32,0,0,2400,false,false,4,3,BuildingClass.Special,0,0,8,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(201,Race.None,"Special_Overmind_Cocoon",1000,500,196,0,0,2400,false,false,3,2,BuildingClass.Special,0,0,10,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(202,Race.Other,"Spell_Dark_Swarm",250,200,32,0,0,2400,false,false,5,5,BuildingClass.None,0,0,8,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(228,Race.None,"None",0,0,0,0,0,0,false,false,0,0,BuildingClass.None,0,0,0,0,0,0,0,0,false,false,false,false,228, -1, -1));
		types.add(new UnitTypeWME(229,Race.Unknown,"Unknown",0,0,0,0,0,0,false,false,0,0,BuildingClass.None,0,0,0,0,0,0,0,0,false,false,false,false,229, -1, -1)); 

		return types;
	}	
}
