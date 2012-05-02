package eisbot.abl.wmes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import tuple.Pair;
import wm.WME;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.StarCraftConstants;
import eisbot.proxy.wmes.MapWME;
import eisbot.proxy.wmes.unit.UnitWME;

// TODO: Address diagonal bias?
public class UnitQueryWME extends WME {
	/**
	 * Set by setLocation, used by various queries.
	 */
	int srcx = -1;
	int srcy = -1;

	/**
	 * Set by setDestination, used by various queries.
	 */
	int dstx = -1;
	int dsty = -1;

	/**
	 * Set by setType, used by queries.
	 */
	int type = StarCraftConstants.NULL_UNIT;

	/**
	 * Set by setSide, used by queries.
	 * Note that the bot's ID is:
	 *   ABLStarCraftBot.getGame().getPlayer().getPlayerID();
	 */
	int playerID = -1;

	boolean enemy = false;
	boolean worker = false;
	boolean center = false;
	boolean flying = false;
	boolean ground = false;

	/**
	 * Set by setScoutingWME, used by scouting-specific queries.
	 */
	ScoutingWME scoutingwme = null;
	
	/**
	 * The maximum Euclidian distance at which to attempt BFS.
	 * TODO: Tune this!
	 */
	static final double MAX_BFS_DISTANCE = 50;
	
	/**
	 * The distance result of a search.
	 */
	double distance = Double.MAX_VALUE;

	/**
	 * A list of all units. This list is kept up-to-date by calling the update() method.
	 */
	ArrayList<UnitWME> allUnits = null;

	public boolean setLocation(int x, int y) {
		srcx = x;
		srcy = y;
		return true;
	}

	public boolean setLocationPixels(int x, int y) {
		srcx = (int) (x/32);
		srcy = (int) (y/32);
		return true;
	}

	public boolean setLocationUnit(int unitID) {
		UnitWME unit = ABLStarCraftBot.getGame().getUnitByID(unitID);
		if (unit == null) {
			return false;
		}

		srcx = unit.getX();
		srcy = unit.getY();
		return true;
	}

	public boolean setDestination(int x, int y) {
		dstx = x;
		dsty = y;
		return true;
	}

	public boolean setType(int type) {
		this.type = type;
		return true;
	}
	
	public boolean setIsCenter(boolean iscenter) {
		this.center = iscenter;
		return true;
	}
	
	public boolean setIsWorker(boolean isworker) {
		this.worker = isworker;
		return true;
	}
	
	public boolean setIsEnemy(boolean isenemy) {
		this.enemy = isenemy;
		return true;
	}

	public boolean setIsFlying(boolean isflying) {
		this.flying = isflying;
		return true;
	}

	public boolean setIsGround(boolean isground) {
		this.ground = isground;
		return true;
	}

	public boolean setPlayer(int playerID) {
		this.playerID = playerID;
		return true;
	}

	public boolean setPlayerMe() {
		this.playerID = ABLStarCraftBot.getGame().getPlayer().getPlayerID();
		return true;
	}
	
	/**
	 * Refreshes the internal state. Called internally before lookups are done.
	 */
	private void update() {
		distance = Double.MAX_VALUE;
		allUnits = ABLStarCraftBot.getGame().getUnits();
	}
	
	/**
	 * Refreshes conditions. Should be called between different searches.
	 */
	public boolean getFresh() {
		this.srcx = -1;
		this.srcy = -1;
		this.dstx = -1;
		this.dsty = -1;
		this.type = StarCraftConstants.NULL_UNIT;
		this.playerID = -1;
		this.enemy = false;
		this.worker = false;
		this.center = false;
		this.flying = false;
		this.ground = false;
		return true;
	}
	
	/**
	 * @return The distance result of a search call. If called before a search, it
	 * returns double.MAX_VALUE. However, in some cases where a search fails, it may
	 * also return double.MAX_VALUE.
	 */
	public double getDistance() {
		return this.distance;
	}
	
	public int getNearest() {
		return this.getNearestEuclidian();
	}
	
	public int getNearestEuclidian() {
		UnitWME nearest = null;

		this.update();

		for (UnitWME unit : allUnits) {
			if (meetsConditions(unit)) {
				double dist = distance(unit.getX(), unit.getY(), srcx, srcy);
				if (dist < distance) {
				distance = dist;
				nearest = unit;
				}
			}
		}
		if (nearest != null) {
			return nearest.getID();
		}
		return StarCraftConstants.NULL_UNIT;
	}

	public boolean setScoutingWME(ScoutingWME wme) {
		this.scoutingwme = wme;
		return true;
	}

	/**
	 * Computes Euclidian distance within a positive map space.
	 * @param sx The source x-coordinate.
	 * @param sy The source y-coordinate.
	 * @param dx The destination x-coordinate.
	 * @param dy The destination y-coordinate.
	 * @return The Euclidian distance from the source to the destination, or Double.MAX_VALUE if any of the coordinates are negative.
	 */
	public final static double distance(int sx, int sy, int dx, int dy) {
		if (sx < 0 || sy < 0 || dx < 0 || dy < 0) {
			return Double.MAX_VALUE;
		}
		return Math.sqrt(Math.pow(dx - sx, 2) + Math.pow(dy - sy, 2));
	}

	public final double getFlightDistance() {
		return Math.sqrt(Math.pow(srcx - dstx, 2) + Math.pow(srcy - dsty, 2));
	}
	
	private final boolean meetsConditions(UnitWME unit) {
		if (this.type != StarCraftConstants.NULL_UNIT && this.type != unit.getTypeID()) { return false; }
		if (this.playerID != -1 && this.playerID != unit.getPlayerID()) { return false; }
		if (this.center && !(unit.getIsCenter())) { return false; }
		if (this.worker && !(unit.getIsWorker())) { return false; }
		if (this.enemy && (this.playerID == unit.getPlayerID() ||
		           ABLStarCraftBot.getGame().getPlayerByID(unit.getPlayerID()).isAlly())) { return false; }
		if (this.flying && !unit.getIsAirborne()) { return false; }
		if (this.ground && unit.getIsAirborne()) { return false; }
		return true;
	}
}