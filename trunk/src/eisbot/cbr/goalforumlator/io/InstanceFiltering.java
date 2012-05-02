package eisbot.cbr.goalforumlator.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import weka.core.Instance;
import weka.core.Instances;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.cbr.goalforumlator.GameEncoder;
import eisbot.cbr.goalforumlator.filter.Filter;
import eisbot.cbr.goalforumlator.filter.UnitCountsOnlyFilter;

public class InstanceFiltering {

	public static void main(String[] args) throws Exception {
		GameEncoder encoder = new GameEncoder(Race.Protoss, Race.Protoss); 
		new InstanceFiltering().loadGames(
			encoder, 
			new UnitCountsOnlyFilter(), 
			"src/eisbot/cbr/goalforumlator/data/tracesPvP-Protoss.arff"); 		 
	}  
 
	public static void loadGames(GameEncoder encoder, Filter filter, String filename) throws Exception {
		try { 
			Instances allGames = new Instances(new BufferedReader(
					new FileReader(filename)));		
			
			for (int i=0; i<allGames.numInstances(); i++) {
				Instance instance = allGames.instance(i);
				filter.applyFiler(encoder, instance); 
			}
			
			String output = filename.split("\\.")[0] + "Filtered.arff";
			BufferedWriter writer = new BufferedWriter(new FileWriter(output));
			writer.write(allGames.toString());
			writer.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
