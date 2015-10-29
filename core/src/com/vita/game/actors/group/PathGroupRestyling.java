package com.vita.game.actors.group;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.vita.game.interfaces.IMyOwnInputsCommands;

/**
 * Created by user on 27.10.2015.
 */
public class PathGroupRestyling extends Group implements IMyOwnInputsCommands {
    private Vector2 trackingObjCoordinates;

    public PathGroupRestyling (Vector2 trackingObjCoordinates){
        this.trackingObjCoordinates = trackingObjCoordinates;
    }
    //Collision bug and Active block -> start build path
    //Prototype params of method : start point, bug (for getting center of bug)
    public void startBuildPath(){

    }

    //Update
    public void update() {
        //if no has point - return
    }


    @Override
    public void setLeftMove(boolean t) {

    }

    @Override
    public void setRightMove(boolean t) {

    }

    @Override
    public void setUpMove(boolean t) {

    }

    @Override
    public void setDownMove(boolean t) {

    }
}
