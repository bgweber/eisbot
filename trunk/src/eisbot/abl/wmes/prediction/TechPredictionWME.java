package eisbot.abl.wmes.prediction;

import eisbot.proxy.wmes.TechTypeWME.TechType;

public class TechPredictionWME extends PredictionWME {

	private TechType type;
	private int typeID;
	 
	public TechPredictionWME(TechType type, int timing) {
		super(timing);
		this.type = type;
		this.typeID = type.ordinal();
	}

	public TechType getType() {
		return type;
	}

	public int getTypeID() {
		return typeID;
	}
}
