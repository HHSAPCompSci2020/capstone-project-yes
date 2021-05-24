package gui;

import java.awt.Color;
import java.awt.Point;
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
 * @version 5/23/21
 */
public class GameScreen extends Screen {

	private DrawingSurface surface;
	private Car p1,p2;
	private ArrayList<Shape> obstacles;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Checkpoint> checkpoints;
//	private ArrayList<PImage> p1Images, p2Images, projImages;
	private int p1Score, p2Score, win;
	private int returnButtonNum;
	private Rectangle returnButton;

	/**
	 * Creates a new GameScreen that takes in the DrawingSurface.
	 * Sets the scores to 0, and adds all the obstacles, checkpoints, projectiles, and return button into the game.
	 * @param surface DrawingSurface that will display the graphics
	 */
	public GameScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		p1Score = 0;
		p2Score = 0;
		win = 0;
		
		returnButtonNum = 0;
		
//		p1Images = new ArrayList<PImage>();
//		p2Images = new ArrayList<PImage>();
//		projImages = new ArrayList<PImage>();
		
		obstacles = new ArrayList<Shape>();
		obstacles.add(new Rectangle(0, 0, 960, 15));
		obstacles.add(new Rectangle(0, 505, 960, 15));
		obstacles.add(new Rectangle(0, 0, 15, 515));
		obstacles.add(new Rectangle(945, 0, 15, 515));
		obstacles.add(new Rectangle(320,335,490,20));
		obstacles.add(new Rectangle(840,240,120,20));
		obstacles.add(new Rectangle(680,160,20,180));
		obstacles.add(new Rectangle(120,140,700,20));
		obstacles.add(new Rectangle(120,140,20,260));
		obstacles.add(new Rectangle(220,350,20,200));
		obstacles.add(new Rectangle(320,140,20,195));
		
		checkpoints = new ArrayList<Checkpoint>();
		checkpoints.add(new Checkpoint(new Color(255,246,3),385,300,50,200,0));
		checkpoints.add(new Checkpoint(new Color(199, 196, 191),575,300,50,200,1));
		checkpoints.add(new Checkpoint(new Color(199, 196, 191),575,0,50,300,2));
		checkpoints.add(new Checkpoint(new Color(199, 196, 191),275,0,50,300,3));
		
