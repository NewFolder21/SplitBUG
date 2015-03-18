package com.vita.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by DzEN on 19.03.2015.
 */
public class PathPart extends Actor {
    private Texture path_block;

    public PathPart(float x, float y){
        path_block = new Texture("white_square.png");
        setPosition(x, y);
    }

    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(path_block, getX(), getY());
    }


}
