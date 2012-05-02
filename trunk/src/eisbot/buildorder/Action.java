package eisbot.buildorder;

import eisbot.abl.StarCraftConstants;
import eisbot.abl.wmes.requests.ArchonRequestWME;
import eisbot.abl.wmes.requests.AttackRequestWME;
import eisbot.abl.wmes.requests.BuildingRequestWME;
import eisbot.abl.wmes.requests.RequestWME;
import eisbot.abl.wmes.requests.ResearchRequestWME;
import eisbot.abl.wmes.requests.ScoutRequestWME;
import eisbot.abl.wmes.requests.UnitRequestWME;
import eisbot.proxy.wmes.TechTypeWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.UpgradeTypeWME;
import eisbot.proxy.wmes.TechTypeWME.TechType;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;
import eisbot.proxy.wmes.UpgradeTypeWME.UpgradeType;

public class Action {
 
	public enum ActionType { Build, ASAP, Scout, Attack };
	
	private ActionType type;
	private int quantity;
	private UnitTypeWME unitType = null;
	private UpgradeTypeWME upgradeType = null;
	private TechTypeWME techType = null;
	
//	public static UnitTypeWME getType(int typeID) {


	public Action(String type, String quantity, String unit, String upgrade) {
		this.type = ActionType.valueOf(type);
		this.quantity = Integer.parseInt(quantity); 
		 
		if (!unit.equals("None")) {
			unitType = UnitTypeWME.getType(UnitType.valueOf(unit).ordinal());
		}
		 
		if (!upgrade.equals("None")) {
			try {
				upgradeType = UpgradeTypeWME.getType(UpgradeType.valueOf(upgrade).ordinal());
			}
			catch (IllegalArgumentException e) {
				techType = TechTypeWME.getType(TechType.valueOf(upgrade).ordinal());
			}
		}
	}
	
	public Action(String action) {
		action = action.trim();
		
		if (action.equalsIgnoreCase("Attack")) {
			type = ActionType.Attack;
		} 
		else if (action.equalsIgnoreCase("Protoss_FE_Pylon")) {
			unitType = UnitTypeWME.getType(UnitType.valueOf("Protoss_Pylon").ordinal());			
		}
		else {
			try {
				unitType = UnitTypeWME.getType(UnitType.valueOf(action).ordinal());			
			}
			catch (IllegalArgumentException e) {
				try {
					upgradeType = UpgradeTypeWME.getType(UpgradeType.valueOf(action).ordinal());
				}
				catch (IllegalArgumentException ex) {
					techType = TechTypeWME.getType(TechType.valueOf(action).ordinal());
				}
			} 
		}
 	} 
	  
	public RequestWME getRequestWME() { 
		if (type == ActionType.Scout) {
			return new ScoutRequestWME();
		}  
		else if (type == ActionType.Attack) {
			return new AttackRequestWME();
		}		 
		else if (unitType != null) {
			if (unitType.getId() == UnitType.Protoss_Archon.ordinal()) {
				return new ArchonRequestWME(false);
			}
			else if (unitType.getId() == UnitType.Protoss_Dark_Archon.ordinal()) {
				return new ArchonRequestWME(true);
			}		
			else if (unitType.isBuilding()) {
				return new BuildingRequestWME(unitType);
			}
			else {
				return new UnitRequestWME(unitType);
			}
		} 
		else if (upgradeType != null) {
			return new ResearchRequestWME(upgradeType);
		}
		else if (techType != null) { 
			return new ResearchRequestWME(techType);
		}
		
		return null;
	}

	public int getMineralReq() {
		if (unitType != null) {
			return unitType.getMineralsCost();
		}
		else if (upgradeType != null) {
			return upgradeType.getMineralsBase();
		}
		else if (techType != null) {
			return techType.getMineralsCost();
		}
		else {
			return 0;
		}		
	}
 
	public int getGasReq() {
		if (unitType != null) {
			return unitType.getGasCost();
		}
		else if (upgradeType != null) {
			return upgradeType.getGasBase();
		}
		else if (techType != null) {
			return techType.getGasCost();
		}
		else {
			return 0;
		}		
	}

	public int getTypeID() {
		return type.ordinal(); 
	}
	
	public String toString() {
		return type + " " + quantity + " " + unitType + " " + upgradeType + " " + techType;
	}
}
