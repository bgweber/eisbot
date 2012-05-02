package eisbot.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abl.runtime.BehavingEntity;
import abl.runtime.BehavingListener;
import abl.runtime.Step;
import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Logger;

public class ABLPanel extends JPanel implements BehavingListener {
	
	private int updates = 0;
	private long lastUpdate = System.currentTimeMillis();

	private JLabel label = new JLabel("ABL is running");
	private boolean running = true;
	
	public ABLPanel() {
		setLayout(new BorderLayout());
		
		JButton pause = new JButton("Pause ABL");
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BehavingEntity behavingEntity = ABLStarCraftBot.getBehavingEntity();
								
				if (behavingEntity != null) {
					if (behavingEntity.isPaused()) {
						behavingEntity.unpause(); 
						label.setText("ABL is running");
						Logger.print("GUI", "Un-pausing ABL");						
						running = true;
					}
					else {
						behavingEntity.pause();
						label.setText("ABL is paused");
						Logger.print("GUI", "Pausing ABL");
						running = false;
					}
				}
			}
		});
		
		add(pause, BorderLayout.WEST);		
		add(label, BorderLayout.EAST);
	}
	
	public void onBehave(Hashtable executingSteps, Set leafSteps) {
		updates++;
		
		if (System.currentTimeMillis() > (lastUpdate + 1000)) {
			lastUpdate = System.currentTimeMillis();

			if (running) {
				label.setText("ABL is running: " + updates 
						+ " (" + leafSteps.size()
						+ "," + executingSteps.size() + ")");
			}
			
			updates = 0;
		}
	}

	public void executingStep(Step selectedStep) { }
}
