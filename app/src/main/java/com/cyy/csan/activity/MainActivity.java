package com.cyy.csan.activity;

import android.os.Bundle;

import com.cyy.csan.R;
import com.cyy.csan.bean.City;
import com.cyy.csan.view.StrategyMapView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyy
 * on 18-6-6下午3:32
 */
public class MainActivity extends BaseActivity {
    private StrategyMapView sm_map;
    private List<City> mCityList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
        initView();
    }

    private void initView() {
        mCityList=mDataRequestUtil.getCityData();
        sm_map = findViewById(R.id.sm_map);
        sm_map.setCityList(mCityList);
    }


}
