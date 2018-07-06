package com.cyy.csan.bean;

/**
 * 军队
 * Created by cyy
 * on 18-7-5.
 */
public class Army extends Bean {
    public General mGeneral;
    public int number;

    public Army(General general) {
        mGeneral = general;
    }

    public General getGeneral() {
        return mGeneral;
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
