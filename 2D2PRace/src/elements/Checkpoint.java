package elements;

import processing.core.PApplet;

/**
 * Used to create the checkpoint the car needs to pass during the game to prevent cheating
 * 
 * @author Alex Lan
 * @version 5/14/21
 */
public class Checkpoint {
	private static final int WIDTH = 45;
	private static final int HEIGHT = 60;
	
	private int x;
	private int y;
	
	/**
	 * Checkpoint constructor
	 * @param x x-coordinate of Checkpoint object
	 * @param y y-coordinate of Checkpoint object
	 */
	public Checkpoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Draws the Checkpoint object on the specified PApplet
	 * @param surface user-inputed surface that the Checkpoint object will be drawn on
	 */
	public void draw(PApplet surface) {
		surface.fill(0, 0, 255);
		surface.rect(x, y, WIDTH, HEIGHT);
	}
	
	

}
