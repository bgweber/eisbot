package eisbot.abl.sensors;

import abl.runtime.DefaultAsyncSensor;
/**
 * Base class for all StarCraft sensors.
 */
public abstract class StarCraftSensor extends DefaultAsyncSensor{
	    
    public void senseContinuous(Object[] args) {
        sense(args);
    }
	
    protected void sense(Object[] args) {
        sense();        
    }

    public boolean canBeParallel() {
    	return false;
    }
    
    protected abstract void sense();
}
