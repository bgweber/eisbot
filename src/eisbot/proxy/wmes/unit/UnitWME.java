package eisbot.proxy.wmes.unit;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import wm.WME;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.abl.StarCraftConstants;
import eisbot.abl.wmes.SquadWME;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.model.Player;
import eisbot.proxy.model.Unit;
import eisbot.proxy.wmes.PlayerWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;
import eisbot.proxy.wmes.unit.protoss.ArbitorWME;
import eisbot.proxy.wmes.unit.protoss.ArchivesWME;
import eisbot.proxy.wmes.unit.protoss.ArchonWME;
import eisbot.proxy.wmes.unit.protoss.AssimilatorWME;
import eisbot.proxy.wmes.unit.protoss.CannonWME;
import eisbot.proxy.wmes.unit.protoss.CarrierWME;
import eisbot.proxy.wmes.unit.protoss.CitadelWME;
import eisbot.proxy.wmes.unit.protoss.CorsairWME;
import eisbot.proxy.wmes.unit.protoss.CyberneticsCoreWME;
import eisbot.proxy.wmes.unit.protoss.DarkArchonWME;
import eisbot.proxy.wmes.unit.protoss.DarkTemplarWME;
import eisbot.proxy.wmes.unit.protoss.DragoonWME;
import eisbot.proxy.wmes.unit.protoss.FleetBeaconWME;
import eisbot.proxy.wmes.unit.protoss.ForgeWME;
import eisbot.proxy.wmes.unit.protoss.GatewayWME;
import eisbot.proxy.wmes.unit.protoss.HighTemplarWME;
import eisbot.proxy.wmes.unit.protoss.NexusWME;
import eisbot.proxy.wmes.unit.protoss.ObservatoryWME;
import eisbot.proxy.wmes.unit.protoss.ObserverWME;
import eisbot.proxy.wmes.unit.protoss.ProbeWME;
import eisbot.proxy.wmes.unit.protoss.PylonWME;
import eisbot.proxy.wmes.unit.protoss.ReaverWME;
import eisbot.proxy.wmes.unit.protoss.RoboticsFacilityWME;
import eisbot.proxy.wmes.unit.protoss.ScoutWME;
import eisbot.proxy.wmes.unit.protoss.ShuttleWME;
import eisbot.proxy.wmes.unit.protoss.StargateWME;
import eisbot.proxy.wmes.unit.protoss.SupportBayWME;
import eisbot.proxy.wmes.unit.protoss.TribunalWME;
import eisbot.proxy.wmes.unit.protoss.ZealotWME;
/**
 * Represents a unit in StarCraft.
 */
public class UnitWME extends WME {
	
	/** a unique identifier for referencing the unit */
	protected int ID = StarCraftConstants.NULL_UNIT;
	
	/** the player the unit belongs too */
	private int playerID;

	/** the unit type */
	protected UnitTypeWME type;
	
	int width;
	int height;	
 	
	private boolean merged;
	private boolean trapped = false; 
	
	/** x tile position */
	protected int x;
	private int realX;
	private int realCenterX;
	
	/** y tile position */
	protected int y;
	private int realY;
	private int realCenterY;

	/** unit hit points */
	private int hitPoints;
	
	/** unit shields */
	private int shields;
	
	/** unit energy */
	private int energy;
	
	/** an internal timer used in StarCraft */
	private int orderTimer;

	/** for vultures only */
	protected int mineCount = 0;
	
	private int buildTimer;
	private int trainTimer;
	private int researchTimer;
	private int upgradeTimer;

	int target;
	int orderTarget;
	int targetX;
	int targetY;
	int targetRealX;
	int targetRealY;
	boolean active = false;
	boolean burrowed;
	boolean cloaked;
	boolean powered;
	int interceptorCount;
	int scarabCount;
	int attackTargetX;
	int attackTargetY;
	int numLoadedUnits;
	boolean carryingMinerals;
	
	int spawnFrame = 0;
	int lastMoved = 0;
	
