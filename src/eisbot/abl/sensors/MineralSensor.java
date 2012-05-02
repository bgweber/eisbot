package eisbot.abl.sensors;

import java.util.Collections;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.unit.MineralWME;

public class MineralSensor extends StarCraftSensor {

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
		
		ABLStarCraftBot.getBehavingEntity().deleteAllWMEClass("MineralWME");

		// randomize list
		Collections.shuffle(ABLStarCraftBot.getGame().getMinerals());
        
        for (MineralWME mineralWME : ABLStarCraftBot.getGame().getMinerals()) {
        	ABLStarCraftBot.getBehavingEntity().addWME(mineralWME);
        }
	}

}
