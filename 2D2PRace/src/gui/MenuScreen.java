package gui;

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
	
	private Rectangle selection;
	/**
	 * Creates a new MenuScreen that takes in the DrawingSurface
	 * @param surface DrawingSurface that will display the graphics
	 */
	public MenuScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		
		selection = new Rectangle(960/2-100,540/2-50,200,100);
	}
	
	/**
	 * Draws the assets for the MenuScreen on the previously inputed DrawingSurface
	 */
	public void draw()
	{
		String menuTitle = "Menu";
		float w = surface.textWidth(menuTitle);
		surface.text(menuTitle, surface.width/2-w/2, surface.height/8);
		
		surface.background(255);
		surface.fill(255);
		surface.rect(selection.x, selection.y, selection.width, selection.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Menu!!!!!";
		surface.text(str, surface.width/2-w/2, surface.height/2);
	}
	
}
