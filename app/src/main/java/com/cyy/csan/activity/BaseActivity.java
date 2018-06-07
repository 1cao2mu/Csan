package com.cyy.csan.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cyy.csan.dbtool.DataRequestUtil;

/**
 * Created by cyy
 * on 18-6-6下午3:32
 */
public class BaseActivity extends AppCompatActivity {
    private DataRequestUtil mDataRequestUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataRequestUtil = new DataRequestUtil(this);
    }

    public Context getContext() {
        return this;
    }


}
