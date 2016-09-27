package com.mygdx.game.enums;

/**
 * Created by Sergey on 19.05.2016.
 */
public enum Form {
    Squad, Triangle;

    public static Form getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
