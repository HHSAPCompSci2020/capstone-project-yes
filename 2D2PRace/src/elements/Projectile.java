package elements;

import processing.core.PImage;

/**
 * Used to create the projectile used by the car to sabotage the other car during the game
 * 
 * @author Alex Lan
 * @version 5/7/21
 */
public class Projectile extends MovingImage{
	
	public static final int PROJ_WIDTH = 5;
	public static final int PROJ_HEIGHT = 5;
	
	private double xv, yv;
	private int lifespan;
	
	public Projectile(PImage img, int x, int y, int xv, int yv) {
		super(img, x, y, PROJ_WIDTH, PROJ_HEIGHT);
		
		this.xv = xv;
		this.yv = yv;
		lifespan = 60;
	}
	
	public void shoot() {
		
	}
	
	public void act() {
		if(lifespan < 1)
		{
//			removeSelf(this);
		}
		
		moveToLocation(getX()+xv,getY()+yv);
		lifespan--;
	}
	

}
