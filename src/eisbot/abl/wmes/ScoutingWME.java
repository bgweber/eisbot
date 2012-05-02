package eisbot.abl.wmes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import tuple.Pair;
import wm.WME;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Logger;
import eisbot.abl.StarCraftConstants;
import eisbot.proxy.wmes.StartingLocationWME;
import eisbot.proxy.wmes.unit.UnitWME;


public class ScoutingWME extends WME {

	protected int workerID = StarCraftConstants.NULL_UNIT;
	protected Queue<Pair<Integer, Integer>> destinations = new LinkedList<Pair<Integer, Integer>>();
	protected boolean enroute = false;

	public int getWorkerID() {
		return workerID;
	}

	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}

	public void clearWorkerID() {
		this.workerID = StarCraftConstants.NULL_UNIT;
	}

	public boolean getHasWorker() {
		return ABLStarCraftBot.getGame().getUnitByID(this.workerID) != null;
	}

	public int getNumDestinations() {
		return destinations.size();
	}

	public void clearDestinations() {
		destinations.clear();
	}

	public void pushDestination(int dstx, int dsty) {
		destinations.add(new Pair<Integer, Integer>(dstx, dsty));
	}

	public Pair<Integer, Integer> popDestination() {
		return destinations.remove();
	}

	public Pair<Integer, Integer> peekDestination() {
		return destinations.peek();
	}

	public int getNextX() {
		return destinations.peek().fst;
	}

	public int getNextY() {
		return destinations.peek().snd;
	}

	public boolean getArrived() {
		if (destinations.size() == 0) {
			return false;
		}
		Pair<Integer, Integer> dst = destinations.peek();
		UnitWME worker = ABLStarCraftBot.getGame().getUnitByID(workerID);
		double dx = worker.getX() - dst.fst;
		double dy = worker.getY() - dst.snd;
		return Math.sqrt(dx*dx + dy*dy) < StarCraftConstants.DISTANCE_ARRIVED;
	}

	public boolean getEnroute() {
		return enroute;
	}

	public void setEnroute(boolean enr) {
		enroute = enr;
	}

	@SuppressWarnings("unchecked")
	public boolean enqueueScoutStartingLocations(int unitx, int unity) {
		int i;
		int fromx = unitx;
		int fromy = unity;
		ArrayList<StartingLocationWME> startingLocations, visited;
		ArrayList<Pair<Double, StartingLocationWME>> distances;
		StartingLocationWME sl;

		startingLocations = (ArrayList<StartingLocationWME>) ABLStarCraftBot.getGame().getStartingLocations().clone();

		sl = ABLStarCraftBot.getGame().getPlayerStart();
		startingLocations.remove(sl);

		distances = new ArrayList<Pair<Double, StartingLocationWME>>();
		visited = new ArrayList<StartingLocationWME>();
		while (visited.size() < startingLocations.size()) {
			for (i=0; i < startingLocations.size(); ++i) {
				sl = startingLocations.get(i);
				Logger.print("ScoutingWME", "Considering location (" + sl.getX() + ", " + sl.getY() + ") ...");
				if (visited.contains(sl)) {
					Logger.print("ScoutingWME", "  ...visited!");
					continue;
				}
				distances.add(new Pair<Double, StartingLocationWME>(UnitQueryWME.distance(fromx, fromy, sl.getX(), sl.getY()), sl));
				Logger.print("ScoutingWME", "  ...distance: " + distances.get(distances.size() - 1).fst);
			}
			if (distances.size() == 0) {
				Logger.print("ScoutingWME", "  ...no locations left unvisited.");
				break;
			}
			Collections.sort(distances, new Comparator<Pair<Double, StartingLocationWME>> () {
				public int compare(Pair<Double, StartingLocationWME> first, Pair<Double, StartingLocationWME> second) {
					double val = first.fst - second.fst;
					if (val < 0) {
						return -1;
					} else if (val > 0) {
						return 1;
					}
					return 0;
				}
			});
			sl = distances.get(0).snd;
			Logger.print("ScoutingWME", "Closest: (" + sl.getX() + ", " + sl.getY() + ") at distance " + distances.get(0).fst);
			visited.add(sl);
			distances.clear();
			Logger.print("ScoutingWME", "Enqueueing location (" + sl.getX() + ", " + sl.getY() + ")");
			this.pushDestination(sl.getX(), sl.getY());
			fromx = sl.getX();
			fromy = sl.getY();
		}
		return true;
	}
}