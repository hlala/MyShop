package com.example.my_shop.acvitity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.my_shop.R;
import com.example.my_shop.adapter.HouseListDetailedInfoAdapter;
import com.example.my_shop.bean.HouseListDetailedInfoJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class HouseListDetailedInfoActivity extends AppCompatActivity {
    private static final String TAG = "HouseListDetailedInfoAc";
    private ListView houseDetaliedInfosView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_list_detailed_info);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        int count = getIntent().getIntExtra("COUNT", -1);
        Log.d(TAG, "onCreate: pinghu:count :" + count);

        initView();
        setViewData();
    }

    private void setViewData() {
        HouseListDetailedInfoAdapter houseListDetailedInfoAdapter = new HouseListDetailedInfoAdapter(this, getData());
        houseDetaliedInfosView.setAdapter(houseListDetailedInfoAdapter);
    }

    private HouseListDetailedInfoJson.ContentBean.LeaderboardDetailModelBean getData() {
        String str = getJson("minsulishaitaiyang.json");

        Type type = new TypeToken<HouseListDetailedInfoJson>(){}.getType();
        HouseListDetailedInfoJson json = new Gson().fromJson(str, type);

        return json.getContent().getLeaderboardDetailModel();
    }

    private void initView() {
        houseDetaliedInfosView = findViewById(R.id.list_house_detalied_infos);
    }

    private String getJson(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assets = getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assets.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
