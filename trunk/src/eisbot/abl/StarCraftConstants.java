package eisbot.abl;

import java.awt.event.KeyEvent;

import eisbot.abl.wmes.ConstructionWME.ConstructionStatus;
import eisbot.buildorder.Action.ActionType;
import eisbot.buildorder.Prerequisite.PrereqType;
import eisbot.proxy.wmes.UnitTypeWME.BuildingClass;
import eisbot.proxy.wmes.unit.PlayerUnitWME.FighterTask;
import eisbot.proxy.wmes.unit.PlayerUnitWME.WorkerTask;
//import eisbot.abl.wmes.ShuttleMissionWME;

/**
 * Constant definitions for the ABL code.
 * 
 * Includes the following information:
 *  - races
 *  - unit types
 *  - orders
 *  - tech types
 *  - upgrade types
 *
 * Include the following line under the imports in the abl header:
 * constants starcraftbot.abl.java.StarCraftConstants;
 */
public interface StarCraftConstants {

	public static int NULL_UNIT = -1;
	
	public static int PIXELS_PER_TILE = 32;

	public static int DISTANCE_CLOSE = 20; //TODO: Tune this...
	public static int DISTANCE_ARRIVED = 3; // TODO: Tune this...

	public static int FARM_SUPPLY = 8;

	public enum TrainUnitStatus { Request, SentCommand, Training }
	
	// GDA strategies
//	public static final int Obs = Strategy.Obs.ordinal();
//	public static final int Carriers = Strategy.Carriers.ordinal();
//	public static final int GoonRange = Strategy.GoonRange.ordinal();
//	public static final int DTRush = Strategy.DTRush.ordinal();
//	public static final int MassZealot = Strategy.MassZealot.ordinal();

	// reasons for construction a pylon
	public static final int PYLON_FIRST = 0;
	public static final int PYLON_OPEN = 1;
	public static final int PYLON_MINERALS = 2;
	public static final int PYLON_CHOKE = 3;
	public static final int PYLON_BOUNDARY = 4;

	// construction wme states
	int CONSTRUCTION_REQUEST = ConstructionStatus.Request.ordinal();
	int CONSTRUCTION_PREPARE = ConstructionStatus.Prepare.ordinal();
	int CONSTRUCTION_READY = ConstructionStatus.Ready.ordinal();
	int CONSTRUCTION_CONSTRUCTING = ConstructionStatus.Constructing.ordinal();
	int CONSTRUCTION_PAUSED = ConstructionStatus.Paused.ordinal();
	int CONSTRUCTION_FINISHED = ConstructionStatus.Finished.ordinal();

	// worker task
	int WORKER_IDLE = WorkerTask.IDLE.ordinal();
	int WORKER_MINE = WorkerTask.MINING.ordinal();
	int WORKER_GAS = WorkerTask.GAS.ordinal();
	int WORKER_CONSTRUCT = WorkerTask.CONSTRUCTING.ordinal();
	int WORKER_SCOUT = WorkerTask.SCOUTING.ordinal();
	int WORKER_DEFEND = WorkerTask.DEFEND.ordinal();
	int WORKER_CLEAR = WorkerTask.CLEAR.ordinal();

	int FIGHTER_IDLE = FighterTask.IDLE.ordinal();
	int FIGHTER_GUARD = FighterTask.GUARD.ordinal();
	int FIGHTER_ATTACK = FighterTask.ATTACK.ordinal();
	int FIGHTER_FLEE = FighterTask.FLEE.ordinal();
	int FIGHTER_REGROUP = FighterTask.REGROUP.ordinal();
	
	int PREREQ_MINERALS = PrereqType.Minerals.ordinal();
	int PREREQ_GAS = PrereqType.Gas.ordinal();
	int PREREQ_SUPPLY = PrereqType.Supply.ordinal();
	int PREREQ_ASAP = PrereqType.ASAP.ordinal();

