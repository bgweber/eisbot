package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.UpgradeTypeWME;


public class UpgradeTypeSensor extends StarCraftSensor {

	protected void sense() {
		
		if (ABLStarCraftBot.getBehavingEntity().lookupWME(UpgradeTypeWME.class.getSimpleName()).size() == 0) {
	        for (UpgradeTypeWME upgradeType : ABLStarCraftBot.getGame().getUpgradeTypes()) {
	        	ABLStarCraftBot.getBehavingEntity().addWME(upgradeType);
	        }
		}
	}
}
