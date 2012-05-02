package eisbot.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import eisbot.abl.LogListener;
import eisbot.abl.Logger;

public class LoggingPanel extends JTabbedPane implements LogListener {

	HashMap<String, LogTopic> panels = new HashMap<String, LogTopic>();
	
	public static final String INVALID = "Other";
	
	public LoggingPanel() {					
		LogTopic topic = new LogTopic(INVALID);
		panels.put(INVALID, topic);
		addTab(INVALID, topic);	    		
	}
	
	public void onLogMessage(String domain, String text) {
		LogTopic topic = panels.get(domain);
		boolean valid = Logger.isValidDomain(domain);
				
		if (valid) {
			if (topic == null) {
				topic = new LogTopic(domain);
				panels.put(domain, topic);				
				addTab(domain, topic);	    		
			}			
		}
		else {
			topic = panels.get(INVALID);
		}
		
		topic.onMessage(text);
	}

	public class LogTopic extends JPanel {		
		JTextArea textPane = null;
		
		ArrayList<String> commands = new ArrayList<String>();
		
		int listSize = 20;
		
		String domain;
		
		public LogTopic(String domain) {
			setLayout(new BorderLayout());
			
			this.domain = domain;			
			textPane = new JTextArea();
			add(textPane, BorderLayout.WEST);
		}

		public void onMessage(String text) {
			synchronized (commands) {
				commands.add(text);
				
				while (commands.size() > listSize) {
					commands.remove(0);
				}
			}
			
			update();
		}
		
		public void update() {		
			StringBuffer buffer = new StringBuffer();

			buffer.append("\n");
			buffer.append("   " + domain + "\n");
			buffer.append("   " + "---------------------------------------------" + "\n");
			
			synchronized (commands) {
				for (String message : commands) {
					buffer.append("   " + message + "\n");
				}
			}
			
			textPane.setText(buffer.toString());		
		}
	}	
}
