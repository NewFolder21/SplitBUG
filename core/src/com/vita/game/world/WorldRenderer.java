package com.vita.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.vita.game.actors.group.Enemies;
import com.vita.game.actors.group.PathGroupRestyling;
import com.vita.game.actors.objects.ActiveBlock;
import com.vita.game.actors.objects.BugRestyling;
import com.vita.game.actors.objects.InactiveBlock;

/**
 * Created by user on 28.10.2015.
 */
public class WorldRenderer {
    private BugRestyling bug;
    private PathGroupRestyling path;
    private Enemies enemies;
    private ActiveBlock activeBlock;
    private InactiveBlock inactiveBlock;
    private Stage stage;
    PolygonSpriteBatch batch;
    ShapeRenderer shapeRenderer;

    public WorldRenderer (BugRestyling bug, PathGroupRestyling path, Enemies enemies, ActiveBlock activeBlock, InactiveBlock inactiveBlock){
        batch = new PolygonSpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        this.bug = bug;
        this.activeBlock = activeBlock;
        this.inactiveBlock = inactiveBlock;
        this.path = path;
        //this.path = path;
        //this.enemies = enemies;

        stage.addActor(inactiveBlock);
        stage.addActor(activeBlock);
        stage.addActor(path);
        stage.addActor(bug);
        //stage.addActor(enemies);
        //stage.addActor(inactiveBlock);
    }

    public void render(){
        stage.draw();
    }
}
