package eisbot.proxy.wmes.unit;

import eisbot.proxy.wmes.UnitTypeWME;

/**
 * Represents a neutral unit.
 */
public class NeutralUnitWME extends UnitWME {

	public boolean blockage = false;
	
	public boolean isBlockage() {
		return blockage;
	}

	public void setBlockage(UnitTypeWME type, int x, int y) {
		this.blockage = true;
		this.type = type;
		this.x = x;
		this.y = y;
	}
}
