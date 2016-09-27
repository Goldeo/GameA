package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GameA;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "FIG";
		config.width = GameA.WIDTH;
		config.height = GameA.HEIGHT;
		config.backgroundFPS = 30;
		config.foregroundFPS = 30;
		new LwjglApplication(new GameA(), config);
	}
}
