package eisbot.abl.wmes.prediction;

import eisbot.proxy.wmes.UnitTypeWME.UnitType;

public class UnitPredictionWME extends PredictionWME {

	private UnitType type; 
	private int typeID;
	private int attribute;
	 
	public UnitPredictionWME(UnitType type, int timing, int attribute) {
		super(timing);
		this.type = type;
		this.typeID = type.ordinal();
		this.timing = timing;
		this.attribute = attribute;
	}

	public UnitType getType() {
		return type;
	}

	public int getTypeID() {
		return typeID;
	}

	public int getAttribute() {
		return attribute;
	}
}
