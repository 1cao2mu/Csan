package com.cyy.csan.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.cyy.csan.R;
import com.cyy.csan.bean.BigArmy;
import com.cyy.csan.bean.General;
import com.cyy.csan.bean.MiddleArmy;
import com.cyy.csan.listener.OnClickBeanListener;

import java.util.ArrayList;


/**
 * 战役地图
 * Created by cyy
 * on 18-6-6.
 */
public class CampaignMapView extends View {
    private BigArmy selfBigArmy;
    private BigArmy otherBigArmy;
    private Paint mPaint;
    private Context context;
    private int mWidth, mHeight;
    private String TAG = "CampaignMapView";
    private OnClickBeanListener mOnClickBeanListener;
    private boolean isIng = false;
    private int delayMillis = 1500;
    private int[] range = {5, 6, 4, 7, 3, 8, 2, 9, 1, 10};

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            ArrayList<MiddleArmy> middleArmylist1 = selfBigArmy.getMiddleArmyArrayList();
            for (int i = 0; i < middleArmylist1.size(); i++) {
                MiddleArmy middleArmy1 = middleArmylist1.get(i);
                middleArmy1.setX(middleArmy1.getX() + 1);
            }
            ArrayList<MiddleArmy> middleArmylist2 = otherBigArmy.getMiddleArmyArrayList();
            for (int i = 0; i < middleArmylist2.size(); i++) {
                MiddleArmy middleArmy1 = middleArmylist2.get(i);
                middleArmy1.setX(middleArmy1.getX() - 1);
            }
            invalidate();
            handler.postDelayed(this, delayMillis);
        }
    };


    public boolean isIng() {
        return isIng;
    }

    public void setIng(boolean ing) {
        isIng = ing;
        if (isIng) {
            handler.postDelayed(runnable, delayMillis);
        } else {
            handler.removeCallbacks(runnable);
        }
    }

    public void setArmy(BigArmy selfBigArmy, BigArmy otherBigArmy) {
        ArrayList<MiddleArmy> middleArmylist1= selfBigArmy.getMiddleArmyArrayList();
        for (int i = 0; i < middleArmylist1.size(); i++) {
            MiddleArmy middleArmy = middleArmylist1.get(i);
            middleArmy.setXY(1,range[i]);
        }
        ArrayList<MiddleArmy> middleArmylist2= otherBigArmy.getMiddleArmyArrayList();
        for (int i = 0; i < middleArmylist2.size(); i++) {
            MiddleArmy middleArmy = middleArmylist2.get(i);
            middleArmy.setXY(10,range[i]);
        }
        this.selfBigArmy = selfBigArmy;
        this.otherBigArmy = otherBigArmy;
        invalidate();
    }

    public CampaignMapView(Context context) {
        super(context);
        initData(context);
    }

    public CampaignMapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    private void initData(Context context) {
        mPaint = new Paint();
        this.context = context;
        setLayerType(View.LAYER_TYPE_SOFTWARE, mPaint);
    }

    public void setOnClickBeanListener(OnClickBeanListener onClickBeanListener) {
        mOnClickBeanListener = onClickBeanListener;
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
        setMeasuredDimension(mWidth, mHeight);
    }


    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        Log.e(TAG, "onDraw");
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setAntiAlias(true);
        mPaint.setColor(ActivityCompat.getColor(context, R.color.colorAccent));
        mPaint.setPathEffect(new DashPathEffect(new float[]{4f, 4f}, 0));
        //画虚线
        for (int i = 0; i < 11; i++) {
            mPaint.setStrokeWidth(i == 0 || i == 10 ? 8 : 2);
            canvas.drawLine(xValueToPx(i * 100 / 10f), yValueToPx(0), xValueToPx(i * 100 / 10f), yValueToPx(100), mPaint);
            canvas.drawLine(xValueToPx(0), yValueToPx(i * 100 / 10f), xValueToPx(100), yValueToPx(i * 100 / 10f), mPaint);
        }
        ArrayList<MiddleArmy> selfMiddleArmyArrayList = selfBigArmy.getMiddleArmyArrayList();
        for (MiddleArmy middleArmy : selfMiddleArmyArrayList) {
//            if (middleArmy.getX() == -1) {
//                middleArmy.setXY(1, 5);
//            }
            drawGeneral(middleArmy.getX(), middleArmy.getY(), middleArmy.getGeneral(), canvas, true);

        }
        ArrayList<MiddleArmy> otherMiddleArmyArrayList = otherBigArmy.getMiddleArmyArrayList();
        for (MiddleArmy middleArmy : otherMiddleArmyArrayList) {
//            if (middleArmy.getX() == -1) {
//                middleArmy.setXY(10, 5);
//            }
            drawGeneral(middleArmy.getX(), middleArmy.getY(), middleArmy.getGeneral(), canvas, false);
        }

    }

    private void drawGeneral(int x, int y, General general, Canvas canvas, boolean self) {
        mPaint.setTextSize(yValueToPx(5f));
        if (self) {
            mPaint.setColor(ActivityCompat.getColor(context, R.color.blue));
        } else {
            mPaint.setColor(ActivityCompat.getColor(context, R.color.red));
        }
        mPaint.setStyle(Paint.Style.FILL);
        float fx = xValueToPx((x - 0.5f) * 10f);
        float fy = yValueToPx((y - 0.5f) * 10f);
        float fheight = yValueToPx(10f);
        float fwidth = xValueToPx(10f);
        canvas.drawRect(fx - fwidth / 2, fy - fheight / 2, fx + fwidth / 2, fy + fheight / 2, mPaint);

        mPaint.setColor(ActivityCompat.getColor(context, R.color.white));
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float offset = fontMetrics.top / 2 + fontMetrics.bottom / 2;
        canvas.drawText(general.getName(), fx, fy - offset, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ex = event.getX();
        float ey = event.getY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
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
