package eisbot.cbr.goalforumlator.retriever;

import weka.classifiers.trees.J48;
/**
 * C4.5 implementation of the classification retriever.
 */
public class J48Retriever extends ClassificationRetriever {

	public J48Retriever() {
		super(new J48());
	}
}
