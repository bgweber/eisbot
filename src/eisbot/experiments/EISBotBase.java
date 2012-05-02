package eisbot.experiments;

import eisbot.abl.ABLStarCraftBot;

public class EISBotBase {

	public static void main(String[] args) {
 
		System.setProperty("BuildOrderScript", "Default.txt");   
		System.setProperty("ABLBotName", "EISBotAAAI");   
   		 
		System.setProperty("GoalFormulator.Enable", "false");
		System.setProperty("OpponentPredictor.Enable", "false");
		System.setProperty("GDA.Enable", "false");
     
		// ICCup mode
//		System.setProperty("GameSettings.IccupMode", "true");
//		System.setProperty("GameSettings.ShowGUI", "false"); 
//		System.setProperty("GameSettings.UseManners", "true");
//		System.setProperty("GameSettings.Fastest", "false"); 
//		System.setProperty("GameSettings.UserInput", "false"); 

    
		ABLStarCraftBot.main(args);
	}
}