	int ACTION_BUILD = ActionType.Build.ordinal();
	int ACTION_ASAP = ActionType.ASAP.ordinal();
	int ACTION_Scout = ActionType.Scout.ordinal();
	int ACTION_Attack = ActionType.Attack.ordinal();
	
	//Reaver harass states
//	int SM_LOADING = ShuttleMissionWME.HarassState.LOADING.ordinal();
//	int SM_DROPPING = ShuttleMissionWME.HarassState.DROPPING.ordinal();
//	int SM_RUNNING = ShuttleMissionWME.HarassState.RUNNING.ordinal();
//	int SM_IDLE = ShuttleMissionWME.HarassState.IDLE.ordinal();

	// building classes:
//	int BUILDING_CLASS_NONE = BuildingClass.None.ordinal();
//	int BUILDING_CLASS_PRODUCTION = BuildingClass.Production.ordinal();
//	int BUILDING_CLASS_RESEARCH = BuildingClass.Research.ordinal();
//	int BUILDING_CLASS_SUPPLY = BuildingClass.Supply.ordinal();
//	int BUILDING_CLASS_TURRET = BuildingClass.Turret.ordinal();
//	int BUILDING_CLASS_ADDON = BuildingClass.Addon.ordinal();
//	int BUILDING_CLASS_CENTER = BuildingClass.Center.ordinal();
//	int BUILDING_CLASS_EXTRACTOR = BuildingClass.Extractor.ordinal();
//	int BUILDING_CLASS_BUNKER = BuildingClass.Bunker.ordinal();
//	int BUILDING_CLASS_BATTERY = BuildingClass.Battery.ordinal();
//	int BUILDING_CLASS_NYDUS = BuildingClass.Nydus.ordinal();
//	int BUILDING_CLASS_SPECIAL = BuildingClass.Special.ordinal();

	/** 
	 * Races 
	 */
	public enum Race {
		Zerg,
		Terran,
		Protoss,
		Random,
		Other,
		None,
		Unknown
	}
	
	public static final int VK_R = KeyEvent.VK_R;
	public static final int VK_G = KeyEvent.VK_G;
	public static final int VK_M = KeyEvent.VK_M;

