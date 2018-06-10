package com.cyy.csan.activity;

import android.os.Bundle;
import android.util.Log;

import com.cyy.csan.R;
import com.cyy.csan.bean.City;
import com.cyy.csan.listener.OnClickCityListener;
import com.cyy.csan.view.StrategyMapView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyy
 * on 18-6-6下午3:32
 */
public class MainActivity extends BaseActivity implements OnClickCityListener {
    private StrategyMapView sm_map;
    private List<City> mCityList = new ArrayList<>();
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
        initView();
    }

    private void initView() {
        mCityList = mDataRequestUtil.getBigCityData();
        sm_map = findViewById(R.id.sm_map);
        sm_map.setCityList(mCityList);
        sm_map.setOnClickCityListener(this);
    }


    @Override
    public void onClickCityListener(City city) {
        if (!sm_map.isIsmedium()) {
            mCityList = mDataRequestUtil.getMediumCityData(city.getBid());
            sm_map.setCityList(mCityList, true);
        } else {
            Log.e(TAG, "onClickCityListener: " + city.getName());
        }

    }

    @Override
    public void onBackPressed() {
        if (sm_map.isIsmedium()) {
            mCityList = mDataRequestUtil.getBigCityData();
            sm_map.setCityList(mCityList);
        } else {
            super.onBackPressed();
        }
    }
}
