package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.filter.ParticleWME;


public class ParticleFilterSensor extends StarCraftSensor {

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
		
		ABLStarCraftBot.getBehavingEntity().deleteAllWMEClass("ParticleWME");

        for (ParticleWME particle : ABLStarCraftBot.getGame().getParticleFilter().getParticles()) {
        	ABLStarCraftBot.getBehavingEntity().addWME(particle);
        }
	}
}
