package elements;

import java.util.ArrayList;

import gui.GameScreen;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Used to create the projectile used by the car to sabotage the other car during the game
 * 
 * @author Alex Lan
 * @version 5/20/21
 */
public class Projectile extends MovingImage {
	
	public static final int PROJ_WIDTH = 10;
	public static final int PROJ_HEIGHT = 10;
	
	private double xv, yv;
	private int lifespan;
	
	/**
	 * Project constructor with a lifespan int set to 60 (approx. 1 second).
	 * 
	 * @param img image file that the car will be using
	 * @param x x-coordinate of the projectile
	 * @param y y-coordinate of the projectile
	 * @param xv x-velocity of the projectile
	 * @param yv y-velocity of the projectile
	 */
	public Projectile(ArrayList<PImage> img, int x, int y, int xv, int yv) {
		super(img, x, y, PROJ_WIDTH, PROJ_HEIGHT);
		
		this.xv = xv;
		this.yv = yv;
		lifespan = 60;
	}
	
	/**
	 * Changes the location of the Projectile object.
	 * Also lowers the lifespan of the projectile.
	 */
	public void act() {
		moveToLocation(getX()+xv,getY()+yv);
		lifespan--;
	}
	
	/**
	 * Returns the current lifespan left of the projectile.
	 * @return integer for the lifespan of the Projectile object
	 */
	public int getLifespan()
	{
		return lifespan;
	}
	

}
