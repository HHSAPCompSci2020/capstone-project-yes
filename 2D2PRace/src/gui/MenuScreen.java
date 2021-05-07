package gui;

import java.awt.Rectangle;

public class MenuScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle selection;
	
	public MenuScreen(DrawingSurface surface)
	{
		super();
		this.surface = surface;
	}
	
	public void draw()
	{
		surface.background(255);
		String str = "Menu!!!!!";
		float w = surface.textWidth(str);
		surface.text(str, surface.width/2-w/2, surface.height/2);
	}
	
}
