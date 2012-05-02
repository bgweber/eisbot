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

public class EISBot extends BehavingEntity implements eisbot.abl.StarCraftConstants {
   int earliestObsTiming = 7200;
   int maxProbes = 70;
   int maxSupplyReq = 40;
   int workersPerNexus = 18;
   boolean waitForPrereqs = true;
   int nextNexusRequest = 0;
   boolean offsetPylons = false;
   int pylonPurpose = 0;
   int squadCounter = 0;
   int minSquadSize = 3;
   int maxSquadSize = 8;
   private final static Object[] __$tempObjArray = new Object[1];
   private final static Class[] __$sensorFactoryArgArray = new Class[1];
   private final static Class[] __$behFactoryArgArray = new Class[5];
   private final static Class[] __$preconditionArgArray = new Class[4];
   private final static Class[] __$continuousConditionArgArray = new Class[3];
   private final static Class[] __$stepFactoryArgArray = new Class[3];
   private final static Class[] __$argumentStepExecuteArgArray = new Class[3];
   private final static Class[] __$mentalStepExecuteArgArray = new Class[4];
   private final static Class[] __$reinforcementSignalArgArray = new Class[3];
   private final static Class[] __$rlPolicyArgArray = new Class[6];
   private final static Class[] __$stateWMEArgArray = new Class[3];
   private final static Class[] __$successConditionArgArray = new Class[3];
   private final static Class __$EISBot_BehaviorFactories_rfield;
   final static Method __$behaviorFactory0_rfield;
   private final static Class __$EISBot_Preconditions_rfield;
   final static Method __$precondition0_rfield;
   private final static Class __$EISBot_PreconditionSensorFactories_rfield;
   final static Method __$preconditionSensorFactory0_rfield;
   private final static Class __$EISBot_ContextConditions_rfield;
   final static Method __$contextCondition0_rfield;
   private final static Class __$EISBot_ContextConditionSensorFactories_rfield;
   final static Method __$contextConditionSensorFactory0_rfield;
   private final static Class __$EISBot_StepFactories_rfield;
   final static Method __$stepFactory0_rfield;
   private final static Class __$EISBot_ArgumentStepExecute_rfield;
   final static Method __$argumentExecute0_rfield;
   private final static Class __$EISBot_MentalStepExecute_rfield;
   final static Method __$mentalExecute0_rfield;
   private final static Class __$EISBot_SuccessTests_rfield;
   final static Method __$successTest0_rfield;
   private final static Class __$EISBot_SuccessTestSensorFactories_rfield;
   final static Method __$successTestSensorFactory0_rfield;
   private final static Class __$EISBot_ReinforcementSignals_rfield;
   final static Method __$reinforcementSignal0_rfield;
   private final static Class __$EISBot_ReinforcementSignalSensorFactories_rfield;
   final static Method __$reinforcementSignalSensorFactory0_rfield;
   private final static Class __$EISBot_RLPolicy_rfield;
   final static Method __$rlPolicy0_rfield;
   private final static Class __$EISBot_StateWMEs_rfield;
   final static Method __$stateWME0_rfield;
   private final static Class __$EISBot_StateWMESensorFactories_rfield;
   final static Method __$stateWMESensorFactory0_rfield;
   private final static Class __$EISBot_SuccessConditions_rfield;
   final static Method __$successCondition0_rfield;
   private final static Class __$EISBot_SuccessConditionSensorFactories_rfield;
   final static Method __$successConditionSensorFactory0_rfield;

