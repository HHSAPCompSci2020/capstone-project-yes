package gui;

import java.awt.event.KeyEvent;

/**
 * Used by DrawingSurface to draw the specified screen, which is to show the 
 * player the game interface
 * 
 * @author Connor Chow
 * @version 5/7/21
 */
public class GameScreen extends Screen {

	private DrawingSurface surface;
	
	public GameScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		
		
	}
	
	/**
	 * 
	 */
	public void draw()
	{
//		if (surface.isPressed(KeyEvent.VK_LEFT))
//			mario.walk(-1);
//		if (surface.isPressed(KeyEvent.VK_RIGHT))
//			mario.walk(1);
//		if (surface.isPressed(KeyEvent.VK_UP))
//			mario.jump();
		
	}
	
}
