package eisbot.abl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import eisbot.abl.StarCraftConstants.Race;
import eisbot.abl.wmes.ReconWME;
import eisbot.abl.wmes.requests.RequestWME;
import eisbot.cbr.goalforumlator.CaseRetriever;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.filter.NoMemoryFilter;
import eisbot.proxy.filter.ParticleFilter;
import eisbot.proxy.types.UnitType.UnitTypes;
import eisbot.proxy.wmes.BaseLocationWME;
import eisbot.proxy.wmes.ChokePointWME;
import eisbot.proxy.wmes.MapWME;
import eisbot.proxy.wmes.PlayerWME;
import eisbot.proxy.wmes.RegionWME;
import eisbot.proxy.wmes.StartingLocationWME;
import eisbot.proxy.wmes.TechTypeWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.UpgradeTypeWME;
import eisbot.proxy.wmes.unit.AllyUnitWME;
import eisbot.proxy.wmes.unit.EnemyUnitWME;
import eisbot.proxy.wmes.unit.GeyserWME;
import eisbot.proxy.wmes.unit.MineralWME;
import eisbot.proxy.wmes.unit.NeutralUnitWME;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
import eisbot.proxy.wmes.unit.UnitWME;
/**
 * StarCraft AI Interface.
 *
 * Maintains StarCraft state and provides hooks for StarCraft commands.
 *
 * Note: all coordinates are specified in tile coordinates.
 */
public class Game {

	/** the bot's player ID */
	private int playerID;

	/** the bot's race */
	private int playerRace;

	/** player information */
	private PlayerWME player;
	private ArrayList<PlayerWME> enemies = new ArrayList<PlayerWME>();

	/** all players */
	private ArrayList<PlayerWME> players;
	private PlayerWME[] playerArray = new PlayerWME[12];

	/** map information */
	private MapWME map;

	/** a list of the starting locations */
	private ArrayList<StartingLocationWME> startingLocations;
	
	/** The starting location of the bot */
	private StartingLocationWME playerStart = null;
 
	/** a list of the units */
	private ArrayList<UnitWME> units = new ArrayList<UnitWME>();
	private ArrayList<PlayerUnitWME> playerUnits = new ArrayList<PlayerUnitWME>();
	private ArrayList<EnemyUnitWME> enemyUnits = new ArrayList<EnemyUnitWME>();
	private HashMap<Integer, UnitWME> unitMap = new HashMap<Integer, UnitWME>();

	/** StarCraft unit types */
	private HashMap<Integer, UnitTypeWME> unitTypes = UnitTypeWME.getUnitTypeMap();

	/** list of tech types */
	private ArrayList<TechTypeWME> techTypes = TechTypeWME.getTechTypes();

	/** list of upgrade types */
	private ArrayList<UpgradeTypeWME> upgradeTypes = UpgradeTypeWME.getUpgradeTypes();
	
	private ArrayList<RequestWME> buildRequests = new ArrayList<RequestWME>();

//	/** queue of commands to execute */
//	private CommandQueue commandQueue = new CommandQueue();

	/** timestamp of when the game state was last changed */
	private long lastGameUpdate = 0;

	private ArrayList<BaseLocationWME> baseLocations;

	private ArrayList<ChokePointWME> chokePoints;

	private ArrayList<RegionWME> regions;

	int frame = 0; 
	
	private ParticleFilter particleFilter;
	
	private ReconWME recon;

	private CaseRetriever caseRetriever;

	/**
	 * Constructs a game object from the initial information sent from StarCraft.
	 *
	 * The game object will not have units until update is called.
	 * @throws InstantiationException 
	 */
	public Game(JNIBWAPI bwapi) {
    	playerID = bwapi.getSelf().getID();
		players = PlayerWME.getPlayers(bwapi);

		for (PlayerWME p : players) {
			if (playerID == p.getPlayerID()) {
				player = p;
		    	playerRace = Race.valueOf(p.getRace()).ordinal();
			}
			else { 
				enemies.add(p);
			} 

			playerArray[p.getPlayerID()] = p;
		} 

		if (ABLStarCraftBot.IgnoreBases == false) {
			map = new MapWME(bwapi);
			startingLocations = StartingLocationWME.getLocations(bwapi);
			baseLocations = BaseLocationWME.getLocations(bwapi);
			regions = RegionWME.getRegions(map, bwapi);
			chokePoints = ChokePointWME.getLocations(bwapi, regions);
		}
		
  
//		if (Boolean.getBoolean("ParticleFilter")) {
			particleFilter = new ParticleFilter(this, 
					Boolean.getBoolean("IdentifyParticles"), 
					false, 
					Boolean.getBoolean("DefaultParticles"),
					Boolean.getBoolean("UseTargetVector"));
//		}
//		else { 
//			particleFilter = new NoMemoryFilter(this, false, false, false, false);
//		}

		recon = new ReconWME(enemies.get(0).getPlayerRace());
		particleFilter.start();
	} 
 