   static {
      try {
         __$sensorFactoryArgArray[0] = Integer.TYPE;
         __$behFactoryArgArray[0] = Integer.TYPE;
         __$behFactoryArgArray[1] = __$tempObjArray.getClass();
         __$behFactoryArgArray[2] = Class.forName("java.util.Hashtable");
         __$behFactoryArgArray[3] = Class.forName("abl.runtime.GoalStep");
         __$behFactoryArgArray[4] = Class.forName("java.lang.String");
         __$preconditionArgArray[0] = Integer.TYPE;
         __$preconditionArgArray[1] = __$tempObjArray.getClass();
         __$preconditionArgArray[2] = Class.forName("java.util.Hashtable");
         __$preconditionArgArray[3] = Class.forName("abl.runtime.BehavingEntity");
         __$continuousConditionArgArray[0] = Integer.TYPE;
         __$continuousConditionArgArray[1] = __$tempObjArray.getClass();
         __$continuousConditionArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$stepFactoryArgArray[0] = Integer.TYPE;
         __$stepFactoryArgArray[1] = Class.forName("abl.runtime.Behavior");
         __$stepFactoryArgArray[2] = __$tempObjArray.getClass();
         __$argumentStepExecuteArgArray[0] = Integer.TYPE;
         __$argumentStepExecuteArgArray[1] = __$tempObjArray.getClass();
         __$argumentStepExecuteArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$mentalStepExecuteArgArray[0] = Integer.TYPE;
         __$mentalStepExecuteArgArray[1] = __$tempObjArray.getClass();
         __$mentalStepExecuteArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$mentalStepExecuteArgArray[3] = Class.forName("abl.runtime.MentalStep");
         __$reinforcementSignalArgArray[0] = Integer.TYPE;
         __$reinforcementSignalArgArray[1] = __$tempObjArray.getClass();
         __$reinforcementSignalArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$rlPolicyArgArray[0] = Integer.TYPE;
         __$rlPolicyArgArray[1] = Class.forName("java.lang.Object");
         __$rlPolicyArgArray[2] = Integer.TYPE;
         __$rlPolicyArgArray[3] = Class.forName("java.lang.Object");
         __$rlPolicyArgArray[4] = Double.TYPE;
         __$rlPolicyArgArray[5] = Boolean.TYPE;
         __$stateWMEArgArray[0] = Integer.TYPE;
         __$stateWMEArgArray[1] = __$tempObjArray.getClass();
         __$stateWMEArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
         __$successConditionArgArray[0] = Integer.TYPE;
         __$successConditionArgArray[1] = __$tempObjArray.getClass();
         __$successConditionArgArray[2] = Class.forName("abl.runtime.BehavingEntity");
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_BehaviorFactories_rfield = Class.forName("eisbot.abl.java.EISBot_BehaviorFactories");
         __$behaviorFactory0_rfield = __$EISBot_BehaviorFactories_rfield.getDeclaredMethod("behaviorFactory0", __$behFactoryArgArray);
         __$behaviorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_Preconditions_rfield = Class.forName("eisbot.abl.java.EISBot_Preconditions");
         __$precondition0_rfield = __$EISBot_Preconditions_rfield.getDeclaredMethod("precondition0", __$preconditionArgArray);
         __$precondition0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_PreconditionSensorFactories_rfield = Class.forName("eisbot.abl.java.EISBot_PreconditionSensorFactories");
         __$preconditionSensorFactory0_rfield = __$EISBot_PreconditionSensorFactories_rfield.getDeclaredMethod("preconditionSensorFactory0", __$sensorFactoryArgArray);
         __$preconditionSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_ContextConditions_rfield = Class.forName("eisbot.abl.java.EISBot_ContextConditions");
         __$contextCondition0_rfield = __$EISBot_ContextConditions_rfield.getDeclaredMethod("contextCondition0", __$continuousConditionArgArray);
         __$contextCondition0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_ContextConditionSensorFactories_rfield = Class.forName("eisbot.abl.java.EISBot_ContextConditionSensorFactories");
         __$contextConditionSensorFactory0_rfield = __$EISBot_ContextConditionSensorFactories_rfield.getDeclaredMethod("contextConditionSensorFactory0", __$sensorFactoryArgArray);
         __$contextConditionSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_StepFactories_rfield = Class.forName("eisbot.abl.java.EISBot_StepFactories");
         __$stepFactory0_rfield = __$EISBot_StepFactories_rfield.getDeclaredMethod("stepFactory0", __$stepFactoryArgArray);
         __$stepFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_ArgumentStepExecute_rfield = Class.forName("eisbot.abl.java.EISBot_ArgumentStepExecute");
         __$argumentExecute0_rfield = __$EISBot_ArgumentStepExecute_rfield.getDeclaredMethod("argumentExecute0", __$argumentStepExecuteArgArray);
         __$argumentExecute0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_MentalStepExecute_rfield = Class.forName("eisbot.abl.java.EISBot_MentalStepExecute");
         __$mentalExecute0_rfield = __$EISBot_MentalStepExecute_rfield.getDeclaredMethod("mentalExecute0", __$mentalStepExecuteArgArray);
         __$mentalExecute0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_SuccessTests_rfield = Class.forName("eisbot.abl.java.EISBot_SuccessTests");
         __$successTest0_rfield = __$EISBot_SuccessTests_rfield.getDeclaredMethod("successTest0", __$continuousConditionArgArray);
         __$successTest0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_SuccessTestSensorFactories_rfield = Class.forName("eisbot.abl.java.EISBot_SuccessTestSensorFactories");
         __$successTestSensorFactory0_rfield = __$EISBot_SuccessTestSensorFactories_rfield.getDeclaredMethod("successTestSensorFactory0", __$sensorFactoryArgArray);
         __$successTestSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_ReinforcementSignals_rfield = Class.forName("eisbot.abl.java.EISBot_ReinforcementSignals");
         __$reinforcementSignal0_rfield = __$EISBot_ReinforcementSignals_rfield.getDeclaredMethod("reinforcementSignal0", __$reinforcementSignalArgArray);
         __$reinforcementSignal0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_ReinforcementSignalSensorFactories_rfield = Class.forName("eisbot.abl.java.EISBot_ReinforcementSignalSensorFactories");
         __$reinforcementSignalSensorFactory0_rfield = __$EISBot_ReinforcementSignalSensorFactories_rfield.getDeclaredMethod("reinforcementSignalSensorFactory0", __$sensorFactoryArgArray);
         __$reinforcementSignalSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_RLPolicy_rfield = Class.forName("eisbot.abl.java.EISBot_RLPolicy");
         __$rlPolicy0_rfield = __$EISBot_RLPolicy_rfield.getDeclaredMethod("rlPolicy0", __$rlPolicyArgArray);
         __$rlPolicy0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_StateWMEs_rfield = Class.forName("eisbot.abl.java.EISBot_StateWMEs");
         __$stateWME0_rfield = __$EISBot_StateWMEs_rfield.getDeclaredMethod("stateWME0", __$stateWMEArgArray);
         __$stateWME0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_StateWMESensorFactories_rfield = Class.forName("eisbot.abl.java.EISBot_StateWMESensorFactories");
         __$stateWMESensorFactory0_rfield = __$EISBot_StateWMESensorFactories_rfield.getDeclaredMethod("stateWMESensorFactory0", __$sensorFactoryArgArray);
         __$stateWMESensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_SuccessConditions_rfield = Class.forName("eisbot.abl.java.EISBot_SuccessConditions");
         __$successCondition0_rfield = __$EISBot_SuccessConditions_rfield.getDeclaredMethod("successCondition0", __$successConditionArgArray);
         __$successCondition0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }

   static {
      try {
         __$EISBot_SuccessConditionSensorFactories_rfield = Class.forName("eisbot.abl.java.EISBot_SuccessConditionSensorFactories");
         __$successConditionSensorFactory0_rfield = __$EISBot_SuccessConditionSensorFactories_rfield.getDeclaredMethod("successConditionSensorFactory0", __$sensorFactoryArgArray);
         __$successConditionSensorFactory0_rfield.setAccessible(true);
      
      } catch (Exception e) { throw new AblRuntimeError("Error in static initializer", e); }
   }


   private static void registerBehaviors_0(BehaviorLibrary behaviorLibrary) {
      behaviorLibrary.registerBehavior(new __BehaviorDesc(0, __$behaviorFactory0_rfield, null, null, "startup()", new String[] {"startup()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(1, __$behaviorFactory0_rfield, null, null, "startupAgent()", new String[] {"startupAgent()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(2, __$behaviorFactory0_rfield, null, null, "startStrategyManager()", new String[] {"startStrategyManager()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(3, __$behaviorFactory0_rfield, null, null, "forceExpansion()", new String[] {"forceExpansion()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(4, __$behaviorFactory0_rfield, null, null, "spendExcess()", new String[] {"spendExcess()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(5, __$behaviorFactory0_rfield, null, null, "spendExcess()", new String[] {"spendExcess()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(6, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "spendExcess(int, int)", new String[] {"spendExcess(int, int)"}, null, (short)6));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(7, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "deleteForgeUpgradeDelay()", new String[] {"deleteForgeUpgradeDelay()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(8, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "spendExcess(int, int)", new String[] {"spendExcess(int, int)"}, null, (short)5));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(9, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "spendExcess(int, int)", new String[] {"spendExcess(int, int)"}, null, (short)4));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(10, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "spendExcess(int, int)", new String[] {"spendExcess(int, int)"}, null, (short)3));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(11, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "spendExcess(int, int)", new String[] {"spendExcess(int, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(12, __$behaviorFactory0_rfield, null, null, "researchPsiStorm()", new String[] {"researchPsiStorm()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(13, __$behaviorFactory0_rfield, null, null, "researchTemplarEnergy()", new String[] {"researchTemplarEnergy()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(14, __$behaviorFactory0_rfield, null, null, "researchLegSpeeed()", new String[] {"researchLegSpeeed()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(15, __$behaviorFactory0_rfield, null, null, "researchDragoonRange()", new String[] {"researchDragoonRange()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(16, __$behaviorFactory0_rfield, null, null, "researchCarrierCapacity()", new String[] {"researchCarrierCapacity()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(17, __$behaviorFactory0_rfield, null, null, "researchObserverRange()", new String[] {"researchObserverRange()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(18, __$behaviorFactory0_rfield, null, null, "researchObserverSpeed()", new String[] {"researchObserverSpeed()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(19, __$behaviorFactory0_rfield, null, null, "forceObservers()", new String[] {"forceObservers()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(20, __$behaviorFactory0_rfield, null, null, "forceBuildRobo()", new String[] {"forceBuildRobo()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(21, __$behaviorFactory0_rfield, null, null, "forceBuildObservatory()", new String[] {"forceBuildObservatory()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(22, __$behaviorFactory0_rfield, null, null, "forceBuildObservers()", new String[] {"forceBuildObservers()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(23, __$behaviorFactory0_rfield, null, null, "startScoutingManager()", new String[] {"startScoutingManager()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(24, __$behaviorFactory0_rfield, null, null, "pickScout()", new String[] {"pickScout()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(25, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "workerScout(ProbeWME, int)", new String[] {"workerScout(ProbeWME, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(26, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "workerScout(ProbeWME, int)", new String[] {"workerScout(ProbeWME, int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(27, __$behaviorFactory0_rfield, null, null, "scoutFlee()", new String[] {"scoutFlee()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(28, __$behaviorFactory0_rfield, null, null, "startSupplyManager()", new String[] {"startSupplyManager()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(29, __$behaviorFactory0_rfield, null, null, "preventSupplyLock()", new String[] {"preventSupplyLock()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(30, __$behaviorFactory0_rfield, null, null, "preventStalledSupply()", new String[] {"preventStalledSupply()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(31, __$behaviorFactory0_rfield, null, null, "startBuildOrderManager()", new String[] {"startBuildOrderManager()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(32, __$behaviorFactory0_rfield, null, null, "getNextBuildStep()", new String[] {"getNextBuildStep()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(33, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "processBuildStep(RequestWME)", new String[] {"processBuildStep(RequestWME)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(34, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "processBuildStep(RequestWME)", new String[] {"processBuildStep(RequestWME)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(35, __$behaviorFactory0_rfield, null, null, "startCBRManager()", new String[] {"startCBRManager()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(36, __$behaviorFactory0_rfield, null, null, "processUnitRequests()", new String[] {"processUnitRequests()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(37, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "handlePrereqs(int, int)", new String[] {"handlePrereqs(int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(38, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "handleUnitRequest(int, int, int, int)", new String[] {"handleUnitRequest(int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(39, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "handleUnitRequest(int, int, int, int)", new String[] {"handleUnitRequest(int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(40, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "handleUnitRequest(int, int, int, int)", new String[] {"handleUnitRequest(int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(41, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "handleUnitRequest(int, int, int, int)", new String[] {"handleUnitRequest(int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(42, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "handleUnitRequest(int, int, int, int)", new String[] {"handleUnitRequest(int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(43, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "handleUnitRequest(int, int, int, int)", new String[] {"handleUnitRequest(int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(44, __$behaviorFactory0_rfield, null, null, "processBuildingRequests()", new String[] {"processBuildingRequests()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(45, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "handleBuildingRequest(int, int, int)", new String[] {"handleBuildingRequest(int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(46, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "handleBuildingRequest(int, int, int)", new String[] {"handleBuildingRequest(int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(47, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "handleBuildingRequest(int, int, int)", new String[] {"handleBuildingRequest(int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(48, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "handleBuildingRequest(int, int, int)", new String[] {"handleBuildingRequest(int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(49, __$behaviorFactory0_rfield, null, null, "processResearchRequests()", new String[] {"processResearchRequests()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(50, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "handleResearchRequest(boolean, int, int, int, int)", new String[] {"handleResearchRequest(boolean, int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(51, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "handleResearchRequest(boolean, int, int, int, int)", new String[] {"handleResearchRequest(boolean, int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(52, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "handleResearchRequest(boolean, int, int, int, int)", new String[] {"handleResearchRequest(boolean, int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(53, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "handleResearchRequest(boolean, int, int, int, int)", new String[] {"handleResearchRequest(boolean, int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(54, __$behaviorFactory0_rfield, null, null, "processArchonRequests()", new String[] {"processArchonRequests()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(55, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "handleArchonRequest(ArchonRequestWME)", new String[] {"handleArchonRequest(ArchonRequestWME)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(56, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "handleArchonRequest(ArchonRequestWME)", new String[] {"handleArchonRequest(ArchonRequestWME)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(57, __$behaviorFactory0_rfield, null, null, "handleArchonRequest(ArchonRequestWME)", new String[] {"handleArchonRequest(ArchonRequestWME)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(58, __$behaviorFactory0_rfield, null, null, "startProductionManager()", new String[] {"startProductionManager()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(59, __$behaviorFactory0_rfield, null, null, "limitQueueSize()", new String[] {"limitQueueSize()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(60, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "cancelTrain(int)", new String[] {"cancelTrain(int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(61, __$behaviorFactory0_rfield, null, null, "produceObservers()", new String[] {"produceObservers()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(62, __$behaviorFactory0_rfield, null, null, "produceUnits()", new String[] {"produceUnits()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(63, __$behaviorFactory0_rfield, null, null, "produceUnitsNow()", new String[] {"produceUnitsNow()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(64, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "trainUnit(int, int)", new String[] {"trainUnit(int, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(65, __$behaviorFactory0_rfield, null, null, "trainUnit(int, int)", new String[] {"trainUnit(int, int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(66, __$behaviorFactory0_rfield, null, null, "startWorkerManager()", new String[] {"startWorkerManager()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(67, __$behaviorFactory0_rfield, null, null, "detectIdleGasWorkers()", new String[] {"detectIdleGasWorkers()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(68, __$behaviorFactory0_rfield, null, null, "detectIdleConstructors()", new String[] {"detectIdleConstructors()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(69, __$behaviorFactory0_rfield, null, null, "clearMineralBlocks()", new String[] {"clearMineralBlocks()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(70, __$behaviorFactory0_rfield, null, null, "forceAssimilator()", new String[] {"forceAssimilator()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(71, __$behaviorFactory0_rfield, null, null, "pumpProbesBuildOrder()", new String[] {"pumpProbesBuildOrder()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(72, __$behaviorFactory0_rfield, null, null, "pumpProbesExcess()", new String[] {"pumpProbesExcess()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(73, __$behaviorFactory0_rfield, null, null, "pumpProbesCBR()", new String[] {"pumpProbesCBR()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(74, __$behaviorFactory0_rfield, null, null, "additionalAssimilators()", new String[] {"additionalAssimilators()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(75, __$behaviorFactory0_rfield, null, null, "pullOffGas()", new String[] {"pullOffGas()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(76, __$behaviorFactory0_rfield, null, null, "pullOffGasDefense()", new String[] {"pullOffGasDefense()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(77, __$behaviorFactory0_rfield, null, null, "putOnGas()", new String[] {"putOnGas()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(78, __$behaviorFactory0_rfield, null, null, "manageWorkerHarass()", new String[] {"manageWorkerHarass()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(79, __$behaviorFactory0_rfield, null, null, "manageBaseHarass()", new String[] {"manageBaseHarass()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(80, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "getFriendHelp(int, int, int, int, int)", new String[] {"getFriendHelp(int, int, int, int, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(81, __$behaviorFactory0_rfield, null, null, "getFriendHelp(ProbeWME, int, int, int, int)", new String[] {"getFriendHelp(ProbeWME, int, int, int, int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(82, __$behaviorFactory0_rfield, null, null, "workerDefend(ProbeWME, int, int, int, int)", new String[] {"workerDefend(ProbeWME, int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(83, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "returnToWork(ProbeWME, int, int)", new String[] {"returnToWork(ProbeWME, int, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(84, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "returnToWork(ProbeWME, int, int)", new String[] {"returnToWork(ProbeWME, int, int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(85, __$behaviorFactory0_rfield, null, null, "probeTransfer()", new String[] {"probeTransfer()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(86, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "transferWorkers(NexusWME, int, int, int, int)", new String[] {"transferWorkers(NexusWME, int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(87, __$behaviorFactory0_rfield, null, null, "mineMinerals()", new String[] {"mineMinerals()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(88, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "selectMinerals(ProbeWME, int, int, int)", new String[] {"selectMinerals(ProbeWME, int, int, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(89, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "selectMinerals(ProbeWME, int, int, int)", new String[] {"selectMinerals(ProbeWME, int, int, int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(90, __$behaviorFactory0_rfield, null, null, "gasTransfer()", new String[] {"gasTransfer()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(91, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "modifyGasCollectors(AssimilatorWME, int, int, int, int, int)", new String[] {"modifyGasCollectors(AssimilatorWME, int, int, int, int, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(92, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "modifyGasCollectors(AssimilatorWME, int, int, int, int, int)", new String[] {"modifyGasCollectors(AssimilatorWME, int, int, int, int, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(93, __$behaviorFactory0_rfield, null, null, "modifyGasCollectors(AssimilatorWME, int, int, int, int, int)", new String[] {"modifyGasCollectors(AssimilatorWME, int, int, int, int, int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(94, __$behaviorFactory0_rfield, null, null, "checkMinedOut()", new String[] {"checkMinedOut()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(95, __$behaviorFactory0_rfield, null, null, "focusMinerals()", new String[] {"focusMinerals()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(96, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "forceMinerals()", new String[] {"forceMinerals()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(97, __$behaviorFactory0_rfield, null, null, "focusGas()", new String[] {"focusGas()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(98, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "forceGas()", new String[] {"forceGas()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(99, __$behaviorFactory0_rfield, null, null, "startConstructionManager()", new String[] {"startConstructionManager()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(100, __$behaviorFactory0_rfield, null, null, "waitForConstructionRequest()", new String[] {"waitForConstructionRequest()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(101, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "processConstructionWME(ConstructionWME, int)", new String[] {"processConstructionWME(ConstructionWME, int)"}, null, (short)5));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(102, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "delayNextNexus(ConstructionWME)", new String[] {"delayNextNexus(ConstructionWME)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(103, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "processConstructionWME(ConstructionWME, int)", new String[] {"processConstructionWME(ConstructionWME, int)"}, null, (short)5));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(104, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "processConstructionWME(ConstructionWME, int)", new String[] {"processConstructionWME(ConstructionWME, int)"}, null, (short)3));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(105, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "processConstructionWME(ConstructionWME, int)", new String[] {"processConstructionWME(ConstructionWME, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(106, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "processConstructionWME(ConstructionWME)", new String[] {"processConstructionWME(ConstructionWME)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(107, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "selectConstructor(ConstructionWME, int)", new String[] {"selectConstructor(ConstructionWME, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(108, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "selectConstructor(ConstructionWME, int)", new String[] {"selectConstructor(ConstructionWME, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(109, __$behaviorFactory0_rfield, null, null, "assignConstructionWorker(ConstructionWME, int, ProbeWME, int)", new String[] {"assignConstructionWorker(ConstructionWME, int, ProbeWME, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(110, __$behaviorFactory0_rfield, null, null, "monitorTrappedWorkers(ProbeWME, int)", new String[] {"monitorTrappedWorkers(ProbeWME, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(111, __$behaviorFactory0_rfield, null, null, "monitorTrapped(ProbeWME, int, int, int, int)", new String[] {"monitorTrapped(ProbeWME, int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(112, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "selectBuildSite(int, ProbeWME, int)", new String[] {"selectBuildSite(int, ProbeWME, int)"}, null, (short)3));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(113, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "selectBuildSite(int, ProbeWME, int)", new String[] {"selectBuildSite(int, ProbeWME, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(114, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "buildTile(int, int, int, int)", new String[] {"buildTile(int, int, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(115, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "selectBuildSite(int, PlayerUnitWME, int)", new String[] {"selectBuildSite(int, PlayerUnitWME, int)", "selectBuildSite(int, ProbeWME, int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(116, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "freeResources(ConstructionWME)", new String[] {"freeResources(ConstructionWME)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(117, __$behaviorFactory0_rfield, null, null, "startTacticsManager()", new String[] {"startTacticsManager()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(118, __$behaviorFactory0_rfield, null, null, "defendBaseGround()", new String[] {"defendBaseGround()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(119, __$behaviorFactory0_rfield, null, null, "airSquadAttack()", new String[] {"airSquadAttack()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(120, __$behaviorFactory0_rfield, null, null, "corsairSquadAttack()", new String[] {"corsairSquadAttack()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(121, __$behaviorFactory0_rfield, null, null, "defendBaseAir()", new String[] {"defendBaseAir()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(122, __$behaviorFactory0_rfield, null, null, "defendBaseCaster()", new String[] {"defendBaseCaster()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(123, __$behaviorFactory0_rfield, null, null, "createSquad()", new String[] {"createSquad()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(124, __$behaviorFactory0_rfield, null, null, "manageSquadGrouping(int)", new String[] {"manageSquadGrouping(int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(125, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "regroupSquad(int)", new String[] {"regroupSquad(int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(126, __$behaviorFactory0_rfield, null, null, "regroupSquad(int)", new String[] {"regroupSquad(int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(127, __$behaviorFactory0_rfield, null, null, "squadBreakup()", new String[] {"squadBreakup()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(128, __$behaviorFactory0_rfield, null, null, "squadSelectTarget()", new String[] {"squadSelectTarget()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(129, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "squadSelectTarget(int)", new String[] {"squadSelectTarget(int)"}, null, (short)5));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(130, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "squadSelectTarget(int)", new String[] {"squadSelectTarget(int)"}, null, (short)4));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(131, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "squadSelectTarget(int)", new String[] {"squadSelectTarget(int)"}, null, (short)3));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(132, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "squadSelectTarget(int)", new String[] {"squadSelectTarget(int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(133, __$behaviorFactory0_rfield, null, null, "squadSelectTarget(int)", new String[] {"squadSelectTarget(int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(134, __$behaviorFactory0_rfield, null, null, "deleteSquad()", new String[] {"deleteSquad()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(135, __$behaviorFactory0_rfield, null, null, "squadRetreat()", new String[] {"squadRetreat()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(136, __$behaviorFactory0_rfield, null, null, "squadMerge()", new String[] {"squadMerge()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(137, __$behaviorFactory0_rfield, null, null, "manageRetreat(SquadWME, int)", new String[] {"manageRetreat(SquadWME, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(138, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "stopRetreat(SquadWME, int)", new String[] {"stopRetreat(SquadWME, int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(139, __$behaviorFactory0_rfield, null, null, "stopRetreat(SquadWME, int)", new String[] {"stopRetreat(SquadWME, int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(140, __$behaviorFactory0_rfield, null, null, "rallyUnits()", new String[] {"rallyUnits()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(141, __$behaviorFactory0_rfield, null, null, "unblockChokes()", new String[] {"unblockChokes()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(142, __$behaviorFactory0_rfield, null, null, "scatterAttack()", new String[] {"scatterAttack()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(143, __$behaviorFactory0_rfield, null, null, "observerSupport()", new String[] {"observerSupport()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(144, __$behaviorFactory0_rfield, null, null, "observerFlee()", new String[] {"observerFlee()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(145, __$behaviorFactory0_rfield, null, null, "revealCloakedUnits()", new String[] {"revealCloakedUnits()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(146, __$behaviorFactory0_rfield, null, null, "revealBurrowedUnits()", new String[] {"revealBurrowedUnits()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(147, __$behaviorFactory0_rfield, null, null, "groundDefendBase()", new String[] {"groundDefendBase()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(148, __$behaviorFactory0_rfield, null, null, "airDefendBase()", new String[] {"airDefendBase()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(149, __$behaviorFactory0_rfield, null, null, "flee()", new String[] {"flee()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(150, __$behaviorFactory0_rfield, null, null, "fleeDamage()", new String[] {"fleeDamage()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(151, __$behaviorFactory0_rfield, null, null, "flee(PlayerUnitWME, int, int)", new String[] {"flee(PlayerUnitWME, int, int)", "flee(DragoonWME, int, int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(152, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "reattack(int)", new String[] {"reattack(int)"}, null, (short)2));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(153, __$behaviorFactory0_rfield, __$precondition0_rfield, __$preconditionSensorFactory0_rfield, "reattack(int)", new String[] {"reattack(int)"}, null, (short)1));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(154, __$behaviorFactory0_rfield, null, null, "casterAssignSquad()", new String[] {"casterAssignSquad()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(155, __$behaviorFactory0_rfield, null, null, "archonAssignSquad()", new String[] {"archonAssignSquad()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(156, __$behaviorFactory0_rfield, null, null, "attackerAssignSquad()", new String[] {"attackerAssignSquad()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(157, __$behaviorFactory0_rfield, null, null, "casterFollowSquad()", new String[] {"casterFollowSquad()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(158, __$behaviorFactory0_rfield, null, null, "casterRetreat()", new String[] {"casterRetreat()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(159, __$behaviorFactory0_rfield, null, null, "psiStorm()", new String[] {"psiStorm()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(160, __$behaviorFactory0_rfield, null, null, "mergeArchon()", new String[] {"mergeArchon()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(161, __$behaviorFactory0_rfield, null, null, "clearMergedFlag(HighTemplarWME, HighTemplarWME)", new String[] {"clearMergedFlag(HighTemplarWME, HighTemplarWME)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(162, __$behaviorFactory0_rfield, null, null, "trainInterceptors()", new String[] {"trainInterceptors()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(163, __$behaviorFactory0_rfield, null, null, "WaitFrames(int)", new String[] {"WaitFrames(int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(164, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "continueBehavior(boolean)", new String[] {"continueBehavior(boolean)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(165, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "continueBehavior(boolean)", new String[] {"continueBehavior(boolean)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(166, __$behaviorFactory0_rfield, null, null, "keyPressListener()", new String[] {"keyPressListener()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(167, __$behaviorFactory0_rfield, null, null, "processKeypresses()", new String[] {"processKeypresses()"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(168, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "keyPress(int)", new String[] {"keyPress(int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(169, __$behaviorFactory0_rfield, __$precondition0_rfield, null, "keyPress(int)", new String[] {"keyPress(int)"}, null, (short)0));
      behaviorLibrary.registerBehavior(new __BehaviorDesc(170, __$behaviorFactory0_rfield, null, null, "EISBot_RootCollectionBehavior()", new String[] {"EISBot_RootCollectionBehavior()"}, null, (short)0));
   }

   private static void registerBehaviors_1(BehaviorLibrary behaviorLibrary) {
   }

   public static void main(String[] args) {
      new EISBot().startBehaving();
   }

   public EISBot() {
      individualBehaviorLibrary = new BehaviorLibrary(342);
      jointBehaviorLibrary = new BehaviorLibrary(0);
      registerBehaviors_0(individualBehaviorLibrary);
      registerBehaviors_1(jointBehaviorLibrary);
      ABT = (CollectionBehavior)EISBot_BehaviorFactories.behaviorFactory0(170, null, null, null, "EISBot_RootCollectionBehavior()");
      startWMEReflection(ABT);
      ABT.initRootBehavior();
      registerEntity("EISBot", this);
   }

}
