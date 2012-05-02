package eisbot.proxy.wmes;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import wm.WME;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.model.Region;


public class RegionWME extends WME {

	/**
	 * Parses the regions.
	 * @throws InstantiationException 
	 */
	public static ArrayList<RegionWME> getRegions(MapWME map, JNIBWAPI bwapi) {
		ArrayList<RegionWME> locations = new ArrayList<RegionWME>();

		for (Region r : bwapi.getMap().getRegions()) {

			RegionWME region = new RegionWME();
			region.id = r.getID();
			region.centerX = r.getCenterX();
			region.centerY = r.getCenterY();
			region.numPoints = r.getCoordinates().length/2;
			region.x = new int[region.numPoints];
			region.y = new int[region.numPoints];

			region.xmax = 0;
			region.ymax = 0;
			region.xmin = Integer.MAX_VALUE;
			region.ymin = Integer.MAX_VALUE;
			for (int i = 0; i < region.numPoints; i++) {
				region.x[i] = r.getCoordinates()[2*i];
				region.y[i] = r.getCoordinates()[2*i + 1];
				region.points.add(new Point(region.x[i], region.y[i]));				
				
				if (region.x[i] < region.xmin) {
					region.xmin = region.x[i];
				}
				if (region.x[i] > region.xmax) {
					region.xmax = region.x[i];
				}
				if (region.y[i] < region.ymin) {
					region.ymin = region.y[i];
				}
				if (region.y[i] > region.ymax) {
					region.ymax = region.y[i];
				}
			}

			// close the poly
			region.x[region.x.length - 1] = region.x[0];
			region.y[region.y.length - 1] = region.y[0];
			region.polygon = new Polygon(region.x, region.y, region.numPoints);

			locations.add(region);
		}

		return locations;
	}

	private int centerX;

	private int centerY;

	private int id;
	
	private ArrayList<Point> points = new ArrayList<Point>();
	
	private Polygon polygon;

	/**
	 * These are the pixel-coordinate points that trace the edge of the polygon.
	 */
	private int numPoints;

	private int x[];
	private int y[];

	private int xmin, xmax, ymin, ymax;

	private int searchDistance = -1;

	private WME searchTarget = null;
	private ChokePointWME next = null;

	public boolean contains(int realX, int realY) {
		return polygon.contains(new Point(realX, realY));
	}
	
	private List<ChokePointWME> chokePoints = new ArrayList<ChokePointWME>();

	public ArrayList<Point> getPoints() {
		return points;
	}

	public int getCenterX() {
		return this.centerX / 32;
	}

	public int getCenterY() {
		return this.centerY / 32;
	}

	public List<ChokePointWME> getChokePoints() {
		return this.chokePoints;
	}

	public int getMaxTileX() {
		return this.xmax / 32;
	}

	public int getMinTileX() {
		return this.xmin / 32;
	}

	public int getMaxTileY() {
		return this.ymax / 32;
	}

	public int getMinTileY() {
		return this.ymin / 32;
	}

	public int getID() {
		return this.id;
	}

	public int getNumPoints() {
		return this.numPoints;
	}

	public int[] getPointsX() {
		return this.x;
	}

	public int[] getPointsY() {
		return this.y;
	}

	public int getRealCenterX() {
		return this.centerX;
	}

	public int getRealCenterY() {
		return this.centerY;
	}
}