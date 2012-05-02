package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
/**
 * @see CommandQueue
 */
public class Unsiege extends StarCraftAction {

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().unsiege(this,
    			((Integer)args[0]).intValue());
    }
}
