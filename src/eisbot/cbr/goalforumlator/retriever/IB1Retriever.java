package eisbot.cbr.goalforumlator.retriever;

import weka.classifiers.lazy.IB1;
/**
 * k-NN implementation of the classification retriever.
 */
public class IB1Retriever extends ClassificationRetriever {

	public IB1Retriever() {
		super(new IB1());
	}
}
