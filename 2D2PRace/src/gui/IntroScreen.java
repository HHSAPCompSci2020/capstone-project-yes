package gui;

import java.awt.Point;
import java.awt.Rectangle;
/**
 * Used by DrawingSurface to draw the specified screen, which is for creating the intro screen 
 * that is the default screen to display when the game is opened
 * 
 * @author Connor Chow
 * @version 5/7/21
 */
public class IntroScreen extends Screen {
	
	private DrawingSurface surface;
	
	private Rectangle startButton;
	/**
	 * Creates a new IntroScreen that takes in the DrawingSurface
	 * @param surface DrawingSurface that will display the graphics
	 */
	public IntroScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		
		startButton = new Rectangle(960/2-100,540/2-50,200,100);
	}
	
	/**
	 * Draws the assets for the IntroScreen on the previously inputed DrawingSurface
	 */
	public void draw()
	{
		surface.pushMatrix();
		surface.background(0,65,175);
		surface.fill(255);

		surface.rect(startButton.x, startButton.y, startButton.width, startButton.height, 10, 10, 10, 10);
		surface.fill(0);
		String buttonText = "< Open >";
		float w = surface.textWidth(buttonText);
		float h = surface.textWidth(buttonText)/buttonText.length();
		surface.text(buttonText, startButton.x+startButton.width/2-w/2, startButton.y+startButton.height/2+h/2);

		surface.fill(255);
		String title = "2D2PRace";
		String subtitle = "By: Alex and Connor";
		surface.text(title, surface.width/2-w/2, surface.height/8);
		surface.text(subtitle, surface.width/2-w/2, surface.height*2/8);
		surface.popMatrix();
	}
	
	/**
	 * Checks when the mouse is pressed in the specified area
	 * In this case, it would be when the mouse is pressed inside the start button
	 * to change the screen to the MenuScreen
	 */
	public void mousePressed() {
		Point p = new Point(surface.mouseX,surface.mouseY);
		if (startButton.contains(p))
			surface.switchScreen(ScreenSwitcher.MENUSCREEN);
	}
}