	public void setCaseRetriever(CaseRetriever caseRetriever) {
		this.caseRetriever = caseRetriever;
		 
		if (enemies.size() > 0) { 
			caseRetriever.start(Race.valueOf(player.getRace()), Race.valueOf(enemies.get(0).getRace()));
		}
	} 
	
	public Race getEnemyRace() {
		return enemies.get(0).getPlayerRace();
	}
	
	public CaseRetriever getCaseRetriever() {
		return caseRetriever;
	}
	
	public void stop() {
		particleFilter.stop();
	}

//	/**
//	 * Wake up the game thread with a null update.
//	 */
//	public void stop() {
//		synchronized(this) {
//			update = null;
//			this.notify();
//		}
//	}

//	/**
//	 * Returns the command queue.
//	 */
//	public CommandQueue getCommandQueue() {
//		return commandQueue;
//	}

	public void newBlockage(int x, int y) {
		NeutralUnitWME blockage = new NeutralUnitWME();
		blockage.setBlockage(getUnitTypes().get(StarCraftConstants.Critter_Rhynadon) , x, y);
		
		synchronized(units) {
			units.add(blockage);
		}
	}
	
	public int getGameFrame() {
		return frame;
	}

//	public void update(String updateData) {
//		this.update = updateData;
//
//		synchronized(this) {
//			this.notify();
//		}
//	}
	
	public void processedBuildRequest(RequestWME request) {
		buildRequests.add(request);
	}
	
	public ArrayList<RequestWME> getBuildRequests() {
		return buildRequests;
	}

	/**
	 * Updates the state of the game.
	 */
	public void update(JNIBWAPI bwapi) {
		frame = bwapi.getFrameCount();
		player.update(bwapi);
		lastGameUpdate = System.currentTimeMillis();
		
		synchronized(units) {
			units = UnitWME.getUnits(this, bwapi, unitTypes, playerID, playerArray);
			HashMap<Integer, UnitWME> newMap = new HashMap<Integer, UnitWME>();
		
			for (UnitWME unit : units) {
				newMap.put(unit.getID(), unit);
			}
			
			unitMap = newMap;
		}

		ArrayList<PlayerUnitWME> newPlayerUnits = new ArrayList<PlayerUnitWME>();
		ArrayList<EnemyUnitWME> newEnemyUnits = new ArrayList<EnemyUnitWME>();
		
		for (UnitWME unit : units) {
			if (unit.getSpawnFrame() == 0) {
				unit.setSpawnFrame(frame);
			}
			
			if (unit instanceof PlayerUnitWME) {
				newPlayerUnits.add((PlayerUnitWME)unit);
			}
			else if (unit instanceof EnemyUnitWME) {
				newEnemyUnits.add((EnemyUnitWME)unit);
			}
		}
 
		playerUnits = newPlayerUnits;
		enemyUnits = newEnemyUnits;

		recon.update(this);
		    
		if (map != null) { 
			map.updateCreep(bwapi.getCreepSpread());
		}
	}

	/**
	 * Returns the time when the game state was last updated.
	 */
	public long getLastGameUpdate() {
		return lastGameUpdate;
	}

	public ParticleFilter getParticleFilter() {
		return particleFilter;
	}
	
	public ReconWME getRecon() {
		return recon;
	}
	
	/**
	 * Returns a player object for the bot.
	 */
	public PlayerWME getPlayer() {
		return player;
	}
	
	public ArrayList<PlayerWME> getEnemies() {
		return enemies;
	}

	/**
	 * Returns the bots race.
	 */
	public int getPlayerRace() {
		return playerRace;
	}

	/**
	 * Returns a PlayerWME with the given PlayerID. Crashes if no such player exists.
	 */
	public PlayerWME getPlayerByID(int id) {
		return playerArray[id];
	}

	/**
	 * Returns the Map data.
	 */
	public MapWME getMap() {
		return map;
	}

	/**
	 * Returns a map of the tech types indexed by ID.
	 */
	public HashMap<Integer, UnitTypeWME> getUnitTypes() {
		return unitTypes;
	}

	/**
	 * Returns the starting locations.
	 */
	public ArrayList<StartingLocationWME> getStartingLocations() {
		return startingLocations;
	}

	private void findPlayerStart() {
		if (playerStart != null) {
			return;
		}
		ArrayList<PlayerUnitWME> playerUnits = this.getPlayerUnits();

		for (PlayerUnitWME unit:playerUnits) {
			if (unit.getIsCenter()) {
				for (StartingLocationWME start:startingLocations) {
					if (start.getX() == (unit.getRealCenterX()/32) && start.getY() == (unit.getRealCenterY()/32)) {
						playerStart = start;
						return;
					}
				}
			}
		}
		playerStart = null;
	}

	/**
	 * Returns the player's starting location.
	 */
	public StartingLocationWME getPlayerStart() {
		this.findPlayerStart();
		return playerStart;
	}

