package com.example.my_shop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.example.my_shop.R;
import com.example.my_shop.adapter.HotRecyclerAdapter;
import com.example.my_shop.bean.GoodsInfo;
import com.example.my_shop.bean.Page;
import com.example.my_shop.bean.ShoppingCart;
import com.example.my_shop.http.API;
import com.example.my_shop.http.OKHttpHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.support.constraint.Constraints.TAG;

public class HotFragment extends Fragment {
    private final static int REFRESH_DATA = 0;
    private final static int ADD_MORE_DATA = 1;

    private Handler handler;

    private MaterialRefreshLayout materialRefreshLayout;

    private int totalCount;
    private int currentCount;
    private RecyclerView recyclerView;
    private HotRecyclerAdapter adapter;

    private List<GoodsInfo> goodsInfoList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        recyclerView = view.findViewById(R.id.hot_goods_infos);
        materialRefreshLayout = view.findViewById(R.id.hot_materialRefreshLayout);

        initHandler();
        initMaterialRefreshLayout();

        adapter = new HotRecyclerAdapter(getActivity(), goodsInfoList, handler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        refershGoodsInfo();

        return view;
    }

    private void refershGoodsInfo() {
        Map<String, String> paras = new HashMap<>();
        paras.put("curPage", "1");
        paras.put("pageSize", "10");

        requestGoodsInfo(paras, REFRESH_DATA);
    }

    private void initMaterialRefreshLayout() {
        materialRefreshLayout.setLoadMore(true);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                refershGoodsInfo();

                materialRefreshLayout.finishRefresh();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if (currentCount >= totalCount) {
                    Toast.makeText(getActivity(), "无更多商品信息", Toast.LENGTH_SHORT).show();
                }

                Map<String, String> paras = new HashMap<>();
                paras.put("curPage", (currentCount/10 + 1) + "");
                paras.put("pageSize", "10");

                requestGoodsInfo(paras, ADD_MORE_DATA);

                materialRefreshLayout.finishRefreshLoadMore();
            }
        });
    }

    private void initHandler() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Log.d(TAG, "handleMessage: pinghu:" + msg.what + ":" + msg.obj);

                switch (msg.what) {
                    case REFRESH_DATA:
                        refershData(msg.obj);
                        break;
                    case ADD_MORE_DATA:
                        addMoreData(msg.obj);
                        break;
                    case HotRecyclerAdapter.BUY_SHOPPING:
                        sendBuyMessage(msg.obj);
                        break;
                }
            }
        };
    }

    private void sendBuyMessage(Object o) {
        ShoppingCart sc = (ShoppingCart) o;

        Intent intent = new Intent(API.SEND_BUY_INFO);
        intent.putExtra(API.BUY_INFO, sc);
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);

//        bundle为null
//        Bundle bundle = getArguments();
//        bundle.putSerializable(API.BUY_INFO, sc);
//        setArguments(bundle);

//        cart为空
//        CartFragment cart = (CartFragment) getFragmentManager().findFragmentByTag("购物车");
//        cart.addBuyINfo(sc);

        Toast.makeText(getActivity(), "添加了" + sc.getName(), Toast.LENGTH_SHORT).show();
    }

    private void refershData(Object o) {
        Page page = (Page) o;

        if (totalCount == 0) {
            totalCount = page.totalCount;
        }

        if (goodsInfoList != null) {
            this.goodsInfoList.addAll(page.goodsInfoList);
            Log.d(TAG, "refershData: pinghu:调用的notify方法");
            adapter.notifyDataSetChanged();

            currentCount = goodsInfoList.size();
        }
    }

    private void addMoreData(Object o) {
        Page page = (Page) o;
        List<GoodsInfo> more = page.goodsInfoList;

        goodsInfoList.addAll(more);
        if (goodsInfoList != null && goodsInfoList.size() > 0) {
            HotRecyclerAdapter adapter = new HotRecyclerAdapter(getActivity(), goodsInfoList, handler);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            currentCount = goodsInfoList.size();
        }
    }

    private void requestGoodsInfo(Map<String, String> paras, final int requestType){
        OKHttpHelper okHttpHelper = OKHttpHelper.newInstance();

        okHttpHelper.doGet(API.BASE_URL + API.GOODS_INFO, paras, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: pinghu:请求商品数据失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String resStr = response.body().string();
                    Gson gson = new Gson();
                    Type type = new TypeToken<Page>() {}.getType();
                    Page page = gson.fromJson(resStr, type);

                    Message mag = new Message();
                    mag.obj = page;
                    mag.what = requestType;
                    handler.sendMessage(mag);
                    Log.d(TAG, "onResponse: pinghu:" + resStr + ":" + page);
                }
            }
        });
    }
}
