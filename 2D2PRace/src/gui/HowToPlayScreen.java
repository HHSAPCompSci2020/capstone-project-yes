package gui;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * Used by DrawingSurface to draw the specified screen, which is to show the player a visual of how the game functions
 * 
 * @author Connor Chow
 * @version 5/21/21
 */
public class HowToPlayScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle backButton;
	/**
	 * Creates a new HowToPlayScreen that takes in the DrawingSurface
	 * @param surface DrawingSurface that will display the graphics
	 */
	public HowToPlayScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		
		backButton = new Rectangle(this.surface.width/2-100,this.surface.height/2-50,200,100);

	}
	
	/**
	 * Draws the assets for the HowToPlayScreen on the previously inputed DrawingSurface
	 */
	public void draw()
	{
		surface.pushMatrix();
		
		backButton = new Rectangle(surface.width/2-backButton.width/2,surface.height*5/8-backButton.height/2,200,100);
		
		surface.background(255);
		surface.fill(0);
		String menuTitle = "How to play!\n" +
				"\n" +
				"Mouse - Navigation \r\n" + 
				"MB1/LMB - Select\r\n" + 
				"WASD - Player 1\r\n" + 
				"\'1\' - Player 1 shoot projectile button\r\n" + 
				"\'Q\' - Player 1 boost\r\n" + 
				"Arrow Keys - Player 2\r\n" + 
				"\'.\' - Player 2 shoot projectile button\r\n" + 
				"\'/\' - Player 2 boost\r\n" + 
				"ESC - Pause / Quit\r\n";
		float w = surface.textWidth(menuTitle);
		surface.text(menuTitle, surface.width/2-w/2, surface.height/8);
		
		
		surface.fill(255);
		surface.rect(backButton.x, backButton.y, backButton.width, backButton.height, 10, 10, 10, 10);
		surface.fill(0);
		String gameText = "back";
		w = surface.textWidth(gameText);
		float h = surface.textWidth(gameText)/gameText.length();
		surface.text(gameText, backButton.x+backButton.width/2-w/2, backButton.y+backButton.height/2+h/2);
		surface.popMatrix();
	}
	
	/**
	 * Checks when the mouse is pressed in the specified area
	 * In this case, it would be when the mouse is pressed inside the back button
	 * to change the screen to the MenuScreen
	 */
	public void mousePressed() {
		Point p = new Point(surface.mouseX,surface.mouseY);
		if (backButton.contains(p))
			surface.switchScreen(ScreenSwitcher.MENUSCREEN);
	}
}
