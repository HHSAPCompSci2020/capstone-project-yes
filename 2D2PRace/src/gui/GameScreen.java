package gui;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import elements.Car;
import elements.Projectile;

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
	private ArrayList<Shape> obstacles;
	private ArrayList<Projectile> projectiles;
	
	/**
	 * Creates a new GameScreen that takes in the DrawingSurface
	 * @param surface DrawingSurface that will display the graphics
	 */
	public GameScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		obstacles = new ArrayList<Shape>();
		obstacles.add(new Rectangle(250,250,100,50));
		obstacles.add(new Rectangle(550,250,100,50));
		obstacles.add(new Rectangle(0, 0, 960, 25));
		obstacles.add(new Rectangle(0, 490, 960, 50));
		obstacles.add(new Rectangle(0, 0, 25, 515));
		obstacles.add(new Rectangle(935, 0, 25, 515));
		
		projectiles = new ArrayList<Projectile>();
	}
	
	/**
	 * Loads in the two cars
	 */
	public void setup()
	{
//		p1 = new Car(surface.loadImage("car1-1.png"),560,350);
		p2 = new Car(surface.loadImage("car1-2.png"),500,350);
		surface.loadImage("projectile.png");
		
	}
	
	/**
	 * Draws the game with the cars as well as updates them based on user required inputs
	 */
	public void draw()
	{
		surface.pushMatrix();
		
		surface.background(255);
//		p1.draw(surface);
		p2.draw(surface);
		
		for(Projectile p : projectiles)
		{
			if (p instanceof Projectile)
			{
				p.draw(surface);
			}
		}
		
		for (Shape s : obstacles) {
			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle)s;
				surface.rect(r.x,r.y,r.width,r.height);
			}
		}
		
		surface.popMatrix();
		
		p2.act(obstacles);
		for(Projectile p : projectiles)
		{
			if (p instanceof Projectile)
			{
				p.act();
			}
		}
		
		if(projectiles.size() > 0)
		{
			for(int x = projectiles.size() - 1; x >= 0; x--)
			{
				if(projectiles.get(x).getLifespan() < 1)
				{
					projectiles.remove(x);
				}
			}
		}
		
		if (surface.isPressed(KeyEvent.VK_LEFT))
			p2.turn(-5);
		if (surface.isPressed(KeyEvent.VK_RIGHT))
			p2.turn(5);
		if (surface.isPressed(KeyEvent.VK_UP))
			p2.accelerate();
		if (surface.isPressed(KeyEvent.VK_DOWN))
			p2.boost();
		if (surface.isPressed((int)'.'))
		{
			System.out.println("shot");
			Projectile p = new Projectile(surface.loadImage("projectile.png"),
					(int)((p2.getCenterX()) + 40*Math.cos(Math.toRadians(p2.getDirection()))),
					(int)(p2.getCenterY() + 40*Math.sin(Math.toRadians(p2.getDirection()))),
					(int)(p2.getXVelocity()*5),(int)(p2.getYVelocity()*5));
			projectiles.add(p);
		}		
		
	}

}
