package com.mygdx.game.actors.backgrounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.GameA;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 04.08.2016.
 */
public class MainMenu extends Table {
    private GameScreen screen;
    private TextButton playButton;
    private TextButton quitButton;

    private static final int BUTTON_WIDTH = 300;
    private static final int BUTTON_HEIGHT = 60;
    private static final int PADDING = 10;

    public MainMenu(Skin skin, GameScreen screen) {
        super(skin);
        this.screen = screen;
        playButton = new TextButton("Play", GameA.skin);
        quitButton = new TextButton("Quit", GameA.skin);
        setSettings();
    }

    private void setSettings() {
        setSize(screen.getStage().getWidth(), screen.getStage().getHeight());
        align(Align.center);
        add(playButton)
            .size(BUTTON_WIDTH, BUTTON_HEIGHT)
            .padBottom(PADDING)
            .row();
        add(quitButton)
            .size(BUTTON_WIDTH, BUTTON_HEIGHT)
            .padBottom(PADDING)
            .row();
        screen.getStage().addActor(this);
    }

    public void addListeners(final GameA game) {
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PlayScreen(game));
            }
        });

        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }
}
