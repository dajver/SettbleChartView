package com.project.chartview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.project.chartview.R;

/**
 * Created by gleb on 5/27/17.
 */

public class PreviewPieChartView extends BasePieChartView {

    public static final float ARC_SIZE = 100f;

    public PreviewPieChartView(Context context) {
        super(context);
        this.context = context;
        setUpView();
    }

    public PreviewPieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setUpView();
    }

    public PreviewPieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setUpView();
    }

    @Override
    public void onDraw(Canvas canvas) {
        drawingSettings();

        drawBackGroundCircle(canvas);
        drawNineCircles(canvas);
        drawPartsOfPie(canvas);
        drawStrokeBackgroundLines(canvas);
        drawCircleWithI(canvas);
        drawI(canvas);

        int scaledSize = getResources().getDimensionPixelSize(R.dimen.myFontSize);
        float circleRadius = radius;
        for (int i = 0; i < 360; i += 45) {
            float angle = (float) (i * Math.PI / 180f) - 75;

            float startX = (float) (cx + circleRadius * Math.sin(angle));
            float startY = (float) (cy - circleRadius * Math.cos(angle));

            slicePaint.setColor(context.getResources().getColor(android.R.color.white));
            canvas.drawCircle(startX, startY, radius / 10, slicePaint);

            if(colorsOfCircles[i] != 0)
                circlePaint.setColor(context.getResources().getColor(colorsOfCircles[i]));
            canvas.drawCircle(startX, startY, radius / 10, circlePaint);

            slicePaint.setTextAlign(Paint.Align.CENTER);
            slicePaint.setTextSize(scaledSize);
            slicePaint.setColor(context.getResources().getColor(R.color.round_color_center_circle_text));
            canvas.drawText(String.valueOf((int)(sizeOfArcs[i] * ARC_SIZE)), startX, startY + 20, slicePaint);
        }
    }
}