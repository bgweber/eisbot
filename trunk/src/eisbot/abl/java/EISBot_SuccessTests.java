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
public class EISBot_SuccessTests implements eisbot.abl.StarCraftConstants
{
   static public boolean successTest0(int __$stepID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity) {
      switch (__$stepID) {
         case 0: {
            // startup_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerUnitWME wme__1 = (PlayerUnitWME)wmeIter1.next();
                           if (
                              true
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("MineralWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    MineralWME wme__2 = (MineralWME)wmeIter2.next();
                                    if (
                                       true
                                    )

                                    {
                                          List wmeList3;
                                          ListIterator wmeIter3;
                                          wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("GeyserWME");
                                          wmeIter3 = wmeList3.listIterator();
                                          while(wmeIter3.hasNext()) {
                                             GeyserWME wme__3 = (GeyserWME)wmeIter3.next();
                                             if (
                                                true
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
         case 25: {
            // forceExpansion_1Step1
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
                           recon.getNumNexus() == 1
                        )

                        {
                              List wmeList2;
                              ListIterator wmeIter2;
                              wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                              wmeIter2 = wmeList2.listIterator();
                              while(wmeIter2.hasNext()) {
                                 NexusWME wme__2 = (NexusWME)wmeIter2.next();
                                 if (
                                    ( wme__2.getActive() == false )
                                 )

                                 {
                                    return false;
                                 }

                              }

                                 List wmeList3;
                                 ListIterator wmeIter3;
                                 wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                 wmeIter3 = wmeList3.listIterator();
                                 while(wmeIter3.hasNext()) {
                                    PlayerWME wme__3 = (PlayerWME)wmeIter3.next();
                                    if (
                                       ( wme__3.getSupplyUsed() >= 100 )
                                    )

                                    {
                                          List wmeList4;
                                          ListIterator wmeIter4;
                                          wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                                          wmeIter4 = wmeList4.listIterator();
                                          while(wmeIter4.hasNext()) {
                                             ConstructionWME wme__4 = (ConstructionWME)wmeIter4.next();
                                             if (
                                                ( wme__4.getType() == 154 )
                                             )

                                             {
                                                return false;
                                             }

                                          }

                                          return true;

                                    }

                                 }



                        }


                  }

               }


            return false;
         }
         case 28: {
            // spendExcess_1Step1
            int supplyUsed;
            int supplyTotal;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getMinerals())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getGas())
                     &&
                     ( wme__0.getSupplyUsed() < 380 )
                     &&
                     BehavingEntity.constantTrue(supplyTotal = wme__0.getSupplyTotal())
                     &&
                     BehavingEntity.constantTrue(supplyUsed = wme__0.getSupplyUsed())
                  )

                  {
                        if (
                           supplyUsed + 4 < supplyTotal
                        )

                        {
                              if (
                                 ((__ValueTypes.IntVar)__$behaviorFrame[0]).i > 600 || ((__ValueTypes.IntVar)__$behaviorFrame[1]).i > 600
                              )

                              {
                                 return true;
                              }


                        }


                  }

               }


            return false;
         }
         case 31: {
            // spendExcess_2Step1
            int supplyUsed;
            int supplyTotal;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  BuildSequenceWME wme__0 = (BuildSequenceWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                     if (
                        BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getMinerals())
                        &&
                        BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getGas())
                        &&
                        ( wme__1.getSupplyUsed() < 380 )
                        &&
                        BehavingEntity.constantTrue(supplyTotal = wme__1.getSupplyTotal())
                        &&
                        BehavingEntity.constantTrue(supplyUsed = wme__1.getSupplyUsed())
                     )

                     {
                           if (
                              supplyUsed + 4 < supplyTotal
                           )

                           {
                                 if (
                                    ((__ValueTypes.IntVar)__$behaviorFrame[0]).i > 600 || ((__ValueTypes.IntVar)__$behaviorFrame[1]).i > 600
                                 )

                                 {
                                    return true;
                                 }


                           }


                     }

                  }



