package elements;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import gui.GameScreen;
import processing.core.PApplet;
import processing.core.PImage;


/**
 * Used to create the 2D car the User will control to play the game.
 * Uses a custom images that moves.
 * 
 * @author Alex Lan
 * @version 5/14/21
 */
public class Car extends MovingImage {
	
	private static final int CAR_WIDTH = 45;
	private static final int CAR_HEIGHT = 60;
	
	private double speed, direction, friction, xVelocity, yVelocity;
	private boolean onAWall;
	
	/**
	 * Car constructor
	 * 
	 * @param img image file that the car will be using
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public Car(PImage img, int x, int y) {
		super(img, x, y, CAR_WIDTH, CAR_HEIGHT);
		speed = 0;
		direction = 0;
		xVelocity = 0;
		yVelocity = 0;
		friction = 0.85;
		onAWall = false;
	}
	
	/**
	 * Accelerates the car by adding to the speed of the car
	 */
	public void accelerate() {
		if(speed <= 30 && speed >= -30)
			speed += 2;
	}
	
	/**
	 * Turns the car by a specified angle
	 * @param turn angle the car will turn (in degrees)
	 */
	public void turn(int turn) {
		direction += turn;
	}
	
	/**
	 * Boosts the car in the direction the car is facing
	 */
	public void boost() {
		speed = 40;
	}
	
	/**
	 * Calculates the velocity of the car in the x and y direction based on the car's direction it is facing (in degrees),
	 * as well as the speed (based on how much the user accelerates).
	 * The friction to the ground is also calculated, as well as the collision with the wall objects.
	 * These all are then used to update the position of the car.
	 * @param walls ArrayList of walls that the car cannot pass through
	 */
	public void act(ArrayList<Shape> walls) {
		yVelocity = speed * Math.sin(Math.toRadians(direction));
		xVelocity = speed * Math.cos(Math.toRadians(direction));

		speed *= friction;
		
		double xCoord = getX();
		double yCoord = getY();
		double width = getWidth();
		double height = getHeight();

		// ***********Y AXIS***********

		double yCoord2 = yCoord + yVelocity;

		Rectangle2D.Double strechY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoord2),width,height+Math.abs(yVelocity));

		onAWall = false;

		if (yVelocity > 0) {
			Shape standingSurface = null;
			for (Shape s : walls) {
				if (s.intersects(strechY)) {
					onAWall = true;
					standingSurface = s;
					yVelocity = 0;
				}
			}
			if (standingSurface != null) {
				Rectangle r = standingSurface.getBounds();
				yCoord2 = r.getY()-height;
			}
		} else if (yVelocity < 0) {
			Shape headSurface = null;
			for (Shape s : walls) {
				if (s.intersects(strechY)) {
					headSurface = s;
					yVelocity = 0;
				}
			}
			if (headSurface != null) {
				Rectangle r = headSurface.getBounds();
				yCoord2 = r.getY()+r.getHeight();
			}
		}

		// ***********X AXIS***********

		double xCoord2 = xCoord + xVelocity;

		Rectangle2D.Double strechX = new Rectangle2D.Double(Math.min(xCoord,xCoord2),yCoord2,width+Math.abs(xVelocity),height);

		if (xVelocity > 0) {
			Shape rightSurface = null;
			for (Shape s : walls) {
				if (s.intersects(strechX)) {
					rightSurface = s;
					xVelocity = 0;
				}
			}
			if (rightSurface != null) {
				Rectangle r = rightSurface.getBounds();
				xCoord2 = r.getX()-width;
			}
		} else if (xVelocity < 0) {
			Shape leftSurface = null;
			for (Shape s : walls) {
				if (s.intersects(strechX)) {
					leftSurface = s;
					xVelocity = 0;
				}
			}
			if (leftSurface != null) {
				Rectangle r = leftSurface.getBounds();
				xCoord2 = r.getX()+r.getWidth();
			}
		}


		if (Math.abs(speed) < .000005)
			speed = 0;

		moveToLocation(xCoord2,yCoord2);
	}
	
	/**
	 * Gets the velocity of the car on the x axis
	 * @return the specified car object's x velocity
	 */
	public double getXVelocity()
	{
		return xVelocity;
	}
	
	/**
	 * Gets the velocity of the car on the y axis
	 * @return the specified car object's y velocity
	 */
	public double getYVelocity()
	{
		return yVelocity;
	}
	
	/**
	 * Gets the direction of the car (in degrees)
	 * @return the specified car object's angle (in degrees)
	 */
	public double getDirection()
	{
		return direction;
	}
}
