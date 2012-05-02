package eisbot.abl.java;

import abl.runtime.*;
import wm.WME;
import java.util.*;
import java.lang.reflect.Method;
import abl.learning.*;
import eisbot.proxy.*;
import eisbot.proxy.wmes.*;
import eisbot.buildorder.*;
import eisbot.proxy.wmes.unit.*;
import eisbot.proxy.wmes.unit.protoss.*;
import eisbot.proxy.filter.*;
import eisbot.abl.*;
import eisbot.abl.actions.*;
import eisbot.abl.sensors.*;
import eisbot.abl.wmes.*;
import eisbot.abl.wmes.requests.*;
import eisbot.abl.wmes.prediction.*;
import java.awt.Point;
public class EISBot_StepFactories implements eisbot.abl.StarCraftConstants
{
   static public Step stepFactory0(int __$stepID, Behavior __$behaviorParent, final Object[] __$behaviorFrame) {
      switch (__$stepID) {
         case -3: {
            // default wait step
            return new WaitStep(-3, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null);
         }
         case -2: {
            // default fail step
            return new FailStep(-2, __$behaviorParent, false, false, false, (short)-32768, (short)0, false, null, null);
         }
         case -1: {
            // default succeed step
            return new SucceedStep(-1, __$behaviorParent, false, false, (short)-32768, (short)0, false, null, null);
         }
         case 0: {
            // startup_1Step1
            return new WaitStep(0, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 1: {
            // startup_1Step2
            return new MentalStep(1, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 2: {
            // startup_1Step3
            return new GoalStep(2, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startupAgent()", null, (short)0);
         }
         case 3: {
            // startup_1Step4
            return new GoalStep(3, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 4: {
            // startupAgent_1Step1
            return new GoalStep(4, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startStrategyManager()", null, (short)1);
         }
         case 5: {
            // startupAgent_1Step2
            return new GoalStep(5, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startConstructionManager()", null, (short)1);
         }
         case 6: {
            // startupAgent_1Step3
            return new GoalStep(6, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startWorkerManager()", null, (short)1);
         }
         case 7: {
            // startupAgent_1Step4
            return new GoalStep(7, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startTacticsManager()", null, (short)1);
         }
         case 8: {
            // startupAgent_1Step5
            return new GoalStep(8, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startProductionManager()", null, (short)1);
         }
         case 9: {
            // startupAgent_1Step6
            return new GoalStep(9, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startScoutingManager()", null, (short)1);
         }
         case 10: {
            // startupAgent_1Step7
            return new GoalStep(10, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "keyPressListener()", null, (short)1);
         }
         case 11: {
            // startupAgent_1Step8
            return new GoalStep(11, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startCBRManager()", null, (short)1);
         }
         case 12: {
            // startupAgent_1Step9
            return new GoalStep(12, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startSupplyManager()", null, (short)1);
         }
         case 13: {
            // startupAgent_1Step10
            return new GoalStep(13, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startBuildOrderManager()", null, (short)1);
         }
         case 14: {
            // startStrategyManager_1Step1
            return new GoalStep(14, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "researchPsiStorm()", null, (short)0);
         }
         case 15: {
            // startStrategyManager_1Step2
            return new GoalStep(15, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "researchLegSpeeed()", null, (short)0);
         }
         case 16: {
            // startStrategyManager_1Step3
            return new GoalStep(16, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "researchDragoonRange()", null, (short)0);
         }
         case 17: {
            // startStrategyManager_1Step4
            return new GoalStep(17, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "researchCarrierCapacity()", null, (short)0);
         }
         case 18: {
            // startStrategyManager_1Step5
            return new GoalStep(18, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "researchObserverRange()", null, (short)0);
         }
         case 19: {
            // startStrategyManager_1Step6
            return new GoalStep(19, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "forceObservers()", null, (short)0);
         }
         case 20: {
            // startStrategyManager_1Step7
            return new GoalStep(20, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "forceExpansion()", null, (short)0);
         }
         case 21: {
            // startStrategyManager_1Step8
            return new GoalStep(21, __$behaviorParent, true, false, false, false, false, false, (short)1, (short)0, false, null, null, null, null, null, "forceBuildRobo()", null, (short)0);
         }
         case 22: {
            // startStrategyManager_1Step9
            return new GoalStep(22, __$behaviorParent, true, false, false, false, false, false, (short)1, (short)0, false, null, null, null, null, null, "forceBuildObservatory()", null, (short)0);
         }
         case 23: {
            // startStrategyManager_1Step10
            return new GoalStep(23, __$behaviorParent, true, false, false, false, false, false, (short)1, (short)0, false, null, null, null, null, null, "forceBuildObservers()", null, (short)0);
         }
         case 24: {
            // startStrategyManager_1Step11
            return new GoalStep(24, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "spendExcess()", null, (short)0);
         }
         case 25: {
            // forceExpansion_1Step1
            return new WaitStep(25, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 26: {
            // forceExpansion_1Step2
            return new MentalStep(26, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 27: {
            // forceExpansion_1Step3
            return new GoalStep(27, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 28: {
            // spendExcess_1Step1
            return new WaitStep(28, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 29: {
            // spendExcess_1Step2
            return new GoalStep(29, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "spendExcess(int, int)", null, (short)0);
         }
         case 30: {
            // spendExcess_1Step3
            return new GoalStep(30, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 31: {
            // spendExcess_2Step1
            return new WaitStep(31, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 32: {
            // spendExcess_2Step2
            return new GoalStep(32, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "spendExcess(int, int)", null, (short)0);
         }
         case 33: {
            // spendExcess_2Step3
            return new GoalStep(33, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 34: {
            // spendExcess_3Step1
            return new PrimitiveStep(34, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 35: {
            // spendExcess_3Step2
            return new PrimitiveStep(35, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 36: {
            // spendExcess_3Step3
            return new PrimitiveStep(36, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 37: {
            // spendExcess_3Step4
            return new MentalStep(37, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 38: {
            // spendExcess_3Step5
            return new GoalStep(38, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "deleteForgeUpgradeDelay()", null, (short)1);
         }
         case 39: {
            // deleteForgeUpgradeDelay_1Step1
            return new GoalStep(39, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 40: {
            // deleteForgeUpgradeDelay_1Step2
            return new MentalStep(40, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 41: {
            // spendExcess_4Step1
            return new MentalStep(41, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 42: {
            // spendExcess_5Step1
            return new PrimitiveStep(42, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Train(), null, "train");
         }
         case 43: {
            // spendExcess_6Step1
            return new PrimitiveStep(43, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Train(), null, "train");
         }
         case 44: {
            // spendExcess_7Step1
            return new PrimitiveStep(44, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Train(), null, "train");
         }
         case 45: {
            // researchPsiStorm_1Step1
            return new WaitStep(45, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 46: {
            // researchPsiStorm_1Step2
            return new MentalStep(46, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 47: {
            // researchPsiStorm_1Step3
            return new WaitStep(47, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 48: {
            // researchPsiStorm_1Step4
            return new PrimitiveStep(48, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Research(), null, "research");
         }
         case 49: {
            // researchPsiStorm_1Step5
            return new GoalStep(49, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 50: {
            // researchPsiStorm_1Step6
            return new PrimitiveStep(50, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Research(), null, "research");
         }
         case 51: {
            // researchPsiStorm_1Step7
            return new GoalStep(51, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 52: {
            // researchPsiStorm_1Step8
            return new PrimitiveStep(52, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Research(), null, "research");
         }
         case 53: {
            // researchPsiStorm_1Step9
            return new MentalStep(53, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 54: {
            // researchPsiStorm_1Step10
            return new GoalStep(54, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 55: {
            // researchPsiStorm_1Step11
            return new GoalStep(55, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "researchTemplarEnergy()", null, (short)0);
         }
         case 56: {
            // researchTemplarEnergy_1Step1
            return new WaitStep(56, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 57: {
            // researchTemplarEnergy_1Step2
            return new PrimitiveStep(57, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 58: {
            // researchLegSpeeed_1Step1
            return new WaitStep(58, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 59: {
            // researchLegSpeeed_1Step2
            return new PrimitiveStep(59, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 60: {
            // researchDragoonRange_1Step1
            return new WaitStep(60, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 61: {
            // researchDragoonRange_1Step2
            return new PrimitiveStep(61, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 62: {
            // researchCarrierCapacity_1Step1
            return new WaitStep(62, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 63: {
            // researchCarrierCapacity_1Step2
            return new PrimitiveStep(63, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 64: {
            // researchObserverRange_1Step1
            return new WaitStep(64, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 65: {
            // researchObserverRange_1Step2
            return new PrimitiveStep(65, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 66: {
            // researchObserverRange_1Step3
            return new GoalStep(66, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 67: {
            // researchObserverRange_1Step4
            return new GoalStep(67, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "researchObserverSpeed()", null, (short)0);
         }
         case 68: {
            // researchObserverSpeed_1Step1
            return new WaitStep(68, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 69: {
            // researchObserverSpeed_1Step2
            return new PrimitiveStep(69, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 70: {
            // forceObservers_1Step1
            return new WaitStep(70, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 71: {
            // forceObservers_1Step2
            return new MentalStep(71, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 72: {
            // forceBuildRobo_1Step1
            return new WaitStep(72, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 73: {
            // forceBuildRobo_1Step2
            return new MentalStep(73, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 74: {
            // forceBuildRobo_1Step3
            return new GoalStep(74, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 75: {
            // forceBuildObservatory_1Step1
            return new WaitStep(75, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 76: {
            // forceBuildObservatory_1Step2
            return new MentalStep(76, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 77: {
            // forceBuildObservatory_1Step3
            return new GoalStep(77, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 78: {
            // forceBuildObservers_1Step1
            return new WaitStep(78, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 79: {
            // forceBuildObservers_1Step2
            return new MentalStep(79, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 80: {
            // forceBuildObservers_1Step3
            return new GoalStep(80, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 81: {
            // startScoutingManager_1Step1
            return new GoalStep(81, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "pickScout()", null, (short)0);
         }
         case 82: {
            // startScoutingManager_1Step2
            return new GoalStep(82, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "scoutFlee()", null, (short)0);
         }
         case 83: {
            // pickScout_1Step1
            return new GoalStep(83, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 84: {
            // pickScout_1Step2
            return new WaitStep(84, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 85: {
            // pickScout_1Step3
            return new MentalStep(85, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 86: {
            // pickScout_1Step4
            return new GoalStep(86, __$behaviorParent, false, true, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "workerScout(ProbeWME, int)", null, (short)0);
         }
         case 87: {
            // workerScout_1Step1
            return new MentalStep(87, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 88: {
            // workerScout_1Step2
            return new GoalStep(88, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "continueBehavior(boolean)", null, (short)0);
         }
         case 89: {
            // workerScout_1Step3
            return new PrimitiveStep(89, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickTile(), null, "rightClickTile");
         }
         case 90: {
            // workerScout_1Step4
            return new GoalStep(90, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 91: {
            // workerScout_1Step5
            return new WaitStep(91, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 92: {
            // workerScout_2Step1
            return new MentalStep(92, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 93: {
            // workerScout_2Step2
            return new PrimitiveStep(93, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickTile(), null, "rightClickTile");
         }
         case 94: {
            // workerScout_2Step3
            return new GoalStep(94, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 95: {
            // workerScout_2Step4
            return new WaitStep(95, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 96: {
            // scoutFlee_1Step1
            return new WaitStep(96, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 97: {
            // scoutFlee_1Step2
            return new PrimitiveStep(97, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickTile(), null, "rightClickTile");
         }
         case 98: {
            // scoutFlee_1Step3
            return new GoalStep(98, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 99: {
            // scoutFlee_1Step4
            return new MentalStep(99, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 100: {
            // scoutFlee_1Step5
            return new PrimitiveStep(100, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickTile(), null, "rightClickTile");
         }
         case 101: {
            // scoutFlee_1Step6
            return new GoalStep(101, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 102: {
            // startSupplyManager_1Step1
            return new MentalStep(102, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 103: {
            // startSupplyManager_1Step2
            return new GoalStep(103, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "preventSupplyLock()", null, (short)0);
         }
         case 104: {
            // startSupplyManager_1Step3
            return new GoalStep(104, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "preventStalledSupply()", null, (short)0);
         }
         case 105: {
            // preventSupplyLock_1Step1
            return new WaitStep(105, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 106: {
            // preventSupplyLock_1Step2
            return new MentalStep(106, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 107: {
            // preventSupplyLock_1Step3
            return new GoalStep(107, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 108: {
            // preventStalledSupply_1Step1
            return new WaitStep(108, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 109: {
            // preventStalledSupply_1Step2
            return new MentalStep(109, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 110: {
            // preventStalledSupply_1Step3
            return new GoalStep(110, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 111: {
            // startBuildOrderManager_1Step1
            return new MentalStep(111, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 112: {
            // startBuildOrderManager_1Step2
            return new GoalStep(112, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "getNextBuildStep()", null, (short)0);
         }
         case 113: {
            // getNextBuildStep_1Step1
            return new MentalStep(113, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 114: {
            // getNextBuildStep_1Step2
            return new WaitStep(114, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 115: {
            // getNextBuildStep_1Step3
            return new MentalStep(115, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 116: {
            // getNextBuildStep_1Step4
            return new GoalStep(116, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "processBuildStep(RequestWME)", null, (short)0);
         }
         case 117: {
            // getNextBuildStep_1Step5
            return new MentalStep(117, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 118: {
            // processBuildStep_1Step1
            return new MentalStep(118, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 119: {
            // processBuildStep_2Step1
            return new MentalStep(119, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 120: {
            // startCBRManager_1Step1
            return new MentalStep(120, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 121: {
            // startCBRManager_1Step2
            return new GoalStep(121, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "processUnitRequests()", null, (short)0);
         }
         case 122: {
            // startCBRManager_1Step3
            return new GoalStep(122, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "processBuildingRequests()", null, (short)0);
         }
         case 123: {
            // startCBRManager_1Step4
            return new GoalStep(123, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "processResearchRequests()", null, (short)0);
         }
         case 124: {
            // startCBRManager_1Step5
            return new GoalStep(124, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "processArchonRequests()", null, (short)0);
         }
         case 125: {
            // processUnitRequests_1Step1
            return new WaitStep(125, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 126: {
            // processUnitRequests_1Step2
            return new GoalStep(126, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "handleUnitRequest(int, int, int, int)", null, (short)0);
         }
         case 127: {
            // processUnitRequests_1Step3
            return new GoalStep(127, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "handlePrereqs(int, int)", null, (short)0);
         }
         case 128: {
            // processUnitRequests_1Step4
            return new GoalStep(128, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 129: {
            // processUnitRequests_1Step5
            return new MentalStep(129, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 130: {
            // handlePrereqs_1Step1
            return new MentalStep(130, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 131: {
            // handleUnitRequest_1Step1
            return new WaitStep(131, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 132: {
            // handleUnitRequest_1Step2
            return new MentalStep(132, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 133: {
            // handleUnitRequest_2Step1
            return new WaitStep(133, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 134: {
            // handleUnitRequest_2Step2
            return new MentalStep(134, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 135: {
            // handleUnitRequest_3Step1
            return new WaitStep(135, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 136: {
            // handleUnitRequest_3Step2
            return new MentalStep(136, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 137: {
            // handleUnitRequest_4Step1
            return new WaitStep(137, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 138: {
            // handleUnitRequest_4Step2
            return new MentalStep(138, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 139: {
            // handleUnitRequest_5Step1
            return new WaitStep(139, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 140: {
            // handleUnitRequest_5Step2
            return new MentalStep(140, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 141: {
            // handleUnitRequest_6Step1
            return new WaitStep(141, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 142: {
            // handleUnitRequest_6Step2
            return new MentalStep(142, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 143: {
            // processBuildingRequests_1Step1
            return new WaitStep(143, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 144: {
            // processBuildingRequests_1Step2
            return new GoalStep(144, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "handleBuildingRequest(int, int, int)", null, (short)0);
         }
         case 145: {
            // processBuildingRequests_1Step3
            return new GoalStep(145, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "handlePrereqs(int, int)", null, (short)0);
         }
         case 146: {
            // processBuildingRequests_1Step4
            return new GoalStep(146, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 147: {
            // processBuildingRequests_1Step5
            return new MentalStep(147, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 148: {
            // handleBuildingRequest_1Step1
            return new MentalStep(148, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 149: {
            // handleBuildingRequest_2Step1
            return new MentalStep(149, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 150: {
            // handleBuildingRequest_3Step1
            return new WaitStep(150, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 151: {
            // handleBuildingRequest_3Step2
            return new MentalStep(151, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 152: {
            // handleBuildingRequest_4Step1
            return new MentalStep(152, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 153: {
            // processResearchRequests_1Step1
            return new WaitStep(153, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 154: {
            // processResearchRequests_1Step2
            return new GoalStep(154, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "handleResearchRequest(boolean, int, int, int, int)", null, (short)0);
         }
         case 155: {
            // processResearchRequests_1Step3
            return new GoalStep(155, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "handlePrereqs(int, int)", null, (short)0);
         }
         case 156: {
            // processResearchRequests_1Step4
            return new GoalStep(156, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 157: {
            // processResearchRequests_1Step5
            return new MentalStep(157, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 158: {
            // handleResearchRequest_1Step1
            return new WaitStep(158, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 159: {
            // handleResearchRequest_1Step2
            return new PrimitiveStep(159, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 160: {
            // handleResearchRequest_2Step1
            return new WaitStep(160, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 161: {
            // handleResearchRequest_2Step2
            return new PrimitiveStep(161, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Upgrade(), null, "upgrade");
         }
         case 162: {
            // handleResearchRequest_3Step1
            return new WaitStep(162, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 163: {
            // handleResearchRequest_3Step2
            return new PrimitiveStep(163, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Research(), null, "research");
         }
         case 164: {
            // handleResearchRequest_4Step1
            return new WaitStep(164, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 165: {
            // handleResearchRequest_4Step2
            return new PrimitiveStep(165, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Research(), null, "research");
         }
         case 166: {
            // processArchonRequests_1Step1
            return new WaitStep(166, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 167: {
            // processArchonRequests_1Step2
            return new GoalStep(167, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "handleArchonRequest(ArchonRequestWME)", null, (short)0);
         }
         case 168: {
            // processArchonRequests_1Step3
            return new GoalStep(168, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 169: {
            // processArchonRequests_1Step4
            return new MentalStep(169, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 170: {
            // handleArchonRequest_1Step1
            return new MentalStep(170, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 171: {
            // handleArchonRequest_1Step2
            return new PrimitiveStep(171, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new UseTechTarget(), null, "useTechTarget");
         }
         case 172: {
            // handleArchonRequest_1Step3
            return new GoalStep(172, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 173: {
            // handleArchonRequest_2Step1
            return new WaitStep(173, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 174: {
            // handleArchonRequest_2Step2
            return new MentalStep(174, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 175: {
            // handleArchonRequest_2Step3
            return new PrimitiveStep(175, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new UseTechTarget(), null, "useTechTarget");
         }
         case 176: {
            // handleArchonRequest_2Step4
            return new GoalStep(176, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 177: {
            // handleArchonRequest_3Step1
            return new GoalStep(177, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 178: {
            // startProductionManager_1Step1
            return new GoalStep(178, __$behaviorParent, true, false, false, false, false, false, (short)2, (short)0, false, null, null, null, null, null, "produceObservers()", null, (short)0);
         }
         case 179: {
            // startProductionManager_1Step2
            return new GoalStep(179, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "produceUnits()", null, (short)0);
         }
         case 180: {
            // startProductionManager_1Step3
            return new GoalStep(180, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "produceUnitsNow()", null, (short)0);
         }
         case 181: {
            // startProductionManager_1Step4
            return new GoalStep(181, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "limitQueueSize()", null, (short)0);
         }
         case 182: {
            // limitQueueSize_1Step1
            return new WaitStep(182, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 183: {
            // limitQueueSize_1Step2
            return new GoalStep(183, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 184: {
            // limitQueueSize_1Step3
            return new GoalStep(184, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "cancelTrain(int)", null, (short)0);
         }
         case 185: {
            // cancelTrain_1Step1
            return new MentalStep(185, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 186: {
            // cancelTrain_1Step2
            return new PrimitiveStep(186, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new CancelTrain(), null, "cancelTrain");
         }
         case 187: {
            // cancelTrain_1Step3
            return new GoalStep(187, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 188: {
            // produceObservers_1Step1
            return new WaitStep(188, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 189: {
            // produceObservers_1Step2
            return new GoalStep(189, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "trainUnit(int, int)", null, (short)0);
         }
         case 190: {
            // produceObservers_1Step3
            return new GoalStep(190, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 191: {
            // produceObservers_1Step4
            return new MentalStep(191, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 192: {
            // produceUnits_1Step1
            return new WaitStep(192, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 193: {
            // produceUnits_1Step2
            return new GoalStep(193, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "trainUnit(int, int)", null, (short)0);
         }
         case 194: {
            // produceUnits_1Step3
            return new GoalStep(194, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 195: {
            // produceUnits_1Step4
            return new MentalStep(195, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 196: {
            // produceUnitsNow_1Step1
            return new WaitStep(196, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 197: {
            // produceUnitsNow_1Step2
            return new GoalStep(197, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "trainUnit(int, int)", null, (short)0);
         }
         case 198: {
            // produceUnitsNow_1Step3
            return new GoalStep(198, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 199: {
            // produceUnitsNow_1Step4
            return new MentalStep(199, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 200: {
            // trainUnit_2Step1
            return new PrimitiveStep(200, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Train(), null, "train");
         }
         case 201: {
            // startWorkerManager_1Step1
            return new GoalStep(201, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "pumpProbesBuildOrder()", null, (short)0);
         }
         case 202: {
            // startWorkerManager_1Step2
            return new GoalStep(202, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "pumpProbesExcess()", null, (short)0);
         }
         case 203: {
            // startWorkerManager_1Step3
            return new GoalStep(203, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "pumpProbesCBR()", null, (short)0);
         }
         case 204: {
            // startWorkerManager_1Step4
            return new GoalStep(204, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "additionalAssimilators()", null, (short)0);
         }
         case 205: {
            // startWorkerManager_1Step5
            return new GoalStep(205, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "mineMinerals()", null, (short)0);
         }
         case 206: {
            // startWorkerManager_1Step6
            return new GoalStep(206, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "gasTransfer()", null, (short)0);
         }
         case 207: {
            // startWorkerManager_1Step7
            return new GoalStep(207, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "checkMinedOut()", null, (short)0);
         }
         case 208: {
            // startWorkerManager_1Step8
            return new GoalStep(208, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "probeTransfer()", null, (short)0);
         }
         case 209: {
            // startWorkerManager_1Step9
            return new GoalStep(209, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "manageWorkerHarass()", null, (short)0);
         }
         case 210: {
            // startWorkerManager_1Step10
            return new GoalStep(210, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "manageBaseHarass()", null, (short)0);
         }
         case 211: {
            // startWorkerManager_1Step11
            return new GoalStep(211, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "pullOffGasDefense()", null, (short)0);
         }
         case 212: {
            // startWorkerManager_1Step12
            return new GoalStep(212, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "putOnGas()", null, (short)0);
         }
         case 213: {
            // startWorkerManager_1Step13
            return new GoalStep(213, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "detectIdleGasWorkers()", null, (short)0);
         }
         case 214: {
            // startWorkerManager_1Step14
            return new GoalStep(214, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "detectIdleConstructors()", null, (short)0);
         }
         case 215: {
            // startWorkerManager_1Step15
            return new GoalStep(215, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "forceAssimilator()", null, (short)0);
         }
         case 216: {
            // startWorkerManager_1Step16
            return new GoalStep(216, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "clearMineralBlocks()", null, (short)0);
         }
         case 217: {
            // detectIdleGasWorkers_1Step1
            return new WaitStep(217, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 218: {
            // detectIdleGasWorkers_1Step2
            return new MentalStep(218, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 219: {
            // detectIdleGasWorkers_1Step3
            return new GoalStep(219, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 220: {
            // detectIdleConstructors_1Step1
            return new WaitStep(220, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 221: {
            // detectIdleConstructors_1Step2
            return new MentalStep(221, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 222: {
            // detectIdleConstructors_1Step3
            return new GoalStep(222, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 223: {
            // clearMineralBlocks_1Step1
            return new WaitStep(223, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 224: {
            // clearMineralBlocks_1Step2
            return new MentalStep(224, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 225: {
            // clearMineralBlocks_1Step3
            return new PrimitiveStep(225, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickUnit(), null, "rightClickUnit");
         }
         case 226: {
            // clearMineralBlocks_1Step4
            return new GoalStep(226, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 227: {
            // clearMineralBlocks_1Step5
            return new WaitStep(227, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 228: {
            // clearMineralBlocks_1Step6
            return new MentalStep(228, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 229: {
            // forceAssimilator_1Step1
            return new WaitStep(229, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 230: {
            // forceAssimilator_1Step2
            return new MentalStep(230, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 231: {
            // forceAssimilator_1Step3
            return new GoalStep(231, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 232: {
            // pumpProbesBuildOrder_1Step1
            return new WaitStep(232, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 233: {
            // pumpProbesBuildOrder_1Step2
            return new PrimitiveStep(233, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Train(), null, "train");
         }
         case 234: {
            // pumpProbesBuildOrder_1Step3
            return new GoalStep(234, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 235: {
            // pumpProbesExcess_1Step1
            return new WaitStep(235, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 236: {
            // pumpProbesExcess_1Step2
            return new PrimitiveStep(236, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Train(), null, "train");
         }
         case 237: {
            // pumpProbesExcess_1Step3
            return new GoalStep(237, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 238: {
            // pumpProbesCBR_1Step1
            return new WaitStep(238, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 239: {
            // pumpProbesCBR_1Step2
            return new PrimitiveStep(239, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Train(), null, "train");
         }
         case 240: {
            // pumpProbesCBR_1Step3
            return new GoalStep(240, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 241: {
            // additionalAssimilators_1Step1
            return new WaitStep(241, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 242: {
            // additionalAssimilators_1Step2
            return new MentalStep(242, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 243: {
            // additionalAssimilators_1Step3
            return new GoalStep(243, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 244: {
            // pullOffGas_1Step1
            return new WaitStep(244, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 245: {
            // pullOffGas_1Step2
            return new MentalStep(245, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 246: {
            // pullOffGas_1Step3
            return new GoalStep(246, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 247: {
            // pullOffGasDefense_1Step1
            return new WaitStep(247, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 248: {
            // pullOffGasDefense_1Step2
            return new MentalStep(248, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 249: {
            // pullOffGasDefense_1Step3
            return new GoalStep(249, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 250: {
            // pullOffGasDefense_1Step4
            return new MentalStep(250, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 251: {
            // putOnGas_1Step1
            return new WaitStep(251, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 252: {
            // putOnGas_1Step2
            return new MentalStep(252, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 253: {
            // putOnGas_1Step3
            return new GoalStep(253, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 254: {
            // manageWorkerHarass_1Step1
            return new WaitStep(254, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 255: {
            // manageWorkerHarass_1Step2
            return new MentalStep(255, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 256: {
            // manageWorkerHarass_1Step3
            return new GoalStep(256, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "workerDefend(ProbeWME, int, int, int, int)", null, (short)1);
         }
         case 257: {
            // manageWorkerHarass_1Step4
            return new GoalStep(257, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 258: {
            // manageWorkerHarass_1Step5
            return new GoalStep(258, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "getFriendHelp(int, int, int, int, int)", null, (short)1);
         }
         case 259: {
            // manageWorkerHarass_1Step6
            return new GoalStep(259, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 260: {
            // manageBaseHarass_1Step1
            return new WaitStep(260, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 261: {
            // manageBaseHarass_1Step2
            return new GoalStep(261, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "getFriendHelp(int, int, int, int, int)", null, (short)1);
         }
         case 262: {
            // manageBaseHarass_1Step3
            return new GoalStep(262, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 263: {
            // getFriendHelp_1Step1
            return new MentalStep(263, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 264: {
            // getFriendHelp_1Step2
            return new GoalStep(264, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "workerDefend(ProbeWME, int, int, int, int)", null, (short)1);
         }
         case 265: {
            // getFriendHelp_1Step3
            return new GoalStep(265, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 266: {
            // getFriendHelp_1Step4
            return new GoalStep(266, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "getFriendHelp(int, int, int, int, int)", null, (short)1);
         }
         case 267: {
            // workerDefend_1Step1
            return new PrimitiveStep(267, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 268: {
            // workerDefend_1Step2
            return new GoalStep(268, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 269: {
            // workerDefend_1Step3
            return new GoalStep(269, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "returnToWork(ProbeWME, int, int)", null, (short)0);
         }
         case 270: {
            // workerDefend_1Step4
            return new GoalStep(270, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 271: {
            // returnToWork_1Step1
            return new PrimitiveStep(271, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickUnit(), null, "rightClickUnit");
         }
         case 272: {
            // returnToWork_1Step2
            return new GoalStep(272, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 273: {
            // returnToWork_1Step3
            return new MentalStep(273, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 274: {
            // returnToWork_2Step1
            return new PrimitiveStep(274, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickUnit(), null, "rightClickUnit");
         }
         case 275: {
            // returnToWork_2Step2
            return new GoalStep(275, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 276: {
            // returnToWork_2Step3
            return new MentalStep(276, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 277: {
            // probeTransfer_1Step1
            return new WaitStep(277, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 278: {
            // probeTransfer_1Step2
            return new GoalStep(278, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "transferWorkers(NexusWME, int, int, int, int)", null, (short)0);
         }
         case 279: {
            // probeTransfer_1Step3
            return new GoalStep(279, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 280: {
            // transferWorkers_1Step1
            return new MentalStep(280, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 281: {
            // transferWorkers_1Step2
            return new PrimitiveStep(281, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickUnit(), null, "rightClickUnit");
         }
         case 282: {
            // transferWorkers_1Step3
            return new GoalStep(282, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "transferWorkers(NexusWME, int, int, int, int)", null, (short)0);
         }
         case 283: {
            // mineMinerals_1Step1
            return new WaitStep(283, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 284: {
            // mineMinerals_1Step2
            return new GoalStep(284, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "selectMinerals(ProbeWME, int, int, int)", null, (short)0);
         }
         case 285: {
            // mineMinerals_1Step3
            return new MentalStep(285, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 286: {
            // selectMinerals_1Step1
            return new MentalStep(286, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 287: {
            // selectMinerals_1Step2
            return new PrimitiveStep(287, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickUnit(), null, "rightClickUnit");
         }
         case 288: {
            // selectMinerals_2Step1
            return new MentalStep(288, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 289: {
            // selectMinerals_2Step2
            return new PrimitiveStep(289, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickUnit(), null, "rightClickUnit");
         }
         case 290: {
            // gasTransfer_1Step1
            return new WaitStep(290, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 291: {
            // gasTransfer_1Step2
            return new GoalStep(291, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "modifyGasCollectors(AssimilatorWME, int, int, int, int, int)", null, (short)0);
         }
         case 292: {
            // gasTransfer_1Step3
            return new GoalStep(292, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 293: {
            // modifyGasCollectors_1Step1
            return new MentalStep(293, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 294: {
            // modifyGasCollectors_1Step2
            return new PrimitiveStep(294, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickUnit(), null, "rightClickUnit");
         }
         case 295: {
            // modifyGasCollectors_2Step1
            return new MentalStep(295, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 296: {
            // modifyGasCollectors_3Step1
            return new GoalStep(296, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 297: {
            // checkMinedOut_1Step1
            return new WaitStep(297, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 298: {
            // checkMinedOut_1Step2
            return new MentalStep(298, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 299: {
            // focusMinerals_1Step1
            return new GoalStep(299, __$behaviorParent, false, true, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "forceMinerals()", null, (short)0);
         }
         case 300: {
            // forceMinerals_1Step1
            return new MentalStep(300, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 301: {
            // focusGas_1Step1
            return new GoalStep(301, __$behaviorParent, false, true, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "forceGas()", null, (short)0);
         }
         case 302: {
            // forceGas_1Step1
            return new MentalStep(302, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 303: {
            // startConstructionManager_1Step1
            return new GoalStep(303, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "waitForConstructionRequest()", null, (short)0);
         }
         case 304: {
            // waitForConstructionRequest_1Step1
            return new WaitStep(304, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 305: {
            // waitForConstructionRequest_1Step2
            return new MentalStep(305, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 306: {
            // waitForConstructionRequest_1Step3
            return new GoalStep(306, __$behaviorParent, false, false, true, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "processConstructionWME(ConstructionWME, int)", null, (short)0);
         }
         case 307: {
            // waitForConstructionRequest_1Step4
            return new MentalStep(307, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 308: {
            // delayNextNexus_1Step1
            return new MentalStep(308, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 309: {
            // processConstructionWME_3Step1
            return new MentalStep(309, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 310: {
            // processConstructionWME_3Step2
            return new GoalStep(310, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "freeResources(ConstructionWME)", null, (short)0);
         }
         case 311: {
            // processConstructionWME_4Step1
            return new GoalStep(311, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "delayNextNexus(ConstructionWME)", null, (short)0);
         }
         case 312: {
            // processConstructionWME_4Step2
            return new WaitStep(312, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 313: {
            // processConstructionWME_4Step3
            return new MentalStep(313, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 314: {
            // processConstructionWME_4Step4
            return new GoalStep(314, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "selectConstructor(ConstructionWME, int)", null, (short)0);
         }
         case 315: {
            // processConstructionWME_5Step1
            return new GoalStep(315, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "freeResources(ConstructionWME)", null, (short)0);
         }
         case 316: {
            // selectConstructor_1Step1
            return new GoalStep(316, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "assignConstructionWorker(ConstructionWME, int, ProbeWME, int)", null, (short)0);
         }
         case 317: {
            // selectConstructor_2Step1
            return new GoalStep(317, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "assignConstructionWorker(ConstructionWME, int, ProbeWME, int)", null, (short)0);
         }
         case 318: {
            // assignConstructionWorker_1Step1
            return new MentalStep(318, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 319: {
            // assignConstructionWorker_1Step2
            return new GoalStep(319, __$behaviorParent, false, false, true, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "selectBuildSite(int, ProbeWME, int)", null, (short)0);
         }
         case 320: {
            // assignConstructionWorker_1Step3
            return new GoalStep(320, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "freeResources(ConstructionWME)", null, (short)0);
         }
         case 321: {
            // assignConstructionWorker_1Step4
            return new MentalStep(321, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 322: {
            // assignConstructionWorker_1Step5
            return new GoalStep(322, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "monitorTrappedWorkers(ProbeWME, int)", null, (short)1);
         }
         case 323: {
            // monitorTrappedWorkers_1Step1
            return new GoalStep(323, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 324: {
            // monitorTrappedWorkers_1Step2
            return new MentalStep(324, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 325: {
            // monitorTrappedWorkers_1Step3
            return new GoalStep(325, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "monitorTrapped(ProbeWME, int, int, int, int)", null, (short)0);
         }
         case 326: {
            // monitorTrapped_1Step1
            return new GoalStep(326, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 327: {
            // monitorTrapped_1Step2
            return new MentalStep(327, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 328: {
            // selectBuildSite_1Step1
            return new MentalStep(328, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 329: {
            // selectBuildSite_2Step1
            return new MentalStep(329, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 330: {
            // selectBuildSite_2Step2
            return new PrimitiveStep(330, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickTile(), null, "rightClickTile");
         }
         case 331: {
            // selectBuildSite_2Step3
            return new GoalStep(331, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 332: {
            // selectBuildSite_2Step4
            return new GoalStep(332, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "buildTile(int, int, int, int)", null, (short)0);
         }
         case 333: {
            // selectBuildSite_2Step5
            return new GoalStep(333, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 334: {
            // buildTile_1Step1
            return new PrimitiveStep(334, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new BuildTile(), null, "buildTile");
         }
         case 335: {
            // selectBuildSite_3Step1
            return new MentalStep(335, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 336: {
            // freeResources_1Step1
            return new MentalStep(336, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 337: {
            // startTacticsManager_1Step1
            return new MentalStep(337, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 338: {
            // startTacticsManager_1Step2
            return new GoalStep(338, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "createSquad()", null, (short)0);
         }
         case 339: {
            // startTacticsManager_1Step3
            return new GoalStep(339, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "deleteSquad()", null, (short)0);
         }
         case 340: {
            // startTacticsManager_1Step4
            return new GoalStep(340, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "squadSelectTarget()", null, (short)0);
         }
         case 341: {
            // startTacticsManager_1Step5
            return new GoalStep(341, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "squadRetreat()", null, (short)0);
         }
         case 342: {
            // startTacticsManager_1Step6
            return new GoalStep(342, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "squadMerge()", null, (short)0);
         }
         case 343: {
            // startTacticsManager_1Step7
            return new GoalStep(343, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "squadBreakup()", null, (short)0);
         }
         case 344: {
            // startTacticsManager_1Step8
            return new GoalStep(344, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "archonAssignSquad()", null, (short)0);
         }
         case 345: {
            // startTacticsManager_1Step9
            return new GoalStep(345, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "attackerAssignSquad()", null, (short)0);
         }
         case 346: {
            // startTacticsManager_1Step10
            return new GoalStep(346, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "airSquadAttack()", null, (short)0);
         }
         case 347: {
            // startTacticsManager_1Step11
            return new GoalStep(347, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "corsairSquadAttack()", null, (short)0);
         }
         case 348: {
            // startTacticsManager_1Step12
            return new GoalStep(348, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "rallyUnits()", null, (short)0);
         }
         case 349: {
            // startTacticsManager_1Step13
            return new GoalStep(349, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "unblockChokes()", null, (short)0);
         }
         case 350: {
            // startTacticsManager_1Step14
            return new GoalStep(350, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "scatterAttack()", null, (short)0);
         }
         case 351: {
            // startTacticsManager_1Step15
            return new GoalStep(351, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "flee()", null, (short)0);
         }
         case 352: {
            // startTacticsManager_1Step16
            return new GoalStep(352, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "fleeDamage()", null, (short)0);
         }
         case 353: {
            // startTacticsManager_1Step17
            return new GoalStep(353, __$behaviorParent, true, false, false, false, false, false, (short)3, (short)0, false, null, null, null, null, null, "defendBaseGround()", null, (short)0);
         }
         case 354: {
            // startTacticsManager_1Step18
            return new GoalStep(354, __$behaviorParent, true, false, false, false, false, false, (short)3, (short)0, false, null, null, null, null, null, "defendBaseAir()", null, (short)0);
         }
         case 355: {
            // startTacticsManager_1Step19
            return new GoalStep(355, __$behaviorParent, true, false, false, false, false, false, (short)3, (short)0, false, null, null, null, null, null, "defendBaseCaster()", null, (short)0);
         }
         case 356: {
            // startTacticsManager_1Step20
            return new GoalStep(356, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "observerSupport()", null, (short)0);
         }
         case 357: {
            // startTacticsManager_1Step21
            return new GoalStep(357, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "observerFlee()", null, (short)0);
         }
         case 358: {
            // startTacticsManager_1Step22
            return new GoalStep(358, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "revealCloakedUnits()", null, (short)0);
         }
         case 359: {
            // startTacticsManager_1Step23
            return new GoalStep(359, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "revealBurrowedUnits()", null, (short)0);
         }
         case 360: {
            // startTacticsManager_1Step24
            return new GoalStep(360, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "casterAssignSquad()", null, (short)0);
         }
         case 361: {
            // startTacticsManager_1Step25
            return new GoalStep(361, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "casterFollowSquad()", null, (short)0);
         }
         case 362: {
            // startTacticsManager_1Step26
            return new GoalStep(362, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "casterRetreat()", null, (short)0);
         }
         case 363: {
            // startTacticsManager_1Step27
            return new GoalStep(363, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "psiStorm()", null, (short)0);
         }
         case 364: {
            // startTacticsManager_1Step28
            return new GoalStep(364, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "mergeArchon()", null, (short)0);
         }
         case 365: {
            // startTacticsManager_1Step29
            return new GoalStep(365, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "trainInterceptors()", null, (short)0);
         }
         case 366: {
            // defendBaseGround_1Step1
            return new WaitStep(366, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 367: {
            // defendBaseGround_1Step2
            return new MentalStep(367, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 368: {
            // defendBaseGround_1Step3
            return new PrimitiveStep(368, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 369: {
            // defendBaseGround_1Step4
            return new GoalStep(369, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 370: {
            // airSquadAttack_1Step1
            return new WaitStep(370, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 371: {
            // airSquadAttack_1Step2
            return new PrimitiveStep(371, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 372: {
            // airSquadAttack_1Step3
            return new GoalStep(372, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 373: {
            // corsairSquadAttack_1Step1
            return new WaitStep(373, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 374: {
            // corsairSquadAttack_1Step2
            return new PrimitiveStep(374, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackUnit(), null, "attackUnit");
         }
         case 375: {
            // corsairSquadAttack_1Step3
            return new GoalStep(375, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 376: {
            // defendBaseAir_1Step1
            return new WaitStep(376, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 377: {
            // defendBaseAir_1Step2
            return new MentalStep(377, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 378: {
            // defendBaseAir_1Step3
            return new PrimitiveStep(378, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 379: {
            // defendBaseAir_1Step4
            return new GoalStep(379, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 380: {
            // defendBaseCaster_1Step1
            return new WaitStep(380, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 381: {
            // defendBaseCaster_1Step2
            return new MentalStep(381, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 382: {
            // defendBaseCaster_1Step3
            return new PrimitiveStep(382, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 383: {
            // defendBaseCaster_1Step4
            return new GoalStep(383, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 384: {
            // createSquad_1Step1
            return new WaitStep(384, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 385: {
            // createSquad_1Step2
            return new MentalStep(385, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 386: {
            // createSquad_1Step3
            return new GoalStep(386, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 387: {
            // createSquad_1Step4
            return new PrimitiveStep(387, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new SquadAttackTile(), null, "squadAttackTile");
         }
         case 388: {
            // createSquad_1Step5
            return new MentalStep(388, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 389: {
            // createSquad_1Step6
            return new GoalStep(389, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "manageSquadGrouping(int)", null, (short)1);
         }
         case 390: {
            // manageSquadGrouping_1Step1
            return new GoalStep(390, __$behaviorParent, false, true, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "regroupSquad(int)", null, (short)0);
         }
         case 391: {
            // regroupSquad_1Step1
            return new GoalStep(391, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 392: {
            // regroupSquad_1Step2
            return new WaitStep(392, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 393: {
            // regroupSquad_1Step3
            return new MentalStep(393, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 394: {
            // regroupSquad_1Step4
            return new WaitStep(394, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 395: {
            // regroupSquad_1Step5
            return new MentalStep(395, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 396: {
            // regroupSquad_1Step6
            return new GoalStep(396, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "squadSelectTarget(int)", null, (short)0);
         }
         case 397: {
            // regroupSquad_2Step1
            return new GoalStep(397, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "squadSelectTarget(int)", null, (short)0);
         }
         case 398: {
            // squadBreakup_1Step1
            return new WaitStep(398, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 399: {
            // squadBreakup_1Step2
            return new MentalStep(399, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 400: {
            // squadBreakup_1Step3
            return new GoalStep(400, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 401: {
            // squadSelectTarget_1Step1
            return new WaitStep(401, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 402: {
            // squadSelectTarget_1Step2
            return new GoalStep(402, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "squadSelectTarget(int)", null, (short)0);
         }
         case 403: {
            // squadSelectTarget_1Step3
            return new GoalStep(403, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 404: {
            // squadSelectTarget_2Step1
            return new PrimitiveStep(404, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new SquadAttackTile(), null, "squadAttackTile");
         }
         case 405: {
            // squadSelectTarget_3Step1
            return new PrimitiveStep(405, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new SquadAttackTile(), null, "squadAttackTile");
         }
         case 406: {
            // squadSelectTarget_4Step1
            return new PrimitiveStep(406, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new SquadAttackTile(), null, "squadAttackTile");
         }
         case 407: {
            // squadSelectTarget_5Step1
            return new PrimitiveStep(407, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new SquadAttackTile(), null, "squadAttackTile");
         }
         case 408: {
            // squadSelectTarget_6Step1
            return new GoalStep(408, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 409: {
            // deleteSquad_1Step1
            return new WaitStep(409, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 410: {
            // deleteSquad_1Step2
            return new MentalStep(410, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 411: {
            // squadRetreat_1Step1
            return new WaitStep(411, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 412: {
            // squadRetreat_1Step2
            return new MentalStep(412, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 413: {
            // squadRetreat_1Step3
            return new GoalStep(413, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "manageRetreat(SquadWME, int)", null, (short)1);
         }
         case 414: {
            // squadRetreat_1Step4
            return new GoalStep(414, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 415: {
            // squadMerge_1Step1
            return new WaitStep(415, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 416: {
            // squadMerge_1Step2
            return new MentalStep(416, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 417: {
            // squadMerge_1Step3
            return new GoalStep(417, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 418: {
            // squadMerge_1Step4
            return new PrimitiveStep(418, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new SquadAttackTile(), null, "squadAttackTile");
         }
         case 419: {
            // squadMerge_1Step5
            return new MentalStep(419, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 420: {
            // squadMerge_1Step6
            return new GoalStep(420, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "manageSquadGrouping(int)", null, (short)1);
         }
         case 421: {
            // squadMerge_1Step7
            return new GoalStep(421, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 422: {
            // manageRetreat_1Step1
            return new MentalStep(422, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 423: {
            // manageRetreat_1Step2
            return new GoalStep(423, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 424: {
            // manageRetreat_1Step3
            return new GoalStep(424, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "stopRetreat(SquadWME, int)", null, (short)0);
         }
         case 425: {
            // stopRetreat_1Step1
            return new MentalStep(425, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 426: {
            // stopRetreat_2Step1
            return new MentalStep(426, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 427: {
            // rallyUnits_1Step1
            return new WaitStep(427, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 428: {
            // rallyUnits_1Step2
            return new MentalStep(428, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 429: {
            // rallyUnits_1Step3
            return new PrimitiveStep(429, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 430: {
            // rallyUnits_1Step4
            return new GoalStep(430, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 431: {
            // unblockChokes_1Step1
            return new WaitStep(431, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 432: {
            // unblockChokes_1Step2
            return new MentalStep(432, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 433: {
            // unblockChokes_1Step3
            return new PrimitiveStep(433, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 434: {
            // unblockChokes_1Step4
            return new GoalStep(434, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 435: {
            // scatterAttack_1Step1
            return new WaitStep(435, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 436: {
            // scatterAttack_1Step2
            return new MentalStep(436, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 437: {
            // scatterAttack_1Step3
            return new PrimitiveStep(437, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 438: {
            // observerSupport_1Step1
            return new WaitStep(438, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 439: {
            // observerSupport_1Step2
            return new PrimitiveStep(439, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Follow(), null, "follow");
         }
         case 440: {
            // observerSupport_1Step3
            return new GoalStep(440, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 441: {
            // observerFlee_1Step1
            return new WaitStep(441, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 442: {
            // observerFlee_1Step2
            return new PrimitiveStep(442, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Follow(), null, "follow");
         }
         case 443: {
            // observerFlee_1Step3
            return new GoalStep(443, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 444: {
            // revealCloakedUnits_1Step1
            return new WaitStep(444, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 445: {
            // revealCloakedUnits_1Step2
            return new MentalStep(445, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 446: {
            // revealCloakedUnits_1Step3
            return new PrimitiveStep(446, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickTile(), null, "rightClickTile");
         }
         case 447: {
            // revealCloakedUnits_1Step4
            return new GoalStep(447, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 448: {
            // revealBurrowedUnits_1Step1
            return new WaitStep(448, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 449: {
            // revealBurrowedUnits_1Step2
            return new MentalStep(449, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 450: {
            // revealBurrowedUnits_1Step3
            return new PrimitiveStep(450, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickTile(), null, "rightClickTile");
         }
         case 451: {
            // revealBurrowedUnits_1Step4
            return new GoalStep(451, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 452: {
            // groundDefendBase_1Step1
            return new WaitStep(452, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 453: {
            // groundDefendBase_1Step2
            return new PrimitiveStep(453, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 454: {
            // groundDefendBase_1Step3
            return new GoalStep(454, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 455: {
            // airDefendBase_1Step1
            return new WaitStep(455, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 456: {
            // airDefendBase_1Step2
            return new PrimitiveStep(456, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 457: {
            // airDefendBase_1Step3
            return new GoalStep(457, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 458: {
            // flee_1Step1
            return new WaitStep(458, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 459: {
            // flee_1Step2
            return new MentalStep(459, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 460: {
            // flee_1Step3
            return new PrimitiveStep(460, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickUnit(), null, "rightClickUnit");
         }
         case 461: {
            // flee_1Step4
            return new GoalStep(461, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "flee(DragoonWME, int, int)", null, (short)1);
         }
         case 462: {
            // flee_1Step5
            return new GoalStep(462, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 463: {
            // fleeDamage_1Step1
            return new WaitStep(463, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 464: {
            // fleeDamage_1Step2
            return new MentalStep(464, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 465: {
            // fleeDamage_1Step3
            return new PrimitiveStep(465, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickUnit(), null, "rightClickUnit");
         }
         case 466: {
            // fleeDamage_1Step4
            return new GoalStep(466, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "flee(DragoonWME, int, int)", null, (short)1);
         }
         case 467: {
            // fleeDamage_1Step5
            return new GoalStep(467, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 468: {
            // flee_2Step1
            return new GoalStep(468, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 469: {
            // flee_2Step2
            return new MentalStep(469, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 470: {
            // flee_2Step3
            return new GoalStep(470, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "reattack(int)", null, (short)0);
         }
         case 471: {
            // reattack_1Step1
            return new PrimitiveStep(471, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 472: {
            // reattack_2Step1
            return new PrimitiveStep(472, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 473: {
            // casterAssignSquad_1Step1
            return new WaitStep(473, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 474: {
            // casterAssignSquad_1Step2
            return new MentalStep(474, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 475: {
            // casterAssignSquad_1Step3
            return new GoalStep(475, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 476: {
            // archonAssignSquad_1Step1
            return new WaitStep(476, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 477: {
            // archonAssignSquad_1Step2
            return new MentalStep(477, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 478: {
            // archonAssignSquad_1Step3
            return new PrimitiveStep(478, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new AttackMoveTile(), null, "attackMoveTile");
         }
         case 479: {
            // archonAssignSquad_1Step4
            return new GoalStep(479, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 480: {
            // attackerAssignSquad_1Step1
            return new WaitStep(480, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 481: {
            // attackerAssignSquad_1Step2
            return new MentalStep(481, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 482: {
            // attackerAssignSquad_1Step3
            return new GoalStep(482, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 483: {
            // casterFollowSquad_1Step1
            return new WaitStep(483, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 484: {
            // casterFollowSquad_1Step2
            return new PrimitiveStep(484, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Follow(), null, "follow");
         }
         case 485: {
            // casterFollowSquad_1Step3
            return new GoalStep(485, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 486: {
            // casterRetreat_1Step1
            return new WaitStep(486, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 487: {
            // casterRetreat_1Step2
            return new MentalStep(487, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 488: {
            // casterRetreat_1Step3
            return new PrimitiveStep(488, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new RightClickTile(), null, "rightClickTile");
         }
         case 489: {
            // casterRetreat_1Step4
            return new GoalStep(489, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 490: {
            // psiStorm_1Step1
            return new WaitStep(490, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 491: {
            // psiStorm_1Step2
            return new PrimitiveStep(491, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new UseTechTarget(), null, "useTechTarget");
         }
         case 492: {
            // psiStorm_1Step3
            return new GoalStep(492, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 493: {
            // mergeArchon_1Step1
            return new WaitStep(493, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 494: {
            // mergeArchon_1Step2
            return new MentalStep(494, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 495: {
            // mergeArchon_1Step3
            return new PrimitiveStep(495, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new UseTechTarget(), null, "useTechTarget");
         }
         case 496: {
            // mergeArchon_1Step4
            return new GoalStep(496, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 497: {
            // mergeArchon_1Step5
            return new GoalStep(497, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "clearMergedFlag(HighTemplarWME, HighTemplarWME)", null, (short)1);
         }
         case 498: {
            // clearMergedFlag_1Step1
            return new GoalStep(498, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 499: {
            // clearMergedFlag_1Step2
            return new MentalStep(499, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 500: {
            // trainInterceptors_1Step1
            return new WaitStep(500, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, EISBot.__$successTestSensorFactory0_rfield, null);
         }
         case 501: {
            // trainInterceptors_1Step2
            return new PrimitiveStep(501, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, new Train(), null, "train");
         }
         case 502: {
            // trainInterceptors_1Step3
            return new GoalStep(502, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "WaitFrames(int)", null, (short)0);
         }
         case 503: {
            // WaitFrames_1Step1
            return new MentalStep(503, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 504: {
            // WaitFrames_1Step2
            return new WaitStep(504, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 505: {
            // keyPressListener_1Step1
            return new GoalStep(505, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "processKeypresses()", null, (short)0);
         }
         case 506: {
            // processKeypresses_1Step1
            return new WaitStep(506, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, EISBot.__$successTest0_rfield, null, null);
         }
         case 507: {
            // processKeypresses_1Step2
            return new GoalStep(507, __$behaviorParent, false, false, false, true, false, false, (short)-32768, (short)0, false, null, EISBot.__$argumentExecute0_rfield, null, null, null, "keyPress(int)", null, (short)0);
         }
         case 508: {
            // processKeypresses_1Step3
            return new MentalStep(508, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, EISBot.__$mentalExecute0_rfield, null, null, null);
         }
         case 509: {
            // keyPress_1Step1
            return new GoalStep(509, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "focusMinerals()", null, (short)1);
         }
         case 510: {
            // keyPress_2Step1
            return new GoalStep(510, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "focusGas()", null, (short)1);
         }
         case 511: {
            // EISBot_RootCollectionBehaviorStep1
            return new GoalStep(511, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startup()", null, (short)0);
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
