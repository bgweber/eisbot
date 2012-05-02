package eisbot.buildorder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.abl.StarCraftConstants.Race;
/**
 * 
 * 
 * -DBuildOrderScript=src/eisbot/buildorder/buildorders/SafeFE.txt
 *
 */
public class BuildSelector {

	public static double epsilon = 0.5; 
	public static double baseCountWeight = 1.0;
	public static double expoChokeWeight = 1.0;
	public static double historyWeight = 1.0;
	public static int historySize = 1;

	private static String buildFile = "BuildHistory.txt";
	
	static ArrayList<BuildEntry> builds = null;
	
	public static BuildSequenceWME selectBuild() {
		
		if (System.getProperty("BuildOrderScript") != null) {
			System.out.println("Loading build order: " + System.getProperty("BuildOrderScript"));
			return new BuildScriptWME(System.getProperty("BuildOrderScript"));
		}
		
		try { 
			 
			// load the list of builds the first time
			if (builds == null) {
				builds = new ArrayList<BuildEntry>();
				
				BufferedReader reader = new BufferedReader(new FileReader("src/eisbot/buildorder/Builds.txt"));
				String line = reader.readLine();
				line = reader.readLine();
				
				while (line != null) {
					String[] atts = line.split(",");
					BuildEntry entry = new BuildEntry();
					
					entry.race = Race.valueOf(atts[0].trim());
					entry.numBases = Integer.parseInt(atts[1].trim());
					entry.numExpoChokes = Integer.parseInt(atts[2].trim());
					entry.weight = Double.parseDouble(atts[3].trim());
					entry.path = atts[4].trim();
 					
					if (!new File(entry.path).exists()) {
						throw new Exception("Invalid path for build: " + entry.path);
					}

					builds.add(entry);
					line = reader.readLine();
				}
				
				reader.close();
			}

			// retrieve build order history
			ArrayList<String> buildHistory = new ArrayList<String>();
			try {
				File history = new File(buildFile);
				if (history.exists()) {
					BufferedReader reader = new BufferedReader(new FileReader(history));
					String line = reader.readLine();
					
					while (line != null) {
						buildHistory.add(line);
						if (buildHistory.size() >= historySize) {
							break;  
						}
						
						line = reader.readLine();
					}
					
					reader.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			System.err.println("Build history: " + buildHistory);
			
			// find the match characteristics
			Game game = ABLStarCraftBot.getGame();
			int numBases = game.getStartingLocations().size();
			int numChokes = game.getMap().getNumExpoChokes(game);
			Race enemyRace = game.getEnemyRace();

			double totalWeight = 0;
			TreeMap<Double, String> entries = new TreeMap<Double, String>();
			
			for (BuildEntry build : builds) {
				if (!build.race.equals(enemyRace)) {
					continue;
				}   
								  
				double distance = epsilon  
					+ baseCountWeight*Math.abs(build.numBases - numBases) 
					+ expoChokeWeight*Math.abs(build.numExpoChokes - numChokes)
					+ historyWeight*(1 + buildHistory.lastIndexOf(build.path));
  				 
				double weight = build.weight/distance;
				System.out.println(weight + " " + build.path);
				totalWeight += weight;
				entries.put(totalWeight, build.path);
			}
			  
			double selectedWeight = Math.random()*totalWeight;
			String selectedBuild = null;
			for (Entry<Double, String> entry : entries.entrySet()) {
				if (selectedWeight < entry.getKey() ) {
					selectedBuild = entry.getValue();  
					break;
				}  
			}   
		  	
			if (selectedBuild != null) {
				System.out.println("selected build: " + selectedBuild);
				 
				// update build history  
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(buildFile));
					int startingIndex = (buildHistory.size() < historySize) ? 0 : 1;
					
					for (int i=startingIndex; i<buildHistory.size(); i++) {
						writer.write(buildHistory.get(i) + "\n");
					}
					
					writer.write(selectedBuild);					 
					writer.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
 				
				return new BuildScriptWME(selectedBuild);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		System.out.println("Loading default build order");
		return new BuildScriptWME("src/eisbot/buildorder/buildorders/Default.txt");
	}
}
