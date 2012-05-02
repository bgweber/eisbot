package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
/**
 * @see CommandQueue
 */
public class CancelMorph extends StarCraftAction {

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().cancelMorph(this,
    			((Integer)args[0]).intValue());
    }
}
