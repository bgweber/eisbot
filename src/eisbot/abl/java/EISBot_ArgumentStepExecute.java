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
public class EISBot_ArgumentStepExecute implements eisbot.abl.StarCraftConstants
{
   static public Object[] argumentExecute0(int __$stepID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity) {
      switch (__$stepID) {
         case 3: {
            // startup_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(120);
            return args;
         }
         case 27: {
            // forceExpansion_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 29: {
            // spendExcess_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 30: {
            // spendExcess_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 32: {
            // spendExcess_2Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 33: {
            // spendExcess_2Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 34: {
            // spendExcess_3Step1
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(13);
            return args;
         }
         case 35: {
            // spendExcess_3Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(5);
            return args;
         }
         case 36: {
            // spendExcess_3Step3
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(15);
            return args;
         }
         case 39: {
            // deleteForgeUpgradeDelay_1Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(240);
            return args;
         }
         case 42: {
            // spendExcess_5Step1
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[1] = new Integer(67);
            return args;
         }
         case 43: {
            // spendExcess_6Step1
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[1] = new Integer(66);
            return args;
         }
         case 44: {
            // spendExcess_7Step1
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[1] = new Integer(65);
            return args;
         }
         case 48: {
            // researchPsiStorm_1Step4
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(19);
            return args;
         }
         case 49: {
            // researchPsiStorm_1Step5
            final Object[] args = new Object[1];
            args[0] = new Integer(6);
            return args;
         }
         case 50: {
            // researchPsiStorm_1Step6
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(19);
            return args;
         }
         case 51: {
            // researchPsiStorm_1Step7
            final Object[] args = new Object[1];
            args[0] = new Integer(6);
            return args;
         }
         case 52: {
            // researchPsiStorm_1Step8
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(19);
            return args;
         }
         case 54: {
            // researchPsiStorm_1Step10
            final Object[] args = new Object[1];
            args[0] = new Integer(7200);
            return args;
         }
         case 57: {
            // researchTemplarEnergy_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(40);
            return args;
         }
         case 59: {
            // researchLegSpeeed_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(34);
            return args;
         }
         case 61: {
            // researchDragoonRange_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(33);
            return args;
         }
         case 63: {
            // researchCarrierCapacity_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(43);
            return args;
         }
         case 65: {
            // researchObserverRange_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(38);
            return args;
         }
         case 66: {
            // researchObserverRange_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(7200);
            return args;
         }
         case 69: {
            // researchObserverSpeed_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(39);
            return args;
         }
         case 74: {
            // forceBuildRobo_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 77: {
            // forceBuildObservatory_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 80: {
            // forceBuildObservers_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 83: {
            // pickScout_1Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(240);
            return args;
         }
         case 86: {
            // pickScout_1Step4
            final Object[] args = new Object[2];
            args[0] = ((ProbeWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 88: {
            // workerScout_1Step2
            final Object[] args = new Object[1];
            args[0] = new Boolean(((__ValueTypes.BooleanVar)__$behaviorFrame[4]).b);
            return args;
         }
         case 89: {
            // workerScout_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 90: {
            // workerScout_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 93: {
            // workerScout_2Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 94: {
            // workerScout_2Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 97: {
            // scoutFlee_1Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 98: {
            // scoutFlee_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(150);
            return args;
         }
         case 100: {
            // scoutFlee_1Step5
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[6]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[7]).i);
            return args;
         }
         case 101: {
            // scoutFlee_1Step6
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 107: {
            // preventSupplyLock_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 110: {
            // preventStalledSupply_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 116: {
            // getNextBuildStep_1Step4
            final Object[] args = new Object[1];
            args[0] = ((RequestWME)__$behaviorFrame[1]);
            return args;
         }
         case 126: {
            // processUnitRequests_1Step2
            final Object[] args = new Object[4];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 127: {
            // processUnitRequests_1Step3
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 128: {
            // processUnitRequests_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(6);
            return args;
         }
         case 144: {
            // processBuildingRequests_1Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 145: {
            // processBuildingRequests_1Step3
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 146: {
            // processBuildingRequests_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(12);
            return args;
         }
         case 154: {
            // processResearchRequests_1Step2
            final Object[] args = new Object[5];
            args[0] = new Boolean(((__ValueTypes.BooleanVar)__$behaviorFrame[3]).b);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[4] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            return args;
         }
         case 155: {
            // processResearchRequests_1Step3
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(-1);
            return args;
         }
         case 156: {
            // processResearchRequests_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(12);
            return args;
         }
         case 159: {
            // handleResearchRequest_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 161: {
            // handleResearchRequest_2Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[6]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 163: {
            // handleResearchRequest_3Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 165: {
            // handleResearchRequest_4Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[6]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 167: {
            // processArchonRequests_1Step2
            final Object[] args = new Object[1];
            args[0] = ((ArchonRequestWME)__$behaviorFrame[0]);
            return args;
         }
         case 168: {
            // processArchonRequests_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(6);
            return args;
         }
         case 171: {
            // handleArchonRequest_1Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[8]).i);
            args[1] = new Integer(23);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[6]).i);
            return args;
         }
         case 172: {
            // handleArchonRequest_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(6);
            return args;
         }
         case 175: {
            // handleArchonRequest_2Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[1] = new Integer(23);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 176: {
            // handleArchonRequest_2Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(6);
            return args;
         }
         case 177: {
            // handleArchonRequest_3Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(6);
            return args;
         }
         case 183: {
            // limitQueueSize_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 184: {
            // limitQueueSize_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 186: {
            // cancelTrain_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 187: {
            // cancelTrain_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 189: {
            // produceObservers_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(84);
            return args;
         }
         case 190: {
            // produceObservers_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(120);
            return args;
         }
         case 193: {
            // produceUnits_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 194: {
            // produceUnits_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 197: {
            // produceUnitsNow_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 198: {
            // produceUnitsNow_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 200: {
            // trainUnit_2Step1
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 219: {
            // detectIdleGasWorkers_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 222: {
            // detectIdleConstructors_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 225: {
            // clearMineralBlocks_1Step3
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 226: {
            // clearMineralBlocks_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(750);
            return args;
         }
         case 231: {
            // forceAssimilator_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 233: {
            // pumpProbesBuildOrder_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[1] = new Integer(64);
            return args;
         }
         case 234: {
            // pumpProbesBuildOrder_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 236: {
            // pumpProbesExcess_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[1] = new Integer(64);
            return args;
         }
         case 237: {
            // pumpProbesExcess_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 239: {
            // pumpProbesCBR_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[1] = new Integer(64);
            return args;
         }
         case 240: {
            // pumpProbesCBR_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 243: {
            // additionalAssimilators_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 246: {
            // pullOffGas_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 249: {
            // pullOffGasDefense_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(500);
            return args;
         }
         case 253: {
            // putOnGas_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 256: {
            // manageWorkerHarass_1Step3
            final Object[] args = new Object[5];
            args[0] = ((ProbeWME)__$behaviorFrame[7]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            args[4] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[6]).i);
            return args;
         }
         case 257: {
            // manageWorkerHarass_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 258: {
            // manageWorkerHarass_1Step5
            final Object[] args = new Object[5];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            args[4] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[8]).i);
            return args;
         }
         case 259: {
            // manageWorkerHarass_1Step6
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 261: {
            // manageBaseHarass_1Step2
            final Object[] args = new Object[5];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[4] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            return args;
         }
         case 262: {
            // manageBaseHarass_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(120);
            return args;
         }
         case 264: {
            // getFriendHelp_1Step2
            final Object[] args = new Object[5];
            args[0] = ((ProbeWME)__$behaviorFrame[5]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[9]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[4] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[10]).i);
            return args;
         }
         case 265: {
            // getFriendHelp_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 266: {
            // getFriendHelp_1Step4
            final Object[] args = new Object[5];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[4] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 267: {
            // workerDefend_1Step1
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 268: {
            // workerDefend_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(200);
            return args;
         }
         case 269: {
            // workerDefend_1Step3
            final Object[] args = new Object[3];
            args[0] = ((ProbeWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 270: {
            // workerDefend_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 271: {
            // returnToWork_1Step1
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 272: {
            // returnToWork_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 274: {
            // returnToWork_2Step1
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 275: {
            // returnToWork_2Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 278: {
            // probeTransfer_1Step2
            final Object[] args = new Object[5];
            args[0] = ((NexusWME)__$behaviorFrame[3]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[4] = new Integer(5);
            return args;
         }
         case 279: {
            // probeTransfer_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(100);
            return args;
         }
         case 281: {
            // transferWorkers_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[8]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[9]).i);
            return args;
         }
         case 282: {
            // transferWorkers_1Step3
            final Object[] args = new Object[5];
            args[0] = ((NexusWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[4] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 284: {
            // mineMinerals_1Step2
            final Object[] args = new Object[4];
            args[0] = ((ProbeWME)__$behaviorFrame[3]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 287: {
            // selectMinerals_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[9]).i);
            return args;
         }
         case 289: {
            // selectMinerals_2Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[9]).i);
            return args;
         }
         case 291: {
            // gasTransfer_1Step2
            final Object[] args = new Object[6];
            args[0] = ((AssimilatorWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            args[4] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[5] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 292: {
            // gasTransfer_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 294: {
            // modifyGasCollectors_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[7]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 296: {
            // modifyGasCollectors_3Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 306: {
            // waitForConstructionRequest_1Step3
            final Object[] args = new Object[2];
            args[0] = ((ConstructionWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 310: {
            // processConstructionWME_3Step2
            final Object[] args = new Object[1];
            args[0] = ((ConstructionWME)__$behaviorFrame[0]);
            return args;
         }
         case 311: {
            // processConstructionWME_4Step1
            final Object[] args = new Object[1];
            args[0] = ((ConstructionWME)__$behaviorFrame[0]);
            return args;
         }
         case 314: {
            // processConstructionWME_4Step4
            final Object[] args = new Object[2];
            args[0] = ((ConstructionWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 315: {
            // processConstructionWME_5Step1
            final Object[] args = new Object[1];
            args[0] = ((ConstructionWME)__$behaviorFrame[0]);
            return args;
         }
         case 316: {
            // selectConstructor_1Step1
            final Object[] args = new Object[4];
            args[0] = ((ConstructionWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = ((ProbeWME)__$behaviorFrame[2]);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 317: {
            // selectConstructor_2Step1
            final Object[] args = new Object[4];
            args[0] = ((ConstructionWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = ((ProbeWME)__$behaviorFrame[2]);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 319: {
            // assignConstructionWorker_1Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[1] = ((ProbeWME)__$behaviorFrame[2]);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 320: {
            // assignConstructionWorker_1Step3
            final Object[] args = new Object[1];
            args[0] = ((ConstructionWME)__$behaviorFrame[0]);
            return args;
         }
         case 322: {
            // assignConstructionWorker_1Step5
            final Object[] args = new Object[2];
            args[0] = ((ProbeWME)__$behaviorFrame[2]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 323: {
            // monitorTrappedWorkers_1Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(360);
            return args;
         }
         case 325: {
            // monitorTrappedWorkers_1Step3
            final Object[] args = new Object[5];
            args[0] = ((ProbeWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[4] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 326: {
            // monitorTrapped_1Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(360);
            return args;
         }
         case 330: {
            // selectBuildSite_2Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 331: {
            // selectBuildSite_2Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(6);
            return args;
         }
         case 332: {
            // selectBuildSite_2Step4
            final Object[] args = new Object[4];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 333: {
            // selectBuildSite_2Step5
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 334: {
            // buildTile_1Step1
            final Object[] args = new Object[4];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[3] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 368: {
            // defendBaseGround_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 369: {
            // defendBaseGround_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(4);
            return args;
         }
         case 371: {
            // airSquadAttack_1Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 372: {
            // airSquadAttack_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 374: {
            // corsairSquadAttack_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            return args;
         }
         case 375: {
            // corsairSquadAttack_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 378: {
            // defendBaseAir_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 379: {
            // defendBaseAir_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 382: {
            // defendBaseCaster_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 383: {
            // defendBaseCaster_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 386: {
            // createSquad_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(100);
            return args;
         }
         case 387: {
            // createSquad_1Step4
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 389: {
            // createSquad_1Step6
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 390: {
            // manageSquadGrouping_1Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 391: {
            // regroupSquad_1Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(120);
            return args;
         }
         case 396: {
            // regroupSquad_1Step6
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 397: {
            // regroupSquad_2Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 400: {
            // squadBreakup_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 402: {
            // squadSelectTarget_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 403: {
            // squadSelectTarget_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 404: {
            // squadSelectTarget_2Step1
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            return args;
         }
         case 405: {
            // squadSelectTarget_3Step1
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 406: {
            // squadSelectTarget_4Step1
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 407: {
            // squadSelectTarget_5Step1
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 408: {
            // squadSelectTarget_6Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 413: {
            // squadRetreat_1Step3
            final Object[] args = new Object[2];
            args[0] = ((SquadWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 414: {
            // squadRetreat_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 417: {
            // squadMerge_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(100);
            return args;
         }
         case 418: {
            // squadMerge_1Step4
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 420: {
            // squadMerge_1Step6
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            return args;
         }
         case 421: {
            // squadMerge_1Step7
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 423: {
            // manageRetreat_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 424: {
            // manageRetreat_1Step3
            final Object[] args = new Object[2];
            args[0] = ((SquadWME)__$behaviorFrame[0]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 429: {
            // rallyUnits_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 430: {
            // rallyUnits_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 433: {
            // unblockChokes_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 434: {
            // unblockChokes_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 437: {
            // scatterAttack_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 439: {
            // observerSupport_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 440: {
            // observerSupport_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(12);
            return args;
         }
         case 442: {
            // observerFlee_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 443: {
            // observerFlee_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 446: {
            // revealCloakedUnits_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 447: {
            // revealCloakedUnits_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 450: {
            // revealBurrowedUnits_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 451: {
            // revealBurrowedUnits_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 453: {
            // groundDefendBase_1Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 454: {
            // groundDefendBase_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 456: {
            // airDefendBase_1Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 457: {
            // airDefendBase_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(2);
            return args;
         }
         case 460: {
            // flee_1Step3
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 461: {
            // flee_1Step4
            final Object[] args = new Object[3];
            args[0] = ((DragoonWME)__$behaviorFrame[3]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(24);
            return args;
         }
         case 462: {
            // flee_1Step5
            final Object[] args = new Object[1];
            args[0] = new Integer(1);
            return args;
         }
         case 465: {
            // fleeDamage_1Step3
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 466: {
            // fleeDamage_1Step4
            final Object[] args = new Object[3];
            args[0] = ((DragoonWME)__$behaviorFrame[3]);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[2] = new Integer(24);
            return args;
         }
         case 467: {
            // fleeDamage_1Step5
            final Object[] args = new Object[1];
            args[0] = new Integer(1);
            return args;
         }
         case 468: {
            // flee_2Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 470: {
            // flee_2Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 471: {
            // reattack_1Step1
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 472: {
            // reattack_2Step1
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 475: {
            // casterAssignSquad_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(12);
            return args;
         }
         case 478: {
            // archonAssignSquad_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[6]).i);
            return args;
         }
         case 479: {
            // archonAssignSquad_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(12);
            return args;
         }
         case 482: {
            // attackerAssignSquad_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 484: {
            // casterFollowSquad_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[4]).i);
            return args;
         }
         case 485: {
            // casterFollowSquad_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(12);
            return args;
         }
         case 488: {
            // casterRetreat_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            args[1] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            return args;
         }
         case 489: {
            // casterRetreat_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(12);
            return args;
         }
         case 491: {
            // psiStorm_1Step2
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(19);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
         case 492: {
            // psiStorm_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(24);
            return args;
         }
         case 495: {
            // mergeArchon_1Step3
            final Object[] args = new Object[3];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            args[1] = new Integer(23);
            args[2] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            return args;
         }
         case 496: {
            // mergeArchon_1Step4
            final Object[] args = new Object[1];
            args[0] = new Integer(6);
            return args;
         }
         case 497: {
            // mergeArchon_1Step5
            final Object[] args = new Object[2];
            args[0] = ((HighTemplarWME)__$behaviorFrame[0]);
            args[1] = ((HighTemplarWME)__$behaviorFrame[1]);
            return args;
         }
         case 498: {
            // clearMergedFlag_1Step1
            final Object[] args = new Object[1];
            args[0] = new Integer(240);
            return args;
         }
         case 501: {
            // trainInterceptors_1Step2
            final Object[] args = new Object[2];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            args[1] = new Integer(73);
            return args;
         }
         case 502: {
            // trainInterceptors_1Step3
            final Object[] args = new Object[1];
            args[0] = new Integer(48);
            return args;
         }
         case 507: {
            // processKeypresses_1Step2
            final Object[] args = new Object[1];
            args[0] = new Integer(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            return args;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
