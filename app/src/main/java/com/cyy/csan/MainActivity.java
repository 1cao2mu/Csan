package com.cyy.csan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cyy.csan.View.StrategyMapView;
import com.cyy.csan.bean.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyy
 * on 18-6-6下午3:32
 */
public class MainActivity extends AppCompatActivity {
    private StrategyMapView sm_map;
    private List<City> mCityList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
        initView();
    }

    private void initView() {
        mCityList.add(new City("凉州",15,15));
        mCityList.add(new City("益州",15,65));
        mCityList.add(new City("雍州",25,40));
        mCityList.add(new City("司隶",40,40));
        mCityList.add(new City("荆州",40,65));
        mCityList.add(new City("并州",52.5f,20));
        mCityList.add(new City("幽州",72.5f,10));
        mCityList.add(new City("冀州",65f,25));
        mCityList.add(new City("青州",80f,32.5f));
        mCityList.add(new City("徐州",77.5f,45));
        mCityList.add(new City("扬州",67.5f,62.5f));
        mCityList.add(new City("交州",57.5f,80));
        mCityList.add(new City("兖州",60f,40));
        mCityList.add(new City("豫州",60f,52.5f));
        sm_map = findViewById(R.id.sm_map);
        sm_map.setCityList(mCityList);
    }


}
