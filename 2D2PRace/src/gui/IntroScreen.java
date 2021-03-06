package gui;

import java.awt.Point;
import java.awt.Rectangle;

import processing.core.PFont;

/**
 * Used by DrawingSurface to draw the specified screen, which is for creating the intro screen 
 * that is the default screen to display when the game is opened
 * 
 * @author Connor Chow
 * @version 5/23/21
 */
public class IntroScreen extends Screen {
	
	private DrawingSurface surface;
	
	private Rectangle startButton,backgroundButton;
	private int openButtonNum;
	
	private PFont font1, font2;

	/**
	 * Creates a new IntroScreen that takes in the DrawingSurface
	 * @param surface DrawingSurface that will display the graphics
	 */
	public IntroScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		
		startButton = new Rectangle(this.surface.width/2-100,this.surface.height/2-50,200,100);
		backgroundButton = new Rectangle(0,0,10,10);
		
//		System.out.println(this.surface.width);
//		System.out.println(this.surface.displayWidth);
	}
	
	/**
	 * Setup used to print the fonts on the computer
	 */
	public void setup() {
		
	}
	
	/**
	 * Draws the assets for the IntroScreen on the previously inputed DrawingSurface
	 *  such reactive buttons, backgrounds, text, etc.
	 */
	public void draw()
	{
		surface.pushMatrix();
		surface.background(135 - openButtonNum/2, 206, 235 - openButtonNum/2);
		surface.fill(135 - openButtonNum/2, 206 + openButtonNum/3, 235 - openButtonNum/2);
		surface.noStroke();
		surface.rect(backgroundButton.x, backgroundButton.y, backgroundButton.width, backgroundButton.height);
		
		Point p = new Point(surface.mouseX,surface.mouseY);
		if (startButton.contains(p) && openButtonNum < 48)
			openButtonNum += 3;
		else if(!startButton.contains(p) && openButtonNum > 0)
		{
			openButtonNum -= 3;
		}
		font1 = surface.createFont("Anurati-Regular.otf", 26);
		surface.textFont(font1);
		surface.fill(255 - openButtonNum);
		startButton = new Rectangle(surface.width/2-startButton.width/2,surface.height/2-startButton.height/2,200,100);
		surface.rect(startButton.x, startButton.y, startButton.width, startButton.height, 10, 10, 10, 10);
		surface.fill(99 + openButtonNum*4, 98 + openButtonNum*4, 95 + openButtonNum);
		String buttonText = "PLAY";
		float w = surface.textWidth(buttonText);
		float h = surface.textWidth(buttonText)/buttonText.length();
		surface.text(buttonText, startButton.x+startButton.width/2-w/2, startButton.y+startButton.height/2+h/2);

		font2 = surface.createFont("Moon2.0-Regular.otf", 12);
		surface.textFont(font2);
		surface.fill(99 + openButtonNum*2, 98 + openButtonNum*2, 95 );
		surface.textLeading(15);
		surface.textSize(18);
		String title = "2D2PRace";
		String subtitle = "By: Alex and Connor";
		
		w = surface.textWidth(title);
		surface.text(title, surface.width/2-w/2, surface.height/8);
		w = surface.textWidth(subtitle);
		surface.text(subtitle, surface.width/2-w/2, surface.height*2/8);
		surface.popMatrix();
	}
	
	/**
	 * Checks when the mouse is pressed in the specified area
	 * In this case, it would be when the mouse is pressed inside the start button or the background button
	 * to change the screen to the MenuScreen, or show off the game's easter egg.
	 * Each button plays a sound when the buttons are clicked.
	 */
	public void mousePressed() {
		Point p = new Point(surface.mouseX,surface.mouseY);
		if(backgroundButton.contains(p))
		{
			surface.playSound(1);
			surface.playSound(0);
			surface.setImageChanger(true);
			System.out.println("~click~");
		}
		if (startButton.contains(p))
		{
			surface.playSound(1);
			surface.switchScreen(ScreenSwitcher.MENUSCREEN);
		}
	}
}
