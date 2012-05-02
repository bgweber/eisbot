package eisbot.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.JPanel;

import abl.runtime.BehavingEntity;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.abl.wmes.ReconWME;
import eisbot.abl.wmes.SquadWME;
import eisbot.abl.wmes.prediction.TechPredictionWME;
import eisbot.abl.wmes.prediction.UnitPredictionWME;
import eisbot.abl.wmes.prediction.UpgradePredictionWME;

public class ReconPanel extends JPanel {

	private boolean running = true;
	
	public ReconPanel() {
		new Thread() {
			public void run() {
				Thread.currentThread().setName("Recon Panel Thread");

				while (running) {
					try {
						Thread.sleep(200);
					}
					catch (Exception e) {}

					ReconPanel.this.repaint();
				}				
			}
		}.start();		
	}
	
	public void paint(Graphics g) {

		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Game game = ABLStarCraftBot.getGame();
		ReconWME recon = game.getRecon();
		if (recon == null) {
			return;
		} 
		
		synchronized(recon) {

			// player units
			g.setColor(Color.BLACK);
			int x = 15;
			int y = 25;
			g.drawString("Player Units", x, y);
			y += 18;
			g.drawString("-----------------------------", x, y);
			
			final TreeMap<String, Integer> types = new TreeMap<String, Integer>();
			for (Entry<Integer, Integer> entry : recon.getPlayerCounts().entrySet()) {
				types.put(game.getUnitTypes().get(entry.getKey()).getName(), entry.getValue());
			}
			
			for (String type : types.keySet()) {
				y += 18;
				g.drawString(type + ": " + types.get(type), x, y);
			}
	
			// enemy units
			types.clear();
			for (Entry<Integer, Integer> type : recon.getEnemyTypes().entrySet()) {
				types.put(game.getUnitTypes().get(type.getKey()).getName(), type.getValue());
			}
			
			ArrayList<String> names = new ArrayList<String>(types.keySet());
			Collections.sort(names, new Comparator<String>() {
				public int compare(String o1, String o2) {
					if (types.get(o1) < types.get(o2)) {
						return -1;
					}
					else if (types.get(o1) > types.get(o2)) {
						return 1;
					}
					else {
						return o1.compareTo(o2);
					}
				}
			});

			y = 25;
			x += 200;  
			g.drawString("Squads", x, y);
			y += 18;
			g.drawString("-----------------------------", x, y);
			for (Object obj : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME("SquadWME")) {
				y += 18;
				SquadWME squad = (SquadWME)obj;
				g.drawString("Squad" + squad.getSquadID() + ": " + squad.getSize() + " - " + squad.getCasterSize(), x, y);
			} 
			
			y = 25;
			x += 200;
			g.drawString("Enemy Units", x, y); 
			y += 18;
			g.drawString("-----------------------------", x, y);
			for (String type : names) {
				y += 18; 
				g.drawString(types.get(type) + " - " + type, x, y); 
			}

			y = 25;
			x += 200;
			g.drawString("Enemy Predictions", x, y); 
			y += 18;
			g.drawString("-----------------------------", x, y);
			
			for (Object obj : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME("UnitPredictionWME")) {
				UnitPredictionWME prediction = (UnitPredictionWME)obj;				
				y += 18; 
				g.drawString(prediction.getTiming() + " - " + prediction.getType().name(), x, y); 
			}
			
			for (Object obj : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME("UpgradePredictionWME")) {
				UpgradePredictionWME prediction = (UpgradePredictionWME)obj;				
				y += 18; 
				g.drawString(prediction.getTiming() + " - " + prediction.getType().name(), x, y); 
			}
			 
			for (Object obj : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME("TechPredictionWME")) {
				TechPredictionWME prediction = (TechPredictionWME)obj;				
				y += 18; 
				g.drawString(prediction.getTiming() + " - " + prediction.getType().name(), x, y); 
			}
		}
	} 
	
	/**
	 * Shuts down the GUI.
	 */
	public void stop() {
		running = false;
	}
}
