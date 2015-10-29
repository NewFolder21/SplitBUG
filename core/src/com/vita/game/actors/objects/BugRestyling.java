package com.vita.game.actors.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.vita.game.interfaces.IMyOwnInputsCommands;

/**
 * Created by user on 26.10.2015.
 */
public class BugRestyling extends Actor implements IMyOwnInputsCommands, ITrackingObject {
    private Texture bug;
    private final float step = 80.0f;
    private Vector2 borderMin, borderMax;
    private Vector2 center;
    private float x, y, controlCoordinate;
    boolean leftMove, rightMove, downMove, upMove;

    public BugRestyling(float posX, float posY){
        bug = new Texture("red_circle.png");
        borderMin = new Vector2(0,0);
        borderMax = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        x = bug.getWidth() / 2;
        y = bug.getHeight() / 2;
        center = new Vector2(0,0);
        setX(x);
        setY(y);
    }
/*
    @Override
    public void setLeftMove(boolean t) {
        Gdx.app.log("BugRestyling","setLeftMove");
        controlCoordinate = center.x - step * Gdx.graphics.getDeltaTime();

        if(controlCoordinate < borderMin.x){
            center.x = borderMin.x;
        } else {
            center.x = controlCoordinate;
        }
    }

    @Override
    public void setRightMove(boolean t) {
        Gdx.app.log("BugRestyling","setRightMove");
        controlCoordinate = center.x + step * Gdx.graphics.getDeltaTime();

        if(controlCoordinate > borderMax.x){
            center.x = borderMax.x;
        } else {
            center.x = controlCoordinate;
        }
    }

    @Override
    public void setUpMove(boolean t) {
        Gdx.app.log("BugRestyling","setUpMove");
        controlCoordinate = center.y + step * Gdx.graphics.getDeltaTime();

        if(controlCoordinate > borderMax.y){
            center.y = borderMax.y;
        } else {
            center.y = controlCoordinate;
        }
    }

    @Override
    public void setDownMove(boolean t) {
        Gdx.app.log("BugRestyling","setDownMove");
        controlCoordinate = center.y - step * Gdx.graphics.getDeltaTime();

        if(controlCoordinate < borderMin.y){
            center.y = borderMin.y;
        } else {
            center.y = controlCoordinate;
        }
    }*/

    public void updateMotion(){

        if (leftMove){
            Gdx.app.log("BugRestyling","setLeftMove");
            controlCoordinate = center.x - step * Gdx.graphics.getDeltaTime();

            if(controlCoordinate < borderMin.x){
                center.x = borderMin.x;
            } else {
                center.x = controlCoordinate;
            }
        }
        if (rightMove){
            Gdx.app.log("BugRestyling","setRightMove");
            controlCoordinate = center.x + step * Gdx.graphics.getDeltaTime();

            if(controlCoordinate > borderMax.x){
                center.x = borderMax.x;
            } else {
                center.x = controlCoordinate;
            }
        }
        if (downMove){
            Gdx.app.log("BugRestyling","setDownMove");
            controlCoordinate = center.y - step * Gdx.graphics.getDeltaTime();

            if(controlCoordinate < borderMin.y){
                center.y = borderMin.y;
            } else {
                center.y = controlCoordinate;
            }
        }
        if (upMove){
            Gdx.app.log("BugRestyling","setUpMove");
            controlCoordinate = center.y + step * Gdx.graphics.getDeltaTime();

            if(controlCoordinate > borderMax.y){
                center.y = borderMax.y;
            } else {
                center.y = controlCoordinate;
            }
        }
    }

    public void setLeftMove(boolean t){
        if(rightMove && t) rightMove = false;
        //We dont want going diagonal? Yeap!
        if(downMove && t) downMove = false;
        if(upMove && t) upMove = false;

        leftMove = t;
    }

    public void setRightMove(boolean t){
        if(leftMove && t) leftMove = false;
        if(downMove && t) downMove = false;
        if(upMove && t) upMove = false;

        rightMove = t;
    }

    public void setUpMove(boolean t){
        if(downMove && t) downMove = false;
        if(rightMove && t) rightMove = false;
        if(leftMove && t) leftMove = false;

        upMove = t;
    }

    public void setDownMove(boolean t){
        if(upMove && t) upMove = false;
        if(rightMove && t) rightMove = false;
        if(leftMove && t) leftMove = false;

        downMove = t;
    }

    public void update(float delta) {
        updateMotion();
        setPosition(center.x - x, center.y - y);
    }

    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(bug, getX(), getY());
    }

    @Override
    public Vector2 getCoordinates() {
        return center;
    }
}
