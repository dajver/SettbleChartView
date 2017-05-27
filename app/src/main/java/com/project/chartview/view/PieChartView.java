package com.project.chartview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by gleb on 5/27/17.
 */

public class PieChartView extends BasePieChartView {

    public PieChartView(Context context) {
        super(context);
        this.context = context;
        setUpView();
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setUpView();
    }

    public PieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setUpView();
    }

    @Override
    public void onDraw(Canvas canvas) {
        drawingSettings();
        drawBackGroundCircle(canvas);
        drawPartsOfPie(canvas);
        drawNineCircles(canvas);
        drawStrokeBackgroundLines(canvas);
        drawCircleWithI(canvas);
        drawI(canvas);
    }
}