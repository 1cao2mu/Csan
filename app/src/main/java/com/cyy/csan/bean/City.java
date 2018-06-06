package com.cyy.csan.bean;

/**
 * Created by cyy
 * on 18-6-6下午3:32
 */

public class City {
    private String name;
    private float x, y;

    public City(String name, float x, float y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
