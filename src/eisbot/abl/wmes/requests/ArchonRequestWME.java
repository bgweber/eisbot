package eisbot.abl.wmes.requests;


public class ArchonRequestWME extends RequestWME {

	private boolean dark;
	
	public ArchonRequestWME(boolean dark) {
		this.dark = dark;
	}
	
	public boolean isDark() {
		return dark;
	}
	
	public String getActionName() {
		return dark ? "Protoss_Dark_Archon" : "Protoss_Archon";
	} 
}
