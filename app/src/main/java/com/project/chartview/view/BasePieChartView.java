package com.project.chartview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.project.chartview.R;
import com.project.chartview.view.helper.CircleRadiusHelper;

/**
 * Created by gleb on 5/27/17.
 */

public abstract class BasePieChartView extends View {

    public Context context;
    private IOnClickListener iOnClickListener;

    public Paint circlePaint;
    public Paint slicePaint;
    public Paint linesPaint;
    public float[] datapoints = {450, 450, 450, 450, 450, 450, 450, 450};
    public float[] sizeOfArcs = new float[360];
    public int[] colorsOfCircles = new int[360];
    public RectF rectf;
    public float centerX;
    public float centerY;

    public float firstPieChartSize = 0;
    public float secondPieChartSize = 0;
    public float thirdPieChartSize = 0;
    public float fourthPieChartSize = 0;
    public float fifthPieChartSize = 0;
    public float sixthPieChartSize = 0;
    public float seventhPieChartSize = 0;
    public float eighthPieChartSize = 0;

    public float cx;
    public float cy;

    public float IXPosition;
    public float IYPosition;

    public float radius;

    public BasePieChartView(Context context) {
        super(context);
    }

    public BasePieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BasePieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setUpView() {
        slicePaint = new Paint();
        slicePaint.setAntiAlias(true);
        slicePaint.setDither(true);
        slicePaint.setStyle(Paint.Style.FILL);

        linesPaint = new Paint();
        linesPaint.setAntiAlias(true);
        linesPaint.setDither(true);
        linesPaint.setStyle(Paint.Style.FILL);
        linesPaint.setStrokeWidth(2);
        linesPaint.setColor(context.getResources().getColor(android.R.color.white));

        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setDither(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(1);

        rectf = new RectF();

        colorsOfCircles[90] = R.color.circle_first_color;
        colorsOfCircles[135] = R.color.circle_second_color;
        colorsOfCircles[180] = R.color.circle_third_color;
        colorsOfCircles[225] = R.color.circle_forth_color;
        colorsOfCircles[270] = R.color.circle_fifth_color;
        colorsOfCircles[270] = R.color.circle_sixth_color;
        colorsOfCircles[0] = R.color.circle_seventh_color;
        colorsOfCircles[45] = R.color.circle_eight_color;
    }

    public void drawingSettings() {
        int startTop = 0;
        int startLeft = 0;
        int endBottom = getHeight();
        int endRight = getWidth();

        rectf.set(startLeft, startTop, endRight, endBottom);

        centerX = rectf.centerX();
        centerY = rectf.centerY();

        cx = getWidth() / 2f;
        cy = getHeight() / 2f;
    }

    public void drawBackGroundCircle(Canvas canvas) {
        slicePaint.setColor(context.getResources().getColor(R.color.round_color_center_circle));
        canvas.drawCircle(centerX, centerY, radius, slicePaint);

        radius = CircleRadiusHelper.getRadius(canvas);
    }

    public void drawNineCircles(Canvas canvas) {
        circlePaint.setColor(context.getResources().getColor(R.color.white));

        int circlesCount = 10;
        float percent = 0f;
        float percentStep = 1f / (float) circlesCount;

        for (int i = 0; i < circlesCount; i++) {
            percent += percentStep;
            canvas.drawCircle(centerX, centerY, getCircleRadius(percent), circlePaint);
        }
    }

    public void drawPartsOfPie(Canvas canvas) {
        float[] scaledValues = scale();
        float sliceStartPoint = 0;

        calculateRectForPieSlice(rectf, firstPieChartSize);
        slicePaint.setColor(context.getResources().getColor(R.color.circle_first_color));
        canvas.drawArc(rectf, sliceStartPoint, scaledValues[0], true, slicePaint);
        sliceStartPoint += scaledValues[0];

        calculateRectForPieSlice(rectf, secondPieChartSize);
        slicePaint.setColor(context.getResources().getColor(R.color.circle_second_color));
        canvas.drawArc(rectf, sliceStartPoint, scaledValues[1], true, slicePaint);
        sliceStartPoint += scaledValues[1];

        calculateRectForPieSlice(rectf, thirdPieChartSize);
        slicePaint.setColor(context.getResources().getColor(R.color.circle_third_color));
        canvas.drawArc(rectf, sliceStartPoint, scaledValues[2], true, slicePaint);
        sliceStartPoint += scaledValues[2];

        calculateRectForPieSlice(rectf, fourthPieChartSize);
        slicePaint.setColor(context.getResources().getColor(R.color.circle_forth_color));
        canvas.drawArc(rectf, sliceStartPoint, scaledValues[3], true, slicePaint);
        sliceStartPoint += scaledValues[3];

        calculateRectForPieSlice(rectf, fifthPieChartSize);
        slicePaint.setColor(context.getResources().getColor(R.color.circle_fifth_color));
        canvas.drawArc(rectf, sliceStartPoint, scaledValues[4], true, slicePaint);
        sliceStartPoint += scaledValues[4];

        calculateRectForPieSlice(rectf, sixthPieChartSize);
        slicePaint.setColor(context.getResources().getColor(R.color.circle_sixth_color));
        canvas.drawArc(rectf, sliceStartPoint, scaledValues[5], true, slicePaint);
        sliceStartPoint += scaledValues[5];

        calculateRectForPieSlice(rectf, seventhPieChartSize);
        slicePaint.setColor(context.getResources().getColor(R.color.circle_seventh_color));
        canvas.drawArc(rectf, sliceStartPoint, scaledValues[6], true, slicePaint);
        sliceStartPoint += scaledValues[6];

        calculateRectForPieSlice(rectf, eighthPieChartSize);
        slicePaint.setColor(context.getResources().getColor(R.color.circle_eight_color));
        canvas.drawArc(rectf, sliceStartPoint, scaledValues[7], true, slicePaint);
    }

    public void drawStrokeBackgroundLines(Canvas canvas) {
        float scaleMarkSize = getResources().getDisplayMetrics().density * 16;
        float radius = Math.min(getWidth(), getHeight());

        for (int i = 0; i < 360; i += 45) {
            float angle = (float) (i * Math.PI / 180f);

            float stopX = (float) (centerX + (radius - scaleMarkSize) * Math.sin(angle));
            float stopY = (float) (centerY - (radius - scaleMarkSize) * Math.cos(angle));

            canvas.drawLine(centerX, centerY, stopX, stopY, linesPaint);
        }
    }

    public void drawCircleWithI(Canvas canvas) {
        slicePaint.setColor(context.getResources().getColor(R.color.round_color_center_circle_second));
        canvas.drawCircle(centerX, centerY, radius / 4, slicePaint);
        slicePaint.setColor(context.getResources().getColor(R.color.round_color_center_circle));
        canvas.drawCircle(centerX, centerY, radius / 6, slicePaint);
    }

    public void drawI(Canvas canvas) {
        slicePaint.setTextSize(60);
        slicePaint.setTextAlign(Paint.Align.CENTER);
        slicePaint.setColor(context.getResources().getColor(R.color.round_color_center_circle_text));
        canvas.drawText("i", centerX, centerY + 20, slicePaint);
        IXPosition = centerX;
        IYPosition = centerY;
    }

    public float[] scale() {
        float[] scaledValues = new float[this.datapoints.length];
        float total = getTotal();
        for (int i = 0; i < this.datapoints.length; i++) {
            scaledValues[i] = (this.datapoints[i] / total) * 360;
        }
        return scaledValues;
    }

    private float getCircleRadius(float percent) {
        float invisibleRadius = radius / 4;
        float visibleRadius = radius - invisibleRadius;
        return invisibleRadius + visibleRadius * percent;
    }

    private void calculateRectForPieSlice(RectF source, float slicePercent) {
        float invisibleRadius = radius / 4;
        float visibleRadius = radius - invisibleRadius;
        float sliceRadius = invisibleRadius + visibleRadius * slicePercent;

        source.set(centerX - sliceRadius, centerY - sliceRadius, centerX + sliceRadius, centerY + sliceRadius);
    }

    public float getTotal() {
        float total = 0;
        for (float val : this.datapoints)
            total += val;
        return total;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                final float x = ev.getX();
                final float y = ev.getY();
                if(x >= IXPosition - 50 && y >= IYPosition - 50 && x <= IXPosition + 50 && y <= IYPosition + 50)
                    iOnClickListener.iWasClicked();
                break;
        }
        return true;
    }

