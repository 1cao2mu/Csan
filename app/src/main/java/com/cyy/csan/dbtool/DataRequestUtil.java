package com.cyy.csan.dbtool;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cyy.csan.bean.City;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据获取类
 * Created by cyy
 * on 18-6-7.
 */
public class DataRequestUtil {
    private Context context;


    public DataRequestUtil(Context context) {
        this.context = context;
    }

    public SQLiteDatabase getDB() {
        return new MySQLiteHelper(context).getReadableDatabase();
    }

    public List<City> getBigCityData() {
        List<City> list = new ArrayList<>();
        SQLiteDatabase db = getDB();
        Cursor cursor = db.query("bigcity", null, null, null, null, null, "bid desc");
        while (cursor.moveToNext()) {
            City city = new City();
            city.setBid(cursor.getInt(cursor.getColumnIndex("bid")));
            city.setName(cursor.getString(cursor.getColumnIndex("name")));
            city.setX(cursor.getFloat(cursor.getColumnIndex("x")));
            city.setY(cursor.getFloat(cursor.getColumnIndex("y")));
            city.setCango(cursor.getString(cursor.getColumnIndex("cango")));
            list.add(city);
        }
        cursor.close();
        db.close();
        return list;
    }

    public List<City> getMediumCityData(int bid) {
        List<City> list = new ArrayList<>();
        SQLiteDatabase db = getDB();
        String selection = null;
        String[] selectionArgs = null;
        if (bid != -1) {
            selection = "bid=?";
            selectionArgs = new String[]{String.valueOf(bid)};
        }
        Cursor cursor = db.query("mediumcity", null, selection, selectionArgs, null, null, "mid desc");
        while (cursor.moveToNext()) {
            City city = new City();
            city.setBid(cursor.getInt(cursor.getColumnIndex("bid")));
            city.setMid(cursor.getInt(cursor.getColumnIndex("mid")));
            city.setRealbid(cursor.getInt(cursor.getColumnIndex("realbid")));
            city.setName(cursor.getString(cursor.getColumnIndex("name")));
            city.setX(cursor.getFloat(cursor.getColumnIndex("x")));
            city.setY(cursor.getFloat(cursor.getColumnIndex("y")));
            city.setCango(cursor.getString(cursor.getColumnIndex("cango")));
            list.add(city);
        }
        cursor.close();
        db.close();
        return list;
    }

    public List<City> getMediumCityData() {
        return getMediumCityData(-1);
    }


//    Cursor cursor = db.rawQuery("SELECT bigcity.x as bix ,bigcity.y as biy, mediumcity.x as mx ,mediumcity.y as my,mediumcity.name,mediumcity.cango FROM bigcity INNER JOIN mediumcity ON bigcity.bid=mediumcity.bid", new String[]{});

}
