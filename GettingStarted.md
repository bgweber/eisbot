# Getting Started #

There are two ways to run EISBot: you can download the release and run the bot directly, or you can check out the source from SVN and run the bot from the Eclipse IDE. In order to run EISBot, it is necessary to have Java 1.6 installed. In order to compile EISBot, using Eclipse is the preferred method.

First, you need to set up Starcraft to interface with a BWAPI remote AI client. Instructions for setting up and using BWAPI are available [here](http://code.google.com/p/bwapi/wiki/UsingBWAPI). EISBot currently works with only BWAPI 3.7.2 (rev 4025).

## Running the Release version ##

The easiest way to get EISBot up and running is to download the most recent release on the [downloads](http://code.google.com/p/eisbot/downloads/list) page. Extract the files and launch `EISBotDemo.bat`.
Then, start Starcraft and create a custom single player game.

## Compiling ##

The easiest way to get the project to compile is using Eclipse's import functionality. Check out EISBot from the [repository](http://code.google.com/p/eisbot/source/checkout) using SVN import. This process will check out the project as a new Eclipse project, which includes .classpath and .project files. The repository includes source and data files and is large (~170 MB).

Compiling EISBot is a two part process. If changes to EISBot.ABL are made, then the ABL compiler needs to be executed. It can be launched by running the following class: `eisbot.experiments.CompileEISBot'. It may be necessary to refresh the project after compiling the ABL source to ensure that generated Java files are identified by Eclipse.

## Running from Eclipse ##

The main class for launching EISBot is: `eisbot.experiments.EISBot`. There are other classes in this directory that demonstrate how to launch EISBot with different configurations.