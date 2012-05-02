package eisbot.abl;

import java.util.ArrayList;
import java.util.HashSet;

public class Logger {
 
	private static HashSet<String> disabledDomains = new HashSet<String>();
	private static HashSet<String> validDomains = new HashSet<String>();
	private static HashSet<String> categories = new HashSet<String>();

//	private static HashSet<String> commentaryDomains = new HashSet<String>();

	private static ArrayList<LogListener> listeners = new ArrayList<LogListener>();
 
	static {
		validDomains.add("ABL");
		validDomains.add("GUI");
		validDomains.add("ProxyBot");
		validDomains.add("ICCupRobot");
		validDomains.add("CBR");
		validDomains.add("CBR Full");
		validDomains.add("CBR Attempted");
		validDomains.add("Tactics");
		validDomains.add("Squad");
		validDomains.add("Construction");
		 
		// disabled
		disabledDomains.add("Construction"); 
		disabledDomains.add("CBR"); 
//		disabledDomains.add("ABL"); 
		disabledDomains.add("Squad");
 
		validDomains.add("AllMineralsWME");
		validDomains.add("SquadWME");
		validDomains.add("BuildLocationWME");
		validDomains.add("ScoutingWME");
		validDomains.add("LayoutAnalysisWME");
		validDomains.add("RegionWME");
		validDomains.add("MapWME"); 

		validDomains.add("StrategyManager");
		validDomains.add("ProductionManager");
		validDomains.add("WorkerManager");
		validDomains.add("SupplyManager");
		validDomains.add("ConstructionManager");
		validDomains.add("ScoutingManager");
		validDomains.add("OperationsManager");
		validDomains.add("VultureManager");

		categories.add("WME");
		categories.add("Manager");

//		commentaryDomains.add("ABL");
//		commentaryDomains.add("StrategyManager");
//		commentaryDomains.add("SupplyManager");
//		commentaryDomains.add("ProductionManager");
		
		// Change this to control logging behavior:
		//disabledDomains.add("BuildLocationWME");
		disabledDomains.add("ScoutingWME");
		disabledDomains.add("AllMineralsWME");
		disabledDomains.add("MapWME");
		disabledDomains.add("RegionWME");
	}

	public static void addListener(LogListener listener) {
		listeners.add(listener);
	}
	
	public static boolean isValidDomain(String domain) {
		return validDomains.contains(domain);
	}
	
	public static boolean print(String domain, String text) {
		
//		// say it?
//		if (commentaryDomains.contains(domain)) {
//			Commentator.say(text);
//		}
		
		for (LogListener listener : listeners) {
			listener.onLogMessage(domain, text);
		}
		
		if (disabledDomains.contains(domain)) {
			return true;
		}
		for (String s:categories) {
			if (disabledDomains.contains(s) && domain.contains(s)) {
				return true;
			}
		}
		if (validDomains.contains(domain)) {
			System.out.println(domain + ": " + text);
		} else {
			System.out.println("(INVALID DOMAIN)" + domain + ": " + text);
		}
		return true;
	}
}
