package com.cyy.csan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
public class CampaignActivity extends BaseActivity implements View.OnClickListener {

    private CampaignMapView cmMap;
    private boolean isIng = false;//是否正在进行中
    private Button btIng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign);
        initView();
    }

    private void initView() {
        cmMap = (CampaignMapView) findViewById(R.id.cm_map);
        BigArmy selfBigArmy,otherBigArmy;
        ArrayList<MiddleArmy> middleArmylist1=new ArrayList<>();
        ArrayList<MiddleArmy> middleArmylist2=new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            General general1 = new General("甲"+i, 70, 68, 0);
            SmallArmy smallArmy1 = new SmallArmy(general1, 1000, 1);
            MiddleArmy middleArmy1 = new MiddleArmy(general1, new ArrayList<>(Collections.singletonList(smallArmy1)));
            middleArmylist1.add(middleArmy1);
            General general2 = new General("乙"+i, 70, 68, 0);
            SmallArmy smallArmy2 = new SmallArmy(general2, 1000, 1);
            MiddleArmy middleArmy2 = new MiddleArmy(general2, new ArrayList<>(Collections.singletonList(smallArmy2)));
            middleArmylist2.add(middleArmy2);
        }

        otherBigArmy = new BigArmy(null, middleArmylist2);
        selfBigArmy = new BigArmy(null, middleArmylist1);
        cmMap.setArmy(selfBigArmy, otherBigArmy);
        btIng = (Button) findViewById(R.id.bt_ing);
        btIng.setOnClickListener(this);
        btIng.setText(isIng?"暂停":"继续");
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.bt_ing:
                isIng = !isIng;
                btIng.setText(isIng?"暂停":"继续");
                cmMap.setIng(isIng);
                break;
        }
    }
}
