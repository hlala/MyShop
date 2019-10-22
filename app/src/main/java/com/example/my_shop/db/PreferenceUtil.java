package com.example.my_shop.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.my_shop.exception.NullContextException;

/**
 * 目标：能读能写
 */
public class PreferenceUtil {
    public static String MY_SHOPPING = "m_shopping";

    private static Context mContext = null;

    private static SharedPreferences sp = null;
    private static SharedPreferences.Editor editor = null;

    private static void PreferenceUtil(Context context) {
        mContext = context;

        if (mContext == null) {

            try {
                throw new NullContextException("context is null");
            } catch (NullContextException e) {
                e.printStackTrace();
            }
        }

        sp = context.getSharedPreferences(MY_SHOPPING, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public static void putString(Context context, String key, String value) {
        if (mContext == null || sp == null || editor == null) {
            PreferenceUtil(context);
        }

        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key, String defaultStr) {
        if (mContext == null || sp == null || editor == null) {
            PreferenceUtil(context);
        }

        return sp.getString(key, defaultStr);
    }

    public static boolean contains(Context context, String key) {
        if (mContext == null || sp == null || editor == null) {
            PreferenceUtil(context);
        }

        return sp.contains(key);
    }
}
