package eisbot.abl.wmes.requests;

import eisbot.proxy.wmes.UnitTypeWME;
/**
 * Represents a request from the CBR component to build a unit.
 */
public class UnitRequestWME extends RequestWME {

	/** is this a worker request? */
	private boolean isWorker;

	/** what unit type should be produced? */
	private int type;
	private UnitTypeWME unitType;
	
	/** what unit type produces this */
	private int producedAtType;

	/**
	 * Creates a request for the given unit type.
	 */
	public UnitRequestWME(UnitTypeWME unitType) {
		this.unitType = unitType;
		type = unitType.getId();		
		isWorker = unitType.isWorker();
		producedAtType = unitType.getWhatBuilds();
	}
	 
	public int getSupplyRequired() {
		return unitType.getSupplyRequired();
	}
	
	public String getActionName() {
		return unitType.getName();
	}
	
	public int getReq1() {
		return unitType.getFirstUnitReq();
	}

	public int getReq2() {
		return unitType.getSecondUnitReq();
	}

	public boolean getIsWorker() {
		return isWorker;
	}
	
	public int getType() {
		return type;
	}

	public UnitTypeWME getUnitType() {
		return unitType;
	}

	public int getProducedAtType() {
		return producedAtType;
	}	
}
