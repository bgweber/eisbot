# EISBot Configuration #

EISBot can be configured to run in a number of different ways. For example, the GDA and particle model ablation studies used the same agent runtime with different configurations. The main way EISBot is configured is through Java system properties (e.g. -DSettings.Fastest=true). EISBot uses the following system properties:

**Game Settings**
  * `GameSettings.IgnoreBases` (boolean): disbale BWTA?
  * `GameSettings.ShowGUI` (boolean): show the agent GUI?
  * `GameSettings.AutoRestart` (boolean): restart games on game end?
  * `GameSettings.UseManners` (boolean): quit when loss is detected?
  * `GameSettings.Fastest` (boolean): setSpeed(0)?
  * `GameSettings.UserInput` (boolean): enable the user to perform actions?
  * `GameSettings.QuitOnGameEnd` (boolean): end this process when the game ends?
  * `GameSettings.AutoCamera` (boolean): enable automatic camera positioning ?


**Build Selection**
  * `BuildSelector.Epsilon (double): epsilon value for build order selection
  * `BuildSelector.BaseCountWeight` (double): base count weight for build order selection
  * `BuildSelector.ExpoChokeWeight` (double): expo chokepoint weight for build order selection
  * `BuildSelector.HistoryWeight` (double): history (boredom) weight for build order selection
  * `BuildSelector.HistorySize` (int): number of builds to maintain in history for computing reuse weight


**Particle Filter**
  * `ParticleFilter.Mode` (enum): The type of particle filter to use. See `ParticleFilter.ParticleFilterMode`


**Goal Formulator**
  * `GoalFormulator.Enable` (boolean): enable the CBR goal formulation component?
  * `GoalFormulator.PlanningWindowSize` (int): how many actions to plan ahead
  * `GoalFormulator.ReplanningSize` (int): minimum action window size for triggering replanning
  * `GoalFormulator.SamplingRatio` (double): ratio of training examples to use

**Opponent Predictor**
  * `OpponentPredictor.Enable` (boolean): enable the opponent strategy prediction component?
  * `OpponentPredictor.PredictionWindowSize` (int): how far to look ahead in terms of build actions?
  * `OpponentPredictor.PredictionPeriod` (int): how frequent to run? (delay in game frames)


**Goal Driven Autonomy**
  * `GDA.Enable` (boolean): enable the discrepancy detection component?
  * `GDA.DiscrepancyPeriod` (int): how much of a discrepancy to allow (frames)?


### Example Configuration ###

This configuration runs the bot in competition mode:
```
java -DGameSettings.ShowGUI=false -DGameSettings.QuitOnGameEnd=true eisbot.experiments.EISBot
```

The agent configuration is displayed at start up:
```
EISBot Launching Thu May 03 12:58:18 PDT 2012
Configution
 º ABL Agent: EISBot
 º Game Settings
   - Ignore terrain: false
   - Show GUI: false
   - Auto restart: false
   - Use manners: false
   - Fastest: true
   - User input: true
   - Quit on game end: true
   - Auto camera: false
 º Build Selection
   - Script path: null
   - Epsilon: 0.5
   - Base count weight: 1.0
   - Expo chokepoint weight: 1.0
   - History weight: 1.0
   - History size: 1
 º Particle Filter
   - Mode: OptimizedParticles
 º Goal Formulator
   - enabled: true
   - planning window size: 15
   - replanning size: 0
   - sampling ratio: 1.0
 º Opponent Predictor
   - enabled: true
   - window size: 10
   - prediction period: 720
 º Goal Driven Autonomy (Strategy)
   - enabled: true
   - prediction period: 720
```