	/** 
	 * Orders (commands)
	 */
	public enum Order {	
		Die,
	    Stop,
	    Guard,
	    PlayerGuard,
	    TurretGuard,
	    BunkerGuard,
	    Move,
	    ReaverStop,
	    Attack1,
	    Attack2,
	    AttackUnit,
	    AttackFixedRange,
	    AttackTile,
	    Hover,
	    AttackMove,
	    InfestMine1,
	    Nothing1,
	    Powerup1,
	    TowerGuard,
	    TowerAttack,
	    VultureMine,
	    StayinRange,
	    TurretAttack,
	    Nothing2,
	    Nothing3,
	    DroneStartBuild,
	    DroneBuild,
	    InfestMine2,
	    InfestMine3,
	    InfestMine4,
	    BuildTerran,
	    BuildProtoss1,
	    BuildProtoss2,
	    ConstructingBuilding,
	    Repair1,
	    Repair2,
	    PlaceAddon,
	    BuildAddon,
	    Train,
	    RallyPoint1,
	    RallyPoint2,
	    ZergBirth,
	    Morph1,
	    Morph2,
	    BuildSelf1,
	    ZergBuildSelf,
	    Build5,
	    Enternyduscanal,
	    BuildSelf2,
	    Follow,
	    Carrier,
	    CarrierIgnore1,
	    CarrierStop,
	    CarrierAttack1,
	    CarrierAttack2,
	    CarrierIgnore2,
	    CarrierFight,
	    HoldPosition1,
	    Reaver,
	    ReaverAttack1,
	    ReaverAttack2,
	    ReaverFight,
	    ReaverHold,
	    TrainFighter,
	    StrafeUnit1,
	    StrafeUnit2,
	    RechargeShields1,
	    Rechargeshields2,
	    ShieldBattery,
	    Return,
	    DroneLand,
	    BuildingLand,
	    BuildingLiftoff,
	    DroneLiftoff,
	    Liftoff,
	    ResearchTech,
	    Upgrade,
	    Larva,
	    SpawningLarva,
	    Harvest1,
	    Harvest2,
	    MoveToGas, // Unit is moving to refinery
	    WaitForGas, // Unit is waiting to enter the refinery (another unit is currently in it)
	    HarvestGas, // Unit is in refinery
	    ReturnGas, // Unit is returning gas to center
	    MoveToMinerals, // Unit is moving to mineral patch
	    WaitForMinerals, // Unit is waiting to use the mineral patch (another unit is currently mining from it)
	    MiningMinerals, // Unit is mining minerals from mineral patch
	    Harvest3,
	    Harvest4,
	    ReturnMinerals, // Unit is returning minerals to center
	    Harvest5,
	    EnterTransport,
	    Pickup1,
	    Pickup2,
	    Pickup3,
	    Pickup4,
	    Powerup2,
	    SiegeMode,
	    TankMode,
	    WatchTarget,
	    InitCreepGrowth,
	    SpreadCreep,
	    StoppingCreepGrowth,
	    GuardianAspect,
	    WarpingArchon,
	    CompletingArchonsummon,
	    HoldPosition2,
	    HoldPosition3,
	    Cloak,
	    Decloak,
	    Unload,
	    MoveUnload,
	    FireYamatoGun1,
	    FireYamatoGun2,
	    MagnaPulse,
	    Burrow,
	    Burrowed,
	    Unburrow,
	    DarkSwarm,
	    CastParasite,
	    SummonBroodlings,
	    EmpShockwave,
	    NukeWait,
	    NukeTrain,
	    NukeLaunch,
	    NukePaint,
	    NukeUnit,
	    NukeGround,
	    NukeTrack,
	    InitArbiter,
	    CloakNearbyUnits,
	    PlaceMine,
	    Rightclickaction,
	    SapUnit,
	    SapLocation,
	    HoldPosition4,
	    Teleport,
	    TeleporttoLocation,
	    PlaceScanner,
	    Scanner,
	    DefensiveMatrix,
	    PsiStorm,
	    Irradiate,
	    Plague,
	    Consume,
	    Ensnare,
	    StasisField,
	    Hallucianation1,
	    Hallucination2,
	    ResetCollision1,
	    ResetCollision2,
	    Patrol,
	    CTFCOPInit,
	    CTFCOP1,
	    CTFCOP2,
	    ComputerAI,
	    AtkMoveEP,
	    HarassMove,
	    AIPatrol,
	    GuardPost,
	    RescuePassive,
	    Neutral,
	    ComputerReturn,
	    InitPsiProvider,
	    SelfDestrucing,
	    Critter,
	    HiddenGun,
	    OpenDoor,
	    CloseDoor,
	    HideTrap,
	    RevealTrap,
	    Enabledoodad,
	    Disabledoodad,
	    Warpin,
	    Medic,
	    MedicHeal1,
	    HealMove,
	    MedicHoldPosition,
	    MedicHeal2,
	    Restoration,
	    CastDisruptionWeb,
	    CastMindControl,
	    WarpingDarkArchon,
	    CastFeedback,
	    CastOpticalFlare,
	    CastMaelstrom,
	    JunkYardDog,
	    Fatal,
	    None,
	    Unknown 
	}
	
	// Races
	public static int Zerg = 0;
    public static int Terran = 1;
    public static int Protoss = 2;
    public static int Random = 3;
    public static int Other = 4;
    public static int Race_None = 5;
    public static int Race_Unknown = 6;	
	
