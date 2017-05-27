package com.project.chartview.view.helper;

import android.graphics.Canvas;

/**
 * Created by gleb on 5/27/17.
 */

public class CircleRadiusHelper {
    public static float getRadius(Canvas canvas) {
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        float minSize = width > height ? height : width;
        float radius = minSize / 2;
        return radius;
    }
}
