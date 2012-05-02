package eisbot.abl.wmes.prediction;

import eisbot.proxy.wmes.UpgradeTypeWME.UpgradeType;

public class UpgradePredictionWME extends PredictionWME {

	private UpgradeType type;
	private int typeID;
	 
	public UpgradePredictionWME(UpgradeType type, int timing) {
		super(timing);
		this.type = type;
		this.typeID = type.ordinal();
		this.timing = timing;
	} 
 
	public UpgradeType getType() {
		return type;
	}

	public int getTypeID() {
		return typeID;
	}
}
