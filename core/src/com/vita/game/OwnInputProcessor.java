package com.vita.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.vita.game.actors.Bug;

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
                bug.setUpMove(true);
                break;
            case Input.Keys.UP:
                bug.setDownMove(true);
                break;
            case Input.Keys.LEFT:
                bug.setLeftMove(true);
                break;
            case Input.Keys.RIGHT:
                bug.setRightMove(true);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {

        switch (keycode){
            case Input.Keys.DOWN:
                bug.setUpMove(false);
                break;
            case Input.Keys.UP:
                bug.setDownMove(false);
                break;
            case Input.Keys.LEFT:
                bug.setLeftMove(false);
                break;
            case Input.Keys.RIGHT:
                bug.setRightMove(false);
                break;
            default:
                break;
        }
        return true;
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
