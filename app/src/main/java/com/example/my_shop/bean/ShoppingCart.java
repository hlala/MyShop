package com.example.my_shop.bean;

import java.io.Serializable;

/**
 * 这是一个在购物车中被选中的商品
 */
public class ShoppingCart extends GoodsInfo implements Serializable {
    private int count;
    private boolean isChecked;

    public ShoppingCart() {
    }

    public int addCount() { return ++count; }

    public int subCount() {
        return --count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
