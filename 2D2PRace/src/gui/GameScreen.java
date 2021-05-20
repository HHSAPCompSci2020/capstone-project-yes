package gui;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import elements.Car;
import elements.Checkpoint;
import elements.Projectile;
import processing.core.PImage;

/**
 * Used by DrawingSurface to draw the specified screen, which is to show the 
 * player the game interface
 * 
 * @author Connor Chow
 * @version 5/20/21
 */
public class GameScreen extends Screen {

	private DrawingSurface surface;
	private Car p1,p2;
	private ArrayList<Shape> obstacles;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Checkpoint> checkpoints;
	private ArrayList<PImage> p1Images, p2Images, projImages;
	private int p1Score, p2Score, win;
	
	/**
	 * Creates a new GameScreen that takes in the DrawingSurface
	 * @param surface DrawingSurface that will display the graphics
	 */
	public GameScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		p1Score = 0;
		p2Score = 0;
		win = 0;
		
		p1Images = new ArrayList<PImage>();
		p2Images = new ArrayList<PImage>();
		projImages = new ArrayList<PImage>();
		
		obstacles = new ArrayList<Shape>();
		obstacles.add(new Rectangle(250,250,100,50));
		obstacles.add(new Rectangle(550,250,100,50));
		obstacles.add(new Rectangle(0, 0, 960, 25));
		obstacles.add(new Rectangle(0, 490, 960, 50));
		obstacles.add(new Rectangle(0, 0, 25, 515));
		obstacles.add(new Rectangle(935, 0, 25, 515));
		
		checkpoints = new ArrayList<Checkpoint>();
		checkpoints.add(new Checkpoint(new Color(255,246,3),275,300,50,300,0));
		checkpoints.add(new Checkpoint(new Color(255,255,255),575,300,50,300,1));
		checkpoints.add(new Checkpoint(new Color(255,255,255),575,0,50,300,2));
		checkpoints.add(new Checkpoint(new Color(255,255,255),275,0,50,300,3));
		
