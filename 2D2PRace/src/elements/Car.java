package elements;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

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
	private boolean onAWall;
	private Projectile projectile;
	
	public Car(PImage img, int x, int y) {
		super(img, x, y, CAR_WIDTH, CAR_HEIGHT);
		speed = 0;
		direction = 0;
		friction *= 0.99;
		onAWall = false;
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
	
	public void act(ArrayList<Shape> walls) {
		double xCoord = getX();
		double yCoord = getY();
		double width = getWidth();
		double height = getHeight();


		speed *= friction;
		double vy = speed * Math.sin(Math.toRadians(direction));
		double yCoord2 = yCoord + vy;

		Rectangle2D.Double strechY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoord2),width,height+Math.abs(speed));

		onAWall = false;

		if (speed > 0) {
			Shape standingSurface = null;
			for (Shape s : walls) {
				if (s.intersects(strechY)) {
					onAWall = true;
					standingSurface = s;
					speed = 0;
				}
			}
			if (standingSurface != null) {
				Rectangle r = standingSurface.getBounds();
				yCoord2 = r.getY()-height;
			}
		} else if (speed < 0) {
			Shape headSurface = null;
			for (Shape s : walls) {
				if (s.intersects(strechY)) {
					headSurface = s;
					speed = 0;
				}
			}
			if (headSurface != null) {
				Rectangle r = headSurface.getBounds();
				yCoord2 = r.getY()+r.getHeight();
			}
		}


		double vx = speed * Math.cos(Math.toRadians(direction));
		double xCoord2 = yCoord + vx;

		Rectangle2D.Double strechX = new Rectangle2D.Double(Math.min(xCoord,xCoord2),yCoord2,width+Math.abs(speed),height);

		if (speed > 0) {
			Shape rightSurface = null;
			for (Shape s : walls) {
				if (s.intersects(strechX)) {
					rightSurface = s;
					speed = 0;
				}
			}
			if (rightSurface != null) {
				Rectangle r = rightSurface.getBounds();
				xCoord2 = r.getX()-width;
			}
		} else if (speed < 0) {
			Shape leftSurface = null;
			for (Shape s : walls) {
				if (s.intersects(strechX)) {
					leftSurface = s;
					speed = 0;
				}
			}
			if (leftSurface != null) {
				Rectangle r = leftSurface.getBounds();
				xCoord2 = r.getX()+r.getWidth();
			}
		}


		if (Math.abs(speed) < .5)
			speed = 0;

		moveToLocation(xCoord2,yCoord2);
	}
	
	
	

}
