package com.vita.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;

/**
 * Created by DzEN on 19.03.2015.
 */
public class PathGroup extends Group {

    private ArrayList<Vector2> path;
    private PathPart currentActor;
    private int previousDirection;
    private Vector2 borderMin, borderMax;
    private final float step = 40.0f;
    boolean leftMove, rightMove, downMove, upMove;

    public PathGroup(float x, float y){
        super();
        currentActor = new PathPart(x, y);
    }

    public void updateMotion(){
        if (leftMove){

            if(previousDirection != 4){
                Vector2 vec = new Vector2();
                vec.x = path.get(path.size() - 1).x - step * Gdx.graphics.getDeltaTime();
                vec.y = path.get(path.size() - 1).y;

                if(vec.x < borderMin.x)
                    vec.x = borderMin.x;
                //End draw part line of path , and set x & y for new part line of path
                currentActor.setSize(path.get(path.size() - 1).x - vec.x, path.get(path.size() - 1).y - vec.y);
                addActor(currentActor);
                currentActor = new PathPart(vec.x, vec.y);

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
