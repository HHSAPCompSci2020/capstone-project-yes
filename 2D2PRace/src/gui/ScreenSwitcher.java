package gui;

/**
 * Interface holding the int values of all the screens
 * as well as a method to switch between the different screens
 * 
 * @author Connor Chow
 * @version 5/7/21
 */
public interface ScreenSwitcher {
	public static final int INTROSCREEN = 0;
	public static final int MENUSCREEN = 1;
	public static final int GAMESCREEN = 2;

	/**
	 * Switches the screen to a different screen from its current one
	 * @param i specified screen int value to switch to
	 */
	public void switchScreen(int i);
}
