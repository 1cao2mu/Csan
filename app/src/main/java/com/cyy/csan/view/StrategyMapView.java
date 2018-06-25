package com.cyy.csan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.cyy.csan.R;
import com.cyy.csan.bean.City;
import com.cyy.csan.listener.OnClickCityListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by cyy
 * on 18-6-6.
 */
public class StrategyMapView extends View {
    private List<City> mCityList = new ArrayList<>();
    private Paint mPaint;
    private Context context;
    private int mWidth, mHeight, heightSize, widthSize;
    private boolean ismedium = false;
    private String TAG = "StrategyMapView";
    private OnClickCityListener onClickCityListener;
    private float cityWidth, cityHeight;
    private float lastX, lastY;

    public StrategyMapView(Context context) {
        super(context);
        initData(context);
    }

    public StrategyMapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context);

    }

    private void initData(Context context) {
        mPaint = new Paint();
        this.context = context;
    }

    public void setOnClickCityListener(OnClickCityListener onClickCityListener) {
        this.onClickCityListener = onClickCityListener;
    }

    public boolean isIsmedium() {
        return ismedium;
    }

    public void setIsmedium(boolean ismedium) {
        this.ismedium = ismedium;
    }

    public void setCityList(List<City> cityList) {
        setIsmedium(false);
        mCityList = cityList;
        invalidate();
    }

    public void setCityList(List<City> cityList, boolean ismedium) {
        setIsmedium(ismedium);
        mCityList = cityList;
        invalidate();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
            this.widthSize = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            throw new IllegalArgumentException("width must be EXACTLY,you should set like android:width=\"200dp\"");
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
            this.heightSize = heightSize;

        } else if (widthMeasureSpec == MeasureSpec.AT_MOST) {
            throw new IllegalArgumentException("height must be EXACTLY,you should set like android:height=\"200dp\"");
        }
        Log.e(TAG, "mWidth: " + mWidth);
        Log.e(TAG, "mHeight: " + mHeight);

        setMeasuredDimension(mWidth, mHeight);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Log.e(TAG, "onDraw");
        float textSize = yValueToPx(5);
        float strokeWidth = 3;
        cityWidth = ismedium ? textSize * 3.1f : xValueToPx(7.5f);
        cityHeight = ismedium ? textSize * 1.2f : yValueToPx(7.5f);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setTextSize(textSize);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawColor(ActivityCompat.getColor(context, R.color.blue));
        if (mCityList.size() > 0) {

            for (int i = 0; i < mCityList.size(); i++) {
                City city = mCityList.get(i);
                float x = xValueToPx(city.getX());
                float y = yValueToPx(city.getY());

                mPaint.setColor(ActivityCompat.getColor(context, R.color.colorAccent));
                mPaint.setStyle(Paint.Style.STROKE);

                for (int j = i; j < mCityList.size(); j++) {
                    City cityj = mCityList.get(j);
                    if (city.getCango().contains("," + cityj.getName() + ",")) {
                        float xj = xValueToPx(cityj.getX());
                        float yj = yValueToPx(cityj.getY());
                        canvas.drawLine(x, y, xj, yj, mPaint);//画线
                    }
                }

                mPaint.setColor(ActivityCompat.getColor(context, R.color.white));
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawRect(x - cityWidth / 2, y - cityHeight / 2, x + cityWidth / 2, y + cityHeight / 2, mPaint);//画边框背景

                mPaint.setColor(ActivityCompat.getColor(context, R.color.colorAccent));
                mPaint.setStyle(Paint.Style.STROKE);
                canvas.drawRect(x - cityWidth / 2, y - cityHeight / 2, x + cityWidth / 2, y + cityHeight / 2, mPaint);//画边框

                if (city.isReal()) {
                    mPaint.setColor(ActivityCompat.getColor(context, R.color.blue));
                } else {
                    mPaint.setColor(ActivityCompat.getColor(context, R.color.colorAccent));

                }

                mPaint.setStyle(Paint.Style.FILL);
                float bei = isIsmedium() ? 7f / 24f : 1f / 4f;
                canvas.drawText(city.getName(), x, y + cityHeight * bei, mPaint);//画字

            }

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ex = event.getX();
        float ey = event.getY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
//                lastX = event.getX();
//                lastY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                for (City city : mCityList) {
                    float cxs = xValueToPx(city.getX()) - cityWidth / 2;
                    float cxb = xValueToPx(city.getX()) + cityWidth / 2;
                    float cys = yValueToPx(city.getY()) - cityHeight / 2;
                    float cyb = yValueToPx(city.getY()) + cityHeight / 2;
                    if (ex > cxs && ex < cxb && ey > cys && ey < cyb) {
                        onClickCityListener.onClickCityListener(city);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
//                float dx = ex - lastX;
//                float dy = ey - lastY;
//                float left, top, right, bottom;
//                left = getLeft() + dx;
//                top = getTop() + dy;
//                right = left + mWidth;
//                bottom = top + mHeight;
//                if (dx > 0) {//view向右
//                    left = left < 0 ? left : 0;
//                    right = left + mWidth;
//                } else {
//                    right = right < widthSize ? widthSize : right;
//                    left = right - mWidth;
//                }
//                if (dy > 0) {//view向上
//                    top = top < 0 ? top : 0;
//                    bottom = top + mHeight;
//                } else {
//                    bottom = bottom < heightSize ? heightSize : bottom;
//                    top = bottom - mHeight;
//                }
//                layout((int) left, (int) top, (int) right, (int) bottom);
                break;
        }
        return true;
    }

    private float xValueToPx(float value) {
        return mWidth * value / 100;
    }

    private float yValueToPx(float value) {
        return mHeight * value / 100;
    }

}
