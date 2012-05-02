package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
/**
 * @see CommandQueue
 */
public class AttackUnit extends StarCraftAction {

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().attackUnit(this,
    			((Integer)args[0]).intValue(), 
    			((Integer)args[1]).intValue());
    }
}
