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
	
	
	private double speed, direction, friction;
	private Projectile projectile;
	
	public Car(PImage img, int x, int y) {
		super(img, x, y, CAR_WIDTH, CAR_HEIGHT);
		speed = 0;
		direction = 0;
		friction *= 0.85;
	}
	
	public void accelerate() {
		if(speed <= 30 && speed >= -30)
			speed += 5;
	}
	
	
	public void turn(int turn) {
		direction += turn;
	}
	
	public void boost() {
		speed = 100;
	}
	
	public void shoot() {
		projectile = new Projectile();
		projectile.shoot();
	}
	
	public void act() {
		double xCoord = getX();
		double yCoord = getY();
		
		double vy = speed * Math.sin(Math.toRadians(direction));
		double vx = speed * Math.cos(Math.toRadians(direction));
		
		speed *= friction;
		
		if (Math.abs(speed) < .5)
			speed = 0;
		
		yCoord += vy;
		xCoord += vx;
		
		/*
		if(projectile touches car) {
			speed = 0;
			projectile = null;
		}
		*/
		
		moveToLocation(xCoord,yCoord);
	
	}
	
	

}
