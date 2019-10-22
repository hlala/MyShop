package com.example.my_shop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class PathView extends View {
    private Path mPath;
    private Paint mPaint;

    public PathView(Context context) {
        super(context);

        init();
    }

    private void init() {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(12);
        mPaint.setColor(Color.RED);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.addRect(200, 100, 500, 300, Path.Direction.CW);
        canvas.drawPath(mPath, mPaint);

        mPath.reset();

        mPath.addRect(200, 400, 500, 600, Path.Direction.CCW);
        canvas.drawPath(mPath, mPaint);

    }
}
