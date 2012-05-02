package eisbot.proxy.wmes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;

import wm.WME;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.abl.StarCraftConstants;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.filter.ParticleWME;
import eisbot.proxy.types.UnitType.UnitTypes;
import eisbot.proxy.wmes.unit.GeyserWME;
import eisbot.proxy.wmes.unit.MineralWME;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
import eisbot.proxy.wmes.unit.UnitWME;
import eisbot.proxy.wmes.unit.protoss.GroundUnitWME;
import eisbot.proxy.wmes.unit.protoss.NexusWME;
/**
 * Stores tile information about a map in StarCraft.
 * 
 * Note: internally in StarCraft, the height and walkable arrays have a higher
 *       resolution than the size tile in this class. Each tile is actually
 *       a 4x4 grid, but this has been abstracted away for simplicity for now.
 */
public class MapWME extends WME {

	private boolean[] hasCreep;
  
	public boolean hasCreep(int tx, int ty) {
		return hasCreep[ty*mapWidth + tx];
	}
	  
	public void updateCreep(int[] creep) { 
		for (int i=0; i<creep.length; i++) {
			hasCreep[i] = (creep[i] == 1);
 		}		 
	}
	
	public void drawLocations(JNIBWAPI bwapi, Game game, int drawBuildLocations, boolean drawPylons) {
		
		int tileWidth = 4;
		int tileHeight = 3;			
		if (drawBuildLocations > 1) tileHeight = 2;
		if (drawBuildLocations == 2) tileWidth = 3;
		if (drawBuildLocations == 3) tileWidth = 2;

		if (drawPylons) {
			ArrayList<Point> buildLocations = game.getMap().getBuildLocations(game, tileWidth, tileHeight, -1, -1, false);							
			for (Point location : buildLocations) {
				bwapi.drawBox(location.x*32, location.y*32, (location.x + tileWidth)*32, (location.y + tileHeight)*32, 133, false, false);
			}
		}
		
		ArrayList<Point> expandLocations = game.getMap().getExpansionLocations(game, false, null);		
		for (Point location : expandLocations) {
			bwapi.drawBox(location.x*32, location.y*32, (location.x + 4)*32, (location.y + 3)*32, 153, false, false);
		}
		
		Point location = game.getMap().getNextExpansion(game, true);
		if (location != null) {
			bwapi.drawBox(location.x*32, location.y*32, (location.x + 4)*32, (location.y + 3)*32, 72 + (int)(Math.random()*32), false, false);
		}
		
		location = game.getMap().getNextGeyser(game);
		if (location != null) {
			bwapi.drawBox(location.x*32, location.y*32, (location.x + 4)*32, (location.y + 2)*32, 55 + (int)(Math.random()*2), false, false);
		}
				
		for (UnitWME expo : getExpos(game)) {
			ArrayList<Point> pylons = game.getMap().getPylonChokepoint(game, expo, -1);
			for (Point pLocation : pylons) {
				bwapi.drawBox(pLocation.x*32, pLocation.y*32, (pLocation.x + 2)*32, (pLocation.y + 2)*32, 16 + (int)(Math.random()*2), false, false);
			}
					
			pylons = game.getMap().getFirstPylons(game, expo, -1);
			for (Point pLocation : pylons) {
				bwapi.drawBox(pLocation.x*32, pLocation.y*32, (pLocation.x + 2)*32, (pLocation.y + 2)*32, 32 + (int)(Math.random()*2), false, false);
			}
			
			pylons = game.getMap().getDefensePylons(game, expo, -1);
			for (Point pLocation : pylons) {
				bwapi.drawBox(pLocation.x*32, pLocation.y*32, (pLocation.x + 2)*32, (pLocation.y + 2)*32, 114 + (int)(Math.random()*2), false, false);
			}

			pylons = game.getMap().getPylonBoundary(game, expo, -1);
			
			for (Point pLocation : pylons) {
				bwapi.drawBox(pLocation.x*32, pLocation.y*32, (pLocation.x + 2)*32, (pLocation.y + 2)*32, 48 + (int)(Math.random()*2), false, false);
			} 
			
			location = game.getMap().getPylonOpenSpace(game, expo, -1);
			if (location != null) {
				bwapi.drawBox(location.x*32, location.y*32, (location.x + 2)*32, (location.y + 2)*32, 140 + (int)(Math.random()*2), false, false);
			}
		}
	}
	
	int buildingX = 0;
	int buildingY = 0;
	int purpose = 0;

	/**
	 * 
	 * @param type
	 * @param workerID
	 * @param workerX - tile coordinates
	 * @param workerY - tile coordinates
	 * @return
	 */ 
	public boolean findBuildingLocation(int type, int workerID, int workerX, int workerY) {
		return findBuildingLocation(type, workerID, workerX, workerY, false);
	}
	
	public int getPylonWorker() {
		int closest = -1;
 				
		if (findBuildingLocation(StarCraftConstants.Protoss_Pylon, -1, 0, 0, false)) {
			double distance = Double.MAX_VALUE;

			for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
				if (unit.getTypeID() == StarCraftConstants.Protoss_Probe && unit.getTask()==StarCraftConstants.WORKER_MINE && unit.getActive()) {
					double dx = Math.abs(unit.getX() - buildingX);
					double dy = Math.abs(unit.getY() - buildingY);
					double dist = Math.sqrt(dx*dx + dy*dy);
					
					if (dist < distance) {
						closest = unit.getID();
						distance = dist;
					}
				}
			}
		}
		 
