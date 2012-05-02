package eisbot.abl.wmes.requests;

import eisbot.proxy.wmes.TechTypeWME;
import eisbot.proxy.wmes.UpgradeTypeWME;

public class ResearchRequestWME extends RequestWME {

	private boolean isUpgrade;
	private int type;
	private int researchedAtType;
	private int mineralsCost;
	private int gasCost;
	private String typeName;
	
	public ResearchRequestWME(TechTypeWME techType) {
		isUpgrade = false; 
		type = techType.getId();
		researchedAtType = techType.getWhatResearchesID();
		mineralsCost = techType.getMineralsCost();
		gasCost = techType.getGasCost();
		typeName = techType.getName();
	}
  
	public ResearchRequestWME(UpgradeTypeWME upgradeType) {
		isUpgrade = true;
		type = upgradeType.getId();
		researchedAtType = upgradeType.getWhatResearchesID();
		mineralsCost = upgradeType.getMineralsBase();
		gasCost = upgradeType.getGasBase();
		typeName = upgradeType.getName();
	} 
	
	public String getActionName() {
		return typeName;
	}

	public boolean getIsUpgrade() {
		return isUpgrade;
	}
 	
	public int getMineralsCost() {
		return mineralsCost;
	}

	public int getGasCost() {
		return gasCost;
	}
	
	public int getType() {
		return type;
	}
	
	public int getResearchedAtType() {
		return researchedAtType;
	}
}
