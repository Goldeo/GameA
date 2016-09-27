package com.mygdx.game.actors.heroes;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GameA;
import com.mygdx.game.actors.text.ScoreLabel;
import com.mygdx.game.actors.scales.HP;
import com.mygdx.game.enums.Color;
import com.mygdx.game.enums.Form;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Sergey on 29.02.2016.
 */
public class Figure extends Hero  {

    private static final int SCORE1 = 5;
    private static final int SCORE2 = 20;
    private static final int SCORE3 = -200;

    public enum Direction {
        UP, DOWN
    }

    private HP hp;
    private boolean isUpOpportunity;
    private boolean isDownOpportunity;
    private static final float GRAVITY = 15;
    private int jump = 280;

    public Figure(PlayScreen screen, float width, float height) {
        super(screen, width, height);
        this.screen = screen;
        //setSize(width, height);
        hp = new HP(screen);
        velocity = new Vector2(0, 0);
        isDownOpportunity = isUpOpportunity = true;
        bounds = new Rectangle(getX(), getY(), width, height);
    }

    public boolean isUpOpportunity() {
        return isUpOpportunity;
    }

    public void setIsUpOpportunity(boolean isUpOpportunity) {
        this.isUpOpportunity = isUpOpportunity;
    }

    public boolean isDownOpportunity() {
        return isDownOpportunity;
    }

    public void setIsDownOpportunity(boolean isDownOpportunity) {
        this.isDownOpportunity = isDownOpportunity;
    }

    private boolean isDownMiddlePart() {
        return (isDownOpportunity) && (getY() + getHeight() / 2 >= getStage().getCamera().viewportHeight / 2);
    }

    private boolean isUpMiddlePart() {
        return (isUpOpportunity) && (getY() + getHeight() / 2 <= getStage().getCamera().viewportHeight / 2);
    }

    private void setPos() {
        if (getY() + getHeight() >= screen.getStage().getCamera().viewportHeight) {
            setY(screen.getStage().getCamera().viewportHeight - getHeight());
            return;
        }

        if (getY() < 0) {
            setY(0);
            return;
        }

        if (isDownMiddlePart()) {
            setPosition(getX(), getStage().getCamera().viewportHeight / 2 - getHeight() / 2);
            isUpOpportunity = true;
            return;
        }

        if (isUpMiddlePart()) {
            setPosition(getX(), getStage().getCamera().viewportHeight / 2 - getHeight() / 2);
            isDownOpportunity = true;
        }
    }

    private void setFormAndColor(Enemy enemy) {
        ScoreLabel scoreLabel = new ScoreLabel("", GameA.skin, "default", screen, this);

        if (color != enemy.color && form == enemy.form) {
            color = enemy.color;
            scoreLabel.addScores(SCORE1);
            return;
        }

        if (form != enemy.form && color == enemy.color) {
            form = enemy.form;
            scoreLabel.addScores(SCORE1);
            return;
        }

        if (form == enemy.form && color == enemy.color) {
            form = enemy.form;
            scoreLabel.addScores(SCORE2);
            return;
        }

        if (form != enemy.form && color != enemy.color) {
            form = Form.getRandom();
            color = Color.getRandom();
            scoreLabel.addScores(SCORE3);
            hp.decrementHP();
        }

    }

    private void collides() {
        for (Actor enemy: screen.getEnemySpawner().getChildren()) {
            if (bounds.overlaps(((Enemy) enemy).getBounds())) {
                setFormAndColor((Enemy) enemy);
                setFigure();
                enemy.remove();
            }
        }
    }

    public void jump(Direction direction) {
        switch (direction) {
            case DOWN:
                velocity.y = -jump;
                break;
            case UP:
                velocity.y = jump;
                break;
            default:
                break;
        }
    }

    @Override
    protected void actHero(float delta) {
        setPosition(getX(), getY() + velocity.y * delta);

        if (getY() + getHeight() / 2 >= getStage().getCamera().viewportHeight / 2) {
            velocity.y -= GRAVITY;
        }

        if (getY() + getHeight() / 2 < getStage().getCamera().viewportHeight / 2) {
            velocity.y += GRAVITY;
        }

        bounds.setPosition(getX(), getY());
    }

    @Override
    public void act(float delta) {
        actHero(delta);
        setPos();
        collides();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(),getScaleY(),getRotation());
    }
}
