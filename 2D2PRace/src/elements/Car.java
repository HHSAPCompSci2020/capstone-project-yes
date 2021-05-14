package elements;

import processing.core.PImage;

/**
 * Used to create the 2D car the User will control to play the game
 * 
 * @author Alex Lan
 * @version 5/7/21
 */
public class Car extends MovingImage {
	
	private static final int CAR_WIDTH = 45;
	private static final int CAR_HEIGHT = 60;
	
	
	private double xSpeed, ySpeed;
	private Projectile projectile;
	
	public Car(PImage img, int x, int y) {
		super(img, x, y, CAR_WIDTH, CAR_HEIGHT);
		xSpeed = 0;
		ySpeed = 0;
		projectile = new Projectile();
	}
	
	public void accelerate() {
		
	}
	
	public void turn() {
		
	}
	
	public void boost() {
		
	}
	
	public void shoot() {
		
	}
	
	

}
