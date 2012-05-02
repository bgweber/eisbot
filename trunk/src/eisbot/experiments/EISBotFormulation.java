package eisbot.experiments;

import eisbot.abl.ABLStarCraftBot;
/**
 * Note: run with VM arg -Xmx512M
 */
public class EISBotFormulation {

	public static void main(String[] args) {

		System.setProperty("ABLBotName", "EISBot");   
		System.setProperty("BuildOrderScript", "src/eisbot/buildorder/buildorders/Default.txt");   
   		
		System.setProperty("GoalFormulator.Enable", "true");
		System.setProperty("GoalFormulator.PlanningWindowSize", "15");
		System.setProperty("OpponentPredictor.Enable", "false");
		System.setProperty("GDA.Enable", "false"); 

		ABLStarCraftBot.main(args);
	}
}
