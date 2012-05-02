package eisbot.proxy.wmes.unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import wm.WME;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.wmes.AllMineralsWME;
/**
 * Represents a bot-controlled unit.
 */
public class PlayerUnitWME extends UnitWME {
	
	public enum WorkerTask { IDLE, MINING, GAS, CONSTRUCTING, SCOUTING, DEFEND, CLEAR }

	public enum FighterTask { IDLE, GUARD, ATTACK, FLEE, REGROUP, GATHER, EGG }

	int task = WorkerTask.IDLE.ordinal();
	int rally;
	int supportUnit;
	boolean spawnedGoal;
	boolean cantProduce;
	boolean hasTask;
	boolean hasDanced;
	int squadID = 0;
	
	private PlayerUnitWME nexus;

	// asssimilator objects
	private HashSet<Integer> workers = new HashSet<Integer>();
	private int targetWorkers = 3;

	int previousHealth;
	
	public void setPreviousHealth() {
		this.previousHealth = getHealth();
	}
	
	public int getPreviousHealth() {
		return previousHealth;
	}
	
	public int getHealth() {
		return getHitPoints() + getShields();
	}
	
	public boolean getTakenDamage() {
		return getHealth() < getPreviousHealth();
	}
	
	public boolean getTakenHeavyDamage() {
		return getHealth() < getPreviousHealth() - 15;
	}

	public int getTask() {
		return task;
	}
	
	public PlayerUnitWME getNexus() {
		return nexus;
	}
	
	public void setNexus(PlayerUnitWME nexus) {
		this.nexus = nexus;
	} 
	
	public int getTargetWorkers() {
		return targetWorkers;
	}
	
	public void setTargetWorkers(int targetWorkers) {
		this.targetWorkers = targetWorkers;
	}
	
	public int getNumWorkers() {
		return workers.size();
	}

	public void freeWorker(int workerID) {
		workers.remove(workerID);
	}
	
	public boolean getIsAssigned(int workerID) {
		return workers.contains(workerID);
	}
	
	public void addWorker(int workerID) {
		workers.add(workerID);
	}
	
	public ArrayList<Integer> getWorkerList() {
		return new ArrayList<Integer>(workers);
	}
	
	public void setTask(int status) {		
		task = status;
	}
	
	public void setRally() {
		rally++;
	}
	
	/**
	 * Require the unit to set the rally point 3 times
	 */
	public boolean getRallySet() {
		return rally > 2;
	}

	public int getSquadID() {
		return squadID;
	} 
	
	public void setSquadID(int squadID) {
		this.squadID = squadID;
	}
	
	
	public int getSupportUnit() {
		return supportUnit;
	}
	
	public void setSupportUnit(int supportUnit) {
		this.supportUnit = supportUnit;	}
	
	public boolean getSpawnedGoal() {
		return spawnedGoal;
	}
	
	public void spawnedGoal() {
		spawnedGoal = true;
	}
	
	public boolean getHasTask() {
		return hasTask;
	}
	
	public void hasTask() {
		hasTask = true;
	}	
	
	public boolean getHasDanced() {
		return hasDanced;
	}
	
	public void hasDanced() {
		hasDanced = true;
	}	
	
	public void clearTask() {
		hasDanced = false;
	}
	
	public void cantProduce() {
		cantProduce = true;
	}
	
	public boolean getCanProduce() {
		return !cantProduce;
	}

	@SuppressWarnings("unchecked")
	public int getMiningWorkers() {
		LinkedList<WME> wmes = ABLStarCraftBot.getBehavingEntity().lookupWME("AllMineralsWME");
		if (wmes.isEmpty()) {
			return 0;
		}
		AllMineralsWME minerals = (AllMineralsWME) wmes.get(0);
		return minerals.getNumWorkers(ID);
	}

	@SuppressWarnings("unchecked")
	public double getSaturation() {
		LinkedList<WME> wmes = ABLStarCraftBot.getBehavingEntity().lookupWME("AllMineralsWME");
		if (wmes.isEmpty()) {
			return 0;
		}
		AllMineralsWME minerals = (AllMineralsWME) wmes.get(0);
		return minerals.getSaturation(ID);
	}

	public boolean getSaturated() {
		return this.getSaturation() >= 1;
	}
}