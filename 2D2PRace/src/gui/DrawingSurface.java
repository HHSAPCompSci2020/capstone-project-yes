package gui;

import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.sound.SoundFile;
/**
 * Used by Main class/method to draw the game that is projected onto the screen
 * 
 * @author Connor Chow
 * @version 5/24/21
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {

	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	private boolean imgChanger;
	
	private String[] soundFileNames;
	private SoundFile[] sounds;
	
	/**
	 * Create a new DrawingSurface that fills in the different screens (using an ArrayList to store the different screens)
	 */
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		keys = new ArrayList<Integer>();
		
		IntroScreen introScreen = new IntroScreen(this);
		screens.add(introScreen);
		
		MenuScreen menuScreen = new MenuScreen(this);
		screens.add(menuScreen);
		
		HowToPlayScreen howToPlayScreen = new HowToPlayScreen(this);
		screens.add(howToPlayScreen);
		
		GameScreen gameScreen = new GameScreen(this);
		screens.add(gameScreen);
		
		activeScreen = screens.get(ScreenSwitcher.INTROSCREEN);
		
		imgChanger = false;
		
		soundFileNames = new String[] {"data/bgMusic.mp3", "data/mouseClick.mp3", "data/victorySound.mp3", "data/ding.mp3"};
		sounds = new SoundFile[soundFileNames.length];
	}
	
	/**
	 * Sets up each screen and loads all the sounds.
	 * Originally shows a loading screen while the sounds are loaded in.
	 * (Estimate time: 10-15 seconds to load in the sound files)
	 */
	public void setup() {
		push();
		background(255);
		fill(0);
		textSize(10);
		text("Loading",50,50,width - 100,500);
		pop();
		for (Screen s : screens)
			s.setup();
		loadNextSong();
		sounds[0].amp((float) 0.05);
		sounds[1].amp((float) 0.1);
		sounds[2].amp((float) 0.1);
		sounds[3].amp((float) 0.075);

	}

	/**
	 * Draws the active screen
	 */
	public void draw() {
		activeScreen.draw();
	}
	
	// ----------------------
	
	/**
	 * Refreshes the GameScreen by creating a new one and adding it to the ArrayList of screens.
	 */
	public void refreshGameScreen()
	{
		GameScreen gameScreen = new GameScreen(this);
		screens.set(ScreenSwitcher.GAMESCREEN,gameScreen);
		screens.get(ScreenSwitcher.GAMESCREEN).setup();
	}
	
	// ----------------------
	
	/**
	 * Takes the input of a key when it is pressed and stores it
	 */
	public void keyPressed() {
		keys.add(keyCode);
	}

	/**
	 * Takes the input of a key when it is released and removes it
	 */
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	/**
	 * Checks if a key is being pressed
	 * 
	 * @param code int value of the key that is being checked
	 * @return if the key specified is being pressed or not
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	/**
	 * Takes the input of the mouse when it is pressed and inputs it for the active screen
	 */
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	/**
	 * Takes the input of the mouse when it is moved and inputs it for the active screen
	 */
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	/**
	 * Takes the input of the mouse when it is dragged and inputs it for the active screen
	 */
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	/**
	 * Takes the input of the mouse when it is released and inputs it for the active screen
	 */
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	// ----------------------

	@Override
	/**
	 * Switches the screen to a different screen from its current one
	 * @param i specified screen int value to switch to
	 */
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}
	
	// ----------------------

	/**
	 * Changes the images (used mainly for GameScreen)
	 * @param b true or false = custom or default
	 */
	public void setImageChanger(boolean b) {
		imgChanger = b;
	}
	
	/**
	 * Returns whether the images should be changed or not
	 * @return true or false, whether images should be changed or not
	 */
	public boolean imageChanger() {
		return imgChanger;
	}
	
	/**
	 * Loads the sound files
	 */
	private void loadNextSong() {
		for (int loadIndex = 0; loadIndex < soundFileNames.length; loadIndex++) {
			sounds[loadIndex] = new SoundFile(this, soundFileNames[loadIndex]);
		}
	}
	
	/**
	 * Plays a specific sound effect or song
	 * @param i inputed number correlated to a song or sound in the list on the DrawingSurface object
	 */
	public void playSound(int i) {
		sounds[i].cue(0);
		sounds[i].play();
	}
	
	/**
	 * Stops the specified sound from playing
	 * @param i inputed number correlated to a song or sound in the list on the DrawingSurface object
	 */
	public void stopSound(int i) {
		sounds[i].stop();
	}
}
