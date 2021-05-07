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
		String str = "< Press Start >";
		float w = surface.textWidth(str);
		float h = surface.textWidth(str)/str.length();
		surface.text(str, startButton.x+startButton.width/2-w/2, startButton.y+startButton.height/2+h/2);
	}
	
	public void mousePressed() {
		Point p = new Point(surface.mouseX,surface.mouseY);
		if (startButton.contains(p))
			surface.switchScreen(ScreenSwitcher.MENUSCREEN);
	}
}
