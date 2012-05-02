package eisbot.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JPanel;

import eisbot.abl.wmes.prediction.TechPredictionWME;

import abl.runtime.BehavingEntity;
import abl.runtime.BehavingListener;
import abl.runtime.GoalStep;
import abl.runtime.Step;

public class BehaviorProfiler extends JPanel implements BehavingListener {

	private boolean running = true;
	
	private HashMap<String, Integer> goals = new HashMap<String, Integer>();
	
	public BehaviorProfiler() {
		new Thread() {
			public void run() {
				Thread.currentThread().setName("Behavior Profiler Thread");

				while (running) {
					try {
						Thread.sleep(200);
					}
					catch (Exception e) {}
 
					BehaviorProfiler.this.repaint();
				}				
			}
		}.start();		
	}
	
	
	public void onBehave(Hashtable executingSteps, Set leafSteps) { }	
	
	public void executingStep(Step selectedStep) { 

		if (selectedStep instanceof GoalStep) {
			String signature = ((GoalStep)selectedStep).toString();
			signature = signature.substring(signature.indexOf(" " ) + 1);
			
			synchronized (goals) {
				if (goals.containsKey(signature)) {
					goals.put(signature, goals.get(signature) + 1);
				}
				else {
					goals.put(signature, 1);
				}
			}
		}
	}
	 
	public void paint(Graphics g) {

		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		// player units
		g.setColor(Color.BLACK); 
		int x = 15;
		int y = 25;
		g.drawString("Selected Goals", x, y);
		y += 18;
		g.drawString("-----------------------------", x, y);
		
		ArrayList<String> goalList = new ArrayList<String>();
		synchronized (goals) {
			goalList.addAll(goals.keySet());

			Collections.sort(goalList, new Comparator<String>() {
				public int compare(String o1, String o2) {
					if (goals.get(o1) == goals.get(o2)) {
						return o1.compareTo(o2);
					}
					else {
						return goals.get(o2) - goals.get(o1);
					}
				}				
			});
 		
			for (String goal : goalList) {
				y += 18; 				
				g.drawString(goals.get(goal) + "    " + goal, x, y); 
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
   