		return closest;
	}
 
	public int chokeDistance(int tx, int ty) {
		int closest = 256;
 		 
		for (ChokePointWME choke : ABLStarCraftBot.getGame().getChokePoints()) {
			int distance = Math.max(Math.abs(tx - choke.getX()), Math.abs(ty - choke.getY()));
			closest = Math.min(distance, closest); 
		}

		return closest; 
	}
	
	public boolean findBuildingLocation(int type, int workerID, int workerX, int workerY, boolean fastExpand) {
		Point location = null;
 
		if (type == StarCraftConstants.Protoss_Pylon) {
			if (fastExpand) {
				location = getNextExpansion(ABLStarCraftBot.getGame(), true);
				if (location != null) { 

	 				ArrayList<Point> locations = getFEPylons(ABLStarCraftBot.getGame(), location.x, location.y, workerID);
					if (locations.size() > 0) {
						location = locations.get(0);
					}
					else {
						return false;
					}
				}
			}
			else {
				ArrayList<Point> locations = getFirstPylons(ABLStarCraftBot.getGame(), null, workerID); 
				locations.addAll(getDefensePylons(ABLStarCraftBot.getGame(), null, workerID));
				locations.addAll(getPylonChokepoint(ABLStarCraftBot.getGame(), null, workerID));
	
				for (UnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
					if (unit.getTypeID() == UnitTypes.Protoss_Nexus.ordinal()) {
						locations.add(getPylonOpenSpace(ABLStarCraftBot.getGame(), unit, workerID));
					}
				}
				
				if (locations.size() > 0) {
					location = locations.get(0);
				}
			} 
		}
		else if (type == StarCraftConstants.Protoss_Nexus) {
			location = getNextExpansion(ABLStarCraftBot.getGame(), true);
		}
		else if (type == StarCraftConstants.Protoss_Assimilator) {
			location = getNextGeyser(ABLStarCraftBot.getGame());
		} 
		else {			
			int height = UnitTypeWME.getType(type).getTileHeight();
			int width = UnitTypeWME.getType(type).getTileWidth();
			
			// pad gateways			
			if (type == StarCraftConstants.Protoss_Gateway) {
				height++;
			}  

//			ArrayList<Point> locations = getBuildLocations(ABLStarCraftBot.getGame(), width, height, workerID, -1);

			// regular structure
			ArrayList<Point> locations = new ArrayList<Point>();
			if (type != StarCraftConstants.Protoss_Photon_Cannon) {
						  
				locations = getBuildLocations(ABLStarCraftBot.getGame(), width, height, workerID, StarCraftConstants.PYLON_OPEN, false);
				if (locations.size() == 0) {
					locations = getBuildLocations(ABLStarCraftBot.getGame(), width, height, workerID, StarCraftConstants.PYLON_FIRST, false); 
					
					if (locations.size() == 0) {
						locations = getBuildLocations(ABLStarCraftBot.getGame(), width, height, workerID, StarCraftConstants.PYLON_CHOKE, false);
					}
				}
			}
			// cannon  
			else {
				locations = getBuildLocations(ABLStarCraftBot.getGame(), width, height, workerID, StarCraftConstants.PYLON_CHOKE, true);
				if (locations.size() == 0) { 
					locations = getBuildLocations(ABLStarCraftBot.getGame(), width, height, workerID, StarCraftConstants.PYLON_MINERALS, true);
					
					if (locations.size() == 0) {
						locations = getBuildLocations(ABLStarCraftBot.getGame(), width, height, workerID, StarCraftConstants.PYLON_FIRST, true);
					}
				}
			}
			 
			double closest = Double.MAX_VALUE;

			for (Point point : locations) {
				double dx = point.x - workerX;
				double dy = point.y - workerY;
				double distance = dx*dx + dy*dy;
				
				if (distance < closest) {
					closest = distance;
					location = point;
				}
			}
		}
		
		if (location != null) {
			buildingX = location.x;
			buildingY = location.y;
			
			if (location instanceof PylonLocation) {
				purpose = ((PylonLocation)location).getPurpose();
			}
			
			return true;
		}
		else {
			return false;
		}
	} 

	int scatterY = 0;
	
	public int getScatterX() {
		ArrayList<BaseLocationWME> bases = ABLStarCraftBot.getGame().getBaseLocations();
		if (bases.size() > 0) {
			BaseLocationWME base = bases.get((int)(bases.size()*Math.random()));
			scatterY = base.getY();
			return base.getX();
		}
		else {
			scatterY = mapHeight/2;
			return mapWidth/2;
		}
	}
	
	public int getScatterY() {
		return scatterY;
	}
	
	public Point choosePylonLocation(int nexus, int purpose) {
		UnitWME expo = ABLStarCraftBot.getGame().getUnitByID(nexus);		
		if (expo == null) {
			return null;
		}
		
		ArrayList<Point> pylons = new ArrayList<Point>();
		switch (purpose) {
		case StarCraftConstants.PYLON_FIRST:	
			pylons = getFirstPylons(ABLStarCraftBot.getGame(), expo, -1);
			break;
		case StarCraftConstants.PYLON_OPEN:	
			Point pylon = getPylonOpenSpace(ABLStarCraftBot.getGame(), expo, -1);
			if (pylon != null) {
				pylons.add(pylon);
			}
			break;
		case StarCraftConstants.PYLON_MINERALS:	
			pylons = getDefensePylons(ABLStarCraftBot.getGame(), expo, -1);
			break;
		case StarCraftConstants.PYLON_CHOKE:	
			pylons = getPylonChokepoint(ABLStarCraftBot.getGame(), expo, -1);
			break;
		case StarCraftConstants.PYLON_BOUNDARY:	
			pylons = getPylonBoundary(ABLStarCraftBot.getGame(), expo, -1);
			break;
		}

		// store the pylon request
		if (pylons.size() > 0) {
			return pylons.get(0);
		}
		
		// no pylon location found, fail the behavior
		return null;
	}

	public int getPurpose() {
		return purpose;
	}
	
	public int getBuildingX() {
		return buildingX;
	}
	
	public int getBuildingY() {
		return buildingY;
	}

	LinkedList<Point> scoutLocations = new LinkedList<Point>();

	public Point getNextScoutLocation() {
		Game game = ABLStarCraftBot.getGame();
		
		if (scoutLocations.size() == 0) {
			baseLoop:
			for (BaseLocationWME location : game.getBaseLocations()) {
				for (PlayerUnitWME unit : game.getPlayerUnits()) {
					if (Math.abs(unit.getX() - location.getX()) <= 6 && Math.abs(unit.getY() - location.getY()) <= 6) {
						continue baseLoop;
					}
				}
				
				scoutLocations.add(new Point(location.getX(), location.getY()));
			}
		}
 
		if (scoutLocations.size() == 0) {
			return new Point(getMapWidth()/2, getMapHeight()/2);
		}
		else {
			return scoutLocations.remove();
		}
	}

	LinkedList<Point> startLocations = new LinkedList<Point>();
	
	public Point getNextStartLocation() {
		Game game = ABLStarCraftBot.getGame();
		
		if (startLocations.size() == 0) {
			baseLoop:
			for (StartingLocationWME location : game.getStartingLocations()) {
				for (PlayerUnitWME unit : game.getPlayerUnits()) {
					if (Math.abs(unit.getX() - location.getX()) <= 6 && Math.abs(unit.getY() - location.getY()) <= 6) {
						continue baseLoop;
					}
				}
				
				startLocations.add(new Point(location.getX(), location.getY()));
			}
		}

		if (startLocations.size() == 0) {
			return new Point(getMapWidth()/2, getMapHeight()/2);
		}
		else {
			return startLocations.remove();
		}
	}
	
	/**
	 * 
	 * TODO: check the speed of this method versus simply iterating through the units and doing a BB check.
	 * 
	 * @param type
	 * @param x
	 * @param y
	 * @param workerID
	 * @return
	 */
	public boolean isLocationClear(int type, int x, int y, int workerID) {
		
		// compute unit occupied tiles
		boolean[] occupied = hasCreep.clone();

		for (UnitWME unit : new ArrayList<UnitWME>(ABLStarCraftBot.getGame().getUnits())) {
			if (unit.getID() != workerID && unit.getTypeID() != StarCraftConstants.Resource_Vespene_Geyser) {
				for (int w=0; w<unit.getType().getTileWidth(); w++) {
					for (int h=0; h<unit.getType().getTileHeight(); h++) {
						int index = (unit.getY() + h)*mapWidth + unit.getX() + w;
						
						if (index >= 0 && index < occupied.length) {
							occupied[index] = true;
						}
					}
				}
			}			
		}		
		
		UnitTypeWME unitType = ABLStarCraftBot.getGame().getUnitTypes().get(type);
		if (unitType == null) {
			return false;
		}
		else {
			for (int w=0; w<unitType.getTileWidth(); w++) {
				for (int h=0; h<unitType.getTileHeight(); h++) {
					int index = (y + h)*mapWidth + x + w;
					
					if (index >= 0 && index < occupied.length && occupied[index]) {
						return false;
					}
				}
			}

			return true;
		}
	}
	
	public ArrayList<Point> getFirstPylons(Game game, UnitWME nexus, int probeID) {
		ArrayList<UnitWME> expos = new ArrayList<UnitWME>();
		ArrayList<Point> points = new ArrayList<Point>();

		if (nexus != null) {
			expos.add(nexus);
		}
		else {
			for (UnitWME unit : game.getPlayerUnits()) {
				if (unit.getTypeID() == UnitTypes.Protoss_Nexus.ordinal()) {
					expos.add(unit);
				}
			}
		}
		
		// sort from oldest to newest
		Collections.sort(expos, new Comparator<UnitWME>() {
			public int compare(UnitWME o1, UnitWME o2) {
				return o1.getID() - o2.getID();
			}
		});
		
		// compute unit occupied tiles
		boolean[] occupied = hasCreep.clone();
		for (UnitWME unit : game.getUnits()) {
			if (unit.getID() != probeID) {
				for (int w=0; w<unit.getType().getTileWidth(); w++) {
					for (int h=0; h<unit.getType().getTileHeight(); h++) {
						int index = (unit.getY() + h)*mapWidth + unit.getX() + w;
						
						if (index >= 0 && index < occupied.length) {
							occupied[index] = true;
						}
					}
				}
			}			
		}		

		expoLoop:
		for (UnitWME expo : expos) {
			int tx = 0;
			int ty = 0;
			int count = 0;

			for (MineralWME mins : game.getMinerals()) {
				if (Math.abs(expo.getX() - mins.getX()) < 10 && Math.abs(expo.getY() - mins.getY()) < 10) {
					count++;
					tx += mins.getX();
					ty += mins.getY();
				}
			}
			
			if (count == 0) {
				return new ArrayList<Point>();
			}

			tx = tx/count;
			ty = ty/count;				
			tx = expo.getX() + (expo.getX() - tx);
			ty = expo.getY() + (expo.getY() - ty);
			
			// find a buildable spot
			for (int i=0; i<3; i++) {
				for (int x=-i; x<=i; x++) {
					for (int y=-i; y<=i; y++) {
						if (Math.abs(x) == i || Math.abs(y) == i) {

							// map boundaries 
							if (tx + x + 1 >= mapWidth || (tx + x) < 0 || ty + y + 1 >= mapHeight || (ty + y) < 0) {
								continue;
							}
							
							// terrain
							if (!buildable[ty + y][tx + x]) continue;
							if (!buildable[ty + y + 1][tx + x]) continue;
							if (!buildable[ty + y][tx + x + 1]) continue;
							if (!buildable[ty + y + 1][tx + x + 1]) continue;

							// units
							if (occupied[(ty + y)*mapWidth + tx + x]) continue;
							if (occupied[(ty + y + 1)*mapWidth + tx + x]) continue;
							if (occupied[(ty + y)*mapWidth + tx + x + 1]) continue;
							if (occupied[(ty + y + 1)*mapWidth + tx + x + 1]) continue;
							
							// check adjacent pylons
							for (UnitWME unit : game.getPlayerUnits()) {
								if (unit.getTypeID() == UnitTypes.Protoss_Pylon.ordinal()) {
									if (Math.abs(unit.getX() - (tx +x)) < 8 && Math.abs(unit.getY() - (ty +y)) < 8) {
										continue expoLoop;
									}
								}
							}
				
							points.add(new PylonLocation(tx + x, ty + y, StarCraftConstants.PYLON_FIRST));
							continue expoLoop;
						}
					}							
				}						
			}					
		}
	
		return points;
	}
 
	public ArrayList<Point> getFEPylons(Game game, int expoX, int expoY, int probeID) {
		ArrayList<Point> points = new ArrayList<Point>();

		// compute unit occupied tiles
		boolean[] occupied = hasCreep.clone();
		for (UnitWME unit : game.getUnits()) {
			if (unit.getID() != probeID) {
				for (int w=0; w<unit.getType().getTileWidth(); w++) {
					for (int h=0; h<unit.getType().getTileHeight(); h++) {
						int index = (unit.getY() + h)*mapWidth + unit.getX() + w;
						
						if (index >= 0 && index < occupied.length) {
							occupied[index] = true;
						}
					}
				}
			}			
		}		
 
		// add the nexus that will be there
		for (int w=0; w<4; w++) {
			for (int h=0; h<3; h++) {
				int index = (expoY + h)*mapWidth + expoX + w;
				
				if (index >= 0 && index < occupied.length) {
					occupied[index] = true;
				}
			}
		}
		 
//		expoLoop:
//		for (UnitWME expo : expos) {
		int tx = 0;
		int ty = 0;
		int count = 0;

		for (MineralWME mins : game.getMinerals()) {
			if (Math.abs(expoX - mins.getX()) < 10 && Math.abs(expoY - mins.getY()) < 10) {
				count++;
				tx += mins.getX(); 
				ty += mins.getY();
			}
		}

		if (count > 0 ) {
			tx = tx/count;
			ty = ty/count;				
			tx = expoX + (expoX - tx);
			ty = expoY + (expoY - ty);
		}
		else {
			tx = expoX;
			ty = expoY;
		}
 
		// find a buildable spot
		expoLoop:
		for (int i=0; i<3; i++) {
			for (int x=-i; x<=i; x++) {
				for (int y=-i; y<=i; y++) {
					if (Math.abs(x) == i || Math.abs(y) == i) {

						// map boundaries
						if (tx + x + 1 >= mapWidth || tx + x < 0 || ty + y + 1 >= mapHeight || ty < 0) {
							continue;
						}
						
						// terrain
						if (!buildable[ty + y][tx + x]) continue;
						if (!buildable[ty + y + 1][tx + x]) continue;
						if (!buildable[ty + y][tx + x + 1]) continue;
						if (!buildable[ty + y + 1][tx + x + 1]) continue;

						// units
						if (occupied[(ty + y)*mapWidth + tx + x]) continue;
						if (occupied[(ty + y + 1)*mapWidth + tx + x]) continue;
						if (occupied[(ty + y)*mapWidth + tx + x + 1]) continue;
						if (occupied[(ty + y + 1)*mapWidth + tx + x + 1]) continue;

						points.add(new PylonLocation(tx + x, ty + y, StarCraftConstants.PYLON_CHOKE));
						continue expoLoop;
					}
				}							
			}						
		}					

		return points;
	}
	
	
	public ArrayList<Point> getDefensePylons(Game game, UnitWME nexus, int probeID) {
		ArrayList<UnitWME> expos = new ArrayList<UnitWME>();
		ArrayList<Point> points = new ArrayList<Point>();

		if (nexus != null) {
			expos.add(nexus);
		}
		else {
			for (UnitWME unit : game.getPlayerUnits()) {
				if (unit.getTypeID() == UnitTypes.Protoss_Nexus.ordinal()) {
					expos.add(unit);
				}
			}
		}
		
		// sort from oldest to newest
		Collections.sort(expos, new Comparator<UnitWME>() {
			public int compare(UnitWME o1, UnitWME o2) {
				return o1.getID() - o2.getID();
			}
		});
		
		// compute unit occupied tiles
		boolean[] occupied = hasCreep.clone();
		for (UnitWME unit : game.getUnits()) {
			if (unit.getID() != probeID) {
				for (int w=0; w<unit.getType().getTileWidth(); w++) {
					for (int h=0; h<unit.getType().getTileHeight(); h++) {
						int index = (unit.getY() + h)*mapWidth + unit.getX() + w;
						
						if (index >= 0 && index < occupied.length) {
							occupied[index] = true;
						}
					}
				}
			}			
		}		

		expoLoop:
		for (UnitWME expo : expos) {
			int tx = 0;
			int ty = 0;
			int count = 0;
			
			// get its region
			RegionWME homeRegion = null;
			for (RegionWME region : game.getRegions()) {
				if (region.contains(32*expo.getX(), 32*expo.getY())) {
					homeRegion = region;
					break;
				}
			}
			
			if (homeRegion == null) {
				continue;
			}

			for (MineralWME mins : game.getMinerals()) {
				if (Math.abs(expo.getX() - mins.getX()) < 10 && Math.abs(expo.getY() - mins.getY()) < 10) {
					count++;
					tx += mins.getX();
					ty += mins.getY();

					// mark tiles in between mins as filled
					int minX = Math.min(mins.getX(), expo.getX());
					int maxX = Math.max(mins.getX(), expo.getX());
					int minY = Math.min(mins.getY(), expo.getY());
					int maxY = Math.max(mins.getY(), expo.getY());
					
					for (int x=minX; x<=maxX; x++) {
						for (int y=minY; y<=maxY; y++) {
							if (x < mapWidth && y < mapHeight) {
								occupied[y*mapWidth + x] = true;
							}
						}
					}
				}
			}
			
			if (count == 0) {
				continue;
			}

			tx = tx/count;
			ty = ty/count;				
			tx = tx + (tx - expo.getX())/2;
			ty = ty + (ty - expo.getY())/2;

			// find a buildable spot
			for (int i=0; i<9; i++) {
				for (int x=-i; x<=i; x++) {
					locationLoop:
					for (int y=-i; y<=i; y++) {
						if (Math.abs(x) == i || Math.abs(y) == i) {

							// map boundaries
							if (tx + x + 1 >= mapWidth || tx + x < 0 || ty + y + 1 >= mapHeight || ty + y< 0) {
								continue;
							} 
														
							// terrain
							if (!buildable[ty + y][tx + x]) continue;
							if (!buildable[ty + y + 1][tx + x]) continue;
							if (!buildable[ty + y][tx + x + 1]) continue;
							if (!buildable[ty + y + 1][tx + x + 1]) continue;

							// units
							if (occupied[(ty + y)*mapWidth + tx + x]) continue;
							if (occupied[(ty + y + 1)*mapWidth + tx + x]) continue;
							if (occupied[(ty + y)*mapWidth + tx + x + 1]) continue;
							if (occupied[(ty + y + 1)*mapWidth + tx + x + 1]) continue;

							// same region
							if (!homeRegion.contains(32*tx, 32*ty)) {
								continue;
							}
							
							// check adjacent pylons
							for (UnitWME unit : game.getPlayerUnits()) {
								if (unit.getTypeID() == UnitTypes.Protoss_Pylon.ordinal()) {
									if (Math.abs(unit.getX() - (tx +x)) < 6 && Math.abs(unit.getY() - (ty +y)) < 6) {
										continue expoLoop;
//										return points;
									}
								}
							}
				
 
							points.add(new PylonLocation(tx + x, ty + y, StarCraftConstants.PYLON_MINERALS));
							continue expoLoop;
						}
					}							
				}						
			}					
		}
	
		return points;
	}
		
	public ArrayList<UnitWME> getExpos(Game game) {
		ArrayList<UnitWME> expos = new ArrayList<UnitWME>();

		for (UnitWME unit : game.getPlayerUnits()) {
			if (unit.getTypeID() == UnitTypes.Protoss_Nexus.ordinal()) {
				expos.add(unit);
			}
		}

		return expos;
	}

	/**
	 * Returns a choke point from the newest expo that is not an internal chokepoint
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Point getRallyPoint(int x, int y) {
		
		// get expos
		TreeMap<Integer, PlayerUnitWME> expos = new TreeMap<Integer, PlayerUnitWME>();
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit instanceof NexusWME) {
				expos.put(unit.getID(), unit);
			}
		}

		HashSet<ChokePointWME> ignore = new HashSet<ChokePointWME>();
		int index = 0;
		
//		for (PlayerUnitWME expo : expos.values()) {
//			
//			// get its region
//			RegionWME homeRegion = null;
//			for (RegionWME region : ABLStarCraftBot.getGame().getRegions()) {
//				if (region.contains(32*expo.getX(), 32*expo.getY())) {
//					homeRegion = region;
//					break;
//				}
//			}
//
//			if (homeRegion != null) {
//				if (index + 1 == expos.size()) {
//					ArrayList<ChokePointWME> chokes = new ArrayList<ChokePointWME>();
//					
//					for (ChokePointWME choke : homeRegion.getChokePoints()) {
//						if (!ignore.contains(choke)) {
//							chokes.add(choke);
//						}
//					}
//					
//					if (chokes.size() > 0) {
//						ChokePointWME choke = chokes.get((int)(Math.random()*chokes.size()));
//						return new Point(choke.getX(), choke.getY());
//					}
//				}
//				
//				ignore.addAll(homeRegion.getChokePoints());
//			}
//			
//			index++;
//		}

		for (PlayerUnitWME expo : expos.values()) {
			
			// get its region
			RegionWME homeRegion = null;
			for (RegionWME region : ABLStarCraftBot.getGame().getRegions()) {
				if (region.contains(32*expo.getX(), 32*expo.getY())) {
					homeRegion = region;
					break;
				}
			}

			if (homeRegion != null) {
//				if (index + 1 == expos.size()) {
				if (expos.size() == 1 || index > 0) {
					ArrayList<ChokePointWME> chokes = new ArrayList<ChokePointWME>();
					
					for (ChokePointWME choke : homeRegion.getChokePoints()) {
						if (!ignore.contains(choke)) {
							chokes.add(choke);
						}
					}
					
					if (chokes.size() > 0) {
						ChokePointWME choke = chokes.get((int)(Math.random()*chokes.size()));
						return new Point(choke.getX(), choke.getY());
					}
				}
				
				ignore.addAll(homeRegion.getChokePoints());
			}
			
			index++;
		}
		
		
		return new Point(x, y);
	}

	public Point getPylonOpenSpace(Game game, UnitWME nexus, int probeID) {
		
		// get its region
		RegionWME homeRegion = null;
		for (RegionWME region : game.getRegions()) {
			if (region.contains(32*nexus.getX(), 32*nexus.getY())) {
				homeRegion = region;
				break;
			}
		}
		
		if (homeRegion == null) {
			return null;
		}
		
		// compute unit occupied tiles
		boolean[] occupied = hasCreep.clone();
		for (UnitWME unit : game.getUnits()) {
			if (unit.getID() != probeID) {
				for (int w=0; w<unit.getType().getTileWidth(); w++) {
					for (int h=0; h<unit.getType().getTileHeight(); h++) {
						int index = (unit.getY() + h)*mapWidth + unit.getX() + w;
						
						if (index >= 0 && index < occupied.length) {
							occupied[index] = true;
						}
					}
				}
			}			
		}		
		
		Point closest = null;
		double dist = 0;
		int maxSpace = 10;
		
//		for (int i=0; i<1000; i++) {
		for (int tx=homeRegion.getMinTileX(); tx<=homeRegion.getMaxTileX(); tx++) {
			for (int ty=homeRegion.getMinTileY(); ty<=homeRegion.getMaxTileY(); ty++) {
			
//			int tx = homeRegion.getMinTileX() + (int)(random.nextDouble()*(homeRegion.getMaxTileX() - homeRegion.getMinTileX()));
//			int ty = homeRegion.getMinTileY() + (int)(random.nextDouble()*(homeRegion.getMaxTileY() - homeRegion.getMinTileY()));

				// map boundaries
				if (tx + 1 >= mapWidth || tx < 0 || ty + 1 >= mapHeight || ty < 0) {
					continue;
				}
				
				// keep in region
				if (!homeRegion.contains(32*tx, 32*ty)) {
					continue;
				}
	
				// terrain
				if (!buildable[ty][tx]) continue;
				if (!buildable[ty + 1][tx]) continue;
				if (!buildable[ty][tx + 1]) continue;
				if (!buildable[ty + 1][tx + 1]) continue;
	
				// units
				if (occupied[(ty)*mapWidth + tx]) continue;
				if (occupied[(ty + 1)*mapWidth + tx]) continue;
				if (occupied[(ty)*mapWidth + tx + 1]) continue;
				if (occupied[(ty + 1)*mapWidth + tx + 1]) continue;
	
				int distance = 0;
				
				depthLoop:
				for (int d=0; d<=maxSpace; d++) {
					distance = d;
					for (int x=-d; x<=d; x++) {
						for (int y=-d; y<=d; y++) {
							if (Math.abs(x) == d || Math.abs(y) == d) {
								
								// map boundaries
								if (tx + x + 1 >= mapWidth || tx + x < 0 || ty + y + 1 >= mapHeight || ty + y < 0) {
									break depthLoop;
								}
								
								// terrain
								if (!buildable[ty + y][tx + x]) break depthLoop;
								if (!buildable[ty + y + 1][tx + x]) break depthLoop;
								if (!buildable[ty + y][tx + x + 1]) break depthLoop;
								if (!buildable[ty + y + 1][tx + x + 1]) break depthLoop;
	
								// units
								if (occupied[(ty + y)*mapWidth + tx + x]) break depthLoop;
								if (occupied[(ty + y + 1)*mapWidth + tx + x]) break depthLoop;
								if (occupied[(ty + y)*mapWidth + tx + x + 1]) break depthLoop;
								if (occupied[(ty + y + 1)*mapWidth + tx + x + 1]) break depthLoop;
							}
						}					
					}
				}
				
				if (distance == maxSpace) {
					return new PylonLocation(tx, ty, StarCraftConstants.PYLON_OPEN);
				}
				
				if (closest == null || distance > dist) {
					closest = new PylonLocation(tx, ty, StarCraftConstants.PYLON_OPEN);
					dist = distance;
				}
			}
		}
		
		return closest;
	}
	
	public ArrayList<Point> getPylonBoundary(Game game, UnitWME nexus, int probeID) {
		ArrayList<Point> points = new ArrayList<Point>();

		// compute unit occupied tiles
		boolean[] occupied = hasCreep.clone();
		for (UnitWME unit : game.getUnits()) {
			if (unit.getID() != probeID) {
				for (int w=0; w<unit.getType().getTileWidth(); w++) {
					for (int h=0; h<unit.getType().getTileHeight(); h++) {
						int index = (unit.getY() + h)*mapWidth + unit.getX() + w;
						
						if (index >= 0 && index < occupied.length) {
							occupied[index] = true;
						}
					}
				}
			}			
		}		
		
		// get its region
		RegionWME homeRegion = null;
		for (RegionWME region : game.getRegions()) {
			if (region.contains(32*nexus.getX(), 32*nexus.getY())) {
				homeRegion = region;
				break;
			}
		}
		
		if (homeRegion == null) {
			return points;
		}
		
		pointLoop:
		for (Point point : homeRegion.getPoints()) {
			
			// dont build things too close
			for (Point p : points) {
				if (Math.abs(point.x/32 - p.x) < 10 && Math.abs(point.y/32 - p.y) < 10) {
					continue pointLoop;
				}				
			}
			
			int tx = point.x/32;
			int ty = point.y/32;

			// find a buildable spot
			for (int i=0; i<3; i++) {
				for (int x=-i; x<=i; x++) {
					for (int y=-i; y<=i; y++) {
						if (Math.abs(x) == i || Math.abs(y) == i) {

							// map boundaries
							if (tx + x + 1 >= mapWidth || tx + x < 0 || ty + y + 1 >= mapHeight || ty + y< 0) {
								continue;
							}
							
							// keep in region
							if (!homeRegion.contains(32*(tx + x), 32*ty + y)) {
								continue;
							}
							
							// terrain
							if (!buildable[ty + y][tx + x]) continue;
							if (!buildable[ty + y + 1][tx + x]) continue;
							if (!buildable[ty + y][tx + x + 1]) continue;
							if (!buildable[ty + y + 1][tx + x + 1]) continue;

							// units
							if (occupied[(ty + y)*mapWidth + tx + x]) continue;
							if (occupied[(ty + y + 1)*mapWidth + tx + x]) continue;
							if (occupied[(ty + y)*mapWidth + tx + x + 1]) continue;
							if (occupied[(ty + y + 1)*mapWidth + tx + x + 1]) continue;
							
							// check adjacent pylons
							for (UnitWME unit : game.getPlayerUnits()) {
								if (unit.getTypeID() == UnitTypes.Protoss_Pylon.ordinal()) {
									if (Math.abs(unit.getX() - (tx +x)) < 8 && Math.abs(unit.getY() - (ty +y)) < 8) {
										continue pointLoop;
									}
								}
							}
				
							points.add(new PylonLocation(tx + x, ty + y, StarCraftConstants.PYLON_BOUNDARY));
							continue pointLoop;
						}
					}							
				}						
			}					
		}

		return points;
	}

	public ArrayList<Point> getPylonChokepoint(Game game, UnitWME nexus, int probeID) {
		ArrayList<UnitWME> expos = new ArrayList<UnitWME>();
		ArrayList<Point> points = new ArrayList<Point>();

		if (nexus != null) {
			expos.add(nexus);
		}
		else {
			expos = game.getExpansions();
			
			// dont put a chokepoint pylon near the near if there are expos
			if (expos.size() == 0) {
				for (UnitWME unit : game.getPlayerUnits()) {
					if (unit.getTypeID() == UnitTypes.Protoss_Nexus.ordinal()) {
						expos.add(unit);
					}
				}
			}
		}
		
		// sort from oldest to newest
		Collections.sort(expos, new Comparator<UnitWME>() {
			public int compare(UnitWME o1, UnitWME o2) {
				return o1.getID() - o2.getID();
			}
		});

		// compute unit occupied tiles
		boolean[] occupied = hasCreep.clone();
		for (UnitWME unit : game.getUnits()) {
			if (unit.getID() != probeID) {
				for (int w=0; w<unit.getType().getTileWidth(); w++) {
					for (int h=0; h<unit.getType().getTileHeight(); h++) {
						int index = (unit.getY() + h)*mapWidth + unit.getX() + w;
						
						if (index >= 0 && index < occupied.length) {
							occupied[index] = true;
						}
					}
				}
			}			
		}		
		
		HashSet<ChokePointWME> visited = new HashSet<ChokePointWME>();
		for (UnitWME expo : expos) {

			// get its region
			RegionWME homeRegion = null;
			for (RegionWME region : game.getRegions()) {
				if (region.contains(32*expo.getX(), 32*expo.getY())) {
					homeRegion = region;
					break;
				}
			}
			
			if (homeRegion != null) {
				chokeLoop:
				for (ChokePointWME choke : homeRegion.getChokePoints()) {
					if (visited.contains(choke)) {
						continue;
					}
					else {
						visited.add(choke);
					}
					
					int tx = choke.getX();
					int ty = choke.getY();
 
					// find a buildable spot 
					for (int i=3; i<9; i++) {
						for (int x=-i; x<=i; x++) {
							for (int y=-i; y<=i; y++) {
								if (Math.abs(x) == i || Math.abs(y) == i) {
									
									// keep in region 
									if (!homeRegion.contains(32*(tx + x), 32*ty + y)) {
										continue;
									}
									
									// map boundaries
									if (tx + x + 1 >= mapWidth || tx + x < 0 || ty + y + 1 >= mapHeight || ty + y < 0) {
										continue;
									}
									
									// terrain
									if (!buildable[ty + y][tx + x]) continue;
									if (!buildable[ty + y + 1][tx + x]) continue;
									if (!buildable[ty + y][tx + x + 1]) continue;
									if (!buildable[ty + y + 1][tx + x + 1]) continue;

									// units
									if (occupied[(ty + y)*mapWidth + tx + x]) continue;
									if (occupied[(ty + y + 1)*mapWidth + tx + x]) continue;
									if (occupied[(ty + y)*mapWidth + tx + x + 1]) continue;
									if (occupied[(ty + y + 1)*mapWidth + tx + x + 1]) continue;
									
									// check adjacent pylons
									for (UnitWME unit : game.getPlayerUnits()) {
										if (unit.getTypeID() == UnitTypes.Protoss_Pylon.ordinal()) {
											if (Math.abs(unit.getX() - (tx +x)) < 8 && Math.abs(unit.getY() - (ty +y)) < 8) {
												continue chokeLoop;
											}
										}
									}
						 
									points.add(new PylonLocation(tx + x, ty + y, StarCraftConstants.PYLON_CHOKE));
									continue chokeLoop;
								}
							}							
						}						
					}					
				}				
			}			
		}
		
		return points;
	}
	
	public Point getNextGeyser(Game game) {
		ArrayList<UnitWME> expos = new ArrayList<UnitWME>();
		
		for (UnitWME unit : game.getPlayerUnits()) {
			if (unit.getTypeID() == UnitTypes.Protoss_Nexus.ordinal() && unit.getActive()) {
				expos.add(unit);
			}
		}
		
		// sort from oldest to newest
		Collections.sort(expos, new Comparator<UnitWME>() {
			public int compare(UnitWME o1, UnitWME o2) {
				return o1.getID() - o2.getID();
			}
		});

		for (UnitWME unit : expos) {
			for (GeyserWME geyser : game.getGeysers()) {
				if (Math.abs(unit.getX() - geyser.getX()) < 10 && Math.abs(unit.getY() - geyser.getY()) < 10) {
					return new Point(geyser.getX(), geyser.getY());
				}
			}
		}

		return null;
	}
	
	public boolean getIsExpoAvailable() {
		return getNextExpansion(ABLStarCraftBot.getGame(), true) != null;
	}
	
	public ArrayList<Point> getExpansionLocations(Game game, boolean ignoreMinOnly, RegionWME homeRegion) {
		ArrayList<Point> locations = new ArrayList<Point>();
		
		for (BaseLocationWME location : game.getBaseLocations()) {
			boolean occupied = false;
 
			// make sure its not already taken
			for (UnitWME unit : game.getUnits()) {
				if (unit.getIsCenter()) {
					if (Math.abs(unit.getRealCenterX() - location.getRealX()) < 256 && Math.abs(unit.getRealCenterY() - location.getRealY()) < 256) {
						occupied = true;
						break;
					}
				}
			}
 
			// is this a natural? (connected to home region) 
			boolean natural = false; 						
			RegionWME expoRegion = null;
			for (RegionWME region : game.getRegions()) {
				if (region.contains(32*location.getX(), 32*location.getY())) {
					expoRegion = region;
					break;
				}
			}
			
			if (expoRegion != null) {
				for (ChokePointWME choke : expoRegion.getChokePoints()) {
					if (choke.getOtherRegion(expoRegion).equals(homeRegion)) {
						natural = true; 
						break;
					}
				}
			}
			
			// make sure there is no enemy presense nearby (unless a natural) 
			if (!natural) {
				for (ParticleWME particle : game.getParticleFilter().getParticles()) {
					if (Math.abs(particle.getRealX() - location.getRealX()) < 500 && Math.abs(particle.getRealY() - location.getRealY()) < 500) {
						occupied = true;
						break;
					}
				}
			}

			// ignore min only
			if (ignoreMinOnly) {	
				if (location.isMineralOnly()) {
					occupied = true;
				}
			}
			
			if (!occupied) {
				locations.add(new Point(location.getX(), location.getY()));
			}
		}

		return locations;
	}
	
	public Point getNextExpansion(Game game, boolean ignoreMinOnly) {
 
		// get the starting nexus (smallest ID)
		UnitWME home = null;
		for (UnitWME unit : game.getPlayerUnits()) {
			if (unit.getTypeID() == UnitTypes.Protoss_Nexus.ordinal()) {
				if (home == null || unit.getID() < home.getID()) {
					home = unit;
				}
			}
		}

		if (home == null) {
			return null;
		}
		
		// get its region
		RegionWME homeRegion = null;
		for (RegionWME region : game.getRegions()) {
			if (region.contains(32*home.getX(), 32*home.getY())) {
				homeRegion = region;
				break;
			}
		}
		
		if (homeRegion == null) {
			return null;
		}

		ArrayList<Point> locations = getExpansionLocations(game, ignoreMinOnly, homeRegion);
		if (locations.size() == 0) {
			return null;
		}

		LinkedList<RegionWME> fringe = new LinkedList<RegionWME>();
		HashMap<RegionWME,Integer> fringed = new HashMap<RegionWME,Integer>();
		fringe.add(homeRegion);
		fringed.put(homeRegion, 0);

		Point closest = null;
		int depth = 0;
		double dist = Double.MAX_VALUE;

		while (fringe.size() > 0) {
			RegionWME region = fringe.remove();
			if (closest != null && fringed.get(region) > depth) {	// new depth reached, exit if location found
				return closest;
			}
			
			for (Point location : locations) {
				if (region.contains(location.x*32, location.y*32)) {
					double distance = Double.MAX_VALUE;
			
					for (UnitWME unit : game.getPlayerUnits()) {
						if (unit.getIsBuilding()) {
							double dx = location.x - unit.getX();
							double dy = location.y - unit.getY();
							distance = Math.min(distance, Math.sqrt(dx*dx + dy*dy));
						}
					}
					if (closest == null || distance < dist) {
						closest = location;
						dist = distance;
						depth = fringed.get(region);
					}
				} 
			}

			for (ChokePointWME choke : region.getChokePoints()) {
				RegionWME connected = choke.getOtherRegion(region);
				
				if (!fringed.containsKey(connected)) {
					fringe.add(connected);
					fringed.put(connected, 1 + fringed.get(region));
				}
			}
		}

		return closest;
	}
 
	public int getNumExpoChokes(Game game) { 
		RegionWME region = getNextExpansionRegion(game, true);
		if (region != null) {
			return Math.min(region.getChokePoints().size(), 3);
		}
		
		return 2;
	}
	
	private RegionWME getNextExpansionRegion(Game game, boolean ignoreMinOnly) {

		// get the starting nexus (smallest ID)
		UnitWME home = null;
		for (UnitWME unit : game.getPlayerUnits()) {
			if (unit.getTypeID() == UnitTypes.Protoss_Nexus.ordinal()) {
				if (home == null || unit.getID() < home.getID()) {
					home = unit;
				}
			}
		}

		if (home == null) {
			return null;
		}

		// get its region
		RegionWME homeRegion = null;
		for (RegionWME region : game.getRegions()) {
			if (region.contains(32*home.getX(), 32*home.getY())) {
				homeRegion = region;
				break;
			}
		}
		
		if (homeRegion == null) {
			return null;
		}

		ArrayList<Point> locations = getExpansionLocations(game, ignoreMinOnly, homeRegion);
		if (locations.size() == 0) {
			return null;
		}

		LinkedList<RegionWME> fringe = new LinkedList<RegionWME>();
		HashMap<RegionWME,Integer> fringed = new HashMap<RegionWME,Integer>();
		fringe.add(homeRegion);
		fringed.put(homeRegion, 0);

		RegionWME closest = null;
		int depth = 0;
		double dist = Double.MAX_VALUE;

		while (fringe.size() > 0) {
			RegionWME region = fringe.remove();
			if (closest != null && fringed.get(region) > depth) {	// new depth reached, exit if location found
				return closest;
			}
			
			for (Point location : locations) {
				if (region.contains(location.x*32, location.y*32)) {
					double distance = Double.MAX_VALUE;
			
					for (UnitWME unit : game.getPlayerUnits()) {
						double dx = location.x - unit.getX();
						double dy = location.y - unit.getY();
						distance = Math.min(distance, Math.sqrt(dx*dx + dy*dy));
					}
					if (closest == null || distance < dist) {
						closest = region;
						dist = distance;
						depth = fringed.get(region);
					}
				} 
			}

			for (ChokePointWME choke : region.getChokePoints()) {
				RegionWME connected = choke.getOtherRegion(region);
				
				if (!fringed.containsKey(connected)) {
					fringe.add(connected);
					fringed.put(connected, 1 + fringed.get(region));
				}
			}
		}

		return closest;
	}

	/**
	 * Returns all possible build locations for Protoss structures (tile coordinates), excluding Nexus/Pylon/Assimilator 
	 */
	public ArrayList<Point> getBuildLocations(Game game, int tileWidth, int tileHeight, int probeID, int purpose, boolean padding) {		
		ArrayList<Point> locations = new ArrayList<Point>();
		
		if (purpose == StarCraftConstants.PYLON_CHOKE) {
			padding = true;
		}

		// compute unit occupied tiles  
		boolean[] occupied = hasCreep.clone();
		for (UnitWME unit : game.getUnits()) {
			if (unit.getID() != probeID) {
 
				// add padding to existing gateways 
				int offset = 0;
				if (unit.getTypeID() == StarCraftConstants.Protoss_Gateway) {
					offset = 1;
				}
				
				for (int w=-offset; w<(unit.getType().getTileWidth() + offset); w++) {
					for (int h=-offset; h<(unit.getType().getTileHeight() + offset); h++) {
						int index = (unit.getY() + h)*mapWidth + unit.getX() + w;
						
						if (index >= 0 && index < occupied.length) {
							occupied[index] = true;
						}
					}
				}
			}			
		} 
		  
		// factor in chokepoints  
		for (ChokePointWME chokepoint : game.getChokePoints()) {  
			if (chokepoint.getWidth() < 150)  {
				for (int x=-4; x<=4; x++) {
					for (int y=-3; y<=3; y++) {
						int tx = chokepoint.getX() + x;
						int ty = chokepoint.getY() + y;
						
						if (tx >= 0 && ty >= 0 && tx < mapWidth && ty < mapHeight) {
							occupied[ty*mapWidth + tx] = true; 
						}
					}
				}
			}
		}
		
		// dont block next expo location
		Point expoLocation = getNextExpansion(ABLStarCraftBot.getGame(), true);
		if (expoLocation != null) {
			for (int w=0; w<4; w++) {
				for (int h=0; h<3; h++) {
					int index = (expoLocation.y + h)*mapWidth + expoLocation.x + w;
					
					if (index >= 0 && index < occupied.length) {
						occupied[index] = true;
					}
				}
			}
		}
		
		// make sure gas collecting area is clear
		for (UnitWME expo : game.getPlayerUnits()) {
			if (expo.getTypeID() == UnitTypes.Protoss_Nexus.ordinal()) {
				
				// clear to assimilators
				for (UnitWME unit : game.getPlayerUnits()) {			
					if (unit.getTypeID() != UnitTypes.Protoss_Assimilator.ordinal()) {
						continue;
					}
					
					if (Math.abs(expo.getX() - unit.getX()) < 10 && Math.abs(expo.getY() - unit.getY()) < 10) { 
						// mark tiles in between mins as filled
						int minX = Math.min(unit.getX(), expo.getX());
						int maxX = Math.max(unit.getX() + unit.getType().getTileWidth() - 1, expo.getX() + expo.getType().getTileWidth() - 1);
						int minY = Math.min(unit.getY(), expo.getY());
						int maxY = Math.max(unit.getY() + unit.getType().getTileHeight() - 1, expo.getY() + expo.getType().getTileHeight() - 1);
						
						for (int x=minX; x<=maxX; x++) {
							for (int y=minY; y<=maxY; y++) {
								if (x < mapWidth && y < mapHeight) {
									occupied[y*mapWidth + x] = true;
								}
							}
						}
					}
				}
			
				// clear to geysers
				for (GeyserWME gas : game.getGeysers()) {			
					if (Math.abs(expo.getX() - gas.getX()) < 10 && Math.abs(expo.getY() - gas.getY()) < 10) {
						// mark tiles in between mins as filled
						int minX = Math.min(gas.getX(), expo.getX());
						int maxX = Math.max(gas.getX() + gas.getType().getTileWidth() - 1, expo.getX() + expo.getType().getTileWidth() - 1);
						int minY = Math.min(gas.getY(), expo.getY());
						int maxY = Math.max(gas.getY() + gas.getType().getTileHeight() - 1, expo.getY() + expo.getType().getTileHeight() - 1);
						
						for (int x=minX; x<=maxX; x++) {
							for (int y=minY; y<=maxY; y++) {
								if (x < mapWidth && y < mapHeight) {
									occupied[y*mapWidth + x] = true;
								}
							}
						}
					}
				}
			}
		}
		
		ArrayList<UnitWME> pylons = new ArrayList<UnitWME>();
		for (UnitWME unit : game.getPlayerUnits()) {
			if (unit.getTypeID() == UnitTypes.Protoss_Pylon.ordinal() && unit.getActive()) {
				pylons.add(unit);
			}
		} 

		// iterate through pylons
		for (UnitWME unit : pylons) {
			
//		for (UnitWME unit : game.getPlayerUnits()) {
			if (unit.getTypeID() != UnitTypes.Protoss_Pylon.ordinal() || !unit.getActive()) {
				continue;
			}

//			// is this the correct type of pylon?
			if (!(unit.getPurpose()== purpose || purpose == -1)) {
				continue;
			}
			 
			for (int x=-10; x<=10; x++) {
				loop:
				for (int y=-10; y<=10; y++) {
					int tx = (unit.getX() + x);
					int ty = (unit.getY() + y);
					
					// check map size
					if (tx < 0 || ty < 0 || (tx + tileWidth) > mapWidth || (ty + tileHeight) >= mapHeight) {	// height - 1 constraint due to GUI
						continue;
					}
					 
					// check terrain and unit collision					
					if (padding) {
						for (int w = -1; w<=tileWidth; w++) {
							for (int h=-1; h<=tileHeight; h++) {
								if ((ty + h) >= 0 && (tx + w) >= 0 && (ty + h) < mapHeight && (tx + w) < mapWidth) {
									if (!buildable[ty + h][tx + w]) {
										continue loop;
									}
									
									if (occupied[(ty + h)*mapWidth + tx + w]) {
										continue loop;
									}
								}
							}
						}
					}
					else {
						for (int w = 0; w<tileWidth; w++) {
							for (int h=0; h<tileHeight; h++) {
								if (!buildable[ty + h][tx + w]) {
									continue loop;
								}
								
								if (occupied[(ty + h)*mapWidth + tx + w]) {
									continue loop;
								}
							}
						}						
					}
					
					// check for power
					boolean buildable = false;
					int bx = tx - unit.getX() + 7;
				    int by = ty - unit.getY() + 5;
				    if (tileWidth == 4) bx++;
				    
				    if (bx >= 0 && by >= 0 && bx <= 14 && by <= 9 || (bx ==-1 && tileWidth == 3 && by>=3 && by<=6)) {	// 3x2 special case
				    	switch(by) {
				        case 0:
				          if ( tileHeight == 3 && bx >= 4 && bx <= 9 ) buildable = true;
				          break;
				        case 1:
				          if (bx >= 1 && bx <= 12) buildable = true;
				          break;
				        case 2:
				          if (bx <= 13) buildable = true;
				          break;
				        case 3:
				        case 4:
				        case 5:
				        case 6:
				        	buildable = true;
				        	break;
				        case 7:
				          if (bx <= 13) buildable = true;
				          break;
				        case 8:
				          if (bx >= 1 && bx <= 12) buildable = true;
				          break;
				        case 9:
				          if (bx >= 4 && bx <= 9) buildable = true;
				          break;
				        }
				    }				    
				    
				    if (buildable) {
				    	locations.add(new Point(tx, ty));
				    }
				}
			}
		}

		return locations;
	}
	
	/** the map name */
	private String mapName;
	
	/** number of tiles wide */
	private int mapWidth;

	/** number of tiles high */
	private int mapHeight;
	
	/** height array (valid values are 0,1,2) */
	private int[][] height;
	
	/** buildable array */
	private boolean[][] buildable;
	
	/** walkable array */
	private boolean[][] walkable;
		
