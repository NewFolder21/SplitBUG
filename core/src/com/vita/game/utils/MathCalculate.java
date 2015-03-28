package com.vita.game.utils;

import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * Created by DzEN on 28.03.2015.
 */
public class MathCalculate {

    public float polygonArea(List<Vector2> points){
        float area = 0;         // Accumulates area in the loop
        int numPoints = points.size(),
                j = numPoints - 1;

        for (int i=0; i<numPoints; i++){
            area = area +  (points.get(j).x +points.get(i).x) * (points.get(j).y-points.get(i).y);
            j = i;  //j is previous vertex to i
        }

        return area/2;
    }
}
