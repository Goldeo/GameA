package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GameA;
import com.mygdx.game.actors.buttons.ButtonsGroup;
import com.mygdx.game.actors.heroes.EnemySpawner;
import com.mygdx.game.actors.text.ScoreText;
import com.mygdx.game.actors.backgrounds.BackgroundPlayScreen;
import com.mygdx.game.actors.heroes.Figure;

public class PlayScreen extends GameScreen {

    private BackgroundPlayScreen backgroundPlayScreen;
    private Figure figure;
    private ScoreText scoreText;
    private EnemySpawner enemySpawner;
    private ButtonsGroup buttons;

    public PlayScreen(GameA game) {
        super(game);
    }

    public ScoreText getScoreText() {
        return scoreText;
    }

    public EnemySpawner getEnemySpawner() {
        return enemySpawner;
    }

    @Override
    protected void initialization() {
        stage = new Stage(new StretchViewport(GameA.WIDTH, GameA.HEIGHT));
        scoreText = new ScoreText("0", GameA.skin, "black-font");
        backgroundPlayScreen = new BackgroundPlayScreen(this, scoreText);
        figure = new Figure(this, 80, 80);
        enemySpawner = new EnemySpawner(this);
        buttons = new ButtonsGroup(this);
    }

    @Override
    protected void setSettings() {
        stage.addActor(backgroundPlayScreen);
        backgroundPlayScreen.setPosition(0, 0);
        backgroundPlayScreen.setSize(GameA.WIDTH, GameA.HEIGHT);

        stage.addActor(scoreText);
        scoreText.setPosition(10, GameA.HEIGHT - scoreText.getHeight());
        figure.setPosition(GameA.WIDTH / 4 - figure.getWidth() / 2,
                GameA.HEIGHT / 2 - figure.getHeight() / 2);

        stage.addActor(figure);
        stage.addActor(enemySpawner);
        stage.addActor(buttons);
        buttons.setFigure(figure);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {

    }

}
