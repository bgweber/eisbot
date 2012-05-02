package eisbot.abl.wmes;

import wm.WME;

public class ShuttleMissionWME extends WME{
	public static enum HarassState{ IDLE, LOADING, DROPPING, RUNNING }

	int state = HarassState.IDLE.ordinal();
	private int shuttleID;
	
	public ShuttleMissionWME(int id){
		shuttleID = id;
	}
	
	public int getShuttleID() {
		return shuttleID;
	}

	public void setShuttleID(int shuttleID) {
		this.shuttleID = shuttleID;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int newState) {
		this.state = newState;
	}

}
