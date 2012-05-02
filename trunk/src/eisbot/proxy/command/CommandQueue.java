package eisbot.proxy.command;

import java.util.ArrayList;

import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.actions.StarCraftAction;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.command.Command.StarCraftCommand;
import eisbot.proxy.wmes.unit.UnitWME;

public class CommandQueue {

	/** queued up commands (orders) to send to StarCraft */
	private ArrayList<Command> commandQueue = new ArrayList<Command>();

	/**
	 * Clears the command queue.
	 */
	public void clear() {
		commandQueue.clear();
	}
	
	private ArrayList<CommandListener> listeners = new ArrayList<CommandListener>();
	
	public void addCommandListener(CommandListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Sends queued up commands to JNI-BWAPI.
	 * 
	 * Note: should be invoked from the JNI-BWAPI callback: gameUpdate()
	 */
	public void processCommands(JNIBWAPI bwapi) {
		synchronized (commandQueue) {
			
			for (Command command : commandQueue) {			
				boolean success = true;
				
				switch (command.getCommand()) {
				case attackMove:
					success = bwapi.attackMove(command.getUnitID(), command.getArg0(), command.getArg1());					
					break;
				case attackUnit:
					success = bwapi.attackUnit(command.getUnitID(), command.getArg0());
					break;
				case build:
					int px = command.getArg0()*32;
					int py = command.getArg1()*32;
					bwapi.drawBox(px, py, px+96, py+64, (int)(Math.random()*50), true, false);
					success = bwapi.build(command.getUnitID(), command.getArg0(), command.getArg1(), command.getArg2());
					
					// ERROR with valid building placement
					if (!success) {
						UnitWME unit = ABLStarCraftBot.getGame().getUnitByID(command.getUnitID());						
						if (unit != null && unit.getX() == command.getArg0() && unit.getY() == command.getArg1()) {
							ABLStarCraftBot.getGame().newBlockage(command.getArg0(), command.getArg1());
						}
					}
					
					break;
				case buildAddon:
					success = bwapi.buildAddon(command.getUnitID(), command.getArg0());
					break;
				case train:
					success = bwapi.train(command.getUnitID(), command.getArg0());
					break;
				case morph:
					success = bwapi.morph(command.getUnitID(), command.getArg0());
					break;
				case research:
					success = bwapi.research(command.getUnitID(), command.getArg0());
					break;
				case upgrade:
					success = bwapi.upgrade(command.getUnitID(), command.getArg0());
					break;
				case setRallyPosition:
					success = bwapi.setRallyPoint(command.getUnitID(), command.getArg0(), command.getArg1());
					break;
				case setRallyTarget:
					success = bwapi.setRallyPoint(command.getUnitID(), command.getArg0());
					break;
				case move:
					success = bwapi.move(command.getUnitID(), command.getArg0(), command.getArg1());
					break;
				case patrol:
					success = bwapi.patrol(command.getUnitID(), command.getArg0(), command.getArg1());
					break;
				case holdPosition:
					success = bwapi.holdPosition(command.getUnitID());
					break;
				case stop:
					success = bwapi.stop(command.getUnitID());
					break;
				case follow:
					success = bwapi.follow(command.getUnitID(), command.getArg0());
					break;
				case gather:
					success = bwapi.gather(command.getUnitID(), command.getArg0());
					break;
				case returnCargo:
					success = bwapi.returnCargo(command.getUnitID());
					break;
				case repair:
					success = bwapi.repair(command.getUnitID(), command.getArg0());
					break;
				case burrow:
					success = bwapi.burrow(command.getUnitID());
					break;
				case unburrow:
					success = bwapi.unburrow(command.getUnitID());
					break;
				case cloak:
					success = bwapi.cloak(command.getUnitID());
					break;
				case decloak:
					success = bwapi.decloak(command.getUnitID());
					break;
				case siege:
					success = bwapi.siege(command.getUnitID());
					break;
				case unsiege:
					success = bwapi.unsiege(command.getUnitID());
					break;
				case lift:
					success = bwapi.lift(command.getUnitID());
					break;
				case land:
					success = bwapi.land(command.getUnitID(), command.getArg0(), command.getArg1());
					break;
				case load:
					success = bwapi.load(command.getUnitID(), command.getArg0());
					break;
				case unload:
					success = bwapi.unload(command.getUnitID(), command.getArg0());
					break;
				case unloadAll:
					success = bwapi.unloadAll(command.getUnitID());
					break;
				case unloadAllPosition:
					success = bwapi.unloadAll(command.getUnitID(), command.getArg0(), command.getArg1());
					break;
				case rightClick:
					success = bwapi.rightClick(command.getUnitID(), command.getArg0(), command.getArg1());
					break;
				case rightClickUnit:
					success = bwapi.rightClick(command.getUnitID(), command.getArg0());
					break;
				case haltConstruction:
					success = bwapi.haltConstruction(command.getUnitID());
					break;
				case cancelConstruction:
					success = bwapi.cancelConstruction(command.getUnitID());
					break;
				case cancelAddon:
					success = bwapi.cancelAddon(command.getUnitID());
					break;
				case cancelTrain:
					success = bwapi.cancelTrain(command.getUnitID());
					break; 
				case cancelTrainSlot:
					success = bwapi.cancelTrain(command.getUnitID(), command.getArg0());
					break;
				case cancelMorph:
					success = bwapi.cancelMorph(command.getUnitID());
					break;
				case cancelResearch:
					success = bwapi.cancelResearch(command.getUnitID());
					break;
				case cancelUpgrade:
					success = bwapi.cancelUpgrade(command.getUnitID());
					break;
				case useTech:
					success = bwapi.useTech(command.getUnitID(), command.getArg0());
					break;
				case useTechPosition:
					success = bwapi.useTech(command.getUnitID(), command.getArg0(), command.getArg1(), command.getArg2());
					break;
				case useTechTarget:
					success = bwapi.useTech(command.getUnitID(), command.getArg0(), command.getArg1());
					break;		
				case setGameSpeed:
					bwapi.setGameSpeed(command.getUnitID());
					break;
				case createSquad:
//					bwapi.createSquad(command.getUnitID(), command.getArg0());
					break;
				case deleteSquad:
//					bwapi.deleteSquad(command.getUnitID());
					break;
				case setSquadStyle:
//					bwapi.setSquadStyle(command.getUnitID(), command.getArg0());
					break;
				case addSquadUnit:
//					bwapi.addUnit(command.getUnitID(), command.getArg0());
					break;
				case deleteSquadUnit: 
//					bwapi.deleteUnit(command.getUnitID(), command.getArg0());
					break;
				case squadMove:
//					bwapi.squadMoveTile(command.getUnitID(), command.getArg0(), command.getArg1());
					break;
				case squadHold:
//					bwapi.squadHold(command.getUnitID()); 
					break; 
				case squadAttackTile:
//					bwapi.squadAttackTile(command.getUnitID(), command.getArg0(), command.getArg1());
					break;
				case squadAttackTarget: 
//					bwapi.squadAttack(command.getUnitID(), command.getArg0());
					break;
				}
  
				command.completionCallback(success);
			}			
			
			commandQueue.clear();
		}			
	}
	
	public void setGameSpeed(int speed) {
		doCommand(null, StarCraftCommand.setGameSpeed, speed, 0, 0, 0);
	}
	
	/**
	 * Adds a command to the command queue.
	 * 
	 * @param command - the command to execture, see the Orders enumeration
	 * @param unitID - the unit to control
	 * @param arg0 - the first command argument
	 * @param arg1 - the second command argument
	 * @param arg2 - the third command argument
	 */
	private void doCommand(StarCraftAction action, StarCraftCommand command, int unitID, int arg0, int arg1, int arg2) {
		synchronized (commandQueue) {
			Command order = new Command(action, command, unitID, arg0, arg1, arg2);
			
			if (!commandQueue.contains(order)) {
				commandQueue.add(order);
				
				for (CommandListener listener : listeners) {
					listener.event(order);
				}
			}	
			// repeat commands result in failure
			else if (action != null){
				action.completionCallback(false);
			}
		}
	}
	
    /**********************************************************
     * Commands
     *********************************************************/	
	
	/**
	 * Tells the unit to attack move the specific location (in tile coordinates).
	 * 
	 * 	// virtual bool attackMove(Position position) = 0;
	 */
	public void attackMove(StarCraftAction action, int unitID, int x, int y) { 
		doCommand(action, StarCraftCommand.attackMove, unitID, x, y, 0);
    }
    
	/**
	 * Tells the unit to attack another unit.
	 * 
	 * 	// virtual bool attackUnit(Unit* target) = 0;
	 */
    public void attackUnit(StarCraftAction action, int unitID, int targetID) { 
		doCommand(action, StarCraftCommand.attackUnit, unitID, targetID, 0, 0);
    }

    /**
     * Tells the unit to right click (move) to the specified location (in tile coordinates).
     * 
     * 	// virtual bool rightClick(Position position) = 0;
     */
    public void rightClick(StarCraftAction action, int unitID, int x, int y) { 
		doCommand(action, StarCraftCommand.rightClick, unitID, x, y, 0);
    }

    /**
     * Tells the unit to right click (move) on the specified target unit 
     * (Includes resources).
     * 
     * 	// virtual bool rightClick(Unit* target) = 0;
     */
    public void rightClick(StarCraftAction action, int unitID, int targetID) { 
		doCommand(action, StarCraftCommand.rightClickUnit, unitID, targetID, 0, 0);
    }

    /**
     * Tells the building to train the specified unit type.
     * 
     * 	// virtual bool train(UnitType type) = 0;
     */
    public void train(StarCraftAction action, int unitID, int typeID) { 
		doCommand(action, StarCraftCommand.train, unitID, typeID, 0, 0);
    }

    /**
     * Tells a worker unit to construct a building at the specified location.
     * 
     * 	// virtual bool build(TilePosition position, UnitType type) = 0;
     */
    public void build(StarCraftAction action, int unitID, int tx, int ty, int typeID) { 
		doCommand(action, StarCraftCommand.build, unitID, tx, ty, typeID);
    }

    /**
     * Tells the building to build the specified add on.
     * 
     * 	// virtual bool buildAddon(UnitType type) = 0;
     */
    public void buildAddon(StarCraftAction action, int unitID, int typeID) { 
		doCommand(action, StarCraftCommand.buildAddon, unitID, typeID, 0, 0);
    }

    /**
     * Tells the building to research the specified tech type.
     * 
     * 	// virtual bool research(TechType tech) = 0;
     */
    public void research(StarCraftAction action, int unitID, int techTypeID) { 
		doCommand(action, StarCraftCommand.research, unitID, techTypeID, 0, 0);
    }
    
    /**
     * Tells the building to upgrade the specified upgrade type.
     * 
     * 	// virtual bool upgrade(UpgradeType upgrade) = 0;
     */
    public void upgrade(StarCraftAction action, int unitID, int upgradeTypeID) { 
		doCommand(action, StarCraftCommand.upgrade, unitID, upgradeTypeID, 0, 0);
    }
    
    /**
     * Orders the unit to stop moving. The unit will chase enemies that enter its vision.
     * 
     * 	// virtual bool stop() = 0;
     */
    public void stop(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.stop, unitID, 0, 0, 0);
    }

