package com.cyy.csan.bean;

/**
 * 军司马
 * Created by cyy
 * on 18-7-5.
 */
public class SmallArmy extends Army {
    private int type;
    private int said;

    public SmallArmy(General general, int number) {
        super(general);
        this.number=number;
    }

    public SmallArmy(General general, int number,int type) {
        super(general);
        this.number=number;
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSaid() {
        return said;
    }

    public void setSaid(int said) {
        this.said = said;
    }
}
