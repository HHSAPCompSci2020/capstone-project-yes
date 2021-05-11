package elements;

import processing.core.PImage;

/**
 * Used to create the 2D car the User will control to play the game
 * 
 * @author Alex Lan
 * @version 5/7/21
 */
public class Car {
	
	private double xVelocity, yVelocity;
	private Projectile projectile;
	
	public Car(PImage img) {
		xVelocity = 0;
		yVelocity = 0;
	}

}
