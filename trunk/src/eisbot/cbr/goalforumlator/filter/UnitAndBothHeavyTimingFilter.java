package eisbot.cbr.goalforumlator.filter;

import weka.core.Instance;
import eisbot.cbr.goalforumlator.GameEncoder;
/**
 * Leaves the unit counts for only the player and timing features for both players.
 */
public class UnitAndBothHeavyTimingFilter implements Filter {

	public static double TimingFactor = 0.001; 
	
	public void applyFiler(GameEncoder encoder, Instance instance) {
 
		// clear features before the unit counts
		for (int i=0; i<encoder.typeIndex; i++) {
			instance.setValue(i, 0);
		}
 
		// scale the timing features
		for (int i=encoder.timingIndex; i<encoder.enemyTypeIndex; i++) {
			instance.setValue(i, TimingFactor*instance.value(i));
		}

		// clear enemy unit counts
		for (int i=encoder.enemyTypeIndex; i<encoder.enemyTimingIndex; i++) {
			instance.setValue(i, 0);
		}
		  
		// scale the enemy timing features
		for (int i=encoder.enemyTimingIndex; i<encoder.classIndex; i++) {
			instance.setValue(i, TimingFactor*instance.value(i));
		}		
	}
}
