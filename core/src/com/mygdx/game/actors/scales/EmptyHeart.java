package com.mygdx.game.actors.scales;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.GameA;

/**
 * Created by Sergey on 27.07.2016.
 */
public class EmptyHeart extends Heart {

    public EmptyHeart() {
        super();
        region = GameA.atlas.findRegion("emptyHeart");
    }
}
