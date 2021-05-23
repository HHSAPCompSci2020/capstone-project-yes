package gui;

import java.awt.Point;
import java.awt.Rectangle;
/**
 * Used by DrawingSurface to draw the specified screen, which is to show the 
 * player the menu that can access the game as well as different options
 * 
 * @author Connor Chow
 * @version 5/23/21
 */
public class MenuScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle gameButton, howToPlayButton;
	private int gameButtonNum, howToPlayButtonNum;
	
	/**
	 * Creates a new MenuScreen that takes in the DrawingSurface
	 * @param surface DrawingSurface that will display the graphics
	 */
	public MenuScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		
		gameButton = new Rectangle(this.surface.width*3/4-100,this.surface.height/2-50,200,100);
		howToPlayButton = new Rectangle(this.surface.width*1/4-100,this.surface.height/2-50,200,100);
	}
	
	/**
	 * Draws the assets for the MenuScreen on the previously inputed DrawingSurface
	 */
	public void draw()
	{
		surface.pushMatrix();
		surface.background(237 - gameButtonNum/2, 234 - howToPlayButtonNum/2, 229 - gameButtonNum/2);
		
		gameButton = new Rectangle(surface.width*3/4-gameButton.width/2,surface.height/2-gameButton.height/2,200,100);
		howToPlayButton = new Rectangle(this.surface.width*1/4-howToPlayButton.width/2,this.surface.height/2-howToPlayButton.height/2,200,100);
		
		surface.fill(99 + gameButtonNum, 98 + howToPlayButtonNum, 95 + gameButtonNum);
		surface.textSize(24);
		String menuTitle = "MENU";
		float w = surface.textWidth(menuTitle);
		surface.text(menuTitle, surface.width/2-w/2, surface.height/8);
		
		Point p = new Point(surface.mouseX,surface.mouseY);
		if (gameButton.contains(p) && gameButtonNum < 48)
			gameButtonNum += 3;
		else if(!gameButton.contains(p) && gameButtonNum > 0)
		{
			gameButtonNum -= 3;
		}
		if (howToPlayButton.contains(p) && howToPlayButtonNum < 48)
			howToPlayButtonNum += 3;
		else if(!howToPlayButton.contains(p) && howToPlayButtonNum > 0)
		{
			howToPlayButtonNum -= 3;
		}
		
		
		surface.fill(255 - gameButtonNum);
		surface.rect(gameButton.x, gameButton.y, gameButton.width, gameButton.height, 10, 10, 10, 10);
		surface.fill(99 + gameButtonNum, 98 + gameButtonNum, 95 + gameButtonNum);
		surface.textSize(18);
		String gameButtonText = "Start";
		w = surface.textWidth(gameButtonText);
		float h = surface.textWidth(gameButtonText)/gameButtonText.length();
		surface.text(gameButtonText, gameButton.x+gameButton.width/2-w/2, gameButton.y+gameButton.height/2+h/2);
		
		surface.fill(255 - howToPlayButtonNum);
		surface.rect(howToPlayButton.x, howToPlayButton.y, howToPlayButton.width, howToPlayButton.height, 10, 10, 10, 10);
		surface.fill(99 + howToPlayButtonNum, 98 + howToPlayButtonNum, 95 + howToPlayButtonNum);
		String howToPlayText = "How to Play";
		w = surface.textWidth(howToPlayText);
		h = surface.textWidth(howToPlayText)/howToPlayText.length();
		surface.text(howToPlayText, howToPlayButton.x+howToPlayButton.width/2-w/2, howToPlayButton.y+howToPlayButton.height/2+h/2);
		surface.popMatrix();
	}
	
	/**
	 * Checks when the mouse is pressed in the specified area
	 * In this case, it would be when the mouse is pressed inside the start button or how-to-play button
	 * to change the screen to the GameScreen or the HowToPlayScreen
	 */
	public void mousePressed() {
		Point p = new Point(surface.mouseX,surface.mouseY);
		if (gameButton.contains(p))
		{
			surface.playSound(1);
			surface.refreshGameScreen();
			surface.switchScreen(ScreenSwitcher.GAMESCREEN);
		}
		else if (howToPlayButton.contains(p))
		{
			surface.playSound(1);
			surface.switchScreen(ScreenSwitcher.HOWTOPLAYSCREEN);
		}
	}
	
}
