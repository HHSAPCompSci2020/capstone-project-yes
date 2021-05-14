package gui;

import java.awt.event.KeyEvent;

import elements.Car;

/**
 * Used by DrawingSurface to draw the specified screen, which is to show the 
 * player the game interface
 * 
 * @author Connor Chow
 * @version 5/7/21
 */
public class GameScreen extends Screen {

	private DrawingSurface surface;
	private Car p1,p2;
	
	public GameScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
	}
	
	/**
	 * 
	 */
	public void setup()
	{
		p1 = new Car(surface.loadImage("car1-1.png"),560,350);
		p2 = new Car(surface.loadImage("car1-2.png"),500,350);
	}
	
	/**
	 * 
	 */
	public void draw()
	{
		surface.pushMatrix();
		
		surface.background(255);
		p1.draw(surface);
		p2.draw(surface);
		
		surface.popMatrix();
		
		if (surface.isPressed(KeyEvent.VK_LEFT))
			p2.turn(-1);
		if (surface.isPressed(KeyEvent.VK_RIGHT))
			p2.turn(1);
		if (surface.isPressed(KeyEvent.VK_UP))
			p2.accelerate();
		
		
		p2.act();
	}
	
}
