package gui;

import java.awt.Point;
import java.awt.Rectangle;

public class IntroScreen extends Screen {
	
	private DrawingSurface surface;
	
	private Rectangle startButton;
	
	public IntroScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
		
		startButton = new Rectangle(960/2-100,540/2-50,200,100);
	}
	
	public void draw()
	{
		surface.background(0,65,175);
		surface.fill(255);

		surface.rect(startButton.x, startButton.y, startButton.width, startButton.height, 10, 10, 10, 10);
		surface.fill(0);
		String buttonText = "< Press Start >";
		float w = surface.textWidth(buttonText);
		float h = surface.textWidth(buttonText)/buttonText.length();
		surface.text(buttonText, startButton.x+startButton.width/2-w/2, startButton.y+startButton.height/2+h/2);

		surface.fill(255);
		String title = "2D2PRace";
		String subtitle = "By: Alex and Connor";
		surface.text(title, surface.width/2-w/2, surface.height/8);
		surface.text(subtitle, surface.width/2-w/2, surface.height*2/8);
	}
	
	public void mousePressed() {
		Point p = new Point(surface.mouseX,surface.mouseY);
		if (startButton.contains(p))
			surface.switchScreen(ScreenSwitcher.MENUSCREEN);
	}
}
