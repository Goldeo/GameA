package com.mygdx.game.actors.buttons;

import com.mygdx.game.actors.heroes.Figure;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 07.05.2016.
 */
public class UpButton extends ArrowButton {

    public UpButton(PlayScreen screen) {
        super(screen);
    }

    @Override
    protected void removeFigure() {
        if (figure.isUpOpportunity()){
            figure.jump(Figure.Direction.UP);
            figure.setIsDownOpportunity(false);
        }
    }

}
