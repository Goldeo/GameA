package com.mygdx.game.enums;

/**
 * Created by Sergey on 19.05.2016.
 */
public enum Color {
    Yellow, Orange, Blue, Green;

    public static Color getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
