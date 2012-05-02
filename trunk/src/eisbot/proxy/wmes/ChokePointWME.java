package eisbot.proxy.wmes;

import java.util.ArrayList;
import java.util.HashMap;

import wm.WME;
import eisbot.abl.StarCraftConstants;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.model.ChokePoint;
/**
 * Represents a starting location in StarCraft.
 * 
 * Note: x and y are in tile coordinates
 */
public class ChokePointWME extends WME {

	private int x;

	private int y;

	private int width;

	private RegionWME regionA;
	private RegionWME regionB;

	private int searchDistance = -1;
	private WME searchTarget = null;

	private RegionWME next = null;

	/**
	 * Parses the starting locations.
	 */
	public static ArrayList<ChokePointWME> getLocations(JNIBWAPI bwapi, ArrayList<RegionWME> regions) {
		ArrayList<ChokePointWME> locations = new ArrayList<ChokePointWME>();

		HashMap<Integer, RegionWME> regionMap = new HashMap<Integer, RegionWME>();
		for (RegionWME region : regions) {
			regionMap.put(region.getID(), region);
		}

		for (ChokePoint point : bwapi.getMap().getChokePoints()) {

			ChokePointWME loc = new ChokePointWME();
			loc.x = point.getCenterX();
			loc.y = point.getCenterY();
			loc.width = (int)point.getRadius();
	
			int region1 = point.getFirstRegionID();
			int region2 = point.getSecondRegionID();
			loc.regionA = regionMap.get(region1);
			loc.regionB = regionMap.get(region2);

			loc.regionA.getChokePoints().add(loc);
			loc.regionB.getChokePoints().add(loc);
			locations.add(loc);
		}
		
		return locations;		
	}
	
	public RegionWME getOtherRegion(RegionWME region) {
		return region.equals(regionA) ? regionB : regionA;
	}
	
	/**
	 * Returns the x coordinate (tile coordinates).
	 */
	public int getX() {
		return x/StarCraftConstants.PIXELS_PER_TILE;
	}

	/**
	 * Returns the y coordinate (tile coordinates).
	 */
	public int getY() {
		return y/StarCraftConstants.PIXELS_PER_TILE;
	}

	/**
	 * Returns the x coordinate (pixel coordinates)
	 */
	public int getRealX() {
		return x;
	}

	/**
	 * Returns the y coordinate (pixel coordinates)
	 */
	public int getRealY() {
		return y;
	}

	public int getWidth() {
		return width;
	}
	
	public String toString() {
		return x + "," + y;
	}
}