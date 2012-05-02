package eisbot.abl.wmes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import wm.WME;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Logger;
import eisbot.proxy.wmes.unit.MineralWME;

public class AllMineralsWME extends WME {

	ArrayList<Patch> patches = new ArrayList<Patch>();
	HashSet<Integer> claimed = new HashSet<Integer>();
	HashMap<Integer, Integer> assigned = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> centerAssignments = new HashMap<Integer, Integer>();

	private int maxPatchDistance = 5;
	
	/**
	 * Compute
	 */
	public AllMineralsWME() {
		ArrayList<MineralWME> fringe = new ArrayList<MineralWME>(ABLStarCraftBot.getGame().getMinerals());

		while (fringe.size() > 0) {
			HashSet<MineralWME>  neighbors = new HashSet<MineralWME>();
			neighbors.add(fringe.remove(0));

			while (true) {				
				HashSet<MineralWME> addSet = new HashSet<MineralWME>();

				for (MineralWME patchMineral : neighbors) {
					for (MineralWME mineral : ABLStarCraftBot.getGame().getMinerals()) {
						if (mineral != patchMineral && !neighbors.contains(mineral)) {						
							if (Math.abs(patchMineral.getX() - mineral.getX()) <= maxPatchDistance	&& 
									Math.abs(patchMineral.getY() - mineral.getY()) <= maxPatchDistance ) {

								addSet.add(mineral);
								fringe.remove(mineral);
							}						
						}
					}
				}
				
				if (addSet.size() > 0) {
					neighbors.addAll(addSet);
				}
				else {
					break;
				}
			}
			
			// compute the centroid
			int centerX = 0;
			int centerY = 0;
			for (MineralWME mineral : neighbors) {
				centerX += mineral.getX();
				centerY += mineral.getY();
			}
			
			Patch patch = new Patch();
			patch.centerX = centerX/neighbors.size();
			patch.centerY = centerY/neighbors.size();
			patch.minerals = new HashSet<MineralWME>(neighbors);
			
			patches.add(patch);
		}
		
		// print out the patches		
		Logger.print("AllMineralsWME", "Num patches: " + patches.size());
		for (Patch patch : patches) {
			Logger.print("AllMineralsWME", patch.centerX + " " + patch.centerY);
			Logger.print("AllMineralsWME", "Mineral patch size: " + patch.minerals.size());
			
			for (MineralWME min : patch.minerals) {
				Logger.print("AllMineralsWME", "  " + min.getID());
			}
		}
	}
	
	public void setClaimed(int unitID, int mineralID, int centerID) {
		assigned.put(unitID, mineralID);
		centerAssignments.put(unitID, centerID);
		claimed.add(mineralID);
	}

	public void unAssign(int unitID) {
		Integer patch = assigned.remove(unitID);
		centerAssignments.remove(unitID);
		if (patch != null) {
			claimed.remove(patch);
		}
	}

	public boolean isAssigned(int unitID) {
		return assigned.containsKey(unitID);
	}
	
	public int getNumWorkers(int centerID) {
		int count = 0;
		for (int workerID : centerAssignments.keySet()) {
			if (centerAssignments.get(workerID) == centerID) {
				count++;
			}
		}
		return count;
	}

	public double getSaturation(int centerID) {
		int workers = 0;
		int numMinerals = 0;
		HashSet<Integer> minerals = new HashSet<Integer>();
		HashSet<Patch> nearbyPatches = new HashSet<Patch>();
		for (int workerID : centerAssignments.keySet()) {
			if (centerAssignments.get(workerID) == centerID) {
				workers++;
				minerals.add(assigned.get(workerID));
			}
		}
		for (int mineralID : minerals) {
			for (Patch p : patches) {
				for (MineralWME m : p.minerals){
					if (m.getID() == mineralID) {
						nearbyPatches.add(p);
					}
				}
			}
		}
		for (Patch p : nearbyPatches) {
			numMinerals += p.minerals.size();
		}
		return workers / (double) (numMinerals*2);
	}
	
	/**
	 * Set by setLocation, then used by getBestPatch
	 */
	int px;
	int py;
	
	public boolean setLocation(int x, int y) {
		px = x;
		py = y;
		return true;
	}

	public int getBestPatch() {
		return getBestPatch(px, py);
	}

	public int getBestPatch(int x, int y) {
		
		if (patches.size() == 0) {
			return -1;
		}

		// find the closest patch
		Patch bestPatch = patches.get(0);
		double bestDistance = distance(bestPatch, x, y);
		
		for (Patch patch : patches) {
			double distance = distance(patch, x, y);
			
			if (distance < bestDistance) {
				bestPatch = patch;
				bestDistance = distance;
			}
		}
	
		// find unoccupied minerals
		ArrayList<MineralWME> free = new ArrayList<MineralWME>();
		for (MineralWME mineral : bestPatch.minerals) {
			if (!claimed.contains(mineral.getID())) {
				free.add(mineral);
			}
		}
		
		// clear usage if no free minerals
		if (free.size() == 0) {
			for (MineralWME mineral : bestPatch.minerals) {
				claimed.remove(mineral.getID());
			}
			
			free.addAll(bestPatch.minerals);
		}
		
		// find the closest mineral
		int closest = -1;
		bestDistance = 1000;
		for (MineralWME mineral : free) {
			double distance = distance(mineral, x, y);
			
			if (distance < bestDistance) {
				bestDistance = distance;
				closest = mineral.getID();
			}
		}
		
		return closest;
	}
	
	private final double distance(MineralWME mineral, int x, int y) {
		double dx = mineral.getX() - x;
		double dy = mineral.getY() - y;
		return Math.sqrt(dx*dx + dy*dy);
	}

	private final double distance(Patch patch, int x, int y) {
		double dx = patch.centerX - x;
		double dy = patch.centerY - y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	private class Patch {
		HashSet<MineralWME> minerals = new HashSet<MineralWME>();

		int centerX;
		int centerY;		
	}
}