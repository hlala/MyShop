package com.example.my_shop.http;

import android.util.Log;

import com.example.my_shop.bean.Page;
import com.facebook.common.logging.LoggingDelegate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.support.constraint.Constraints.TAG;

public class OKHttpHelper {
    private static OkHttpClient client = new OkHttpClient();

    private OKHttpHelper() {
    }

    public static OKHttpHelper newInstance() {
        return new OKHttpHelper();
    }

    public void doGet(String url, Map<String, String> paras, Callback callback) {
        Request request = buildRequest(RequestType.GET, url, paras);
        client.newCall(request).enqueue(callback);
    }

    public void doGet(String url, Callback callback) {
        doGet(url, null, callback);
    }

    public void doPost(String url, Map<String, String> paras, Callback callback) {
        Request request = buildRequest(RequestType.POST, url, paras);
        client.newCall(request).enqueue(callback);
    }

    private Request buildRequest(Enum type, String url, Map<String, String> paras) {
        Request.Builder requestBuilder = new Request.Builder();
        if (type == RequestType.GET) {
            requestBuilder.url(buildURL(url, paras));
        } else if (type == RequestType.POST) {
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : paras.keySet()) {
                builder.add(key, paras.get(key));
                requestBuilder.post(builder.build());
            }
        }

        return requestBuilder.build();
    }

    private String buildURL(String url, Map<String, String> paras) {
        StringBuilder sb = new StringBuilder(url) ;

        for (String key : paras.keySet()) {
            sb.append(key);
            sb.append("=");
            sb.append(paras.get(key));
            sb.append("&");
        }

        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }

    private void demo() {
        String URL = "http://112.124.22.238:8081/course_api/wares/hot?curPage=1&pageSize=10";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(URL).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String resStr = response.body().string();
                    Gson gson = new Gson();
                    Type type = new TypeToken<Page>() {}.getType();
                    Page page = gson.fromJson(resStr, type);
                }
            }
        });
//        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
//        FormBody.Builder formBody = new FormBody.Builder();//创建表单请求体
//        formBody.add("username","zhangsan");//传递键值对参数
//        Request request = new Request.Builder()//创建Request 对象。
//                .url("http://www.baidu.com")
//                .post(formBody.build())//传递请求体
//                .build();
    }

    private enum RequestType {
        GET,
        POST
    }
}
