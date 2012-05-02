package eisbot.cbr.goalforumlator.filter;

import weka.core.Instance;
import eisbot.cbr.goalforumlator.GameEncoder;
/**
 * Leaves only the unit counts for the player.
 */
public class UnitCountsOnlyFilter implements Filter {

	public void applyFiler(GameEncoder encoder, Instance instance) {

		// clear features before the unit counts
		for (int i=0; i<encoder.typeIndex; i++) {
			
			if (i != 2) {	// Trace ID
				instance.setValue(i, 0);
			}
		}

		// clear all features after the unit counts
		for (int i=encoder.timingIndex; i<encoder.classIndex; i++) {
			instance.setValue(i, 0);
		}
	}
}
