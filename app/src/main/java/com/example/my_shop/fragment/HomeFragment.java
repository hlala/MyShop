package com.example.my_shop.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.my_shop.R;
import com.example.my_shop.adapter.HomeRecyclerAdapter;
import com.example.my_shop.bean.Banner;
import com.example.my_shop.bean.GoodsShow;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment {
    private final static int REFERSH_SLIDER_VIEW = 0;
    private final static int REFERSH_RECYCLER_VIEW = 1;

    private View homeView;

    private Handler homeHandler;

    private SliderLayout sliderShow;
    private List<Banner> bannerList;

    private RecyclerView recyclerView;
    private HomeRecyclerAdapter adapter;
    private List<GoodsShow> dataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.fragment_home, container, false);

        sliderShow = homeView.findViewById(R.id.slider);
        recyclerView = homeView.findViewById(R.id.recyclerView);

        initHomeHandler();
        requestImages();
        requestGoodsShowInfo();

        return homeView;
    }

    private void initHomeHandler() {
        homeHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case REFERSH_SLIDER_VIEW :
                        initSliderView();

                        break;
                    case REFERSH_RECYCLER_VIEW :
                        initRecyclerView();

                        break;
                    default:
                        break;
                }
            }
        };
    }

    private void initRecyclerView() {
        if (dataList != null && dataList.size() > 0) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new HomeRecyclerAdapter(dataList, getActivity());
            recyclerView.setAdapter(adapter);
        }
    }

    private void initSliderView() {
        if (bannerList != null && bannerList.size() > 0) {
            for (final Banner banner : bannerList) {
                TextSliderView textSliderView = new TextSliderView(getActivity());
                textSliderView
                        .description(banner.getName())
                        .image(banner.getImgUrl())
                        .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                            @Override
                            public void onSliderClick(BaseSliderView slider) { Toast.makeText(getContext(),"你点击了" + banner.getName(), Toast.LENGTH_SHORT).show();
                            }
                        });

                sliderShow.addSlider(textSliderView);
            }
        }

        sliderShow.setCustomIndicator((PagerIndicator) homeView.findViewById(R.id.custom_indicator));
    }

    private void requestGoodsShowInfo() {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }

        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url("http://112.124.22.238:8081/course_api/campaign/recommend").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: pinghu : 请求商品信息失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String resStr = response.body().string();

                    Gson gson = new Gson();
                    Type type = new TypeToken<List<GoodsShow>>(){}.getType();
                    dataList = gson.fromJson(resStr, type);
                    Log.d(TAG, "onResponse: pinghu : " + resStr);

                    homeHandler.sendEmptyMessage(REFERSH_RECYCLER_VIEW);
                }
            }
        });
    }

    private void requestImages() {
        String URL = "http://112.124.22.238:8081/course_api/banner/query?type=1";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(URL).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: pinghu:failure");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String resStr = response.body().string();

                Type resType = new TypeToken<List<Banner>>(){}.getType();
                Gson gson = new Gson();
                bannerList = gson.fromJson(resStr, resType);
                homeHandler.sendEmptyMessage(REFERSH_SLIDER_VIEW);
            }
        });
    }
}
