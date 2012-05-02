package eisbot.proxy.wmes.unit;

import wm.WME;

public class NewUnitWME extends WME {

	private int type;
	private UnitWME unit;	
	
	public NewUnitWME(int type, UnitWME unit) {
		this.type = type;
		this.unit = unit;
	}

	public void setPurpose(int purpose) {
		unit.setPurpose(purpose);
	}
	
	public int getType() {
		return type;
	}
}
