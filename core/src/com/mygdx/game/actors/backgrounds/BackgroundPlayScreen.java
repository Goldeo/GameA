package com.mygdx.game.actors.backgrounds;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameA;
import com.mygdx.game.actors.text.ScoreText;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 16.04.2016.
 */
public class BackgroundPlayScreen extends Background {
    private Camera camera;
    private Vector2 bgPos1;
    private Vector2 bgPos2;
    private Vector2 velocity;
    private TextureRegion line;
    private ScoreText text;

    public Vector2 getBgPos2() {
        return bgPos2;
    }

    public BackgroundPlayScreen(PlayScreen screen, ScoreText text) {
        camera = screen.getStage().getCamera();
        this.text = text;

        backGround = GameA.atlas.findRegion("bg");
        line = GameA.atlas.findRegion("line");

        velocity = new Vector2(80, 0);
        bgPos1 = new Vector2(getX(), getY());
        bgPos2 = new Vector2(bgPos1.x + getWidth(), getY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(backGround, bgPos1.x, bgPos1.y, getWidth(), getHeight());
        batch.draw(backGround, bgPos2.x, bgPos2.y, getWidth(), getHeight());
        batch.draw(line, 0 , camera.viewportHeight / 2 - 1, camera.viewportWidth, 2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        reposition(getX() - velocity.x * delta, getY() + velocity.y * delta);
        text.addScorePoints(velocity.x * delta / 50);

        if (getBgPos2().x <= camera.position.x - camera.viewportWidth / 2)
            reposition(camera.position.x - camera.viewportWidth / 2, 0);
    }

    private void reposition(float x, float y) {
        setPosition(x, y);
        bgPos1.set(x, y);
        bgPos2.set(bgPos1.x + getWidth(), y);
    }


}