	// unit types
	public static final int Terran_Marine = 0;
	public static final int Terran_Ghost = 1;
	public static final int Terran_Vulture = 2;
	public static final int Terran_Goliath = 3;
	public static final int Terran_Siege_Tank_Tank_Mode = 5;
	public static final int Terran_SCV = 7;
	public static final int Terran_Wraith = 8;
	public static final int Terran_Science_Vessel = 9;
	public static final int Terran_Dropship = 11;
	public static final int Terran_Battlecruiser = 12;
	public static final int Terran_Vulture_Spider_Mine = 13;
	public static final int Terran_Nuclear_Missile = 14;
	public static final int Terran_Siege_Tank_Siege_Mode = 30;
	public static final int Terran_Medic = 34;
	public static final int Zerg_Larva = 35;
	public static final int Terran_Firebat = 32;
	public static final int Spell_Scanner_Sweep = 33;
	public static final int Zerg_Hydralisk = 38;
	public static final int Zerg_Ultralisk = 39;
	public static final int Zerg_Egg = 36;
	public static final int Zerg_Zergling = 37;
	public static final int Zerg_Overlord = 42;
	public static final int Zerg_Mutalisk = 43;
	public static final int Zerg_Broodling = 40;
	public static final int Zerg_Drone = 41;
	public static final int Zerg_Defiler = 46;
	public static final int Zerg_Scourge = 47;
	public static final int Zerg_Guardian = 44;
	public static final int Zerg_Queen = 45;
	public static final int Zerg_Infested_Terran = 50;
	public static final int Zerg_Cocoon = 59;
	public static final int Terran_Valkyrie = 58;
	public static final int Protoss_Dark_Archon = 63;
	public static final int Zerg_Devourer = 62;
	public static final int Protoss_Dark_Templar = 61;
	public static final int Protoss_Corsair = 60;
	public static final int Protoss_Archon = 68;
	public static final int Protoss_Shuttle = 69;
	public static final int Protoss_Scout = 70;
	public static final int Protoss_Arbiter = 71;
	public static final int Protoss_Probe = 64;
	public static final int Protoss_Zealot = 65;
	public static final int Protoss_Dragoon = 66;
	public static final int Protoss_High_Templar = 67;
	public static final int Protoss_Carrier = 72;
	public static final int Protoss_Interceptor = 73;
	public static final int Protoss_Scarab = 85;
	public static final int Protoss_Observer = 84;
	public static final int Protoss_Reaver = 83;
	public static final int Critter_Scantid = 93;
	public static final int Critter_Ragnasaur = 95;
	public static final int Critter_Kakaru = 94;
	public static final int Critter_Rhynadon = 89;
	public static final int Critter_Bengalaas = 90;
	public static final int Zerg_Lurker = 103;
	public static final int Critter_Ursadon = 96;
	public static final int Zerg_Lurker_Egg = 97;
	public static final int Terran_Refinery = 110;
	public static final int Terran_Barracks = 111;
	public static final int Terran_Nuclear_Silo = 108;
	public static final int Terran_Supply_Depot = 109;
	public static final int Terran_Command_Center = 106;
	public static final int Terran_Comsat_Station = 107;
	public static final int Spell_Disruption_Web = 105;
	public static final int Terran_Physics_Lab = 118;
	public static final int Terran_Covert_Ops = 117;
	public static final int Terran_Science_Facility = 116;
	public static final int Terran_Control_Tower = 115;
	public static final int Terran_Starport = 114;
	public static final int Terran_Factory = 113;
	public static final int Terran_Academy = 112;
	public static final int Special_Ion_Cannon = 127;
	public static final int Special_Crashed_Norad_II = 126;
	public static final int Terran_Bunker = 125;
	public static final int Terran_Missile_Turret = 124;
	public static final int Terran_Armory = 123;
	public static final int Terran_Engineering_Bay = 122;
	public static final int Terran_Machine_Shop = 120;
	public static final int Zerg_Greater_Spire = 137;
	public static final int Zerg_Defiler_Mound = 136;
	public static final int Zerg_Evolution_Chamber = 139;
	public static final int Zerg_Queen__s_Nest = 138;
	public static final int Zerg_Spire = 141;
	public static final int Zerg_Ultralisk_Cavern = 140;
	public static final int Zerg_Creep_Colony = 143;
	public static final int Zerg_Spawning_Pool = 142;
	public static final int Zerg_Hatchery = 131;
	public static final int Zerg_Infested_Command_Center = 130;
	public static final int Zerg_Hive = 133;
	public static final int Zerg_Lair = 132;
	public static final int Zerg_Hydralisk_Den = 135;
	public static final int Zerg_Nydus_Canal = 134;
	public static final int Special_Cerebrate_Daggoth = 152;
	public static final int Protoss_Nexus = 154;
	public static final int Protoss_Robotics_Facility = 155;
	public static final int Protoss_Pylon = 156;
	public static final int Protoss_Assimilator = 157;
	public static final int Protoss_Observatory = 159;
	public static final int Zerg_Spore_Colony = 144;
	public static final int Zerg_Sunken_Colony = 146;
	public static final int Special_Overmind_With_Shell = 147;
	public static final int Special_Overmind = 148;
	public static final int Zerg_Extractor = 149;
	public static final int Special_Mature_Chrysalis = 150;
	public static final int Special_Cerebrate = 151;
	public static final int Protoss_Robotics_Support_Bay = 171;
	public static final int Protoss_Arbiter_Tribunal = 170;
	public static final int Protoss_Fleet_Beacon = 169;
	public static final int Special_Stasis_Cell_Prison = 168;
	public static final int Special_XelNaga_Temple = 175;
	public static final int Special_Protoss_Temple = 174;
	public static final int Special_Khaydarin_Crystal_Form = 173;
	public static final int Protoss_Shield_Battery = 172;
	public static final int Protoss_Citadel_of_Adun = 163;
	public static final int Protoss_Photon_Cannon = 162;
	public static final int Protoss_Gateway = 160;
	public static final int Protoss_Stargate = 167;
	public static final int Protoss_Forge = 166;
	public static final int Protoss_Templar_Archives = 165;
	public static final int Protoss_Cybernetics_Core = 164;
	public static final int Special_Psi_Disrupter = 190;
	public static final int Resource_Vespene_Geyser = 188;
	public static final int Special_Warp_Gate = 189;
	public static final int Resource_Mineral_Field = 176;
	public static final int Special_Overmind_Cocoon = 201;
	public static final int Special_Power_Generator = 200;
	public static final int Spell_Dark_Swarm = 202;
	public static final int Type_Unknown = 229;
	public static final int Type_None = 228;	
	

