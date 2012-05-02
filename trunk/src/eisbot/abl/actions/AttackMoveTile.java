package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.StarCraftConstants;
import eisbot.proxy.command.CommandQueue;
import eisbot.proxy.wmes.unit.UnitWME;
/**
 * @see CommandQueue
 */
public class AttackMoveTile extends StarCraftAction { 

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().attackMove(this,
    			((Integer)args[0]).intValue(), 
    			((Integer)args[1]).intValue() * StarCraftConstants.PIXELS_PER_TILE, 
    			((Integer)args[2]).intValue() * StarCraftConstants.PIXELS_PER_TILE);
    	
		// assign the target location
		UnitWME unit = ABLStarCraftBot.getGame().getUnitByID(((Integer)args[0]).intValue());
		if (unit != null) {
			unit.setAttackTargetX(((Integer)args[1]).intValue() * StarCraftConstants.PIXELS_PER_TILE);
			unit.setAttackTargetY(((Integer)args[2]).intValue() * StarCraftConstants.PIXELS_PER_TILE);
		}
    }
}
 