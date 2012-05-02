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
public class EISBot_SuccessTestSensorFactories implements eisbot.abl.StarCraftConstants
{
   static public SensorActivation[] successTestSensorFactory0(int __$stepID) {
      switch (__$stepID) {
         case 0: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MineralSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new GasSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 25: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 28: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 31: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 45: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 47: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 56: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 58: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 60: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 62: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 64: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 68: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 70: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null)
               };

               return __$activationArray;

         }
         case 72: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 75: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 78: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 84: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new ParticleFilterSensor(), null),
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
         case 95: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 96: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 105: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 108: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 114: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 125: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 133: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 137: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 141: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 150: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 158: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 160: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 164: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 173: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 188: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 192: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 196: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 217: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 220: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 223: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MineralSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 227: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MineralSensor(), null)
               };

               return __$activationArray;

         }
         case 229: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 232: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MineralSensor(), null),
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 235: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MineralSensor(), null),
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 238: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new MineralSensor(), null),
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 241: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new GasSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 244: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 247: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new ReconSensor(), null)
               };

               return __$activationArray;

         }
         case 251: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 254: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 260: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 277: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 283: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 290: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 297: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 366: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 370: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 373: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new EnemyUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 376: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 380: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 384: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new ParticleFilterSensor(), null)
               };

               return __$activationArray;

         }
         case 415: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new ParticleFilterSensor(), null)
               };

               return __$activationArray;

         }
         case 427: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new MapSensor(), null)
               };

               return __$activationArray;

         }
         case 431: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new MapSensor(), null)
               };

               return __$activationArray;

         }
         case 435: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new MapSensor(), null),
                  new SensorActivation(new ParticleFilterSensor(), null)
               };

               return __$activationArray;

         }
         case 438: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 441: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 444: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new EnemyUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 448: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new EnemyUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 452: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 455: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 458: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new ReconSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 463: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 473: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
         case 476: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 480: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 483: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 486: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 490: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new EnemyUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null),
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 493: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null)
               };

               return __$activationArray;

         }
         case 500: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new PlayerUnitSensor(), null),
                  new SensorActivation(new PlayerSensor(), null)
               };

               return __$activationArray;

         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}
