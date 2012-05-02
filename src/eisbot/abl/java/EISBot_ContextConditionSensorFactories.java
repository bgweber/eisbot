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
public class EISBot_ContextConditionSensorFactories implements eisbot.abl.StarCraftConstants
{
   static public SensorActivation[] contextConditionSensorFactory0(int __$behaviorID) {
      switch (__$behaviorID) {
         case 25: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 26: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 56: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 109: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 111: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 113: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MapSensor(), null)
               };

               return __$activationArray;

         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}
