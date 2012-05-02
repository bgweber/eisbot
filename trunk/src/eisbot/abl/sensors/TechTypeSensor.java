package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.TechTypeWME;


public class TechTypeSensor extends StarCraftSensor {

	protected void sense() {
		
		if (ABLStarCraftBot.getBehavingEntity().lookupWME(TechTypeWME.class.getSimpleName()).size() == 0) {
	        for (TechTypeWME techType : ABLStarCraftBot.getGame().getTechTypes()) {
	        	ABLStarCraftBot.getBehavingEntity().addWME(techType);
	        }
		}
	}
}
