package com.cyy.csan.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cyy.csan.R;
import com.cyy.csan.dbtool.DataRequestUtil;


/**
 * 启动界面
 * Created by cyy
 * on 18-5-29下午5:43
 */
public class SplashActivity extends Activity {
    private DataRequestUtil mDataRequestUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mDataRequestUtil = new DataRequestUtil(getContext());
        mDataRequestUtil.getDB();
        Intent intent=new Intent(getContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public Context getContext() {
        return this;
    }
}
