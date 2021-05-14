package gui;

import java.awt.Point;
import java.awt.Rectangle;
/**
 * Used by DrawingSurface to draw the specified screen, which is to show the 
 * player the menu that can access the game as well as different options
 * 
 * @author Connor Chow
 * @version 5/7/21
 */
public class MenuScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle gameButton, howToPlayButton;
	/**
	 * Creates a new MenuScreen that takes in the DrawingSurface
	 * @param surface DrawingSurface that will display the graphics
	 */
	public MenuScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		
		gameButton = new Rectangle(960*3/4-100,540/2-50,200,100);
		howToPlayButton = new Rectangle(960*1/4-100,540/2-50,200,100);
	}
	
	/**
	 * Draws the assets for the MenuScreen on the previously inputed DrawingSurface
	 */
	public void draw()
	{
		surface.pushMatrix();
		surface.background(255);
		surface.fill(0);
		String menuTitle = "Menu!";
		float w = surface.textWidth(menuTitle);
		surface.text(menuTitle, surface.width/2-w/2, surface.height/8);
		
		
		surface.fill(255);
		surface.rect(gameButton.x, gameButton.y, gameButton.width, gameButton.height, 10, 10, 10, 10);
		surface.fill(0);
		String gameButtonText = "Start";
		w = surface.textWidth(gameButtonText);
		float h = surface.textWidth(gameButtonText)/gameButtonText.length();
		surface.text(gameButtonText, gameButton.x+gameButton.width/2-w/2, gameButton.y+gameButton.height/2+h/2);
		
		surface.fill(255);
		surface.rect(howToPlayButton.x, howToPlayButton.y, howToPlayButton.width, howToPlayButton.height, 10, 10, 10, 10);
		surface.fill(0);
		String howToPlayText = "How To Play";
		w = surface.textWidth(howToPlayText);
		h = surface.textWidth(howToPlayText)/howToPlayText.length();
		surface.text(howToPlayText, howToPlayButton.x+howToPlayButton.width/2-w/2, howToPlayButton.y+howToPlayButton.height/2+h/2);
		surface.popMatrix();
	}
	
	/**
	 * Checks when the mouse is pressed in the specified area
	 * In this case, it would be when the mouse is pressed inside the start button
	 * to change the screen to the GameScreen
	 */
	public void mousePressed() {
		Point p = new Point(surface.mouseX,surface.mouseY);
		if (gameButton.contains(p))
			surface.switchScreen(ScreenSwitcher.GAMESCREEN);
		else if (howToPlayButton.contains(p))
			surface.switchScreen(ScreenSwitcher.HOWTOPLAYSCREEN);
	}
	
}
