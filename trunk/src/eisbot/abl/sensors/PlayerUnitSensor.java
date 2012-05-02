package eisbot.abl.sensors;

import java.util.HashSet;

import abl.runtime.BehavingEntity;
import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.unit.PlayerUnitWME;


public class PlayerUnitSensor extends StarCraftSensor {

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
		
		ABLStarCraftBot.getBehavingEntity().deleteAllWMEClass("PlayerUnitWME");

		HashSet<Integer> units = new HashSet<Integer>();		
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			units.add(unit.getID());
			ABLStarCraftBot.getBehavingEntity().addWME(unit);
		}

		// ensure worker counts are updated for killed units
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getNumWorkers() > 0) {
				for (int id : unit.getWorkerList()) {
					if (!units.contains(id)) {
						unit.freeWorker(id);
					}
				}
			}
		}				
	}
}