	/**
	 * Returns the enemy's starting location, or null if it's unknown.
	 * If there are multiple enemy sides, it returns the start location of an arbitrary enemy.
	 */
	public StartingLocationWME getEnemyStart() {
		int i;
		ArrayList<EnemyUnitWME> enemyUnits = this.getEnemyUnits();
		ArrayList<StartingLocationWME> startingLocations = this.getStartingLocations();

		for (EnemyUnitWME unit:enemyUnits) {
			if (unit.getIsCenter()) {
				i = 0;
				for (StartingLocationWME start:startingLocations) {
					if (start.getX() == (unit.getRealCenterX()/32) && start.getY() == (unit.getRealCenterY()/32)) {
						return start;
					}
					i++;
				}
			}
		}
		return null;
	}

	/** 
	 * Gets all units
	 */
	public ArrayList<UnitWME> getUnits() {
		return units;
	}

	public ArrayList<ChokePointWME> getChokePoints() {
		return chokePoints;
	}

	public ArrayList<RegionWME> getRegions() {
		return regions;
	}

	public ArrayList<BaseLocationWME> getBaseLocations() {
		return baseLocations;
	}

	/**
	 * Returns a list of the bots units.
	 */
	public ArrayList<PlayerUnitWME> getPlayerUnits() {
//		synchronized(units) {
//		
//			ArrayList<PlayerUnitWME> playerUnits = new ArrayList<PlayerUnitWME>();
//			for (UnitWME unit : units) {
//				if (unit instanceof PlayerUnitWME) {
//					playerUnits.add((PlayerUnitWME)unit);
//				}
//			}
//	
//			return playerUnits;
//		}
		
		return playerUnits;
	}

	public ArrayList<UnitWME> getExpansions() {
		TreeMap<Integer, UnitWME> expos = new TreeMap<Integer, UnitWME>();
		
		for (UnitWME unit : units) {
			if (unit instanceof PlayerUnitWME && unit.getTypeID() == UnitTypes.Protoss_Nexus.ordinal()) {
				expos.put(unit.getID(), unit);
			}
		} 
		
		if (expos.size() > 0) {
			expos.remove(expos.firstKey());
		}
		
		return new ArrayList<UnitWME>(expos.values()); 
	}
	
	public UnitWME getUnitByID(int id) {
		return unitMap.get(id);
	}

	/**
	 * Returns a list of enemy units.
	 */
	public ArrayList<EnemyUnitWME> getEnemyUnits() {
//		synchronized(units) {
//		
//			ArrayList<EnemyUnitWME> enemyUnits = new ArrayList<EnemyUnitWME>();
//			for (UnitWME unit : units) {
//				if (unit instanceof EnemyUnitWME) {
//					enemyUnits.add((EnemyUnitWME)unit);
//				}
//			}
//
//			return enemyUnits;
//		}
		
		return enemyUnits;
	}

	/**
	 * Returns a list of allied units.
	 */
	public ArrayList<AllyUnitWME> getAllyUnits() {
		synchronized(units) {
			
			ArrayList<AllyUnitWME> allyUnits = new ArrayList<AllyUnitWME>();
			for (UnitWME unit : units) {
				if (unit instanceof AllyUnitWME) {
					allyUnits.add((AllyUnitWME)unit);
				}
			}
	
			return allyUnits;
		}
	}

	public ArrayList<NeutralUnitWME> getNeutralUnits() {
		synchronized(units) {
		
			ArrayList<NeutralUnitWME> neutralUnits = new ArrayList<NeutralUnitWME>();
			for (UnitWME unit : units) {
				if (unit instanceof NeutralUnitWME) {
					neutralUnits.add((NeutralUnitWME)unit);
				}
			}
	
			return neutralUnits;
		}
	}
	
	/**
	 * Returns the mineral patches.
	 */
	public ArrayList<MineralWME> getMinerals() {
		synchronized(units) {
		
			ArrayList<MineralWME> minerals= new ArrayList<MineralWME>();
			for (UnitWME unit : units) {
				if (unit instanceof MineralWME) {
					minerals.add((MineralWME)unit);
				}
			}
	
			return minerals;
		}
	}

	/**
	 * Returns the list of geysers.
	 */
	public ArrayList<GeyserWME> getGeysers() {
		synchronized(units) {

			ArrayList<GeyserWME> gas = new ArrayList<GeyserWME>();
			for (UnitWME unit : units) {
				if (unit instanceof GeyserWME) {
					gas.add((GeyserWME)unit);
				}
			}
	
			return gas;
		}
	}

	/**
	 * Returns the tech types.
	 */
	public ArrayList<TechTypeWME> getTechTypes() {
		return techTypes;
	}

	/**
	 * Returns the upgrade types.
	 */
	public ArrayList<UpgradeTypeWME> getUpgradeTypes() {
		return upgradeTypes;
	}
}
