package com.vita.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by vitaliy on 13.03.15.
 */
public class PathBuilder {

    private ArrayList<Vector2> path;
    private int previousDirection;
    private Vector2 borderMin, borderMax;
    private final float step = 40.0f;
    boolean leftMove, rightMove, downMove, upMove;


    public PathBuilder(Vector2 start, Vector2 borderMin, Vector2 borderMax){
        path = new ArrayList<>();
        previousDirection = 0;
        this.borderMin = borderMin;
        this.borderMax = borderMax;
        path.add(start);
    }

    public void updateMotion(){
        if (leftMove){

            if(previousDirection != 4){
                Vector2 vec = new Vector2();
            }else{

            }
            /*
            x -= step * Gdx.graphics.getDeltaTime();
            if(x < 0)
                x = 0;

            Gdx.app.log("PATH LEFT : ", "" + x);

            setX(x);*/
        }
        if (rightMove){
            if(previousDirection != 2){

            }else{

            }
            /*x += step * Gdx.graphics.getDeltaTime();
            if(x > 620)
                x = 620;

            Gdx.app.log("PATH RIGHT : ", "" + x);

            setX(x);*/
        }
        if (downMove){
            if(previousDirection != 3){

            }else{

            }
            /*y += step * Gdx.graphics.getDeltaTime();
            if( y > 462)
                y = 462;

            Gdx.app.log("PATH UP : ", "" + y);

            setY(y);*/
        }
        if (upMove){
            if(previousDirection != 1){

            }else{

            }
            /*y -= step * Gdx.graphics.getDeltaTime();
            if(y < 0)
                y = 0;

            Gdx.app.log("PATH DOWN : ", "" + y);

            setY(y);*/
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
