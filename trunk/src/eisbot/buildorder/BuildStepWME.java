package eisbot.buildorder;

import wm.WME;
import eisbot.abl.wmes.requests.RequestWME;

public class BuildStepWME extends WME {

	private Prerequisite prerequisite;
	private Action action;
	
	public BuildStepWME(Prerequisite prerequisite, Action action) {
		this.prerequisite = prerequisite;
		this.action = action;
	}

	public Prerequisite getPrerequisite() {
		return prerequisite;
	}
 
	public Action getAction() {
		return action;
	} 

	public int getMineralReq() {
		return action != null ? action.getMineralReq() : 0;
	}
 
	public int getGasReq() {
		return action != null ? action.getGasReq() : 0;
	}

	public int getSupplyReq() {
		return prerequisite != null ? prerequisite.getSupplyReq() : 0;
	}
	
	public int getPrereqType() {
		return prerequisite.getTypeID();
	}
 
	public int getActionType() {
		return action.getTypeID();
	}

	public String toString() {
		return "BuildStep" + "\n  " + prerequisite + "\n  " + action;
	}
	 
	public RequestWME getRequestWME() {
		return action.getRequestWME();
	}
}
 