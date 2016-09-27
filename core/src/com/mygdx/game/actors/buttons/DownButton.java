package com.mygdx.game.actors.buttons;

import com.mygdx.game.actors.heroes.Figure;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 07.05.2016.
 */
public class DownButton extends ArrowButton {

    public DownButton(PlayScreen screen) {
        super(screen);
        this.screen = screen;
    }

    @Override
    protected void removeFigure() {
        if (figure.isDownOpportunity()) {
            figure.jump(Figure.Direction.DOWN);
            figure.setIsUpOpportunity(false);
        }
    }

}
