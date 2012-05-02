package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
import eisbot.proxy.wmes.unit.UnitWME;
/**
 * @see CommandQueue
 */
public class AttackMovePixel extends StarCraftAction {

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().attackMove(this, 
    			((Integer)args[0]).intValue(), 
    			((Integer)args[1]).intValue(), 
    			((Integer)args[2]).intValue());
    	  
		// assign the target location
		UnitWME unit = ABLStarCraftBot.getGame().getUnitByID(((Integer)args[0]).intValue());
		if (unit != null) {
			unit.setAttackTargetX(((Integer)args[1]).intValue());
			unit.setAttackTargetY(((Integer)args[2]).intValue());
		}
    }
}
