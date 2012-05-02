package eisbot.buildorder;

import java.io.BufferedReader;
import java.io.FileReader;

import eisbot.buildorder.Prerequisite.PrereqType;

public class BuildScriptWME extends BuildSequenceWME {

	
//	protected ArrayList<BuildStepWME> buildSteps = new ArrayList<BuildStepWME>();
 
	public static void main(String[] args) {
		BuildSequenceWME sequene = new BuildScriptWME("src/eisbot/buildorder/scripts/GoonsCount.txt");
		 
		while (true) {
			BuildStepWME nextStep = sequene.getNextStep();
			
			if (nextStep == null) {
				break;
			} 
			else {
				System.out.println(nextStep.getSupplyReq() + "\t" + nextStep.getRequestWME().getActionName());				
			}
		}
	}  
	
	public BuildScriptWME(String filename) {
		super();
		int pylonCount = 0;
		 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			
			while (line != null) { 
				String[] atts = line.split("\t");
				if (atts.length == 0) {
					break;
				}
				
				int count = Integer.parseInt(atts[0].trim());
				String actionString = atts[1].trim();
				Action action = new Action(actionString);
 
				if (action != null) {
					if (actionString.equalsIgnoreCase("Protoss_FE_Pylon")) {
						fastExpand = true;
					}
					
//					if (action.getRequestWME().getActionName().equalsIgnoreCase("Protoss_Nexus")) {
//						pylonCount++;
//					} 
					
					if (action.getRequestWME().getActionName().equalsIgnoreCase("Protoss_Pylon")) {
						if (pylonCount < 2) {
							buildSteps.add(new BuildStepWME(new Prerequisite(PrereqType.Supply, count), action));
						}
						
						pylonCount++;
					}
					else {
						buildSteps.add(new BuildStepWME(new Prerequisite(PrereqType.Supply, count), action));
					}
				} 
				 
				line = reader.readLine();
			}  
			
			reader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
