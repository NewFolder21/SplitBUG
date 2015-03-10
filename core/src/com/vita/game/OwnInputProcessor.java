package com.vita.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by DzEN on 11.03.2015.
 */
public class OwnInputProcessor implements InputProcessor {
    private Bug bug;

    public OwnInputProcessor(Bug bug){
        super();
        this.bug = bug;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.DOWN:
                bug.down();
                break;
            case Input.Keys.UP:
                bug.up();
                break;
            case Input.Keys.LEFT:
                bug.left();
                break;
            case Input.Keys.RIGHT:
                bug.right();
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
