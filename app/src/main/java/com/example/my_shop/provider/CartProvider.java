package com.example.my_shop.provider;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;

import com.example.my_shop.bean.ShoppingCart;
import com.example.my_shop.db.PreferenceUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * 负责对整个购物车的数据进行存储与读取
 */
public class CartProvider {
    private Context context;

    private SparseArray<ShoppingCart> shoppingCartArray;

    public CartProvider(Context context) {
        this.context = context;
        shoppingCartArray = new SparseArray<>(8);
    }

    public void put(ShoppingCart shoppingCart) {
        ShoppingCart temp = shoppingCartArray.get(Integer.valueOf(shoppingCart.getId()));
        if (temp != null) {
            temp.addCount();

            return;
        }

        shoppingCartArray.put(shoppingCart.getId(), shoppingCart);
    }

    public List<ShoppingCart> getAll() {
        List<ShoppingCart> res = new ArrayList<>(shoppingCartArray.size());

        for (int i = 0; i < shoppingCartArray.size(); i++) {
            ShoppingCart sc = shoppingCartArray.valueAt(i);
            res.add(sc);
        }

        return res;
    }

    public ShoppingCart get(int key) {
        return shoppingCartArray.get(key);
    }

    public int size() {
        return shoppingCartArray.size();
    }

    public List<ShoppingCart> getAllFromLocal() {
        Gson gson = new Gson();
        String shoppingCartStr = PreferenceUtil.getString(context, PreferenceUtil.MY_SHOPPING, null);
        if (shoppingCartStr == null) {
            return null;
        }

        List<ShoppingCart> res = new ArrayList<>();
        Type type = new TypeToken<SparseArray<ShoppingCart>>(){}.getType();
        shoppingCartArray =  gson.fromJson(shoppingCartStr, type);

        return getAll();
    }

    public void commit() {
        Gson gson = new Gson();

        Log.d(TAG, "commit: pinghu : "
                                + PreferenceUtil.MY_SHOPPING
                                + gson.toJson(shoppingCartArray));

        PreferenceUtil.putString(context,
                                PreferenceUtil.MY_SHOPPING,
                                gson.toJson(shoppingCartArray));
    }
}
