package eisbot.buildorder;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import wm.WME;
import eisbot.abl.wmes.requests.RequestWME;

public class BuildSequenceWME extends WME {

	protected ArrayList<BuildStepWME> buildSteps = new ArrayList<BuildStepWME>();
	
	public int index = 0;
	protected boolean fastExpand = false; 
	
	public static void main(String[] args) {
		BuildSequenceWME sequene = new BuildSequenceWME("src/eisbot/buildorder/builds/2Gate.xml");
		 
		while (true) {
			BuildStepWME nextStep = sequene.getNextStep();
			
			if (nextStep == null) {
				break;
			} 
			else {
				System.out.println(nextStep.getRequestWME());				
			}
		}
	} 
	 
	protected BuildSequenceWME() {
	}
	
	public BuildSequenceWME(String filename) {
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filename));			
			
			NodeList buildStepElments = doc.getElementsByTagName("Build_Order_Step");
			for (int i=0; i<buildStepElments.getLength(); i++) {
				Element buildStepElement = (Element)buildStepElments.item(i);				

				Element prereqElement = (Element)buildStepElement.getElementsByTagName("Prerequisite").item(0);
				String prereqType = prereqElement.getElementsByTagName("Type").item(0).getTextContent();
				String prereqQuantity = prereqElement.getElementsByTagName("Quantity").item(0).getTextContent();
				String prereqUnit = prereqElement.getElementsByTagName("Unit").item(0).getTextContent();
				String prereqUpgrade = prereqElement.getElementsByTagName("Upgrade").item(0).getTextContent();
				Prerequisite prerequisite = new Prerequisite(prereqType, prereqQuantity, prereqUnit, prereqUpgrade);

				Element actionElement = (Element)buildStepElement.getElementsByTagName("Action").item(0); 
				String actionType = actionElement.getElementsByTagName("Type").item(0).getTextContent();
				String actionQuantity = actionElement.getElementsByTagName("Quantity").item(0).getTextContent();
				String actionUnit = actionElement.getElementsByTagName("Unit").item(0).getTextContent();
				String actionUpgrade = actionElement.getElementsByTagName("Upgrade").item(0).getTextContent();
				Action action = new Action(actionType, actionQuantity, actionUnit, actionUpgrade);

				buildSteps.add(new BuildStepWME(prerequisite, action));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isFastExpand() {
		return fastExpand;
	}
	  
	public BuildStepWME getNextStep() {
		if (index < buildSteps.size()) {
			return buildSteps.get(index++);
		}
		else {
			return null;
		}
	}  
	    
	public RequestWME getRequestWME() {
		BuildStepWME step = (index < buildSteps.size()) ? buildSteps.get(index) : null;
		return (step != null) ? step.getRequestWME() : null;
	}

	public int getSupplyReq() {
		BuildStepWME step = (index < buildSteps.size()) ? buildSteps.get(index) : null;
		return (step != null) ? step.getSupplyReq() : 0;
	}

	public int getMineralReq() {
		BuildStepWME step = (index < buildSteps.size()) ? buildSteps.get(index) : null;
		return (step != null) ? step.getMineralReq() : 0;
	}

	public int getGasReq() {
		BuildStepWME step = (index < buildSteps.size()) ? buildSteps.get(index) : null;
		return (step != null) ? step.getGasReq() : 0;
	}

	public void print() {
		System.out.println("Build Sequence");
		for (BuildStepWME step : buildSteps) {
			System.out.println("Step");
			System.out.println("  " + step.getPrerequisite());
			System.out.println("  " + step.getAction());
		}
	}
}
