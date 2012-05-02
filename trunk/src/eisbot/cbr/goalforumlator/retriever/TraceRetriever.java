package eisbot.cbr.goalforumlator.retriever;

import java.util.ArrayList;
import java.util.HashMap;

import weka.core.Instance;
import weka.core.Instances;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.abl.wmes.prediction.PredictionWME;
import eisbot.cbr.goalforumlator.CaseRetriever;
import eisbot.cbr.goalforumlator.GameEncoder;
import eisbot.cbr.goalforumlator.filter.UnitAndBothHeavyTimingFilter;
/**
 * 
 * 
 * TODO: optimize for speed!
 */
public class TraceRetriever implements Retriever {

	private ArrayList<Instances> games;
	
	private Race race;
	
	public String getName() {
		return "Trace Predictor";
	}
	
	public void train(Race race, ArrayList<Instances> games, double sampleRatio) {
		this.games = games;
		this.race = race;	
		
//		Collections.shuffle(games, new Random(13)); 
//		Collections.shuffle(games, new Random());
	}
	
	public ArrayList<BuildOrder> predictState(GameEncoder encoder, Instance instance, int moves) {		

		int bestIndex = 0;
		Instances bestGame = null;
		double bestDistance = Double.MAX_VALUE;
		
		for (Instances game : games) {
			for (int i=0; i<(game.numInstances() - moves); i++) {
				double distance = distance(instance, game.instance(i));
				
//				distance += Math.random()*0.1;
				
				if (distance < bestDistance) {
					bestDistance = distance;
					bestIndex = i;
					bestGame = game;
				}
			}			
		}
		
		// make a copy of the instance
		Instance copy = new Instance(instance);
		copy.setDataset(instance.dataset());
		instance = copy;

		ArrayList<BuildOrder> orders = new ArrayList<BuildOrder>();
		for (int move=0; move<moves; move++) {
			int prediction = (int)bestGame.instance(bestIndex + move).classValue();
			orders.add(BuildOrder.getBuildOrder(race, prediction));
		}

		return orders;
	}	

	public ArrayList<PredictionWME> predictEnemyState(GameEncoder encoder, Instance instance, int moves) {		
		
		int bestIndex = 0;
		Instances bestGame = null;
		double bestDistance = Double.MAX_VALUE;
		
		for (Instances game : games) {
			for (int i=0; i<(game.numInstances() - moves); i++) {
				double distance = distance(instance, game.instance(i));

				if (distance < bestDistance) {
					bestDistance = distance;
					bestIndex = i;
					bestGame = game;
				}
			}			
		}
		
		Instance enemyStart = bestGame.instance(bestIndex);
		Instance enemyEnd = bestGame.instance(bestIndex + moves - 1);		
		ArrayList<PredictionWME> predictions = new ArrayList<PredictionWME>();
		
 		for (int i=encoder.enemyTimingIndex; i<encoder.classIndex; i++) {
			if (enemyStart.value(i) <= 0 && enemyEnd.value(i) > 0) { 
				PredictionWME prediction = CaseRetriever.getPrediction(enemyEnd.attributeSparse(i).name(), (int)(enemyEnd.value(i)/UnitAndBothHeavyTimingFilter.TimingFactor), i);
				
				if (prediction != null) {
					predictions.add(prediction);
				}
			}
		}
		  
		return predictions;
	} 

	public final double distance(Instance instance1, Instance instance2) {
		double dist = 0;
		
		for (int i=0; i<instance1.numAttributes() - 1; i++) {
			dist += Math.abs(instance1.value(i) - instance2.value(i));				
		}

		return dist;
	}		
}
