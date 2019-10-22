package com.example.my_shop.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.my_shop.R;
import com.example.my_shop.bean.HouseInfo;
import com.example.my_shop.bean.HouseListJson;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HouseListInfoAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int itemViewResourceId;

    private List<HouseListJson.ContentBean.LeaderboardByDescListBean> houseInfoList;

    public HouseListInfoAdapter(Context context, int itemViewResourceId, List<HouseListJson.ContentBean.LeaderboardByDescListBean> houseInfoList) {
        this.context = context;
        this.houseInfoList = houseInfoList;
        this.itemViewResourceId = itemViewResourceId;

        inflater = LayoutInflater.from(context);

        Fresco.initialize(context);
    }

    @Override
    public int getCount() {
        if (houseInfoList != null) {
            return houseInfoList.size();
        }

        return 0;
    }

    @Override
    public Object getItem(int i) {
        if (houseInfoList != null) {
            return houseInfoList.get(i);
        }

        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HouseListJson.ContentBean.LeaderboardByDescListBean houseInfo = (HouseListJson.ContentBean.LeaderboardByDescListBean) getItem(i);
        View itemView = inflater.inflate(itemViewResourceId, null);

        SimpleDraweeView imgHouseListInfoPicture = itemView.findViewById(R.id.img_house_list_info_picture);
        TextView txtHouseListInfoTitle = itemView.findViewById(R.id.txt_house_list_info_title);

        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setCornersRadius(10);
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(context.getResources());
        GenericDraweeHierarchy hierarchy = builder.build();
        hierarchy.setRoundingParams(roundingParams);
        imgHouseListInfoPicture.setHierarchy(hierarchy);

        imgHouseListInfoPicture.setImageURI(Uri.parse(houseInfo.getPictureUrl()));
        txtHouseListInfoTitle.setText(houseInfo.getDescription());

        return itemView;
    }
}
