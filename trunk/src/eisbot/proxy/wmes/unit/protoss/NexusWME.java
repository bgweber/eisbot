package eisbot.proxy.wmes.unit.protoss;


public class NexusWME extends BuildingWME {

	boolean newest = false;
	
	public void setNewest() {
		newest = true;
	}
	
	public void clearNewest() {
		newest = false;
	}
	
	public boolean getNewest() {
		return newest;
	}
}
