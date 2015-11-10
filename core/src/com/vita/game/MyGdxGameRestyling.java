package com.vita.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.vita.game.inputs.OwnInputProcessor;
import com.vita.game.world.World;
import com.vita.game.world.WorldRenderer;

/**
 * Created by user on 27.10.2015.
 */
public class MyGdxGameRestyling extends ApplicationAdapter {
    private World world;
    private WorldRenderer worldRenderer;
    private OwnInputProcessor inputProcessor;

    @Override
    public void create() {

        world = new World();
        worldRenderer = new WorldRenderer(world.getBug(), world.getPath(), null, world.getActiveBlock(), world.getInactiveBlock());
        inputProcessor = new OwnInputProcessor();
        inputProcessor.addInputsActor(world.getBug());
        inputProcessor.addInputsActor(world.getPath());
        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.update(Gdx.graphics.getDeltaTime());
        worldRenderer.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }
}
