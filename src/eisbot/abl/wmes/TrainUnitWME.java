package eisbot.abl.wmes;

import wm.WME;
import eisbot.abl.StarCraftConstants;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;

public class TrainUnitWME extends WME {

	public static enum TrainingStatus { Request, Active }

	protected int type;
	protected int whatBuilds;
	protected int addOnType = StarCraftConstants.NULL_UNIT;
	protected int priority;
	protected int mineralCost;
	protected int gasCost;
	protected int supplyCost;
	protected int buildAt = StarCraftConstants.NULL_UNIT;
	protected int status = TrainingStatus.Request.ordinal();
	
	public TrainUnitWME() {}

	public TrainUnitWME(int type) {
		this.type = type;
		
		UnitTypeWME typeWME = UnitTypeWME.getType(type);
		whatBuilds = typeWME.getWhatBuilds();
		mineralCost = typeWME.getMineralsCost();
		supplyCost = typeWME.getSupplyRequired();
		gasCost = typeWME.getGasCost();
		status = TrainingStatus.Request.ordinal();
		
		// is an add on required to build this unit type?
		if (typeWME.getFirstUnitReq() != StarCraftConstants.NULL_UNIT) {
			if (UnitTypeWME.getType(typeWME.getFirstUnitReq()).isAddOn()) {
				addOnType = typeWME.getFirstUnitReq();
			}
			else if (typeWME.getSecondUnitReq() != StarCraftConstants.NULL_UNIT) {
				if (UnitTypeWME.getType(typeWME.getSecondUnitReq()).isAddOn()) {
					addOnType = typeWME.getSecondUnitReq();
				}
			}
		}
	}

	public TrainUnitWME(int type, int at) {
		this(type);
		this.buildAt = at;
	}

	/**
	 * Is this a worker type?
	 */
	public boolean getIsWorker() {
		return type == UnitType.Protoss_Probe.ordinal() ||
			   type == UnitType.Terran_SCV.ordinal() ||
			   type == UnitType.Zerg_Drone.ordinal();
	}

	public int getType() {
		return type;
	}
	
	public int getAddOnType() {
		return addOnType;
	}
	
	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void activate() {
		this.status = TrainingStatus.Active.ordinal();
	}
	
	public int getWhatBuilds() {
		return whatBuilds;
	}
	
	public void setWhatBuilds(int whatBuilds) {
		this.whatBuilds = whatBuilds;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getMineralCost() {
		return mineralCost;
	}
	
	public void setMineralCost(int mineralCost) {
		this.mineralCost = mineralCost;
	}
	
	public int getSupplyCost() {
		return supplyCost;
	}
	
	public int getGasCost() {
		return gasCost;
	}
	
	public void setGasCost(int gasCost) {
		this.gasCost = gasCost;
	}

	public int getBuilder() {
		return this.buildAt;
	}

	public void setBuilder(int builderID) {
		this.buildAt = builderID;
	}
	
	public static TrainUnitWME TrainWorkerWME(int race) {
		TrainUnitWME wme = new TrainUnitWME();
		
		wme.mineralCost = 50;
		wme.gasCost = 0;
		wme.priority = 0;
		
		switch (Race.values()[race]) {
		case Protoss:
			wme.type = UnitType.Protoss_Probe.ordinal();
			wme.whatBuilds = UnitType.Protoss_Nexus.ordinal();
			break;
		case Terran:
			wme.type = UnitType.Terran_SCV.ordinal();
			wme.whatBuilds = UnitType.Terran_Command_Center.ordinal();
			break;
		case Zerg:
			wme.type = UnitType.Zerg_Drone.ordinal();
			wme.whatBuilds = UnitType.Zerg_Larva.ordinal();
			break;
		}
		
		return wme;
	}
}
