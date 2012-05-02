package eisbot.gui;

import java.util.TreeMap;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import abl.runtime.BehavingEntity;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.wmes.ConstructionWME;
import eisbot.abl.wmes.TrainUnitWME;
import eisbot.abl.wmes.requests.BuildingRequestWME;
import eisbot.abl.wmes.requests.ResearchRequestWME;
import eisbot.abl.wmes.requests.UnitRequestWME;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;

public class WMEPanel extends JPanel {

	JTextArea textPane = null;
	
	private boolean running = true;
	
	public WMEPanel() {
		textPane = new JTextArea();
		add(textPane);

		new Thread() {
			public void run() {
				Thread.currentThread().setName("WME Panel Thread");

				while (running) {
					try {
						Thread.sleep(500);
					}
					catch (Exception e) {}

					BehavingEntity behavingEntity = ABLStarCraftBot.getBehavingEntity();
					if (behavingEntity != null) {
						TreeMap<String, Integer> wm = behavingEntity.getWorkingMemory().getMemoryUsage();
						showUsage(wm);					
					}
				}				
			}
		}.start();
	}
	
	/**
	 * Shuts down the GUI.
	 */
	public void stop() {
		running = false;
	}
	
	public void showUsage(TreeMap<String, Integer> usage) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("WME Usage\n");
		buffer.append("---------------------------\n");
		
		for (String wme : usage.keySet()) {
			buffer.append(wme + ": " + usage.get(wme) + "\n");
		}
		
		buffer.append("\nConstructionWMEs\n");
		for (Object wme :BehavingEntity.getBehavingEntity().lookupWME(ConstructionWME.class.getSimpleName())) {
			buffer.append(" -" + UnitType.values()[((ConstructionWME)wme).getType()].name() + "\n");
		}

		buffer.append("\nTrainWMEs\n");
		for (Object wme :BehavingEntity.getBehavingEntity().lookupWME(TrainUnitWME.class.getSimpleName())) {
			buffer.append(" -" + UnitType.values()[((TrainUnitWME)wme).getType()].name() + "\n");
		}
 
		buffer.append("\nUnit Request WMEs\n");
		for (Object wme :BehavingEntity.getBehavingEntity().lookupWME(UnitRequestWME.class.getSimpleName())) {
			buffer.append(" -" + UnitType.values()[((UnitRequestWME)wme).getType()].name() + "\n");
		}

		buffer.append("\nBuildingRequestWMEs\n");
		for (Object wme :BehavingEntity.getBehavingEntity().lookupWME(BuildingRequestWME.class.getSimpleName())) {
			buffer.append(" -" + UnitType.values()[((BuildingRequestWME)wme).getType()].name() + "\n");
		}

		buffer.append("\nResearchRequestWMEs\n");
		for (Object wme :BehavingEntity.getBehavingEntity().lookupWME(ResearchRequestWME.class.getSimpleName())) {
			buffer.append(" -" + UnitType.values()[((ResearchRequestWME)wme).getType()].name() + "\n");
		}

		textPane.setText(buffer.toString());
	}
}
