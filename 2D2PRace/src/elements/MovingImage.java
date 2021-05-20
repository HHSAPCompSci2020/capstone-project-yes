package elements;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Used to create the moving images used by other classes
 * 
 * @author Alex Lan
 * @version 5/20/21
 */
public class MovingImage extends Rectangle2D.Double {
	
	private ArrayList<PImage> images;
	private int imageUsed;

	/**
	 * MovingImage constructor
	 * @param img specified image imported from the project files
	 * @param x x-coordinate of the image
	 * @param y y-coordinate of the image
	 * @param w width of the image
	 * @param h height of the image
	 */
	public MovingImage(ArrayList<PImage> img, int x, int y, int w, int h) {
		super(x,y,w,h);
		images = img;
		imageUsed = 0;
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
	
	/*
	public void rotate() {
		double xCenter = super.x + super.width/2;
		double yCenter = super.y + super.height/2;
		
		double temp = super.width;
		super.width = super.height;
		super.height = temp;
		
		super.x = xCenter - super.width/2;
		super.y = yCenter - super.height/2;
	}
	*/
	/*
	public PImage getImage() {
		return image;
	}
	*/

	public void changeImage(int i)
	{
		//System.out.println(i);
		imageUsed = i;
	}
	
	/**
	 * Draws the moving image object on the specified PApplet
	 * @param g PApplet to draw the MovingImage object onto
	 */
	public void draw(PApplet g) {
		g.push();
		g.image(images.get(imageUsed),(int)x,(int)y,(int)width,(int)height);
		g.pop();
	}
	
	
}