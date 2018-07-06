package com.cyy.csan.activity;

import android.os.Bundle;

import com.cyy.csan.R;
import com.cyy.csan.bean.BigArmy;
import com.cyy.csan.bean.General;
import com.cyy.csan.bean.MiddleArmy;
import com.cyy.csan.bean.SmallArmy;
import com.cyy.csan.view.CampaignMapView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 战役界面
 * Created by cyy
 * on 18-7-5上午10:35
 */
public class CampaignActivity extends BaseActivity {

    private CampaignMapView cmMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign);
        initView();
    }

    private void initView() {
        cmMap = (CampaignMapView) findViewById(R.id.cm_map);
        General general = new General("关彝", 80, 68, 0);
        SmallArmy smallArmy = new SmallArmy(general, 1000, 1);
        MiddleArmy middleArmy = new MiddleArmy(general,new ArrayList<>(Collections.singletonList(smallArmy)) );
        BigArmy selfBigArmy = new BigArmy(general,new ArrayList<>(Collections.singletonList(middleArmy)) );
        BigArmy otherBigArmy = new BigArmy(general,new ArrayList<>(Collections.singletonList(middleArmy)));
        cmMap.setArmy(selfBigArmy, otherBigArmy);
    }
}
