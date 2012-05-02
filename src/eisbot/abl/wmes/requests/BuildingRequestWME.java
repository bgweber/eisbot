package eisbot.abl.wmes.requests;

import eisbot.proxy.wmes.UnitTypeWME;

public class BuildingRequestWME extends RequestWME {

	private int type;
	private UnitTypeWME unitType;
	private int unitReq;
	private int secondUnitReq;
	
	public BuildingRequestWME(UnitTypeWME unitType) {
		this.type = unitType.getId();
		this.unitType = unitType;
		this.unitReq = unitType.getFirstUnitReq();
		this.secondUnitReq = unitType.getSecondUnitReq();
	}
	
	public String getActionName() {
		return unitType.getName();
	} 

	public int getType() {
		return type;
	}
	
	public int getUnitReq() {
		return unitReq;
	}
	
	public int getSecondUnitReq() {
		return secondUnitReq;
	}
}
