package eisbot.abl.wmes;

import wm.WME;
import abl.runtime.BehavingEntity;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.abl.StarCraftConstants;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;
import eisbot.proxy.wmes.unit.PlayerUnitWME;

public class ConstructionWME extends WME {

	public static enum ConstructionStatus { Request, Prepare, Ready, Constructing, Paused, Finished }

	protected int status = ConstructionStatus.Request.ordinal();
	protected int workerID = StarCraftConstants.NULL_UNIT;
	protected int type;
	protected int whatBuilds;
	protected int priority;
	protected int mineralCost;
	protected int gasCost;
	protected int x = -1;
	protected int y = -1;
	private boolean resourcesClaimed = false;
	private UnitTypeWME typeWME;
	
	public ConstructionWME() {}

	public ConstructionWME(int type) {
		this.type = type;

		typeWME = UnitTypeWME.getType(type);
		whatBuilds = typeWME.getWhatBuilds();
		mineralCost = typeWME.getMineralsCost();
		gasCost = typeWME.getGasCost();
	}
	
	/**
	 * Checks if the player has the tech necessary to build the requested construction type.
	 */
	public boolean getHasRequirements() {
		Game game = ABLStarCraftBot.getGame();
		
		// retrieve the type
		UnitTypeWME typeWME = game.getUnitTypes().get(type);
		if (typeWME == null) {
			return false;
		}
		
		boolean firstMet = (typeWME.getFirstUnitReq() == -1);
		boolean secondMet = (typeWME.getSecondUnitReq() == -1);
		
		for (PlayerUnitWME unit : game.getPlayerUnits()) {
			if (!unit.getPowered()) {
				continue;
			}
			
			if (unit.getTypeID() == typeWME.getFirstUnitReq()) {
				firstMet = true;
			}
			
			if (unit.getTypeID() == typeWME.getSecondUnitReq()) {
				secondMet = true;
			}
			
			if (firstMet && secondMet) {
				return true;
			}
		}
		
		return false;
	}
	
	public void addPrereqsToWM(ReconWME recon) {
		if (typeWME != null) {

			if (typeWME.getFirstUnitReq() != StarCraftConstants.NULL_UNIT && recon.getNumType(typeWME.getFirstUnitReq()) == 0) {
		        BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(typeWME.getFirstUnitReq()));
			}

			if (typeWME.getSecondUnitReq() != StarCraftConstants.NULL_UNIT && recon.getNumType(typeWME.getSecondUnitReq()) == 0) {
		        BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(typeWME.getSecondUnitReq()));
			}
		}	
	}
	
	public boolean getResourcesClaimed() {
		return resourcesClaimed;
	}
	
	public void setResourcesClaimed() {
		resourcesClaimed = true;
	}

	/**
	 * Is this a farm type?
	 */
	public boolean getIsFarm() {
		return type == UnitType.Protoss_Pylon.ordinal() ||
			   type == UnitType.Terran_Supply_Depot.ordinal() ||
			   type == UnitType.Zerg_Overlord.ordinal();
	}

	public boolean getIsCenter() {
		return type == UnitType.Protoss_Nexus.ordinal() ||
			   type == UnitType.Terran_Command_Center.ordinal() ||
			   type == UnitType.Zerg_Hatchery.ordinal() ||
			   type == UnitType.Zerg_Lair.ordinal() ||
			   type == UnitType.Zerg_Hive.ordinal();
	}

	public boolean isNexus() {
		return type == UnitType.Protoss_Nexus.ordinal();
	}

	public boolean isRefinery() {
		return type == UnitType.Protoss_Assimilator.ordinal() ||
			   type == UnitType.Terran_Refinery.ordinal() ||
			   type == UnitType.Zerg_Extractor.ordinal();
	}

	public boolean getCanAddOn() {
		return UnitTypeWME.getType(type).canAddOn();
	}
	
	public int getBuildingClass() {
		return UnitTypeWME.getType(type).getBuildingClass().ordinal();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getWorkerID() {
		return workerID;
	}
	
	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
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
	
	public int getGasCost() {
		return gasCost;
	}
	
	public void setGasCost(int gasCost) {
		this.gasCost = gasCost;
	}
	
	public static ConstructionWME FarmWME(int race) {
		ConstructionWME wme = new ConstructionWME();
		
		wme.mineralCost = 100;
		wme.gasCost = 0;
		wme.priority = 0;
		
		switch (Race.values()[race]) {
		case Protoss:
			wme.type = UnitType.Protoss_Pylon.ordinal();
			wme.whatBuilds = UnitType.Protoss_Probe.ordinal();
			break;
		case Terran:
			wme.type = UnitType.Terran_Supply_Depot.ordinal();
			wme.whatBuilds = UnitType.Terran_SCV.ordinal();
			break;
		case Zerg:
			wme.type = UnitType.Zerg_Overlord.ordinal();
			wme.whatBuilds = UnitType.Zerg_Larva.ordinal();
			break;
		}
		
		return wme;
	}
}
