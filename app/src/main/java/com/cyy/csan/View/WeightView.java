package com.cyy.csan.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cyy.csan.R;
import com.cyy.csan.bean.WeightBg;

import java.util.ArrayList;

/**
 * Created by cyy
 * on 18-6-6下午3:32
 */

public class WeightView extends FrameLayout {
    private String text = "某地";
    private TextView tv_name;
    private LinearLayout ll_bg;
    private ArrayList<WeightBg> weightBgs=new ArrayList<>();

    public WeightView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.include_weight, this);
        tv_name= findViewById(R.id.tv_name);
        ll_bg= findViewById(R.id.ll_bg);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.WeightView);
        this.text = mTypedArray.getString(R.styleable.WeightView_text);
        mTypedArray.recycle();
        tv_name.setText(text);
        tv_name.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ll_bg.removeAllViews();
        weightBgs.clear();
        weightBgs.add(new WeightBg(Color.parseColor("#ff0000"),20f));
        weightBgs.add(new WeightBg(Color.parseColor("#00ff00"),20f));
        weightBgs.add(new WeightBg(Color.parseColor("#0000ff"),20f));
        ll_bg.setWeightSum(100f);
        for (WeightBg weightBg1 : weightBgs) {
            View view=new View(context);
            view.setBackgroundColor(weightBg1.getColor());
            view.setLayoutParams(new LinearLayout.LayoutParams(0,LayoutParams.MATCH_PARENT,weightBg1.getNum()));
            ll_bg.addView(view);
        }
    }
}
