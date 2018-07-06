package com.cyy.csan.bean;

/**
 * 将领类
 * Created by cyy
 * on 18-7-5.
 */
public class General extends Bean{
    private int military,politics,experience,gid;
    private String name;

    public General(String name,int military, int politics,  int experience) {
        this.name = name;
        this.military = military;
        this.politics = politics;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMilitary() {
        return military;
    }

    public void setMilitary(int military) {
        this.military = military;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPolitics() {
        return politics;
    }

    public void setPolitics(int politics) {
        this.politics = politics;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
}
