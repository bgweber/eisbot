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
public class EISBot_ContextConditions implements eisbot.abl.StarCraftConstants
{
   static public boolean contextCondition0(int __$behaviorID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity) {
      switch (__$behaviorID) {
         case 25: {
            // workerScout_1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  if (
                     ( wme__0.getID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                  )

                  {
                        if (
                           ((ProbeWME)__$behaviorFrame[0]).getHitPoints() > 0
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 26: {
            // workerScout_2
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  if (
                     ( wme__0.getID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                  )

                  {
                        if (
                           ((ProbeWME)__$behaviorFrame[0]).getHitPoints() > 0
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 56: {
            // handleArchonRequest_2
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("HighTemplarWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  HighTemplarWME wme__0 = (HighTemplarWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__0.getID())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("HighTemplarWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           HighTemplarWME wme__1 = (HighTemplarWME)wmeIter1.next();
                           if (
                              ( wme__1.getID() != ((__ValueTypes.IntVar)__$behaviorFrame[5]).i )
                           )

                           {
                              return true;
                           }

                        }


                  }

               }


            return false;
         }
         case 105: {
            // processConstructionWME_4
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ConstructionWME wme__0 = (ConstructionWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                        if (
                           ((ConstructionWME)__$behaviorFrame[0]).getHasRequirements() == true
                        )

                        {
                              List wmeList2;
                              ListIterator wmeIter2;
                              wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
                              wmeIter2 = wmeList2.listIterator();
                              while(wmeIter2.hasNext()) {
                                 TimerWME wme__2 = (TimerWME)wmeIter2.next();
                                 if (
                                    ( wme__2.getFrameCount() < ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                                 )

                                 {
                                    return true;
                                 }

                              }


                        }


                  }

               }


            return false;
         }
         case 109: {
            // assignConstructionWorker_1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  if (
                     ( wme__0.getID() == ((__ValueTypes.IntVar)__$behaviorFrame[3]).i )
                     &&
                     ( wme__0.getActive() == true )
                  )

                  {
                        if (
                           ((ProbeWME)__$behaviorFrame[2]).getHitPoints() > 0
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 111: {
            // monitorTrapped_1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  if (
                     ( wme__0.getID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                     &&
                     ( wme__0.getX() == ((__ValueTypes.IntVar)__$behaviorFrame[2]).i )
                     &&
                     ( wme__0.getY() == ((__ValueTypes.IntVar)__$behaviorFrame[3]).i )
                     &&
                     ( wme__0.getOrder() == ((__ValueTypes.IntVar)__$behaviorFrame[4]).i )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 113: {
            // selectBuildSite_2
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("MapWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  MapWME wme__0 = (MapWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                        if (
                           ((MapWME)__$behaviorFrame[6]).isLocationClear(((__ValueTypes.IntVar)__$behaviorFrame[0]).i , ((__ValueTypes.IntVar)__$behaviorFrame[4]).i , ((__ValueTypes.IntVar)__$behaviorFrame[3]).i , ((__ValueTypes.IntVar)__$behaviorFrame[2]).i) == true
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 125: {
            // regroupSquad_1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getSquadID() == ((__ValueTypes.IntVar)__$behaviorFrame[0]).i )
                     &&
                     ( wme__0.getSize() > 1 )
                     &&
                     ( wme__0.getEnemyDistance() >= 20 )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}
