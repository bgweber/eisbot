package eisbot.proxy.wmes.unit;

import eisbot.abl.ABLStarCraftBot;

/**
 * Represents a mineral patch.
 */
public class MineralWME extends UnitWME {

	public long lastUsed = -Integer.MAX_VALUE;
	
	public void setAsUsed() {
		lastUsed = ABLStarCraftBot.getGame().getGameFrame();
	}
	
	public long getTimeSinceLastUse() {
		return ABLStarCraftBot.getGame().getGameFrame() - lastUsed;
	}
}
