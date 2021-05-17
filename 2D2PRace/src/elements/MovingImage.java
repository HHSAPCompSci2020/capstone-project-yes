package elements;

import java.awt.geom.Rectangle2D;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Used to create the moving images used by other classes
 * 
 * @author Alex Lan
 * @version 5/14/21
 */
public class MovingImage extends Rectangle2D.Double {
	
	private PImage image;
	
	/**
	 * MovingImage constructor
	 * @param img specified image imported from the project files
	 * @param x x-coordinate of the image
	 * @param y y-coordinate of the image
	 * @param w width of the image
	 * @param h height of the image
	 */
	public MovingImage(PImage img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}
	
	/**
	 * Moves the image to the user's specified location
	 * @param x new specified x-coordinate location
	 * @param y new specified y-coordinate location
	 */
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	/**
	 * Moves the image a certain amount based on user input
	 * @param x amount to move the image on the x-axis
	 * @param y amount to move the image on the y-axis
	 */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
//	public void applyWindowLimits(int windowWidth, int windowHeight) {
//		x = Math.min(x,windowWidth-width);
//		y = Math.min(y,windowHeight-height);
//		x = Math.max(0,x);
//		y = Math.max(0,y);
//	}
	
	public void rotate(double degrees) {
		double xCenter = x + width/2;
		double yCenter = y + height/2;
		
		double temp = width;
		super.width = height;
		super.height = temp;
		
		super.x = xCenter - width/2;
		super.y = yCenter - height/2;
	}
	
	
	/**
	 * Draws the moving image object on the specified PApplet
	 * @param g PApplet to draw the MovingImage object onto
	 */
	public void draw(PApplet g) {
		g.image(image,(int)x,(int)y,(int)width,(int)height);
	}
	
	
}