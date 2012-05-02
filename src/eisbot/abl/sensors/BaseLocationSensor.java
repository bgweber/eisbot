package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.BaseLocationWME;

public class BaseLocationSensor extends StarCraftSensor {

	protected void sense() {
		ABLStarCraftBot.getBehavingEntity().deleteAllWMEClass("BaseLocationWME");

        for (BaseLocationWME baseLocation : ABLStarCraftBot.getGame().getBaseLocations()) {
        	ABLStarCraftBot.getBehavingEntity().addWME(baseLocation);
        }
	}
}
