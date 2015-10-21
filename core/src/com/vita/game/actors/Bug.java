package com.vita.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by DzEN on 10.03.2015.
 */
public class Bug extends Actor implements IOwnInputsComands {
    private Texture bug;
    private Texture path_block;
    private final float step = 80.0f;
    private Vector2 borderMin, borderMax;
    private float x, y;
    boolean leftMove, rightMove, downMove, upMove;

    public Bug(float posX, float posY){
        bug = new Texture("red_circle.png");
        path_block = new Texture("white_square.png");
        borderMin = new Vector2(0,0);
        borderMax = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        x = -16;
        y = -16;
        setX(x);
        setY(y);

    }

    @Override
    public void draw(Batch batch, float alpha){
        updateMotion();
        batch.draw(bug, getX(), getY());
    }

    public void updateMotion(){
        Gdx.app.log("CHECK COLLIDE : ", "" + checkColide());
        if (leftMove){
            x -= step * Gdx.graphics.getDeltaTime();
            if(x < -16)
                x = -16;

            Gdx.app.log("LEFT : ", "" + x);

            setX(x);
        }
        if (rightMove){
            x += step * Gdx.graphics.getDeltaTime();
            if(x > borderMax.x - 16)
                x = borderMax.x - 16;

            Gdx.app.log("RIGHT : ", "" + x);

            setX(x);
        }
        if (downMove){
            y += step * Gdx.graphics.getDeltaTime();
            if( y > borderMax.y - 16)
                y = borderMax.y - 16;

            Gdx.app.log("UP : ", "" + y);

            setY(y);
        }
        if (upMove){
            y -= step * Gdx.graphics.getDeltaTime();
            if(y < -16)
                y = -16;

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

    public boolean  checkColide(){
        if (x == -16 || x == borderMax.x - 16){
            return false;
        }

        if( y == -16 || y == borderMax.y - 16){
            return false;
        }

        return true;
    }

}
