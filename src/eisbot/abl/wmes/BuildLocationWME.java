package eisbot.abl.wmes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import tuple.Pair;
import wm.WME;
import abl.runtime.BehavingEntity;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Logger;
import eisbot.abl.StarCraftConstants;
import eisbot.proxy.wmes.BaseLocationWME;
import eisbot.proxy.wmes.MapWME;
import eisbot.proxy.wmes.StartingLocationWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.unit.GeyserWME;
import eisbot.proxy.wmes.unit.MineralWME;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
import eisbot.proxy.wmes.unit.UnitWME;
/**
 *
 * TODO: factor in low-ground versus high ground, territory, etc.
 */
public class BuildLocationWME extends WME {

	private int xLocation;
	private int yLocation;
	
	private final static int MAX_SEARCH_RANGE = 12;
	private final static int MIN_BUFFER_DISTANCE = 5;
	private final static int DESIRED_BUFFER_DISTANCE = 7;
	private final static int RESOURCE_EXTRA_BUFFER = 2;

	private MapWME mapWME;

	@SuppressWarnings("unchecked")
	public boolean chooseAnyLocation(int typeID) {
		LinkedList<PlayerUnitWME> buildings = ABLStarCraftBot.getBehavingEntity().lookupWME(PlayerUnitWME.class.getSimpleName());

		LinkedList<PlayerUnitWME> toremove = new LinkedList<PlayerUnitWME>();

		for (PlayerUnitWME building : buildings) {
			if (!building.getIsBuilding()) {
				toremove.add(building);
			}
		}

		for (PlayerUnitWME remove : toremove) {
			buildings.remove(remove);
		}

		Collections.shuffle(buildings);

		for (PlayerUnitWME building : buildings) {
			if (chooseLocation(building.getX(), building.getY(), typeID)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean chooseLocation(int x, int y, int typeID) {
		if (mapWME == null) {
			mapWME = ABLStarCraftBot.getGame().getMap();
		}

		UnitTypeWME type = UnitTypeWME.getType(typeID);
		int width = type.getTileWidth();
		int height = type.getTileHeight();

		if (typeID == StarCraftConstants.Terran_Factory) width += 3;
		if (typeID == StarCraftConstants.Terran_Starport) width += 3;
		if (typeID == StarCraftConstants.Terran_Physics_Lab) width += 3;

		Logger.print("BuildLocationWME", "Searching from (" + x + ", " + y + ")");

		// TODO: need to reference current construction WMEs
 
		LinkedList<PlayerUnitWME> units = ABLStarCraftBot.getBehavingEntity().lookupWME(PlayerUnitWME.class.getSimpleName());
		LinkedList<MineralWME> minerals = ABLStarCraftBot.getBehavingEntity().lookupWME(MineralWME.class.getSimpleName());
		LinkedList<GeyserWME> geysers = ABLStarCraftBot.getBehavingEntity().lookupWME(GeyserWME.class.getSimpleName());
		LinkedList<BaseLocationWME> expolocs = ABLStarCraftBot.getBehavingEntity().lookupWME(BaseLocationWME.class.getSimpleName());
		LinkedList<ConstructionWME> projects = ABLStarCraftBot.getBehavingEntity().lookupWME(ConstructionWME.class.getSimpleName());

		for (int buffer = DESIRED_BUFFER_DISTANCE; buffer >= MIN_BUFFER_DISTANCE; --buffer) {
			for (int range=0; range < MAX_SEARCH_RANGE; ++range) {
				
				ArrayList<Pair<Integer, Integer>> locs = new ArrayList<Pair<Integer, Integer>>();
	
				for (int ty=-range; ty<=range; ty++) {
					for (int tx=-range; tx<=range; tx++) {
						if (Math.abs(tx) == range || Math.abs(ty) == range) {
							int testx = x + tx;
							int testy = y + ty;
	
							locs.add(new Pair<Integer, Integer>(testx, testy));
						}
					}
				}
	
				Collections.shuffle(locs);
	
				locLoop:
				for (Pair<Integer, Integer> loc : locs) {
					int testx = loc.fst;
					int testy = loc.snd;
	
					if (!mapWME.isBuildable(testx, testy, width, height)) {
						continue locLoop;
					}
	
					for (PlayerUnitWME unit : units) {
						if (unit.distance(testx, testy) < buffer) {
							continue locLoop;
						}
					}
	
					for (BaseLocationWME expo : expolocs) {
						if (Math.pow(expo.getX() - testx, 2) + Math.pow(expo.getY() - testy, 2) < buffer*buffer) {
							continue locLoop;
						}
					}
	
					for (ConstructionWME project: projects) {
						if (Math.pow(project.getX() - testx, 2) + Math.pow(project.getY() - testy, 2) < buffer*buffer) {
							continue locLoop;
						}
					}
	
					for (MineralWME min : minerals) {
						if (min.distance(testx, testy) < buffer + RESOURCE_EXTRA_BUFFER) {
							continue locLoop;
						}
					}
	
					for (GeyserWME gas : geysers) {
						if (gas.distance(testx, testy) < buffer + RESOURCE_EXTRA_BUFFER) {
							continue locLoop;
						}
					}
	
					Logger.print("BuildLocationWME", "Range: " + range);
					Logger.print("BuildLocationWME", "Result " + testx + ":" + testy);
					xLocation = testx;
					yLocation = testy;
					return true;
				}
			}
		}

		Logger.print("BuildLocationWME", "No suitable build locaitons found near (" + x + ", " + y + ")");
		return false;
	}

	public boolean chooseExpansionLocation() {
		if (mapWME == null) {
			mapWME = ABLStarCraftBot.getGame().getMap();
		}

		final StartingLocationWME start = ABLStarCraftBot.getGame().getPlayerStart();
		StartingLocationWME enemyStart = ABLStarCraftBot.getGame().getEnemyStart();

		LinkedList<UnitWME> units = ABLStarCraftBot.getBehavingEntity().lookupWME(UnitWME.class.getSimpleName());

		ArrayList<BaseLocationWME> expansionLocations = ABLStarCraftBot.getGame().getBaseLocations();

		ArrayList<BaseLocationWME> valid = new ArrayList<BaseLocationWME>();

		expoLoop:
		for( BaseLocationWME loc:expansionLocations ) {
			for (UnitWME unit : units) {
				// TODO: Handle obstruction better...
				if (unit.distance(loc.getX(), loc.getY()) < MIN_BUFFER_DISTANCE) {
					continue expoLoop;
				}
			}

			valid.add(loc);
		}

		Collections.sort(valid, new Comparator<BaseLocationWME> () {
			public int compare(BaseLocationWME first, BaseLocationWME second) {
				return distance(start.getX(), start.getY(), first.getX(), first.getY()) -
					   distance(start.getX(), start.getY(), second.getX(), second.getY());
			}

			private int distance(int x, int y, int x2, int y2) {
				return (int) (Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
			}
		});

		// Remove the closest result (which will be our base):
		valid.remove(0);

		if( valid.size() < 2 ) {
			Logger.print("BuildLocationWME", "No valid expansion locations found!");
			return false;
		}

		// TODO: Handle unreachable locations...
		// TODO: More intelligent location selection...
		if( enemyStart == null ) {
			xLocation = valid.get(0).getX();
			yLocation = valid.get(0).getY();
		} else {
			if( Math.pow(valid.get(0).getX() - enemyStart.getX(), 2) + Math.pow(valid.get(0).getY() - enemyStart.getX(), 2) <
				Math.pow(valid.get(1).getX() - enemyStart.getX(), 2) + Math.pow(valid.get(1).getY() - enemyStart.getX(), 2)) {
				xLocation = valid.get(0).getX();
				yLocation = valid.get(0).getY();
			} else {
				xLocation = valid.get(1).getX();
				yLocation = valid.get(1).getY();
			}
		}

		return true;
	}

	public int getXLocation() {
		return xLocation;
	}

	public int getYLocation() {
		return yLocation;
	}
}