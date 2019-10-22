package com.example.my_shop.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_shop.R;
import com.example.my_shop.adapter.CartRecyclerAdapter;
import com.example.my_shop.bean.GoodsInfo;
import com.example.my_shop.bean.ShoppingCart;
import com.example.my_shop.db.PreferenceUtil;
import com.example.my_shop.http.API;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class CartFragment extends Fragment {
    private final int REFERSH_BUY_INFOS = 0;

    private Handler handler;

    private LocalBroadcastManager broadcastManager;
    private BroadcastReceiver mAdDownLoadReceiver;
    private IntentFilter intentFilter;

    private List<ShoppingCart> shoppingCartDataList;

    private Button btnManage;
    private RecyclerView shoppingCartListView;
    private CheckBox cbxSelectAll;
    private TextView txtTotalPrice;
    private Button btnSettlement;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        btnManage = view.findViewById(R.id.btn_manage);
        shoppingCartListView = view.findViewById(R.id.shopping_cart_list);
        cbxSelectAll = view.findViewById(R.id.cbx_select_all);
        txtTotalPrice = view.findViewById(R.id.txt_total_price);
        btnSettlement = view.findViewById(R.id.btn_settlement);

        initHandler();

        receiveAdDownload();

        initShoppingCartListFormLocal();


        test();

        return view;
    }

    /**
     * 该方法每次都会被调用
     */
    @Override
    public void onResume() {
        super.onResume();


        Toast.makeText(getActivity(), "cart的resume", Toast.LENGTH_SHORT).show();

//        Bundle bundle = getArguments();
//        ShoppingCart sc = (ShoppingCart) bundle.getSerializable(API.BUY_INFO);
//        Toast.makeText(getActivity(), "接收到了:" + sc.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        broadcastManager.unregisterReceiver(mAdDownLoadReceiver);

        PreferenceUtil.putString(getActivity(), PreferenceUtil.MY_SHOPPING, new Gson().toJson(shoppingCartDataList));
        Log.d(TAG, "onDestroy: pinghu:被存到本地了：" + new Gson().toJson(shoppingCartDataList));
    }

    private void initShoppingCartListFormLocal() {
        String localStr = PreferenceUtil.getString(getActivity(), PreferenceUtil.MY_SHOPPING, "");

        Log.d(TAG, "initShoppingCartListFormLocal: pinghu:被读出来了 ：" + localStr);
        if (localStr == null || localStr.equals("")) {
            return;
        }

        Type type = new TypeToken<List<ShoppingCart>>(){}.getType();
        List<ShoppingCart> shoppingCartList = new Gson().fromJson(localStr, type);
        if (shoppingCartList != null) {
            this.shoppingCartDataList = shoppingCartList;

            refershData(shoppingCartDataList);
        }
    }

    private void initHandler() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case REFERSH_BUY_INFOS:
                        refershData((List<ShoppingCart>) msg.obj);
                        break;
                }
            }
        };
    }

    private void receiveAdDownload() {
        mAdDownLoadReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ShoppingCart sc = (ShoppingCart) intent.getSerializableExtra(API.BUY_INFO);
                shoppingCartDataList.add(sc);

                Message msg = new Message();
                msg.what = REFERSH_BUY_INFOS;
                msg.obj = shoppingCartDataList;
                handler.sendMessage(msg);
            }
        };

        broadcastManager = LocalBroadcastManager.getInstance(getActivity());
        intentFilter = new IntentFilter();
        intentFilter.addAction(API.SEND_BUY_INFO);
        broadcastManager.registerReceiver(mAdDownLoadReceiver, intentFilter);
    }

    private void refershData(List<ShoppingCart> shoppingCartList) {
        if (shoppingCartList != null && shoppingCartList.size() > 0) {
            CartRecyclerAdapter cartRecyclerAdapter = new CartRecyclerAdapter(getActivity(), shoppingCartList);
            shoppingCartListView.setAdapter(cartRecyclerAdapter);
            shoppingCartListView.setLayoutManager(new LinearLayoutManager(getActivity()));
            shoppingCartListView.setItemAnimator(new DefaultItemAnimator());
        }
    }

    private void test() {
        String dataJsonStr = "[{\"id\":1,\"categoryId\":5,\"campaignId\":1,\"name\":\"联想（Lenovo）拯救者14.0英寸游戏本（i7-4720HQ 4G 1T硬盘 GTX960M 2G独显 FHD IPS屏 背光键盘）黑\",\"imgUrl\":\"https://img.cniao5.com/s_recommend_55c1e8f7N4b99de71.jpg\",\"price\":5979.0,\"sale\":8654},{\"id\":2,\"categoryId\":6,\"campaignId\":1,\"name\":\"奥林巴斯（OLYMPUS）E-M10-1442-EZ 微单电电动变焦套机 银色 内置WIFI 翻转触摸屏 EM10复古高雅\",\"imgUrl\":\"https://img.cniao5.com/s_recommend_rBEhWlMFnG0IAAAAAAIqnbSuyAAAAIxLwJ57aQAAiq1705.jpg\",\"price\":3799.0,\"sale\":3020},{\"id\":3,\"categoryId\":6,\"campaignId\":3,\"name\":\"Apple iPad mini 2 ME276CH/A （配备 Retina 显示屏 7.9英寸 16G WLAN 机型 深空灰色）\",\"imgUrl\":\"https://img.cniao5.com/s_recommend_548574edNc366ff4a.jpg\",\"price\":1938.0,\"sale\":9138}]";

        Type type = new TypeToken<List<GoodsInfo>>(){}.getType();
        List<GoodsInfo> goodsInfos = new Gson().fromJson(dataJsonStr, type);

        List<ShoppingCart> scList = new ArrayList<>(goodsInfos.size());
        for (GoodsInfo gi : goodsInfos) {
            scList.add(gi.toShoppingCart());
        }

        this.shoppingCartDataList = scList;
//        Message msg = new Message();
//        msg.what = REFERSH_BUY_INFOS;
//        msg.obj = scList;
//        handler.sendMessage(msg);
    }
}
