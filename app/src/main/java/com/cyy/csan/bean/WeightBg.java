package com.cyy.csan.bean;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ygg
 * on 2017/7/13.
 */

public class WeightBg implements Parcelable {
    private Color color;
    private int num;


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(num);
    }

    private WeightBg(Parcel in) {
        num = in.readInt();
    }

    public static final Creator<WeightBg> CREATOR = new Creator<WeightBg>() {
        @Override
        public WeightBg createFromParcel(Parcel in) {
            return new WeightBg(in);
        }

        @Override
        public WeightBg[] newArray(int size) {
            return new WeightBg[size];
        }
    };
}