//	/** 
//	 * Returns the map name.
//	 */
	public String getMapName() {
		return mapName;
	}
	
	private class PathNode {
		int x;
		int y; 
		PathNode parent;

		public PathNode(int x, int y, PathNode parent) {
			this.x = x;
			this.y = y;
			this.parent = parent;
		}
	}
	
	public Point getGatherPoint(int startX, int startY) {
		ArrayList<Point> shortest = new ArrayList<Point>();
		
		for (ParticleWME particle : ABLStarCraftBot.getGame().getParticleFilter().getParticles()) {
			ArrayList<Point> path = getPath(startX, startY, particle.getX(), particle.getY());
			
			if (shortest.size() == 0 || (path.size() > 0 && path.size() < shortest.size())) {
				shortest = path;
			}
		}
		
		if (shortest.size() > 0) {
			return shortest.get(Math.max(0, shortest.size() - 30));
		}
		else {
			return new Point(startX, startY);
		}
	}

	public ArrayList<Point> getPath(int startX, int startY, int endX, int endY) {
		
		HashSet<Integer> visited = new HashSet<Integer>();
		visited.add(startX + mapWidth*startY);

		LinkedList<PathNode> fringe = new LinkedList<PathNode>();
		fringe.add(new PathNode(startX, startY, null));
		
		while (fringe.size() > 0) {
			PathNode node = fringe.remove();
			if (node.x < 0 || node.y < 0 || node.x >= mapWidth || node.y >= mapHeight) {
				continue;
			}
			
			// walkable?
			if (!walkable[node.y][node.x]) {
				continue;
			}
			
			// path found
			if (node.x == endX && node.y == endY) {
				ArrayList<Point> path = new ArrayList<Point>();
				
				while (node != null) {
					path.add(0, new Point(node.x, node.y));
					node = node.parent;
				}
				
				return path;
			}
			// add neighbors
			else {
				ArrayList<PathNode> neighbors = new ArrayList<PathNode>();
				
				
				if (!visited.contains(node.x - 1 + mapWidth*node.y)) {
					visited.add(node.x - 1 + mapWidth*node.y);
					neighbors.add(new PathNode(node.x - 1, node.y, node));
				}
				if (!visited.contains(node.x + 1 + mapWidth*node.y)) {
					visited.add(node.x + 1 + mapWidth*node.y);
					neighbors.add(new PathNode(node.x + 1, node.y, node));
				}
				if (!visited.contains(node.x + mapWidth*(node.y - 1))) {
					visited.add(node.x + mapWidth*(node.y - 1));
					neighbors.add(new PathNode(node.x, node.y - 1, node));
				}
				if (!visited.contains(node.x + mapWidth*(node.y + 1))) {
					visited.add(node.x + mapWidth*(node.y + 1));
					neighbors.add(new PathNode(node.x, node.y + 1, node));
				}
				
//				Collections.shuffle(neighbors);
				fringe.addAll(neighbors);
			}
		}

		return new ArrayList<Point>();		
	}

	/**
	 * Returns the map width (in tiles).
	 */
	public int getMapWidth() {
		return mapWidth;
	}

	/**
	 * Returns the map height (in tiles).
	 */
	public int getMapHeight() {
		return mapHeight;
	}
	
	/**
	 * Returns true if the map is walkable and the given tile coordinates.
	 */
	public boolean isWalkable(int tx, int ty) {
		return walkable[ty][tx];
	}
	
	/**
	 * Returns true if the map is buildable and the given tile coordinates.
	 */
	public boolean isBuildable(int tx, int ty) {
		return buildable[ty][tx];
	}

	public boolean isBuildable(int tx, int ty, int width, int height) {
		boolean result = true;

		if (tx < 0 || ty < 0 || (tx + width) >= mapWidth || (ty + height) >= mapHeight) {
			return false;
		}

		for (int h=0; h<height; h++) {			
			for (int w=0; w<width; w++) {
				result &= buildable[ty + h][tx + w];
			}
		}

		return result;
	}


	/**
	 * Returns the height of the map at the given tile coordinates.
	 */
	public int getHeight(int tx, int ty) {
		return height[ty][tx];
	}

	private int leaderX;
	private int leaderY;
	private long lastInvoked;
	 
	// find closest unit to target
	public boolean setTarget(int attackX, int attackY) {
		if ((System.currentTimeMillis() - lastInvoked) < 1000) {
			return true;
		}
		
		lastInvoked = System.currentTimeMillis();
		leaderX = attackX;
		leaderY = attackY;
		
		int distance = Integer.MAX_VALUE; 
		PlayerUnitWME leader = null;

		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit instanceof GroundUnitWME && unit.getTask() == StarCraftConstants.FIGHTER_ATTACK) {
				if (leader==null || unit.getSpawnFrame() < leader.getSpawnFrame()) {
					leader = unit;
				}
				
//				int pathLength = getPath(unit.getX(), unit.getY(), attackX, attackY).size();
//				 
//				if (pathLength < 10) {
//					return false;
//				}
//				
//				if (pathLength > 0 && pathLength < distance) {
//					distance = pathLength;
//					leader = unit;
//				}
			}
		}

		if (leader != null) {
			leaderX = leader.getX();
			leaderY = leader.getY(); 
		}

		System.out.println("Path time: " + (System.currentTimeMillis() - lastInvoked));
		return true;
	}

