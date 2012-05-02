package eisbot.cbr.goalforumlator.filter;

import weka.core.Instance;
import eisbot.cbr.goalforumlator.GameEncoder;
/**
 * Leaves only the player timing and unit counts.
 */
public class UnitAndTimingFilter implements Filter {

	public void applyFiler(GameEncoder encoder, Instance instance) {

		// clear features before the unit counts
		for (int i=0; i<encoder.typeIndex; i++) {
			instance.setValue(i, 0);
		}

		// scale the timing features
		for (int i=encoder.timingIndex; i<encoder.enemyTypeIndex; i++) {
			instance.setValue(i, 0.001*instance.value(i));
		}
		
		// clear all features after the unit counts
		for (int i=encoder.enemyTypeIndex; i<encoder.classIndex; i++) {
			instance.setValue(i, 0);
		}
	}
}
