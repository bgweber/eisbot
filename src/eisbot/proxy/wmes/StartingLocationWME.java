package eisbot.proxy.wmes;

import java.util.ArrayList;

import wm.WME;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.model.BaseLocation;
/**
 * Represents a starting location in StarCraft.
 * 
 * Note: x and y are in tile coordinates
 */
public class StartingLocationWME extends WME {

	private int x;
	
	private int y;
		
	/**
	 * Parses the starting locations.
	 */
	public static ArrayList<StartingLocationWME> getLocations(JNIBWAPI bwapi) {
		ArrayList<StartingLocationWME> locations = new ArrayList<StartingLocationWME>();
	
		for (BaseLocation location : bwapi.getMap().getBaseLocations()) {
			if (location.isStartLocation()) {			
				StartingLocationWME loc = new StartingLocationWME();
				loc.x = location.getTx(); 
				loc.y = location.getTy(); 
				locations.add(loc);
			}
		}
		
		return locations;		
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
