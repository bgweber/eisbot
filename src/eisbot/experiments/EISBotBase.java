package eisbot.experiments;

import eisbot.abl.ABLStarCraftBot;

public class EISBotBase {

	public static void main(String[] args) {
 
		System.setProperty("ABLBotName", "EISBot");   
		System.setProperty("BuildOrderScript", "src/eisbot/buildorder/buildorders/Default.txt");   
   		 
		System.setProperty("GoalFormulator.Enable", "false");
		System.setProperty("OpponentPredictor.Enable", "false");
		System.setProperty("GDA.Enable", "false");

		ABLStarCraftBot.main(args);
	}
}
