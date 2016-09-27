package com.mygdx.game.actors.scales;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 23.07.2016.
 */
public class HP extends Group {
    private PlayScreen screen;
    private int hp;
    private static final int FULL_HP  = 3;
    private static final int SPACING = 5;
    private static final int MARGIN = 10;

    public HP(PlayScreen screen) {
        this.screen = screen;
        screen.getStage().addActor(this);
        setSize(100, 30);
        setPosition(screen.getStage().getCamera().viewportWidth - getWidth() - MARGIN,
                screen.getStage().getCamera().viewportHeight - getHeight() - MARGIN);

        addHearts();
    }

    private void addHearts() {
        for (int i = 0; i < FULL_HP; ++i) {
            Heart heart = new FullHeart();
            heart.setPosition((heart.getWidth() + SPACING) * i, heart.getY());
            addActor(heart);
        }
        hp = 3;
    }

    public void decrementHP() {
        if (hp > 0)
            --hp;
        setHP();
    }

    public void incrementHP() {
        if (hp < 3)
            ++hp;
        setHP();
    }

    private void setHP() {
        for (int i = 0; i < FULL_HP; ++i) {
            if (i < hp) {
                getChildren().items[i] = new FullHeart();
            } else
            if (i < FULL_HP) {
                getChildren().items[i] = new EmptyHeart();
            }
            getChildren().items[i].setPosition((getChildren().items[i].getWidth() + SPACING) * i, getChildren().items[i].getY());
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        setZIndex(200);
        super.act(delta);
    }
}