	private int groundCooldown;
	private int airCooldown;
	private int trainingQueueSize;	
	int purpose;
	
	/**
	 * Order type currently being executed by the unit.
	 * @See the Order enum in Constants.java
	 */
	private int order;
	
	/** Whether or not the unit is lifted (if it's a building that can lift; it's false otherwise) */
	private boolean lifted;

	/** resources remaining, mineral count for patches, and gas for geysers */ 
	private int resources;
	
	private int addonID;

	/**
	 * Parses the unit data.
	 */
	public static ArrayList<UnitWME> getUnits(Game game, JNIBWAPI bwapi, HashMap<Integer, UnitTypeWME> types, 
			int playerID, PlayerWME[] players1) {
		
		ArrayList<UnitWME> units = new ArrayList<UnitWME>();		
				
		for (Unit u : bwapi.getAllUnits()) {

			int ID = u.getID();
			UnitWME unit = game.getUnitByID(ID);			
						
			int pID = u.getPlayerID();
			int type = u.getTypeID();
			Player player = bwapi.getPlayer(pID);
			boolean newUnit = false;
			
			// allow units to change type
			if (unit != null && unit.getTypeID() != type) {
				unit = null;
			}
			
			if (unit == null) {
				if (player.isSelf()) {
					newUnit = true;
					
					switch (type) {
					case StarCraftConstants.Protoss_Assimilator:
						unit = new AssimilatorWME();
						break;
					case StarCraftConstants.Protoss_Photon_Cannon:
						unit = new CannonWME();
						break;
					case StarCraftConstants.Protoss_Cybernetics_Core:
						unit = new CyberneticsCoreWME();
						break;
					case StarCraftConstants.Protoss_Dragoon:
						unit = new DragoonWME();
						break;
					case StarCraftConstants.Protoss_Forge:
						unit = new ForgeWME();
						break;
					case StarCraftConstants.Protoss_Gateway:
						unit = new GatewayWME();
						break;
					case StarCraftConstants.Protoss_Nexus:
						for (UnitWME nexus : game.getUnits()) {
							if (nexus instanceof NexusWME) {
								((NexusWME)nexus).clearNewest();
							}
						}
						
						unit = new NexusWME();
						((NexusWME)unit).setNewest();
						break;
					case StarCraftConstants.Protoss_Probe:
						unit = new ProbeWME();
						break;
					case StarCraftConstants.Protoss_Pylon:
						unit = new PylonWME();
						break;
					case StarCraftConstants.Protoss_Zealot:
						unit = new ZealotWME();
						break; 
					case StarCraftConstants.Protoss_Robotics_Facility:
						unit = new RoboticsFacilityWME();
						break;
					case StarCraftConstants.Protoss_Observatory:
						unit = new ObservatoryWME();
						break;
					case StarCraftConstants.Protoss_Observer:
						unit = new ObserverWME();
						break;
					case StarCraftConstants.Protoss_Citadel_of_Adun:
						unit = new CitadelWME();
						break;
					case StarCraftConstants.Protoss_Templar_Archives:
						unit = new ArchivesWME();
						break;
					case StarCraftConstants.Protoss_Stargate:
						unit = new StargateWME();
						break;
					case StarCraftConstants.Protoss_Fleet_Beacon:
						unit = new FleetBeaconWME();
						break;
					case StarCraftConstants.Protoss_Carrier:
						unit = new CarrierWME();
						break;
					case StarCraftConstants.Protoss_Scout:
						unit = new ScoutWME();
						break;
					case StarCraftConstants.Protoss_Arbiter:
						unit = new ArbitorWME();
						break;
					case StarCraftConstants.Protoss_Archon:
						unit = new ArchonWME();
						break;
					case StarCraftConstants.Protoss_Dark_Archon:
						unit = new DarkArchonWME();
						break;
					case StarCraftConstants.Protoss_High_Templar:
						unit = new HighTemplarWME();
						break;
					case StarCraftConstants.Protoss_Dark_Templar:
						unit = new DarkTemplarWME();
						break;
					case StarCraftConstants.Protoss_Corsair:
						unit = new CorsairWME();
						break;
					case StarCraftConstants.Protoss_Reaver:
						unit = new ReaverWME();
						break;
					case StarCraftConstants.Protoss_Shuttle:
						unit = new ShuttleWME();
						break;
					case StarCraftConstants.Protoss_Robotics_Support_Bay:
						unit = new SupportBayWME();
						break;
					case StarCraftConstants.Protoss_Arbiter_Tribunal:
						unit = new TribunalWME();
						break;
					// TODO: additional unit types
					default:
						unit = new PlayerUnitWME();
						break;
					}
				}
				else if (type == UnitType.Resource_Mineral_Field.ordinal()) {
					unit = new MineralWME();
				}
				else if (type == UnitType.Resource_Vespene_Geyser.ordinal()) {
					unit = new GeyserWME();
				}
				else if (player.isEnemy()) {
					unit = new EnemyUnitWME();
				}
				else if (player.isAlly()) {
					unit = new AllyUnitWME();
				}
				else if (player.isNeutral()) {
					unit = new NeutralUnitWME();
					
					if (type == 36) {
						unit = new NeutralEggWME(); 
					}
				}				
			} 
			
			unit.ID = ID;
			unit.playerID = pID;
			unit.type = types.get(type);
			unit.realX = u.getX() - bwapi.getUnitType(type).getDimensionLeft() - 1;
			unit.realY = u.getY() - bwapi.getUnitType(type).getDimensionUp() - 1;
			unit.realCenterX = u.getX();
			unit.realCenterY = u.getY();
//			unit.realX = u.getX();
//			unit.realY = u.getY();
//			unit.realCenterX = unit.realX + bwapi.getUnitType(type).getDimensionLeft();
//			unit.realCenterY = unit.realY + bwapi.getUnitType(type).getDimensionUp();
			unit.hitPoints = u.getHitPoints();
			unit.shields = u.getShield();
			unit.energy = u.getEnergy();
			unit.buildTimer = u.getRemainingBuildTimer();
			unit.trainTimer = u.getRemainingTrainTime();
			unit.researchTimer = u.getRemainingResearchTime();
			unit.upgradeTimer = u.getRemainingUpgradeTime();
			unit.orderTimer = u.getOrderTimer();
			unit.order = u.getOrderID();
			unit.lifted = u.isLifted();
			unit.resources = u.getResources();
			unit.addonID = u.getAddOnID();
			unit.mineCount = u.getSpiderMineCount();
			unit.target = u.getTargetUnitID();
			unit.orderTarget = u.getOrderTargetID();
			
			if (unit.type != null) {
				units.add(unit);
			}
			
			unit.active = (u.getRemainingBuildTimer() == 0 && u.isCompleted());
			unit.groundCooldown = u.getGroundWeaponCooldown();
			unit.airCooldown = u.getAirWeaponCooldown();
			unit.targetRealX = u.getTargetX();
			unit.targetX = u.getTargetX()/32;
			unit.targetRealY = u.getTargetY();
			unit.targetY = u.getTargetY()/32;
			unit.burrowed = u.isBurrowed();
			unit.cloaked= u.isCloaked();
			unit.powered = !u.isUnpowered();
			unit.interceptorCount = u.getInterceptorCount();
			unit.scarabCount = u.getScarabCount();
			unit.numLoadedUnits = u.getNumLoadedUnits();
			unit.trainingQueueSize = u.getTrainingQueueSize();
			unit.carryingMinerals = u.isCarryingMinerals();
			
			unit.width = 2*bwapi.getUnitType(type).getDimensionLeft();
			unit.height = 2*bwapi.getUnitType(type).getDimensionUp();
			
			if (unit.getIsBuilding() || unit.getIsResource()) {
				unit.x = (unit.realX + 1)/32;
				unit.y = (unit.realY + 1)/32;
			} else {
				unit.x = (unit.realCenterX)/32;
				unit.y = (unit.realCenterY)/32;
			}
			
			if (newUnit && unit instanceof PlayerUnitWME) {
				((PlayerUnitWME)unit).setPreviousHealth();
			}
		}

		// maintain blockages
		for (NeutralUnitWME unit : game.getNeutralUnits()) {
			if (unit.isBlockage()) {
				units.add(unit);
			}
		}

		return units;
	}  

