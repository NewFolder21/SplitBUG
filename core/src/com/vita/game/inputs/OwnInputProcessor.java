package com.vita.game.inputs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.vita.game.actors.Bug;
import com.vita.game.actors.IOwnInputsComands;
import com.vita.game.utils.PathBuilder;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by DzEN on 11.03.2015.
 */
public class OwnInputProcessor implements InputProcessor {
    private ArrayList<IOwnInputsComands> actors;
    private Iterator<IOwnInputsComands> iteratorActor;

    public OwnInputProcessor(){
        actors = new ArrayList<>();
    }

    @Override
    public boolean keyDown(int keycode) {
        iteratorActor = actors.iterator();
        switch (keycode){
            case Input.Keys.DOWN:
                while(iteratorActor.hasNext()){
                    iteratorActor.next().setUpMove(true);
                }
                break;
            case Input.Keys.UP:
                while(iteratorActor.hasNext()){
                    iteratorActor.next().setDownMove(true);
                }
                break;
            case Input.Keys.LEFT:
                while(iteratorActor.hasNext()){
                    iteratorActor.next().setLeftMove(true);
                }
                break;
            case Input.Keys.RIGHT:
                while(iteratorActor.hasNext()){
                    iteratorActor.next().setRightMove(true);
                }
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {

        iteratorActor = actors.iterator();
        switch (keycode){
            case Input.Keys.DOWN:
                while(iteratorActor.hasNext()){
                    iteratorActor.next().setUpMove(false);
                }
                break;
            case Input.Keys.UP:
                while(iteratorActor.hasNext()){
                    iteratorActor.next().setDownMove(false);
                }
                break;
            case Input.Keys.LEFT:
                while(iteratorActor.hasNext()){
                    iteratorActor.next().setLeftMove(false);
                }
                break;
            case Input.Keys.RIGHT:
                while(iteratorActor.hasNext()){
                    iteratorActor.next().setRightMove(false);
                }
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

    public void addInputsActor(IOwnInputsComands actor){
        actors.add(actor);
    }

    public void removeAllInputsActors(){
        actors.clear();
    }
}
