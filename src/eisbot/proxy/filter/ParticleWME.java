package eisbot.proxy.filter;

import wm.WME;
import eisbot.proxy.wmes.UnitTypeWME;

public class ParticleWME extends WME {

	public int unitID;
	
	public UnitTypeWME type;
	public int typeID;
	
	public double realX;	
	public double realY;

	public double weight = 1;
	public double decay = 0;

	// vectors
	public double dx;
	public double dy;

	public int getUnitID() {
		return unitID;
	}
	
	public void decay(boolean expoDecay) {
		if (expoDecay) {
			weight *= decay;
		}
		else {
			weight -= decay;
		}
	}
  
	public boolean getIsFlyer() {
		return type != null ? type.isFlyer() : false;
	}
	
	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

	public UnitTypeWME getType() {
		return type;
	}	

	public void setType(UnitTypeWME type) {
		this.type = type;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public double getRealX() {
		return realX;
	}

	public void setRealX(double realX) {
		this.realX = realX;
	}

	public double getRealY() {
		return realY;
	}

	public void setRealY(double realY) {
		this.realY = realY;
	}

	public int getX() {
		return (int)(realX/32.0);
	}

	public int getY() {
		return (int)(realY/32.0);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDecay() {
		return decay;
	}

	public void setDecay(double decay) {
		this.decay = decay;
	}
}
