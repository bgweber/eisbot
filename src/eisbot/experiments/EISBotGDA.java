package eisbot.experiments;

import eisbot.abl.ABLStarCraftBot;
/**
 * Note: run with VM arg -Xmx512M
 */
public class EISBotGDA {

	public static void main(String[] args) {

		System.setProperty("ABLBotName", "EISBot");   
		System.setProperty("BuildOrderScript", "src/eisbot/buildorder/buildorders/Default.txt");   
   		
		System.setProperty("GoalFormulator.Enable", "true");
		System.setProperty("GoalFormulator.PlanningWindowSize", "15");
		System.setProperty("OpponentPredictor.Enable", "true");
		System.setProperty("OpponentPredictor.PredictionWindowSize", "10");
		System.setProperty("GDA.Enable", "true");
		System.setProperty("GDA.DiscrepancyPeriod", "" + (24*30));

		ABLStarCraftBot.main(args);
	}
}
