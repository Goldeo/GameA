package com.mygdx.game.actors.heroes;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameA;
import com.mygdx.game.screens.PlayScreen;

import java.util.Random;

/**
 * Created by Sergey on 19.05.2016.
 */
public class Enemy extends Hero {

    private static Random random2 = new Random(System.nanoTime());
    private static Random random = new Random(random2.nextInt());
    private static final int SPEED = 170;
    private static final int DELTA_SPEED = 100;


    public Enemy(PlayScreen screen, float width, float height) {
        super(screen, width, height);

        velocity = new Vector2(SPEED + Enemy.random.nextInt(DELTA_SPEED), 0);
        setPosition(GameA.WIDTH + 50, random.nextInt(GameA.HEIGHT - (int) getHeight()));

        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    protected void actHero(float delta) {
        setPosition(getX() - velocity.x * delta, getY() - velocity.y);
        bounds.setPosition(getX(), getY());
        if (getX() + getWidth() < 0)
            remove();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        setZIndex(10);
        actHero(delta);
    }
}
