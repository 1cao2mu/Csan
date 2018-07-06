package com.cyy.csan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.cyy.csan.R;
import com.cyy.csan.bean.Bean;
import com.cyy.csan.bean.City;
import com.cyy.csan.listener.OnClickBeanListener;
import com.cyy.csan.view.StrategyMapView;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 * Created by cyy
 * on 18-6-6下午3:32
 */
public class MainActivity extends BaseActivity implements OnClickBeanListener {
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
        sm_map = (StrategyMapView) findViewById(R.id.sm_map);
        sm_map.setCityList(mCityList);
        sm_map.setOnClickBeanListener(this);
    }


    @Override
    public void onClickBeanListener(Bean bean) {
        if (bean instanceof City) {
            City city = (City) bean;
            if (!sm_map.isIsmedium()) {
                mCityList = mDataRequestUtil.getMediumCityData(city.getBid());
                sm_map.setCityList(mCityList, true);
            } else {
                Log.e(TAG, "onClickBeanListener: " + city.getName());
                Intent intent = new Intent(getContext(), CampaignActivity.class);
                startActivity(intent);
            }
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
