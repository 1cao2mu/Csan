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
        db.execSQL("create table bigcity(bid integer primary key autoincrement,name text,x REAL,y REAL,cango text)");
        //河东郡，河内郡，河南尹，弘农郡，京兆尹，左冯翊，右扶风
        db.execSQL("create table mediumcity(mid integer primary key autoincrement,bid integer,name text,x REAL,y REAL,cango text)");
        db.execSQL("insert into bigcity VALUES (0,'司隶',44,44,'凉州,益州,并州,冀州,兖州,豫州,荆州')");
        db.execSQL("insert into mediumcity VALUES (0,0,'右扶风',20,50,'左冯翊,京兆尹')");
        db.execSQL("insert into mediumcity VALUES (1,0,'左冯翊',40,35,'右扶风,京兆尹,弘农郡,河东郡,北地郡')");
        db.execSQL("insert into mediumcity VALUES (2,0,'河东郡',60,35,'左冯翊,弘农郡,河南尹,河内郡')");
        db.execSQL("insert into mediumcity VALUES (3,0,'弘农郡',60,65,'京兆尹,左冯翊,河东郡,河南尹')");
        db.execSQL("insert into mediumcity VALUES (4,0,'河南尹',80,65,'河内郡,河东郡,弘农郡')");
        db.execSQL("insert into mediumcity VALUES (5,0,'河内郡',80,35,'河南尹,河东郡')");
        db.execSQL("insert into mediumcity VALUES (6,0,'京兆尹',40,65,'左冯翊,右扶风,弘农郡')");

        //平原郡、东莱郡、济南国、乐安国、北海国、齐国。
        db.execSQL("insert into bigcity VALUES (1,'青州',84,36.5,'兖州,冀州,徐州')");
        db.execSQL("insert into mediumcity VALUES (7,1,'平原郡',20,35,'济南国,乐安国')");
        db.execSQL("insert into mediumcity VALUES (8,1,'东莱郡',80,50,'北海国')");
        db.execSQL("insert into mediumcity VALUES (9,1,'济南国',20,65,'齐国,乐安国,平原郡')");
        db.execSQL("insert into mediumcity VALUES (10,1,'乐安国',40,35,'平原郡,济南国,北海国,齐国')");
        db.execSQL("insert into mediumcity VALUES (11,1,'北海国',60,50,'齐国,乐安国,东莱郡')");
        db.execSQL("insert into mediumcity VALUES (12,1,'齐国',40,65,'北海国,乐安国,济南国')");

        //琅琊国，东海国，彭城国，下邳国，广陵郡。
        db.execSQL("insert into bigcity VALUES (2,'徐州',81.5,49,'青州,兖州,豫州,扬州')");
        db.execSQL("insert into mediumcity VALUES (13,2,'琅琊国',50,35,'东海国')");
        db.execSQL("insert into mediumcity VALUES (14,2,'东海国',50,50,'彭城国,下邳国,广陵郡,琅琊国')");
        db.execSQL("insert into mediumcity VALUES (15,2,'彭城国',35,65,'下邳国,东海国')");
        db.execSQL("insert into mediumcity VALUES (16,2,'下邳国',50,65,'彭城国,东海国,广陵郡')");
        db.execSQL("insert into mediumcity VALUES (17,2,'广陵郡',65,65,'下邳国,东海国')");

        //陈留郡，东郡，济阴郡，山阳郡，任城郡，东平国，济北国，泰山郡
        db.execSQL("insert into bigcity VALUES (3,'兖州',64,44,'司隶,冀州,青州,徐州,豫州')");
        db.execSQL("insert into mediumcity VALUES (18,3,'陈留郡',20,65,'东郡,济阴郡')");
        db.execSQL("insert into mediumcity VALUES (19,3,'济阴郡',40,50,'陈留郡,东郡,东平国,山阳郡')");
        db.execSQL("insert into mediumcity VALUES (20,3,'山阳郡',53,65,'济阴郡,东平国,任城郡')");
        db.execSQL("insert into mediumcity VALUES (21,3,'任城郡',66,55,'东平国,山阳郡')");
        db.execSQL("insert into mediumcity VALUES (22,3,'东平国',53,45,'济北国,东郡,济阴郡,任城郡,山阳郡')");
        db.execSQL("insert into mediumcity VALUES (23,3,'东郡',40,35,'济北国,济阴郡,陈留郡,东平国')");
        db.execSQL("insert into mediumcity VALUES (24,3,'泰山郡',80,50,'济北国')");
        db.execSQL("insert into mediumcity VALUES (25,3,'济北国',66,35,'东平国,东郡,泰山郡')");

        //颍川郡，汝南郡，陈国，梁国，沛国,鲁国。
        db.execSQL("insert into bigcity VALUES (4,'豫州',64,56.5,'兖州,扬州,徐州,荆州,司隶')");
        db.execSQL("insert into mediumcity VALUES (26,4,'颍川郡',30,35,'陈国,汝南郡')");
        db.execSQL("insert into mediumcity VALUES (27,4,'汝南郡',50,65,'陈国,颍川郡,沛国')");
        db.execSQL("insert into mediumcity VALUES (28,4,'陈国',50,35,'颍川郡,汝南郡,梁国,沛国')");
        db.execSQL("insert into mediumcity VALUES (29,4,'梁国',60,25,'陈国,沛国')");
        db.execSQL("insert into mediumcity VALUES (30,4,'沛国',70,35,'陈国,梁国,鲁国,汝南郡')");
        db.execSQL("insert into mediumcity VALUES (31,4,'鲁国',75,20,'沛国')");

        //代郡，上谷郡，涿郡，广阳郡，渔阳郡，右北平，辽西郡，辽东属，辽东郡，玄菟郡，乐浪郡。
        db.execSQL("insert into bigcity VALUES (5,'幽州',76.5,14,'冀州,并州')");
        db.execSQL("insert into mediumcity VALUES (32,5,'代郡',12.5,50,'上谷郡')");
        db.execSQL("insert into mediumcity VALUES (33,5,'上谷郡',25,50,'涿郡,广阳郡,渔阳郡,代郡')");
        db.execSQL("insert into mediumcity VALUES (34,5,'涿郡',17.75,65,'上谷郡,广阳郡')");
        db.execSQL("insert into mediumcity VALUES (35,5,'广阳郡',31.25,60,'上谷郡,涿郡,渔阳郡')");
        db.execSQL("insert into mediumcity VALUES (36,5,'渔阳郡',37.5,50,'广阳郡,上谷郡,右北平')");
        db.execSQL("insert into mediumcity VALUES (37,5,'右北平',50,50,'渔阳郡,辽东属,辽西郡')");
        db.execSQL("insert into mediumcity VALUES (38,5,'辽西郡',56.25,60,'右北平,辽东属')");
        db.execSQL("insert into mediumcity VALUES (39,5,'辽东属',62.5,40,'辽西郡,辽东郡,右北平,玄菟郡')");
        db.execSQL("insert into mediumcity VALUES (40,5,'辽东郡',75,50,'辽东属,玄菟郡,乐浪郡')");
        db.execSQL("insert into mediumcity VALUES (41,5,'玄菟郡',75,35,'辽东属,辽东郡')");
        db.execSQL("insert into mediumcity VALUES (42,5,'乐浪郡',87.5,65,'辽东郡')");

        //中山国，常山郡，河间郡，渤海国，安平国，清河郡，魏郡，赵国，巨鹿郡
        db.execSQL("insert into bigcity VALUES (6,'冀州',69,29,'司隶,并州,幽州,青州,兖州')");
        db.execSQL("insert into mediumcity VALUES (43,6,'中山国',40,25,'常山郡,巨鹿郡,安平国,河间郡')");
        db.execSQL("insert into mediumcity VALUES (44,6,'常山郡',20,25,'中山国,赵国,巨鹿郡')");
        db.execSQL("insert into mediumcity VALUES (45,6,'河间郡',60,25,'渤海国,安平国,中山国')");
        db.execSQL("insert into mediumcity VALUES (46,6,'渤海国',80,25,'河间郡,安平国,清河郡')");
        db.execSQL("insert into mediumcity VALUES (47,6,'安平国',50,37.5,'中山国,巨鹿郡,河间郡,清河郡,渤海国')");
        db.execSQL("insert into mediumcity VALUES (48,6,'清河郡',60,50,'魏郡,巨鹿郡,安平国,渤海国')");
        db.execSQL("insert into mediumcity VALUES (49,6,'魏郡',30,75,'赵国,巨鹿郡,清河郡')");
        db.execSQL("insert into mediumcity VALUES (50,6,'赵国',20,50,'常山郡,巨鹿郡,魏郡')");
        db.execSQL("insert into mediumcity VALUES (51,6,'巨鹿郡',40,50,'常山郡,中山国,安平国,清河郡,赵国,魏郡')");

        //太原郡、上党郡、西河郡、云中郡、定襄郡、雁门郡、朔方郡、五原郡、上郡。
        db.execSQL("insert into bigcity VALUES (7,'并州',56.5,24,'凉州,司隶,幽州,冀州')");
        db.execSQL("insert into mediumcity VALUES (52,7,'太原郡',80,50,'西河郡,雁门郡,上党郡')");
        db.execSQL("insert into mediumcity VALUES (53,7,'上党郡',80,75,'太原郡')");
        db.execSQL("insert into mediumcity VALUES (54,7,'西河郡',50,50,'上郡,太原郡,雁门郡,五原郡,朔方郡')");
        db.execSQL("insert into mediumcity VALUES (55,7,'云中郡',60,25,'五原郡,雁门郡,定襄郡')");
        db.execSQL("insert into mediumcity VALUES (56,7,'定襄郡',55,37.5,'云中郡,五原郡,雁门郡')");
        db.execSQL("insert into mediumcity VALUES (57,7,'雁门郡',80,25,'太原郡,云中郡,西河郡,定襄郡')");
        db.execSQL("insert into mediumcity VALUES (58,7,'朔方郡',20,25,'上郡,五原郡,西河郡')");
        db.execSQL("insert into mediumcity VALUES (59,7,'五原郡',40,25,'朔方郡,西河郡,定襄郡,云中郡')");
        db.execSQL("insert into mediumcity VALUES (60,7,'上郡',20,50,'西河郡,朔方郡')");

        //南阳郡，江夏郡，南郡，武陵郡，长沙郡，零陵郡，桂阳郡
        db.execSQL("insert into bigcity VALUES (8,'荆州',44,69,'益州,司隶,豫州,扬州,交州')");
        db.execSQL("insert into mediumcity VALUES (61,8,'南阳郡',50,20,'南郡,江夏郡')");
        db.execSQL("insert into mediumcity VALUES (62,8,'江夏郡',75,40,'南阳郡,南郡,长沙郡')");
        db.execSQL("insert into mediumcity VALUES (63,8,'南郡',25,40,'南阳郡,江夏郡,长沙郡,武陵郡')");
        db.execSQL("insert into mediumcity VALUES (64,8,'武陵郡',25,60,'南郡,长沙郡,零陵郡')");
        db.execSQL("insert into mediumcity VALUES (65,8,'长沙郡',75,60,'零陵郡,桂阳郡,武陵郡,南郡,江夏郡')");
        db.execSQL("insert into mediumcity VALUES (66,8,'零陵郡',25,80,'长沙郡,武陵郡,桂阳郡')");
        db.execSQL("insert into mediumcity VALUES (67,8,'桂阳郡',75,80,'零陵郡,长沙郡')");

        //九江郡 丹阳郡 庐江郡 会稽郡 豫章郡 吴郡
        db.execSQL("insert into bigcity VALUES (9,'扬州',71.5,66.5,'交州,徐州,荆州,豫州')");
        db.execSQL("insert into mediumcity VALUES (68,9,'九江郡',37.5,25,'庐江郡,丹阳郡')");
        db.execSQL("insert into mediumcity VALUES (69,9,'丹阳郡',50,50,'九江郡,庐江郡,会稽郡,豫章郡,吴郡')");
        db.execSQL("insert into mediumcity VALUES (70,9,'庐江郡',25,50,'丹阳郡,九江郡,豫章郡')");
        db.execSQL("insert into mediumcity VALUES (71,9,'会稽郡',62.5,75,'丹阳郡,吴郡,豫章郡')");
        db.execSQL("insert into mediumcity VALUES (72,9,'豫章郡',37.5,75,'丹阳郡,会稽郡,庐江郡')");
        db.execSQL("insert into mediumcity VALUES (73,9,'吴郡',75,50,'丹阳郡,会稽郡')");

        //武都郡，陇西郡，汉阳郡，安定郡，北地郡，武威郡，金城郡，张掖郡,张掖属,酒泉郡，敦煌郡
        db.execSQL("insert into bigcity VALUES (10,'凉州',19,19,'并州,司隶,益州')");
        db.execSQL("insert into mediumcity VALUES (74,10,'武都郡',66,84,'陇西郡,汉阳郡')");
        db.execSQL("insert into mediumcity VALUES (75,10,'陇西郡',58,70,'金城郡,汉阳郡,武都郡')");
        db.execSQL("insert into mediumcity VALUES (76,10,'汉阳郡',74,70,'陇西郡,武都郡,安定郡')");
        db.execSQL("insert into mediumcity VALUES (77,10,'安定郡',74,56,'武威郡,北地郡,汉阳郡')");
        db.execSQL("insert into mediumcity VALUES (78,10,'北地郡',82,42,'武威郡,安定郡')");
        db.execSQL("insert into mediumcity VALUES (79,10,'武威郡',66,42,'北地郡,安定郡,金城郡,张掖郡')");
        db.execSQL("insert into mediumcity VALUES (80,10,'金城郡',58,56,'武威郡,陇西郡')");
        db.execSQL("insert into mediumcity VALUES (81,10,'张掖郡',50,28,'张掖属,武威郡,酒泉郡')");
        db.execSQL("insert into mediumcity VALUES (82,10,'张掖属',41,14,'酒泉郡,敦煌郡,张掖郡')");
        db.execSQL("insert into mediumcity VALUES (83,10,'酒泉郡',32,28,'张掖属,敦煌郡,张掖郡')");
        db.execSQL("insert into mediumcity VALUES (84,10,'敦煌郡',16,28,'张掖属,酒泉郡')");

        //汉中郡，巴郡，广汉郡，广汉属，蜀郡，蜀郡属，犍为郡，犍为属，牂牁郡，越巂郡，益州郡，永昌郡
        db.execSQL("insert into bigcity VALUES (11,'益州',19,69,'凉州,司隶,荆州,交州')");
        db.execSQL("insert into mediumcity VALUES (85,11,'汉中郡',75,18,'广汉郡,巴郡')");
        db.execSQL("insert into mediumcity VALUES (86,11,'巴郡',75,36,'汉中郡,广汉郡,犍为郡')");
        db.execSQL("insert into mediumcity VALUES (87,11,'广汉郡',50,36,'广汉属,巴郡,汉中郡,蜀郡,犍为郡')");
        db.execSQL("insert into mediumcity VALUES (88,11,'广汉属',37.5,18,'蜀郡,广汉郡')");
        db.execSQL("insert into mediumcity VALUES (89,11,'蜀郡',25,36,'广汉郡,广汉属,蜀郡属,犍为郡')");
        db.execSQL("insert into mediumcity VALUES (90,11,'蜀郡属',25,50,'蜀郡,犍为郡,越巂郡')");
        db.execSQL("insert into mediumcity VALUES (91,11,'犍为郡',50,50,'巴郡,广汉郡,蜀郡,蜀郡属,犍为属,牂牁郡,越巂郡')");
        db.execSQL("insert into mediumcity VALUES (92,11,'犍为属',50,66,'犍为郡,越巂郡,益州郡,牂牁郡')");
        db.execSQL("insert into mediumcity VALUES (93,11,'牂牁郡',75,66,'犍为郡,犍为属,益州郡,永昌郡')");
        db.execSQL("insert into mediumcity VALUES (94,11,'越巂郡',25,66,'犍为郡,犍为属,蜀郡属,益州郡,永昌郡')");
        db.execSQL("insert into mediumcity VALUES (95,11,'益州郡',37.5,75,'犍为属,牂牁郡,越巂郡,永昌郡')");
        db.execSQL("insert into mediumcity VALUES (96,11,'永昌郡',25,84,'越巂郡,益州郡,牂牁郡')");

        //南海郡，郁林郡，苍梧郡，合浦郡，交趾郡，九真郡,日南郡
        db.execSQL("insert into bigcity VALUES (12,'交州',61.5,84,'荆州,扬州,益州')");
        db.execSQL("insert into mediumcity VALUES (97,12,'南海郡',80,20,'苍梧郡,合浦郡')");
        db.execSQL("insert into mediumcity VALUES (98,12,'郁林郡',40,20,'交趾郡,合浦郡,苍梧郡')");
        db.execSQL("insert into mediumcity VALUES (99,12,'苍梧郡',60,20,'南海郡,郁林郡,合浦郡')");
        db.execSQL("insert into mediumcity VALUES (100,12,'合浦郡',50,40,'交趾郡,苍梧郡,郁林郡,南海郡')");
        db.execSQL("insert into mediumcity VALUES (101,12,'交趾郡',20,40,'郁林郡,合浦郡,九真郡')");
        db.execSQL("insert into mediumcity VALUES (102,12,'九真郡',20,60,'交趾郡,日南郡')");
        db.execSQL("insert into mediumcity VALUES (103,12,'日南郡',20,80,'九真郡')");

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
