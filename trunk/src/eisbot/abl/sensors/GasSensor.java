package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.unit.GeyserWME;


public class GasSensor extends StarCraftSensor {

	/** last timestamp that the sensor was sensed */
	private long lastUpdate = -1;
	
	protected void sense() {

		// check if the game has changed
		if (ABLStarCraftBot.getGame().getGameFrame() > lastUpdate) {
			lastUpdate = ABLStarCraftBot.getGame().getGameFrame();
		}
		else {
			return;
		}
		
		ABLStarCraftBot.getBehavingEntity().deleteAllWMEClass("GeyserWME");

        for (GeyserWME geyserWME : ABLStarCraftBot.getGame().getGeysers()) {
        	ABLStarCraftBot.getBehavingEntity().addWME(geyserWME);
        }
	}
}
