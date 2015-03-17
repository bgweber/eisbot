# EISBot #

EISBot is a [StarCraft: Brood War](http://us.blizzard.com/en-us/games/sc/) bot developed by Ben Weber at [UC Santa Cruz](http://games.soe.ucsc.edu/) as part of his dissertation research. The main objective for the project is to identify the capabilities necessary for expert Starcraft gameplay and to realize these capabilities in a game-playing agent.

<a href='http://www.youtube.com/watch?feature=player_embedded&v=y_zAfvNnSDQ' target='_blank'><img src='http://img.youtube.com/vi/y_zAfvNnSDQ/0.jpg' width='425' height=344 /></a>

## Content ##

  * [GettingStarted](GettingStarted.md): Information for running and compiling EISBot.
  * [Videos](Videos.md): Videos of EISBot in action.
  * [Downloads](http://code.google.com/p/eisbot/downloads/list): Source and binary downloads for the AIIDE 2011 version and binary release of the dissertation version.
  * [Configuration](Configuration.md): Details on setting up EISBot.
  * [SourceOverview](SourceOverview.md): Overview of the EISBot source.
  * [Gallery](Gallery.md): Screen captures of EISBot in action.

## Dissertation ##

[Integrating Learning in a Multi-Scale Agent](http://users.soe.ucsc.edu/~bweber/bweber-dissertation.pdf)
  * Ben Weber's dissertation focuses on the goal of building human-level artificial intelligence for real-time strategy games. It explores the following research question: what capabilities are necessary for expert RTS gameplay and how can these capabilities be integrated in a complete game playing agent? The dissertation was produced under the advisorship of Michael Mateas and Arnav Jhala in the Expressive Intelligence Studio at the University of California, Santa Cruz.

A paperback version is also available on [Amazon](http://www.amazon.com/dp/1477614737/).

[![](http://users.soe.ucsc.edu/~bweber/CoverText.jpg)](http://www.amazon.com/dp/1477614737/)

## Publications ##

Work on this project has resulted in the following publications. They are listed here in recommended order of reading. Citation information can be found [here](Citations.md).


[Reactive Planning Idioms for Multi-Scale Game AI](http://users.soe.ucsc.edu/~bweber/pubs/weber_cig2010.pdf)
  * Advocates the use of reactive planning for authoring agents that need to simultaneously manage several tasks. This paper provides an overview of design patterns built on top of the ABL reactive planning language that are used in EISBot. The result of this work is a reactive planning Starcraft bot that plays complete games and also implements micromanagement behaviors.

[A Data Mining Approach to Strategy Prediction](http://users.soe.ucsc.edu/~bweber/pubs/cig_2009.pdf)
  * Presents methods for training classification and regression models that are applied to the tasks of identifying which build order an opponent is pursuing and identifying when specific buildings and units will be produced. The outcome of this work is that the models exhibit anticipation capabilities, but the limitation of this method is that all strategies need to be known during development.

[A Particle Model for State Estimation in Real-Time Strategy Games](http://users.soe.ucsc.edu/~bweber/pubs/weber_aiide11.pdf)
  * Explores a method for tracking previously observed units. The proposed particle model is inspired by the application of particle filters to games, but uses a simplified approach in which individual particles track units. To train parameters in the model, replays are used to implement an error function that enables offline analysis of different model configurations.

[Case-Based Goal Formulation](http://users.soe.ucsc.edu/~bweber/pubs/weber_goalformulation.pdf)
  * Introduces a method for formulating new strategic goals for the agent to pursue using replays. The general idea is to infer game states reached later in a game as goals states intended by the player earlier in the game. This method is used to perform opponent modeling and to select strategies for the agent to pursue.

[Applying Goal-Driven Autonomy to StarCraft](http://users.soe.ucsc.edu/~bweber/pubs/gda_aiide2010.pdf)
  * Explores an application of the Goal-Driven Autonomy (GDA) conceptual model in a Starcraft agent. In this paper, the GDA model is implemented using a collection of hand-authored ABL behaviors. The resulting agent pursues a fixed set of build orders, but is able to respond to changes in opponent strategies.

[Learning from Demonstration for Goal-Driven Autonomy](http://users.soe.ucsc.edu/~bweber/pubs/Weber-AAAI-2012.pdf)
  * Presents methods for implementing the GDA subtasks using gameplay demonstrations. In this paper, the GDA model is implemented using case-based goal formulation to build anticipations of opponent actions and to respond with new strategies. The resulting system uses GDA to select and monitor strategy execution.

[Building Human-Level AI for Real-Time Strategy Games](http://users.soe.ucsc.edu/~bweber/pubs/weber-acs2011-final.pdf)
  * Provide an overview of many of the capabilities necessary for expert-level Starcraft gameplay. The paper describes how many of these capabilities are emulated in EISBot and provides an initial evaluation of EISBot versus human opponents.


## In the Press ##

  * Edge Magazine: [The future of videogame AI](http://www.edge-online.com/features/future-videogame-ai?page=2)
  * New Scientist: [Online games are a gold mine for design ideas](http://www.newscientist.com/article/mg20727745.100-online-games-are-a-gold-mine-for-design-ideas.htm)
  * New Scientist: [Machine intelligence put to test in alien world](http://www.newscientist.com/article/mg20827845.400-machine-intelligence-put-to-test-in-alien-world.html)
  * Game Pro: [Building a StarCraft bot that plays like a pro](http://web.archive.org/web/20110607063926/http://www.gamepro.com/article/features/214810/starcraft-bot-plays-like-pro/)
  * CNET: [GDC: What's next for video game AI?](http://news.cnet.com/8301-27076_3-20000266-248.html)

## Acknowledgments ##

This project is based upon work supported by the National Science Foundation under Grant Number [IIS-1018954](http://www.nsf.gov/awardsearch/showAward.do?AwardNumber=1018954). Any opinions, ﬁndings, and conclusions or recommendations expressed in this material are those of the authors and do not necessarily reﬂect the views of the National Science Foundation.

[StarCraft](http://us.blizzard.com/en-us/games/sc/), Brood War and Blizzard Entertainment are trademarks or registered trademarks of Blizzard Entertainment, Inc. in the U.S. and/or other countries. ©1998 Blizzard Entertainment, Inc. All rights reserved.