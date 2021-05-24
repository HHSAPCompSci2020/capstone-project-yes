package elements;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import processing.core.PApplet;

/**
 * Used to create the checkpoint the car needs to pass during the game to prevent cheating
 * 
 * @author Alex Lan
 * @version 5/23/21
 */
public class Checkpoint extends Rectangle2D.Double {
	//private static final int WIDTH = 45;
	//private static final int HEIGHT = 60;
	
	private int x,y,w,h,num;
	private Color c;
	
	/**
	 * Checkpoint constructor
	 * @param c color of the Checkpoint object
	 * @param x x-coordinate of Checkpoint object
	 * @param y y-coordinate of Checkpoint object
	 * @param w width of the Checkpoint object
	 * @param h height of the Checkpoint object
	 * @param num number corresponding to each checkpoint object.
	 */
	public Checkpoint(Color c, int x, int y, int w, int h, int num) {
		super(x,y,w,h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
		this.num = num;
	}
	
	/**
	 * the checkpoint's number
	 * @return the number correlated to the Checkpoint object
	 */
	public int getNum()
	{
		return num;
	}
	
	/**
	 * Changes the color of the Checkpoint object to the specified color
	 * @param c new color the Checkpoint object will become
	 */
	public void setColor(Color c)
	{
		this.c = c;
	}
	
	/**
	 * Draws the Checkpoint object on the specified PApplet
	 * @param surface user-inputed surface that the Checkpoint object will be drawn on
	 */
	public void draw(PApplet surface) {
		surface.push();
		surface.noStroke();
		surface.fill(c.getRed(),c.getGreen(),c.getBlue());
		surface.rect(x, y, w, h);
		surface.pop();
	}
	
	

}
