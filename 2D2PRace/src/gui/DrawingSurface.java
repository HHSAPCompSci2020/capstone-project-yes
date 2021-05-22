package gui;

import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
/**
 * Used by Main class/method to draw the game that is projected onto the screen
 * 
 * @author Connor Chow
 * @version 5/21/21
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {

	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	private boolean imgChanger;
	
	/**
	 * Create a new DrawingSurface that fills in the different screens
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
	}
	
	/**
	 * Sets up each screen
	 */
	public void setup() {
		for (Screen s : screens)
			s.setup();
	}

	/**
	 * Draws the active screen
	 */
	public void draw() {
		activeScreen.draw();
	}
	
	// ----------------------
	
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

	public void setImageChanger(boolean b) {
		imgChanger = b;
	}
	public boolean imageChanger() {
		return imgChanger;
	}
}
