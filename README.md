# ColorSlide


**Summary**


We developed a 2D, block-sliding based logic puzzle game that utilizes a block-merging mechanic based on color to test users’ problem solving skills. In addition to a set of pre-made levels, levels can be generated algorithmically and randomly, increasing in difficulty over time. It includes an interactive and simple user interface so that it is intuitive to understand, enhancing the player experience and highlighting puzzle solving mechanics.	

In this presentation, we will be giving a walkthrough of our documented code, a general demonstration of the game, and possible directions for future work.
<br>
<br>
<br>

**Technical Architecture** 


Our application was divided into a frontend and backend, and all parts were written in Java and tested separately using JUnit. The backend game logic is ultimately encapsulated in the LevelBoard Java class, and has a series of interface functions useful for both the frontend and developer testing, such as isComplete, getBlocks, getBlockIndexAt, etc., and a wide variety of constructors allowing for default level creation, random level creation, and of course level creation from a text file in a specified format. A LevelBoard instance has instances of Block and Goal classes, and keeps track of other important data such as the number of moves allotted. With this structure, all needed backend calculations are allocated to their respective classes, but only a single interface is needed to interact with the frontend and user inputs.
<br>
<br>

The frontend was developed using the graphics library Java Swing and Graphics2D library. There were three total components for frontend, apart from learning about these libraries.
<br>
<br>

Screen Maneuvering
Game Screen graphics
Accessing backend to display on game screen (ex: .txt files)
<br>
<br>

For the Game Screen, we created a separate component called BoardGrid, which saved, painted, and repainted the board for every update. The mouseclicks were used relative to this board, not the whole screen to work nicely with the backend logic.
<br>
<br>

Screen maneuvering included making an instance of the backend class LevelBoard, and passing that instance into each of the graphics classes used for board display for each level.
<br>
<br>

File management was a big part in managing next game level loading and previous level loading. This was handled by a screen management class.4
<br>
<br>

Attractiveness was also taken into account. There are gifs and colorful designs throughout our game.
<br>
<br>
<br>

**Installation Instructions** 


In your command line, type ``java -version``. If there is an error, install Java from [Oracle](https://www.oracle.com/java/technologies/downloads/) website. Once Java is installed, in your command line, execute 

``git clone https://github.com/CS222SP22/course-project-vf-a``.

To play the game, navigate to the installation directory and run

```cd src```

```java Main.java```

On Windows, you may have to run ``javac Main.java`` and then ``java Main``. Compile any remaining files as necessary.
<br>
<br>
<br>

**Group Members and Roles**


Akash: Implemented much of the user interface other than the game board. Worked on creating a seamless transition between game screens (game menu, game won screen, quitting, instruction screen, and previous level). Created a file management system to organize next level and previous level screens. Provided aesthetics in the form of colors, gifs, and attractive instruction screens.

Daniel: Worked on Backend, created class interface functions for the Level class governing backend logic, designed levels, developed random level generation

Labdhi: Implemented Graphics2D into the project that enables user interactions with the screen and repaints the screen. Implemented all game functionality, including connecting backend logic with the graphics, as well as connecting the BoardGrid component with the Game Screen.

Manuj: Implemented backend testing logic, win-checking, and level board structure, including parameterization and parsing of level files. Also began development of level creator functionality.