package eisbot.cbr.goalforumlator.retriever;

import java.util.ArrayList;

import eisbot.abl.StarCraftConstants.Race;
import eisbot.proxy.wmes.TechTypeWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.UpgradeTypeWME;
import eisbot.proxy.wmes.TechTypeWME.TechType;
import eisbot.proxy.wmes.UnitTypeWME.UnitType;
import eisbot.proxy.wmes.UpgradeTypeWME.UpgradeType;
/**
 * Represents a build order command to execute in StarCraft.
 */
public class BuildOrder {
	
	private static ArrayList<UnitType> protossTypes = UnitTypeWME.getTypes(Race.Protoss);
	private static ArrayList<TechType> protossTechs = TechTypeWME.getTypes(Race.Protoss);
	private static ArrayList<UpgradeType> protossUpgrades = UpgradeTypeWME.getTypes(Race.Protoss);
	private static ArrayList<UnitType> terranTypes = UnitTypeWME.getTypes(Race.Terran);
	private static ArrayList<TechType> terranTechs = TechTypeWME.getTypes(Race.Terran);
	private static ArrayList<UpgradeType> terranUpgrades = UpgradeTypeWME.getTypes(Race.Terran);
	private static ArrayList<UnitType> zergTypes = UnitTypeWME.getTypes(Race.Zerg);
	private static ArrayList<TechType> zergTechs = TechTypeWME.getTypes(Race.Zerg);
	private static ArrayList<UpgradeType> zergUpgrades = UpgradeTypeWME.getTypes(Race.Zerg);

	private UnitType unitType;
	private TechType techType;
	private UpgradeType upgradeType;
	
	public BuildOrder(UnitType type) {
		unitType = type;
	}
	
	/**
	 * Returns a build order given a class label
	 */
	public  static BuildOrder getBuildOrder(Race race, int prediction) {
		switch (race) {
		case Protoss:
			if (prediction < protossTypes.size()) {
				return new BuildOrder(protossTypes.get(prediction));
			}
			else {
				prediction -= 2*protossTypes.size();
				
				if (prediction < protossTechs.size()) {
					return new BuildOrder(protossTechs.get(prediction));
				}
				else {
					prediction -= protossTechs.size();
					return new BuildOrder(protossUpgrades.get(prediction));
				}
			}
		case Terran:
			if (prediction < terranTypes.size()) {
				return new BuildOrder(terranTypes.get(prediction));
			}
			else {
				prediction -= 2*terranTypes.size();
				
				if (prediction < terranTechs.size()) {
					return new BuildOrder(terranTechs.get(prediction));
				}
				else {
					prediction -= terranTechs.size();
					return new BuildOrder(terranUpgrades.get(prediction));
				}
			}
		case Zerg:
			if (prediction < zergTypes.size()) {
				return new BuildOrder(zergTypes.get(prediction));
			}
			else {
				prediction -= 2*zergTypes.size();
				
				if (prediction < zergTechs.size()) {
					return new BuildOrder(zergTechs.get(prediction));
				}
				else {
					prediction -= zergTechs.size();
					return new BuildOrder(zergUpgrades.get(prediction));
				}
			}
		}
		
		return null;
	}
	
	public BuildOrder(TechType type) {
		techType = type;
	}

	public BuildOrder(UpgradeType type) {
		upgradeType = type;
	}

	public UnitType getUnitType() {
		return unitType;
	}
	
	public TechType getTechType() {
		return techType;
	}
	
	public UpgradeType getUpgradeType() {
		return upgradeType;
	}
	
	public String toString() {
		if (unitType != null) {
			return unitType.toString();
		}
		else if (techType != null) {
			return techType.toString();
		}
		else {
			return upgradeType.toString();
		}
	}
}
