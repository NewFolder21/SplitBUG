package com.vita.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by DzEN on 10.03.2015.
 */
public class Bug extends Actor implements IOwnInputsComands {
    private Texture bug;
    private Texture path_block;
    private final float step = 40.0f;
    private float x, y;
    boolean leftMove, rightMove, downMove, upMove;

    public Bug(float posX, float posY){
        bug = new Texture("red_circle.png");
        path_block = new Texture("white_square.png");
        x = 0;
        y = posY;
        setX(x);
        setY(y);

    }

    @Override
    public void draw(Batch batch, float alpha){
        updateMotion();
        batch.draw(bug, getX(), getY());
    }

    public void updateMotion(){
        if (leftMove){
            x -= step * Gdx.graphics.getDeltaTime();
            if(x < 0)
                x = 0;

            Gdx.app.log("LEFT : ", "" + x);

            setX(x);
        }
        if (rightMove){
            x += step * Gdx.graphics.getDeltaTime();
            if(x > 620)
                x = 620;

            Gdx.app.log("RIGHT : ", "" + x);

            setX(x);
        }
        if (downMove){
            y += step * Gdx.graphics.getDeltaTime();
            if( y > 462)
                y = 462;

            Gdx.app.log("UP : ", "" + y);

            setY(y);
        }
        if (upMove){
            y -= step * Gdx.graphics.getDeltaTime();
            if(y < 0)
                y = 0;

            Gdx.app.log("DOWN : ", "" + y);

            setY(y);
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
}
