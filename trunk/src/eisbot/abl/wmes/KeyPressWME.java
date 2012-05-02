package eisbot.abl.wmes;

import wm.WME;

public class KeyPressWME extends WME {

	private int keycode;
	
	public KeyPressWME(int keycode) {
		this.keycode = keycode;
	}
	
	public int getKeycode() {
		return keycode;
	}
}