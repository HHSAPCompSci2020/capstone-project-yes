package gui;

public interface ScreenSwitcher {
	public static final int INTROSCREEN = 0;
	public static final int MENUSCREEN = 1;
	public static final int GAMESCREEN = 2;

	public void switchScreen(int i);
}
