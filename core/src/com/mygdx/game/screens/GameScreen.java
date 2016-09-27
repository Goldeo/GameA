package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GameA;

/**
 * Created by Sergey on 17.07.2016.
 */
public abstract class GameScreen implements Screen {
    protected GameA game;
    protected Stage stage;

    public GameScreen(final GameA game) {
        this.game = game;
        stage = new Stage(new StretchViewport(GameA.WIDTH, GameA.HEIGHT));
        initialization();
        setSettings();
    }

    public Stage getStage() {
        return stage;
    }

    protected abstract void initialization();
    protected abstract void setSettings();

    @Override
    public void pause() {
        game.setGameState(GameA.State.PAUSED);
    }

    @Override
    public void resume() {
        game.setGameState(GameA.State.RUNNING);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render(float delta) {
        switch(GameA.state) {
            case RUNNING:
                stage.act(delta);
                break;
            case PAUSED:
                break;
        }
        stage.draw();
    }

}