            return false;
         }
         case 45: {
            // researchPsiStorm_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  BuildSequenceWME wme__0 = (BuildSequenceWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ArchivesWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     ArchivesWME wme__1 = (ArchivesWME)wmeIter1.next();
                     if (
                        ( wme__1.getActive() == true )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                              __$behaviorFrame[1] = wme__2;
                              if (
                                 true
                              )

                              {
                                    if (
                                       Logger.print("ABL" , "Locking resources for Psi Storm Upgrade")
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
         case 47: {
            // researchPsiStorm_1Step3
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     ( wme__0.getActualMinerals() >= 200 )
                     &&
                     ( wme__0.getActualGas() >= 200 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ArchivesWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ArchivesWME wme__1 = (ArchivesWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getID())
                              &&
                              ( wme__1.getActive() == true )
                              &&
                              ( wme__1.getResearchTimer() == 0 )
                           )

                           {
                                 if (
                                    Logger.print("ABL" , "Frcing Psi Storm Upgrade")
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
         case 56: {
            // researchTemplarEnergy_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     ( wme__0.getMinerals() >= 150 )
                     &&
                     ( wme__0.getGas() >= 150 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ArchivesWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ArchivesWME wme__1 = (ArchivesWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getID())
                              &&
                              ( wme__1.getActive() == true )
                              &&
                              ( wme__1.getResearchTimer() == 0 )
                           )

                           {
                                 if (
                                    Logger.print("ABL" , "Forcing templar energy")
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
         case 58: {
            // researchLegSpeeed_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  BuildSequenceWME wme__0 = (BuildSequenceWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     ReconWME wme__1 = (ReconWME)wmeIter1.next();
                     if (
                        ( wme__1.getZealotCount() >= 10 )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("CitadelWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              CitadelWME wme__2 = (CitadelWME)wmeIter2.next();
                              if (
                                 BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__2.getID())
                                 &&
                                 ( wme__2.getActive() == true )
                                 &&
                                 ( wme__2.getResearchTimer() == 0 )
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       PlayerWME wme__3 = (PlayerWME)wmeIter3.next();
                                       if (
                                          ( wme__3.getMinerals() >= 150 )
                                          &&
                                          ( wme__3.getGas() >= 150 )
                                       )

                                       {
                                             if (
                                                Logger.print("ABL" , "Forcing Leg Speed Upgrade")
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



            return false;
         }
         case 60: {
            // researchDragoonRange_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  BuildSequenceWME wme__0 = (BuildSequenceWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     ReconWME wme__1 = (ReconWME)wmeIter1.next();
                     if (
                        ( wme__1.getDragoonCount() >= 8 )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                              if (
                                 ( wme__2.getMinerals() >= 150 )
                                 &&
                                 ( wme__2.getGas() >= 150 )
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("CyberneticsCoreWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       CyberneticsCoreWME wme__3 = (CyberneticsCoreWME)wmeIter3.next();
                                       if (
                                          BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__3.getID())
                                          &&
                                          ( wme__3.getActive() == true )
                                          &&
                                          ( wme__3.getResearchTimer() == 0 )
                                       )

                                       {
                                             if (
                                                Logger.print("ABL" , "Forcing Dragoon range Upgrade")
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



            return false;
         }
         case 62: {
            // researchCarrierCapacity_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("CarrierWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  CarrierWME wme__0 = (CarrierWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("FleetBeaconWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           FleetBeaconWME wme__1 = (FleetBeaconWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getID())
                              &&
                              ( wme__1.getActive() == true )
                              &&
                              ( wme__1.getResearchTimer() == 0 )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                                    if (
                                       ( wme__2.getMinerals() >= 100 )
                                       &&
                                       ( wme__2.getGas() >= 100 )
                                    )

                                    {
                                          if (
                                             Logger.print("ABL" , "Forcing carrier capacity Upgrade")
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


            return false;
         }
         case 64: {
            // researchObserverRange_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  BuildSequenceWME wme__0 = (BuildSequenceWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     TimerWME wme__1 = (TimerWME)wmeIter1.next();
                     if (
                        ( wme__1.getFrameCount() > 20000 )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              ReconWME wme__2 = (ReconWME)wmeIter2.next();
                              if (
                                 ( wme__2.getObsCount() >= 2 )
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("ObservatoryWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       ObservatoryWME wme__3 = (ObservatoryWME)wmeIter3.next();
                                       if (
                                          BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__3.getID())
                                          &&
                                          ( wme__3.getActive() == true )
                                          &&
                                          ( wme__3.getResearchTimer() == 0 )
                                       )

                                       {
                                             List wmeList4;
                                             ListIterator wmeIter4;
                                             wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                             wmeIter4 = wmeList4.listIterator();
                                             while(wmeIter4.hasNext()) {
                                                PlayerWME wme__4 = (PlayerWME)wmeIter4.next();
                                                if (
                                                   ( wme__4.getMinerals() >= 150 )
                                                   &&
                                                   ( wme__4.getGas() >= 150 )
                                                )

                                                {
                                                      if (
                                                         Logger.print("ABL" , "Forcing obs range Upgrade")
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

                  }



            return false;
         }
         case 68: {
            // researchObserverSpeed_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     ( wme__0.getMinerals() >= 200 )
                     &&
                     ( wme__0.getGas() >= 200 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ObservatoryWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ObservatoryWME wme__1 = (ObservatoryWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getID())
                              &&
                              ( wme__1.getActive() == true )
                              &&
                              ( wme__1.getResearchTimer() == 0 )
                           )

                           {
                                 if (
                                    Logger.print("ABL" , "Forcing obs range speed")
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
         case 70: {
            // forceObservers_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ReconWME wme__0 = (ReconWME)wmeIter0.next();
                  if (
                     ( wme__0.getEnemyCloaking() == true )
                  )

                  {
                        if (
                           Logger.print("ABL" , "Forcing Observer tech")
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 72: {
            // forceBuildRobo_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ForceObserversWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ForceObserversWME wme__0 = (ForceObserversWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("CyberneticsCoreWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           CyberneticsCoreWME wme__1 = (CyberneticsCoreWME)wmeIter1.next();
                           if (
                              ( wme__1.getActive() == true )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    TimerWME wme__2 = (TimerWME)wmeIter2.next();
                                    if (
                                       ( wme__2.getFrameCount() > 6000 )
                                    )

                                    {
                                          List wmeList3;
                                          ListIterator wmeIter3;
                                          wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("RoboticsFacilityWME");
                                          wmeIter3 = wmeList3.listIterator();
                                          while(wmeIter3.hasNext()) {
                                             RoboticsFacilityWME wme__3 = (RoboticsFacilityWME)wmeIter3.next();
                                             if (
                                                true
                                             )

                                             {
                                                return false;
                                             }

                                          }

                                             List wmeList4;
                                             ListIterator wmeIter4;
                                             wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                                             wmeIter4 = wmeList4.listIterator();
                                             while(wmeIter4.hasNext()) {
                                                ConstructionWME wme__4 = (ConstructionWME)wmeIter4.next();
                                                if (
                                                   ( wme__4.getType() == 155 )
                                                )

                                                {
                                                   return false;
                                                }

                                             }

                                                if (
                                                   Logger.print("ABL" , "Forcing Robotics Facility construction")
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


            return false;
         }
         case 75: {
            // forceBuildObservatory_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ForceObserversWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ForceObserversWME wme__0 = (ForceObserversWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("RoboticsFacilityWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           RoboticsFacilityWME wme__1 = (RoboticsFacilityWME)wmeIter1.next();
                           if (
                              ( wme__1.getActive() == true )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ObservatoryWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    ObservatoryWME wme__2 = (ObservatoryWME)wmeIter2.next();
                                    if (
                                       true
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
                                          ( wme__3.getType() == 159 )
                                       )

                                       {
                                          return false;
                                       }

                                    }

                                       if (
                                          Logger.print("ABL" , "Forcing Observatory")
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
         case 78: {
            // forceBuildObservers_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("UnitRequestWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  UnitRequestWME wme__0 = (UnitRequestWME)wmeIter0.next();
                  if (
                     ( wme__0.getType() == 84 )
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ForceObserversWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     ForceObserversWME wme__1 = (ForceObserversWME)wmeIter1.next();
                     if (
                        true
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                              if (
                                 ( wme__2.getSupplyUsed() < 380 )
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("ObservatoryWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       ObservatoryWME wme__3 = (ObservatoryWME)wmeIter3.next();
                                       if (
                                          ( wme__3.getActive() == true )
                                       )

                                       {
                                             List wmeList4;
                                             ListIterator wmeIter4;
                                             wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                                             wmeIter4 = wmeList4.listIterator();
                                             while(wmeIter4.hasNext()) {
                                                ReconWME wme__4 = (ReconWME)wmeIter4.next();
                                                if (
                                                   ( wme__4.getNumObs() < 2 )
                                                )

                                                {
                                                      List wmeList5;
                                                      ListIterator wmeIter5;
                                                      wmeList5 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
                                                      wmeIter5 = wmeList5.listIterator();
                                                      while(wmeIter5.hasNext()) {
                                                         TrainUnitWME wme__5 = (TrainUnitWME)wmeIter5.next();
                                                         if (
                                                            ( wme__5.getType() == 84 )
                                                         )

                                                         {
                                                            return false;
                                                         }

                                                      }

                                                         if (
                                                            Logger.print("ABL" , "Forcing Observer")
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

                  }



            return false;
         }
         case 84: {
            // pickScout_1Step2
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ReconWME wme__0 = (ReconWME)wmeIter0.next();
                  __$behaviorFrame[1] = wme__0;
                  if (
                     true
                  )

                  {
                        if (
                           ((ReconWME)__$behaviorFrame[1]).startScouting()
                        )

                        {
                              List wmeList2;
                              ListIterator wmeIter2;
                              wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ParticleWME");
                              wmeIter2 = wmeList2.listIterator();
                              while(wmeIter2.hasNext()) {
                                 ParticleWME wme__2 = (ParticleWME)wmeIter2.next();
                                 if (
                                    ( wme__2.getTypeID() != 42 )
                                    &&
                                    ( wme__2.getTypeID() != 41 )
                                    &&
                                    ( wme__2.getTypeID() != 64 )
                                    &&
                                    ( wme__2.getTypeID() != 7 )
                                 )

                                 {
                                    return false;
                                 }

                              }

                                 List wmeList3;
                                 ListIterator wmeIter3;
                                 wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
                                 wmeIter3 = wmeList3.listIterator();
                                 while(wmeIter3.hasNext()) {
                                    ProbeWME wme__3 = (ProbeWME)wmeIter3.next();
                                    __$behaviorFrame[0] = wme__3;
                                    if (
                                       ( wme__3.getActive() == true )
                                       &&
                                       ( wme__3.getTask() == 1 )
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__3.getID())
                                       &&
                                       ( wme__3.getCarryingMinerals() == false )
                                    )

                                    {
                                          if (
                                             Logger.print("ABL" , "Picked worker")
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
         case 91: {
            // workerScout_1Step5
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  if (
                     ( wme__0.getID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                     &&
                     ( wme__0.getOrder() == 3 )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 95: {
            // workerScout_2Step4
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  if (
                     ( wme__0.getID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                     &&
                     ( wme__0.getOrder() == 3 )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 96: {
            // scoutFlee_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getTask() == 4 )
                     &&
                     ( wme__0.getTakenDamage() == true )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getID())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__0.getTargetX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[7]).i = wme__0.getTargetY())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           NexusWME wme__1 = (NexusWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__1.getY())
                           )

                           {
                                 if (
                                    Logger.print("ABL" , "Scout fleeing")
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
         case 105: {
            // preventSupplyLock_1Step1
            int supplyTotal;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ConstructionWME wme__0 = (ConstructionWME)wmeIter0.next();
                  if (
                     ( wme__0.getType() == 156 )
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PylonWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     PylonWME wme__1 = (PylonWME)wmeIter1.next();
                     if (
                        ( wme__1.getActive() == false )
                     )

                     {
                        return false;
                     }

                  }

                     List wmeList2;
                     ListIterator wmeIter2;
                     wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                     wmeIter2 = wmeList2.listIterator();
                     while(wmeIter2.hasNext()) {
                        PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                        if (
                           BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getSupplyUsed())
                           &&
                           BehavingEntity.constantTrue(supplyTotal = wme__2.getSupplyTotal())
                           &&
                           BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__2.getRaceID())
                           &&
                           ( wme__2.getSupplyTotal() < 400 )
                        )

                        {
                              if (
                                 ((supplyTotal < 66) &&(((__ValueTypes.IntVar)__$behaviorFrame[1]).i >= 42)) ||((supplyTotal >= 66) &&(((__ValueTypes.IntVar)__$behaviorFrame[1]).i >= 0.8 * supplyTotal))
                              )

                              {
                                 return true;
                              }


                        }

                     }




            return false;
         }
         case 108: {
            // preventStalledSupply_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ConstructionWME wme__0 = (ConstructionWME)wmeIter0.next();
                  if (
                     ( wme__0.getType() == 156 )
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PylonWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     PylonWME wme__1 = (PylonWME)wmeIter1.next();
                     if (
                        ( wme__1.getActive() == false )
                     )

                     {
                        return false;
                     }

                  }

                     List wmeList2;
                     ListIterator wmeIter2;
                     wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                     wmeIter2 = wmeList2.listIterator();
                     while(wmeIter2.hasNext()) {
                        PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                        if (
                           ( wme__2.getMinerals() >= 250 )
                           &&
                           BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getSupplyUsed())
                           &&
                           BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__2.getSupplyTotal())
                        )

                        {
                              if (
                                 ((__ValueTypes.IntVar)__$behaviorFrame[1]).i + 4 > ((__ValueTypes.IntVar)__$behaviorFrame[2]).i
                              )

                              {
                                 return true;
                              }


                        }

                     }




            return false;
         }
         case 114: {
            // getNextBuildStep_1Step2
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("UnitRequestWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  UnitRequestWME wme__0 = (UnitRequestWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ResearchRequestWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     ResearchRequestWME wme__1 = (ResearchRequestWME)wmeIter1.next();
                     if (
                        true
                     )

                     {
                        return false;
                     }

                  }

                     List wmeList2;
                     ListIterator wmeIter2;
                     wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("BuildingRequestWME");
                     wmeIter2 = wmeList2.listIterator();
                     while(wmeIter2.hasNext()) {
                        BuildingRequestWME wme__2 = (BuildingRequestWME)wmeIter2.next();
                        if (
                           true
                        )

                        {
                           return false;
                        }

                     }

                        List wmeList3;
                        ListIterator wmeIter3;
                        wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
                        wmeIter3 = wmeList3.listIterator();
                        while(wmeIter3.hasNext()) {
                           TrainUnitWME wme__3 = (TrainUnitWME)wmeIter3.next();
                           if (
                              true
                           )

                           {
                              return false;
                           }

                        }

                           List wmeList4;
                           ListIterator wmeIter4;
                           wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                           wmeIter4 = wmeList4.listIterator();
                           while(wmeIter4.hasNext()) {
                              ConstructionWME wme__4 = (ConstructionWME)wmeIter4.next();
                              if (
                                 true
                              )

                              {
                                 return false;
                              }

                           }

                              List wmeList5;
                              ListIterator wmeIter5;
                              wmeList5 = BehavingEntity.getBehavingEntity().lookupWME("ArchonRequestWME");
                              wmeIter5 = wmeList5.listIterator();
                              while(wmeIter5.hasNext()) {
                                 ArchonRequestWME wme__5 = (ArchonRequestWME)wmeIter5.next();
                                 if (
                                    true
                                 )

                                 {
                                    return false;
                                 }

                              }

                                 List wmeList6;
                                 ListIterator wmeIter6;
                                 wmeList6 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
                                 wmeIter6 = wmeList6.listIterator();
                                 while(wmeIter6.hasNext()) {
                                    BuildSequenceWME wme__6 = (BuildSequenceWME)wmeIter6.next();
                                    __$behaviorFrame[0] = wme__6;
                                    if (
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__6.getSupplyReq())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__6.getMineralReq())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__6.getGasReq())
                                    )

                                    {
                                          List wmeList7;
                                          ListIterator wmeIter7;
                                          wmeList7 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                          wmeIter7 = wmeList7.listIterator();
                                          while(wmeIter7.hasNext()) {
                                             PlayerWME wme__7 = (PlayerWME)wmeIter7.next();
                                             if (
                                                BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__7.getSupplyUsed())
                                                &&
                                                BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__7.getMinerals())
                                                &&
                                                BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[7]).i = wme__7.getGas())
                                             )

                                             {
                                                   if (
                                                      ((__ValueTypes.IntVar)__$behaviorFrame[2]).i >=(2 * ((__ValueTypes.IntVar)__$behaviorFrame[3]).i) || ((__ValueTypes.IntVar)__$behaviorFrame[2]).i >= ((EISBot)__$thisEntity).maxSupplyReq ||(((__ValueTypes.IntVar)__$behaviorFrame[6]).i >=(((__ValueTypes.IntVar)__$behaviorFrame[4]).i + 50) && ((__ValueTypes.IntVar)__$behaviorFrame[7]).i >= ((__ValueTypes.IntVar)__$behaviorFrame[5]).i)
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
         case 125: {
            // processUnitRequests_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("UnitRequestWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  UnitRequestWME wme__0 = (UnitRequestWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getType())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getProducedAtType())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getReq1())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__0.getReq2())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__0.getSupplyRequired())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__1.getSupplyUsed())
                           )

                           {
                                 if (
                                    (((__ValueTypes.IntVar)__$behaviorFrame[6]).i + ((__ValueTypes.IntVar)__$behaviorFrame[5]).i) <= 400
                                 )

                                 {
                                       if (
                                          Logger.print("CBR" , "Processing unit request: " + ((__ValueTypes.IntVar)__$behaviorFrame[1]).i)
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
         case 131: {
            // handleUnitRequest_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TrainUnitWME wme__0 = (TrainUnitWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

               return true;

         }
         case 133: {
            // handleUnitRequest_2Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TrainUnitWME wme__0 = (TrainUnitWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     PlayerUnitWME wme__1 = (PlayerUnitWME)wmeIter1.next();
                     if (
                        ( wme__1.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                        &&
                        ( wme__1.getActive() == true )
                     )

                     {
                        return true;
                     }

                  }



            return false;
         }
         case 135: {
            // handleUnitRequest_3Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TrainUnitWME wme__0 = (TrainUnitWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

               return true;

         }
         case 137: {
            // handleUnitRequest_4Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TrainUnitWME wme__0 = (TrainUnitWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     PlayerUnitWME wme__1 = (PlayerUnitWME)wmeIter1.next();
                     if (
                        ( wme__1.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                        &&
                        ( wme__1.getActive() == true )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerUnitWME wme__2 = (PlayerUnitWME)wmeIter2.next();
                              if (
                                 ( wme__2.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[2]).i )
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
         case 139: {
            // handleUnitRequest_5Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TrainUnitWME wme__0 = (TrainUnitWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

               return true;

         }
         case 141: {
            // handleUnitRequest_6Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TrainUnitWME wme__0 = (TrainUnitWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     PlayerUnitWME wme__1 = (PlayerUnitWME)wmeIter1.next();
                     if (
                        ( wme__1.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                        &&
                        ( wme__1.getActive() == true )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerUnitWME wme__2 = (PlayerUnitWME)wmeIter2.next();
                              if (
                                 ( wme__2.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[2]).i )
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
                                          ( wme__3.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[3]).i )
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
         case 143: {
            // processBuildingRequests_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("BuildingRequestWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  BuildingRequestWME wme__0 = (BuildingRequestWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getType())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getUnitReq())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getSecondUnitReq())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ConstructionWME wme__1 = (ConstructionWME)wmeIter1.next();
                           if (
                              ( wme__1.getType() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                           )

                           {
                              return false;
                           }

                        }

                           if (
                              Logger.print("ABL" , "Processing building request: " + ((__ValueTypes.IntVar)__$behaviorFrame[1]).i)
                           )

                           {
                              return true;
                           }



                  }

               }


            return false;
         }
         case 150: {
            // handleBuildingRequest_3Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerUnitWME wme__0 = (PlayerUnitWME)wmeIter0.next();
                  if (
                     ( wme__0.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                     &&
                     ( wme__0.getActive() == true )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 153: {
            // processResearchRequests_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ResearchRequestWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ResearchRequestWME wme__0 = (ResearchRequestWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getType())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.BooleanVar)__$behaviorFrame[3]).b = wme__0.getIsUpgrade())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getResearchedAtType())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__0.getMineralsCost())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__0.getGasCost())
                  )

                  {
                        if (
                           Logger.print("CBR" , "Processed research request: " + ((__ValueTypes.IntVar)__$behaviorFrame[1]).i)
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 158: {
            // handleResearchRequest_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     ( wme__0.getMinerals() >= ((__ValueTypes.IntVar)__$behaviorFrame[3]).i )
                     &&
                     ( wme__0.getGas() >= ((__ValueTypes.IntVar)__$behaviorFrame[4]).i )
                  )

                  {
                        if (
                           Logger.print("CBR" , "Approved research request")
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 160: {
            // handleResearchRequest_2Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     ( wme__0.getMinerals() >= ((__ValueTypes.IntVar)__$behaviorFrame[3]).i )
                     &&
                     ( wme__0.getGas() >= ((__ValueTypes.IntVar)__$behaviorFrame[4]).i )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerUnitWME wme__1 = (PlayerUnitWME)wmeIter1.next();
                           __$behaviorFrame[5] = wme__1;
                           if (
                              ( wme__1.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[2]).i )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__1.getID())
                              &&
                              ( wme__1.getActive() == true )
                           )

                           {
                                 if (
                                    ((PlayerUnitWME)__$behaviorFrame[5]).getBuildTimer() == 0 && ((PlayerUnitWME)__$behaviorFrame[5]).getResearchTimer() == 0
                                 )

                                 {
                                       if (
                                          Logger.print("CBR" , "Approved research request")
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
         case 162: {
            // handleResearchRequest_3Step1
               if (
                  ((PlayerUnitWME)__$behaviorFrame[6]).getBuildTimer() == 0 && ((PlayerUnitWME)__$behaviorFrame[6]).getResearchTimer() == 0
               )

               {
                     if (
                        Logger.print("CBR" , "Approved research request")
                     )

                     {
                        return true;
                     }


               }


            return false;
         }
         case 164: {
            // handleResearchRequest_4Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     ( wme__0.getMinerals() >= ((__ValueTypes.IntVar)__$behaviorFrame[3]).i )
                     &&
                     ( wme__0.getGas() >= ((__ValueTypes.IntVar)__$behaviorFrame[4]).i )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerUnitWME wme__1 = (PlayerUnitWME)wmeIter1.next();
                           __$behaviorFrame[5] = wme__1;
                           if (
                              ( wme__1.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[2]).i )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__1.getID())
                              &&
                              ( wme__1.getActive() == true )
                           )

                           {
                                 if (
                                    ((PlayerUnitWME)__$behaviorFrame[5]).getBuildTimer() == 0 && ((PlayerUnitWME)__$behaviorFrame[5]).getResearchTimer() == 0
                                 )

                                 {
                                       if (
                                          Logger.print("CBR" , "Approved research request")
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
         case 166: {
            // processArchonRequests_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ArchonRequestWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ArchonRequestWME wme__0 = (ArchonRequestWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     true
                  )

                  {
                        if (
                           Logger.print("CBR" , "Got archon request")
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 173: {
            // handleArchonRequest_2Step1
            int y2;
            int x1;
            int x2;
            int y1;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("HighTemplarWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  HighTemplarWME wme__0 = (HighTemplarWME)wmeIter0.next();
                  __$behaviorFrame[1] = wme__0;
                  if (
                     ( wme__0.getActive() == true )
                     &&
                     ( wme__0.getMerged() == false )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getID())
                     &&
                     BehavingEntity.constantTrue(x1 = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(y1 = wme__0.getY())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("HighTemplarWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           HighTemplarWME wme__1 = (HighTemplarWME)wmeIter1.next();
                           __$behaviorFrame[2] = wme__1;
                           if (
                              ( wme__1.getActive() == true )
                              &&
                              ( wme__1.getMerged() == false )
                              &&
                              ( wme__1.getID() != ((__ValueTypes.IntVar)__$behaviorFrame[3]).i )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__1.getID())
                              &&
                              BehavingEntity.constantTrue(x2 = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(y2 = wme__1.getY())
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
                                          return true;
                                       }


                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 182: {
            // limitQueueSize_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("UnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  UnitWME wme__0 = (UnitWME)wmeIter0.next();
                  if (
                     ( wme__0.getTrainingQueueSize() > 1 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 188: {
            // produceObservers_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TrainUnitWME wme__0 = (TrainUnitWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getType() == 84 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              ( wme__1.getMinerals() >= 25 )
                              &&
                              ( wme__1.getGas() >= 75 )
                              &&
                              ( wme__1.getSupplyUsed() < 400 )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("RoboticsFacilityWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    RoboticsFacilityWME wme__2 = (RoboticsFacilityWME)wmeIter2.next();
                                    if (
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getID())
                                       &&
                                       ( wme__2.getTrainTimer() == 0 )
                                       &&
                                       ( wme__2.getBuildTimer() == 0 )
                                       &&
                                       ( wme__2.getActive() == true )
                                       &&
                                       ( wme__2.getTrainingQueueSize() == 0 )
                                    )

                                    {
                                          List wmeList3;
                                          ListIterator wmeIter3;
                                          wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                                          wmeIter3 = wmeList3.listIterator();
                                          while(wmeIter3.hasNext()) {
                                             ConstructionWME wme__3 = (ConstructionWME)wmeIter3.next();
                                             if (
                                                ( wme__3.getResourcesClaimed() == false )
                                             )

                                             {
                                                return false;
                                             }

                                          }

                                          return true;

                                    }

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 192: {
            // produceUnits_1Step1
            int supplyUsed;
            int supplyCost;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TrainUnitWME wme__0 = (TrainUnitWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getMineralCost())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getGasCost())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__0.getType())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__0.getWhatBuilds())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__0.getBuilder())
                     &&
                     BehavingEntity.constantTrue(supplyCost = wme__0.getSupplyCost())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              ( wme__1.getMinerals() >= ((__ValueTypes.IntVar)__$behaviorFrame[2]).i )
                              &&
                              ( wme__1.getGas() >= ((__ValueTypes.IntVar)__$behaviorFrame[3]).i )
                              &&
                              BehavingEntity.constantTrue(supplyUsed = wme__1.getSupplyUsed())
                           )

                           {
                                 if (
                                    (supplyCost + supplyUsed) <= 400
                                 )

                                 {
                                       List wmeList3;
                                       ListIterator wmeIter3;
                                       wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                                       wmeIter3 = wmeList3.listIterator();
                                       while(wmeIter3.hasNext()) {
                                          PlayerUnitWME wme__3 = (PlayerUnitWME)wmeIter3.next();
                                          if (
                                             ( wme__3.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[5]).i )
                                             &&
                                             BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__3.getID())
                                             &&
                                             ( wme__3.getTrainTimer() == 0 )
                                             &&
                                             ( wme__3.getBuildTimer() == 0 )
                                             &&
                                             ( wme__3.getActive() == true )
                                             &&
                                             ( wme__3.getTrainingQueueSize() == 0 )
                                          )

                                          {
                                                if (
                                                   ((__ValueTypes.IntVar)__$behaviorFrame[6]).i == -1 || ((__ValueTypes.IntVar)__$behaviorFrame[6]).i == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i
                                                )

                                                {
                                                      List wmeList5;
                                                      ListIterator wmeIter5;
                                                      wmeList5 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                                                      wmeIter5 = wmeList5.listIterator();
                                                      while(wmeIter5.hasNext()) {
                                                         ConstructionWME wme__5 = (ConstructionWME)wmeIter5.next();
                                                         if (
                                                            ( wme__5.getResourcesClaimed() == false )
                                                         )

                                                         {
                                                            return false;
                                                         }

                                                      }

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
         case 196: {
            // produceUnitsNow_1Step1
            int supplyUsed;
            int supplyCost;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TrainUnitWME wme__0 = (TrainUnitWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getMineralCost())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getGasCost())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__0.getType())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__0.getWhatBuilds())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__0.getBuilder())
                     &&
                     BehavingEntity.constantTrue(supplyCost = wme__0.getSupplyCost())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              ( wme__1.getMinerals() > 600 )
                              &&
                              ( wme__1.getGas() >= ((__ValueTypes.IntVar)__$behaviorFrame[3]).i )
                              &&
                              BehavingEntity.constantTrue(supplyUsed = wme__1.getSupplyUsed())
                           )

                           {
                                 if (
                                    (supplyCost + supplyUsed) <= 400
                                 )

                                 {
                                       List wmeList3;
                                       ListIterator wmeIter3;
                                       wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
                                       wmeIter3 = wmeList3.listIterator();
                                       while(wmeIter3.hasNext()) {
                                          PlayerUnitWME wme__3 = (PlayerUnitWME)wmeIter3.next();
                                          if (
                                             ( wme__3.getTypeID() == ((__ValueTypes.IntVar)__$behaviorFrame[5]).i )
                                             &&
                                             BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__3.getID())
                                             &&
                                             ( wme__3.getTrainTimer() == 0 )
                                             &&
                                             ( wme__3.getBuildTimer() == 0 )
                                             &&
                                             ( wme__3.getActive() == true )
                                             &&
                                             ( wme__3.getTrainingQueueSize() == 0 )
                                          )

                                          {
                                                if (
                                                   ((__ValueTypes.IntVar)__$behaviorFrame[6]).i == -1 || ((__ValueTypes.IntVar)__$behaviorFrame[6]).i == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i
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
         case 217: {
            // detectIdleGasWorkers_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getTask() == 2 )
                     &&
                     ( wme__0.getOrder() == 3 )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 220: {
            // detectIdleConstructors_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getTask() == 3 )
                     &&
                     ( wme__0.getOrder() == 3 )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 223: {
            // clearMineralBlocks_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     ( wme__0.getSupplyUsed() >= 100 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("MineralWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           MineralWME wme__1 = (MineralWME)wmeIter1.next();
                           if (
                              ( wme__1.getResources() == 0 )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getID())
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    ProbeWME wme__2 = (ProbeWME)wmeIter2.next();
                                    __$behaviorFrame[2] = wme__2;
                                    if (
                                       ( wme__2.getTask() == 1 )
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__2.getID())
                                       &&
                                       ( wme__2.getCarryingMinerals() == false )
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
         case 227: {
            // clearMineralBlocks_1Step5
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("MineralWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  MineralWME wme__0 = (MineralWME)wmeIter0.next();
                  if (
                     ( wme__0.getResources() == 0 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getID())
                  )

                  {
                     return false;
                  }

               }

               return true;

         }
         case 229: {
            // forceAssimilator_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("AssimilatorWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  AssimilatorWME wme__0 = (AssimilatorWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                     if (
                        ( wme__1.getSupplyUsed() >= 40 )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              ConstructionWME wme__2 = (ConstructionWME)wmeIter2.next();
                              if (
                                 ( wme__2.getType() == 157 )
                              )

                              {
                                 return false;
                              }

                           }

                           return true;

                     }

                  }



            return false;
         }
         case 232: {
            // pumpProbesBuildOrder_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  BuildSequenceWME wme__0 = (BuildSequenceWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getSupplyReq())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ReconWME wme__1 = (ReconWME)wmeIter1.next();
                           if (
                              ( wme__1.getNumProbes() < ((EISBot)__$thisEntity).maxProbes )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("UnitRequestWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    UnitRequestWME wme__2 = (UnitRequestWME)wmeIter2.next();
                                    if (
                                       true
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
                                          true
                                       )

                                       {
                                          return false;
                                       }

                                    }

                                       List wmeList4;
                                       ListIterator wmeIter4;
                                       wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("TrainUnitWME");
                                       wmeIter4 = wmeList4.listIterator();
                                       while(wmeIter4.hasNext()) {
                                          TrainUnitWME wme__4 = (TrainUnitWME)wmeIter4.next();
                                          if (
                                             true
                                          )

                                          {
                                             return false;
                                          }

                                       }

                                          List wmeList5;
                                          ListIterator wmeIter5;
                                          wmeList5 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                          wmeIter5 = wmeList5.listIterator();
                                          while(wmeIter5.hasNext()) {
                                             PlayerWME wme__5 = (PlayerWME)wmeIter5.next();
                                             if (
                                                ( wme__5.getMinerals() >= 50 )
                                                &&
                                                BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__5.getSupplyUsed())
                                                &&
                                                BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__5.getSupplyTotal())
                                             )

                                             {
                                                   if (
                                                      ((__ValueTypes.IntVar)__$behaviorFrame[1]).i < ((__ValueTypes.IntVar)__$behaviorFrame[2]).i
                                                   )

                                                   {
                                                         if (
                                                            ((__ValueTypes.IntVar)__$behaviorFrame[1]).i <(2 * ((__ValueTypes.IntVar)__$behaviorFrame[0]).i) || ((__ValueTypes.IntVar)__$behaviorFrame[0]).i >= ((EISBot)__$thisEntity).maxSupplyReq
                                                         )

                                                         {
                                                               List wmeList8;
                                                               ListIterator wmeIter8;
                                                               wmeList8 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                                                               wmeIter8 = wmeList8.listIterator();
                                                               while(wmeIter8.hasNext()) {
                                                                  NexusWME wme__8 = (NexusWME)wmeIter8.next();
                                                                  if (
                                                                     ( wme__8.getNumWorkers() < ((EISBot)__$thisEntity).workersPerNexus )
                                                                     &&
                                                                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__8.getID())
                                                                     &&
                                                                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__8.getX())
                                                                     &&
                                                                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__8.getY())
                                                                     &&
                                                                     ( wme__8.getTrainTimer() == 0 )
                                                                     &&
                                                                     ( wme__8.getBuildTimer() == 0 )
                                                                     &&
                                                                     ( wme__8.getActive() == true )
                                                                  )

                                                                  {
                                                                        List wmeList9;
                                                                        ListIterator wmeIter9;
                                                                        wmeList9 = BehavingEntity.getBehavingEntity().lookupWME("MineralWME");
                                                                        wmeIter9 = wmeList9.listIterator();
                                                                        while(wmeIter9.hasNext()) {
                                                                           MineralWME wme__9 = (MineralWME)wmeIter9.next();
                                                                           if (
                                                                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__9.getX())
                                                                              &&
                                                                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[7]).i = wme__9.getY())
                                                                           )

                                                                           {
                                                                                 if (
                                                                                    Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[4]).i - ((__ValueTypes.IntVar)__$behaviorFrame[6]).i) < 10 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[5]).i - ((__ValueTypes.IntVar)__$behaviorFrame[7]).i) < 10
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

                                          }





                           }

                        }


                  }

               }


            return false;
         }
         case 235: {
            // pumpProbesExcess_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  BuildSequenceWME wme__0 = (BuildSequenceWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getSupplyReq())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ReconWME wme__1 = (ReconWME)wmeIter1.next();
                           if (
                              ( wme__1.getNumProbes() < ((EISBot)__$thisEntity).maxProbes )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                                    if (
                                       ( wme__2.getMinerals() >= 250 )
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getSupplyUsed())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__2.getSupplyTotal())
                                    )

                                    {
                                          if (
                                             ((__ValueTypes.IntVar)__$behaviorFrame[1]).i < ((__ValueTypes.IntVar)__$behaviorFrame[2]).i
                                          )

                                          {
                                                if (
                                                   ((__ValueTypes.IntVar)__$behaviorFrame[1]).i <(2 * ((__ValueTypes.IntVar)__$behaviorFrame[0]).i) || ((__ValueTypes.IntVar)__$behaviorFrame[0]).i >= ((EISBot)__$thisEntity).maxSupplyReq
                                                )

                                                {
                                                      List wmeList5;
                                                      ListIterator wmeIter5;
                                                      wmeList5 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                                                      wmeIter5 = wmeList5.listIterator();
                                                      while(wmeIter5.hasNext()) {
                                                         NexusWME wme__5 = (NexusWME)wmeIter5.next();
                                                         if (
                                                            ( wme__5.getNumWorkers() < ((EISBot)__$thisEntity).workersPerNexus )
                                                            &&
                                                            BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__5.getID())
                                                            &&
                                                            BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__5.getX())
                                                            &&
                                                            BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__5.getY())
                                                            &&
                                                            ( wme__5.getTrainTimer() == 0 )
                                                            &&
                                                            ( wme__5.getBuildTimer() == 0 )
                                                            &&
                                                            ( wme__5.getActive() == true )
                                                         )

                                                         {
                                                               List wmeList6;
                                                               ListIterator wmeIter6;
                                                               wmeList6 = BehavingEntity.getBehavingEntity().lookupWME("MineralWME");
                                                               wmeIter6 = wmeList6.listIterator();
                                                               while(wmeIter6.hasNext()) {
                                                                  MineralWME wme__6 = (MineralWME)wmeIter6.next();
                                                                  if (
                                                                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__6.getX())
                                                                     &&
                                                                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[7]).i = wme__6.getY())
                                                                  )

                                                                  {
                                                                        if (
                                                                           Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[4]).i - ((__ValueTypes.IntVar)__$behaviorFrame[6]).i) < 10 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[5]).i - ((__ValueTypes.IntVar)__$behaviorFrame[7]).i) < 10
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

                                 }


                           }

                        }


                  }

               }


            return false;
         }
         case 238: {
            // pumpProbesCBR_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("BuildSequenceWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  BuildSequenceWME wme__0 = (BuildSequenceWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     ReconWME wme__1 = (ReconWME)wmeIter1.next();
                     if (
                        ( wme__1.getNumProbes() < ((EISBot)__$thisEntity).maxProbes )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              PlayerWME wme__2 = (PlayerWME)wmeIter2.next();
                              if (
                                 ( wme__2.getMinerals() >= 50 )
                                 &&
                                 BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getSupplyUsed())
                                 &&
                                 BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__2.getSupplyTotal())
                              )

                              {
                                    if (
                                       ((__ValueTypes.IntVar)__$behaviorFrame[1]).i < ((__ValueTypes.IntVar)__$behaviorFrame[2]).i
                                    )

                                    {
                                          List wmeList4;
                                          ListIterator wmeIter4;
                                          wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                                          wmeIter4 = wmeList4.listIterator();
                                          while(wmeIter4.hasNext()) {
                                             NexusWME wme__4 = (NexusWME)wmeIter4.next();
                                             if (
                                                ( wme__4.getNumWorkers() < ((EISBot)__$thisEntity).workersPerNexus )
                                                &&
                                                BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__4.getID())
                                                &&
                                                BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__4.getX())
                                                &&
                                                BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__4.getY())
                                                &&
                                                ( wme__4.getTrainTimer() == 0 )
                                                &&
                                                ( wme__4.getBuildTimer() == 0 )
                                                &&
                                                ( wme__4.getActive() == true )
                                             )

                                             {
                                                   List wmeList5;
                                                   ListIterator wmeIter5;
                                                   wmeList5 = BehavingEntity.getBehavingEntity().lookupWME("MineralWME");
                                                   wmeIter5 = wmeList5.listIterator();
                                                   while(wmeIter5.hasNext()) {
                                                      MineralWME wme__5 = (MineralWME)wmeIter5.next();
                                                      if (
                                                         BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__5.getX())
                                                         &&
                                                         BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[7]).i = wme__5.getY())
                                                      )

                                                      {
                                                            if (
                                                               Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[4]).i - ((__ValueTypes.IntVar)__$behaviorFrame[6]).i) < 10 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[5]).i - ((__ValueTypes.IntVar)__$behaviorFrame[7]).i) < 10
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


                     }

                  }



            return false;
         }
         case 241: {
            // additionalAssimilators_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("AssimilatorWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  AssimilatorWME wme__0 = (AssimilatorWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ConstructionWME wme__1 = (ConstructionWME)wmeIter1.next();
                           if (
                              ( wme__1.getType() == 157 )
                           )

                           {
                              return false;
                           }

                        }

                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              NexusWME wme__2 = (NexusWME)wmeIter2.next();
                              if (
                                 ( wme__2.getNumWorkers() >= 10 )
                                 &&
                                 BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__2.getX())
                                 &&
                                 BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getY())
                              )

                              {
                                    List wmeList3;
                                    ListIterator wmeIter3;
                                    wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("GeyserWME");
                                    wmeIter3 = wmeList3.listIterator();
                                    while(wmeIter3.hasNext()) {
                                       GeyserWME wme__3 = (GeyserWME)wmeIter3.next();
                                       if (
                                          BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__3.getX())
                                          &&
                                          BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__3.getY())
                                       )

                                       {
                                             if (
                                                Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[0]).i - ((__ValueTypes.IntVar)__$behaviorFrame[2]).i) < 10 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[1]).i - ((__ValueTypes.IntVar)__$behaviorFrame[3]).i) < 10
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


            return false;
         }
         case 244: {
            // pullOffGas_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getGas())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getSupplyUsed())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ReconWME wme__1 = (ReconWME)wmeIter1.next();
                           if (
                              ( wme__1.getNumAssimilators() <= 1 )
                           )

                           {
                                 if (
                                    ((__ValueTypes.IntVar)__$behaviorFrame[1]).i >= 300
                                 )

                                 {
                                       List wmeList3;
                                       ListIterator wmeIter3;
                                       wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("AssimilatorWME");
                                       wmeIter3 = wmeList3.listIterator();
                                       while(wmeIter3.hasNext()) {
                                          AssimilatorWME wme__3 = (AssimilatorWME)wmeIter3.next();
                                          __$behaviorFrame[0] = wme__3;
                                          if (
                                             ( wme__3.getTargetWorkers() >= 3 )
                                          )

                                          {
                                                if (
                                                   Logger.print("ABL" , "Pulling worker off gas")
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
         case 247: {
            // pullOffGasDefense_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("AssimilatorWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  AssimilatorWME wme__0 = (AssimilatorWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getTargetWorkers() > 0 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getY())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ReconWME wme__1 = (ReconWME)wmeIter1.next();
                           if (
                              ( wme__1.getMyNexusCount() <= 1 )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    EnemyUnitWME wme__2 = (EnemyUnitWME)wmeIter2.next();
                                    if (
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__2.getX())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__2.getY())
                                       &&
                                       ( wme__2.getIsWorker() == false )
                                       &&
                                       ( wme__2.getIsFlyer() == false )
                                    )

                                    {
                                          if (
                                             Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[3]).i - ((__ValueTypes.IntVar)__$behaviorFrame[1]).i) <= 8 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[4]).i - ((__ValueTypes.IntVar)__$behaviorFrame[2]).i) <= 8
                                          )

                                          {
                                                if (
                                                   Logger.print("ABL" , "Pulling worker off gas for DEFENSE")
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
         case 251: {
            // putOnGas_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     ( wme__0.getGas() <= 200 )
                     &&
                     ( wme__0.getSupplyUsed() >= 20 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("GasHoldWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           GasHoldWME wme__1 = (GasHoldWME)wmeIter1.next();
                           if (
                              true
                           )

                           {
                              return false;
                           }

                        }

                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("AssimilatorWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              AssimilatorWME wme__2 = (AssimilatorWME)wmeIter2.next();
                              __$behaviorFrame[0] = wme__2;
                              if (
                                 ( wme__2.getTargetWorkers() < 3 )
                              )

                              {
                                    if (
                                       Logger.print("ABL" , "Putting worker on gas")
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
         case 254: {
            // manageWorkerHarass_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  __$behaviorFrame[7] = wme__0;
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getID())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__0.getOrderTarget())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getTask())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getY())
                  )

                  {
                        if (
                           ((__ValueTypes.IntVar)__$behaviorFrame[3]).i == WORKER_MINE
                        )

                        {
                              List wmeList2;
                              ListIterator wmeIter2;
                              wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                              wmeIter2 = wmeList2.listIterator();
                              while(wmeIter2.hasNext()) {
                                 EnemyUnitWME wme__2 = (EnemyUnitWME)wmeIter2.next();
                                 if (
                                    ( wme__2.getOrderTarget() == ((__ValueTypes.IntVar)__$behaviorFrame[2]).i )
                                    &&
                                    BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__2.getX())
                                    &&
                                    BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__2.getY())
                                    &&
                                    BehavingEntity.constantTrue(((__ValueTypes.BooleanVar)__$behaviorFrame[9]).b = wme__2.getIsWorker())
                                    &&
                                    ( wme__2.getIsFlyer() == false )
                                 )

                                 {
                                       List wmeList3;
                                       ListIterator wmeIter3;
                                       wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                                       wmeIter3 = wmeList3.listIterator();
                                       while(wmeIter3.hasNext()) {
                                          ReconWME wme__3 = (ReconWME)wmeIter3.next();
                                          if (
                                             ( wme__3.getMyNexusCount() <= 1 )
                                          )

                                          {
                                                if (
                                                   Logger.print("ABL" , "Dealing with harass")
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
         case 260: {
            // manageBaseHarass_1Step1
            NexusWME worker;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  NexusWME wme__0 = (NexusWME)wmeIter0.next();
                  worker = wme__0;
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getY())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getID())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           EnemyUnitWME wme__1 = (EnemyUnitWME)wmeIter1.next();
                           if (
                              ( wme__1.getOrderTarget() == ((__ValueTypes.IntVar)__$behaviorFrame[2]).i )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__1.getY())
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    ReconWME wme__2 = (ReconWME)wmeIter2.next();
                                    if (
                                       ( wme__2.getMyNexusCount() <= 1 )
                                    )

                                    {
                                          if (
                                             Logger.print("ABL" , "Dealing with base harass")
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


            return false;
         }
         case 277: {
            // probeTransfer_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  NexusWME wme__0 = (NexusWME)wmeIter0.next();
                  __$behaviorFrame[3] = wme__0;
                  if (
                     ( wme__0.getActive() == false )
                     &&
                     ( wme__0.getBuildTimer() < 200 )
                     &&
                     ( wme__0.getBuildTimer() > 150 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getY())
                  )

                  {
                        if (
                           Logger.print("ABL" , "Trasferring workers")
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 283: {
            // mineMinerals_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  __$behaviorFrame[3] = wme__0;
                  if (
                     ( wme__0.getTask() == 0 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getY())
                     &&
                     ( wme__0.getActive() == true )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 290: {
            // gasTransfer_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("AssimilatorWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  AssimilatorWME wme__0 = (AssimilatorWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getActive() == true )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__0.getNumWorkers())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__0.getTargetWorkers())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getY())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getID())
                  )

                  {
                        if (
                           ((__ValueTypes.IntVar)__$behaviorFrame[4]).i != ((__ValueTypes.IntVar)__$behaviorFrame[5]).i
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 297: {
            // checkMinedOut_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ProbeWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ProbeWME wme__0 = (ProbeWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getTask() == 1 )
                     &&
                     ( wme__0.getOrder() == 3 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getID())
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 304: {
            // waitForConstructionRequest_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ConstructionWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ConstructionWME wme__0 = (ConstructionWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
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
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getFrameCount())
                           )

                           {
                                 if (
                                    Logger.print("Construction" , "Got new construction request: " + ((ConstructionWME)__$behaviorFrame[0]).getType())
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
         case 312: {
            // processConstructionWME_4Step2
               if (
                  ((PlayerWME)__$behaviorFrame[3]).getMinerals() >= ((ConstructionWME)__$behaviorFrame[0]).getMineralCost() && ((PlayerWME)__$behaviorFrame[3]).getGas() >= ((ConstructionWME)__$behaviorFrame[0]).getGasCost()
               )

               {
                     if (
                        Logger.print("Construction" , "Acquired resources for construction: " + ((ConstructionWME)__$behaviorFrame[0]).getType())
                     )

                     {
                        return true;
                     }


               }


            return false;
         }
         case 366: {
            // defendBaseGround_1Step1
            int lastMoved;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TimerWME wme__0 = (TimerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__0.getFrameCount())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("AttackUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           AttackUnitWME wme__1 = (AttackUnitWME)wmeIter1.next();
                           __$behaviorFrame[6] = wme__1;
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__1.getID())
                              &&
                              ( wme__1.getOrder() != 14 )
                              &&
                              ( wme__1.getOrder() != 10 )
                              &&
                              ( wme__1.getSquadID() == 0 )
                              &&
                              ( wme__1.getTask() != 3 )
                              &&
                              ( wme__1.getIsFlyer() == false )
                              &&
                              BehavingEntity.constantTrue(lastMoved = wme__1.getLastMoved())
                           )

                           {
                                 if (
                                    ((__ValueTypes.IntVar)__$behaviorFrame[5]).i >(lastMoved + 150)
                                 )

                                 {
                                       List wmeList3;
                                       ListIterator wmeIter3;
                                       wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                                       wmeIter3 = wmeList3.listIterator();
                                       while(wmeIter3.hasNext()) {
                                          EnemyUnitWME wme__3 = (EnemyUnitWME)wmeIter3.next();
                                          if (
                                             BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__3.getX())
                                             &&
                                             BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__3.getY())
                                             &&
                                             ( wme__3.getBurrowed() == false )
                                             &&
                                             ( wme__3.getIsFlyer() == false )
                                          )

                                          {
                                                List wmeList4;
                                                ListIterator wmeIter4;
                                                wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                                                wmeIter4 = wmeList4.listIterator();
                                                while(wmeIter4.hasNext()) {
                                                   NexusWME wme__4 = (NexusWME)wmeIter4.next();
                                                   if (
                                                      BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__4.getX())
                                                      &&
                                                      BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__4.getY())
                                                   )

                                                   {
                                                         if (
                                                            Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[0]).i - ((__ValueTypes.IntVar)__$behaviorFrame[2]).i) < 24 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[1]).i - ((__ValueTypes.IntVar)__$behaviorFrame[3]).i) < 24
                                                         )

                                                         {
                                                               if (
                                                                  Logger.print("ABL" , "Defending base: " + ((__ValueTypes.IntVar)__$behaviorFrame[4]).i)
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

                        }


                  }

               }


            return false;
         }
         case 370: {
            // airSquadAttack_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("CasterUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  CasterUnitWME wme__0 = (CasterUnitWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                     &&
                     ( wme__0.getOrder() == 49 )
                     &&
                     ( wme__0.getSquadID() != 0 )
                     &&
                     ( wme__0.getIsFlyer() == true )
                     &&
                     ( wme__0.getTypeID() != 60 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getY())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           EnemyUnitWME wme__1 = (EnemyUnitWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__1.getY())
                           )

                           {
                                 if (
                                    UnitWME.distance(((__ValueTypes.IntVar)__$behaviorFrame[1]).i , ((__ValueTypes.IntVar)__$behaviorFrame[2]).i , ((__ValueTypes.IntVar)__$behaviorFrame[3]).i , ((__ValueTypes.IntVar)__$behaviorFrame[4]).i) < 10
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
         case 373: {
            // corsairSquadAttack_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("CorsairWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  CorsairWME wme__0 = (CorsairWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                     &&
                     ( wme__0.getOrder() == 49 )
                     &&
                     ( wme__0.getSquadID() != 0 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getY())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           EnemyUnitWME wme__1 = (EnemyUnitWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__1.getY())
                              &&
                              ( wme__1.getIsFlyer() == true )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__1.getID())
                           )

                           {
                                 if (
                                    UnitWME.distance(((__ValueTypes.IntVar)__$behaviorFrame[1]).i , ((__ValueTypes.IntVar)__$behaviorFrame[2]).i , ((__ValueTypes.IntVar)__$behaviorFrame[3]).i , ((__ValueTypes.IntVar)__$behaviorFrame[4]).i) < 20
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
         case 376: {
            // defendBaseAir_1Step1
            int lastMoved;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TimerWME wme__0 = (TimerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__0.getFrameCount())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("AttackUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           AttackUnitWME wme__1 = (AttackUnitWME)wmeIter1.next();
                           __$behaviorFrame[7] = wme__1;
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__1.getID())
                              &&
                              ( wme__1.getOrder() != 14 )
                              &&
                              ( wme__1.getOrder() != 10 )
                              &&
                              ( wme__1.getSquadID() == 0 )
                              &&
                              ( wme__1.getTask() != 3 )
                              &&
                              ( wme__1.getCanAttackAir() == true )
                              &&
                              BehavingEntity.constantTrue(lastMoved = wme__1.getLastMoved())
                           )

                           {
                                 if (
                                    ((__ValueTypes.IntVar)__$behaviorFrame[6]).i >(lastMoved + 150)
                                 )

                                 {
                                       List wmeList3;
                                       ListIterator wmeIter3;
                                       wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                                       wmeIter3 = wmeList3.listIterator();
                                       while(wmeIter3.hasNext()) {
                                          EnemyUnitWME wme__3 = (EnemyUnitWME)wmeIter3.next();
                                          if (
                                             BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__3.getX())
                                             &&
                                             BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__3.getY())
                                             &&
                                             ( wme__3.getBurrowed() == false )
                                             &&
                                             ( wme__3.getIsFlyer() == true )
                                          )

                                          {
                                                List wmeList4;
                                                ListIterator wmeIter4;
                                                wmeList4 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                                                wmeIter4 = wmeList4.listIterator();
                                                while(wmeIter4.hasNext()) {
                                                   NexusWME wme__4 = (NexusWME)wmeIter4.next();
                                                   if (
                                                      BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__4.getX())
                                                      &&
                                                      BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__4.getY())
                                                   )

                                                   {
                                                         if (
                                                            Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[0]).i - ((__ValueTypes.IntVar)__$behaviorFrame[2]).i) < 24 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[1]).i - ((__ValueTypes.IntVar)__$behaviorFrame[3]).i) < 24
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


                  }

               }


            return false;
         }
         case 380: {
            // defendBaseCaster_1Step1
            int lastMoved;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TimerWME wme__0 = (TimerWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[6]).i = wme__0.getFrameCount())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("CasterUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           CasterUnitWME wme__1 = (CasterUnitWME)wmeIter1.next();
                           __$behaviorFrame[7] = wme__1;
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__1.getID())
                              &&
                              ( wme__1.getOrder() != 14 )
                              &&
                              ( wme__1.getOrder() != 10 )
                              &&
                              ( wme__1.getSquadID() == 0 )
                              &&
                              ( wme__1.getIsFlyer() == true )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__1.getTypeID())
                              &&
                              BehavingEntity.constantTrue(lastMoved = wme__1.getLastMoved())
                           )

                           {
                                 if (
                                    ((__ValueTypes.IntVar)__$behaviorFrame[6]).i >(lastMoved + 150)
                                 )

                                 {
                                       List wmeList3;
                                       ListIterator wmeIter3;
                                       wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                                       wmeIter3 = wmeList3.listIterator();
                                       while(wmeIter3.hasNext()) {
                                          EnemyUnitWME wme__3 = (EnemyUnitWME)wmeIter3.next();
                                          if (
                                             BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__3.getX())
                                             &&
                                             BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__3.getY())
                                             &&
                                             ( wme__3.getBurrowed() == false )
                                             &&
                                             BehavingEntity.constantTrue(((__ValueTypes.BooleanVar)__$behaviorFrame[8]).b = wme__3.getIsFlyer())
                                          )

                                          {
                                                if (
                                                   ((__ValueTypes.IntVar)__$behaviorFrame[5]).i != Protoss_Corsair || ((__ValueTypes.BooleanVar)__$behaviorFrame[8]).b == true
                                                )

                                                {
                                                      List wmeList5;
                                                      ListIterator wmeIter5;
                                                      wmeList5 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                                                      wmeIter5 = wmeList5.listIterator();
                                                      while(wmeIter5.hasNext()) {
                                                         NexusWME wme__5 = (NexusWME)wmeIter5.next();
                                                         if (
                                                            BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__5.getX())
                                                            &&
                                                            BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__5.getY())
                                                         )

                                                         {
                                                               if (
                                                                  Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[0]).i - ((__ValueTypes.IntVar)__$behaviorFrame[2]).i) < 24 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[1]).i - ((__ValueTypes.IntVar)__$behaviorFrame[3]).i) < 24
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

                        }


                  }

               }


            return false;
         }
         case 384: {
            // createSquad_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ReconWME wme__0 = (ReconWME)wmeIter0.next();
                  if (
                     ( wme__0.getNumFreeForces() >= ((EISBot)__$thisEntity).minSquadSize )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ParticleWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ParticleWME wme__1 = (ParticleWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__1.getY())
                           )

                           {
                              return true;
                           }

                        }


                  }

               }


            return false;
         }
         case 392: {
            // regroupSquad_1Step2
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getSquadID() == ((__ValueTypes.IntVar)__$behaviorFrame[0]).i )
                     &&
                     ( wme__0.getSpreadExceeded() == true )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 394: {
            // regroupSquad_1Step4
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getSquadID() == ((__ValueTypes.IntVar)__$behaviorFrame[0]).i )
                     &&
                     ( wme__0.getSpreadFixed() == true )
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 398: {
            // squadBreakup_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getIsIdle() == true )
                     &&
                     ( wme__0.getHasRetreated() == true )
                  )

                  {
                        if (
                           Logger.print("Squad" , "Breaking up squad: " + ((SquadWME)__$behaviorFrame[0]).getSquadID())
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 401: {
            // squadSelectTarget_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getIsIdle() == true )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getSquadID())
                     &&
                     ( wme__0.getIsRetreating() == false )
                     &&
                     ( wme__0.getHasRetreated() == false )
                  )

                  {
                        if (
                           Logger.print("Squad" , "Detected idle squad: " + ((__ValueTypes.IntVar)__$behaviorFrame[0]).i)
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 409: {
            // deleteSquad_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getSize() == 0 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getSquadID())
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
         case 411: {
            // squadRetreat_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getBaseDistance() >= 20 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getSquadSupply())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getEnemySupply())
                     &&
                     ( wme__0.getIsRetreating() == false )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getSquadID())
                  )

                  {
                        if (
                           ((__ValueTypes.IntVar)__$behaviorFrame[2]).i > ((__ValueTypes.IntVar)__$behaviorFrame[1]).i
                        )

                        {
                              if (
                                 Logger.print("Squad" , "Squad is retreating: ")
                              )

                              {
                                 return true;
                              }


                        }


                  }

               }


            return false;
         }
         case 415: {
            // squadMerge_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ParticleWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ParticleWME wme__0 = (ParticleWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getY())
                  )

                  {
                        if (
                           SquadWME.canMergeSquads()
                        )

                        {
                           return true;
                        }


                  }

               }


            return false;
         }
         case 427: {
            // rallyUnits_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  EnemyUnitWME wme__0 = (EnemyUnitWME)wmeIter0.next();
                  if (
                     true
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("AttackUnitWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     AttackUnitWME wme__1 = (AttackUnitWME)wmeIter1.next();
                     __$behaviorFrame[4] = wme__1;
                     if (
                        ( wme__1.getOrder() == 3 )
                        &&
                        ( wme__1.getActive() == true )
                        &&
                        ( wme__1.getSquadID() == 0 )
                        &&
                        BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getID())
                        &&
                        BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getX())
                        &&
                        BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__1.getY())
                        &&
                        ( wme__1.getTask() == 0 )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("MapWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              MapWME wme__2 = (MapWME)wmeIter2.next();
                              __$behaviorFrame[5] = wme__2;
                              if (
                                 true
                              )

                              {
                                    if (
                                       Logger.print("ABL" , "Rallying unit (prepareAttack): " + ((__ValueTypes.IntVar)__$behaviorFrame[0]).i)
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
         case 431: {
            // unblockChokes_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerUnitWME wme__0 = (PlayerUnitWME)wmeIter0.next();
                  if (
                     ( wme__0.getTypeID() != 64 )
                     &&
                     ( wme__0.getOrder() == 3 )
                     &&
                     ( wme__0.getActive() == true )
                     &&
                     ( wme__0.getSquadID() == 0 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getY())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("MapWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           MapWME wme__1 = (MapWME)wmeIter1.next();
                           __$behaviorFrame[3] = wme__1;
                           if (
                              true
                           )

                           {
                                 if (
                                    ((MapWME)__$behaviorFrame[3]).chokeDistance(((__ValueTypes.IntVar)__$behaviorFrame[1]).i , ((__ValueTypes.IntVar)__$behaviorFrame[2]).i) <= 2
                                 )

                                 {
                                       if (
                                          Logger.print("ABL" , "Moving unit to unblock choke: " + ((__ValueTypes.IntVar)__$behaviorFrame[0]).i)
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
         case 435: {
            // scatterAttack_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("AttackUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  AttackUnitWME wme__0 = (AttackUnitWME)wmeIter0.next();
                  __$behaviorFrame[3] = wme__0;
                  if (
                     ( wme__0.getSquadID() != 0 )
                     &&
                     ( wme__0.getOrder() == 3 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ParticleWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ParticleWME wme__1 = (ParticleWME)wmeIter1.next();
                           if (
                              true
                           )

                           {
                              return false;
                           }

                        }

                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("MapWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              MapWME wme__2 = (MapWME)wmeIter2.next();
                              if (
                                 BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getScatterX())
                                 &&
                                 BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__2.getScatterY())
                              )

                              {
                                 return true;
                              }

                           }



                  }

               }


            return false;
         }
         case 438: {
            // observerSupport_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ObserverWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ObserverWME wme__0 = (ObserverWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                     &&
                     ( wme__0.getOrder() == 3 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("AttackUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           AttackUnitWME wme__1 = (AttackUnitWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getID())
                              &&
                              ( wme__1.getSquadID() != 0 )
                           )

                           {
                                 if (
                                    Logger.print("ABL" , "Obs follow")
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
         case 441: {
            // observerFlee_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  if (
                     ( wme__0.getIsRetreating() == false )
                  )

                  {
                     return false;
                  }

               }

                  List wmeList1;
                  ListIterator wmeIter1;
                  wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ObserverWME");
                  wmeIter1 = wmeList1.listIterator();
                  while(wmeIter1.hasNext()) {
                     ObserverWME wme__1 = (ObserverWME)wmeIter1.next();
                     if (
                        BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getID())
                        &&
                        ( wme__1.getOrder() != 49 )
                     )

                     {
                           List wmeList2;
                           ListIterator wmeIter2;
                           wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("AttackUnitWME");
                           wmeIter2 = wmeList2.listIterator();
                           while(wmeIter2.hasNext()) {
                              AttackUnitWME wme__2 = (AttackUnitWME)wmeIter2.next();
                              if (
                                 BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getID())
                              )

                              {
                                    if (
                                       Logger.print("ABL" , "Obs Flee, no squads")
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
         case 444: {
            // revealCloakedUnits_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  EnemyUnitWME wme__0 = (EnemyUnitWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getY())
                     &&
                     ( wme__0.getCloaked() == true )
                     &&
                     ( wme__0.getTypeID() != 84 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           TimerWME wme__1 = (TimerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__1.getFrameCount())
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ObserverWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    ObserverWME wme__2 = (ObserverWME)wmeIter2.next();
                                    __$behaviorFrame[5] = wme__2;
                                    if (
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__2.getID())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__2.getLastMoved())
                                    )

                                    {
                                          if (
                                             ((__ValueTypes.IntVar)__$behaviorFrame[3]).i >(((__ValueTypes.IntVar)__$behaviorFrame[4]).i + 300)
                                          )

                                          {
                                                if (
                                                   Logger.print("ABL" , "Obs revealing cloaked")
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
         case 448: {
            // revealBurrowedUnits_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  EnemyUnitWME wme__0 = (EnemyUnitWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getY())
                     &&
                     ( wme__0.getBurrowed() == true )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("TimerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           TimerWME wme__1 = (TimerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__1.getFrameCount())
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("ObserverWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    ObserverWME wme__2 = (ObserverWME)wmeIter2.next();
                                    __$behaviorFrame[5] = wme__2;
                                    if (
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__2.getID())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__2.getLastMoved())
                                    )

                                    {
                                          if (
                                             ((__ValueTypes.IntVar)__$behaviorFrame[3]).i >(((__ValueTypes.IntVar)__$behaviorFrame[4]).i + 500)
                                          )

                                          {
                                                if (
                                                   Logger.print("ABL" , "Obs revealing burrowed")
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
         case 452: {
            // groundDefendBase_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ZealotWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ZealotWME wme__0 = (ZealotWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__0.getID())
                     &&
                     ( wme__0.getOrder() == 3 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           EnemyUnitWME wme__1 = (EnemyUnitWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getY())
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
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__2.getX())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__2.getY())
                                    )

                                    {
                                          if (
                                             Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[0]).i - ((__ValueTypes.IntVar)__$behaviorFrame[2]).i) < 20 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[1]).i - ((__ValueTypes.IntVar)__$behaviorFrame[3]).i) < 20
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


            return false;
         }
         case 455: {
            // airDefendBase_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("DragoonWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  DragoonWME wme__0 = (DragoonWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__0.getID())
                     &&
                     ( wme__0.getOrder() == 3 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           EnemyUnitWME wme__1 = (EnemyUnitWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getY())
                              &&
                              ( wme__1.getBurrowed() == false )
                              &&
                              ( wme__1.getTypeID() != 84 )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    NexusWME wme__2 = (NexusWME)wmeIter2.next();
                                    if (
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__2.getX())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__2.getY())
                                    )

                                    {
                                          if (
                                             Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[0]).i - ((__ValueTypes.IntVar)__$behaviorFrame[2]).i) < 20 && Math.abs(((__ValueTypes.IntVar)__$behaviorFrame[1]).i - ((__ValueTypes.IntVar)__$behaviorFrame[3]).i) < 20
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


            return false;
         }
         case 458: {
            // flee_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("ReconWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  ReconWME wme__0 = (ReconWME)wmeIter0.next();
                  if (
                     ( wme__0.getEnemyTanks() == false )
                     &&
                     ( wme__0.getEnemyBunkers() == false )
                     &&
                     ( wme__0.getEnemyCannons() == false )
                     &&
                     ( wme__0.getEnemySunkens() == false )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("DragoonWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           DragoonWME wme__1 = (DragoonWME)wmeIter1.next();
                           __$behaviorFrame[3] = wme__1;
                           if (
                              ( wme__1.getTask() != 3 )
                              &&
                              ( wme__1.getTakenDamage() == true )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getID())
                              &&
                              ( wme__1.getGroundCooldown() > 0 )
                              &&
                              ( wme__1.getGroundCooldown() < 26 )
                              &&
                              ( wme__1.getOrder() == 10 )
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    NexusWME wme__2 = (NexusWME)wmeIter2.next();
                                    if (
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getID())
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
         case 463: {
            // fleeDamage_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("DragoonWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  DragoonWME wme__0 = (DragoonWME)wmeIter0.next();
                  __$behaviorFrame[3] = wme__0;
                  if (
                     ( wme__0.getTask() != 3 )
                     &&
                     ( wme__0.getTakenDamage() == true )
                     &&
                     ( wme__0.getHitPoints() < 90 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                     &&
                     ( wme__0.getGroundCooldown() > 0 )
                     &&
                     ( wme__0.getGroundCooldown() < 26 )
                     &&
                     ( wme__0.getOrder() == 10 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("NexusWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           NexusWME wme__1 = (NexusWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__1.getID())
                           )

                           {
                              return true;
                           }

                        }


                  }

               }


            return false;
         }
         case 473: {
            // casterAssignSquad_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("CasterUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  CasterUnitWME wme__0 = (CasterUnitWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getSquadID() == 0 )
                     &&
                     ( wme__0.getActive() == true )
                     &&
                     ( wme__0.getMerged() == false )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getY())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__0.getTypeID())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.BooleanVar)__$behaviorFrame[5]).b = wme__1.getPsiStorm())
                           )

                           {
                                 if (
                                    ((__ValueTypes.IntVar)__$behaviorFrame[4]).i != Protoss_High_Templar || ((__ValueTypes.BooleanVar)__$behaviorFrame[5]).b
                                 )

                                 {
                                       List wmeList3;
                                       ListIterator wmeIter3;
                                       wmeList3 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
                                       wmeIter3 = wmeList3.listIterator();
                                       while(wmeIter3.hasNext()) {
                                          SquadWME wme__3 = (SquadWME)wmeIter3.next();
                                          __$behaviorFrame[1] = wme__3;
                                          if (
                                             true
                                          )

                                          {
                                                if (
                                                   Logger.print("Squad" , "Assigning caster to a squad")
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
         case 476: {
            // archonAssignSquad_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  SquadWME wme__0 = (SquadWME)wmeIter0.next();
                  __$behaviorFrame[1] = wme__0;
                  if (
                     true
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("ArchonWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           ArchonWME wme__1 = (ArchonWME)wmeIter1.next();
                           __$behaviorFrame[0] = wme__1;
                           if (
                              ( wme__1.getSquadID() == 0 )
                              &&
                              ( wme__1.getActive() == true )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__1.getY())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__1.getID())
                           )

                           {
                                 if (
                                    Logger.print("Squad" , "Assigning archon to a squad")
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
         case 480: {
            // attackerAssignSquad_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("AttackUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  AttackUnitWME wme__0 = (AttackUnitWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getSquadID() == 0 )
                     &&
                     ( wme__0.getActive() == true )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getY())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("SquadWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           SquadWME wme__1 = (SquadWME)wmeIter1.next();
                           __$behaviorFrame[1] = wme__1;
                           if (
                              true
                           )

                           {
                                 if (
                                    UnitWME.distance(((__ValueTypes.IntVar)__$behaviorFrame[2]).i , ((__ValueTypes.IntVar)__$behaviorFrame[3]).i , ((SquadWME)__$behaviorFrame[1])) < 10
                                 )

                                 {
                                       if (
                                          Logger.print("Squad" , "Assigning idle attacker to a squad")
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
         case 483: {
            // casterFollowSquad_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("CasterUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  CasterUnitWME wme__0 = (CasterUnitWME)wmeIter0.next();
                  __$behaviorFrame[5] = wme__0;
                  if (
                     ( wme__0.getOrder() != 49 )
                     &&
                     ( wme__0.getOrder() != 142 )
                     &&
                     ( wme__0.getOrder() != 14 )
                     &&
                     ( wme__0.getOrder() != 10 )
                     &&
                     ( wme__0.getSquadID() != 0 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getSquadID())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                     &&
                     ( wme__0.getActive() == true )
                     &&
                     ( wme__0.getMerged() == false )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("AttackUnitWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           AttackUnitWME wme__1 = (AttackUnitWME)wmeIter1.next();
                           if (
                              ( wme__1.getSquadID() == ((__ValueTypes.IntVar)__$behaviorFrame[1]).i )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__1.getID())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__1.getY())
                           )

                           {
                                 if (
                                    ((CasterUnitWME)__$behaviorFrame[5]).distance(((__ValueTypes.IntVar)__$behaviorFrame[2]).i , ((__ValueTypes.IntVar)__$behaviorFrame[3]).i) > 3
                                 )

                                 {
                                       if (
                                          Logger.print("Squad" , "Telling caster to follow")
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
         case 486: {
            // casterRetreat_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("CasterUnitWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  CasterUnitWME wme__0 = (CasterUnitWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getSquadID() != 0 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__0.getSquadID())
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__0.getID())
                     &&
                     ( wme__0.getActive() == true )
                     &&
                     ( wme__0.getMerged() == false )
                  )

                  {
                        if (
                           ! SquadWME.squadExist(((__ValueTypes.IntVar)__$behaviorFrame[4]).i)
                        )

                        {
                              List wmeList2;
                              ListIterator wmeIter2;
                              wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("BuildingWME");
                              wmeIter2 = wmeList2.listIterator();
                              while(wmeIter2.hasNext()) {
                                 BuildingWME wme__2 = (BuildingWME)wmeIter2.next();
                                 if (
                                    BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getX())
                                    &&
                                    BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__2.getY())
                                 )

                                 {
                                       if (
                                          Logger.print("Squad" , "Removing caster from a squad")
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
         case 490: {
            // psiStorm_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  PlayerWME wme__0 = (PlayerWME)wmeIter0.next();
                  if (
                     ( wme__0.getPsiStorm() == true )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("HighTemplarWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           HighTemplarWME wme__1 = (HighTemplarWME)wmeIter1.next();
                           if (
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__1.getID())
                              &&
                              ( wme__1.getEnergy() >= 75 )
                              &&
                              ( wme__1.getOrder() != 142 )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__1.getY())
                           )

                           {
                                 List wmeList2;
                                 ListIterator wmeIter2;
                                 wmeList2 = BehavingEntity.getBehavingEntity().lookupWME("EnemyUnitWME");
                                 wmeIter2 = wmeList2.listIterator();
                                 while(wmeIter2.hasNext()) {
                                    EnemyUnitWME wme__2 = (EnemyUnitWME)wmeIter2.next();
                                    __$behaviorFrame[6] = wme__2;
                                    if (
                                       ( wme__2.getIsBuilding() == false )
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__2.getID())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[4]).i = wme__2.getX())
                                       &&
                                       BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[5]).i = wme__2.getY())
                                       &&
                                       ( wme__2.getTypeID() != 42 )
                                    )

                                    {
                                          if (
                                             ((EnemyUnitWME)__$behaviorFrame[6]).distance(((__ValueTypes.IntVar)__$behaviorFrame[2]).i , ((__ValueTypes.IntVar)__$behaviorFrame[3]).i) <= 16
                                          )

                                          {
                                                if (
                                                   UnitWME.friendlyDistance(((__ValueTypes.IntVar)__$behaviorFrame[4]).i , ((__ValueTypes.IntVar)__$behaviorFrame[5]).i) > 2
                                                )

                                                {
                                                      if (
                                                         Logger.print("ABL" , "Using Psi Storm")
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

               }


            return false;
         }
         case 493: {
            // mergeArchon_1Step1
            int y2;
            int x1;
            int x2;
            int y1;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("HighTemplarWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  HighTemplarWME wme__0 = (HighTemplarWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     ( wme__0.getActive() == true )
                     &&
                     ( wme__0.getMerged() == false )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[2]).i = wme__0.getID())
                     &&
                     BehavingEntity.constantTrue(x1 = wme__0.getX())
                     &&
                     BehavingEntity.constantTrue(y1 = wme__0.getY())
                     &&
                     ( wme__0.getEnergy() < 50 )
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("HighTemplarWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           HighTemplarWME wme__1 = (HighTemplarWME)wmeIter1.next();
                           __$behaviorFrame[1] = wme__1;
                           if (
                              ( wme__1.getActive() == true )
                              &&
                              ( wme__1.getMerged() == false )
                              &&
                              ( wme__1.getID() != ((__ValueTypes.IntVar)__$behaviorFrame[2]).i )
                              &&
                              BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[3]).i = wme__1.getID())
                              &&
                              BehavingEntity.constantTrue(x2 = wme__1.getX())
                              &&
                              BehavingEntity.constantTrue(y2 = wme__1.getY())
                              &&
                              ( wme__1.getEnergy() < 50 )
                           )

                           {
                                 if (
                                    UnitWME.distance(x1 , y1 , x2 , y2) < 20
                                 )

                                 {
                                       if (
                                          Logger.print("ABL" , "Warping Archon")
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
         case 500: {
            // trainInterceptors_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("CarrierWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  CarrierWME wme__0 = (CarrierWME)wmeIter0.next();
                  if (
                     ( wme__0.getInterceptorCount() < 8 )
                     &&
                     ( wme__0.getTrainTimer() == 0 )
                     &&
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[0]).i = wme__0.getID())
                  )

                  {
                        List wmeList1;
                        ListIterator wmeIter1;
                        wmeList1 = BehavingEntity.getBehavingEntity().lookupWME("PlayerWME");
                        wmeIter1 = wmeList1.listIterator();
                        while(wmeIter1.hasNext()) {
                           PlayerWME wme__1 = (PlayerWME)wmeIter1.next();
                           if (
                              ( wme__1.getMinerals() >= 25 )
                           )

                           {
                              return true;
                           }

                        }


                  }

               }


            return false;
         }
         case 504: {
            // WaitFrames_1Step2
               if (
                  ABLStarCraftBot.getGame().getGameFrame() >= ((__ValueTypes.IntVar)__$behaviorFrame[1]).i
               )

               {
                  return true;
               }


            return false;
         }
         case 506: {
            // processKeypresses_1Step1
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("KeyPressWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  KeyPressWME wme__0 = (KeyPressWME)wmeIter0.next();
                  __$behaviorFrame[0] = wme__0;
                  if (
                     BehavingEntity.constantTrue(((__ValueTypes.IntVar)__$behaviorFrame[1]).i = wme__0.getKeycode())
                  )

                  {
                     return true;
                  }

               }


            return false;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
