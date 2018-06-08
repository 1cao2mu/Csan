package com.cyy.csan.dbtool;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 建一个SQLite帮助类
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    //数据库的名称
    private static String NAME = "csan.db";
    //数据库的版本
    private static int VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("==onCreate==", "数据库创建");
        db.execSQL("create table city(id integer primary key autoincrement,name text,x REAL,y REAL,cango text)");
        db.execSQL("insert into city VALUES (0,'凉州',15,15,'并州,司隶,益州')");
        db.execSQL("insert into city VALUES (1,'益州',15,65,'凉州,司隶,荆州,交州')");
        db.execSQL("insert into city VALUES (2,'司隶',40,40,'凉州,益州,并州,冀州,兖州,豫州,荆州')");
        db.execSQL("insert into city VALUES (3,'荆州',40,65,'益州,司隶,豫州,扬州,交州')");
        db.execSQL("insert into city VALUES (4,'并州',52.5,20,'凉州,司隶,幽州,冀州')");
        db.execSQL("insert into city VALUES (5,'幽州',72.5,10,'冀州,并州')");
        db.execSQL("insert into city VALUES (6,'冀州',65,25,'司隶,并州,幽州,青州,兖州')");
        db.execSQL("insert into city VALUES (7,'青州',80,32.5,'兖州,冀州,徐州')");
        db.execSQL("insert into city VALUES (8,'徐州',77.5,45,'青州,兖州,豫州,扬州')");
        db.execSQL("insert into city VALUES (9,'扬州',67.5,62.5,'交州,徐州,荆州,豫州')");
        db.execSQL("insert into city VALUES (10,'交州',57.5,80,'荆州,扬州,益州')");
        db.execSQL("insert into city VALUES (11,'兖州',60,40,'司隶,冀州,青州,徐州,豫州')");
        db.execSQL("insert into city VALUES (12,'豫州',60,52.5,'兖州,扬州,徐州,荆州,司隶')");

    }


    /**
     * 数据库版本发生改变时调用  newVersion>oldVersion  数据库版本升级
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            Log.i("==onUpgrade==", "数据库版本升级");
        }
    }

    /**
     * 数据库版本发生改变时调用   newVersion<oldVersion 数据库版本降级
     * <p/>
     * 只有发生重大错误时才调用此方法
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        if (newVersion < oldVersion) {
            Log.i("==onDowngrade==", "数据库版本降级");
        }
    }

    /**
     * 每次打开数据库时调用的方法   主要是验证数据库打没打开
     */
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.i("==onOpen==", "数据库打开");
    }

}
