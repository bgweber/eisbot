package eisbot.abl.sensors;

import java.util.HashMap;
import java.util.HashSet;

import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.proxy.wmes.unit.NewUnitWME;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
/**
 * 
 *
 * Note: new sensor instances are constantly being spawned. The gameUnits structure maps the current game to list of active units. 
 */
public class NewUnitSensor extends StarCraftSensor {

	private static HashMap<Game, HashSet<Integer>> gameUnits = new HashMap<Game, HashSet<Integer>>();

	protected void sense() {
		
		// retrieve units for the current game
		HashSet<Integer> units = gameUnits.get(ABLStarCraftBot.getGame());
		if (units == null) {
			units = new HashSet<Integer>();
			gameUnits.clear();
			gameUnits.put(ABLStarCraftBot.getGame(), units);
		}

		// load the list when the game is first loaded
		if (units.size() == 0) {
			for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
				units.add(unit.getID());
			}
		}
		else {			
			for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
				if (!units.contains(unit.getID())) {
					ABLStarCraftBot.getBehavingEntity().addWME(new NewUnitWME(unit.getTypeID(), unit));
				}

				units.add(unit.getID());
			}			
		}
	}
}
