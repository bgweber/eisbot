package eisbot.abl.wmes;

import wm.WME;

public class StartAttackWME extends WME {

	private int endAttackSize;
	
	private boolean regrouping = true;
	
	private int x;
	private int y;
	
	public StartAttackWME(int endAttackSize, int x, int y) {
		this.endAttackSize = endAttackSize;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getEndAttackSize() {
		return endAttackSize;
	}
	  
	public void setRegrouping(boolean regrouping) {
		this.regrouping = regrouping;
	}
	
	public boolean getRegrouping() {
		return regrouping;
	}
}
