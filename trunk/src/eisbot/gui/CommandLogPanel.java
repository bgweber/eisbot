package eisbot.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.command.Command;
import eisbot.proxy.command.CommandListener;

public class CommandLogPanel extends JPanel implements CommandListener {

	JTextArea textPane = null;
	
	private boolean running = true;
	
	ArrayList<String> commands = new ArrayList<String>();
	
	int listSize = 20;
	
	public CommandLogPanel() {
		setLayout(new BorderLayout());
		
		textPane = new JTextArea();
		add(textPane, BorderLayout.WEST);
		
		commands.add("Starting agent...");
		update();
	}

	public void event(Command command) {
		String message = ABLStarCraftBot.getGame().getGameFrame() + "\t" +
			command.getCommand() + " " + 
			command.getUnitID()
			+ " " + command.getArg0()
			+ " " + command.getArg1()
			+ " " + command.getArg2();

		commands.add(message);
		while (commands.size() > listSize) {
			commands.remove(0);
		}
		
		update();
	}
	
	public void update() {		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Cycle\tCommand\n");
		buffer.append("------------------------------------------------------\n");
		
		for (String message : commands) {
			buffer.append(message + "\n");
		}
		
		textPane.setText(buffer.toString());
		
		listSize = getHeight()/18;
	}
}
