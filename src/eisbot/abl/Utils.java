package eisbot.abl;

import eisbot.abl.wmes.ShuttleMissionWME;
import abl.runtime.BehavingEntity;

public class Utils {
	public static double distance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	
	public static boolean missionDoesNotExist(int shuttleID)
	{
		for (Object obj : BehavingEntity.getBehavingEntity().getWorkingMemory().lookupWME("ShuttleMissionWME"))
				{
					if (((ShuttleMissionWME)obj).getShuttleID() == shuttleID)
						return false;
			
				}
		return true;
	}
	
}
