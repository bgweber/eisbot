package eisbot.proxy.model;

public class PlayerScore {

	public static final int numAttributes = 11;

	private int ID;
	private int completedUnits;
	private int deadUnits;
	private int killedUnits;
	private int cumulativeMinerals;
	private int cumulativeGas;
	private int unitScore;
	private int killScore;
	private int buildingScore;
	private int razingScore;
	private int customScore;
	
	public PlayerScore(int[] data, int index) {
		ID = data[index++];	
		completedUnits = data[index++];	
		deadUnits = data[index++];	
		killedUnits = data[index++];	
		cumulativeMinerals = data[index++];	
		cumulativeGas = data[index++];	
		unitScore = data[index++];	
		killScore = data[index++];	
		buildingScore = data[index++];	
		razingScore = data[index++];	
		customScore = data[index++];	
	}

	public int getID() {
		return ID;
	}

	public int getCompletedUnits() {
		return completedUnits;
	}

	public int getDeadUnits() {
		return deadUnits;
	}

	public int getKilledUnits() {
		return killedUnits;
	}

	public int getCumulativeMinerals() {
		return cumulativeMinerals;
	}

	public int getCumulativeGas() {
		return cumulativeGas;
	}

	public int getUnitScore() {
		return unitScore;
	}

	public int getKillScore() {
		return killScore;
	}

	public int getBuildingScore() {
		return buildingScore;
	}

	public int getRazingScore() {
		return razingScore;
	}

	public int getCustomScore() {
		return customScore;
	}	
}