	// IDLE (stopped) = 3
	// Move = 6
	// Attack = 14
	// Patrol = 152
	// Hold - 107
	// Stop = 3
	// LayMine = 132
	// has laid = 20
	
	// orders
	public static int Die = 0;
	public static int Stop = 1;
	public static int Guard = 2;
	public static int PlayerGuard = 3;
	public static int TurretGuard = 4;
	public static int BunkerGuard = 5;
	public static int Move = 6;
	public static int ReaverStop = 7;
	public static int Attack1 = 8;
	public static int Attack2 = 9;
	public static int AttackUnit = 10;
	public static int AttackFixedRange = 11;
	public static int AttackTile = 12;
	public static int Hover = 13;
	public static int AttackMove = 14;
	public static int InfestMine1 = 15;
	public static int Nothing1 = 16;
	public static int Powerup1 = 17;
	public static int TowerGuard = 18;
	public static int TowerAttack = 19;
	public static int VultureMine = 20;
	public static int StayinRange = 21;
	public static int TurretAttack = 22;
	public static int Nothing2 = 23;
	public static int Nothing3 = 24;
	public static int DroneStartBuild = 25;
	public static int DroneBuild = 26;
	public static int InfestMine2 = 27;
	public static int InfestMine3 = 28;
	public static int InfestMine4 = 29;
	public static int BuildTerran = 30;
	public static int BuildProtoss1 = 31;
	public static int BuildProtoss2 = 32;
	public static int ConstructingBuilding = 33;
	public static int Repair1 = 34;
	public static int Repair2 = 35;
	public static int PlaceAddon = 36;
	public static int BuildAddon = 37;
	public static int Train = 38;
	public static int RallyPoint1 = 39;
	public static int RallyPoint2 = 40;
	public static int ZergBirth = 41;
	public static int Morph1 = 42;
	public static int Morph2 = 43;
	public static int BuildSelf1 = 44;
	public static int ZergBuildSelf = 45;
	public static int Build5 = 46;
	public static int Enternyduscanal = 47;
	public static int BuildSelf2 = 48;
	public static int Follow = 49;
	public static int Carrier = 50;
	public static int CarrierIgnore1 = 51;
	public static int CarrierStop = 52;
	public static int CarrierAttack1 = 53;
	public static int CarrierAttack2 = 54;
	public static int CarrierIgnore2 = 55;
	public static int CarrierFight = 56;
	public static int HoldPosition1 = 57;
	public static int Reaver = 58;
	public static int ReaverAttack1 = 59;
	public static int ReaverAttack2 = 60;
	public static int ReaverFight = 61;
	public static int ReaverHold = 62;
	public static int TrainFighter = 63;
	public static int StrafeUnit1 = 64;
	public static int StrafeUnit2 = 65;
	public static int RechargeShields1 = 66;
	public static int Rechargeshields2 = 67;
	public static int ShieldBattery = 68;
	public static int Return = 69;
	public static int DroneLand = 70;
	public static int BuildingLand = 71;
	public static int BuildingLiftoff = 72;
	public static int DroneLiftoff = 73;
	public static int Liftoff = 74;
	public static int ResearchTech = 75;
	public static int Upgrade = 76;
	public static int Larva = 77;
	public static int SpawningLarva = 78;
	public static int Harvest1 = 79;
	public static int Harvest2 = 80;
	public static int MoveToGas = 81;
	public static int WaitForGas = 82;
	public static int HarvestGas = 83;
	public static int ReturnGas = 84;
	public static int MoveToMinerals = 85;
	public static int WaitForMinerals = 86;
	public static int MiningMinerals = 87;
	public static int Harvest3 = 88;
	public static int Harvest4 = 89;
	public static int ReturnMinerals = 90;
	public static int Harvest5 = 91;
	public static int EnterTransport = 92;
	public static int Pickup1 = 93;
	public static int Pickup2 = 94;
	public static int Pickup3 = 95;
	public static int Pickup4 = 96;
	public static int Powerup2 = 97;
	public static int SiegeMode = 98;
	public static int TankMode = 99;
	public static int WatchTarget = 100;
	public static int InitCreepGrowth = 101;
	public static int SpreadCreep = 102;
	public static int StoppingCreepGrowth = 103;
	public static int GuardianAspect = 104;
	public static int WarpingArchon = 105;
	public static int CompletingArchonsummon = 106;
	public static int HoldPosition2 = 107;
	public static int HoldPosition3 = 108;
	public static int Cloak = 109;
	public static int Decloak = 110;
	public static int Unload = 111;
	public static int MoveUnload = 112;
	public static int FireYamatoGun1 = 113;
	public static int FireYamatoGun2 = 114;
	public static int MagnaPulse = 115;
	public static int Burrow = 116;
	public static int Burrowed = 117;
	public static int Unburrow = 118;
	public static int DarkSwarm = 119;
	public static int CastParasite = 120;
	public static int SummonBroodlings = 121;
	public static int EmpShockwave = 122;
	public static int NukeWait = 123;
	public static int NukeTrain = 124;
	public static int NukeLaunch = 125;
	public static int NukePaint = 126;
	public static int NukeUnit = 127;
	public static int NukeGround = 128;
	public static int NukeTrack = 129;
	public static int InitArbiter = 130;
	public static int CloakNearbyUnits = 131;
	public static int PlaceMine = 132;
	public static int Rightclickaction = 133;
	public static int SapUnit = 134;
	public static int SapLocation = 135;
	public static int HoldPosition4 = 136;
	public static int Teleport = 137;
	public static int TeleporttoLocation = 138;
	public static int PlaceScanner = 139;
	public static int Scanner = 140;
	public static int DefensiveMatrix = 141;
	public static int PsiStorm = 142;
	public static int Order_Irradiate = 143;
	public static int Order_Plague = 144;
	public static int Order_Consume = 145;
	public static int Order_Ensnare = 146;
	public static int StasisField = 147;
	public static int Hallucianation1 = 148;
	public static int Hallucination2 = 149;
	public static int ResetCollision1 = 150;
	public static int ResetCollision2 = 151;
	public static int Patrol = 152;
	public static int CTFCOPInit = 153;
	public static int CTFCOP1 = 154;
	public static int CTFCOP2 = 155;
	public static int ComputerAI = 156;
	public static int AtkMoveEP = 157;
	public static int HarassMove = 158;
	public static int AIPatrol = 159;
	public static int GuardPost = 160;
	public static int RescuePassive = 161;
	public static int Neutral = 162;
	public static int ComputerReturn = 163;
	public static int InitPsiProvider = 164;
	public static int SelfDestrucing = 165;
	public static int Critter = 166;
	public static int HiddenGun = 167;
	public static int OpenDoor = 168;
	public static int CloseDoor = 169;
	public static int HideTrap = 170;
	public static int RevealTrap = 171;
	public static int Enabledoodad = 172;
	public static int Disabledoodad = 173;
	public static int Warpin = 174;
	public static int Medic = 175;
	public static int MedicHeal1 = 176;
	public static int HealMove = 177;
	public static int MedicHoldPosition = 178;
	public static int MedicHeal2 = 179;
	public static int Order_Restoration = 180;
	public static int CastDisruptionWeb = 181;
	public static int CastMindControl = 182;
	public static int WarpingDarkArchon = 183;
	public static int CastFeedback = 184;
	public static int CastOpticalFlare = 185;
	public static int CastMaelstrom = 186;
	public static int JunkYardDog = 187;
	public static int Fatal = 188;
	public static int Order_None = 189;
	public static int Order_Unknown = 190;	
	
