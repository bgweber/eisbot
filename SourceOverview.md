# Source Overview #

The source code is structured as follows:

  * **src**
    * **eisbot**
      * **abl**
        * **abl**
          * Contains ABL code for specifying agent behavior.
        * **actions**
          * Classes for binding ABL actions to Starcraft commands.
        * **java**
          * Output directory for ABL compilation. Contains generated Java code.
        * **sensors**
          * Classes for binding WMEs to sensor classes.
        * **wmes**
          * Objects for tracking the internal state of the agent.
        * Contains the ABL source and bindings for ABL sensors and actions. It also contains a driver class for launcher the agent, and ABL utility classes.
      * **buildorder**
        * **buildorders**
          * Build order scrips.
        * Classes for parsing build orders.
      * **cbr**
        * **data**
          * Data files used for goal formulation, and expectation and explanation generation.
        * **goalforumlator**
          * **filter**
            * Methods for transforming feature vectors.
          * **io**
            * Utility class for loading feature vectors instances.
          * **retriever**
            * Implementations of the retrieval interface.
          * Classes for representing game state as a feature vector and for implementing goal-formulation and retrieval.
      * **experiments**
        * Driver classes for running different EISBot configurations.
      * **gui**
        * Swing components for visualizing agent and game state.
      * **proxy**
        * **command**
        * Classes for dispatching Starcraft commands.
        * **filter**
        * Classes for implementing the particle model.
        * **model**
        * Objects for storing Starcraft game state. These objects are place holders and not used directly by ABL behaviors.
        * **types**
        * Classes for storing type data.
        * **wmes**
          * **unit**
            * **protoss**
              * Objects for representing specific Protoss unit types.
            * Objects for representing unit types.
        * Objects for storing game state. These objects are used directly by ABL behaviors.
    * **jni**
      * C++ code for binding Java native methods to AI client calls. See the [JNIBWAPI](http://code.google.com/p/jnibwapi/) project for more details.