    /**
     * Orders the unit to hold position. The unit will not chase enemies that enter its vision.
     * 
     * 	// virtual bool holdPosition() = 0;
     */
    public void holdPosition(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.holdPosition, unitID, 0, 0, 0);
    }

    /**
     * Orders the unit to patrol between its current location and the specified location.
     * 
     * 	// virtual bool patrol(Position position) = 0;
     */
    public void patrol(StarCraftAction action, int unitID, int x, int y) { 
		doCommand(action, StarCraftCommand.patrol, unitID, x, y, 0);
    }
    
    /**
     * Orders a unit to follow a target unit.
     * 
     * 	// virtual bool follow(Unit* target) = 0;
     */
    public void follow(StarCraftAction action, int unitID, int targetID) { 
		doCommand(action, StarCraftCommand.follow, unitID, targetID, 0, 0);
    }

    /**
     * Sets the rally location for a building. 
     * 
     * 	// virtual bool setRallyPosition(Position target) = 0;
     */
    public void setRallyPosition(StarCraftAction action, int unitID, int x, int y) { 
		doCommand(action, StarCraftCommand.setRallyPosition, unitID, x, y, 0);
    }

    /**
     * Sets the rally location for a building based on the target unit's current position.
     * 
     * 	// virtual bool setRallyUnit(Unit* target) = 0;
     */
    public void setRallyUnit(StarCraftAction action, int unitID, int targetID) { 
		doCommand(action, StarCraftCommand.setRallyTarget, unitID, targetID, 0, 0);
    }

    /**
     * Instructs an SCV to repair a target unit.
     * 
     * 	// virtual bool repair(Unit* target) = 0;
     */
    public void repair(StarCraftAction action, int unitID, int targetID) {
		doCommand(action, StarCraftCommand.repair, unitID, targetID, 0, 0);
    }

    /**
     * Orders a zerg unit to morph to a different unit type.
     * 
     * 	// virtual bool morph(UnitType type) = 0;
     */
    public void morph(StarCraftAction action, int unitID, int typeID) {
		doCommand(action, StarCraftCommand.morph, unitID, typeID, 0, 0);
    }

    /**
     * Tells a zerg unit to burrow. Burrow must be upgraded for non-lurker units.
     * 
     * 	// virtual bool burrow() = 0;
     */
    public void burrow(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.burrow, unitID, 0, 0, 0);
    }
    
    /**
     * Tells a burrowed unit to unburrow.
     * 
     * 	// virtual bool unburrow() = 0;
     */
    public void unburrow(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.unburrow, unitID, 0, 0, 0);
    }
    
    /**
     * Orders a siege tank to siege.
     * 
     * 	// virtual bool siege() = 0;
     */
    public void siege(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.siege, unitID, 0, 0, 0);
    }

    /** 
     * Orders a siege tank to un-siege.
     * 
     * 	// virtual bool unsiege() = 0;
     */
    public void unsiege(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.unsiege, unitID, 0, 0, 0);
    }

    /**
     * Tells a unit to cloak. Works for ghost and wraiths. 
     * 
     * 	// virtual bool cloak() = 0;
     */
    public void cloak(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.cloak, unitID, 0, 0, 0);
    }
    
    /**
     * Tells a unit to decloak, works for ghosts and wraiths.
     * 
     * 	// virtual bool decloak() = 0;
     */
    public void decloak(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.decloak, unitID, 0, 0, 0);
    }

    /** 
     * Commands a Terran building to lift off.
     * 
     * 	// virtual bool lift() = 0;
     */
    public void lift(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.lift, unitID, 0, 0, 0);
    }

    /**
     * Commands a terran building to land at the specified location.
     * 
     * 	// virtual bool land(TilePosition position) = 0;
     */
    public void land(StarCraftAction action, int unitID, int tx, int ty) {
		doCommand(action, StarCraftCommand.land, unitID, tx, ty, 0);
    }
    
    /**
     * Orders the transport unit to load the target unit.
     * 
     * 	// virtual bool load(Unit* target) = 0;
     */
    public void load(StarCraftAction action, int unitID, int targetID) { 
		doCommand(action, StarCraftCommand.load, unitID, targetID, 0, 0);
    }

    /**
     * Orders a transport unit to unload the target unit at the current transport location.
     * 
     * 	// virtual bool unload(Unit* target) = 0;
     */
    public void unload(StarCraftAction action, int unitID, int targetID) { 
		doCommand(action, StarCraftCommand.unload, unitID, targetID, 0, 0);
    }

    /**
     * Orders a transport to unload all units at the current location.
     * 
     * 	// virtual bool unloadAll() = 0;
     */
    public void unloadAll(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.unloadAll, unitID, 0, 0, 0);
    }

    /**
     * Orders a unit to unload all units at the target location.
     * 
     * 	// virtual bool unloadAll(Position position) = 0;
     */
    public void unloadAll(StarCraftAction action, int unitID, int x, int y) { 
		doCommand(action, StarCraftCommand.unloadAllPosition, unitID, x, y, 0);
    }
    
    /**
     * Orders a being to stop being constructed.
     * 
     * 	// virtual bool cancelConstruction() = 0;
     */
    public void cancelConstruction(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.cancelConstruction, unitID, 0, 0, 0);
    }

    /**
     * Tells an scv to pause construction on a building.
     * 
     *	// virtual bool haltConstruction() = 0;
     */
    public void haltConstruction(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.haltConstruction, unitID, 0, 0, 0);
    }
    
    /**
     * Orders a zerg unit to stop morphing.
     * 
     * 	// virtual bool cancelMorph() = 0;
     */
    public void cancelMorph(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.cancelMorph, unitID, 0, 0, 0);
    }
    
    /** 
     * Tells a building to remove the last unit from its training queue.
     * 
     * 	// virtual bool cancelTrain() = 0;
     */
    public void cancelTrain(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.cancelTrain, unitID, 0, 0, 0);
    }
    
    /**
     * Tells a building to remove a specific unit from its queue.
     * 
     * 	// virtual bool cancelTrain(StarCraftAction action, int slot) = 0;
     */
    public void cancelTrain(StarCraftAction action, int unitID, int slot) { 
		doCommand(action, StarCraftCommand.cancelTrainSlot, unitID, slot, 0, 0);
    }
    
    /**
     * Orders a Terran building to stop constructing an add on.
     * 
     * 	// virtual bool cancelAddon() = 0;
     */
    public void cancelAddon(StarCraftAction action, int unitID) {
		doCommand(action, StarCraftCommand.cancelAddon, unitID, 0, 0, 0);
    }
    
    /***
     * Tells a building cancel a research in progress. 
     * 
     * 	// virtual bool cancelResearch() = 0;
     */
    public void cancelResearch(StarCraftAction action, int unitID) { 
		doCommand(action, StarCraftCommand.cancelResearch, unitID, 0, 0, 0);
    }
    
    /***
     * Tells a building cancel an upgrade  in progress. 
     * 
     * 	// virtual bool cancelUpgrade() = 0;
     */
    public void cancelUpgrade(StarCraftAction action, int unitID) { 
		doCommand(action, StarCraftCommand.cancelUpgrade, unitID, 0, 0, 0);
    }
    
    /**
     * Tells the unit to use the specified tech, (i.e. STEM PACKS)
     * 
     *  // virtual bool useTech(TechType tech) = 0;
     */
    public void useTech(StarCraftAction action, int unitID, int techTypeID) { 
		doCommand(action, StarCraftCommand.useTech, unitID, techTypeID, 0, 0);
    }
    
    /**
     * Tells the unit to use tech at the target location.
     * 
     * Note: for AOE spells such as plague.
     * 
     *  // virtual bool useTech(TechType tech, Position position) = 0;
     */
    public void useTech(StarCraftAction action, int unitID, int techTypeID, int x, int y) { 
		doCommand(action, StarCraftCommand.useTechPosition, unitID, techTypeID, x, y);
    }

    /**
     * Tells the unit to use tech on the target unit.
     * 
     * Note: for targeted spells such as irradiate.
     * 
     *  // virtual bool useTech(TechType tech, Unit* target) = 0;
     */
    public void useTech(StarCraftAction action, int unitID, int techTypeID, int targetID) { 
		doCommand(action, StarCraftCommand.useTechTarget, unitID, techTypeID, targetID, 0);
    }	
    
