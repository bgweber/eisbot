package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.unit.EnemyUnitWME;

public class EnemyUnitSensor extends StarCraftSensor {

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
		
		ABLStarCraftBot.getBehavingEntity().deleteAllWMEClass("EnemyUnitWME");

		for (EnemyUnitWME unit : ABLStarCraftBot.getGame().getEnemyUnits()) {
			ABLStarCraftBot.getBehavingEntity().addWME(unit);
		}				
	}

}
