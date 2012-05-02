package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;

public class ReconSensor extends StarCraftSensor {

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
		
		ABLStarCraftBot.getBehavingEntity().deleteAllWMEClass("ReconWME");
		ABLStarCraftBot.getBehavingEntity().addWME(ABLStarCraftBot.getGame().getRecon());
	}
}
