package com.mygdx.game.actors.heroes;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.GameA;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 28.07.2016.
 */
public class EnemySpawner extends Group {
    private PlayScreen screen;
    private long lastDropTime;

    public EnemySpawner(PlayScreen screen) {
        this.screen = screen;
    }

    private void generateEnemy() {
        addActor(new Enemy(screen, GameA.WIDTH * 0.05f, GameA.WIDTH * 0.05f));
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (TimeUtils.nanoTime() - lastDropTime > 700000000) generateEnemy();
    }
}
