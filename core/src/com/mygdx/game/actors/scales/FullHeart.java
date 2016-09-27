package com.mygdx.game.actors.scales;

import com.mygdx.game.GameA;

/**
 * Created by Sergey on 27.07.2016.
 */
public class FullHeart extends Heart {

    public FullHeart() {
        super();
        region = GameA.atlas.findRegion("heart");
    }
}
