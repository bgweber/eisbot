package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.CommandQueue;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
import eisbot.proxy.wmes.unit.protoss.AttackUnitWME;
/**
 * @see CommandQueue
 */
public class SquadAttackTarget extends StarCraftAction {

    public void execute(Object[] args) {     
    	int squadID = (Integer)args[0];
    	int targetID = (Integer)args[1]; 
    	        
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID && unit instanceof AttackUnitWME) {
		    	ABLStarCraftBot.getQueue().attackUnit(null, unit.getID(), targetID);
			} 
		}		 
    } 
    
    public synchronized int getCompletionStatus() {
    	return completionStatus = SUCCESS;
    }

}