	// closest tile distance to a player unit 
	public static int friendlyDistance(int ex, int ey) { 
		int closest = 256;
		
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) { 
			int distance = Math.max(Math.abs(unit.getX() - ex), Math.abs(unit.getY() - ey)); 
			closest = Math.min(distance, closest); 
		}  
		 
		return closest; 
	}

	public boolean getCarryingMinerals() {
		return carryingMinerals;		
	}
	
	public boolean getCanAttackAir() {
		return type.getAirDamage() > 0;
	}

	public boolean getCanAttackGround() {
		return type.getGroundDamage() > 0;
	}
 
	public int getNumLoadedUnits() {
		return numLoadedUnits;
	}
  
	public int getTrainingQueueSize() {
		return trainingQueueSize;
	}

	public int getPurpose() { 
		return purpose;
	} 
	
	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}
	   
	public boolean getIsCaster() { 
		return type.getId() == StarCraftConstants.Protoss_High_Templar	||
				type.getId() == StarCraftConstants.Protoss_Dark_Archon ||
				type.getId() == StarCraftConstants.Protoss_Arbiter; 
	} 
	
	public void setMerged() {
		merged = true;
	}

	public void setNotMerged() {
		merged = false; 
	}

	public boolean getMerged() {
		return merged;
	}

	public int getInterceptorCount() {
		return interceptorCount;
	}

	public int getScarabCount() {
		return scarabCount;
	}

	public int getAttackTargetX() {
		return attackTargetX;
	}

	public void setAttackTargetX(int attackTargetX) {
		this.attackTargetX = attackTargetX;
	}
 
	public int getAttackTargetY() {
		return attackTargetY;
	}

	public void setAttackTargetY(int attackTargetY) {
		this.attackTargetY = attackTargetY;
	}
		
	public int getLastMoved() {
		return lastMoved;
	}

	public int getSpawnFrame() {
		return spawnFrame;
	}
	
	public void setSpawnFrame(int spawnFrame) {
		this.spawnFrame = spawnFrame;
	}
	
	public int getNearestEnemy() {
		double closest = Double.MAX_VALUE;
		
		for (EnemyUnitWME enemy : ABLStarCraftBot.getGame().getEnemyUnits()) {
			double dx = Math.abs(enemy.x - x); 
			double dy = Math.abs(enemy.y - y);
			double dist = Math.sqrt(dx*dx + dy*dy);

			double x = Math.abs(1- - 1); 

			if (dist < closest) {
				closest = dist;
			}
		}
		
		return (int)closest;
	}
	
	public void setLastMoved(int frame) {
		lastMoved = frame;
	}
	
	public boolean getPowered() {
		return powered;
	}
	
	public boolean getBurrowedOrCloaked() {
		return burrowed || cloaked;
	}

	public boolean getBurrowed() {
		return burrowed;
	}

	public boolean getCloaked() {
		return cloaked;
	}

	public int getTargetX() {
		return targetX;
	}

	public int getTargetRealX() {
		return targetRealX;
	}

	public int getTargetY() {
		return targetY;
	}

	public int getTargetRealY() {
		return targetRealY;
	}

	public int getGroundCooldown() {
		return groundCooldown;
	}
	
	public int getAirCooldown() {
		return airCooldown;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	 
	public void setTrapped() {
		trapped = true; 
	}
	
	public boolean getActive() {
		return active && powered && !trapped;
	}
	
	public boolean getIsSpellCaster() {
		return type.isSpellCaster();
	}
		
	public int getTarget() {
		return target;
	}

	public int getOrderTarget() {
		return orderTarget; 
	}

	public boolean getIsResource() {
		return (type != null) ? type.getIsResource() : false;
	}

	public boolean getIsBuilding() {  
		return (type != null) ? type.getIsBuilding() || getTypeID()==StarCraftConstants.Zerg_Larva || getTypeID()==StarCraftConstants.Zerg_Egg : false;
	}
	
	public int getMineCount() {
		return mineCount; 
	}

	public int getAddonID() {
		return addonID;
	}
	
	public boolean getIsBuilt() {
		return buildTimer == 0;
	}
	
	public static double distance(double x1, double y1, double x2, double y2) {
		final double dx = x1 - x2;
		final double dy = y1 - y2;
		return Math.sqrt(dx*dx + dy*dy);
	}
 
	public static double distance(double x, double y, SquadWME squad) {
		Point center = squad.getCenter(false);
		 
		if (center != null) {
			return distance(x, y, center.x, center.y);
		}
		else {
			return Double.MAX_VALUE;
		}
	}

	public final double distance(double x, double y) {
		final double dx = this.x - x;
		final double dy = this.y - y;
		return Math.sqrt(dx*dx + dy*dy);
	}
 	
	/**
	 * Returns the Euclidian distance to the specified unit.
	 */
	public double distance(UnitWME unit) {
		double dx = unit.x - x;
		double dy = unit.y - y;
		
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	/**
	 * Returns the unit ID.
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Returns if the unit is a worker type.
	 */
	public boolean getIsWorker() {
		return type.isWorker();
	}
	
	/**
	 * Returns whether the unit is a center type.
	 */
	public boolean getIsCenter() {
		return type.isCenter();
	}

	/**
	 * Returns whether the unit is a farm type.
	 */
	public boolean getIsFarm() {
		return type.isFarm();
	}

	public boolean getIsAirborne() {
		return this.getIsFlyer() || (this.getIsBuilding() && this.getIsLifted());
	}

	public boolean getIsFlyer() {
		return type.isFlyer();
	}

	public boolean getIsLifted() {
		return this.lifted;
	}

	/**
	 * Returns the id of the player controlling the unit.
	 * @return
	 */
	public int getPlayerID() {
		return playerID;
	}

	/**
	 * Returns the unit type.
	 */
	public UnitTypeWME getType() {
		return type;
	}

	/**
	 * Returns the type ID.
	 */
	public int getTypeID() {
		return (type != null) ? type.getId() : -1;
	}

	/**
	 * Returns the units x position (tile coordinates)
	 */
	public int getX() {
		return x;
	}

	public int getRealX() {
		return realX;
	}

	public int getRealCenterX() {
		return realCenterX;
	}

	/**
	 * Returns the units y position (tile coordinates)
	 */	
	public int getY() {
		return y;
	}

	public int getRealY() {
		return realY;
	}

	public int getRealCenterY() {
		return realCenterY;
	}

	/**
	 * Returns the units health
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * Returns the units shield energy.
	 */
	public int getShields() {
		return shields;
	}

	/**
	 * Returns the amount of energy (mana) the unit has.
	 */
	public int getEnergy() {
		return energy;
	}

	/**
	 * Returns the ID of the order the unit is currently executing.
	 */
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getOrderTimer() {
		return orderTimer;
	}

	public int getBuildTimer() {
		return buildTimer;	
	}
	public int getTrainTimer() {
		return trainTimer;
	}
	
	public int getResearchTimer() {
		return researchTimer;
	}
	
	public int getUpgradeTimer() {
		return upgradeTimer;
	}
	
	/**
	 * Specifies the amount of resources remaining (for mineral patches and geysers)
	 */
	public int getResources() {
		return resources;
	}
	
	public String toString() {
		return 
			"ID:" + ID +
			" player:" + playerID +
			" type:" + type.getName() +
			" x:" + x +
			" y:" + y +
			" hitPoints:" + hitPoints +
			" shields:" + shields +
			" enemy:" + energy +
			" orderTimer:" + orderTimer +
			" order:" + order + 
			" resource:" + resources;
	}
}
