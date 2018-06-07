package com.cyy.csan.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.cyy.csan.R;
import com.cyy.csan.dbtool.DataRequestUtil;


/**
 * Created by cyy
 * on 18-5-29下午5:43
 */
public class SplashActivity extends Activity {
    private CountDownTimer cdt;
    private DataRequestUtil mDataRequestUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mDataRequestUtil = new DataRequestUtil(this);
        cdt = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        mDataRequestUtil.copyDb("csan.db",cdt);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cdt.cancel();
    }

    public Context getContext() {
        return this;
    }
}
