package eisbot.abl.wmes;

import eisbot.abl.ABLStarCraftBot;
import wm.WME;


public class TimerWME extends WME {
	
	public int getFrameCount() {
		return ABLStarCraftBot.getGame().getGameFrame();
	}
}