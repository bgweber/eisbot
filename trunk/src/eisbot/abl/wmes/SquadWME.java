package eisbot.abl.wmes;

import java.awt.Point;
import java.util.ArrayList;

import wm.WME;
import abl.runtime.BehavingEntity;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.StarCraftConstants;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.wmes.unit.EnemyUnitWME;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
import eisbot.proxy.wmes.unit.UnitWME;
import eisbot.proxy.wmes.unit.protoss.AttackUnitWME;
import eisbot.proxy.wmes.unit.protoss.CasterUnitWME;

public class SquadWME extends WME {

	int squadID;
	boolean isRegrouping = false;
	boolean isRetreating = false;
	boolean hasRetreated = false;
	int regroupTime = 0;
	
	public SquadWME(int id) {
		this.squadID = id;
	} 
	
	public static boolean squadExist(int squadID) {
		for (Object squad : ABLStarCraftBot.getBehavingEntity().getWorkingMemory().lookupWME("SquadWME")) {
			if (((SquadWME)squad).getSquadID() == squadID) {
				return true; 
			}
		}
		 
		return false;
	}
	  
	public void createSquad() {
//		ABLStarCraftBot.getQueue().createSquad(null, squadID, 0);
		
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getActive()&& unit instanceof AttackUnitWME && unit.getSquadID() == 0) {
//				ABLStarCraftBot.getQueue().addUnit(null, unit.getID(), squadID);
				unit.setSquadID(squadID);
			}  
		}  
		
		regroup(true);
	} 
	
	public void mergeSquads() {	
				
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) { 
			if (unit.getActive()&& unit instanceof AttackUnitWME) {
				if (unit.getSquadID() == mergeSquadA.getSquadID()) {
//					ABLStarCraftBot.getQueue().deleteUnit(null, unit.getID(), mergeSquadA.getSquadID());
				}
				else if (unit.getSquadID() == mergeSquadB.getSquadID()) {
//					ABLStarCraftBot.getQueue().deleteUnit(null, unit.getID(), mergeSquadB.getSquadID());
				}
			}  
		}  

//		ABLStarCraftBot.getQueue().deleteSquad(null, mergeSquadA.getSquadID());		
//		ABLStarCraftBot.getQueue().deleteSquad(null, mergeSquadB.getSquadID());		

