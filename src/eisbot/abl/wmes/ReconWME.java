package eisbot.abl.wmes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import wm.WME;
import abl.runtime.BehavingEntity;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.abl.StarCraftConstants;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.abl.wmes.prediction.TechPredictionWME;
import eisbot.abl.wmes.prediction.UnitPredictionWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.unit.AllyUnitWME;
import eisbot.proxy.wmes.unit.EnemyUnitWME;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
import eisbot.proxy.wmes.unit.protoss.AttackUnitWME;

public class ReconWME extends WME {

	Map<Integer, Integer> activePlayerCounts = new HashMap<Integer, Integer>();
	Map<Integer, Integer> allPlayerCounts = new HashMap<Integer, Integer>();
	Map<Integer, Integer> allyCounts = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> unitTimings = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> enemyTypes = new HashMap<Integer, Integer>();
	HashSet<Integer> currentEnemyTypes = new HashSet<Integer>();
	
	int supplyUsed = 0;
	 
	public ReconWME(Race enemyRace) { 
		switch (enemyRace) {
		case Protoss:
			enemyTypes.put(StarCraftConstants.Protoss_Nexus, 0);
			enemyTypes.put(StarCraftConstants.Protoss_Probe, 0);
			break;
		case Terran: 
			enemyTypes.put(StarCraftConstants.Terran_Command_Center, 0);
			enemyTypes.put(StarCraftConstants.Terran_SCV, 0); 
			break;
		case Zerg:
			enemyTypes.put(StarCraftConstants.Zerg_Hatchery, 0);
			enemyTypes.put(StarCraftConstants.Zerg_Drone, 0);
			enemyTypes.put(StarCraftConstants.Zerg_Overlord, 0);
			break;
		}
	}
	 
	public void update(Game game) {
		supplyUsed = game.getPlayer().getSupplyUsed();
		
		Map<Integer, Integer> newAllPlayerCounts = new HashMap<Integer, Integer>();
		Map<Integer, Integer> newActivePlayerCounts = new HashMap<Integer, Integer>();

		for (PlayerUnitWME unit : game.getPlayerUnits()) {				
			if (!unitTimings.containsKey(unit.getTypeID())) {
				unitTimings.put(unit.getTypeID(), game.getGameFrame());
			}
			  
			if (unit.getActive()) {
				Integer count = newActivePlayerCounts.get(unit.getTypeID());
				newActivePlayerCounts.put(unit.getTypeID(), 1 + (count != null ? count : 0));
			}
			
			Integer count = newAllPlayerCounts.get(unit.getTypeID());
			newAllPlayerCounts.put(unit.getTypeID(), 1 + (count != null ? count : 0));
		}
		
		allPlayerCounts = newAllPlayerCounts;
		activePlayerCounts = newActivePlayerCounts;

		Map<Integer, Integer> newAllyCounts = new HashMap<Integer, Integer>();

		newAllyCounts.clear();
		for (AllyUnitWME unit : game.getAllyUnits()) {
			Integer count = newAllyCounts.get(unit.getTypeID());
			newAllyCounts.put(unit.getTypeID(), 1 + (count != null ? count : 0));
		}

		allyCounts = newAllyCounts;
			
		HashSet<Integer> currentTypes = new HashSet<Integer>();
		for (EnemyUnitWME unit : game.getEnemyUnits()) {
			currentTypes.add(unit.getTypeID());
 			
			if (!enemyTypes.containsKey(unit.getTypeID())) {
				enemyTypes.put(unit.getTypeID(), game.getGameFrame());
			}
			
			// also add pre-req types
			UnitTypeWME type = game.getUnitTypes().get(unit.getTypeID());
			if (type != null) {
				if (type.getWhatBuilds() != -1 && !enemyTypes.containsKey(type.getWhatBuilds())) {
					enemyTypes.put(type.getWhatBuilds(), game.getGameFrame());
				}
				
				if (type.getFirstUnitReq() != -1 && !enemyTypes.containsKey(type.getFirstUnitReq())) {
					enemyTypes.put(type.getFirstUnitReq(), game.getGameFrame());
				} 
				  
				if (type.getSecondUnitReq() != -1 && !enemyTypes.containsKey(type.getSecondUnitReq())) {
					enemyTypes.put(type.getSecondUnitReq(), game.getGameFrame());
				}
			}
		}
		
		currentEnemyTypes = currentTypes;

	}
	 
	public boolean startScouting() {
		return getNumType(StarCraftConstants.Protoss_Gateway) > 0 || getNumType(StarCraftConstants.Protoss_Forge) > 0;
	}
	
	public static int getEnemySupply() {
		int count = 0;
		
		for (EnemyUnitWME unit : ABLStarCraftBot.getGame().getEnemyUnits()) {
			count += unit.getType().getSupplyRequired()/2;
		}
 		
		return count;
	}

	public boolean isDuplicate(ConstructionWME construction) {
		return isDuplicate(construction.getType());
	}
 	
