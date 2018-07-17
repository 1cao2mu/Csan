package com.cyy.csan.bean;

/**
 * 军队
 * Created by cyy
 * on 18-7-5.
 */
public class Army extends Bean {
    public int x=-1, y=-1;
    public General mGeneral;
    public int number;

    public Army(General general) {
        mGeneral = general;
    }

    public General getGeneral() {
        return mGeneral;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setGeneral(General general) {
        mGeneral = general;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
