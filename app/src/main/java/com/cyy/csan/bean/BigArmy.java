package com.cyy.csan.bean;

import java.util.ArrayList;

/**
 * 军团
 * Created by cyy
 * on 18-7-5.
 */
public class BigArmy extends Army {
    private int baid;
    private ArrayList<MiddleArmy> mMiddleArmyArrayList;

    public BigArmy(General general) {
        super(general);
    }

    public BigArmy(General general, ArrayList<MiddleArmy> mMiddleArmyArrayList) {
        super(general);
        this.mMiddleArmyArrayList = mMiddleArmyArrayList;
    }

    public int getBaid() {
        return baid;
    }

    public void setBaid(int baid) {
        this.baid = baid;
    }

    public ArrayList<MiddleArmy> getMiddleArmyArrayList() {
        return mMiddleArmyArrayList;
    }

    public void setMiddleArmyArrayList(ArrayList<MiddleArmy> middleArmyArrayList) {
        mMiddleArmyArrayList = middleArmyArrayList;
    }
}
