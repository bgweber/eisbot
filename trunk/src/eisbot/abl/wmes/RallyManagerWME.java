package eisbot.abl.wmes;

import java.util.ArrayList;

import wm.WME;
import eisbot.abl.ABLStarCraftBot;
import eisbot.proxy.wmes.ChokePointWME;

public class RallyManagerWME extends WME {

	private int xLocation;
	
	private int yLocation;

	private ArrayList<ChokePointWME> chokePoints;
	
	public RallyManagerWME() {
		chokePoints = ABLStarCraftBot.getGame().getChokePoints();
	}
	
	public boolean setLocation(int pixelX, int pixelY) {
		ChokePointWME closest = null;
		double distance = Double.MAX_VALUE;

		for (ChokePointWME chokePoint : chokePoints) {
			double dist = Math.sqrt(Math.pow(chokePoint.getX() - pixelX,2) + Math.pow(chokePoint.getY() - pixelY,2));

			if (dist < distance) {
				distance = dist;
				closest = chokePoint;
			}
		}

		if (closest != null) {
			xLocation = closest.getX();
			yLocation = closest.getY();
		}	
		
		return true;
	}
	
	public int getXLocation() {
		return xLocation;
	}	
	
	public int getYLocation() {
		return yLocation;
	}
}
