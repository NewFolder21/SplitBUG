package com.vita.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.vita.game.actors.objects.Bug;
import com.vita.game.actors.group.PathGroup;
import com.vita.game.inputs.OwnInputProcessor;


public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
    Bug bug;
    Stage stage;
    OwnInputProcessor inputProcessor;
    PathGroup pathGroup;

	@Override
	public void create () {

		batch = new SpriteBatch();
        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        bug = new Bug(32, 32);

        //pathBuilder = new Path( new Vector2(16f,16f),new Vector2(0f,0f),new Vector2(400f,400f));
        inputProcessor = new OwnInputProcessor();
        inputProcessor.addInputsActor(bug);
        //inputProcessor.addInputsActor(pathBuilder);
        Gdx.input.setInputProcessor(inputProcessor);
        stage.addActor(bug);

        //**************************TEST
        pathGroup = new PathGroup(0, 0);
        inputProcessor.addInputsActor(pathGroup);
        stage.addActor(pathGroup);
        //******************************
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());
	}
}
