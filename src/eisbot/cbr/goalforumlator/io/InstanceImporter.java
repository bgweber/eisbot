package eisbot.cbr.goalforumlator.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeMap;

import weka.core.Instance;
import weka.core.Instances;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.cbr.goalforumlator.GameEncoder;
import eisbot.cbr.goalforumlator.filter.Filter;
import eisbot.cbr.goalforumlator.filter.UnitCountsOnlyFilter;

public class InstanceImporter {

	public static void main(String[] args) throws Exception {
		GameEncoder encoder = new GameEncoder(Race.Protoss, Race.Terran);
		
		ArrayList<Instances> games = new InstanceImporter().loadGames(encoder, new UnitCountsOnlyFilter(), 
				"src/eisbot/cbr/goalforumlator/data/tracesPvT-Protoss.arff"); 		
	}  
	
	public static ArrayList<Instances> loadGames(GameEncoder encoder, Filter filter, String filename) throws Exception {

		// load all instances
		Instances allGames = new Instances(new BufferedReader(
				new FileReader(filename)));		
		allGames.setClassIndex(allGames.numAttributes() - 1); 
 
		// split into separate traces
		TreeMap<Integer, Instances> traces = new TreeMap<Integer, Instances>();
		for (int i=0; i<allGames.numInstances(); i++) {
			Instance instance = allGames.instance(i);
			filter.applyFiler(encoder, instance);
			
			int traceID = (int)instance.value(encoder.traceIndex);
			Instances instances = traces.get(traceID);
			
			if (instances == null) {
				instances = new Instances(allGames, 0, 0);
				traces.put(traceID, instances);
			}
			
			instances.add(instance);
		}

		return new ArrayList<Instances>(traces.values());
	} 
}