		projectiles = new ArrayList<Projectile>();
	}
	
	/**
	 * Loads in the two cars and projectile image
	 */
	public void setup()
	{
		p1Images.add(surface.loadImage("car1-1.png"));
		p1Images.add(surface.loadImage("car1-2.png"));
		p1Images.add(surface.loadImage("car1-3.png"));
		p1Images.add(surface.loadImage("car1-4.png"));
		p1Images.add(surface.loadImage("car1-5.png"));
		p1Images.add(surface.loadImage("car1-6.png"));
		p1Images.add(surface.loadImage("car1-7.png"));
		p1Images.add(surface.loadImage("car1-8.png"));
		
		p2Images.add(surface.loadImage("car2-1.png"));
		p2Images.add(surface.loadImage("car2-2.png"));
		p2Images.add(surface.loadImage("car2-3.png"));
		p2Images.add(surface.loadImage("car2-4.png"));
		p2Images.add(surface.loadImage("car2-5.png"));
		p2Images.add(surface.loadImage("car2-6.png"));
		p2Images.add(surface.loadImage("car2-7.png"));
		p2Images.add(surface.loadImage("car2-8.png"));		
		
		projImages.add(surface.loadImage("projectile.png"));
		
		p1 = new Car(p1Images, 215, 340, 45, 45);
		p2 = new Car(p2Images, 215, 400, 45, 45);
		surface.loadImage("projectile.png");
	}
	
	/**
	 * Draws the game with the cars, boundaries, and checkpoints, 
	 * as well as updates them based on user required inputs.
	 * Also adds in projectiles based on the user inputting the specified keystroke.
	 * Deletes the Projectile object when the Projectile's lifespan is 0.
	 */
	public void draw()
	{
		surface.pushMatrix();
		
		surface.background(255);
		
		for(Checkpoint c : checkpoints)
		{
			if(c instanceof Checkpoint)
			{
				c.draw(surface);
			}
		}
		
		p1.draw(surface);
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
		
		String scoreBoard = "Scores:\nP1: " + p1Score + ", P2: " + p2Score
				+ "\nP1C: " + p1.getCheckpoint() + ", P2C: " + p2.getCheckpoint();
		surface.text(scoreBoard, surface.width/2 - 20, surface.height/2 + 20);
		
		surface.popMatrix();
		
		p1.act(obstacles);
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
				if(projectiles.get(x).intersects(p1) || projectiles.get(x).intersects(p2))
				{	
					if(projectiles.get(x).intersects(p1))
					{
						p1.deaccelerate();
					}
					if(projectiles.get(x).intersects(p2))
					{
						p2.deaccelerate();
					}
					projectiles.remove(x);
				}
				else if(projectiles.get(x).getLifespan() < 1)
				{
					projectiles.remove(x);
				}
			}
		}

		//Method when car crosses checkpoint
		for(Checkpoint c : checkpoints)
		{
			if(c instanceof Checkpoint)
			{
				if(c.getNum() != 0)
				{
					if(p1.intersects(c) && p2.intersects(c))
					{
						c.setColor(new Color(224,224,224));
						if(p1.getCheckpoint() == c.getNum() - 1)
						{
							p1.setCheckpoint(c.getNum());
						}
						if(p2.getCheckpoint() == c.getNum() - 1)
						{
							p2.setCheckpoint(c.getNum());
						}
					}
					else if(p1.intersects(c))
					{
						c.setColor(new Color(252, 240, 3));
						if(p1.getCheckpoint() == c.getNum() - 1)
						{
							p1.setCheckpoint(c.getNum());
						}
					}
					else if(p2.intersects(c))
					{
						c.setColor(new Color(53, 252, 3));
						if(p2.getCheckpoint() == c.getNum() - 1)
						{
							p2.setCheckpoint(c.getNum());
						}
					}
					else
					{
						c.setColor(new Color(255,255,255));
					}
				}
				else
				{
					if(p1.intersects(c) && p2.intersects(c))
					{
						c.setColor(new Color(255, 0, 0));
						if(p1.getCheckpoint() == 3)
						{
							p1.setCheckpoint(c.getNum());
							p1Score++;
						}
						if(p2.getCheckpoint() == 3)
						{
							p2.setCheckpoint(c.getNum());
							p2Score++;
						}
					}
					else if(p1.intersects(c))
					{
						c.setColor(new Color(252, 240, 3));
						if(p1.getCheckpoint() == 3)
						{
							p1.setCheckpoint(c.getNum());
							p1Score++;
						}
					}
					else if(p2.intersects(c))
					{
						c.setColor(new Color(53, 252, 3));
						if(p2.getCheckpoint() == 3)
						{
							p2.setCheckpoint(c.getNum());
							p2Score++;
						}
					}
					else
					{
						c.setColor(new Color(224,224,224));
					}
				}
			}
		}
		
		
		if(win == 0)
		{
			if (surface.isPressed(KeyEvent.VK_A))
			{
				//System.out.println("turn left");
				p1.turn(-5);
			}
			if (surface.isPressed(KeyEvent.VK_D))
			{
				//System.out.println("turn right");
				p1.turn(5);
			}
			else if (!(surface.isPressed(KeyEvent.VK_A)) && !(surface.isPressed(KeyEvent.VK_D)))
			{
				//System.out.println("forward");
			}
			if (surface.isPressed(KeyEvent.VK_W))
			{
				p1.accelerate();
			}
			if (surface.isPressed(KeyEvent.VK_V))
			{
				p1.boost();
			}
			if (surface.isPressed(KeyEvent.VK_C))
			{
				//System.out.println("p1 shot");
				Projectile p = new Projectile(projImages,
						(int)((p1.getCenterX()) + 40*Math.cos(Math.toRadians(p1.getDirection()))),
						(int)(p1.getCenterY() + 40*Math.sin(Math.toRadians(p1.getDirection()))),
						(int)(40*Math.cos(Math.toRadians(p1.getDirection()))),(int)(40*Math.sin(Math.toRadians(p1.getDirection()))));			
				projectiles.add(p);
			}
			if (surface.isPressed(KeyEvent.VK_LEFT))
			{
				p2.turn(-5);
			}
			if (surface.isPressed(KeyEvent.VK_RIGHT))
			{
				p2.turn(5);
			}
			if (surface.isPressed(KeyEvent.VK_UP))
			{
				p2.accelerate();
			}
			if (surface.isPressed(KeyEvent.VK_SLASH))
			{
				p2.boost();
			}
			if (surface.isPressed(KeyEvent.VK_PERIOD))
			{
				//System.out.println("p2 shot");
				Projectile p = new Projectile(projImages,
						(int)((p2.getCenterX()) + 40*Math.cos(Math.toRadians(p2.getDirection()))),
						(int)(p2.getCenterY() + 40*Math.sin(Math.toRadians(p2.getDirection()))),
						(int)(40*Math.cos(Math.toRadians(p2.getDirection()))),(int)(40*Math.sin(Math.toRadians(p2.getDirection()))));
				projectiles.add(p);
			}	
			if(p1Score >= 5)
			{
				win = 1;
				p1.setCheckpoint(0);
				p2.setCheckpoint(0);
			}
			else if(p2Score >= 5)
			{
				win = 2;
				p1.setCheckpoint(0);
				p2.setCheckpoint(0);
			}
		}
		else
		{
			if(win == 1)
			{
				surface.push();
				surface.fill(255,0,0);
				surface.text("P1 WINS", surface.width/2, surface.height*2/8);
				surface.pop();
			}
			else if(win == 2)
			{
				surface.push();
				surface.fill(255,0,0);
				surface.text("P2 WINS", surface.width/2, surface.height*2/8);
				surface.pop();
			}
		}
	}
	
	/*
	public void rotate(int turn, Car c) {
		double rad = surface.radians((float) turn);
		
		surface.pushMatrix();
		surface.imageMode(surface.CENTER);
		surface.translate((float)(c.getX() + c.getWidth()/2), (float)(c.getY() + c.getHeight()/2));
		surface.rotate((float) rad);
		surface.image(c.getImage(),(float)c.getX(),(float)c.getY());
		surface.popMatrix();
	}
	*/
	

}
