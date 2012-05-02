package eisbot.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.wmes.ConstructionWME;
import eisbot.abl.wmes.TrainUnitWME;
import eisbot.abl.wmes.requests.BuildingRequestWME;
import eisbot.abl.wmes.requests.RequestWME;
import eisbot.abl.wmes.requests.ResearchRequestWME;
import eisbot.abl.wmes.requests.UnitRequestWME;
import eisbot.proxy.wmes.TechTypeWME.TechType;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;
import eisbot.proxy.wmes.UpgradeTypeWME.UpgradeType;

public class RequestPanel extends JPanel {
	
	private boolean running = true;

	public RequestPanel() {
		new Thread() {
			public void run() {
				Thread.currentThread().setName("Request Panel Thread");

				while (running) {
					try {
						Thread.sleep(200);
					}
					catch (Exception e) {}

					RequestPanel.this.repaint();
				}				
			}
		}.start();		
	}
	
	public void paint(Graphics g) {
		super.paint(g); 
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.BLACK);
		int x = 15;
		int y = 25;
		
		g.drawString("ConstructionWMEs", x, y);
		for (Object wme : ABLStarCraftBot.getBehavingEntity().lookupWME(ConstructionWME.class.getSimpleName())) {
			y += 18;
			g.drawString(" -" + UnitType.values()[((ConstructionWME)wme).getType()].name() + "", x, y);
		}

		y += 36;
		g.drawString("TrainWMEs", x, y);
		for (Object wme : ABLStarCraftBot.getBehavingEntity().lookupWME(TrainUnitWME.class.getSimpleName())) {
			y += 18;
			g.drawString(" -" + UnitType.values()[((TrainUnitWME)wme).getType()].name(), x, y);
		}
 
		y += 36;
		g.drawString("Unit Request WMEs", x, y);
		for (Object wme : ABLStarCraftBot.getBehavingEntity().lookupWME(UnitRequestWME.class.getSimpleName())) {
			y += 18;
			g.drawString(" -" + UnitType.values()[((UnitRequestWME)wme).getType()].name(), x, y);
		}
 
		y += 36;
		g.drawString("BuildingRequestWMEs", x, y);
		for (Object wme : ABLStarCraftBot.getBehavingEntity().lookupWME(BuildingRequestWME.class.getSimpleName())) {
			y += 18;
			g.drawString(" -" + UnitType.values()[((BuildingRequestWME)wme).getType()].name(), x, y);
		}
 
		y += 36;
		g.drawString("ResearchRequestWMEs", x, y);
		for (Object wme : ABLStarCraftBot.getBehavingEntity().lookupWME(ResearchRequestWME.class.getSimpleName())) {
			y += 18;
			if (((ResearchRequestWME)wme).getIsUpgrade()) {
				g.drawString(" -" + UpgradeType.values()[((ResearchRequestWME)wme).getType()].name(), x, y);
			} 
			else {
				g.drawString(" -" + TechType.values()[((ResearchRequestWME)wme).getType()].name(), x, y);
			}
		}

		x = 265;
		y = 25;		
		g.drawString("Build order", x, y);
		for (RequestWME request : ABLStarCraftBot.getGame().getBuildRequests()) {
			y += 18;		
			g.drawString(" -" + request.getActionName(), x, y);
		}
	} 
	
	/**
	 * Shuts down the GUI.
	 */
	public void stop() {
		running = false;
	}
}
