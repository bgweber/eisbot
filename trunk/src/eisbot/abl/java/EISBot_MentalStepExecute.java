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
public class EISBot_MentalStepExecute implements eisbot.abl.StarCraftConstants
{
   static public void mentalExecute0(int __$stepID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity, MentalStep __$thisStep) {
      switch (__$stepID) {
         case 1: {
            // startup_1Step2
            Logger.print("ABL" , "Starting managers");
            UnitQueryWME oracle = new UnitQueryWME();
            BehavingEntity.getBehavingEntity().addWME(oracle);
            TimerWME timer = new TimerWME();
            BehavingEntity.getBehavingEntity().addWME(timer);
            break;
         }
         case 26: {
            // forceExpansion_1Step2
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Nexus));
            break;
         }
         case 37: {
            // spendExcess_3Step4
            BehavingEntity.getBehavingEntity().addWME(new ForgeUpgradeDelayWME());
            break;
         }
         case 40: {
            // deleteForgeUpgradeDelay_1Step2
            BehavingEntity.getBehavingEntity().deleteWME(((ForgeUpgradeDelayWME)__$behaviorFrame[0]));
            break;
         }
         case 41: {
            // spendExcess_4Step1
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Gateway));
            break;
         }
         case 46: {
            // researchPsiStorm_1Step2
            ((PlayerWME)__$behaviorFrame[1]).addResourceHold(200 , 200);
            break;
         }
         case 53: {
            // researchPsiStorm_1Step9
            ((PlayerWME)__$behaviorFrame[1]).removeResourceHold(200 , 200);
            break;
         }
         case 71: {
            // forceObservers_1Step2
            BehavingEntity.getBehavingEntity().addWME(new ForceObserversWME());
            break;
         }
         case 73: {
            // forceBuildRobo_1Step2
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Robotics_Facility));
            break;
         }
         case 76: {
            // forceBuildObservatory_1Step2
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Observatory));
            break;
         }
         case 79: {
            // forceBuildObservers_1Step2
            BehavingEntity.getBehavingEntity().addWME(new TrainUnitWME(Protoss_Observer));
            break;
         }
         case 85: {
            // pickScout_1Step3
            ((ProbeWME)__$behaviorFrame[0]).setTask(WORKER_SCOUT);
            ((ProbeWME)__$behaviorFrame[0]).setPreviousHealth();
            break;
         }
         case 87: {
            // workerScout_1Step1
            __$behaviorFrame[5] = ABLStarCraftBot.getGame().getParticleFilter().getRandomBuildingParticle();
            if(((ParticleWME)__$behaviorFrame[5]) != null) { ((__ValueTypes.IntVar)__$behaviorFrame[2]).i = ((ParticleWME)__$behaviorFrame[5]).getX() - 10 +(int)(Math.random() * 20); ((__ValueTypes.IntVar)__$behaviorFrame[3]).i = ((ParticleWME)__$behaviorFrame[5]).getY() - 10 +(int)(Math.random() * 20); } else { ((__ValueTypes.BooleanVar)__$behaviorFrame[4]).b = false; ((__ValueTypes.IntVar)__$behaviorFrame[2]).i = ((ProbeWME)__$behaviorFrame[0]).getX(); ((__ValueTypes.IntVar)__$behaviorFrame[3]).i = ((ProbeWME)__$behaviorFrame[0]).getY(); }
            break;
         }
         case 92: {
            // workerScout_2Step1
            if(((TimerWME)__$behaviorFrame[6]).getFrameCount() > 12000) { __$behaviorFrame[4] = ((MapWME)__$behaviorFrame[5]).getNextScoutLocation(); } else { __$behaviorFrame[4] = ((MapWME)__$behaviorFrame[5]).getNextStartLocation(); }
            ((__ValueTypes.IntVar)__$behaviorFrame[2]).i = ((Point)__$behaviorFrame[4]).x;
            ((__ValueTypes.IntVar)__$behaviorFrame[3]).i = ((Point)__$behaviorFrame[4]).y;
            Logger.print("ABL" , "scouting " + ((__ValueTypes.IntVar)__$behaviorFrame[2]).i + " " + ((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            break;
         }
         case 99: {
            // scoutFlee_1Step4
            ((ProbeWME)__$behaviorFrame[0]).setPreviousHealth();
            break;
         }
         case 102: {
            // startSupplyManager_1Step1
            Logger.print("SupplyManager" , "Starting supply manager");
            break;
         }
         case 106: {
            // preventSupplyLock_1Step2
            Logger.print("SupplyManager" , "Requesting to build a pylon: " + ((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Pylon));
            if(((__ValueTypes.IntVar)__$behaviorFrame[1]).i > 120) { BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Pylon)); }
            if(((__ValueTypes.IntVar)__$behaviorFrame[1]).i > 240) { BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Pylon)); }
            break;
         }
         case 109: {
            // preventStalledSupply_1Step2
            Logger.print("SupplyManager" , "Requesting to build a pylon due to supply stall");
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Pylon));
            break;
         }
         case 111: {
            // startBuildOrderManager_1Step1
            Logger.print("ABL" , "Starting Build Order manager");
            BuildSequenceWME sequence = BuildSelector.selectBuild();
            ((EISBot)__$thisEntity).offsetPylons = sequence.isFastExpand();
            BehavingEntity.getBehavingEntity().addWME(sequence);
            break;
         }
         case 113: {
            // getNextBuildStep_1Step1
            Logger.print("ABL" , "Waiting for BO requests to be processed");
            break;
         }
         case 115: {
            // getNextBuildStep_1Step3
            __$behaviorFrame[1] = ((BuildSequenceWME)__$behaviorFrame[0]).getRequestWME();
            Logger.print("ABL" , "New Build Order request: " + ((RequestWME)__$behaviorFrame[1]));
            if(((RequestWME)__$behaviorFrame[1]) != null) { ABLStarCraftBot.getGame().processedBuildRequest(((RequestWME)__$behaviorFrame[1])); }
            break;
         }
         case 117: {
            // getNextBuildStep_1Step5
            ((BuildSequenceWME)__$behaviorFrame[0]).getNextStep();
            break;
         }
         case 118: {
            // processBuildStep_1Step1
            BehavingEntity.getBehavingEntity().addWME(((RequestWME)__$behaviorFrame[0]));
            break;
         }
         case 119: {
            // processBuildStep_2Step1
            BehavingEntity.getBehavingEntity().deleteWME(((BuildSequenceWME)__$behaviorFrame[1]));
            Logger.print("ABL" , "Build order completed");
            ((EISBot)__$thisEntity).waitForPrereqs = false;
            BehavingEntity.getBehavingEntity().addWME(new EnableCBRWME());
            break;
         }
         case 120: {
            // startCBRManager_1Step1
            Logger.print("CBR" , "Starting CBR manager");
            break;
         }
         case 129: {
            // processUnitRequests_1Step5
            BehavingEntity.getBehavingEntity().deleteWME(((UnitRequestWME)__$behaviorFrame[0]));
            break;
         }
         case 130: {
            // handlePrereqs_1Step1
            Logger.print("ABL" , "Adding Construction WME for unit prereqs");
            ((ReconWME)__$behaviorFrame[2]).addPrereqsToWM(((__ValueTypes.IntVar)__$behaviorFrame[0]).i , ((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            break;
         }
         case 132: {
            // handleUnitRequest_1Step2
            BehavingEntity.getBehavingEntity().addWME(new TrainUnitWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 134: {
            // handleUnitRequest_2Step2
            BehavingEntity.getBehavingEntity().addWME(new TrainUnitWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 136: {
            // handleUnitRequest_3Step2
            BehavingEntity.getBehavingEntity().addWME(new TrainUnitWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 138: {
            // handleUnitRequest_4Step2
            BehavingEntity.getBehavingEntity().addWME(new TrainUnitWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 140: {
            // handleUnitRequest_5Step2
            BehavingEntity.getBehavingEntity().addWME(new TrainUnitWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 142: {
            // handleUnitRequest_6Step2
            BehavingEntity.getBehavingEntity().addWME(new TrainUnitWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 147: {
            // processBuildingRequests_1Step5
            BehavingEntity.getBehavingEntity().deleteWME(((BuildingRequestWME)__$behaviorFrame[0]));
            break;
         }
         case 148: {
            // handleBuildingRequest_1Step1
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 149: {
            // handleBuildingRequest_2Step1
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 151: {
            // handleBuildingRequest_3Step2
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 152: {
            // handleBuildingRequest_4Step1
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i));
            break;
         }
         case 157: {
            // processResearchRequests_1Step5
            BehavingEntity.getBehavingEntity().deleteWME(((ResearchRequestWME)__$behaviorFrame[0]));
            break;
         }
         case 169: {
            // processArchonRequests_1Step4
            BehavingEntity.getBehavingEntity().deleteWME(((ArchonRequestWME)__$behaviorFrame[0]));
            break;
         }
         case 170: {
            // handleArchonRequest_1Step1
            ((HighTemplarWME)__$behaviorFrame[3]).setMerged();
            ((HighTemplarWME)__$behaviorFrame[2]).setMerged();
            break;
         }
         case 174: {
            // handleArchonRequest_2Step2
            ((HighTemplarWME)__$behaviorFrame[1]).setMerged();
            ((HighTemplarWME)__$behaviorFrame[2]).setMerged();
            break;
         }
         case 185: {
            // cancelTrain_1Step1
            System.err.println("Cancelling train unit");
            break;
         }
         case 191: {
            // produceObservers_1Step4
            BehavingEntity.getBehavingEntity().deleteWME(((TrainUnitWME)__$behaviorFrame[0]));
            break;
         }
         case 195: {
            // produceUnits_1Step4
            BehavingEntity.getBehavingEntity().deleteWME(((TrainUnitWME)__$behaviorFrame[0]));
            break;
         }
         case 199: {
            // produceUnitsNow_1Step4
            BehavingEntity.getBehavingEntity().deleteWME(((TrainUnitWME)__$behaviorFrame[0]));
            break;
         }
         case 218: {
            // detectIdleGasWorkers_1Step2
            ((ProbeWME)__$behaviorFrame[0]).setTask(WORKER_IDLE);
            break;
         }
         case 221: {
            // detectIdleConstructors_1Step2
            ((ProbeWME)__$behaviorFrame[0]).setTask(WORKER_IDLE);
            break;
         }
         case 224: {
            // clearMineralBlocks_1Step2
            ((ProbeWME)__$behaviorFrame[2]).setTask(WORKER_CLEAR);
            break;
         }
         case 228: {
            // clearMineralBlocks_1Step6
            ((ProbeWME)__$behaviorFrame[2]).setTask(WORKER_IDLE);
            break;
         }
         case 230: {
            // forceAssimilator_1Step2
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Assimilator));
            break;
         }
         case 242: {
            // additionalAssimilators_1Step2
            Logger.print("WorkerManager" , "Requesting to build an additional assimilator");
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Assimilator));
            break;
         }
         case 245: {
            // pullOffGas_1Step2
            ((AssimilatorWME)__$behaviorFrame[0]).setTargetWorkers(1);
            break;
         }
         case 248: {
            // pullOffGasDefense_1Step2
            ((AssimilatorWME)__$behaviorFrame[0]).setTargetWorkers(0);
            BehavingEntity.getBehavingEntity().addWME(new GasHoldWME());
            break;
         }
         case 250: {
            // pullOffGasDefense_1Step4
            BehavingEntity.getBehavingEntity().deleteAllWMEClass("GasHoldWME");
            break;
         }
         case 252: {
            // putOnGas_1Step2
            ((AssimilatorWME)__$behaviorFrame[0]).setTargetWorkers(3);
            break;
         }
         case 255: {
            // manageWorkerHarass_1Step2
            ((ProbeWME)__$behaviorFrame[7]).setTask(WORKER_DEFEND);
            if(((ProbeWME)__$behaviorFrame[7]).getShields() <= 10) { ((__ValueTypes.IntVar)__$behaviorFrame[8]).i = 1; }
            if(! ((__ValueTypes.BooleanVar)__$behaviorFrame[9]).b) { ((__ValueTypes.IntVar)__$behaviorFrame[8]).i = 5; }
            break;
         }
         case 263: {
            // getFriendHelp_1Step1
            ((ProbeWME)__$behaviorFrame[5]).setTask(WORKER_DEFEND);
            ((__ValueTypes.IntVar)__$behaviorFrame[4]).i = ((__ValueTypes.IntVar)__$behaviorFrame[4]).i - 1;
            break;
         }
         case 273: {
            // returnToWork_1Step3
            ((ProbeWME)__$behaviorFrame[0]).setTask(WORKER_GAS);
            break;
         }
         case 276: {
            // returnToWork_2Step3
            ((ProbeWME)__$behaviorFrame[0]).setTask(WORKER_MINE);
            break;
         }
         case 280: {
            // transferWorkers_1Step1
            ((MineralWME)__$behaviorFrame[10]).setAsUsed();
            if(((ProbeWME)__$behaviorFrame[6]).getNexus() != null) { ((ProbeWME)__$behaviorFrame[6]).getNexus().freeWorker(((__ValueTypes.IntVar)__$behaviorFrame[8]).i); }
            ((NexusWME)__$behaviorFrame[0]).addWorker(((__ValueTypes.IntVar)__$behaviorFrame[8]).i);
            ((ProbeWME)__$behaviorFrame[6]).setNexus(((NexusWME)__$behaviorFrame[0]));
            ((__ValueTypes.IntVar)__$behaviorFrame[4]).i --;
            break;
         }
         case 285: {
            // mineMinerals_1Step3
            ((ProbeWME)__$behaviorFrame[3]).setTask(WORKER_MINE);
            break;
         }
         case 286: {
            // selectMinerals_1Step1
            ((MineralWME)__$behaviorFrame[10]).setAsUsed();
            ((NexusWME)__$behaviorFrame[8]).addWorker(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            ((ProbeWME)__$behaviorFrame[0]).setNexus(((NexusWME)__$behaviorFrame[8]));
            break;
         }
         case 288: {
            // selectMinerals_2Step1
            ((MineralWME)__$behaviorFrame[10]).setAsUsed();
            ((NexusWME)__$behaviorFrame[8]).addWorker(((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            ((ProbeWME)__$behaviorFrame[0]).setNexus(((NexusWME)__$behaviorFrame[8]));
            break;
         }
         case 293: {
            // modifyGasCollectors_1Step1
            if(((ProbeWME)__$behaviorFrame[6]).getNexus() != null) { ((ProbeWME)__$behaviorFrame[6]).getNexus().freeWorker(((__ValueTypes.IntVar)__$behaviorFrame[7]).i); }
            ((ProbeWME)__$behaviorFrame[6]).setTask(WORKER_GAS);
            ((AssimilatorWME)__$behaviorFrame[0]).addWorker(((__ValueTypes.IntVar)__$behaviorFrame[7]).i);
            break;
         }
         case 295: {
            // modifyGasCollectors_2Step1
            ((AssimilatorWME)__$behaviorFrame[0]).freeWorker(((__ValueTypes.IntVar)__$behaviorFrame[7]).i);
            ((ProbeWME)__$behaviorFrame[6]).setTask(WORKER_IDLE);
            break;
         }
         case 298: {
            // checkMinedOut_1Step2
            if(((ProbeWME)__$behaviorFrame[0]).getNexus() != null) { ((ProbeWME)__$behaviorFrame[0]).getNexus().freeWorker(((__ValueTypes.IntVar)__$behaviorFrame[1]).i); }
            ((ProbeWME)__$behaviorFrame[0]).setTask(WORKER_IDLE);
            break;
         }
         case 300: {
            // forceMinerals_1Step1
            ((AssimilatorWME)__$behaviorFrame[0]).setTargetWorkers(0);
            break;
         }
         case 302: {
            // forceGas_1Step1
            ((AssimilatorWME)__$behaviorFrame[0]).setTargetWorkers(3);
            break;
         }
         case 305: {
            // waitForConstructionRequest_1Step2
            ((__ValueTypes.IntVar)__$behaviorFrame[1]).i = ((__ValueTypes.IntVar)__$behaviorFrame[1]).i + 60 * 24;
            break;
         }
         case 307: {
            // waitForConstructionRequest_1Step4
            BehavingEntity.getBehavingEntity().deleteWME(((ConstructionWME)__$behaviorFrame[0]));
            break;
         }
         case 308: {
            // delayNextNexus_1Step1
            ((EISBot)__$thisEntity).nextNexusRequest = ((__ValueTypes.IntVar)__$behaviorFrame[1]).i + 5 * 24 * 60;
            break;
         }
         case 309: {
            // processConstructionWME_3Step1
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(((ConstructionWME)__$behaviorFrame[0]).getType()));
            break;
         }
         case 313: {
            // processConstructionWME_4Step3
            ((PlayerWME)__$behaviorFrame[3]).addResourceHold(((ConstructionWME)__$behaviorFrame[0]).getMineralCost() , ((ConstructionWME)__$behaviorFrame[0]).getGasCost());
            ((ConstructionWME)__$behaviorFrame[0]).setResourcesClaimed();
            ((__ValueTypes.IntVar)__$behaviorFrame[2]).i = ((ConstructionWME)__$behaviorFrame[0]).getType();
            break;
         }
         case 318: {
            // assignConstructionWorker_1Step1
            if(((ProbeWME)__$behaviorFrame[2]).getNexus() != null) { ((ProbeWME)__$behaviorFrame[2]).getNexus().freeWorker(((__ValueTypes.IntVar)__$behaviorFrame[3]).i); }
            ((ProbeWME)__$behaviorFrame[2]).setNexus(null);
            ((ProbeWME)__$behaviorFrame[2]).setTask(WORKER_CONSTRUCT);
            break;
         }
         case 321: {
            // assignConstructionWorker_1Step4
            ((ProbeWME)__$behaviorFrame[2]).setTask(WORKER_IDLE);
            break;
         }
         case 324: {
            // monitorTrappedWorkers_1Step2
            ((__ValueTypes.IntVar)__$behaviorFrame[2]).i = ((ProbeWME)__$behaviorFrame[0]).getX();
            ((__ValueTypes.IntVar)__$behaviorFrame[3]).i = ((ProbeWME)__$behaviorFrame[0]).getY();
            ((__ValueTypes.IntVar)__$behaviorFrame[4]).i = ((ProbeWME)__$behaviorFrame[0]).getOrder();
            break;
         }
         case 327: {
            // monitorTrapped_1Step2
            ((ProbeWME)__$behaviorFrame[0]).setTrapped();
            break;
         }
         case 328: {
            // selectBuildSite_1Step1
            ((EISBot)__$thisEntity).offsetPylons = false;
            ((NewUnitWME)__$behaviorFrame[3]).setPurpose(((EISBot)__$thisEntity).pylonPurpose);
            BehavingEntity.getBehavingEntity().deleteWME(((NewUnitWME)__$behaviorFrame[3]));
            break;
         }
         case 329: {
            // selectBuildSite_2Step1
            ((EISBot)__$thisEntity).pylonPurpose = ((__ValueTypes.IntVar)__$behaviorFrame[5]).i;
            break;
         }
         case 335: {
            // selectBuildSite_3Step1
            Logger.print("ABL" , "No room, building more pylons");
            BehavingEntity.getBehavingEntity().addWME(new ConstructionWME(Protoss_Pylon));
            break;
         }
         case 336: {
            // freeResources_1Step1
            ((PlayerWME)__$behaviorFrame[1]).removeResourceHold(((ConstructionWME)__$behaviorFrame[0]).getMineralCost() , ((ConstructionWME)__$behaviorFrame[0]).getGasCost());
            break;
         }
         case 337: {
            // startTacticsManager_1Step1
            Logger.print("Tactics" , "Starting tactics manager");
            break;
         }
         case 367: {
            // defendBaseGround_1Step2
            ((AttackUnitWME)__$behaviorFrame[6]).setLastMoved(((__ValueTypes.IntVar)__$behaviorFrame[5]).i);
            break;
         }
         case 377: {
            // defendBaseAir_1Step2
            ((AttackUnitWME)__$behaviorFrame[7]).setLastMoved(((__ValueTypes.IntVar)__$behaviorFrame[6]).i);
            break;
         }
         case 381: {
            // defendBaseCaster_1Step2
            ((CasterUnitWME)__$behaviorFrame[7]).setLastMoved(((__ValueTypes.IntVar)__$behaviorFrame[6]).i);
            break;
         }
         case 385: {
            // createSquad_1Step2
            ((__ValueTypes.IntVar)__$behaviorFrame[0]).i = ++ ((EISBot)__$thisEntity).squadCounter;
            Logger.print("Squad" , "Forming Squad: " + ((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            ((EISBot)__$thisEntity).minSquadSize = Math.min(((EISBot)__$thisEntity).minSquadSize + 1 , ((EISBot)__$thisEntity).maxSquadSize);
            __$behaviorFrame[3] = new SquadWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            ((SquadWME)__$behaviorFrame[3]).createSquad();
            break;
         }
         case 388: {
            // createSquad_1Step5
            BehavingEntity.getBehavingEntity().addWME(((SquadWME)__$behaviorFrame[3]));
            break;
         }
         case 393: {
            // regroupSquad_1Step3
            Logger.print("Squad" , "Squad is regrouping");
            ((SquadWME)__$behaviorFrame[1]).regroup(false);
            ((SquadWME)__$behaviorFrame[1]).setRegrouping(true);
            break;
         }
         case 395: {
            // regroupSquad_1Step5
            ((SquadWME)__$behaviorFrame[1]).setRegrouping(false);
            break;
         }
         case 399: {
            // squadBreakup_1Step2
            ((SquadWME)__$behaviorFrame[0]).breakUp();
            break;
         }
         case 410: {
            // deleteSquad_1Step2
            BehavingEntity.getBehavingEntity().deleteWME(((SquadWME)__$behaviorFrame[0]));
            Logger.print("Squad" , "Deleting squad: " + ((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            break;
         }
         case 412: {
            // squadRetreat_1Step2
            ((SquadWME)__$behaviorFrame[0]).retreat();
            break;
         }
         case 416: {
            // squadMerge_1Step2
            ((__ValueTypes.IntVar)__$behaviorFrame[0]).i = ++ ((EISBot)__$thisEntity).squadCounter;
            Logger.print("Squad" , "Merging Squad: " + ((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            __$behaviorFrame[3] = new SquadWME(((__ValueTypes.IntVar)__$behaviorFrame[0]).i);
            ((SquadWME)__$behaviorFrame[3]).mergeSquads();
            break;
         }
         case 419: {
            // squadMerge_1Step5
            BehavingEntity.getBehavingEntity().addWME(((SquadWME)__$behaviorFrame[3]));
            break;
         }
         case 422: {
            // manageRetreat_1Step1
            ((SquadWME)__$behaviorFrame[0]).setRetreating(true);
            break;
         }
         case 425: {
            // stopRetreat_1Step1
            ((SquadWME)__$behaviorFrame[0]).stopRetreat();
            break;
         }
         case 426: {
            // stopRetreat_2Step1
            ((SquadWME)__$behaviorFrame[0]).setRetreating(false);
            break;
         }
         case 428: {
            // rallyUnits_1Step2
            ((AttackUnitWME)__$behaviorFrame[4]).setTask(FIGHTER_GUARD);
            Point rally = ((MapWME)__$behaviorFrame[5]).getRallyPoint(((__ValueTypes.IntVar)__$behaviorFrame[1]).i , ((__ValueTypes.IntVar)__$behaviorFrame[2]).i);
            if(rally != null) { ((__ValueTypes.DoubleVar)__$behaviorFrame[6]).d = Math.random() * 2.0 * Math.PI; ((__ValueTypes.IntVar)__$behaviorFrame[1]).i = rally.x; ((__ValueTypes.IntVar)__$behaviorFrame[2]).i = rally.y; ((__ValueTypes.IntVar)__$behaviorFrame[1]).i +=(int)(Math.cos(((__ValueTypes.DoubleVar)__$behaviorFrame[6]).d) * 3.5); ((__ValueTypes.IntVar)__$behaviorFrame[2]).i +=(int)(Math.sin(((__ValueTypes.DoubleVar)__$behaviorFrame[6]).d) * 3.5); }
            break;
         }
         case 432: {
            // unblockChokes_1Step2
            ((__ValueTypes.IntVar)__$behaviorFrame[1]).i += -2 +(int)(5.0 * Math.random());
            ((__ValueTypes.IntVar)__$behaviorFrame[2]).i += -2 +(int)(5.0 * Math.random());
            break;
         }
         case 436: {
            // scatterAttack_1Step2
            ((AttackUnitWME)__$behaviorFrame[3]).setPreviousHealth();
            System.err.println("Ground units Scattering");
            break;
         }
         case 445: {
            // revealCloakedUnits_1Step2
            ((ObserverWME)__$behaviorFrame[5]).setLastMoved(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            break;
         }
         case 449: {
            // revealBurrowedUnits_1Step2
            ((ObserverWME)__$behaviorFrame[5]).setLastMoved(((__ValueTypes.IntVar)__$behaviorFrame[3]).i);
            break;
         }
         case 459: {
            // flee_1Step2
            ((DragoonWME)__$behaviorFrame[3]).setTask(FIGHTER_FLEE);
            break;
         }
         case 464: {
            // fleeDamage_1Step2
            ((DragoonWME)__$behaviorFrame[3]).setTask(FIGHTER_FLEE);
            break;
         }
         case 469: {
            // flee_2Step2
            ((PlayerUnitWME)__$behaviorFrame[0]).setPreviousHealth();
            ((PlayerUnitWME)__$behaviorFrame[0]).setTask(FIGHTER_ATTACK);
            break;
         }
         case 474: {
            // casterAssignSquad_1Step2
            ((CasterUnitWME)__$behaviorFrame[0]).setSquadID(((SquadWME)__$behaviorFrame[1]).getClosestSquadID(((__ValueTypes.IntVar)__$behaviorFrame[2]).i , ((__ValueTypes.IntVar)__$behaviorFrame[3]).i));
            break;
         }
         case 477: {
            // archonAssignSquad_1Step2
            ((ArchonWME)__$behaviorFrame[0]).setSquadID(((SquadWME)__$behaviorFrame[1]).getClosestSquadID(((__ValueTypes.IntVar)__$behaviorFrame[2]).i , ((__ValueTypes.IntVar)__$behaviorFrame[3]).i));
            ((__ValueTypes.IntVar)__$behaviorFrame[5]).i = ((__ValueTypes.IntVar)__$behaviorFrame[2]).i;
            ((__ValueTypes.IntVar)__$behaviorFrame[6]).i = ((__ValueTypes.IntVar)__$behaviorFrame[3]).i;
            Point center = ((SquadWME)__$behaviorFrame[1]).getCenter(false);
            if(center != null) { ((__ValueTypes.IntVar)__$behaviorFrame[5]).i = center.x; ((__ValueTypes.IntVar)__$behaviorFrame[6]).i = center.y; }
            break;
         }
         case 481: {
            // attackerAssignSquad_1Step2
            ((AttackUnitWME)__$behaviorFrame[0]).setSquadID(((SquadWME)__$behaviorFrame[1]).getSquadID());
            break;
         }
         case 487: {
            // casterRetreat_1Step2
            ((CasterUnitWME)__$behaviorFrame[0]).setSquadID(0);
            break;
         }
         case 494: {
            // mergeArchon_1Step2
            ((HighTemplarWME)__$behaviorFrame[0]).setMerged();
            ((HighTemplarWME)__$behaviorFrame[1]).setMerged();
            break;
         }
         case 499: {
            // clearMergedFlag_1Step2
            ((HighTemplarWME)__$behaviorFrame[0]).setNotMerged();
            ((HighTemplarWME)__$behaviorFrame[1]).setNotMerged();
            break;
         }
         case 503: {
            // WaitFrames_1Step1
            ((__ValueTypes.IntVar)__$behaviorFrame[1]).i = ABLStarCraftBot.getGame().getGameFrame() + ((__ValueTypes.IntVar)__$behaviorFrame[0]).i;
            break;
         }
         case 508: {
            // processKeypresses_1Step3
            Logger.print("ABL" , "keycode: " + ((__ValueTypes.IntVar)__$behaviorFrame[1]).i);
            BehavingEntity.getBehavingEntity().deleteWME(((KeyPressWME)__$behaviorFrame[0]));
            break;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
