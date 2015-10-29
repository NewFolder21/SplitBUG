package com.vita.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    SpriteBatch batch;

    public WorldRenderer (BugRestyling bug, PathGroupRestyling path, Enemies enemies, ActiveBlock activeBlock, InactiveBlock inactiveBlock){
        batch = new SpriteBatch();
        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        this.bug = bug;
/*        this.path = path;
        this.enemies = enemies;
        this.activeBlock = activeBlock;
        this.inactiveBlock = inactiveBlock;*/

        stage.addActor(bug);
/*        stage.addActor(path);
        stage.addActor(enemies);
        stage.addActor(activeBlock);
        stage.addActor(inactiveBlock);*/
    }

    public void render(){
        batch.begin();
        bug.draw(batch, 0);
        batch.end();
    }
}
