package eisbot.proxy.wmes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

import wm.WME;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.StarCraftConstants;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.model.Player;
import eisbot.proxy.wmes.TechTypeWME.TechType;
import eisbot.proxy.wmes.UpgradeTypeWME.UpgradeType;
import eisbot.proxy.wmes.unit.UnitWME;

/**
 * Stores information about a player
 * 
 * Note: the supply used and supply total variables are double what you would expect, because
 *       small units are represented as 1 supply in StarCraft.
 */
public class PlayerWME extends WME {

	/** the player identifier */
	private int playerID;

	/** current mineral supply */
	private int minerals;
	
	private int mineralHold;
	
	/** current gas supply */
	private int gas;
	
	private int gasHold;
	
	/** amount of supply used by the player */
	private int supplyUsed;

	/** amount of supply provided by the player */
	private int supplyTotal;
	
	/** the players name */
	private String name;
	
	/** the players race */
	private Race race;

	private int raceID;
	
	/** the players type, see http://code.google.com/p/bwapi/wiki/PlayerTypes */
	private int type;

	/** specifies if the player is an ally */
	private boolean ally;

	private boolean[] hasResearched = new boolean[47];
	private boolean[] isResearching = new boolean[47];
	private int[] upgradeLevel = new int[63];
	private boolean[] isUpgrading = new boolean[63];

	/**
	 * Parses the player data.
	 */
	public static ArrayList<PlayerWME> getPlayers(JNIBWAPI bwapi) {
		ArrayList<PlayerWME> players = new ArrayList<PlayerWME>();

		for (Player p : bwapi.getPlayers()) {
			PlayerWME player = new PlayerWME();
			player.playerID = p.getID();
			player.raceID = p.getRaceID();
			player.race = Race.values()[player.raceID];		
			player.name = "Player:" + p.getID();			
			player.type = p.getTypeID();			
			player.ally = p.isAlly();						
			players.add(player);		
		}
		
		return players;
	}

	/**
	 * Updates the players attributes given the command data.
	 */
	public void update(JNIBWAPI bwapi) {		

		minerals = bwapi.getSelf().getMinerals();
		gas = bwapi.getSelf().getGas();
		supplyUsed = bwapi.getSelf().getSupplyUsed();
		supplyTotal = bwapi.getSelf().getSupplyTotal();

		int index = 0;
		for (int level : bwapi.getSelf().getUpgradeLevels()) {
			upgradeLevel[index++] = level;
		}
		
		index = 0;
		for (boolean upgrading : bwapi.getSelf().getUpgradesInProgress()) {
			isUpgrading[index++] = upgrading;
		}

		index = 0;
		for (boolean researched : bwapi.getSelf().getResearchCompleted()) {
			hasResearched[index++] = researched;
		}
		
		index = 0;
		for (boolean researching : bwapi.getSelf().getResearchInProgress()) {
			isResearching[index++] = researching;
		}				
	}
	
	/**
	 * Returns the number of buildings the player has.
	 */
	public int getNumBuildings() {
		int count = 0;

		for (UnitWME unit : ABLStarCraftBot.getGame().getUnits()) {
			if (unit.getPlayerID() == this.playerID && unit.getIsBuilding()) {
				count++;
			}
		}
		
		return count;
	}
	
	public boolean getPsiStorm() {
		return hasResearched(TechType.Psionic_Storm);
	}
	
	public int getProtossArmySize() {
		int count = 0;

		for (UnitWME unit : ABLStarCraftBot.getGame().getUnits()) {
			if (unit.getPlayerID() == this.playerID && 
					(unit.getTypeID()==StarCraftConstants.Protoss_Zealot ||
					 unit.getTypeID()==StarCraftConstants.Protoss_Dragoon ||
					 unit.getTypeID()==StarCraftConstants.Protoss_High_Templar ||
					 unit.getTypeID()==StarCraftConstants.Protoss_Dark_Templar)) {
				count++;
			}
		}
		
		return count;
	}	

