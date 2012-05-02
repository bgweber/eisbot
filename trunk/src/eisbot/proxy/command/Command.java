package eisbot.proxy.command;

import eisbot.abl.actions.StarCraftAction;

/**
 * Representation of a command (Order) in StarCraft. The list of commands is enumerated here:
 * http://code.google.com/p/bwapi/wiki/Orders
 */
public class Command {

	private StarCraftAction action;
	
	/** the command to execute */
	private StarCraftCommand command;

	/** the unit to execute the command */
	private int unitID;
	
	/** the first argument */
	private int arg0;
	
	/** the second argument */
	private int arg1;
	
	/** the third argument */
	private int arg2;

	/**
	 * Creates a command
	 * 
	 * @param command
	 * @param unitID
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 */
	public Command(StarCraftAction action, StarCraftCommand command, int unitID, int arg0, int arg1, int arg2) {
		this.action = action;
		this.command = command;
		this.unitID = unitID;
		this.arg0 = arg0;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	/**
	 * Notifies the primitive action whether action execution was successful. 
	 */
    public void completionCallback(boolean status) {
    	if (action != null) {
    		action.completionCallback(status);
    	}
    }
	
	public boolean equals(Command o) {
		return command == o.command 
			&& unitID == o.unitID
			&& arg0 == o.arg0
			&& arg1 == o.arg1
			&& arg2 == o.arg2;
	}
	
	/**
	 * Commands (Orders) in StarCraft.
	 */

	public enum StarCraftCommand {
		 attackMove,
		 attackUnit,
		 build,
		 buildAddon,
		 train,
		 morph,
		 research,
		 upgrade,
		 setRallyPosition,
		 setRallyTarget,
		 move,
		 patrol,
		 holdPosition,
		 stop,
		 follow,
		 gather,
		 returnCargo,
		 repair,
		 burrow,
		 unburrow,
		 cloak,
		 decloak,
		 siege,
		 unsiege,
		 lift,
		 land,
		 load,
		 unload,
		 unloadAll,
		 unloadAllPosition,
		 rightClick,
		 rightClickUnit,
		 haltConstruction,
		 cancelConstruction,
		 cancelAddon,
		 cancelTrain,
		 cancelTrainSlot,
		 cancelMorph,
		 cancelResearch,
		 cancelUpgrade,
		 useTech,
		 useTechPosition,
		 useTechTarget,
		 setGameSpeed,
		 createSquad,
		 deleteSquad,
		 setSquadStyle,
		 addSquadUnit,
		 deleteSquadUnit,
		 squadMove,
		 squadHold,
		 squadAttackTile,
		 squadAttackTarget,
	}
	
	/**
	 * Returns the command ID.
	 */
	public StarCraftCommand getCommand() {
		return command;
	}

	/**
	 * Returns the ID of the unit to execute the command.
	 */
	public int getUnitID() {
		return unitID;
	}

	/**
	 * Returns the first command argument.
	 */
	public int getArg0() {
		return arg0;
	}

	/**
	 * Returns the second command argument.
	 */
	public int getArg1() {
		return arg1;
	}

	/**
	 * Returns the third command argument.
	 */
	public int getArg2() {
		return arg2;
	}		
}
