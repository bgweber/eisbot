package eisbot.proxy.wmes;

import java.util.ArrayList;

import wm.WME;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.model.BaseLocation;
import eisbot.proxy.model.Unit;
/**
 * Represents a starting location in StarCraft.
 * 
 * Note: x and y are in tile coordinates
 */
public class BaseLocationWME extends WME {

	private int x;
	
	private int y;

	private int realX;
	
	private int realY;
	
	private boolean mineralOnly = true;

	/**
	 * Parses the starting locations.
	 */
	public static ArrayList<BaseLocationWME> getLocations(JNIBWAPI bwapi) {
		ArrayList<BaseLocationWME> locations = new ArrayList<BaseLocationWME>();

		for (BaseLocation location : bwapi.getMap().getBaseLocations()) {
			BaseLocationWME loc = new BaseLocationWME();
			loc.realX = location.getX();
			loc.realY = location.getY();
			loc.x = location.getTx();
			loc.y = location.getTy();
			
			for (Unit gas : bwapi.getGeysers()) {
				if (Math.abs(gas.getX() - location.getX()) < 320 && Math.abs(gas.getY() - location.getY()) < 320) {
					loc.mineralOnly = false;
				}
			}

			locations.add(loc);
		}
		
		return locations;		
	}
 
	public boolean isMineralOnly() {
		return mineralOnly;
	}
	
	public int getRealX() {
		return realX;
	}

	public int getRealY() {
		return realY;
	}

	/**
	 * Returns the x coordinate of the starting location (tile coordinates).
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the y coordinate of the starting location (tile coordinates).
	 */
	public int getY() {
		return y;
	}
	
	public String toString() {
		return x + "," + y;
	}
}
