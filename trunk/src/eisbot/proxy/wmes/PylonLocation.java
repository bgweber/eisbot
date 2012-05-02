package eisbot.proxy.wmes;

import java.awt.Point;

public class PylonLocation extends Point {
 
	int purpose;
	
	public PylonLocation(int x, int y, int purpose) {
		super(x, y);
		this.purpose = purpose;
	}
	
	public int getPurpose() {
		return purpose;
	}
}
