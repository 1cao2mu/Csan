package com.cyy.csan.bean;

import java.util.ArrayList;

/**
 * 校尉
 * Created by cyy
 * on 18-7-5.
 */
public class MiddleArmy extends Army {
    private int maid;
    private ArrayList<SmallArmy> mSmallArmyArrayList;

    public MiddleArmy(General general) {
        super(general);
    }

    public MiddleArmy(General general, ArrayList<SmallArmy> mSmallArmyArrayList) {
        super(general);
        this.mSmallArmyArrayList = mSmallArmyArrayList;
    }

    public ArrayList<SmallArmy> getSmallArmyArrayList() {
        return mSmallArmyArrayList;
    }

    public void setSmallArmyArrayList(ArrayList<SmallArmy> smallArmyArrayList) {
        mSmallArmyArrayList = smallArmyArrayList;
    }

    public int getMaid() {
        return maid;
    }

    public void setMaid(int maid) {
        this.maid = maid;
    }
}
