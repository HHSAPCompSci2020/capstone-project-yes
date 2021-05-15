package elements;

import processing.core.PApplet;

/**
 * Used to create the checkpoint the car needs to pass during the game to prevent cheating
 * 
 * @author Alex Lan
 * @version 5/7/21
 */
public class Checkpoint {
	private static final int WIDTH = 45;
	private static final int HEIGHT = 60;
	
	private int x;
	private int y;
	
	public Checkpoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(PApplet surface) {
		surface.fill(0, 0, 255);
		surface.rect(x, y, WIDTH, HEIGHT);
	}
	
	

}
