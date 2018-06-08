package com.cyy.csan.dbtool;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cyy.csan.bean.City;

import java.util.ArrayList;
import java.util.List;

/**
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

    public List<City> getCityData() {
        List<City> list = new ArrayList<>();
        SQLiteDatabase db = getDB();
        Cursor cursor = db.query("city", null, null, null, null, null, "id desc");
        while (cursor.moveToNext()) {
            City city = new City();
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

}
