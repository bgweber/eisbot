package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
/**
 * @see CommandQueue
 */
public class PatrolPixel extends StarCraftAction {

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().patrol(this,
    			((Integer)args[0]).intValue(), 
    			((Integer)args[1]).intValue(), 
    			((Integer)args[2]).intValue());
    }
}
