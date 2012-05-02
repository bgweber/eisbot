package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
/**
 * @see CommandQueue
 */
public class CancelTrain extends StarCraftAction {

    public void execute(Object[] args) {     
    	ABLStarCraftBot.getQueue().cancelTrain(this,
    			((Integer)args[0]).intValue());
    }
}
