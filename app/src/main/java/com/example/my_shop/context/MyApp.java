package com.example.my_shop.context;

import android.app.Application;

import com.example.my_shop.util.TypefaceUtil;


/**
 * @author liyanmei
 * @email lym_liyanmei@qq.com
 * @date 2019/6/25
 * @describe
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.replaceSystemDefaultFont(this,"fonts/Helvetica_Neue_CE_35_Thin.ttf");
    }
}