package eisbot.cbr.goalforumlator.retriever;

import java.util.ArrayList;

import weka.core.Instance;
import weka.core.Instances;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.abl.wmes.prediction.PredictionWME;
import eisbot.cbr.goalforumlator.GameEncoder;

public interface Retriever {

	public void train(Race race, ArrayList<Instances> games, double sampleRatio);
	
	public ArrayList<BuildOrder> predictState(GameEncoder encoder, Instance instance, int moves);

	public ArrayList<PredictionWME> predictEnemyState(GameEncoder encoder, Instance instance, int moves);
}
