package eisbot.cbr.goalforumlator.retriever;

import weka.classifiers.meta.AdaBoostM1;
/**
 * AdaBoost implementation of the classification retriever.
 */
public class AdaBoostRetriever extends ClassificationRetriever {

	private static AdaBoostM1 adaBoost = new AdaBoostM1();
	static {
		adaBoost.setNumIterations(50);
	}
	
	public AdaBoostRetriever() {
		super(adaBoost);
	}
}