    public void setOnIClickListener(IOnClickListener listener) {
        this.iOnClickListener = listener;
    }

    public interface IOnClickListener {
        void iWasClicked();
    }

    public void setFirstPieChartSize(float firstPieChartSize) {
        sizeOfArcs[90] = firstPieChartSize;
        this.firstPieChartSize = firstPieChartSize;
    }

    public void setSecondPieChartSize(float secondPieChartSize) {
        sizeOfArcs[135] = secondPieChartSize;
        this.secondPieChartSize = secondPieChartSize;
    }

    public void setThirdPieChartSize(float thirdPieChartSize) {
        sizeOfArcs[180] = thirdPieChartSize;
        this.thirdPieChartSize = thirdPieChartSize;
    }

    public void setFourthPieChartSize(float fourthPieChartSize) {
        sizeOfArcs[225] = fourthPieChartSize;
        this.fourthPieChartSize = fourthPieChartSize;
    }

    public void setFifthPieChartSize(float fifthPieChartSize) {
        sizeOfArcs[270] = fifthPieChartSize;
        this.fifthPieChartSize = fifthPieChartSize;
    }

    public void setSixthPieChartSize(float sixthPieChartSize) {
        sizeOfArcs[315] = sixthPieChartSize;
        this.sixthPieChartSize = sixthPieChartSize;
    }

    public void setSeventhPieChartSize(float seventhPieChartSize) {
        sizeOfArcs[0] = seventhPieChartSize;
        this.seventhPieChartSize = seventhPieChartSize;
    }

    public void setEighthPieChartSize(float sevenPieChartSize) {
        sizeOfArcs[45] = sevenPieChartSize;
        this.eighthPieChartSize = sevenPieChartSize;
    }
}