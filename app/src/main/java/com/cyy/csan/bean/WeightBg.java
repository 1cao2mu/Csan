package com.cyy.csan.bean;

/**
 * Created by cyy
 * on 18-6-6下午3:32
 */

public class WeightBg {
    private int color;
    private float num;

    public WeightBg(int color, float num) {
        this.color = color;
        this.num = num;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }
}
