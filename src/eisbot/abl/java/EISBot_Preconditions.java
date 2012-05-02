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
public class EISBot_Preconditions implements eisbot.abl.StarCraftConstants
{
   static public boolean precondition0(int __$behaviorID, Object[] __$args, Hashtable __$variableTable, final BehavingEntity __$thisEntity) {
      switch (__$behaviorID) {
         case 6: {
            // spendExcess_3
            int minerals = ((Integer)__$args[0]).intValue();
            int gas = ((Integer)__$args[1]).intValue();
            int unitID;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ForgeUpgradeDelayWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ForgeUpgradeDelayWME wme__0 = (ForgeUpgradeDelayWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  if (
                     minerals >= 300 && gas >= 300
                  )

                  {
                        List wmeList2;
                        ListIterator wmeIter2;
                        wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ForgeWME");
                        wmeIter2 = wmeList2.listIterator();
                        while(wmeIter2.hasNext()) {
                           ForgeWME wme__2 = (ForgeWME)wmeIter2.next();
                           if (
                              BehavingEntity.constantTrue(unitID = wme__2.getID())
                              &&
                              ( wme__2.getActive() == true )
                              &&
                              ( wme__2.getResearchTimer() == 0 )
                           )

                           {
                                 if (
                                    Logger.print("ABL" , "Excess spending on forge upgrades")
                                 )

                                 {
                                    __$variableTable.put("unitID", new Integer(unitID));
                                    return true;
                                 }


                           }

                        }


                  }



            return false;
         }
         case 7: {
            // deleteForgeUpgradeDelay_1
            ForgeUpgradeDelayWME delayWME;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ForgeUpgradeDelayWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ForgeUpgradeDelayWME wme__0 = (ForgeUpgradeDelayWME)wmeIter0.next();
                  delayWME = wme__0;
                  if (
                     true
                  )

                  {
                     __$variableTable.put("delayWME", new ObjectWrapper(delayWME));
                     return true;
                  }

               }


            return false;
         }
         case 8: {
            // spendExcess_4
            int minerals = ((Integer)__$args[0]).intValue();
            int gas = ((Integer)__$args[1]).intValue();
               if (
                  minerals >= 600
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("GatewayWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        GatewayWME wme__1 = (GatewayWME)wmeIter1.next();
                        if (
                           ( wme__1.getActive() == true )
                           &&
                           ( wme__1.getTrainTimer() == 0 )
                           &&
                           ( wme__1.getBuildTimer() == 0 )
                        )

                        {
                           return false;
                        }

                     }

                        List wmeList2;
                        ListIterator wmeIter2;
                        wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("GatewayWME");
                        wmeIter2 = wmeList2.listIterator();
                        while(wmeIter2.hasNext()) {
                           GatewayWME wme__2 = (GatewayWME)wmeIter2.next();
                           if (
                              ( wme__2.getActive() == false )
                           )

                           {
                              return false;
                           }

                        }

                           List wmeList3;
                           ListIterator wmeIter3;
                           wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                           wmeIter3 = wmeList3.listIterator();
                           while(wmeIter3.hasNext()) {
                              ConstructionWME wme__3 = (ConstructionWME)wmeIter3.next();
                              if (
                                 ( wme__3.getType() == 160 )
                              )

                              {
                                 return false;
                              }

                           }

                              if (
                                 Logger.print("ABL" , "Adding more production facilities")
                              )

                              {
                                 return true;
                              }





               }


            return false;
         }
         case 9: {
            // spendExcess_5
            int minerals = ((Integer)__$args[0]).intValue();
            int gas = ((Integer)__$args[1]).intValue();
            int used;
            int total;
            int unitID;
               if (
                  minerals >= 300 && gas >= 600
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                        if (
                           BehavingEntity.constantTrue(used = wme__1.getSupplyUsed())
                           &&
                           BehavingEntity.constantTrue(total = wme__1.getSupplyTotal())
                        )

                        {
                              if (
                                 used < total
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("ArchivesWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       ArchivesWME wme__3 = (ArchivesWME)wmeIter3.next();
                                       if (
                                          true
                                       )

                                       {
                                             List wmeList4;
                                             ListIterator wmeIter4;
                                             wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("GatewayWME");
                                             wmeIter4 = wmeList4.listIterator();
                                             while(wmeIter4.hasNext()) {
                                                GatewayWME wme__4 = (GatewayWME)wmeIter4.next();
                                                if (
                                                   BehavingEntity.constantTrue(unitID = wme__4.getID())
                                                   &&
                                                   ( wme__4.getActive() == true )
                                                   &&
                                                   ( wme__4.getTrainTimer() == 0 )
                                                   &&
                                                   ( wme__4.getBuildTimer() == 0 )
                                                )

                                                {
                                                      if (
                                                         Logger.print("ABL" , "Excess spending on High Templar")
                                                      )

                                                      {
                                                         __$variableTable.put("total", new Integer(total));
                                                         __$variableTable.put("unitID", new Integer(unitID));
                                                         __$variableTable.put("used", new Integer(used));
                                                         return true;
                                                      }


                                                }

                                             }


                                       }

                                    }


                              }


                        }

                     }


               }


            return false;
         }
         case 10: {
            // spendExcess_6
            int minerals = ((Integer)__$args[0]).intValue();
            int gas = ((Integer)__$args[1]).intValue();
            int used;
            int total;
            int unitID;
               if (
                  minerals >= 600 && gas >= 300
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                        if (
                           BehavingEntity.constantTrue(used = wme__1.getSupplyUsed())
                           &&
                           BehavingEntity.constantTrue(total = wme__1.getSupplyTotal())
                        )

                        {
                              if (
                                 used < total
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("CyberneticsCoreWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       CyberneticsCoreWME wme__3 = (CyberneticsCoreWME)wmeIter3.next();
                                       if (
                                          true
                                       )

                                       {
                                             List wmeList4;
                                             ListIterator wmeIter4;
                                             wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("GatewayWME");
                                             wmeIter4 = wmeList4.listIterator();
                                             while(wmeIter4.hasNext()) {
                                                GatewayWME wme__4 = (GatewayWME)wmeIter4.next();
                                                if (
                                                   BehavingEntity.constantTrue(unitID = wme__4.getID())
                                                   &&
                                                   ( wme__4.getActive() == true )
                                                   &&
                                                   ( wme__4.getTrainTimer() == 0 )
                                                   &&
                                                   ( wme__4.getBuildTimer() == 0 )
                                                )

                                                {
                                                      if (
                                                         Logger.print("ABL" , "Excess spending on Dragoons")
                                                      )

                                                      {
                                                         __$variableTable.put("total", new Integer(total));
                                                         __$variableTable.put("unitID", new Integer(unitID));
                                                         __$variableTable.put("used", new Integer(used));
                                                         return true;
                                                      }


                                                }

                                             }


                                       }

                                    }


                              }


                        }

                     }


               }


            return false;
         }
         case 11: {
            // spendExcess_7
            int minerals = ((Integer)__$args[0]).intValue();
            int gas = ((Integer)__$args[1]).intValue();
            int used;
            int total;
            int unitID;
               if (
                  minerals >= 600
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                        if (
                           BehavingEntity.constantTrue(used = wme__1.getSupplyUsed())
                           &&
                           BehavingEntity.constantTrue(total = wme__1.getSupplyTotal())
                        )

                        {
                              if (
                                 used < total
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("GatewayWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       GatewayWME wme__3 = (GatewayWME)wmeIter3.next();
                                       if (
                                          BehavingEntity.constantTrue(unitID = wme__3.getID())
                                          &&
                                          ( wme__3.getActive() == true )
                                          &&
                                          ( wme__3.getTrainTimer() == 0 )
                                          &&
                                          ( wme__3.getBuildTimer() == 0 )
                                       )

                                       {
                                             if (
                                                Logger.print("ABL" , "Excess spending on Zealots")
                                             )

                                             {
                                                __$variableTable.put("total", new Integer(total));
                                                __$variableTable.put("unitID", new Integer(unitID));
                                                __$variableTable.put("used", new Integer(used));
                                                return true;
                                             }


                                       }

                                    }


                              }


                        }

                     }


               }


