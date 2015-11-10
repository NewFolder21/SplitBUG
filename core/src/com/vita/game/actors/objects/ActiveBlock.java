package com.vita.game.actors.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.ShortArray;
import com.vita.game.interfaces.ISupportForOverlapDetection;

/**
 * Created by user on 26.10.2015.
 */
public class ActiveBlock extends Actor implements ISupportForOverlapDetection {

    private Polygon playArea;
    private Texture texture;
    private PolygonSprite polygonSprite;
    private PolygonRegion region;
    private float [] vertices;
    private EarClippingTriangulator triangulator;
    private ShortArray triangleIndices;

    public ActiveBlock(){
        super();
        Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pix.setColor(0x00aaffff); // DE is red, AD is green and BE is blue.
        pix.fill();
        texture = new Texture(pix);
        playArea = (new Polygon(new float[] {
                1, 1,
                Gdx.graphics.getWidth() - 1, 1,
                Gdx.graphics.getWidth() - 1, Gdx.graphics.getHeight() - 1,
                1, Gdx.graphics.getHeight() -1
        }));

        vertices = new float[] {
                1, 1,
                Gdx.graphics.getWidth() - 1, 1,
                Gdx.graphics.getWidth() - 1, Gdx.graphics.getHeight() - 1,
                1, Gdx.graphics.getHeight() -1
        };

    }

    public void update() {
        updateTriangulators();
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        polygonSprite.draw((PolygonSpriteBatch)batch);
    }

    @Override
    public Object getFigure() {
        return playArea;
    }

    private void updateTriangulators(){
        triangulator = new EarClippingTriangulator();
        triangleIndices = triangulator.computeTriangles(vertices);

        region = new PolygonRegion(new TextureRegion(texture),  vertices, triangleIndices.toArray());
        polygonSprite = new PolygonSprite(region);
    }
}
