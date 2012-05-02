package eisbot.abl.wmes;

import java.util.HashSet;

import wm.WME;
import eisbot.abl.StarCraftConstants;

public class RefineryWME extends WME {

	public HashSet<Integer> workers = new HashSet<Integer>();

	private int ID = StarCraftConstants.NULL_UNIT;

	public RefineryWME(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public int getNumWorkers() {
		return workers.size();
	}

	public void assign(int workerID) {
		workers.add(workerID);
	}
	
	public boolean isAssigned(int workerID) {
		return workers.contains(workerID);
	}
}