		projectiles = new ArrayList<Projectile>();
		
//		returnButton = new Rectangle(surface.width/2-100,surface.height*7/10-50,200,100);
		returnButton = new Rectangle(372,340,200,100);
	}
	
	/**
	 * Loads in the two cars and projectile images
	 */
	public void setup()
	{
//		p1Images.add(surface.loadImage("car1-1.png"));
//		p1Images.add(surface.loadImage("car1-2.png"));
//		p1Images.add(surface.loadImage("car1-3.png"));
//		p1Images.add(surface.loadImage("car1-4.png"));
//		p1Images.add(surface.loadImage("car1-5.png"));
//		p1Images.add(surface.loadImage("car1-6.png"));
//		p1Images.add(surface.loadImage("car1-7.png"));
//		p1Images.add(surface.loadImage("car1-8.png"));
//		
//		p2Images.add(surface.loadImage("car2-1.png"));
//		p2Images.add(surface.loadImage("car2-2.png"));
//		p2Images.add(surface.loadImage("car2-3.png"));
//		p2Images.add(surface.loadImage("car2-4.png"));
//		p2Images.add(surface.loadImage("car2-5.png"));
//		p2Images.add(surface.loadImage("car2-6.png"));
//		p2Images.add(surface.loadImage("car2-7.png"));
//		p2Images.add(surface.loadImage("car2-8.png"));		
		
//		projImages.add(surface.loadImage("projectile.png"));
		
//		p1 = new Car(p1Images, 215, 340, 45, 45);
//		p2 = new Car(p2Images, 215, 400, 45, 45);
		if(surface.imageChanger()) {
			p1 = new Car(surface.loadImage("fidgetspinner1.png"), 215, 390, 35, 35);
			p2 = new Car(surface.loadImage("fidgetspinner2.png"), 215, 450, 35, 35);
			p1.setMode(true);
			p2.setMode(true);
		}
		else {
			p1 = new Car(surface.loadImage("car1-1.png"), 285, 400, 35, 35);
			p2 = new Car(surface.loadImage("car2-1.png"), 285, 450, 35, 35);
		}

		surface.loadImage("projectile.png");
	}
	
	/**
	 * Draws the game with the cars, boundaries, and checkpoints, 
	 * as well as updates them based on user required inputs.
	 * Also adds in projectiles based on the user inputting the specified keystroke.
	 * Deletes the Projectile object when the Projectile's lifespan is 0.
	 * Shows the graphics when a user wins and plays a victory sound effect.
	 */
	public void draw()
	{
		surface.push();
//		returnButton = new Rectangle(surface.width/2-returnButton.width/2,surface.height*7/10-returnButton.height/2,200,100);
		
		//bg color
		surface.background(237 + returnButtonNum, 234 + returnButtonNum, 229 + returnButtonNum);

		if(p1Score == 0 && p2Score == 0)
		{
			surface.fill(145, 6, 6);
			surface.rect(420,390,50,25);
			surface.triangle(470,380,470,425,495,402.5f);
			surface.rect(420,150,50,25);
			surface.triangle(420,140,420,185,395,162.5f);
		}
		
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
		surface.noStroke();
		//obstacle color
		surface.fill(150, 148, 143);
		//surface.fill(255);
		for (Shape s : obstacles) {
			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle)s;
				surface.rect(r.x,r.y,r.width,r.height);
			}
		}
		
		surface.fill(99 + returnButtonNum, 98 + returnButtonNum, 95 + returnButtonNum); //scoreboard color
		surface.textLeading(15);
		String scoreboard = "Scores:\nP1: " + p1Score + ", P1C: " + p1.getCheckpoint() + ", Boosts Left: " + p1.getBoost() 
							+ "\nP2: " + p2Score + ", P2C: " + p2.getCheckpoint() + ", Boosts Left: " + p2.getBoost();
		float scoreboardLength = surface.textWidth(scoreboard);
		surface.text(scoreboard, 30, 40);

		
		surface.pop();
		
		p1.act(obstacles, p2);
		p2.act(obstacles, p1);
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
						//both normal checkpoint color
						c.setColor(new Color(159, 237, 215));
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
						//p1 normal checkpoint color
						c.setColor(new Color(254, 249, 199));
						if(p1.getCheckpoint() == c.getNum() - 1)
						{
							p1.setCheckpoint(c.getNum());
						}
					}
					else if(p2.intersects(c))
					{
						//p2 normal checkpoint color
						c.setColor(new Color(171, 237, 159));
						if(p2.getCheckpoint() == c.getNum() - 1)
						{
							p2.setCheckpoint(c.getNum());
						}
					}
					else
					{
						//default normal checkpoint color
						c.setColor(new Color(199, 196, 191));
					}
				}
				else
				{
					if(p1.intersects(c) && p2.intersects(c))
					{
						//both start/finish checkpoint color
						c.setColor(new Color(237, 159, 159));
						if(p1.getCheckpoint() == 3)
						{
							if(win == 0)
							{
								p1.setCheckpoint(c.getNum());
								p1Score++;
							}
						}
						if(p2.getCheckpoint() == 3)
						{
							if(win == 0)
							{
								p2.setCheckpoint(c.getNum());
								p2Score++;
							}
						}
					}
					else if(p1.intersects(c))
					{
						//p1 start/finish checkpoint color
						c.setColor(new Color(254, 249, 199));
						if(p1.getCheckpoint() == 3)
						{
							if(win == 0)
							{
								p1.setCheckpoint(c.getNum());
								p1Score++;
							}
						}
					}
					else if(p2.intersects(c))
					{
						//p2 start/finish checkpoint color
						c.setColor(new Color(171, 237, 159));
						if(p2.getCheckpoint() == 3)
						{
							if(win == 0)
							{
								p2.setCheckpoint(c.getNum());
								p2Score++;
							}
						}
					}
					else
					{
						//default start/finish checkpoint color
						c.setColor(new Color(110, 91, 91));
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
				
				if(surface.imageChanger())
				{
					Projectile p = new Projectile(surface.loadImage("red.png"),
						(int)((p1.getCenterX()) + 40*Math.cos(Math.toRadians(p1.getDirection()))),
						(int)(p1.getCenterY() + 40*Math.sin(Math.toRadians(p1.getDirection()))),
						(int)(40*Math.cos(Math.toRadians(p1.getDirection()))),(int)(40*Math.sin(Math.toRadians(p1.getDirection()))));	
					projectiles.add(p);
				}
				else {
					//System.out.println("p1 shot");
					Projectile p = new Projectile(surface.loadImage("projectile.png"),
							(int)((p1.getCenterX()) + 40*Math.cos(Math.toRadians(p1.getDirection()))),
							(int)(p1.getCenterY() + 40*Math.sin(Math.toRadians(p1.getDirection()))),
							(int)(40*Math.cos(Math.toRadians(p1.getDirection()))),(int)(40*Math.sin(Math.toRadians(p1.getDirection()))));
					projectiles.add(p);
				}
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
				if(surface.imageChanger())
				{
					Projectile p = new Projectile(surface.loadImage("cyan.png"),
							(int)((p2.getCenterX()) + 40*Math.cos(Math.toRadians(p2.getDirection()))),
							(int)(p2.getCenterY() + 40*Math.sin(Math.toRadians(p2.getDirection()))),
							(int)(40*Math.cos(Math.toRadians(p2.getDirection()))),(int)(40*Math.sin(Math.toRadians(p2.getDirection()))));
					projectiles.add(p);
				}
				else {
					//System.out.println("p2 shot");
					Projectile p = new Projectile(surface.loadImage("projectile.png"),
							(int)((p2.getCenterX()) + 40*Math.cos(Math.toRadians(p2.getDirection()))),
							(int)(p2.getCenterY() + 40*Math.sin(Math.toRadians(p2.getDirection()))),
							(int)(40*Math.cos(Math.toRadians(p2.getDirection()))),(int)(40*Math.sin(Math.toRadians(p2.getDirection()))));
					projectiles.add(p);
				}
			}	
			if(p1Score >= 5)
			{
				surface.playSound(2);
				win = 1;
//				p1.setCheckpoint(0);
//				p2.setCheckpoint(0);
//				p1Score = 0;
//				p2Score = 0;
			}
			else if(p2Score >= 5)
			{
				surface.playSound(2);
				win = 2;
//				p1.setCheckpoint(0);
//				p2.setCheckpoint(0);
//				p1Score = 0;
//				p2Score = 0;
			}
		}
		else
		{
			if(win == 1)
			{
				surface.push();
				
				Point p = new Point(surface.mouseX,surface.mouseY);
				if (returnButton.contains(p) && returnButtonNum < 48)
					returnButtonNum += 3;
				else if(!returnButton.contains(p) && returnButtonNum > 0)
				{
					returnButtonNum -= 3;
				}
				
				surface.noStroke();
				surface.fill(255 - returnButtonNum);
//				surface.rect(surface.width/2 - 2, surface.height*2/8 - 15, 50, 20, 5, 5, 5, 5);
				surface.rect(450, 110, 70, 20, 5, 5, 5, 5);
				surface.fill(99 + returnButtonNum, 98 + returnButtonNum, 95 + returnButtonNum);
//				surface.text("P1 WINS", surface.width/2, surface.height*2/8);
				surface.text("P1 WINS", 455, 125);
				
				surface.fill(255 - returnButtonNum);
				surface.rect(returnButton.x, returnButton.y, returnButton.width, returnButton.height, 10, 10, 10, 10);
				surface.fill(99 + returnButtonNum, 98 + returnButtonNum, 95 + returnButtonNum);
				String buttonText = "Back";
				float w = surface.textWidth(buttonText);
				float h = surface.textWidth(buttonText)/buttonText.length();
				surface.text(buttonText, returnButton.x+returnButton.width/2-w/2, returnButton.y+returnButton.height/2+h/2);
				
				surface.pop();
			}
			else if(win == 2)
			{				
				surface.push();
				
				Point p = new Point(surface.mouseX,surface.mouseY);
				if (returnButton.contains(p) && returnButtonNum < 48)
					returnButtonNum += 3;
				else if(!returnButton.contains(p) && returnButtonNum > 0)
				{
					returnButtonNum -= 3;
				}
				
				surface.noStroke();
				surface.fill(255 - returnButtonNum);
				surface.rect(445, 110, 80, 20, 5, 5, 5, 5);
				surface.fill(99 + returnButtonNum, 98 + returnButtonNum, 95 + returnButtonNum);
				surface.text("P2 WINS", 450, 125);
				
				surface.fill(255 - returnButtonNum);
				surface.rect(returnButton.x, returnButton.y, returnButton.width, returnButton.height, 10, 10, 10, 10);
				surface.fill(99 + returnButtonNum, 98 + returnButtonNum, 95 + returnButtonNum);
				String buttonText = "Back";
				float w = surface.textWidth(buttonText);
				float h = surface.textWidth(buttonText)/buttonText.length();
				surface.text(buttonText, returnButton.x+returnButton.width/2-w/2, returnButton.y+returnButton.height/2+h/2);
				
				surface.pop();
			}
		}
	}
	
	/**
	 * Checks when the mouse is pressed in the specific area
	 * In this case, it would be when the mouse is pressed inside the back button
	 * (after a player has won the game) to change the screen back to the menu.
	 * A sound is played when this button is clicked.
	 */
	public void mousePressed() {
		Point p = new Point(surface.mouseX,surface.mouseY);
		if (returnButton.contains(p))
			if(win != 0)
			{
				surface.stopSound(2);
				surface.playSound(1);
				surface.switchScreen(ScreenSwitcher.MENUSCREEN);
			}
	}

}
