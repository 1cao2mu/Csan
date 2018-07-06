package com.cyy.csan.dbtool;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * SQLite帮助类
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
        db.execSQL("create table mediumcity(mid integer primary key autoincrement,bid integer,name text,x REAL,y REAL,cango text,realbid integer)");

        String sqlinsert = "insert into mediumcity (bid,name,x,y,cango,realbid) values ";

        db.execSQL("insert into bigcity values (0,'司隶',44,44,',凉州,益州,并州,冀州,兖州,豫州,荆州,')");
        db.execSQL("insert into mediumcity  values (0,0,'右扶风',20,50,',左冯翊,京兆尹,武都郡,汉阳郡,安定郡,北地郡,汉中郡,',0)");
        db.execSQL("insert into mediumcity  values (1,0,'左冯翊',37.5,35,',右扶风,京兆尹,弘农郡,河东郡,北地郡,上郡,',0)");
        db.execSQL("insert into mediumcity values (2,0,'河东郡',55,35,',左冯翊,弘农郡,河南尹,河内郡,上郡,西河郡,太原郡,上党郡,',0)");
        db.execSQL("insert into mediumcity values (3,0,'弘农郡',55,65,',京兆尹,左冯翊,河东郡,河南尹,南阳郡,',0)");
        db.execSQL("insert into mediumcity values (4,0,'河南尹',72.5,65,',河内郡,河东郡,弘农郡,陈留郡,颍川郡,南阳郡,',0)");
        db.execSQL("insert into mediumcity values (5,0,'河内郡',72.5,35,',河南尹,河东郡,上党郡,东郡,魏郡,',0)");
        db.execSQL("insert into mediumcity values (6,0,'京兆尹',37.5,65,',左冯翊,右扶风,弘农郡,汉中郡,南阳郡,',0)");

        //平原郡、东莱郡、济南国、乐安国、北海国、齐国。
        db.execSQL("insert into bigcity values (1,'青州',84,36.5,',兖州,冀州,徐州,')");
        db.execSQL("insert into mediumcity values (7,1,'平原郡',20,35,',济南国,乐安国,东郡,济北国,渤海国,清河郡,',1)");
        db.execSQL("insert into mediumcity values (8,1,'东莱郡',80,50,',北海国,琅琊国,',1)");
        db.execSQL("insert into mediumcity values (9,1,'济南国',20,65,',齐国,乐安国,平原郡,泰山郡,',1)");
        db.execSQL("insert into mediumcity values (10,1,'乐安国',40,35,',平原郡,济南国,北海国,齐国,渤海国,',1)");
        db.execSQL("insert into mediumcity values (11,1,'北海国',60,50,',齐国,乐安国,东莱郡,琅琊国,',1)");
        db.execSQL("insert into mediumcity values (12,1,'齐国',40,65,',北海国,乐安国,济南国,琅琊国,泰山郡,',1)");

        //琅琊国，东海国，彭城国，下邳国，广陵郡。
        db.execSQL("insert into bigcity values (2,'徐州',81.5,49,',青州,兖州,豫州,扬州,')");
        db.execSQL("insert into mediumcity values (13,2,'琅琊国',50,35,',东海国,东莱郡,北海国,齐国,泰山郡,',2)");
        db.execSQL("insert into mediumcity values (14,2,'东海国',50,50,',彭城国,下邳国,广陵郡,琅琊国,泰山郡,鲁国,',2)");
        db.execSQL("insert into mediumcity values (15,2,'彭城国',35,65,',下邳国,东海国,沛国,',2)");
        db.execSQL("insert into mediumcity values (16,2,'下邳国',50,65,',彭城国,东海国,广陵郡,沛国,九江郡,',2)");
        db.execSQL("insert into mediumcity values (17,2,'广陵郡',65,65,',下邳国,东海国,丹阳郡,吴郡,',2)");

        //陈留郡，东郡，济阴郡，山阳郡，任城郡，东平国，济北国，泰山郡
        db.execSQL("insert into bigcity values (3,'兖州',64,44,',司隶,冀州,青州,徐州,豫州,')");
        db.execSQL("insert into mediumcity values (18,3,'陈留郡',20,65,',东郡,济阴郡,颍川郡,陈国,梁国,河南尹,',3)");
        db.execSQL("insert into mediumcity values (19,3,'济阴郡',40,50,',陈留郡,东郡,东平国,山阳郡,梁国,沛国,',3)");
        db.execSQL("insert into mediumcity values (20,3,'山阳郡',53,65,',济阴郡,东平国,任城郡,沛国,',3)");
        db.execSQL("insert into mediumcity values (21,3,'任城郡',63,65,',东平国,山阳郡,沛国,鲁国,',3)");
        db.execSQL("insert into mediumcity values (22,3,'东平国',53,45,',济北国,东郡,济阴郡,任城郡,山阳郡,鲁国,',3)");
        db.execSQL("insert into mediumcity values (23,3,'东郡',40,35,',济北国,济阴郡,陈留郡,东平国,魏郡,清河郡,平原郡,河内郡,',3)");
        db.execSQL("insert into mediumcity values (24,3,'泰山郡',80,50,',济北国,济南国,齐国,琅琊国,东海国,鲁国,',3)");
        db.execSQL("insert into mediumcity values (25,3,'济北国',66,35,',东平国,东郡,泰山郡,平原郡,鲁国,',3)");

        //颍川郡，汝南郡，陈国，梁国，沛国,鲁国。
        db.execSQL("insert into bigcity values (4,'豫州',64,56.5,',兖州,扬州,徐州,荆州,司隶,')");
        db.execSQL("insert into mediumcity values (26,4,'颍川郡',30,45,',陈国,汝南郡,南阳郡,河南尹,陈留郡,',4)");
        db.execSQL("insert into mediumcity values (27,4,'汝南郡',40,75,',陈国,颍川郡,沛国,南阳郡,江夏郡,九江郡,庐江郡,',4)");
        db.execSQL("insert into mediumcity values (28,4,'陈国',40,45,',颍川郡,汝南郡,梁国,沛国,陈留郡,',4)");
        db.execSQL("insert into mediumcity values (29,4,'梁国',50,35,',陈国,沛国,陈留郡,济阴郡,',4)");
        db.execSQL("insert into mediumcity values (30,4,'沛国',70,45,',陈国,梁国,鲁国,汝南郡,彭城国,下邳国,济阴郡,山阳郡,任城郡,九江郡,',4)");
        db.execSQL("insert into mediumcity values (31,4,'鲁国',75,30,',沛国,任城郡,泰山郡,东平国,济北国,东海国,',4)");

        //代郡，上谷郡，涿郡，广阳郡，渔阳郡，右北平，辽西郡，辽东属，辽东郡，玄菟郡，乐浪郡。
        db.execSQL("insert into bigcity values (5,'幽州',76.5,14,',冀州,并州,')");
        db.execSQL("insert into mediumcity values (32,5,'代郡',12.5,50,',上谷郡,雁门郡,常山郡,中山国,',5)");
        db.execSQL("insert into mediumcity values (33,5,'上谷郡',25,50,',涿郡,广阳郡,渔阳郡,代郡,',5)");
        db.execSQL("insert into mediumcity values (34,5,'涿郡',18.75,65,',上谷郡,广阳郡,中山国,河间郡,',5)");
        db.execSQL("insert into mediumcity values (35,5,'广阳郡',31.25,60,',上谷郡,涿郡,渔阳郡,河间郡,',5)");
        db.execSQL("insert into mediumcity values (36,5,'渔阳郡',37.5,50,',广阳郡,上谷郡,右北平,渤海国,',5)");
        db.execSQL("insert into mediumcity values (37,5,'右北平',50,50,',渔阳郡,辽东属,辽西郡,',5)");
        db.execSQL("insert into mediumcity values (38,5,'辽西郡',56.25,60,',右北平,辽东属,',5)");
        db.execSQL("insert into mediumcity values (39,5,'辽东属',62.5,40,',辽西郡,辽东郡,右北平,玄菟郡,',5)");
        db.execSQL("insert into mediumcity values (40,5,'辽东郡',75,50,',辽东属,玄菟郡,乐浪郡,',5)");
        db.execSQL("insert into mediumcity values (41,5,'玄菟郡',75,35,',辽东属,辽东郡,',5)");
        db.execSQL("insert into mediumcity values (42,5,'乐浪郡',87.5,65,',辽东郡,',5)");

        //中山国，常山郡，河间郡，渤海国，安平国，清河郡，魏郡，赵国，巨鹿郡
        db.execSQL("insert into bigcity values (6,'冀州',69,29,',司隶,并州,幽州,青州,兖州,')");
        db.execSQL("insert into mediumcity values (43,6,'中山国',40,25,',常山郡,巨鹿郡,安平国,河间郡,代郡,涿郡,',6)");
        db.execSQL("insert into mediumcity values (44,6,'常山郡',20,25,',中山国,赵国,巨鹿郡,代郡,太原郡,',6)");
        db.execSQL("insert into mediumcity values (45,6,'河间郡',60,25,',渤海国,安平国,中山国,广阳郡,涿郡,',6)");
        db.execSQL("insert into mediumcity values (46,6,'渤海国',80,25,',河间郡,安平国,清河郡,乐安国,平原郡,渔阳郡,',6)");
        db.execSQL("insert into mediumcity values (47,6,'安平国',50,37.5,',中山国,巨鹿郡,河间郡,清河郡,渤海国,',6)");
        db.execSQL("insert into mediumcity values (48,6,'清河郡',60,50,',魏郡,巨鹿郡,安平国,渤海国,平原郡,东郡,',6)");
        db.execSQL("insert into mediumcity values (49,6,'魏郡',30,75,',赵国,巨鹿郡,清河郡,河内郡,东郡,上党郡,',6)");
        db.execSQL("insert into mediumcity values (50,6,'赵国',20,50,',常山郡,巨鹿郡,魏郡,上党郡,',6)");
        db.execSQL("insert into mediumcity values (51,6,'巨鹿郡',40,50,',常山郡,中山国,安平国,清河郡,赵国,魏郡,',6)");

        //太原郡、上党郡、西河郡、云中郡、定襄郡、雁门郡、朔方郡、五原郡、上郡。
        db.execSQL("insert into bigcity values (7,'并州',56.5,24,',凉州,司隶,幽州,冀州,')");
        db.execSQL("insert into mediumcity values (52,7,'太原郡',80,50,',西河郡,雁门郡,上党郡,河东郡,常山郡,',7)");
        db.execSQL("insert into mediumcity values (53,7,'上党郡',80,75,',太原郡,河东郡,河内郡,赵国,魏郡,',7)");
        db.execSQL("insert into mediumcity values (54,7,'西河郡',50,50,',上郡,太原郡,雁门郡,五原郡,朔方郡,河东郡,',7)");
        db.execSQL("insert into mediumcity values (55,7,'云中郡',60,25,',五原郡,雁门郡,定襄郡,',7)");
        db.execSQL("insert into mediumcity values (56,7,'定襄郡',55,37.5,',云中郡,五原郡,雁门郡,',7)");
        db.execSQL("insert into mediumcity values (57,7,'雁门郡',80,25,',太原郡,云中郡,西河郡,定襄郡,代郡,',7)");
        db.execSQL("insert into mediumcity values (58,7,'朔方郡',20,25,',上郡,五原郡,西河郡,',7)");
        db.execSQL("insert into mediumcity values (59,7,'五原郡',40,25,',朔方郡,西河郡,定襄郡,云中郡,',7)");
        db.execSQL("insert into mediumcity values (60,7,'上郡',20,50,',西河郡,朔方郡,左冯翊,河东郡,北地郡,',7)");

