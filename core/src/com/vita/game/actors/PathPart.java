package com.vita.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by DzEN on 19.03.2015.
 */
public class PathPart extends Actor {
    private Texture path_block;
    static int id = 0;
    private int own_id;

    public PathPart(float x, float y){
        path_block = new Texture("white_square.png");
        setPosition(x, y);
        own_id = id++;
    }

    @Override
    public void draw(Batch batch, float alpha){
        //Gdx.app.log("PathPart", "" + this.getWidth());
        batch.draw(path_block, getX(), getY(),  getWidth(), getHeight());
    }

    public void show(){
        Gdx.app.log("PathPart --" + own_id, getX() + " " + getY() + " || " + getWidth() + " : " + getHeight());
    }

    public Texture getTexture(){
        return path_block;
    }
}
