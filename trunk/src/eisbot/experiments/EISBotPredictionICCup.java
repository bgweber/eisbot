package eisbot.experiments;

import eisbot.abl.ABLStarCraftBot;

public class EISBotPredictionICCup {

	public static void main(String[] args) {

		System.setProperty("BuildOrderScript", "Default.txt");   
		System.setProperty("ABLBotName", "EISBotAAAI");    
   		
		System.setProperty("GoalFormulator.Enable", "true");
		System.setProperty("GoalFormulator.PlanningWindowSize", "15");
		System.setProperty("OpponentPredictor.Enable", "true");
		System.setProperty("OpponentPredictor.PredictionWindowSize", "10");
		System.setProperty("GDA.Enable", "false");
     
		// ICCup mode
		System.setProperty("GameSettings.IccupMode", "true");
		System.setProperty("GameSettings.ShowGUI", "false"); 
		System.setProperty("GameSettings.UseManners", "true");
		System.setProperty("GameSettings.Fastest", "false"); 
		System.setProperty("GameSettings.UserInput", "false"); 

   
		ABLStarCraftBot.main(args);
	}
}
