package com.vita.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.vita.game.actors.Bug;


public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
    Bug bug;
    Stage stage;

	@Override
	public void create () {

		batch = new SpriteBatch();
        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        bug = new Bug(32, 32);
        bug.setSize(16,16);
        Gdx.input.setInputProcessor(new OwnInputProcessor(bug));
        stage.addActor(bug);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();

        stage.act(Gdx.graphics.getDeltaTime());
	}
}
