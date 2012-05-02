package eisbot.abl.sensors;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.UnitTypeWME;


public class UnitTypeSensor extends StarCraftSensor {

	protected void sense() {
		
		if (ABLStarCraftBot.getBehavingEntity().lookupWME(UnitTypeWME.class.getSimpleName()).size() == 0) {
	        for (UnitTypeWME unitType : ABLStarCraftBot.getGame().getUnitTypes().values()) {
	        	ABLStarCraftBot.getBehavingEntity().addWME(unitType);
	        }
		}
	}
}
