package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.RegionWME;

public class RegionSensor extends StarCraftSensor {

	protected void sense() {
		
		if (ABLStarCraftBot.getBehavingEntity().lookupWME(RegionWME.class.getSimpleName()).size() == 0) {
	        for (RegionWME region : ABLStarCraftBot.getGame().getRegions()) {
	        	ABLStarCraftBot.getBehavingEntity().addWME(region);
	        }
		}
	}
}
