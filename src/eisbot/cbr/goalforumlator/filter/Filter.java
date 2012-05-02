package eisbot.cbr.goalforumlator.filter;

import weka.core.Instance;
import eisbot.cbr.goalforumlator.GameEncoder;

public interface Filter {

	public void applyFiler(GameEncoder encoder, Instance instance);	

}
 