[2D2PRace]
Authors: Alexander Lan and Connor Chow
Revision: 4/26/2021


Introduction: 
As a kid, you may have played with RC cars, and raced your friends. In fact, you may have come across a place called Inline Racing at the Vallco Shopping Center. You may have not heard of the name, but at least remembered a place in which racers could drive their Ferraris, at least the miniature version, and race others at high speeds on complex race tracks created for these radio controlled vehicles. Now, with the pandemic and Vallco being demolished, this simple racing video-game brings back some of the fun components of RC car racing right to your computer and adds some of its own spinoffs. Are you ready to put your hands back on the steering wheel?


2D2PRace is a top-down, classic 2D racing game specifically built for two players using the same computer. The game also includes physics to add realism, as well its own additions that make it a computer game. Your objective is simple: beat your opponent to the finish line. You have two gadgets you can use: boost and projectiles. Boost allows your vehicle to gain a quick burst of speed up to three times per game. Projectiles can also be used, being shot in the direction of the front of your car, and can go through walls. The projectiles will slow down or stop your opponent and don’t have a cooldown, but you will need high precision to stay locked onto these tiny, but fast, vehicles.


Instructions:
Keyboard keys: 


Mouse - Navigation 
MB1/LMB - Select
WASD - Player 1
‘C’ - Player 1 shoot projectile button
‘V’ - Player 1 boost
Arrow Keys - Player 2
‘.’ - Player 2 shoot projectile button
‘/’ - Player 2 boost
ESC - Quit


Places to click:
 
Anywhere on the Starting Screen, leading to the Menu screen, which has buttons specified on the menu screen to open the game’s GUI, that shows buttons


Intro Screen (Default when game is launched)
Click on the “Play” button to go to the Menu Screen
Press ‘Esc’ to quit the game (can be done on any screen)
Click at a specific a part of the screen to get the easter egg


Menu Screen
Press the “How to Play” button to go to the How to Play Screen
Press the Start button to go to the Game Screen


How to Play Screen
Displays the instructions as to how to play this game
Press the “Back” button to go back to Menu Screen


 Game Screen
The screen that displays the racing game
A “Back” button can be clicked to return to the menu screen once a player wins the game


The screens are all going to be in the same window






Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
* Checkpoints - Checkpoint objects used to detect when the car collides/runs over them so the players don’t race around the track the wrong way. These are also used to track where each car is and determine who wins the game. [DONE]
* Boundaries - Boundaries on the side, acting as walls so car objects don’t leave the track. The cars are confined within the track space.[DONE]
* Physics - Different physics concepts to make the cars’ mechanics realistic, including friction, velocity, etc. [DONE]
* Projectiles - Working projectiles shot from the Car objects that collide with both cars to sabotage the user whose car it collides with. [DONE]
* Boost - Gives the user a quick burst of speed to their car. Can be used to outrun the projectiles. [DONE]
* How-To-Play - Gives a brief description in the game to explain the controls on how to play the game. [DONE]


Want-to-have Features:
* Customization - A screen in the menu where the user can change the car’s colors/graphics to fit the user’s preference. [NOT DONE]
* Animated Menu / How-to-play screen - A menu and how to play screen that has a fluid design with smooth buttons. [DONE]
* Save presets - Saves user’s options/specifications when application is closed [NOT DONE]
* Sound - Sounds effects that trigger when different things occur [DONE]
* Custom Controls - Allows the user to change the controls to different buttons to fit their needs/play style [NOT DONE]


Stretch Features:
*  Multiplayer/Network play? (Depends if we learn server communication) - Different people can play on different computers to play against each other [NOT DONE]
*  AI - Working AI cars for the user to play against [NOT DONE]
*  3D Graphics - 3D graphics for the racing game, but still with a top-down view [NOT DONE]




Class List:
* Elements
   * Car: A 2D car being used to drive around
   * Checkpoint: An object that detects when a car has collided with it (to make sure the cars goes the correct way to earn a point for it’s lap)
   * Projectile: object fired from the car to sabotage other cars
   * MovingImage: A class that represents a moving image
* GUI
   * Main - creates a new game
   * Screen - super class that all screens extends
   * Screenswitcher - an interface that allows different screen to be switched
   * IntroScreen - Holds graphics for intro screen
   * MenuScreen - Holds graphics for menu screen
   * HowToPlayScreen - Holds graphics for screen on how to play the game
   * GameScreen  Holds graphics for the game itself
   * DrawingSurface - where the game will be “drawn” by processing
Credits:
Connor - Main, Intro Screen, MenuScreen, HowToPlayScreen, GameScreen, Projectile
Alexander - Car, CheckPoint, MovingImage
Used ScreenChanger, AnimationDemoProcessing, RotationInProcessing, and ProcessingSoundLibrary processing code from Mr. Shelby
Keyboard from*:
https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/MLA22LL?wid=4000&hei=1800&fmt=jpeg&qlt=95&.v=1496944005839 
Car Images from*:
https://opengameart.org/content/top-down-view-cars-and-trucks-racing-sprites 
https://www.stickpng.com/img/objects/fidget-toys/black-fidget-spinner 
Projectile Images from*:
https://static.thenounproject.com/png/98948-200.png 
https://www.graphicpie.com/among-us-png-free/ 
Fonts from: 
https://visme.co/blog/modern-fonts/ 
Sound effects from:
https://youtu.be/i0DON3AjhW4 
https://youtu.be/3cuQT1YZfVc 
https://youtu.be/GVAF07-2Xic 
Music from:
https://youtu.be/9OEqRRkYiU8 
Note* = we altered the images, but these are the original images that we used.
________________