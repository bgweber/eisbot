package eisbot.buildorder;

import eisbot.proxy.wmes.TechTypeWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.UpgradeTypeWME;
import eisbot.proxy.wmes.TechTypeWME.TechType;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;
import eisbot.proxy.wmes.UpgradeTypeWME.UpgradeType;

public class Prerequisite {

	public enum PrereqType { Minerals, Gas, Supply, ASAP };
	
	private PrereqType type;
	private int quantity = 0;
	private UnitTypeWME unitType = null;
	private UpgradeTypeWME upgradeType = null; 
	private TechTypeWME techType = null;

	public Prerequisite(PrereqType type, int quantity) {
		this.type = type;
		this.quantity = quantity; 
	}

	public Prerequisite(String type, String quantity, String unit, String upgrade) {
		this.type = PrereqType.valueOf(type);
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

	public int getSupplyReq() {
		if (type == PrereqType.Supply) {
			return quantity;
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
