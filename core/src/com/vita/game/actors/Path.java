package com.vita.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by vitaliy on 13.03.15.
 */
public class Path extends Actor implements IOwnInputsComands {
    private Texture path_block;
    private ArrayList<Vector2> path;
    private int previousDirection;
    private Vector2 borderMin, borderMax;
    private final float step = 40.0f;
    boolean leftMove, rightMove, downMove, upMove;
    /*0 : 0 ; vector
    * 1 : 3 ; vector
    * */

    public Path(Vector2 start, Vector2 borderMin, Vector2 borderMax){
        path = new ArrayList<>();
        previousDirection = 0;
        this.borderMin = borderMin;
        this.borderMax = borderMax;
        path_block = new Texture("white_square.png");
        path.add(start);
    }

    @Override
    public void draw(Batch batch, float alpha){
        updateMotion();
        batch.draw(path_block, getX(), getY());
    }

    public void updateMotion(){
        if (leftMove){

            if(previousDirection != 4){
                Vector2 vec = new Vector2();
                vec.x = path.get(path.size() - 1).x - step * Gdx.graphics.getDeltaTime();
                vec.y = path.get(path.size() - 1).y;

                if(vec.x < borderMin.x)
                    vec.x = borderMin.x;

                path.add(vec);
                Gdx.app.log("PATH LEFT (C): ", "" + vec.x);
                vec = null;
            }else{
                Vector2 vec = path.get(path.size() - 1);
                vec.x -= step * Gdx.graphics.getDeltaTime();

                if(vec.x < borderMin.x)
                    vec.x = borderMin.x;

                Gdx.app.log("PATH LEFT (NC): ", "" + vec.x + "-" + path.size());
                vec = null;
            }

            previousDirection = 4;
        }

        if (rightMove){
            if(previousDirection != 2){
                Vector2 vec = new Vector2();
                vec.x = path.get(path.size() - 1).x + step * Gdx.graphics.getDeltaTime();
                vec.y = path.get(path.size() - 1).y;

                if(vec.x < borderMin.x)
                    vec.x = borderMin.x;

                path.add(vec);
                Gdx.app.log("PATH RIGHT (C): ", "" + vec.x);
                vec = null;
            }else{
                Vector2 vec = path.get(path.size() - 1);
                vec.x += step * Gdx.graphics.getDeltaTime();

                if(vec.x < borderMin.x)
                    vec.x = borderMin.x;

                Gdx.app.log("PATH RIGHT (NC): ", "" + vec.x + "-" + path.size());
                vec = null;
            }

            previousDirection = 2;

        }

        if (downMove){
            if(previousDirection != 3){
                Vector2 vec = new Vector2();
                vec.x = path.get(path.size() - 1).x;
                vec.y = path.get(path.size() - 1).y + step * Gdx.graphics.getDeltaTime();

                if(vec.y < borderMin.y)
                    vec.y = borderMin.y;

                path.add(vec);
                Gdx.app.log("PATH DOWN (C): ", "" + vec.y);
                vec = null;
            }else{
                Vector2 vec = path.get(path.size() - 1);
                vec.y += step * Gdx.graphics.getDeltaTime();

                if(vec.y < borderMin.y)
                    vec.y = borderMin.y;

                Gdx.app.log("PATH DOWN (NC): ", "" + vec.y + "-" + path.size());
                vec = null;
            }
            previousDirection = 3;

        }

        if (upMove){
            if(previousDirection != 1){
                Vector2 vec = new Vector2();
                vec.x = path.get(path.size() - 1).x;
                vec.y = path.get(path.size() - 1).y - step * Gdx.graphics.getDeltaTime();

                if(vec.y < borderMin.y)
                    vec.y = borderMin.y;

                path.add(vec);
                Gdx.app.log("PATH DOWN (C): ", "" + vec.y);
                vec = null;
            }else{
                Vector2 vec = path.get(path.size() - 1);
                vec.y -= step * Gdx.graphics.getDeltaTime();

                if(vec.y < borderMin.y)
                    vec.y = borderMin.y;

                Gdx.app.log("PATH DOWN (NC): ", "" + vec.y + "-" + path.size());
                vec = null;
            }
            previousDirection = 1;

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
//