[2D2P Race]
Authors: Alexander Lan and Connor Chow
Revision: 4/26/2021


Introduction: 
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do?
What problem does it solve? Why did you write it?
What is the story?
What are the rules? What is the goal?
Who would want to use your program?
What are the primary features of your program?]


This program is a top-down, classic 2d racing game specifically built for local players with projectiles and physics. Your objective is simple: beat your opponent to the finish line. You have two gadgets you can use: boost and projectiles. Boost allows you to give your car a quick burst of speed. Projectiles will shoot forward only out of the car and will slow down your opponent if you hit them.


Instructions:
Keyboard keys: 


Mouse - Navigation 
MB1/LMB - Select
WASD - Player 1
‘1’ - Player 1 shoot projectile button
‘Q’ - Player 1 boost
Arrow Keys - Player 2
‘.’ - Player 2 shoot projectile button
‘/’ - Player 2 boost
ESC - Pause / Quit


Places to click:
 
Anywhere on the Starting Screen, leading to the Menu screen, which has buttons specified on the menu screen to open the game’s GUI, that shows buttons


Starting Screen
Click on Menu to go to the menu screen 
Click quit to quit


Menu Screen
Press Start to go to the Players Screen
Press Customize to go to the Customize Screen
Press the back button to exit to the starting screen


Cars Screen
Click on any of the cars available for you
Once selected a car, then press maps 


Map Screen
Click on a map that you want to race in.  
Once selected a map, then press game modes
 
The screens are all going to be in the same window


Customization
Click on the different cars available
Click on the one of the different presents available for that car
Click back to go to the menu screen




Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
* Checkpoints - so car objects don’t exploit racing around the track
* Boundaries - so car objects don’t leave the track / confined within the track space
* Physics - friction, velocity, etc.
* Projectiles - working projectiles that collide with cars to sabotage the specified user
* Boost - Gives the users  a quick burst of speed to the car
* How-To-Play - Gives a brief description as to how to play the game


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
* Customization - changing the car’s colors/graphics to the user’s preference
* Animated Menu / How-to-play screen
* Save presets - saves user’s options/specifications when application is closed
* Sound - sounds effects when different things occurring
* Custom Controls - Allows the user to change the controls to different buttons for their needs


Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
*  Multiplayer/Network play? (Depends if we learn server communication) - Different people can play on different computers to play against each other
*  AI - Working AI cars to play against
*  3D Graphics - 3D graphics for the racing game, but still with a top-down view




Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]
* Elements
   * Car: A 2D car being used to drive around
   * Checkpoint: An object that detects when a car has collided with it (to make sure the cars goes the correct way to earn a point for it’s lap)
   * Projectile: object fired from the car to sabotage other cars
   * MovingImage: A class that represents a moving image
* GUI
   * Main - creates a new game
   * IntroScreen - Holds graphics for intro screen
   * MenuScreen - Holds graphics for menu screen
   * CustomizationScreen - Holds graphics for car customization screen
   * PauseScreen - Holds graphics for pause screen
   * HowToPlayScreen - Holds graphics for screen on how to play the game
   * GameScreen  Holds graphics for the game itself
Credits:
Connor - Main, Intro Screen, MenuScreen, HowToPlayScreen, GameScreen, Projectile
Alexander - Car, CheckPoint, MovingImage
Used ScreenChanger and AnimationDemoProcessing processing code from Mr. Shelby
Car Images from https://opengameart.org/content/top-down-view-cars-and-trucks-racing-sprites 
Circle Projectile from https://static.thenounproject.com/png/98948-200.png 
________________