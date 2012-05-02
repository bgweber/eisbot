package eisbot.abl.wmes;

import wm.WME;
import eisbot.abl.StarCraftConstants;
import eisbot.proxy.wmes.unit.PlayerUnitWME.WorkerTask;

public class FreeWorkerWME extends WME {

	protected int workerID = StarCraftConstants.NULL_UNIT;
	
	/** next task to perform */
	protected int task = WorkerTask.IDLE.ordinal();
	
	/** desired unit position */
	protected int x = -1;
	protected int y = -1;

	public FreeWorkerWME(int task) {
		this.task = task;
	}
	
	public FreeWorkerWME(int task, int x, int y) {
		this.task = task;
		this.x = x;
		this.y = y;
	}

	public int getWorkerID() {
		return workerID;
	}

	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}

	public int getTask() {
		return task;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
