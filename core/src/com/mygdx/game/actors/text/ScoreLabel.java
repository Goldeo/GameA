package com.mygdx.game.actors.text;

import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RemoveActorAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.actors.heroes.Figure;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 12.07.2016.
 */
public class ScoreLabel extends Label {

    private PlayScreen screen;
    private ScoreText scoreText;
    private MoveByAction mba;
    private AlphaAction aa;
    private RemoveActorAction ra;
    private ParallelAction pa;
    private SequenceAction sa;

    public ScoreLabel(CharSequence text, Skin skin, String styleName, PlayScreen screen, Figure firure) {
        super(text, skin, styleName);
        this.screen = screen;
        setPosition(firure.getX() - getWidth(), firure.getY() + firure.getHeight() / 2 - getHeight() / 2);
        scoreText = screen.getScoreText();

        mba = new MoveByAction();
        aa = new AlphaAction();
        ra = new RemoveActorAction();

        pa = new ParallelAction(mba, aa);
        sa = new SequenceAction(pa, ra);
    }

    @Override
    public void act(float delta) {
        setZIndex(10);
        super.act(delta);
    }

    public void addScores(int scorePoints) {
        setText(String.valueOf(scorePoints));
        screen.getStage().addActor(this);

        mba.setAmountX(-250);
        mba.setDuration(1);
        aa.setAlpha(0);
        aa.setDuration(2);
        ra.setTarget(this);
        addAction(sa);

        scoreText.addScorePoints(scorePoints);
    }
}
