package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
/**
 * @see CommandQueue
 */
public class Decloak extends StarCraftAction {

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().decloak(this,
    			((Integer)args[0]).intValue());
    }
}
