package gui;

import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet implements ScreenSwitcher {

	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		keys = new ArrayList<Integer>();
		
		IntroScreen introScreen = new IntroScreen(this);
		screens.add(introScreen);
		
		MenuScreen menuScreen = new MenuScreen(this);
		screens.add(menuScreen);
		
		activeScreen = screens.get(ScreenSwitcher.INTROSCREEN);
	}
	
	public void setup() {
		for (Screen s : screens)
			s.setup();
	}

	public void draw() {
		activeScreen.draw();
	}
	
	// ----------------------
	
	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	// ----------------------

	@Override
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}
