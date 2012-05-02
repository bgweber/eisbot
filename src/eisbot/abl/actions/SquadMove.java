package eisbot.abl.actions;

import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.StarCraftConstants;
import eisbot.proxy.command.CommandQueue;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
import eisbot.proxy.wmes.unit.protoss.AttackUnitWME;
/**
 * @see CommandQueue
 */
public class SquadMove extends StarCraftAction {

    public void execute(Object[] args) {     
    	int squadID = (Integer)args[0];
    	int x = (Integer)args[1] * StarCraftConstants.PIXELS_PER_TILE; 
    	int y = (Integer)args[2] * StarCraftConstants.PIXELS_PER_TILE;
    	  
		for (PlayerUnitWME unit : ABLStarCraftBot.getGame().getPlayerUnits()) {
			if (unit.getSquadID() == squadID && unit instanceof AttackUnitWME) {
		    	ABLStarCraftBot.getQueue().rightClick(null, unit.getID(), x, y);
			}
		}		
    }
    
    public synchronized int getCompletionStatus() {
    	return completionStatus = SUCCESS;
    }
} 
