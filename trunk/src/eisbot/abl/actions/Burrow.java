package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
/**
 * @see CommandQueue
 */
public class Burrow extends StarCraftAction {

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().burrow(this,
    			((Integer)args[0]).intValue());
    }
}
