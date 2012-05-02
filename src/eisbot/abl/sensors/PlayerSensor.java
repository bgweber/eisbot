package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.PlayerWME;


public class PlayerSensor extends StarCraftSensor {

	protected void sense() {
		
		if (ABLStarCraftBot.getBehavingEntity().lookupWME(PlayerWME.class.getSimpleName()).size() == 0) {
			ABLStarCraftBot.getBehavingEntity().addWME(ABLStarCraftBot.getGame().getPlayer());
		}
	}
}
