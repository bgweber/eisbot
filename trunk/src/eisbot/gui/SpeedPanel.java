package eisbot.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.abl.Logger;

public class SpeedPanel extends JPanel {

	public int initialSpeed = 0;
	public int slowest = 100;
	public int fastest = 0;

	public SpeedPanel(final Game game) {
		
		ABLStarCraftBot.getQueue().setGameSpeed(initialSpeed);
		final JSlider slider = new JSlider(JSlider.HORIZONTAL, fastest, slowest, initialSpeed);
		slider.addChangeListener(new ChangeListener() {			
			public void stateChanged(ChangeEvent e) {
				Logger.print("GUI", "Setting game speed: " + slider.getValue());
				ABLStarCraftBot.getQueue().setGameSpeed(slider.getValue());
			} 
		});
		
		JLabel label = new JLabel("Game Speed");
		add(label);

//		setPreferredSize(new Dimension(300, 40));
		add(slider);
	}
}