//	public void createSquad(StarCraftAction action, int squadID, int style) {
//		doCommand(action, StarCraftCommand.createSquad, squadID, style, 0, 0);
//    }
//	
//	public void deleteSquad(StarCraftAction action, int squadID) {
//		doCommand(action, StarCraftCommand.deleteSquad, squadID, 0, 0, 0);
//    }
//	
//	public void setSquadStyle(StarCraftAction action, int squadID, int style) {
//		doCommand(action, StarCraftCommand.setSquadStyle, squadID, style, 0, 0);
//    }
//	
//	public void addUnit(StarCraftAction action, int unitID, int squadID) {
//		doCommand(action, StarCraftCommand.addSquadUnit, unitID, squadID, 0, 0);
//    }
//	
//	public void deleteUnit(StarCraftAction action, int unitID, int squadID) {
//		doCommand(action, StarCraftCommand.deleteSquadUnit, unitID, squadID, 0, 0);
//    }
//	
//	public void squadMove(StarCraftAction action, int squadID, int x, int y) {
//		doCommand(action, StarCraftCommand.squadMove, squadID, x, y, 0); 
//    }
//	
//	public void squadHold(StarCraftAction action, int squadID) {
//		doCommand(action, StarCraftCommand.squadHold, squadID, 0, 0, 0);
//    }
//	
//	public void squadAttackTile(StarCraftAction action, int squadID, int x, int y) {
//		doCommand(action, StarCraftCommand.squadAttackTile, squadID, x, y, 0);
//    }
//	
//	public void squadAttackTarget(StarCraftAction action, int squadID, int targetID) {
//		doCommand(action, StarCraftCommand.squadAttackTarget, squadID, targetID, 0, 0);
//    }
}
