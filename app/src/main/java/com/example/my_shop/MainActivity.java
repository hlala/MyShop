package com.example.my_shop;

import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.my_shop.bean.Tab;
import com.example.my_shop.fragment.CartFragment;
import com.example.my_shop.fragment.CatagoryFragment;
import com.example.my_shop.fragment.HomeFragment;
import com.example.my_shop.fragment.HotFragment;
import com.example.my_shop.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost tabHost;

    private LayoutInflater layoutInflater;

    private List<Tab> tabList = new ArrayList<>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        tabHost = this.findViewById(R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        layoutInflater = LayoutInflater.from(this);

        initTab();
    }

    private void initTab() {
        Tab home = new Tab(R.string.home, R.drawable.selector_icon_home, HomeFragment.class);
        Tab hot = new Tab(R.string.hot, R.drawable.selector_icon_hot, HotFragment.class);
        Tab catagory = new Tab(R.string.catagory, R.drawable.selector_icon_catagory, CatagoryFragment.class);
        Tab cart = new Tab(R.string.cart, R.drawable.selector_icon_cart, CartFragment.class);
        Tab mine = new Tab(R.string.mine, R.drawable.selector_icon_mine, MineFragment.class);

        tabList.add(home);
        tabList.add(hot);
        tabList.add(catagory);
        tabList.add(cart);
        tabList.add(mine);

        for (Tab tab : tabList) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(getString(tab.getTitle()))
                                                .setIndicator(getString(tab.getTitle()));

            View view = layoutInflater.inflate(R.layout.tab_indicator, null);

            ImageView img = view.findViewById(R.id.icon_tab);
            TextView txt = view.findViewById(R.id.txt_indicator);

            img.setBackgroundResource(tab.getIcon());
            txt.setText(tab.getTitle());

            tabSpec.setIndicator(view);

            tabHost.addTab(tabSpec, tab.getFragment(), null);
        }
    }
}
