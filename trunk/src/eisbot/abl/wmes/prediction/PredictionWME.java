package eisbot.abl.wmes.prediction;

import wm.WME;

public class PredictionWME extends WME {

	protected int timing;

	public PredictionWME(int timing) {
		this.timing = timing;
	} 

	public int getTiming() {
		return timing;
	}
}
