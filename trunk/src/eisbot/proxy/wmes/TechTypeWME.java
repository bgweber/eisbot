package eisbot.proxy.wmes;

import java.util.ArrayList;
import java.util.HashMap;

import wm.WME;
import eisbot.abl.StarCraftConstants.Race;
/**
 * Reference data about the tech types in StarCraft.
 * 
 * A tech type is an upgrade that is an active upgrade, such as stim packs. 
 * While upgrade types are passive upgrades such as armor.
 */
public class TechTypeWME extends WME {

	 /** constants */
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
	 public static int None = 44;
	 public static int Unknown = 45;
	 public static int Nuclear_Strike = 46;
	
	/** the tech unique ID */
	private int id;

	/** the tech type name */
	private String name;
	
	/** the unit type that research the tech */
	private int whatResearchesID;
	
	/** mineral cost of the tech */
	private int mineralsCost;
	
	/** gas cost of the tech */
	private int gasCost;

	private static HashMap<Integer, TechTypeWME> techTypeMap;

	public TechTypeWME(int id, String name, int whatResearchesID, int mineralsCost, int gasCost) {
		this.id = id;
		this.name = name;
		this.whatResearchesID = whatResearchesID;
		this.mineralsCost = mineralsCost;
		this.gasCost = gasCost;
	}
	
	/**
	 * Gets a tech type by ID.
	 */
	public static TechTypeWME getType(int typeID) {
		if (techTypeMap == null) {			
			techTypeMap = new HashMap<Integer, TechTypeWME>();
			
			for (TechTypeWME tech : getTechTypes()) {
				techTypeMap.put(tech.getId(), tech);
			}
		}
		
		return techTypeMap.get(typeID);
	}
	
	/**
	 * Returns a unique identifier for the tech type.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the name of the tech type.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * The id of the type that researches the tech.
	 */
	public int getWhatResearchesID() {
		return whatResearchesID;
	}
	
	/**
	 * Mineral cost of the tech.
	 */
	public int getMineralsCost() {
		return mineralsCost;
	}
	
	/**
	 * Gas cost of the tech.
	 */
	public int getGasCost() {
		return gasCost;
	}

	public String toString() {
		return 
			"id:" + id + 
			" name:" + name + 
			" whatResearches:" + whatResearchesID + 
			" mins:" + mineralsCost + 
			" gas:" + gasCost;
	}

	/** enumeration */
	public enum TechType {
		Stim_Packs,
		Lockdown,
		EMP_Shockwave,
		Spider_Mines,
		Scanner_Sweep,
		Tank_Siege_Mode,
		Defensive_Matrix,
		Irradiate,
		Yamato_Gun,
		Cloaking_Field,
		Personnel_Cloaking,
		Burrowing,
		Infestation,
		Spawn_Broodlings,
		Dark_Swarm,
		Plague,
		Consume,
		Ensnare,
		Parasite,
		Psionic_Storm,
		Hallucination,
		Recall,
		Stasis_Field,
		Archon_Warp,
		Restoration,
		Disruption_Web,
		undefined0,
		Mind_Control,
		Dark_Archon_Meld,
		Feedback,
		Optical_Flare,
		Maelstrom,
		Lurker_Aspect,
		undefined1,
		Healing,
		undefined2,
		undefined3,
		undefined4,
		undefined5,
		undefined6,
		undefined7,
		undefined8,
		undefined9,
		undefined10,
		None,
		Unknown,
		Nuclear_Strike,		
	};
	
