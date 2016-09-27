package com.mygdx.game.actors.buttons;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.actors.heroes.Figure;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 28.07.2016.
 */
public class ButtonsGroup extends Group {
    private Group downButtonGroup;
    private ArrowButton downButton, upButton;
    private static final int PADDING = 10;

    public ButtonsGroup(PlayScreen screen) {
        upButton = new UpButton(screen);

        downButton = new DownButton(screen);
        downButtonGroup = new Group();

        screen.getStage().addActor(upButton);
        downButtonGroup.addActor(downButton);
        screen.getStage().addActor(downButtonGroup);
        setPos();
    }

    public void setFigure(Figure figure) {
        downButton.setFigure(figure);
        upButton.setFigure(figure);
    }

    private void setPos() {
        upButton.setPosition(PADDING, PADDING);
        downButtonGroup.setOrigin(downButton.getWidth() / 2, downButton.getHeight() / 2);
        downButtonGroup.setPosition(800 - downButton.getWidth() - PADDING, PADDING);
        downButtonGroup.setRotation(180);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        downButtonGroup.setZIndex(20);
        super.act(delta);
    }
}
