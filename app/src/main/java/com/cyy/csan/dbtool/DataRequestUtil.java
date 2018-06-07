package com.cyy.csan.dbtool;

import android.content.Context;
import android.os.CountDownTimer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by cyy
 * on 18-6-7.
 */
public class DataRequestUtil {
    private Context context;

    public DataRequestUtil(Context context) {
        this.context = context;
    }

    public void copyDb(final String dbName, final CountDownTimer cdt) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File filesDir = context.getFilesDir();// 获取data/data/files目录的文件夹
                System.out.println("filesDir:" + filesDir.getAbsolutePath());
                File outFile = new File(filesDir, dbName);

                if (outFile.exists()) {//确保只复制一次
                    System.out.println("数据库" + dbName + "已经存在,无需拷贝!");
                    cdt.start();
                    return;
                }

                FileOutputStream out = null;
                InputStream in = null;
                try {
                    out = new FileOutputStream(outFile);
                    in = context.getAssets().open(dbName);

                    int len = 0;
                    byte[] buffer = new byte[1024];

                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        out.close();
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                cdt.start();
                System.out.println("拷贝数据库" + dbName + "成功!");
            }
        }).start();


    }
}
