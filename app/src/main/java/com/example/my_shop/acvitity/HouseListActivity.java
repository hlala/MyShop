package com.example.my_shop.acvitity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.my_shop.R;
import com.example.my_shop.adapter.HouseListInfoAdapter;
import com.example.my_shop.bean.HouseInfo;
import com.example.my_shop.bean.HouseListJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class HouseListActivity extends AppCompatActivity {
    private static final String TAG = "HouseListActivity";

    private ListView houseInfoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_list);

        initViews();
        setListener();
        setViewInfos();
     }

    private void initViews() {
        houseInfoListView = findViewById(R.id.lv_house_list);
    }

    private void setViewInfos() {
        List<HouseListJson.ContentBean.LeaderboardByDescListBean> houseInfoList = initData();
        HouseListInfoAdapter houseListInfoAdapter = new HouseListInfoAdapter(this, R.layout.item_house_list_info, houseInfoList);
        houseInfoListView.setAdapter(houseListInfoAdapter);
    }

    private List<HouseListJson.ContentBean.LeaderboardByDescListBean> initData() {
        String houseInfoStr = getJson("BeijingTeseFangwuTuijian.json");
        Type type = new TypeToken<HouseListJson>(){}.getType();
        HouseListJson houseListJson = new Gson().fromJson(houseInfoStr, type);

        return houseListJson.getContent().getLeaderboardByDescList();
    }

    private void setListener() {
        houseInfoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick:pinghu: " + i  + ";"+ l );
                Intent intent = new Intent(HouseListActivity.this, HouseListDetailedInfoActivity.class);
                intent.putExtra("COUNT", i);
                startActivity(intent);
            }
        });
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
