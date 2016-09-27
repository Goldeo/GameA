package com.mygdx.game.actors.text;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameA;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 10.05.2016.
 */
public class ScoreText extends Label {
    private float scorePoints;

    public ScoreText(CharSequence text, Skin skin, String styleName) {
        super(text, skin, styleName);
        scorePoints = 0;
    }

    public void addScorePoints(float addingScorePoints) {
        if (scorePoints + addingScorePoints < 0)
            scorePoints = 0;
        else {
            this.scorePoints += addingScorePoints;
            setText(String.valueOf(Math.round(scorePoints)));
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        setZIndex(300);
        super.act(delta);
    }
}
