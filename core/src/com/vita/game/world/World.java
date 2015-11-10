package com.vita.game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Circle;
import com.vita.game.actors.group.Enemies;
import com.vita.game.actors.group.PathGroup;
import com.vita.game.actors.group.PathGroupRestyling;
import com.vita.game.actors.objects.ActiveBlock;
import com.vita.game.actors.objects.Bug;
import com.vita.game.actors.objects.BugRestyling;
import com.vita.game.actors.objects.InactiveBlock;
import com.vita.game.interfaces.IMyOwnInputsCommands;
import com.vita.game.utils.CollidesDetection;


import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

/**
 * Created by user on 26.10.2015.
 */
public class World {
    private BugRestyling bug;
    private PathGroupRestyling path;
    private InactiveBlock inactiveBlock;
    private ActiveBlock activeBlock;
    private Enemies enemies;

    public World(){
        bug = new BugRestyling(Gdx.app.getGraphics().getHeight()/2, 0);
        activeBlock = new ActiveBlock();
        inactiveBlock = new InactiveBlock();
        enemies = new Enemies();
        path = new PathGroupRestyling(bug.getCenterCoordinates());
    }

    public void update(float delta){
        bug.update(delta);
        enemies.update();
        activeBlock.update();
        inactiveBlock.update();

        //Gdx.app.log("Collision : ", CollidesDetection.collideCircleAndPolygon((Circle)bug.getFigure(), (Polygon)activeBlock.getFigure()) + "");
        if(CollidesDetection.collideCircleAndPolygon((Circle)bug.getFigure(), (Polygon)activeBlock.getFigure())){
            if(!path.getIsDrawing())            {
                path.startBuildPath(bug.getPointLastChangeDirection());
            }
            path.update();
        } else {
            if(path.getIsDrawing()){
                path.stopBuildPath();
            }
        }
    }

    public void render(){

    }

    public BugRestyling getBug(){
        return bug;
    }

    public ActiveBlock getActiveBlock () {return activeBlock;}

    public InactiveBlock getInactiveBlock () { return inactiveBlock; }

    public PathGroupRestyling getPath(){ return path; }
}
