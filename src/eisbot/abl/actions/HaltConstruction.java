package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
/**
 * @see CommandQueue
 */
public class HaltConstruction extends StarCraftAction {

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().haltConstruction(this,
    			((Integer)args[0]).intValue()); 
    }
}
