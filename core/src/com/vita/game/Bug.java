package com.vita.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by DzEN on 10.03.2015.
 */
public class Bug extends Actor {
    private Texture bug;
    private final float step = 10.0f;
    private float x, y;

    public Bug(float posX, float posY){
        bug = new Texture("red_circle.png");
        setX(posX);
        setY(posY);
    }

    @Override
    public void draw(Batch batch, float alpha){
        x = getX();
        y = getY();

        if(x < 0)
            x = 0;
        else if( x > 800)
            x = 800;

        if(y < 0)
            y = 0;
        else if( y > 800)
            y = 800;

        batch.draw(bug, x, y, getWidth(), getHeight());
    }

    public void down(){
        setY(getY() + step);
    }

    public void up(){
        setY(getY() - step);
    }

    public void left(){
        setX(getX() - step);
    }

    public void right(){
        setX(getX() + step);
    }
}
