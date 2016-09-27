package com.mygdx.game.actors.backgrounds;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Sergey on 30.05.2016.
 */
public abstract class Background extends Actor {
    protected TextureRegion backGround;

    @Override
    public void act(float delta) {
        setZIndex(0);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(backGround, getX(), getY(), getWidth(), getHeight());
    }
}