//        //南阳郡，江夏郡，南郡，武陵郡，长沙郡，零陵郡，桂阳郡
        db.execSQL("insert into bigcity values (8,'荆州',44,69,',益州,司隶,豫州,扬州,交州,')");
        db.execSQL("insert into mediumcity values (61,8,'南阳郡',50,20,',南郡,江夏郡,河南尹,弘农郡,京兆尹,汝南郡,颍川郡,汉中郡,',8)");
        db.execSQL("insert into mediumcity values (62,8,'江夏郡',75,40,',南阳郡,南郡,长沙郡,汝南郡,豫章郡,庐江郡,',8)");
        db.execSQL("insert into mediumcity values (63,8,'南郡',25,40,',南阳郡,江夏郡,长沙郡,武陵郡,汉中郡,巴郡,',8)");
        db.execSQL("insert into mediumcity values (64,8,'武陵郡',25,60,',南郡,长沙郡,零陵郡,犍为郡,巴郡,牂牁郡,郁林郡,',8)");
        db.execSQL("insert into mediumcity values (65,8,'长沙郡',75,60,',零陵郡,桂阳郡,武陵郡,南郡,江夏郡,豫章郡,',8)");
        db.execSQL("insert into mediumcity values (66,8,'零陵郡',50,80,',长沙郡,武陵郡,桂阳郡,苍梧郡,',8)");
        db.execSQL("insert into mediumcity values (67,8,'桂阳郡',75,80,',零陵郡,长沙郡,豫章郡,南海郡,',8)");

        //九江郡 丹阳郡 庐江郡 会稽郡 豫章郡 吴郡
        db.execSQL("insert into bigcity values (9,'扬州',71.5,66.5,',交州,徐州,荆州,豫州,')");
        db.execSQL("insert into mediumcity values (68,9,'九江郡',37.5,25,',庐江郡,丹阳郡,下邳国,',9)");
        db.execSQL("insert into mediumcity values (69,9,'丹阳郡',50,50,',九江郡,庐江郡,会稽郡,豫章郡,吴郡,广陵郡,',9)");
        db.execSQL("insert into mediumcity values (70,9,'庐江郡',25,50,',丹阳郡,九江郡,豫章郡,汝南郡,江夏郡,',9)");
        db.execSQL("insert into mediumcity values (71,9,'会稽郡',62.5,75,',丹阳郡,吴郡,豫章郡,南海郡,',9)");
        db.execSQL("insert into mediumcity values (72,9,'豫章郡',37.5,75,',丹阳郡,会稽郡,庐江郡,江夏郡,长沙郡,桂阳郡,南海郡,',9)");
        db.execSQL("insert into mediumcity values (73,9,'吴郡',75,50,',丹阳郡,会稽郡,广陵郡,',9)");

        //武都郡，陇西郡，汉阳郡，安定郡，北地郡，武威郡，金城郡，张掖郡,张掖属,酒泉郡，敦煌郡
        db.execSQL("insert into bigcity values (10,'凉州',19,19,',并州,司隶,益州,')");
        db.execSQL("insert into mediumcity values (74,10,'武都郡',66,84,',陇西郡,汉阳郡,右扶风,汉中郡,广汉属,广汉郡,',10)");
        db.execSQL("insert into mediumcity values (75,10,'陇西郡',58,70,',金城郡,汉阳郡,武都郡,',10)");
        db.execSQL("insert into mediumcity values (76,10,'汉阳郡',74,70,',陇西郡,武都郡,安定郡,金城郡,武威郡,右扶风,',10)");
        db.execSQL("insert into mediumcity values (77,10,'安定郡',74,56,',武威郡,北地郡,汉阳郡,右扶风,',10)");
        db.execSQL("insert into mediumcity values (78,10,'北地郡',82,42,',武威郡,安定郡,右扶风,左冯翊,上郡,',10)");
        db.execSQL("insert into mediumcity values (79,10,'武威郡',66,42,',北地郡,安定郡,金城郡,张掖郡,汉阳郡,',10)");
        db.execSQL("insert into mediumcity values (80,10,'金城郡',58,56,',武威郡,陇西郡,汉阳郡,',10)");
        db.execSQL("insert into mediumcity values (81,10,'张掖郡',50,28,',张掖属,武威郡,酒泉郡,',10)");
        db.execSQL("insert into mediumcity values (82,10,'张掖属',41,14,',酒泉郡,敦煌郡,张掖郡,',10)");
        db.execSQL("insert into mediumcity values (83,10,'酒泉郡',32,28,',张掖属,敦煌郡,张掖郡,',10)");
        db.execSQL("insert into mediumcity values (84,10,'敦煌郡',16,28,',张掖属,酒泉郡,',10)");

        //汉中郡，巴郡，广汉郡，广汉属，蜀郡，蜀郡属，犍为郡，犍为属，牂牁郡，越巂郡，益州郡，永昌郡
        db.execSQL("insert into bigcity values (11,'益州',19,69,',凉州,司隶,荆州,交州,')");
        db.execSQL("insert into mediumcity values (85,11,'汉中郡',75,18,',广汉郡,巴郡,右扶风,京兆尹,南阳郡,南郡,武都郡,',11)");
        db.execSQL("insert into mediumcity values (86,11,'巴郡',75,36,',汉中郡,广汉郡,犍为郡,南郡,武陵郡,',11)");
        db.execSQL("insert into mediumcity values (87,11,'广汉郡',50,36,',广汉属,巴郡,汉中郡,蜀郡,犍为郡,武都郡,',11)");
        db.execSQL("insert into mediumcity values (88,11,'广汉属',37.5,18,',蜀郡,广汉郡,武都郡,',11)");
        db.execSQL("insert into mediumcity values (89,11,'蜀郡',25,36,',广汉郡,广汉属,蜀郡属,犍为郡,',11)");
        db.execSQL("insert into mediumcity values (90,11,'蜀郡属',25,50,',蜀郡,犍为郡,越巂郡,',11)");
        db.execSQL("insert into mediumcity values (91,11,'犍为郡',50,50,',巴郡,广汉郡,蜀郡,蜀郡属,犍为属,牂牁郡,越巂郡,武陵郡,',11)");
        db.execSQL("insert into mediumcity values (92,11,'犍为属',50,66,',犍为郡,越巂郡,益州郡,牂牁郡,',11)");
        db.execSQL("insert into mediumcity values (93,11,'牂牁郡',75,66,',犍为郡,犍为属,益州郡,永昌郡,武陵郡,郁林郡,交趾郡,',11)");
        db.execSQL("insert into mediumcity values (94,11,'越巂郡',25,66,',犍为郡,犍为属,蜀郡属,益州郡,永昌郡,',11)");
        db.execSQL("insert into mediumcity values (95,11,'益州郡',37.5,75,',犍为属,牂牁郡,越巂郡,永昌郡,',11)");
        db.execSQL("insert into mediumcity values (96,11,'永昌郡',25,84,',越巂郡,益州郡,牂牁郡,',11)");

        //南海郡，郁林郡，苍梧郡，合浦郡，交趾郡，九真郡,日南郡
        db.execSQL("insert into bigcity values (12,'交州',61.5,84,',荆州,扬州,益州,')");
        db.execSQL("insert into mediumcity values (97,12,'南海郡',80,20,',苍梧郡,合浦郡,桂阳郡,豫章郡,会稽郡,',12)");
        db.execSQL("insert into mediumcity values (98,12,'郁林郡',40,20,',交趾郡,合浦郡,苍梧郡,武陵郡,牂牁郡,',12)");
        db.execSQL("insert into mediumcity values (99,12,'苍梧郡',60,20,',南海郡,郁林郡,合浦郡,零陵郡,',12)");
        db.execSQL("insert into mediumcity values (100,12,'合浦郡',50,40,',交趾郡,苍梧郡,郁林郡,南海郡,',12)");
        db.execSQL("insert into mediumcity values (101,12,'交趾郡',20,40,',郁林郡,合浦郡,九真郡,牂牁郡,',12)");
        db.execSQL("insert into mediumcity values (102,12,'九真郡',20,60,',交趾郡,日南郡,',12)");
        db.execSQL("insert into mediumcity values (103,12,'日南郡',20,80,',九真郡,',12)");

        //司隶外
        db.execSQL(sqlinsert + "(0,'武都郡',10,80,',右扶风,',10)");
        db.execSQL(sqlinsert + "(0,'汉阳郡',10,60,',右扶风,',10)");
        db.execSQL(sqlinsert + "(0,'安定郡',10,40,',右扶风,',10)");
        db.execSQL(sqlinsert + "(0,'北地郡',15,20,',右扶风,左冯翊,',10)");
        db.execSQL(sqlinsert + "(0,'汉中郡',20,80,',右扶风,京兆尹,',11)");
        db.execSQL(sqlinsert + "(0,'上郡',35,20,',左冯翊,河东郡,',7)");
        db.execSQL(sqlinsert + "(0,'西河郡',45,20,',河东郡,',7)");
        db.execSQL(sqlinsert + "(0,'太原郡',55,20,',河东郡,',7)");
        db.execSQL(sqlinsert + "(0,'上党郡',70,20,',河东郡,河内郡,',7)");
        db.execSQL(sqlinsert + "(0,'魏郡',85,20,',河内郡,',6)");
        db.execSQL(sqlinsert + "(0,'东郡',85,35,',河内郡,',3)");
        db.execSQL(sqlinsert + "(0,'陈留郡',85,55,',河南尹,',3)");
        db.execSQL(sqlinsert + "(0,'颍川郡',85,70,',河南尹,',4)");
        db.execSQL(sqlinsert + "(0,'南阳郡',50,80,',河南尹,弘农郡,京兆尹,',8)");

        db.execSQL(sqlinsert + "(1,'东郡',10,80,',平原郡,',3)");
        db.execSQL(sqlinsert + "(1,'济北国',20,75,',平原郡,',3)");
        db.execSQL(sqlinsert + "(1,'泰山郡',40,75,',济南国,齐国,',3)");
        db.execSQL(sqlinsert + "(1,'琅琊国',60,80,',东莱郡,北海国,齐国,',2)");
        db.execSQL(sqlinsert + "(1,'渤海国',10,25,',乐安国,平原郡,',6)");
        db.execSQL(sqlinsert + "(1,'清河郡',10,50,',平原郡,',6)");

        db.execSQL(sqlinsert + "(2,'东莱郡',35,25,',琅琊国,',1)");
        db.execSQL(sqlinsert + "(2,'北海国',50,25,',琅琊国,',1)");
        db.execSQL(sqlinsert + "(2,'齐国',65,25,',琅琊国,',1)");
        db.execSQL(sqlinsert + "(2,'泰山郡',20,35,',琅琊国,东海国,',3)");
        db.execSQL(sqlinsert + "(2,'鲁国',20,50,',东海国,',4)");
        db.execSQL(sqlinsert + "(2,'沛国',20,65,',彭城国,下邳国,',4)");
        db.execSQL(sqlinsert + "(2,'九江郡',30,80,',下邳国,',9)");
        db.execSQL(sqlinsert + "(2,'丹阳郡',50,80,',广陵郡,',9)");
        db.execSQL(sqlinsert + "(2,'吴郡',70,80,',广陵郡,',9)");

        db.execSQL(sqlinsert + "(3,'河内郡',10,45,',东郡,',0)");
        db.execSQL(sqlinsert + "(3,'河南尹',10,75,',陈留郡,',0)");
        db.execSQL(sqlinsert + "(3,'清河郡',40,25,',东郡,',6)");
        db.execSQL(sqlinsert + "(3,'魏郡',20,35,',东郡,',6)");
        db.execSQL(sqlinsert + "(3,'平原郡',55,25,',东郡,济北国,',1)");
        db.execSQL(sqlinsert + "(3,'济南国',70,25,',泰山郡,',1)");
        db.execSQL(sqlinsert + "(3,'齐国',80,25,',泰山郡,',1)");
        db.execSQL(sqlinsert + "(3,'琅琊国',90,40,',泰山郡,',2)");
        db.execSQL(sqlinsert + "(3,'东海国',90,60,',泰山郡,',2)");
        db.execSQL(sqlinsert + "(3,'鲁国',73,63,',任城郡,泰山郡,东平国,济北国,',4)");
        db.execSQL(sqlinsert + "(3,'沛国',52.5,80,',济阴郡,山阳郡,任城郡,',4)");
        db.execSQL(sqlinsert + "(3,'梁国',40,80,',陈留郡,济阴郡,',4)");
        db.execSQL(sqlinsert + "(3,'陈国',30,80,',陈留郡,',4)");
        db.execSQL(sqlinsert + "(3,'颍川郡',20,80,',陈留郡,',4)");

        db.execSQL(sqlinsert + "(4,'陈留郡',35,20,',颍川郡,陈国,梁国,',3)");
        db.execSQL(sqlinsert + "(4,'济阴郡',50,20,',梁国,沛国,',3)");
        db.execSQL(sqlinsert + "(4,'山阳郡',60,20,',沛国,',3)");
        db.execSQL(sqlinsert + "(4,'任城郡',70,20,',沛国,鲁国,',3)");
        db.execSQL(sqlinsert + "(4,'东平国',75,10,',鲁国,',3)");
        db.execSQL(sqlinsert + "(4,'济北国',85,10,',鲁国,',3)");
        db.execSQL(sqlinsert + "(4,'泰山郡',95,10,',鲁国,',3)");
        db.execSQL(sqlinsert + "(4,'九江郡 ',71,80,',汝南郡,沛国,',9)");
        db.execSQL(sqlinsert + "(4,'庐江郡',59,85,',汝南郡,',9)");
        db.execSQL(sqlinsert + "(4,'东海国',89,30,',鲁国,',2)");
        db.execSQL(sqlinsert + "(4,'彭城国',85,40,',沛国,',2)");
        db.execSQL(sqlinsert + "(4,'下邳国',85,50,',沛国,',2)");
        db.execSQL(sqlinsert + "(4,'南阳郡',20,70,',汝南郡,颍川郡,',8)");
        db.execSQL(sqlinsert + "(4,'江夏郡',30,85,',汝南郡,',8)");
        db.execSQL(sqlinsert + "(4,'河南尹',15,40,',颍川郡,',0)");

        db.execSQL(sqlinsert + "(5,'雁门郡',7.5,40,',代郡,',7)");
        db.execSQL(sqlinsert + "(5,'常山郡',5.5,75,',代郡,',6)");
        db.execSQL(sqlinsert + "(5,'中山国',14.5,80,',代郡,涿郡,',6)");
        db.execSQL(sqlinsert + "(5,'河间郡',27.5,75,',广阳郡,涿郡,',6)");
        db.execSQL(sqlinsert + "(5,'渤海国',37.5,75,',渔阳郡,',6)");

        db.execSQL(sqlinsert + "(6,'河内郡',10,75,',魏郡,',0)");
        db.execSQL(sqlinsert + "(6,'上党郡',10,50,',赵国,魏郡,',7)");
        db.execSQL(sqlinsert + "(6,'太原郡',10,25,',常山郡,',7)");
        db.execSQL(sqlinsert + "(6,'代郡',20,15,',常山郡,中山国,',5)");
        db.execSQL(sqlinsert + "(6,'涿郡',40,15,',中山国,河间郡,',5)");
        db.execSQL(sqlinsert + "(6,'广阳郡',60,15,',河间郡,',5)");
        db.execSQL(sqlinsert + "(6,'渔阳郡',80,15,',渤海国,',5)");
        db.execSQL(sqlinsert + "(6,'平原郡',66,60,',渤海国,清河郡,',1)");
        db.execSQL(sqlinsert + "(6,'乐安国',83,60,',渤海国,',1)");
        db.execSQL(sqlinsert + "(6,'东郡',50,85,',魏郡,清河郡,',3)");

        db.execSQL(sqlinsert + "(7,'北地郡',12.5,75,',上郡,',10)");
        db.execSQL(sqlinsert + "(7,'左冯翊',20,85,',上郡,',0)");
        db.execSQL(sqlinsert + "(7,'河东郡',50,75,',上郡,西河郡,太原郡,上党郡,',0)");
        db.execSQL(sqlinsert + "(7,'河内郡',70,85,',上党郡,',0)");
        db.execSQL(sqlinsert + "(7,'代郡',92,25,',雁门郡,',5)");
        db.execSQL(sqlinsert + "(7,'赵国',92,65,',上党郡,',6)");
        db.execSQL(sqlinsert + "(7,'魏郡',92,75,',上党郡,',6)");
        db.execSQL(sqlinsert + "(7,'常山郡',92,40,',太原郡,',6)");

        db.execSQL(sqlinsert + "(8,'汉中郡',10,20,',南阳郡,南郡,',11)");
        db.execSQL(sqlinsert + "(8,'巴郡',10,40,',南郡,武陵郡,',11)");
        db.execSQL(sqlinsert + "(8,'犍为郡',10,50,',武陵郡,',11)");
        db.execSQL(sqlinsert + "(8,'牂牁郡',10,60,',武陵郡,',11)");
        db.execSQL(sqlinsert + "(8,'河南尹',48,10,',南阳郡,',0)");
        db.execSQL(sqlinsert + "(8,'弘农郡',32,10,',南阳郡,',0)");
        db.execSQL(sqlinsert + "(8,'京兆尹',16,10,',南阳郡,',0)");
        db.execSQL(sqlinsert + "(8,'汝南郡',80,10,',南阳郡,江夏郡,',4)");
        db.execSQL(sqlinsert + "(8,'颍川郡',64,10,',南阳郡,',4)");
        db.execSQL(sqlinsert + "(8,'庐江郡',85,30,',江夏郡,',9)");
        db.execSQL(sqlinsert + "(8,'豫章郡',88,60,',江夏郡,长沙郡,桂阳郡,',9)");
        db.execSQL(sqlinsert + "(8,'郁林郡',25,90,',武陵郡,',12)");
        db.execSQL(sqlinsert + "(8,'苍梧郡',50,90,',零陵郡,',12)");
        db.execSQL(sqlinsert + "(8,'南海郡',75,90,',桂阳郡,',12)");

        db.execSQL(sqlinsert + "(9,'南海郡',50,90,',豫章郡,会稽郡,',12)");
        db.execSQL(sqlinsert + "(9,'下邳国',50,10,',九江郡,',2)");
        db.execSQL(sqlinsert + "(9,'广陵郡',62.5,25,',丹阳郡,吴郡,',2)");
        db.execSQL(sqlinsert + "(9,'江夏郡',10,50,',豫章郡,庐江郡,',8)");
        db.execSQL(sqlinsert + "(9,'长沙郡',10,70,',豫章郡,',8)");
        db.execSQL(sqlinsert + "(9,'桂阳郡',10,80,',豫章郡,',8)");
        db.execSQL(sqlinsert + "(9,'汝南郡',25,10,',九江郡,庐江郡,',4)");
        db.execSQL(sqlinsert + "(9,'沛国',37.5,10,',九江郡,',4)");

        db.execSQL(sqlinsert + "(10,'上郡',93,42,',北地郡,',7)");
        db.execSQL(sqlinsert + "(10,'右扶风',86,70,',武都郡,汉阳郡,安定郡,北地郡,',0)");
        db.execSQL(sqlinsert + "(10,'左冯翊',92,56,',北地郡,',0)");
        db.execSQL(sqlinsert + "(10,'汉中郡',78,94,',武都郡,',11)");
        db.execSQL(sqlinsert + "(10,'广汉属',58,94,',武都郡,',11)");
        db.execSQL(sqlinsert + "(10,'广汉郡',68,94,',武都郡,',11)");

        db.execSQL(sqlinsert + "(11,'武都郡',50,9,',汉中郡,广汉属,广汉郡,',10)");
        db.execSQL(sqlinsert + "(11,'右扶风',65,9,',汉中郡,',0)");
        db.execSQL(sqlinsert + "(11,'京兆尹',88,9,',汉中郡,',0)");
        db.execSQL(sqlinsert + "(11,'南阳郡',88,35,',汉中郡,',8)");
        db.execSQL(sqlinsert + "(11,'南郡',88,45,',汉中郡,巴郡,',8)");
        db.execSQL(sqlinsert + "(11,'武陵郡',88,60,',犍为郡,巴郡,牂牁郡,',8)");
        db.execSQL(sqlinsert + "(11,'郁林郡',80,85,',牂牁郡,',12)");
        db.execSQL(sqlinsert + "(11,'交趾郡',64,85,',牂牁郡,',12)");

        db.execSQL(sqlinsert + "(12,'武陵郡',28,10,',郁林郡,',8)");
        db.execSQL(sqlinsert + "(12,'零陵郡',42,10,',苍梧郡,',8)");
        db.execSQL(sqlinsert + "(12,'桂阳郡',56,10,',南海郡,',8)");
        db.execSQL(sqlinsert + "(12,'豫章郡',70,10,',南海郡,',9)");
        db.execSQL(sqlinsert + "(12,'会稽郡',85,10,',南海郡,',9)");
        db.execSQL(sqlinsert + "(12,'牂牁郡',14,10,',郁林郡,交趾郡,',11)");
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
