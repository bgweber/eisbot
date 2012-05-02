package eisbot.cbr.goalforumlator.retriever;

import java.util.ArrayList;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.abl.wmes.prediction.PredictionWME;
import eisbot.cbr.goalforumlator.GameEncoder;
/**
 * Classification implementation of case retriever. Retrieves only a single build order action.
 */
public abstract class ClassificationRetriever implements Retriever {

	private Classifier classifier;
	
	private Race race;
	
	public ClassificationRetriever(Classifier classifier) {
		this.classifier = classifier;
	}

	/**
	 * Through the games into 1 big instances set of training.
	 */
	public void train(Race race, ArrayList<Instances> games, double sampleRatio) {
		this.race = race;
		Instances instances = new Instances(games.get(0), 0, 0);
		
		for (Instances game : games) {
			for (int i=0; i<game.numInstances(); i++) {
				if (Math.random() < sampleRatio) {
					instances.add(game.instance(i));
				}
			}
		}
		
		// train the classifier
		try {
			classifier.buildClassifier(instances);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves a single prediction
	 */
	public ArrayList<BuildOrder> predictState(GameEncoder encoder, Instance instance, int moves) {		
		ArrayList<BuildOrder> orders = new ArrayList<BuildOrder>();

//		try {
//			int prediction = (int)classifier.classifyInstance(instance);
//			orders.add(BuildOrder.getBuildOrder(race, prediction));
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}

		while (moves > 0) {
			try {
				
				// get the move
				int prediction = (int)classifier.classifyInstance(instance);
				orders.add(BuildOrder.getBuildOrder(race, prediction));
				
				// apply it
				double value = instance.value(encoder.typeIndex + prediction);
				instance.setValue(encoder.typeIndex + prediction, 1 + value);
	
				moves--;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}		
		
		
		return orders;
	}  
	  
	public ArrayList<PredictionWME> predictEnemyState(GameEncoder encoder, Instance instance, int moves) {		
		return new ArrayList<PredictionWME>(); 
	}
}
