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
public class EISBot_PreconditionSensorFactories implements eisbot.abl.StarCraftConstants
{
   static public SensorActivation[] preconditionSensorFactory0(int __$behaviorID) {
      switch (__$behaviorID) {
         case 6: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 8: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 9: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 10: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 11: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 25: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ParticleFilterSensor(), null)
               };

               return __$activationArray;

         }
         case 26: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MapSensor(), null)
               };

               return __$activationArray;

         }
         case 37: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null)
               };

               return __$activationArray;

         }
         case 38: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 40: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 42: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 46: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 48: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 50: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 52: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 55: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 64: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null)
               };

               return __$activationArray;

         }
         case 80: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 83: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 86: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MineralSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 88: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MineralSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 89: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MineralSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 91: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 92: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 96: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 98: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 103: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null)
               };

               return __$activationArray;

         }
         case 105: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 107: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 108: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MapSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 112: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new NewUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 113: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MapSensor(), null),
                  new SensorActivation(new NewUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 114: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new NewUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 115: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new MapSensor(), null),
                  new SensorActivation(new NewUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 116: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 125: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ParticleFilterSensor(), null)
               };

               return __$activationArray;

         }
         case 129: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 130: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 131: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 132: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ParticleFilterSensor(), null)
               };

               return __$activationArray;

         }
         case 152: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 153: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ParticleFilterSensor(), null)
               };

               return __$activationArray;

         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}
