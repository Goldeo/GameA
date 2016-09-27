package com.mygdx.game.actors.scales;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Sergey on 27.07.2016.
 */
public abstract class Heart extends Actor {
    protected TextureRegion region;

    public Heart() {
        setSize(30, 30);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, getX(), getY(), getWidth(), getHeight());
    }

}
