package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.GameA;
import com.mygdx.game.actors.backgrounds.BackgroundMenuScreen;
import com.mygdx.game.actors.backgrounds.MainMenu;

public class MenuScreen extends GameScreen {

    private BackgroundMenuScreen backgroundMenuScreen;
    private MainMenu mainMenu;

    public MenuScreen(GameA game) {
        super(game);
    }

    @Override
    protected void initialization() {
        stage = new Stage(new StretchViewport(GameA.WIDTH, GameA.HEIGHT));
        backgroundMenuScreen = new BackgroundMenuScreen();
        mainMenu = new MainMenu(GameA.skin, this);
    }

    @Override
    protected void setSettings() {
        stage.addActor(backgroundMenuScreen);
        stage.addActor(mainMenu);
        mainMenu.addListeners(game);
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
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {

    }


}
