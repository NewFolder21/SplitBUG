package com.vita.game.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by user on 29.10.2015.
 */
public class CollidesDetection {
    public static boolean collideCircleAndCircle(Circle circle1, Circle circle2){
        return Intersector.overlaps(circle1, circle2);
    }
    public static boolean collideCircleAndRectangle(Circle circle, Rectangle rectangle){
        return Intersector.overlaps(circle, rectangle);
    }
    public static boolean collideCircleAndPolygon(Circle circle, Polygon polygon){
        float []vertices=polygon.getTransformedVertices();
        Vector2 center=new Vector2(circle.x, circle.y);
        float squareRadius=circle.radius*circle.radius;
        for (int i=0;i<vertices.length;i+=2){
            if (i==0){
                if (Intersector.intersectSegmentCircle(new Vector2(vertices[vertices.length - 2], vertices[vertices.length - 1]), new Vector2(vertices[i], vertices[i + 1]), center, squareRadius))
                    return true;
            } else {
                if (Intersector.intersectSegmentCircle(new Vector2(vertices[i-2], vertices[i-1]), new Vector2(vertices[i], vertices[i+1]), center, squareRadius))
                    return true;
            }
        }
        return polygon.contains(circle.x, circle.y);
    }

    public static boolean collideRectangleAndRectangle(Rectangle rectangle1, Rectangle rectangle2){
        return Intersector.overlaps(rectangle1, rectangle2);
    }
    public static boolean collideRectangleAndPolygon(Rectangle r, Polygon p) {
        Polygon rPoly = new Polygon(new float[] { 0, 0,
                r.width, 0,
                r.width, r.height,
                0, r.height });
        rPoly.setPosition(r.x, r.y);
        if (Intersector.overlapConvexPolygons(rPoly, p))
            return true;
        return false;
    }

    public static boolean collidePolygonAndPolygon(Polygon polygon1,Polygon polygon2){return false; }

}
