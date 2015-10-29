package com.vita.game.world;

import com.badlogic.gdx.Gdx;
import com.vita.game.actors.group.Enemies;
import com.vita.game.actors.group.PathGroup;
import com.vita.game.actors.objects.ActiveBlock;
import com.vita.game.actors.objects.Bug;
import com.vita.game.actors.objects.BugRestyling;
import com.vita.game.actors.objects.InactiveBlock;
import com.vita.game.interfaces.IMyOwnInputsCommands;

/**
 * Created by user on 26.10.2015.
 */
public class World {
    private BugRestyling bug;
    private PathGroup path;
    private InactiveBlock inactiveBlock;
    private ActiveBlock activeBlock;
    private Enemies enemies;

    public World(){
        bug = new BugRestyling(Gdx.app.getGraphics().getHeight()/2, 0);
        activeBlock = new ActiveBlock();
        inactiveBlock = new InactiveBlock();
        enemies = new Enemies();
    }

    public void update(float delta){
        bug.update(delta);
        enemies.update();
        activeBlock.update();
        inactiveBlock.update();
    }

    public void render(){

    }

    public BugRestyling getBug(){
        return bug;
    }
}
