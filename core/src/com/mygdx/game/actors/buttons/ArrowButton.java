package com.mygdx.game.actors.buttons;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GameA;
import com.mygdx.game.actors.heroes.Figure;
import com.mygdx.game.screens.PlayScreen;

import sun.applet.AppletListener;

/**
 * Created by Sergey on 18.05.2016.
 */
public abstract class ArrowButton extends Button {
    protected PlayScreen screen;
    protected Figure figure;
    protected ButtonStyle style;

    public ArrowButton(PlayScreen screen) {
        this.screen = screen;
        style = new ButtonStyle();
        style.up = GameA.skin.getDrawable("Arrow-icon");
        style.down = GameA.skin.getDrawable("Arrow-icon-blind");
        setStyle(style);
        setSize(GameA.WIDTH / 5, GameA.HEIGHT / 5);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                removeFigure();
            }
        });
    }

    protected void setFigure(Figure figure) {
        this.figure = figure;
    }

    protected abstract void removeFigure();

    @Override
    public void act(float delta) {
        setZIndex(20);
        super.act(delta);
    }

}