            return false;
         }
         case 25: {
            // workerScout_1
            ProbeWME worker = (ProbeWME)__$args[0];
            int workerID = ((Integer)__$args[1]).intValue();
            ParticleWME particle;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ParticleWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ParticleWME wme__0 = (ParticleWME)wmeIter0.next();
                  particle = wme__0;
                  if (
                     ( wme__0.getTypeID() != 42 )
                     &&
                     ( wme__0.getTypeID() != 41 )
                     &&
                     ( wme__0.getTypeID() != 64 )
                     &&
                     ( wme__0.getTypeID() != 7 )
                  )

                  {
                        if (
                           Logger.print("ABL" , "Particle scouting")
                        )

                        {
                           __$variableTable.put("particle", new ObjectWrapper(particle));
                           return true;
                        }


                  }

               }


            return false;
         }
         case 26: {
            // workerScout_2
            ProbeWME worker = (ProbeWME)__$args[0];
            int workerID = ((Integer)__$args[1]).intValue();
            MapWME map;
            TimerWME timer;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("MapWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  MapWME wme__0 = (MapWME)wmeIter0.next();
                  map = wme__0;
                  if (
                     true
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           TimerWME wme__1 = (TimerWME)wmeIter1.next();
                           timer = wme__1;
                           if (
                              true
                           )

                           {
                              __$variableTable.put("timer", new ObjectWrapper(timer));
                              __$variableTable.put("map", new ObjectWrapper(map));
                              return true;
                           }

                        }


                  }

               }


            return false;
         }
         case 33: {
            // processBuildStep_1
            RequestWME request = (RequestWME)__$args[0];
               if (
                  request != null
               )

               {
                  return true;
               }


            return false;
         }
         case 34: {
            // processBuildStep_2
            RequestWME request = (RequestWME)__$args[0];
            BuildSequenceWME buildOrder;
               if (
                  request == null
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        BuildSequenceWME wme__1 = (BuildSequenceWME)wmeIter1.next();
                        buildOrder = wme__1;
                        if (
                           true
                        )

                        {
                           __$variableTable.put("buildOrder", new ObjectWrapper(buildOrder));
                           return true;
                        }

                     }


               }


            return false;
         }
         case 37: {
            // handlePrereqs_1
            int req1 = ((Integer)__$args[0]).intValue();
            int req2 = ((Integer)__$args[1]).intValue();
            ReconWME recon;
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == false
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        ReconWME wme__1 = (ReconWME)wmeIter1.next();
                        recon = wme__1;
                        if (
                           true
                        )

                        {
                           __$variableTable.put("recon", new ObjectWrapper(recon));
                           return true;
                        }

                     }


               }


            return false;
         }
         case 38: {
            // handleUnitRequest_1
            int typeID = ((Integer)__$args[0]).intValue();
            int whatBuilds = ((Integer)__$args[1]).intValue();
            int req1 = ((Integer)__$args[2]).intValue();
            int req2 = ((Integer)__$args[3]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == false
               )

               {
                     if (
                        req1 == NULL_UNIT && req2 == NULL_UNIT
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerUnitWME wme__2 = (PlayerUnitWME)wmeIter2.next();
                              if (
                                 ( wme__2.getTypeID() == whatBuilds )
                                 &&
                                 ( wme__2.getActive() == true )
                              )

                              {
                                 return true;
                              }

                           }


                     }


               }


            return false;
         }
         case 39: {
            // handleUnitRequest_2
            int typeID = ((Integer)__$args[0]).intValue();
            int whatBuilds = ((Integer)__$args[1]).intValue();
            int req1 = ((Integer)__$args[2]).intValue();
            int req2 = ((Integer)__$args[3]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == true
               )

               {
                     if (
                        req1 == NULL_UNIT && req2 == NULL_UNIT
                     )

                     {
                        return true;
                     }


               }


            return false;
         }
         case 40: {
            // handleUnitRequest_3
            int typeID = ((Integer)__$args[0]).intValue();
            int whatBuilds = ((Integer)__$args[1]).intValue();
            int req1 = ((Integer)__$args[2]).intValue();
            int req2 = ((Integer)__$args[3]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == false
               )

               {
                     if (
                        req1 != NULL_UNIT && req2 == NULL_UNIT
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerUnitWME wme__2 = (PlayerUnitWME)wmeIter2.next();
                              if (
                                 ( wme__2.getTypeID() == whatBuilds )
                                 &&
                                 ( wme__2.getActive() == true )
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       PlayerUnitWME wme__3 = (PlayerUnitWME)wmeIter3.next();
                                       if (
                                          ( wme__3.getTypeID() == req1 )
                                          &&
                                          ( wme__3.getActive() == true )
                                       )

                                       {
                                          return true;
                                       }

                                    }


                              }

                           }


                     }


               }


            return false;
         }
         case 41: {
            // handleUnitRequest_4
            int typeID = ((Integer)__$args[0]).intValue();
            int whatBuilds = ((Integer)__$args[1]).intValue();
            int req1 = ((Integer)__$args[2]).intValue();
            int req2 = ((Integer)__$args[3]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == true
               )

               {
                     if (
                        req1 != NULL_UNIT && req2 == NULL_UNIT
                     )

                     {
                        return true;
                     }


               }


            return false;
         }
         case 42: {
            // handleUnitRequest_5
            int typeID = ((Integer)__$args[0]).intValue();
            int whatBuilds = ((Integer)__$args[1]).intValue();
            int req1 = ((Integer)__$args[2]).intValue();
            int req2 = ((Integer)__$args[3]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == false
               )

               {
                     if (
                        req1 != NULL_UNIT && req2 != NULL_UNIT
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerUnitWME wme__2 = (PlayerUnitWME)wmeIter2.next();
                              if (
                                 ( wme__2.getTypeID() == whatBuilds )
                                 &&
                                 ( wme__2.getActive() == true )
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       PlayerUnitWME wme__3 = (PlayerUnitWME)wmeIter3.next();
                                       if (
                                          ( wme__3.getTypeID() == req1 )
                                          &&
                                          ( wme__3.getActive() == true )
                                       )

                                       {
                                             List wmeList4;
                                             ListIterator wmeIter4;
                                             wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                                             wmeIter4 = wmeList4.listIterator();
                                             while(wmeIter4.hasNext()) {
                                                PlayerUnitWME wme__4 = (PlayerUnitWME)wmeIter4.next();
                                                if (
                                                   ( wme__4.getTypeID() == req2 )
                                                   &&
                                                   ( wme__4.getActive() == true )
                                                )

                                                {
                                                   return true;
                                                }

                                             }


                                       }

                                    }


                              }

                           }


                     }


               }


            return false;
         }
         case 43: {
            // handleUnitRequest_6
            int typeID = ((Integer)__$args[0]).intValue();
            int whatBuilds = ((Integer)__$args[1]).intValue();
            int req1 = ((Integer)__$args[2]).intValue();
            int req2 = ((Integer)__$args[3]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == true
               )

               {
                     if (
                        req1 != NULL_UNIT && req2 != NULL_UNIT
                     )

                     {
                        return true;
                     }


               }


            return false;
         }
         case 45: {
            // handleBuildingRequest_1
            int type = ((Integer)__$args[0]).intValue();
            int unitReq = ((Integer)__$args[1]).intValue();
            int secondUnitReq = ((Integer)__$args[2]).intValue();
               if (
                  unitReq == NULL_UNIT
               )

               {
                  return true;
               }


            return false;
         }
         case 46: {
            // handleBuildingRequest_2
            int type = ((Integer)__$args[0]).intValue();
            int unitReq = ((Integer)__$args[1]).intValue();
            int secondUnitReq = ((Integer)__$args[2]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == false
               )

               {
                     if (
                        unitReq != NULL_UNIT && secondUnitReq == NULL_UNIT
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerUnitWME wme__2 = (PlayerUnitWME)wmeIter2.next();
                              if (
                                 ( wme__2.getTypeID() == unitReq )
                                 &&
                                 ( wme__2.getActive() == true )
                              )

                              {
                                 return true;
                              }

                           }


                     }


               }


            return false;
         }
         case 47: {
            // handleBuildingRequest_3
            int type = ((Integer)__$args[0]).intValue();
            int unitReq = ((Integer)__$args[1]).intValue();
            int secondUnitReq = ((Integer)__$args[2]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == true
               )

               {
                     if (
                        unitReq != NULL_UNIT
                     )

                     {
                        return true;
                     }


               }


            return false;
         }
         case 48: {
            // handleBuildingRequest_4
            int type = ((Integer)__$args[0]).intValue();
            int unitReq = ((Integer)__$args[1]).intValue();
            int secondUnitReq = ((Integer)__$args[2]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == false
               )

               {
                     if (
                        unitReq != NULL_UNIT && secondUnitReq != NULL_UNIT
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerUnitWME wme__2 = (PlayerUnitWME)wmeIter2.next();
                              if (
                                 ( wme__2.getTypeID() == unitReq )
                                 &&
                                 ( wme__2.getActive() == true )
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       PlayerUnitWME wme__3 = (PlayerUnitWME)wmeIter3.next();
                                       if (
                                          ( wme__3.getTypeID() == secondUnitReq )
                                          &&
                                          ( wme__3.getActive() == true )
                                       )

                                       {
                                          return true;
                                       }

                                    }


                              }

                           }


                     }


               }


            return false;
         }
         case 50: {
            // handleResearchRequest_1
            boolean isUpgrade = ((Boolean)__$args[0]).booleanValue();
            int type = ((Integer)__$args[1]).intValue();
            int whatResearches = ((Integer)__$args[2]).intValue();
            int mineralsCost = ((Integer)__$args[3]).intValue();
            int gasCost = ((Integer)__$args[4]).intValue();
            int unitID;
            PlayerUnitWME unit;
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == false
               )

               {
                     if (
                        isUpgrade == true
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerUnitWME wme__2 = (PlayerUnitWME)wmeIter2.next();
                              unit = wme__2;
                              if (
                                 ( wme__2.getTypeID() == whatResearches )
                                 &&
                                 BehavingEntity.constantTrue(unitID = wme__2.getID())
                                 &&
                                 ( wme__2.getActive() == true )
                                 &&
                                 ( wme__2.getResearchTimer() == 0 )
                              )

                              {
                                 __$variableTable.put("unit", new ObjectWrapper(unit));
                                 __$variableTable.put("unitID", new Integer(unitID));
                                 return true;
                              }

                           }


                     }


               }


            return false;
         }
         case 51: {
            // handleResearchRequest_2
            boolean isUpgrade = ((Boolean)__$args[0]).booleanValue();
            int type = ((Integer)__$args[1]).intValue();
            int whatResearches = ((Integer)__$args[2]).intValue();
            int mineralsCost = ((Integer)__$args[3]).intValue();
            int gasCost = ((Integer)__$args[4]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == true
               )

               {
                     if (
                        isUpgrade == true
                     )

                     {
                        return true;
                     }


               }


            return false;
         }
         case 52: {
            // handleResearchRequest_3
            boolean isUpgrade = ((Boolean)__$args[0]).booleanValue();
            int type = ((Integer)__$args[1]).intValue();
            int whatResearches = ((Integer)__$args[2]).intValue();
            int mineralsCost = ((Integer)__$args[3]).intValue();
            int gasCost = ((Integer)__$args[4]).intValue();
            int unitID;
            PlayerUnitWME unit;
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == false
               )

               {
                     if (
                        isUpgrade == false
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerUnitWME wme__2 = (PlayerUnitWME)wmeIter2.next();
                              unit = wme__2;
                              if (
                                 ( wme__2.getTypeID() == whatResearches )
                                 &&
                                 BehavingEntity.constantTrue(unitID = wme__2.getID())
                              )

                              {
                                 __$variableTable.put("unit", new ObjectWrapper(unit));
                                 __$variableTable.put("unitID", new Integer(unitID));
                                 return true;
                              }

                           }


                     }


               }


            return false;
         }
         case 53: {
            // handleResearchRequest_4
            boolean isUpgrade = ((Boolean)__$args[0]).booleanValue();
            int type = ((Integer)__$args[1]).intValue();
            int whatResearches = ((Integer)__$args[2]).intValue();
            int mineralsCost = ((Integer)__$args[3]).intValue();
            int gasCost = ((Integer)__$args[4]).intValue();
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == true
               )

               {
                     if (
                        isUpgrade == false
                     )

                     {
                        return true;
                     }


               }


            return false;
         }
         case 55: {
            // handleArchonRequest_1
            ArchonRequestWME request = (ArchonRequestWME)__$args[0];
            int y2;
            HighTemplarWME templar2;
            HighTemplarWME templar1;
            int x1;
            int x2;
            int ID2;
            int y1;
            int ID1;
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == false
               )

               {
                     if (
                        request.isDark() == false
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("HighTemplarWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              HighTemplarWME wme__2 = (HighTemplarWME)wmeIter2.next();
                              templar1 = wme__2;
                              if (
                                 ( wme__2.getActive() == true )
                                 &&
                                 ( wme__2.getMerged() == false )
                                 &&
                                 BehavingEntity.constantTrue(ID1 = wme__2.getID())
                                 &&
                                 BehavingEntity.constantTrue(x1 = wme__2.getX())
                                 &&
                                 BehavingEntity.constantTrue(y1 = wme__2.getY())
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("HighTemplarWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       HighTemplarWME wme__3 = (HighTemplarWME)wmeIter3.next();
                                       templar2 = wme__3;
                                       if (
                                          ( wme__3.getActive() == true )
                                          &&
                                          ( wme__3.getMerged() == false )
                                          &&
                                          ( wme__3.getID() != ID1 )
                                          &&
                                          BehavingEntity.constantTrue(ID2 = wme__3.getID())
                                          &&
                                          BehavingEntity.constantTrue(x2 = wme__3.getX())
                                          &&
                                          BehavingEntity.constantTrue(y2 = wme__3.getY())
                                       )

                                       {
                                             if (
                                                UnitWME.distance(x1 , y1 , x2 , y2) < 20
                                             )

                                             {
                                                   if (
                                                      Logger.print("CBR" , "Warping Archon")
                                                   )

                                                   {
                                                      __$variableTable.put("ID2", new Integer(ID2));
                                                      __$variableTable.put("templar2", new ObjectWrapper(templar2));
                                                      __$variableTable.put("ID1", new Integer(ID1));
                                                      __$variableTable.put("templar1", new ObjectWrapper(templar1));
                                                      __$variableTable.put("y1", new Integer(y1));
                                                      __$variableTable.put("y2", new Integer(y2));
                                                      __$variableTable.put("x2", new Integer(x2));
                                                      __$variableTable.put("x1", new Integer(x1));
                                                      return true;
                                                   }


                                             }


                                       }

                                    }


                              }

                           }


                     }


               }


            return false;
         }
         case 56: {
            // handleArchonRequest_2
            ArchonRequestWME request = (ArchonRequestWME)__$args[0];
               if (
                  ((EISBot)__$thisEntity).waitForPrereqs == true
               )

               {
                     if (
                        request.isDark() == false
                     )

                     {
                        return true;
                     }


               }


            return false;
         }
         case 60: {
            // cancelTrain_1
            int unitID = ((Integer)__$args[0]).intValue();
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("UnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  UnitWME wme__0 = (UnitWME)wmeIter0.next();
                  if (
                     ( wme__0.getID() == unitID )
                     &&
                     ( wme__0.getTrainingQueueSize() > 1 )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 64: {
            // trainUnit_1
            int unitID = ((Integer)__$args[0]).intValue();
            int type = ((Integer)__$args[1]).intValue();
            ReconWME recon;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ReconWME wme__0 = (ReconWME)wmeIter0.next();
                  recon = wme__0;
                  if (
                     true
                  )

                  {
                        if (
                           recon.isDuplicate(type) == true
                        )

                        {
                           __$variableTable.put("recon", new ObjectWrapper(recon));
                           return true;
                        }


                  }

               }


            return false;
         }
         case 80: {
            // getFriendHelp_1
            int allyX = ((Integer)__$args[0]).intValue();
            int allyY = ((Integer)__$args[1]).intValue();
            int enemyX = ((Integer)__$args[2]).intValue();
            int enemyY = ((Integer)__$args[3]).intValue();
            int friends = ((Integer)__$args[4]).intValue();
            ProbeWME worker;
            int y;
            int task;
            int x;
            int workerID;
            int priorTarget;
               if (
                  Logger.print("ABL" , "Looking for friends: " + friends)
               )

               {
                     if (
                        friends > 0
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              ProbeWME wme__2 = (ProbeWME)wmeIter2.next();
                              worker = wme__2;
                              if (
                                 BehavingEntity.constantTrue(workerID = wme__2.getID())
                                 &&
                                 BehavingEntity.constantTrue(priorTarget = wme__2.getOrderTarget())
                                 &&
                                 BehavingEntity.constantTrue(task = wme__2.getTask())
                                 &&
                                 BehavingEntity.constantTrue(x = wme__2.getX())
                                 &&
                                 BehavingEntity.constantTrue(y = wme__2.getY())
                              )

                              {
                                    if (
                                       task == WORKER_MINE
                                    )

                                    {
                                          if (
                                             Math.abs(allyX - x) <= 7 && Math.abs(allyY - y) <= 7
                                          )

                                          {
                                                if (
                                                   Logger.print("ABL" , "Getting help from a friend: " + workerID)
                                                )

                                                {
                                                   __$variableTable.put("priorTarget", new Integer(priorTarget));
                                                   __$variableTable.put("task", new Integer(task));
                                                   __$variableTable.put("worker", new ObjectWrapper(worker));
                                                   __$variableTable.put("workerID", new Integer(workerID));
                                                   __$variableTable.put("y", new Integer(y));
                                                   __$variableTable.put("x", new Integer(x));
                                                   return true;
                                                }


                                          }


                                    }


                              }

                           }


                     }


               }


            return false;
         }
         case 83: {
            // returnToWork_1
            ProbeWME worker = (ProbeWME)__$args[0];
            int workerID = ((Integer)__$args[1]).intValue();
            int priorTarget = ((Integer)__$args[2]).intValue();
            AssimilatorWME assimilator;
            int assimilatorID;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("AssimilatorWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  AssimilatorWME wme__0 = (AssimilatorWME)wmeIter0.next();
                  assimilator = wme__0;
                  if (
                     BehavingEntity.constantTrue(assimilatorID = wme__0.getID())
                  )

                  {
                        if (
                           assimilator.getIsAssigned(workerID)
                        )

                        {
                              if (
                                 Logger.print("ABL" , "Returning to gas")
                              )

                              {
                                 __$variableTable.put("assimilatorID", new Integer(assimilatorID));
                                 __$variableTable.put("assimilator", new ObjectWrapper(assimilator));
                                 return true;
                              }


                        }


                  }

               }


            return false;
         }
         case 84: {
            // returnToWork_2
            ProbeWME worker = (ProbeWME)__$args[0];
            int workerID = ((Integer)__$args[1]).intValue();
            int priorTarget = ((Integer)__$args[2]).intValue();
               if (
                  Logger.print("ABL" , "Returning to minerals")
               )

               {
                  return true;
               }


            return false;
         }
         case 86: {
            // transferWorkers_1
            NexusWME nexus = (NexusWME)__$args[0];
            int nexusID = ((Integer)__$args[1]).intValue();
            int nexusX = ((Integer)__$args[2]).intValue();
            int nexusY = ((Integer)__$args[3]).intValue();
            int count = ((Integer)__$args[4]).intValue();
            int minX;
            ProbeWME worker;
            int minY;
            int unitID;
            int mineralID;
            MineralWME minerals;
               if (
                  count > 0
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        ProbeWME wme__1 = (ProbeWME)wmeIter1.next();
                        worker = wme__1;
                        if (
                           ( wme__1.getTask() == 1 )
                           &&
                           BehavingEntity.constantTrue(unitID = wme__1.getID())
                        )

                        {
                              if (
                                 worker.getNexus() != null && worker.getNexus().getID() != nexusID
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("MineralWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       MineralWME wme__3 = (MineralWME)wmeIter3.next();
                                       minerals = wme__3;
                                       if (
                                          BehavingEntity.constantTrue(mineralID = wme__3.getID())
                                          &&
                                          BehavingEntity.constantTrue(minX = wme__3.getX())
                                          &&
                                          BehavingEntity.constantTrue(minY = wme__3.getY())
                                          &&
                                          ( wme__3.getTimeSinceLastUse() >= 1000 )
                                       )

                                       {
                                             if (
                                                Math.abs(nexusX - minX) <= 10 && Math.abs(nexusY - minY) <= 10
                                             )

                                             {
                                                __$variableTable.put("mineralID", new Integer(mineralID));
                                                __$variableTable.put("worker", new ObjectWrapper(worker));
                                                __$variableTable.put("unitID", new Integer(unitID));
                                                __$variableTable.put("minX", new Integer(minX));
                                                __$variableTable.put("minerals", new ObjectWrapper(minerals));
                                                __$variableTable.put("minY", new Integer(minY));
                                                return true;
                                             }


                                       }

                                    }


                              }


                        }

                     }


               }


            return false;
         }
         case 88: {
            // selectMinerals_1
            ProbeWME worker = (ProbeWME)__$args[0];
            int unitID = ((Integer)__$args[1]).intValue();
            int workerX = ((Integer)__$args[2]).intValue();
            int workerY = ((Integer)__$args[3]).intValue();
            int minX;
            int y;
            int minY;
            int x;
            NexusWME nexus;
            int mineralID;
            MineralWME minerals;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  NexusWME wme__0 = (NexusWME)wmeIter0.next();
                  nexus = wme__0;
                  if (
                     ( wme__0.getActive() == true )
                     &&
                     BehavingEntity.constantTrue(x = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(y = wme__0.getY())
                  )

                  {
                        if (
                           Math.abs(workerX - x) <= 10 && Math.abs(workerY - y) <= 10
                        )

                        {
                              List wmeList2;
                              ListIterator wmeIter2;
                              wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("MineralWME");
                              wmeIter2 = wmeList2.listIterator();
                              while(wmeIter2.hasNext()) {
                                 MineralWME wme__2 = (MineralWME)wmeIter2.next();
                                 minerals = wme__2;
                                 if (
                                    BehavingEntity.constantTrue(mineralID = wme__2.getID())
                                    &&
                                    BehavingEntity.constantTrue(minX = wme__2.getX())
                                    &&
                                    BehavingEntity.constantTrue(minY = wme__2.getY())
                                    &&
                                    ( wme__2.getTimeSinceLastUse() >= 1000 )
                                 )

                                 {
                                       if (
                                          Math.abs(x - minX) <= 10 && Math.abs(y - minY) <= 10
                                       )

                                       {
                                          __$variableTable.put("nexus", new ObjectWrapper(nexus));
                                          __$variableTable.put("mineralID", new Integer(mineralID));
                                          __$variableTable.put("minX", new Integer(minX));
                                          __$variableTable.put("minerals", new ObjectWrapper(minerals));
                                          __$variableTable.put("y", new Integer(y));
                                          __$variableTable.put("minY", new Integer(minY));
                                          __$variableTable.put("x", new Integer(x));
                                          return true;
                                       }


                                 }

                              }


                        }


                  }

               }


            return false;
         }
         case 89: {
            // selectMinerals_2
            ProbeWME worker = (ProbeWME)__$args[0];
            int unitID = ((Integer)__$args[1]).intValue();
            int workerX = ((Integer)__$args[2]).intValue();
            int workerY = ((Integer)__$args[3]).intValue();
            int minX;
            int y;
            int minY;
            int x;
            NexusWME nexus;
            int mineralID;
            MineralWME minerals;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  NexusWME wme__0 = (NexusWME)wmeIter0.next();
                  nexus = wme__0;
                  if (
                     BehavingEntity.constantTrue(x = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(y = wme__0.getY())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("MineralWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           MineralWME wme__1 = (MineralWME)wmeIter1.next();
                           minerals = wme__1;
                           if (
                              BehavingEntity.constantTrue(mineralID = wme__1.getID())
                              &&
                              BehavingEntity.constantTrue(minX = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(minY = wme__1.getY())
                           )

                           {
                                 if (
                                    Math.abs(x - minX) <= 10 && Math.abs(y - minY) <= 10
                                 )

                                 {
                                    __$variableTable.put("nexus", new ObjectWrapper(nexus));
                                    __$variableTable.put("mineralID", new Integer(mineralID));
                                    __$variableTable.put("minX", new Integer(minX));
                                    __$variableTable.put("minerals", new ObjectWrapper(minerals));
                                    __$variableTable.put("y", new Integer(y));
                                    __$variableTable.put("minY", new Integer(minY));
                                    __$variableTable.put("x", new Integer(x));
                                    return true;
                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 91: {
            // modifyGasCollectors_1
            AssimilatorWME assimilator = (AssimilatorWME)__$args[0];
            int assimilatorID = ((Integer)__$args[1]).intValue();
            int numWorkers = ((Integer)__$args[2]).intValue();
            int targetWorkers = ((Integer)__$args[3]).intValue();
            int x = ((Integer)__$args[4]).intValue();
            int y = ((Integer)__$args[5]).intValue();
            ProbeWME worker;
            int unitID;
            int workerX;
            int workerY;
               if (
                  numWorkers < targetWorkers
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        ProbeWME wme__1 = (ProbeWME)wmeIter1.next();
                        worker = wme__1;
                        if (
                           ( wme__1.getTask() == 1 )
                           &&
                           BehavingEntity.constantTrue(unitID = wme__1.getID())
                           &&
                           BehavingEntity.constantTrue(workerX = wme__1.getX())
                           &&
                           BehavingEntity.constantTrue(workerY = wme__1.getY())
                           &&
                           ( wme__1.getActive() == true )
                           &&
                           ( wme__1.getCarryingMinerals() == false )
                        )

                        {
                              if (
                                 ! assimilator.getIsAssigned(unitID)
                              )

                              {
                                    if (
                                       Math.abs(x - workerX) <= 10 && Math.abs(y - workerY) <= 10
                                    )

                                    {
                                       __$variableTable.put("workerY", new Integer(workerY));
                                       __$variableTable.put("workerX", new Integer(workerX));
                                       __$variableTable.put("worker", new ObjectWrapper(worker));
                                       __$variableTable.put("unitID", new Integer(unitID));
                                       return true;
                                    }


                              }


                        }

                     }


               }


            return false;
         }
         case 92: {
            // modifyGasCollectors_2
            AssimilatorWME assimilator = (AssimilatorWME)__$args[0];
            int assimilatorID = ((Integer)__$args[1]).intValue();
            int numWorkers = ((Integer)__$args[2]).intValue();
            int targetWorkers = ((Integer)__$args[3]).intValue();
            int x = ((Integer)__$args[4]).intValue();
            int y = ((Integer)__$args[5]).intValue();
            ProbeWME worker;
            int unitID;
            int workerX;
            int workerY;
               if (
                  numWorkers > targetWorkers
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        ReconWME wme__1 = (ReconWME)wmeIter1.next();
                        if (
                           ( wme__1.getNumNexus() == 1 )
                        )

                        {
                              List wmeList2;
                              ListIterator wmeIter2;
                              wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
                              wmeIter2 = wmeList2.listIterator();
                              while(wmeIter2.hasNext()) {
                                 ProbeWME wme__2 = (ProbeWME)wmeIter2.next();
                                 worker = wme__2;
                                 if (
                                    ( wme__2.getTask() == 2 )
                                    &&
                                    BehavingEntity.constantTrue(unitID = wme__2.getID())
                                    &&
                                    BehavingEntity.constantTrue(workerX = wme__2.getX())
                                    &&
                                    BehavingEntity.constantTrue(workerY = wme__2.getY())
                                    &&
                                    ( wme__2.getActive() == true )
                                    &&
                                    ( wme__2.getOrder() == 81 )
                                 )

                                 {
                                    __$variableTable.put("workerY", new Integer(workerY));
                                    __$variableTable.put("workerX", new Integer(workerX));
                                    __$variableTable.put("worker", new ObjectWrapper(worker));
                                    __$variableTable.put("unitID", new Integer(unitID));
                                    return true;
                                 }

                              }


                        }

                     }


               }


            return false;
         }
         case 96: {
            // forceMinerals_1
            AssimilatorWME assimilator;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("AssimilatorWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  AssimilatorWME wme__0 = (AssimilatorWME)wmeIter0.next();
                  assimilator = wme__0;
                  if (
                     ( wme__0.getTargetWorkers() != 0 )
                  )

                  {
                     __$variableTable.put("assimilator", new ObjectWrapper(assimilator));
                     return true;
                  }

               }


            return false;
         }
         case 98: {
            // forceGas_1
            AssimilatorWME assimilator;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("AssimilatorWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  AssimilatorWME wme__0 = (AssimilatorWME)wmeIter0.next();
                  assimilator = wme__0;
                  if (
                     ( wme__0.getTargetWorkers() != 3 )
                  )

                  {
                     __$variableTable.put("assimilator", new ObjectWrapper(assimilator));
                     return true;
                  }

               }


            return false;
         }
         case 101: {
            // processConstructionWME_1
            ConstructionWME construction = (ConstructionWME)__$args[0];
            int timeDeadline = ((Integer)__$args[1]).intValue();
               if (
                  construction.isNexus()
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        TimerWME wme__1 = (TimerWME)wmeIter1.next();
                        if (
                           ( wme__1.getFrameCount() < ((EISBot)__$thisEntity).nextNexusRequest )
                        )

                        {
                           return true;
                        }

                     }


               }


            return false;
         }
         case 102: {
            // delayNextNexus_1
            ConstructionWME construction = (ConstructionWME)__$args[0];
            int frameCount;
               if (
                  construction.isNexus()
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        TimerWME wme__1 = (TimerWME)wmeIter1.next();
                        if (
                           BehavingEntity.constantTrue(frameCount = wme__1.getFrameCount())
                        )

                        {
                           __$variableTable.put("frameCount", new Integer(frameCount));
                           return true;
                        }

                     }


               }


            return false;
         }
         case 103: {
            // processConstructionWME_2
            ConstructionWME construction = (ConstructionWME)__$args[0];
            int timeDeadline = ((Integer)__$args[1]).intValue();
            ReconWME recon;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ReconWME wme__0 = (ReconWME)wmeIter0.next();
                  recon = wme__0;
                  if (
                     true
                  )

                  {
                        if (
                           recon.isDuplicate(construction) == true
                        )

                        {
                           __$variableTable.put("recon", new ObjectWrapper(recon));
                           return true;
                        }


                  }

               }


            return false;
         }
         case 104: {
            // processConstructionWME_3
            ConstructionWME construction = (ConstructionWME)__$args[0];
            int timeDeadline = ((Integer)__$args[1]).intValue();
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TimerWME wme__0 = (TimerWME)wmeIter0.next();
                  if (
                     ( wme__0.getFrameCount() >= timeDeadline )
                  )

                  {
                        if (
                           Logger.print("Construction" , "Construction timed out: " + construction.getType())
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 105: {
            // processConstructionWME_4
            ConstructionWME construction = (ConstructionWME)__$args[0];
            int timeDeadline = ((Integer)__$args[1]).intValue();
            PlayerWME player;
               if (
                  construction.getHasRequirements()
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        TimerWME wme__1 = (TimerWME)wmeIter1.next();
                        if (
                           ( wme__1.getFrameCount() < timeDeadline )
                        )

                        {
                              List wmeList2;
                              ListIterator wmeIter2;
                              wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                              wmeIter2 = wmeList2.listIterator();
                              while(wmeIter2.hasNext()) {
                                 PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                                 player = wme__2;
                                 if (
                                    true
                                 )

                                 {
                                       if (
                                          Logger.print("Construction" , "Approved construction request: " + construction.getType())
                                       )

                                       {
                                          __$variableTable.put("player", new ObjectWrapper(player));
                                          return true;
                                       }


                                 }

                              }


                        }

                     }


               }


            return false;
         }
         case 106: {
            // processConstructionWME_5
            ConstructionWME construction = (ConstructionWME)__$args[0];
               if (
                  construction.getHasRequirements() == false
               )

               {
                  return true;
               }


            return false;
         }
         case 107: {
            // selectConstructor_1
            ConstructionWME construction = (ConstructionWME)__$args[0];
            int type = ((Integer)__$args[1]).intValue();
            ProbeWME worker;
            int unitID;
               if (
                  type != Protoss_Pylon
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        ProbeWME wme__1 = (ProbeWME)wmeIter1.next();
                        worker = wme__1;
                        if (
                           ( wme__1.getTask() == 1 )
                           &&
                           BehavingEntity.constantTrue(unitID = wme__1.getID())
                           &&
                           ( wme__1.getActive() == true )
                           &&
                           ( wme__1.getCarryingMinerals() == false )
                        )

                        {
                              if (
                                 Logger.print("ABL" , "Picked (non-Pylon) worker unit: " + construction.getType())
                              )

                              {
                                 __$variableTable.put("worker", new ObjectWrapper(worker));
                                 __$variableTable.put("unitID", new Integer(unitID));
                                 return true;
                              }


                        }

                     }


               }


            return false;
         }
         case 108: {
            // selectConstructor_2
            ConstructionWME construction = (ConstructionWME)__$args[0];
            int type = ((Integer)__$args[1]).intValue();
            ProbeWME worker;
            int unitID;
               if (
                  type == Protoss_Pylon
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("MapWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        MapWME wme__1 = (MapWME)wmeIter1.next();
                        if (
                           BehavingEntity.constantTrue(unitID = wme__1.getPylonWorker())
                        )

                        {
                              List wmeList2;
                              ListIterator wmeIter2;
                              wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
                              wmeIter2 = wmeList2.listIterator();
                              while(wmeIter2.hasNext()) {
                                 ProbeWME wme__2 = (ProbeWME)wmeIter2.next();
                                 worker = wme__2;
                                 if (
                                    ( wme__2.getTask() == 1 )
                                    &&
                                    BehavingEntity.constantTrue(unitID = wme__2.getID())
                                    &&
                                    ( wme__2.getActive() == true )
                                    &&
                                    ( wme__2.getCarryingMinerals() == false )
                                 )

                                 {
                                       if (
                                          Logger.print("ABL" , "Picked (Pylon) worker unit: " + construction.getType())
                                       )

                                       {
                                          __$variableTable.put("worker", new ObjectWrapper(worker));
                                          __$variableTable.put("unitID", new Integer(unitID));
                                          return true;
                                       }


                                 }

                              }


                        }

                     }


               }


            return false;
         }
         case 112: {
            // selectBuildSite_1
            int type = ((Integer)__$args[0]).intValue();
            ProbeWME worker = (ProbeWME)__$args[1];
            int workerID = ((Integer)__$args[2]).intValue();
            NewUnitWME event;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("NewUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  NewUnitWME wme__0 = (NewUnitWME)wmeIter0.next();
                  event = wme__0;
                  if (
                     ( wme__0.getType() == type )
                  )

                  {
                        if (
                           Logger.print("Construction" , "Construction now started: " + type)
                        )

                        {
                           __$variableTable.put("event", new ObjectWrapper(event));
                           return true;
                        }


                  }

               }


            return false;
         }
         case 113: {
            // selectBuildSite_2
            int type = ((Integer)__$args[0]).intValue();
            ProbeWME worker = (ProbeWME)__$args[1];
            int workerID = ((Integer)__$args[2]).intValue();
            int y;
            int x;
            int purpose;
            MapWME map;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("NewUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  NewUnitWME wme__0 = (NewUnitWME)wmeIter0.next();
                  if (
                     ( wme__0.getType() == type )
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("MapWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     MapWME wme__1 = (MapWME)wmeIter1.next();
                     map = wme__1;
                     if (
                        true
                     )

                     {
                           if (
                              map.findBuildingLocation(type , worker.getID() , worker.getX() , worker.getY() , ((EISBot)__$thisEntity).offsetPylons)
                           )

                           {
                                 List wmeList3;
                                 ListIterator wmeIter3;
                                 wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("MapWME");
                                 wmeIter3 = wmeList3.listIterator();
                                 while(wmeIter3.hasNext()) {
                                    MapWME wme__3 = (MapWME)wmeIter3.next();
                                    if (
                                       BehavingEntity.constantTrue(x = wme__3.getBuildingX())
                                       &&
                                       BehavingEntity.constantTrue(y = wme__3.getBuildingY())
                                       &&
                                       BehavingEntity.constantTrue(purpose = wme__3.getPurpose())
                                    )

                                    {
                                          if (
                                             Logger.print("Construction" , "Picked location: " + worker.getX() + " " + worker.getY())
                                          )

                                          {
                                             __$variableTable.put("map", new ObjectWrapper(map));
                                             __$variableTable.put("purpose", new Integer(purpose));
                                             __$variableTable.put("y", new Integer(y));
                                             __$variableTable.put("x", new Integer(x));
                                             return true;
                                          }


                                    }

                                 }


                           }


                     }

                  }



            return false;
         }
         case 114: {
            // buildTile_1
            int workerID = ((Integer)__$args[0]).intValue();
            int x = ((Integer)__$args[1]).intValue();
            int y = ((Integer)__$args[2]).intValue();
            int type = ((Integer)__$args[3]).intValue();
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("NewUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  NewUnitWME wme__0 = (NewUnitWME)wmeIter0.next();
                  if (
                     ( wme__0.getType() == type )
                  )

                  {
                     return false;
                  }

               }

                  if (
                     Logger.print("Construction" , "Performing build action: " + x + " " + y)
                  )

                  {
                        if (
                           Logger.print("ABL" , "Performing build action: " + x + " " + y)
                        )

                        {
                           return true;
                        }


                  }



            return false;
         }
         case 115: {
            // selectBuildSite_3
            int type = ((Integer)__$args[0]).intValue();
            PlayerUnitWME worker = (PlayerUnitWME)__$args[1];
            int workerID = ((Integer)__$args[2]).intValue();
            MapWME map;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("NewUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  NewUnitWME wme__0 = (NewUnitWME)wmeIter0.next();
                  if (
                     ( wme__0.getType() == type )
                  )

                  {
                     return false;
                  }

               }

                  if (
                     type != Protoss_Pylon
                  )

                  {
                        List wmeList2;
                        ListIterator wmeIter2;
                        wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                        wmeIter2 = wmeList2.listIterator();
                        while(wmeIter2.hasNext()) {
                           ConstructionWME wme__2 = (ConstructionWME)wmeIter2.next();
                           if (
                              ( wme__2.getType() == 156 )
                           )

                           {
                              return false;
                           }

                        }

                           List wmeList3;
                           ListIterator wmeIter3;
                           wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PylonWME");
                           wmeIter3 = wmeList3.listIterator();
                           while(wmeIter3.hasNext()) {
                              PylonWME wme__3 = (PylonWME)wmeIter3.next();
                              if (
                                 ( wme__3.getActive() == false )
                              )

                              {
                                 return false;
                              }

                           }

                              List wmeList4;
                              ListIterator wmeIter4;
                              wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("MapWME");
                              wmeIter4 = wmeList4.listIterator();
                              while(wmeIter4.hasNext()) {
                                 MapWME wme__4 = (MapWME)wmeIter4.next();
                                 map = wme__4;
                                 if (
                                    true
                                 )

                                 {
                                       if (
                                          ! map.findBuildingLocation(type , worker.getID() , worker.getX() , worker.getY())
                                       )

                                       {
                                          __$variableTable.put("map", new ObjectWrapper(map));
                                          return true;
                                       }


                                 }

                              }




                  }



            return false;
         }
         case 116: {
            // freeResources_1
            ConstructionWME construction = (ConstructionWME)__$args[0];
            PlayerWME player;
               if (
                  construction.getResourcesClaimed() == true
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                        player = wme__1;
                        if (
                           true
                        )

                        {
                           __$variableTable.put("player", new ObjectWrapper(player));
                           return true;
                        }

                     }


               }


            return false;
         }
         case 125: {
            // regroupSquad_1
            int squadID = ((Integer)__$args[0]).intValue();
            SquadWME squad;
               if (
                  Logger.print("Squad" , "Checking regroup behavior: " + squadID)
               )

               {
                     List wmeList1;
                     ListIterator wmeIter1;
                     wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
                     wmeIter1 = wmeList1.listIterator();
                     while(wmeIter1.hasNext()) {
                        SquadWME wme__1 = (SquadWME)wmeIter1.next();
                        squad = wme__1;
                        if (
                           ( wme__1.getSquadID() == squadID )
                           &&
                           ( wme__1.getSize() > 1 )
                           &&
                           ( wme__1.getEnemyDistance() >= 20 )
                        )

                        {
                              if (
                                 Logger.print("Squad" , "Entered regroup behavior: " + squadID)
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("ParticleWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       ParticleWME wme__3 = (ParticleWME)wmeIter3.next();
                                       if (
                                          true
                                       )

                                       {
                                          __$variableTable.put("squad", new ObjectWrapper(squad));
                                          return true;
                                       }

                                    }


                              }


                        }

                     }


               }


            return false;
         }
         case 129: {
            // squadSelectTarget_2
            int squadID = ((Integer)__$args[0]).intValue();
            int ny;
            int nx;
            boolean canAttackAir;
            int ex;
            int ey;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getSquadID() == squadID )
                     &&
                     ( wme__0.getEnemyDistance() < 20 )
                     &&
                     BehavingEntity.constantTrue(canAttackAir = wme__0.getCanAttackAir())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           EnemyUnitWME wme__1 = (EnemyUnitWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(ex = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(ey = wme__1.getY())
                              &&
                              ( wme__1.getBurrowed() == false )
                              &&
                              ( wme__1.getIsFlyer() == false )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    NexusWME wme__2 = (NexusWME)wmeIter2.next();
                                    if (
                                       BehavingEntity.constantTrue(nx = wme__2.getX())
                                       &&
                                       BehavingEntity.constantTrue(ny = wme__2.getY())
                                    )

                                    {
                                          if (
                                             Math.abs(ex - nx) < 24 && Math.abs(ey - ny) < 24
                                          )

                                          {
                                                if (
                                                   Logger.print("Squad" , "Squad defending base: " + squadID)
                                                )

                                                {
                                                   __$variableTable.put("ex", new Integer(ex));
                                                   __$variableTable.put("ey", new Integer(ey));
                                                   __$variableTable.put("ny", new Integer(ny));
                                                   __$variableTable.put("nx", new Integer(nx));
                                                   __$variableTable.put("canAttackAir", new Boolean(canAttackAir));
                                                   return true;
                                                }


                                          }


                                    }

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 130: {
            // squadSelectTarget_3
            int squadID = ((Integer)__$args[0]).intValue();
            boolean isFlyer;
            boolean canAttackAir;
            int y;
            int x;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getSquadID() == squadID )
                     &&
                     ( wme__0.getEnemyDistance() < 20 )
                     &&
                     BehavingEntity.constantTrue(canAttackAir = wme__0.getCanAttackAir())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           EnemyUnitWME wme__1 = (EnemyUnitWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(x = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(y = wme__1.getY())
                              &&
                              BehavingEntity.constantTrue(isFlyer = wme__1.getIsFlyer())
                           )

                           {
                                 if (
                                    canAttackAir || ! isFlyer
                                 )

                                 {
                                       if (
                                          Logger.print("Squad" , "Squad attacking enemy location: " + squadID)
                                       )

                                       {
                                          __$variableTable.put("isFlyer", new Boolean(isFlyer));
                                          __$variableTable.put("y", new Integer(y));
                                          __$variableTable.put("x", new Integer(x));
                                          __$variableTable.put("canAttackAir", new Boolean(canAttackAir));
                                          return true;
                                       }


                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 131: {
            // squadSelectTarget_4
            int squadID = ((Integer)__$args[0]).intValue();
            boolean isFlyer;
            boolean canAttackAir;
            int y;
            int x;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getSquadID() == squadID )
                     &&
                     ( wme__0.getIsRegrouping() == false )
                     &&
                     BehavingEntity.constantTrue(canAttackAir = wme__0.getCanAttackAir())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           EnemyUnitWME wme__1 = (EnemyUnitWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(x = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(y = wme__1.getY())
                              &&
                              BehavingEntity.constantTrue(isFlyer = wme__1.getIsFlyer())
                           )

                           {
                                 if (
                                    canAttackAir || ! isFlyer
                                 )

                                 {
                                       if (
                                          Logger.print("Squad" , "Squad attacking enemy location: " + squadID)
                                       )

                                       {
                                          __$variableTable.put("isFlyer", new Boolean(isFlyer));
                                          __$variableTable.put("y", new Integer(y));
                                          __$variableTable.put("x", new Integer(x));
                                          __$variableTable.put("canAttackAir", new Boolean(canAttackAir));
                                          return true;
                                       }


                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 132: {
            // squadSelectTarget_5
            int squadID = ((Integer)__$args[0]).intValue();
            boolean isFlyer;
            boolean canAttackAir;
            int y;
            int x;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getSquadID() == squadID )
                     &&
                     ( wme__0.getIsRegrouping() == false )
                     &&
                     BehavingEntity.constantTrue(canAttackAir = wme__0.getCanAttackAir())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ParticleWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ParticleWME wme__1 = (ParticleWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(x = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(y = wme__1.getY())
                              &&
                              BehavingEntity.constantTrue(isFlyer = wme__1.getIsFlyer())
                           )

                           {
                                 if (
                                    canAttackAir || ! isFlyer
                                 )

                                 {
                                       if (
                                          Logger.print("Squad" , "Squad attacking particle location: " + squadID)
                                       )

                                       {
                                          __$variableTable.put("isFlyer", new Boolean(isFlyer));
                                          __$variableTable.put("y", new Integer(y));
                                          __$variableTable.put("x", new Integer(x));
                                          __$variableTable.put("canAttackAir", new Boolean(canAttackAir));
                                          return true;
                                       }


                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 138: {
            // stopRetreat_1
            SquadWME squad = (SquadWME)__$args[0];
            int squadID = ((Integer)__$args[1]).intValue();
            int enemySupply;
            int squadSupply;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getSquadID() == squadID )
                     &&
                     BehavingEntity.constantTrue(squadSupply = wme__0.getSquadSupply())
                     &&
                     BehavingEntity.constantTrue(enemySupply = wme__0.getEnemySupply())
                  )

                  {
                        if (
                           squadSupply > enemySupply + 6
                        )

                        {
                              if (
                                 Logger.print("Squad" , "Squad is stopping retreat ")
                              )

                              {
                                 __$variableTable.put("enemySupply", new Integer(enemySupply));
                                 __$variableTable.put("squadSupply", new Integer(squadSupply));
                                 return true;
                              }


                        }


                  }

               }


            return false;
         }
         case 152: {
            // reattack_1
            int unitID = ((Integer)__$args[0]).intValue();
            int y;
            int x;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  EnemyUnitWME wme__0 = (EnemyUnitWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(x = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(y = wme__0.getY())
                  )

                  {
                     __$variableTable.put("y", new Integer(y));
                     __$variableTable.put("x", new Integer(x));
                     return true;
                  }

               }


            return false;
         }
         case 153: {
            // reattack_2
            int unitID = ((Integer)__$args[0]).intValue();
            int y;
            int x;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ParticleWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ParticleWME wme__0 = (ParticleWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(x = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(y = wme__0.getY())
                  )

                  {
                     __$variableTable.put("y", new Integer(y));
                     __$variableTable.put("x", new Integer(x));
                     return true;
                  }

               }


            return false;
         }
         case 164: {
            // continueBehavior_1
            boolean success = ((Boolean)__$args[0]).booleanValue();
               if (
                  success == true
               )

               {
                  return true;
               }


            return false;
         }
         case 165: {
            // continueBehavior_2
            boolean success = ((Boolean)__$args[0]).booleanValue();
               if (
                  success == false
               )

               {
                  return true;
               }


            return false;
         }
         case 168: {
            // keyPress_1
            int keycode = ((Integer)__$args[0]).intValue();
               if (
                  keycode == VK_M
               )

               {
                  return true;
               }


            return false;
         }
         case 169: {
            // keyPress_2
            int keycode = ((Integer)__$args[0]).intValue();
               if (
                  keycode == VK_G
               )

               {
                  return true;
               }


            return false;
         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}