	public Point getRandomPylon() {
		ArrayList<UnitWME> pylons = new ArrayList<UnitWME>();
		
		for (UnitWME unit : ABLStarCraftBot.getGame().getUnits()) {
			if (unit.getPlayerID() == this.playerID && unit.getTypeID()==StarCraftConstants.Protoss_Pylon) {
				pylons.add(unit);
			}
		}

		Collections.shuffle(pylons);		
		if (pylons.size() > 0) {
			return new Point(pylons.get(0).getX(), pylons.get(0).getY());
		}
		
		return null;
	}
	
	public boolean canAffordTechType(int typeID) {
		TechTypeWME type = TechTypeWME.getType(typeID);		
		return minerals >= type.getMineralsCost() && gas >- type.getGasCost();
	}

	/**
	 * TODO: factor in the cost of different levels
	 */
	public boolean canAffordUpgradeType(int typeID) {
		UpgradeTypeWME type = UpgradeTypeWME.getType(typeID);		
		return minerals >= type.getMineralsBase() && gas >- type.getGasBase();
	}

	public boolean[] getResearched() {
		return hasResearched;
	}

	public int[] getUpgrades() {
		return upgradeLevel;
	}

	public int upgradeLevel(UpgradeType type) {
		return upgradeLevel[type.ordinal()];
	}

	public boolean isUpgrading(UpgradeType type) {
		return isUpgrading[type.ordinal()];
	}

	public boolean hasResearched(TechType type) {
		return hasResearched[type.ordinal()];
	}

	public boolean isResearching(TechType type) {
		return isResearching[type.ordinal()];
	}

	public boolean getUpgradingVehicleWeapons() {
		return isUpgrading[UpgradeType.Terran_Vehicle_Weapons.ordinal()];
	}

	public int getVehicleWeaponsLevel() {
		return upgradeLevel[UpgradeType.Terran_Vehicle_Weapons.ordinal()];
	}

	public boolean getUpgradingVehicleArmor() {
		return isUpgrading[UpgradeType.Terran_Vehicle_Plating.ordinal()];
	}

	public int getVehicleArmorLevel() {
		return upgradeLevel[UpgradeType.Terran_Vehicle_Plating.ordinal()];
	}
	
	public boolean getIsResearchingSiege() {
		return isResearching[TechType.Tank_Siege_Mode.ordinal()];
	}

	public boolean getHasResearchedSiege() {
		return hasResearched[TechType.Tank_Siege_Mode.ordinal()];
	}

	public boolean getIsResearchingMines() {
		return isResearching[TechType.Spider_Mines.ordinal()];
	}

	public boolean getHasResearchedMines() {
		return hasResearched[TechType.Spider_Mines.ordinal()];
	}

	public boolean getUpgradedDragoonRange() {
		return upgradeLevel[UpgradeType.Singularity_Charge.ordinal()] > 0;
	}

	public boolean getUpgradingDragoonRange() {
		return isUpgrading[UpgradeType.Singularity_Charge.ordinal()];
	}

	public boolean getUpgradedCarrierCapacity() {
		return upgradeLevel[UpgradeType.Carrier_Capacity.ordinal()] > 0;
	}

	public boolean getUpgradingCarrierCapacity() {
		return isUpgrading[UpgradeType.Carrier_Capacity.ordinal()];
	}
	
	public boolean getUpgradedZealotLegs() {
		return upgradeLevel[UpgradeType.Leg_Enhancements.ordinal()] > 0;
	}

	public boolean getUpgradingZealotLegs() {
		return isUpgrading[UpgradeType.Leg_Enhancements.ordinal()];
	}

	public int getWeaponLevel() {
		return upgradeLevel[UpgradeType.Protoss_Ground_Weapons.ordinal()];
	}

	public boolean getUpgradingWeapons() {
		return isUpgrading[UpgradeType.Protoss_Ground_Weapons.ordinal()];
	}
	
	public int getArmorLevel() {
		return upgradeLevel[UpgradeType.Protoss_Armor.ordinal()];
	}

	public boolean getUpgradingArmor() {
		return isUpgrading[UpgradeType.Protoss_Armor.ordinal()];
	}