//  (MapWME.setTarget(attackX, attackY))
//	(MapWME leaderX::leaderX leaderY::leaderY)
	
	public int getLeaderX() {
		return leaderX;
	}
	
	public int getLeaderY() {
		return leaderY;
	}	
	
	/**
	 * Creates a map based on the string recieved from the AIModule.
	 * 
	 * @param mapData - mapname:width:height:data
	 * 
	 *  Data is a character array where each tile is represented by 3 characters, 
	 *  which specific height, buildable, walkable.
	 */
	public MapWME(JNIBWAPI bwapi) {

		mapName = bwapi.getMap().getName();
		mapWidth = bwapi.getMap().getWidth();
		mapHeight = bwapi.getMap().getHeight();
		
		height = new int[mapHeight][mapWidth];
		buildable = new boolean[mapHeight][mapWidth];
		walkable = new boolean[mapHeight][mapWidth];
		hasCreep = new boolean[mapHeight*mapWidth];
  		
		int total = mapWidth * mapHeight;		
		for (int i=0; i<total; i++) {
			int x = i%mapWidth;
			int y = i/mapWidth;			
			height[y][x] = bwapi.getMap().getHeight(x, y);
			buildable[y][x] = bwapi.getMap().isBuildable(x, y); 
			walkable[y][x] = bwapi.getMap().isWalkable(4*x + 1, 4*y + 1) && bwapi.getMap().isWalkable(4*x + 2, 4*y + 1) 
						&& bwapi.getMap().isWalkable(4*x + 1, 4*y + 2) && bwapi.getMap().isWalkable(4*x + 2, 4*y + 2); 
 		}		
	}
	
	/**
	 * Displays the main properties.
	 */
	public void print() {
		System.out.println("Name: " + mapName);
		System.out.println("Size: " + mapWidth + " x " + mapHeight);
		
		System.out.println("\nBuildable");
	 	  System.out.println("---------");
		for (int y=0; y<mapHeight; y++) {
			for (int x=0; x<mapWidth; x++) {
				System.out.print(buildable[y][x] ? " " : "X");
			}			
			
			System.out.println();
		}

		System.out.println("\nWalkable");
	 	  System.out.println("--------");
		for (int y=0; y<mapHeight; y++) {
			for (int x=0; x<mapWidth; x++) {
				System.out.print(walkable[y][x] ? " " : "X");
			}			
			
			System.out.println();
		}

		System.out.println("\nHeight");
	 	  System.out.println("------");
		for (int y=0; y<mapHeight; y++) {
			for (int x=0; x<mapWidth; x++) {
				switch (height[y][x]) {
					case 2:
						System.out.print(" " );
						break;
					case 1:
						System.out.print("*" );
						break;
					case 0:
						System.out.print("X" );
						break;
				}
			}			
			
			System.out.println();
		}
	}	
}