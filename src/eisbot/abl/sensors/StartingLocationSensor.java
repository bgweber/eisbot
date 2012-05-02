package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.StartingLocationWME;

public class StartingLocationSensor extends StarCraftSensor {

	protected void sense() {
		
		if (ABLStarCraftBot.getBehavingEntity().lookupWME(StartingLocationWME.class.getSimpleName()).size() == 0) {
	        for (StartingLocationWME startingLocation : ABLStarCraftBot.getGame().getStartingLocations()) {
	        	ABLStarCraftBot.getBehavingEntity().addWME(startingLocation);
	        }
		}
	}
}
