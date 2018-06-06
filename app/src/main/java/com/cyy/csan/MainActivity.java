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
        mCityList.add(new City("凉州",10,10));
        mCityList.add(new City("益州",10,70));
        mCityList.add(new City("雍州",30,50));
        mCityList.add(new City("司隶",50,50));
        mCityList.add(new City("荆州",50,70));
        mCityList.add(new City("并州",60,20));
        mCityList.add(new City("幽州",80,10));
        mCityList.add(new City("冀州",70,30));
        mCityList.add(new City("青州",80,40));
        mCityList.add(new City("徐州",80,50));
        mCityList.add(new City("扬州",70,70));
        mCityList.add(new City("交州",60,80));
        mCityList.add(new City("兖州",50,60));
        mCityList.add(new City("豫州",60,60));
        sm_map = findViewById(R.id.sm_map);
        sm_map.setCityList(mCityList);
    }


}