	public static ArrayList<TechType> getTypes(Race race) {
		ArrayList<TechType> types = new ArrayList<TechType>();
		
		switch (race) {
		case Protoss:
			types.add(TechType.Psionic_Storm);
			types.add(TechType.Hallucination);
			types.add(TechType.Recall);
			types.add(TechType.Stasis_Field);
			types.add(TechType.Archon_Warp);
			types.add(TechType.Disruption_Web);
			types.add(TechType.Mind_Control);
			types.add(TechType.Dark_Archon_Meld);
			types.add(TechType.Feedback);
			types.add(TechType.Maelstrom);			
			break;
		case Terran:
			types.add(TechType.Stim_Packs);
			types.add(TechType.Lockdown);	
			types.add(TechType.EMP_Shockwave);
			types.add(TechType.Spider_Mines);
			types.add(TechType.Scanner_Sweep);
			types.add(TechType.Tank_Siege_Mode);
			types.add(TechType.Defensive_Matrix);
			types.add(TechType.Irradiate);
			types.add(TechType.Yamato_Gun);
			types.add(TechType.Cloaking_Field);
			types.add(TechType.Personnel_Cloaking);
			types.add(TechType.Optical_Flare);
			types.add(TechType.Healing);			
			types.add(TechType.Restoration);
			types.add(TechType.Nuclear_Strike);
			break;
		case Zerg:
			types.add(TechType.Burrowing);
			types.add(TechType.Infestation);
			types.add(TechType.Spawn_Broodlings);
			types.add(TechType.Dark_Swarm);
			types.add(TechType.Plague);
			types.add(TechType.Consume);
			types.add(TechType.Ensnare);
			types.add(TechType.Parasite);
			types.add(TechType.Lurker_Aspect);
			break;
		}

		return types;
	}

	/**
	 * Returns a list of the tech types.
	 */
	public static ArrayList<TechTypeWME> getTechTypes() {
		ArrayList<TechTypeWME> types = new ArrayList<TechTypeWME>();
		types.add(new TechTypeWME(0,"Stim_Packs",112,100,100));
		types.add(new TechTypeWME(1,"Lockdown",117,200,200));
		types.add(new TechTypeWME(2,"EMP_Shockwave",116,200,200));
		types.add(new TechTypeWME(3,"Spider_Mines",120,100,100));
		types.add(new TechTypeWME(4,"Scanner_Sweep",228,0,0));
		types.add(new TechTypeWME(5,"Tank_Siege_Mode",120,150,150));
		types.add(new TechTypeWME(6,"Defensive_Matrix",228,0,0));
		types.add(new TechTypeWME(7,"Irradiate",116,200,200));
		types.add(new TechTypeWME(8,"Yamato_Gun",118,100,100));
		types.add(new TechTypeWME(9,"Cloaking_Field",115,150,150));
		types.add(new TechTypeWME(10,"Personnel_Cloaking",117,100,100));
		types.add(new TechTypeWME(11,"Burrowing",131,100,100));
		types.add(new TechTypeWME(12,"Infestation",228,0,0));
		types.add(new TechTypeWME(13,"Spawn_Broodlings",138,100,100));
		types.add(new TechTypeWME(14,"Dark_Swarm",228,0,0));
		types.add(new TechTypeWME(15,"Plague",136,200,200));
		types.add(new TechTypeWME(16,"Consume",136,100,100));
		types.add(new TechTypeWME(17,"Ensnare",138,100,100));
		types.add(new TechTypeWME(18,"Parasite",228,0,0));
		types.add(new TechTypeWME(19,"Psionic_Storm",165,200,200));
		types.add(new TechTypeWME(20,"Hallucination",165,150,150));
		types.add(new TechTypeWME(21,"Recall",170,150,150));
		types.add(new TechTypeWME(22,"Stasis_Field",170,150,150));
		types.add(new TechTypeWME(23,"Archon_Warp",228,0,0));
		types.add(new TechTypeWME(24,"Restoration",228,100,100));
		types.add(new TechTypeWME(25,"Disruption_Web",169,200,200));
		types.add(new TechTypeWME(27,"Mind_Control",165,200,200));
		types.add(new TechTypeWME(28,"Dark_Archon_Meld",228,0,0));
		types.add(new TechTypeWME(29,"Feedback",228,0,0));
		types.add(new TechTypeWME(30,"Optical_Flare",112,100,100));
		types.add(new TechTypeWME(31,"Maelstrom",165,100,100));
		types.add(new TechTypeWME(32,"Lurker_Aspect",135,200,200));
		types.add(new TechTypeWME(34,"Healing",228,0,0));
		types.add(new TechTypeWME(44,"None",228,0,0));
		types.add(new TechTypeWME(45,"Unknown",228,0,0));
		types.add(new TechTypeWME(46,"Nuclear_Strike",228,0,0));
		return types;
	}	
}