	// tech types
	public static int Stim_Packs = 0;
	public static int Lockdown = 1;
	public static int EMP_Shockwave = 2;
	public static int Spider_Mines = 3;
	public static int Scanner_Sweep = 4;
	public static int Tank_Siege_Mode = 5;
	public static int Defensive_Matrix = 6;
	public static int Irradiate = 7;
	public static int Yamato_Gun = 8;
	public static int Cloaking_Field = 9;
	public static int Personnel_Cloaking = 10;
	public static int Burrowing = 11;
	public static int Infestation = 12;
	public static int Spawn_Broodlings = 13;
	public static int Dark_Swarm = 14;
	public static int Plague = 15;
	public static int Consume = 16;
	public static int Ensnare = 17;
	public static int Parasite = 18;
	public static int Psionic_Storm = 19;
	public static int Hallucination = 20;
	public static int Recall = 21;
	public static int Stasis_Field = 22;
	public static int Archon_Warp = 23;
	public static int Restoration = 24;
	public static int Disruption_Web = 25;
	public static int Mind_Control = 27;
	public static int Dark_Archon_Meld = 28;
	public static int Feedback = 29;
	public static int Optical_Flare = 30;
	public static int Maelstrom = 31;
	public static int Lurker_Aspect = 32;
	public static int Healing = 34;
	public static int Tech_None = 44;
	public static int Tech_Unknown = 45;
	public static int Nuclear_Strike = 46;	

	// upgrade types
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
	public static int U___238_Shells = 16;
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
	public static int Upgrade_None = 61;
	public static int Upgrade_Unknown = 62;	
}