	/**
	 * Returns if the player is an ally.
	 */
	public boolean isAlly() {
		return ally;
	}
	
	/**
	 * Returns the player's mineral count, only accurate for the bot player.
	 */
	public int getMinerals() {
		return minerals - mineralHold;
	}

	public int getActualMinerals() {
		return minerals;
	}
	
	public int getActualGas() {
		return gas;
	}	
	
	/**
	 * Returns the player's gas count, only accurate for the bot player.
	 */
	public int getGas() {
		return gas - gasHold;
	}
	
	/**
	 * Adds a resource hold to the agent, while constructing buildings
	 */
	public void addResourceHold(int minerals, int gas) {
		this.mineralHold += minerals;
		this.gasHold += gas;
	}
	
	/**
	 * Removes a previous resource hold.
	 */
	public void removeResourceHold(int minerals, int gas) {
		this.mineralHold -= minerals;
		this.gasHold -= gas;
	}

	/**
	 * Gets the current supply used. (Its double the expected value)
	 */
	public int getSupplyUsed() {
		return supplyUsed;
	}

	/**
	 * Gets the current supply provided . (Its double the expected value)
	 */
	public int getSupplyTotal() {
		return supplyTotal;
	}

	/** 
	 * Returns a unique id for the player.
	 */
	public int getPlayerID() {
		return playerID;
	}

	/**
	 * Returns the players race.
	 */
	public String getRace() {
		return race.toString();
	}
	
	public Race getPlayerRace() {
		return race;
	}
	
	/**
	 * Returns the players race ID.
	 */
	public int getRaceID() {
		return raceID;
	}

	public Point getExpoLocation(int tileX, int tileY) {
		double distance = Double.MAX_VALUE;
		int x = 0;
		int y = 0;

		// find the choke
		for (ChokePointWME location : ABLStarCraftBot.getGame().getChokePoints()) {
			int dx = tileX - location.getX()/32;
			int dy = tileY - location.getY()/32;

			double d = Math.sqrt(dx*dx + dy*dy);
			if (d < distance) {
				distance = d;
				x = location.getX()/32;
				y = location.getY()/32;
			}
		}

		distance = Double.MAX_VALUE;
		Point closest = null;

		for (BaseLocationWME location : ABLStarCraftBot.getGame().getBaseLocations()) {
			int dx = x - location.getX();
			int dy = y - location.getY();

			double d = Math.sqrt(dx*dx + dy*dy);
			if (d < distance) {
				distance = d;
				closest = new Point(location.getX(), location.getY());
			}			
		}

		return closest;
	}
	
	public ArrayList<UnitWME> getUnits() {
		ArrayList<UnitWME> myUnits = new ArrayList<UnitWME>();
		ArrayList<UnitWME> allUnits = ABLStarCraftBot.getGame().getUnits();
		for (UnitWME unit : allUnits) {
			if (unit.getPlayerID() == this.playerID) {
				myUnits.add(unit);
			}
		}
		return myUnits;
	}
	
	public int getNumObservers() {
		int count = 0;
		
		ArrayList<UnitWME> allUnits = ABLStarCraftBot.getGame().getUnits();
		for (UnitWME unit : allUnits) {
			if (unit.getPlayerID() == this.playerID && unit.getType().equals(UnitTypeWME.Protoss_Observer)) {
				count++;
			}
		}
		
		return count;
	}

	public StartingLocationWME getStartingLocation() {
		int i;
		ArrayList<UnitWME> playerUnits = this.getUnits();
		ArrayList<StartingLocationWME> startingLocations = ABLStarCraftBot.getGame().getStartingLocations();

		for (UnitWME unit:playerUnits) {
			if (unit.getIsCenter()) {
				i = 0;
				for (StartingLocationWME start:startingLocations) {
					if (start.getX() == unit.getX() && start.getY() == unit.getY()) {
						return start;
					}
					i++;
				}
			}
		}
		return null;
	}

	public String toString() {
		return 
			"mins:" + minerals +
			" gas:" + gas +
			" supplyUsed:" + supplyUsed +
			" supplyTotal:" + supplyTotal;
	}
}