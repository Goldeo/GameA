package com.mygdx.game.actors.heroes;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameA;
import com.mygdx.game.enums.Color;
import com.mygdx.game.enums.Form;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 18.07.2016.
 */
public abstract class Hero extends Actor {
    protected PlayScreen screen;
    protected TextureRegion textureRegion;
    protected Vector2 velocity;
    protected Form form;
    protected Color color;
    protected Rectangle bounds;

    public Hero(PlayScreen screen, float width, float height) {
        this.screen = screen;
        setSize(width, height);
        form = Form.getRandom();
        color = Color.getRandom();
        setFigure();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setFigure() {
        switch (form) {
            case Squad:
                if (color == Color.Blue)
                    textureRegion = GameA.atlas.findRegion("BlueSquare");
                if (color == Color.Yellow)
                    textureRegion = GameA.atlas.findRegion("YellowSquare");
                if (color == Color.Orange)
                    textureRegion = GameA.atlas.findRegion("OrangeSquare");
                if (color == Color.Green)
                    textureRegion = GameA.atlas.findRegion("GreenSquare");
                break;

            case Triangle:
                if (color == Color.Blue)
                    textureRegion = GameA.atlas.findRegion("BlueTriangle");
                if (color == Color.Yellow)
                    textureRegion = GameA.atlas.findRegion("YellowTriangle");
                if (color == Color.Orange)
                    textureRegion = GameA.atlas.findRegion("OrangeTriangle");
                if (color == Color.Green)
                    textureRegion = GameA.atlas.findRegion("GreenTriangle");
                break;
            default:
                break;
        }
    }

    protected abstract void actHero(float delta);
}
