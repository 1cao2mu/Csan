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
    private int mWidth, mHeight;
    private boolean ismedium = false;
    private String TAG = "StrategyMapView";
    private OnClickCityListener onClickCityListener;
    private float cityWidth, cityHeight;

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
        } else if (widthMode == MeasureSpec.AT_MOST) {
            throw new IllegalArgumentException("width must be EXACTLY,you should set like android:width=\"200dp\"");
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
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
        float strokeWidth = 3f;
        cityWidth = ismedium ? textSize * 3.1f : xValueToPx(7.5f);
        cityHeight = yValueToPx(7.5f);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setTextSize(textSize);
        mPaint.setTextAlign(Paint.Align.CENTER);
//        canvas.drawColor(ActivityCompat.getColor(context, R.color.white));
        if (mCityList.size() > 0) {

            for (int i = 0; i < mCityList.size(); i++) {
                City city = mCityList.get(i);
                float x = xValueToPx(city.getX());
                float y = yValueToPx(city.getY());

                mPaint.setColor(ActivityCompat.getColor(context, R.color.colorAccent));
                mPaint.setStyle(Paint.Style.STROKE);

                for (int j = i; j < mCityList.size(); j++) {
                    City cityj = mCityList.get(j);
                    if (city.getCango().contains(cityj.getName())) {
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

                mPaint.setColor(ActivityCompat.getColor(context, R.color.colorAccent));
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(city.getName(), x, y + cityHeight * 1 / 4, mPaint);//画字

            }

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                float ex = event.getX();
                float ey = event.getY();
                for (City city : mCityList) {
                    float cxs = xValueToPx(city.getX()) - cityWidth / 2;
                    float cxb = xValueToPx(city.getX()) + cityWidth / 2;
                    float cys = yValueToPx(city.getY()) - cityHeight / 2;
                    float cyb = yValueToPx(city.getY()) + cityHeight / 2;
                    if (ex > cxs && ex < cxb && ey > cys && ey < cyb) {
                        onClickCityListener.onClickCityListener(city);
                    }
                }
                return true;
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