//		ABLStarCraftBot.getQueue().createSquad(null, squadID, 0);

		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) { 
			if (unit.getActive()&& unit instanceof AttackUnitWME) { 
				if (unit.getSquadID() == mergeSquadA.getSquadID() || unit.getSquadID() == mergeSquadB.getSquadID()) { 
//					ABLStarCraftBot.getQueue().addUnit(null, unit.getID(), squadID);
					unit.setSquadID(squadID);
				}
			}
		}
		
		regroup(true);
	} 
 		  
	public boolean getSpreadExceeded() {
		return getSpread() > getSize() * 30; 
	}

	public boolean getSpreadFixed() {
		return (getSpread() < getSize() * 20) || (ABLStarCraftBot.getGame().getGameFrame() > (regroupTime + 60));   
	} 
 
	public int getClosestSquadID(int x, int y) {
		int bestSquad = squadID; 
		double closest = 256*256;
		 
		for (Object obj : ABLStarCraftBot.getBehavingEntity().getWorkingMemory().lookupWME("SquadWME")) {
			SquadWME squad = (SquadWME)obj;			
			Point center = squad.getCenter(false);
			
			if (center != null) {
				double distance = UnitWME.distance(x, y, center.x, center.y);
				
				if (distance < closest) {
					closest = distance;
					bestSquad = squad.getSquadID(); 
				}
			}
		}		
		 
		return bestSquad;
	}
	  
	public void retreat() {
		Point rally = ABLStarCraftBot.getGame().getMap().getRallyPoint(0, 0);
		double theta = Math.random()*2.0*Math.PI;
		
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID) { 
				ABLStarCraftBot.getQueue().rightClick(null, unit.getID(), 
						32*rally.x + (int)(Math.cos(theta)*3.5),  
						32*rally.y + (int)(Math.sin(theta)*3.5));
			} 
		}  
	} 

	public void breakUp() {
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID) { 
				unit.setSquadID(0);
			} 
		}  

		BehavingEntity.getBehavingEntity().deleteWME(this);
	}  

	public boolean getIsRegrouping() {
		return isRegrouping;
	}   
	 
	public void setRegrouping(boolean regrouping) {
		regroupTime = ABLStarCraftBot.getGame().getGameFrame();
		this.isRegrouping = regrouping;
	}
   
	public boolean getIsRetreating() {
		return isRetreating;
	} 
	
	public void setRetreating(boolean retreating) {
		if (retreating) {
			hasRetreated = true;
		}
		
		this.isRetreating = retreating;
	} 
	
	public void stopRetreat() {
		hasRetreated = false; 
		this.isRetreating = false;
		regroup(false);
	}
	 
	public boolean getHasRetreated() {
		return hasRetreated;
	}
 
	private static SquadWME mergeSquadA;
	private static SquadWME mergeSquadB;
	
	public static boolean canMergeSquads() { 
		ArrayList<SquadWME> squads = new ArrayList<SquadWME>();
		ArrayList<Point> centers = new ArrayList<Point>();
 		
		for (Object obj : BehavingEntity.getBehavingEntity().lookupWME("SquadWME")) {
			SquadWME squad = (SquadWME)obj;			
			Point center = squad.getCenter(false);
			
			if (center != null) {
				squads.add(squad);
				centers.add(center);
			}
		}
		 
		for (int i=0; i<(centers.size() - 1); i++) {			
			for (int j=i + 1; j<centers.size(); j++) { 
				if (Math.abs(centers.get(i).x - centers.get(j).x) <= 16 && Math.abs(centers.get(i).y - centers.get(j).y) <= 16) {
					mergeSquadA = squads.get(i);
					mergeSquadB = squads.get(j);
					return true;
				} 
			}
		}
		
		return false;
	}
 
	public boolean getIsIdle() { 
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
//			if (unit.getSquadID() == squadID && unit instanceof AttackUnitWME && 
//					!(unit.getOrder()==StarCraftConstants.AttackMove || unit.getOrder()==StarCraftConstants.AttackUnit)) { 
			if (unit.getSquadID() == squadID && unit instanceof AttackUnitWME && unit.getOrder()==StarCraftConstants.PlayerGuard) {
				return true;
			} 
		}
		 
		return false;  
	}
 
	public boolean getCanAttackAir() { 
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID) { 
				if (unit.getTypeID() == StarCraftConstants.Protoss_Dragoon ||
					unit.getTypeID() == StarCraftConstants.Protoss_Archon || 
					unit.getTypeID() == StarCraftConstants.Protoss_Corsair ||
					unit.getTypeID() == StarCraftConstants.Protoss_Scout){
 					 
					return true;
				}
			} 
		} 
		 
		return false;  
	}

	public int getSquadSupply() {
		int supply = 0;
		
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) { 
			if (unit.getSquadID() == squadID && unit instanceof AttackUnitWME) { 
				supply += unit.getType().getSupplyRequired()/2;
			} 
		}
		
		return supply;
	}

	public void draw(JNIBWAPI bwapi) {
		Point center = getCenter(true);
		if (center == null) {
			return;
		}
		 
		bwapi.drawText(center.x, center.y, getSquadSupply() + " - " + getEnemySupply(), false); 
		bwapi.drawCircle(16 + center.x, 16 + center.y, getSpread(), 33, false, false);
	} 

	public int getSpread() {
		int minX = 256*32;
		int minY = 256*32;
		int maxX = 0;  
		int maxY = 0;
 
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID && unit instanceof AttackUnitWME) {
				minX = Math.min(minX, unit.getRealX());
				minY = Math.min(minY, unit.getRealY());
				maxX = Math.max(maxX, unit.getRealX()); 
				maxY = Math.max(maxY, unit.getRealY()); 
			} 
		}

		return Math.max(maxX - minX, maxY - minY)/2;
	}

	public Point getCenter(boolean real) {
		int count = 0;
		int x = 0;
		int y = 0; 
		
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID && unit instanceof AttackUnitWME) {
				count++;
 				
				if (real) {
					x += unit.getRealX();
					y += unit.getRealY();
				}
				else {
					x += unit.getX();
					y += unit.getY();
				}
			}
		}
		 
		if (count == 0) {
			return null;
		}
		else {
			return new Point(x/count, y/count);
		}
	}
	
	/**
	 * Distance from the center of squad to nearest enemy unit.
	 */
	public double getEnemyDistance() {
		double distance = 128;
		
		Point center = getCenter(false);
		if (center == null) {
			return distance;
		}
		 		
		for (EnemyUnitWME unit : ABLStarCraftBot.getGame().getEnemyUnits()) {
			double dx = unit.getX() - center.x;
			double dy = unit.getY() - center.y;
			distance = Math.min(Math.sqrt(dx*dx + dy*dy), distance);
		}
		
		return distance;
	}

	public double getBaseDistance() {
		double distance = 128;
		  
		Point center = getCenter(false);
		if (center == null) {
			return distance;
		} 
		 		
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getType().isBuilding()) {
				double dx = unit.getX() - center.x; 
				double dy = unit.getY() - center.y;
				distance = Math.min(Math.sqrt(dx*dx + dy*dy), distance);
			} 
		} 
		
		return distance;
	}

	public int getEnemySupply() {
		int threat = 0;
		 
		Point center = getCenter(false);
		if (center == null) {
			return threat;
		}		
  
		for (EnemyUnitWME unit : ABLStarCraftBot.getGame().getEnemyUnits()) {
			if (unit.getType().isWorker()) {
				continue;
			} 
			
			double dx = unit.getX() - center.x;
			double dy = unit.getY() - center.y;
						 
			if (Math.sqrt(dx*dx + dy*dy) < 16) {
				threat += unit.getType().getSupplyRequired();
				
				if (unit.getType().isDefensiveStructure()) { 
					threat += 4;
				}  
			}
		}
 		
		return threat/2;
	}
	
	public void regroup(boolean groupCasters) {
		Point center = getCenter(true);
		if (center == null) {
			return;
		}				
 
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID && unit instanceof AttackUnitWME) {
				   
				if (groupCasters) {  
			    	ABLStarCraftBot.getQueue().rightClick(null, unit.getID(), center.x, center.y);
				}
				else {
			    	ABLStarCraftBot.getQueue().attackMove(null, unit.getID(), center.x, center.y);
				}
			} 
		}
		
		// group unassigned casters
		if (groupCasters) { 			
			for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
				if (unit.getSquadID() == 0 && unit instanceof CasterUnitWME) {
			    	ABLStarCraftBot.getQueue().attackMove(null, unit.getID(), center.x, center.y);
				} 
			} 
		}
    
//		ABLStarCraftBot.getQueue().squadMove(null, squadID, x, y);
		return;  
	}

	public int getSize() {
		int count = 0; 

		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID && unit instanceof AttackUnitWME) {
				count++;
			}
		}
		
		return count; 
	}

	public int getCasterSize() {
		int count = 0; 

		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID && unit instanceof CasterUnitWME) {
				count++; 
			}
		}
		
		return count; 
	}

	public int getSquadID() {
		return squadID;
	}
} 
  