	public boolean isDuplicate(int type) {
		switch (type) {
		// basic structures  
		case StarCraftConstants.Protoss_Forge:
			return getNumType(StarCraftConstants.Protoss_Forge) > 1;
		case StarCraftConstants.Protoss_Stargate:
			return getNumType(StarCraftConstants.Protoss_Stargate) > 2;
		case StarCraftConstants.Protoss_Cybernetics_Core:
			return getNumType(StarCraftConstants.Protoss_Cybernetics_Core) > 0;
		case StarCraftConstants.Protoss_Shield_Battery:
			return true;
		// advanced structures
		case StarCraftConstants.Protoss_Robotics_Facility:
			return getNumType(StarCraftConstants.Protoss_Robotics_Facility) > 0;
		case StarCraftConstants.Protoss_Citadel_of_Adun:
			return getNumType(StarCraftConstants.Protoss_Citadel_of_Adun) > 0;
		case StarCraftConstants.Protoss_Fleet_Beacon:
			return getNumType(StarCraftConstants.Protoss_Fleet_Beacon) > 0;
		case StarCraftConstants.Protoss_Templar_Archives: 
			return getNumType(StarCraftConstants.Protoss_Templar_Archives) > 0;
		case StarCraftConstants.Protoss_Observatory:
			return getNumType(StarCraftConstants.Protoss_Observatory) > 0;
		case StarCraftConstants.Protoss_Arbiter_Tribunal:
			return getNumType(StarCraftConstants.Protoss_Arbiter_Tribunal) > 0;
		case StarCraftConstants.Protoss_Shuttle:
		case StarCraftConstants.Protoss_Robotics_Support_Bay:
		case StarCraftConstants.Protoss_Reaver:
			return true; 
		// units
		case StarCraftConstants.Protoss_Observer: 
			return getNumType(StarCraftConstants.Protoss_Observer) > Math.max(1, supplyUsed/80);
//		case StarCraftConstants.Protoss_Shuttle:
//			return getNumType(StarCraftConstants.Protoss_Shuttle) > 1;			
		case StarCraftConstants.Protoss_Photon_Cannon:
			return getNumType(StarCraftConstants.Protoss_Photon_Cannon) >= 3*getNumActive(StarCraftConstants.Protoss_Nexus);			
		case StarCraftConstants.Protoss_Gateway:
			return getNumType(StarCraftConstants.Protoss_Gateway) >= 4*getNumType(StarCraftConstants.Protoss_Nexus);			
		default:
			return false;
		}
	}
 
	public boolean getEnemyCloaking() {
		
		// check opponent predicted units 
		for (Object prediction : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME("UnitPredictionWME")) {
			switch (((UnitPredictionWME)prediction).getTypeID()) {
			case StarCraftConstants.Protoss_Dark_Templar:
			case StarCraftConstants.Protoss_Templar_Archives:
			case StarCraftConstants.Terran_Wraith:
			case StarCraftConstants.Terran_Science_Facility:
			case StarCraftConstants.Terran_Ghost:
			case StarCraftConstants.Zerg_Lurker:
			case StarCraftConstants.Zerg_Lurker_Egg:
				return true;
			}
		} 
		 
		// check opponent predicted tech
		for (Object prediction : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME("TechPredictionWME")) {
			switch (((TechPredictionWME)prediction).getTypeID()) {
			case StarCraftConstants.Lurker_Aspect:
				return true;
			}
		}		 
		
			   // terran situations
		return currentEnemyTypes.contains(StarCraftConstants.Terran_Starport) ||
			   currentEnemyTypes.contains(StarCraftConstants.Terran_Wraith) ||
			   currentEnemyTypes.contains(StarCraftConstants.Terran_Science_Facility) ||
			   currentEnemyTypes.contains(StarCraftConstants.Terran_Science_Vessel) ||

			   // zerg situations
			   currentEnemyTypes.contains(StarCraftConstants.Zerg_Lurker) ||
			   currentEnemyTypes.contains(StarCraftConstants.Zerg_Lurker_Egg) ||
			   (currentEnemyTypes.contains(StarCraftConstants.Zerg_Hydralisk) && currentEnemyTypes.contains(StarCraftConstants.Zerg_Lair)) ||
			   (currentEnemyTypes.contains(StarCraftConstants.Zerg_Hydralisk_Den) && currentEnemyTypes.contains(StarCraftConstants.Zerg_Lair)) ||

			   // toss situations
			   currentEnemyTypes.contains(StarCraftConstants.Protoss_Citadel_of_Adun) ||
			   currentEnemyTypes.contains(StarCraftConstants.Protoss_High_Templar) ||
			   currentEnemyTypes.contains(StarCraftConstants.Protoss_Dark_Templar) ||
			   currentEnemyTypes.contains(StarCraftConstants.Protoss_Templar_Archives);
	}

	public boolean getEnemyCannons() {
		return currentEnemyTypes.contains(StarCraftConstants.Protoss_Photon_Cannon);
	}

