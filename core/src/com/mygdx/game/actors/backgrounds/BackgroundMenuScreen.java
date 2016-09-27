package com.mygdx.game.actors.backgrounds;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.GameA;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.MenuScreen;

/**
 * Created by Sergey on 16.04.2016.
 */
public class BackgroundMenuScreen extends Background {

    public BackgroundMenuScreen() {
        backGround = GameA.atlas.findRegion("bg");
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
