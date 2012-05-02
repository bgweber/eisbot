package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.MapWME;


public class MapSensor extends StarCraftSensor {
	
	protected void sense() {
		if (ABLStarCraftBot.IgnoreBases) {
			return;
		} 
		 
		if (ABLStarCraftBot.getBehavingEntity().lookupWME(MapWME.class.getSimpleName()).size() == 0) {
			ABLStarCraftBot.getBehavingEntity().addWME(ABLStarCraftBot.getGame().getMap());
		}
	}
}