	public boolean getEnemySunkens() {
		return currentEnemyTypes.contains(StarCraftConstants.Zerg_Sunken_Colony);
	}

	public boolean getEnemyBunkers() {
		return currentEnemyTypes.contains(StarCraftConstants.Terran_Bunker);
	}
	
	public boolean getEnemyTanks() {
		return currentEnemyTypes.contains(StarCraftConstants.Terran_Siege_Tank_Siege_Mode) ||
		 	   currentEnemyTypes.contains(StarCraftConstants.Terran_Siege_Tank_Tank_Mode);
	}

	public int getZealotCount() {
		return getNumActive(StarCraftConstants.Protoss_Zealot);
	}
 
	public int getDragoonCount() {
		return getNumActive(StarCraftConstants.Protoss_Dragoon);
	}
	
	public int getObsCount() { 
		return getNumActive(StarCraftConstants.Protoss_Observer);
	}

	public int getForgeCount() { 
		return getNumActive(StarCraftConstants.Protoss_Forge);
	}

	public int getNumActive(int type) {
		Integer count = activePlayerCounts.get(type);
		if (count != null) {
			return count;
		}
		else {
			return 0;
		}
	}
	
	public void addPrereqsToWM(int req1, int req2) {
		if (req1 != StarCraftConstants.NULL_UNIT && getNumType(req1) == 0) {
	        BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(req1));
		}
 
		if (req2 != StarCraftConstants.NULL_UNIT && getNumType(req2) == 0) {
	        BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(req2));
		}
	}

	public int getNumType(int type) {
		Integer count = allPlayerCounts.get(type); 
		if (count != null) {
			return count;
		}
		else {
			return 0;
		}  
	}
 
	public int getNumFreeForces() {

		int count = 0;
		
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getActive() && unit instanceof AttackUnitWME && unit.getSquadID() == 0) {
				count++;
			}
		}
		
		return count;
	}

	// TODO: base on supply
	public int getNumForces() {
		return getNumActive(StarCraftConstants.Protoss_Zealot) +
			   getNumActive(StarCraftConstants.Protoss_Dragoon) +
			   getNumActive(StarCraftConstants.Protoss_High_Templar) +
			   getNumActive(StarCraftConstants.Protoss_Dark_Templar) +
			   getNumActive(StarCraftConstants.Protoss_Archon)*2 + 
			   getNumActive(StarCraftConstants.Protoss_Dark_Archon)*2 +
			   getNumActive(StarCraftConstants.Protoss_Scout) +
			   getNumActive(StarCraftConstants.Protoss_Corsair) +
			   getNumActive(StarCraftConstants.Protoss_Carrier)*3 +
			   getNumActive(StarCraftConstants.Protoss_Arbiter)*2 +
			   getNumActive(StarCraftConstants.Protoss_Reaver)*2;
	}
 
	public int getNumNexus() {
		return getNumActive(StarCraftConstants.Protoss_Nexus);
	}

	public int getNumCarriers() {
		return getNumActive(StarCraftConstants.Protoss_Carrier);
	}

	public int getNumObs() {
		return getNumActive(StarCraftConstants.Protoss_Observer);
	}

	public int getNumZealots() {
		return getNumActive(StarCraftConstants.Protoss_Zealot);
	}

	public int getNumDragoons() {
		return getNumActive(StarCraftConstants.Protoss_Dragoon);
	}
 	
 	public int getNumProbes() {
		return getNumActive(StarCraftConstants.Protoss_Probe);
	}
	
	public int getNumAssimilators() {
		return getNumType(StarCraftConstants.Protoss_Assimilator);
	}
		
	public int getMyNexusCount() {
		return getNumType(StarCraftConstants.Protoss_Nexus);
	}
	
	public HashMap<Integer, Integer> getEnemyTypes() {
		return enemyTypes;
	}
 
	public HashMap<Integer, Integer> getUnitTimings() {
		return unitTimings;
	}

	public Map<Integer, Integer> getPlayerCounts() {
		return activePlayerCounts;
	}
	
	public boolean getEnemyCloakingTech() {
		return  
			enemyTypes.containsKey(StarCraftConstants.Protoss_Citadel_of_Adun) ||
			enemyTypes.containsKey(StarCraftConstants.Protoss_Templar_Archives) ||
			enemyTypes.containsKey(StarCraftConstants.Protoss_High_Templar) ||
//			enemyTypes.containsKey(StarCraftConstants.Protoss_Cybernetics_Core) ||
			enemyTypes.containsKey(StarCraftConstants.Zerg_Lurker_Egg) ||
			enemyTypes.containsKey(StarCraftConstants.Zerg_Lurker) ||
			enemyTypes.containsKey(StarCraftConstants.Zerg_Hydralisk) ||
			enemyTypes.containsKey(StarCraftConstants.Zerg_Hydralisk_Den) ||
			enemyTypes.containsKey(StarCraftConstants.Terran_Starport) ||
			enemyTypes.containsKey(StarCraftConstants.Terran_Wraith);
	}
}
