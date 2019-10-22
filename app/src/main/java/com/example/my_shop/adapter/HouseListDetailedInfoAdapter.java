package com.example.my_shop.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.my_shop.R;
import com.example.my_shop.bean.HouseListDetailedInfoJson;
import com.example.my_shop.bean.HouseListJson;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HouseListDetailedInfoAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    private int itemTopViewResourceId = R.layout.item_house_detalied_info_top_title;
    private int itemShowViewResourceId = R.layout.item_house_detalied_info_show;

    private HouseListDetailedInfoJson.ContentBean.LeaderboardDetailModelBean leaderboardDetailModelBean;

    public HouseListDetailedInfoAdapter(Context context, HouseListDetailedInfoJson.ContentBean.LeaderboardDetailModelBean leaderboardDetailModelBean) {
        this.context = context;
        this.leaderboardDetailModelBean = leaderboardDetailModelBean;

        inflater = LayoutInflater.from(context);

        Fresco.initialize(context);
    }

    @Override
    public int getCount() {
        if (leaderboardDetailModelBean != null) {
            return leaderboardDetailModelBean.getLeaderboardUnitCardList().get(0)
                    .leaderboardUnitCardItemList.size() + 1;
        }

        return 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;

        if (i == 0) {
            itemView = inflater.inflate(itemTopViewResourceId, null);

            SimpleDraweeView imgHouseDetaliedInfoTopPicture = itemView.findViewById(R.id.img_house_detalied_info_top_picture);
            TextView txtHouseDetaliedInfoTopDescribeOne  = itemView.findViewById(R.id.txt_house_detalied_info_top_describe_one);
            TextView txtHouseDetaliedInfoTopDescribeTwo  = itemView.findViewById(R.id.txt_house_detalied_info_top_describe_two);
            TextView txtHouseDetaliedInfoTopDescribeThree  = itemView.findViewById(R.id.txt_house_detalied_info_top_describe_three);

            imgHouseDetaliedInfoTopPicture.setImageURI(Uri.parse(leaderboardDetailModelBean.getPictureUrl()));
            txtHouseDetaliedInfoTopDescribeOne.setText(leaderboardDetailModelBean.getTitle());
            txtHouseDetaliedInfoTopDescribeTwo.setText(leaderboardDetailModelBean.getSubTitle());
            txtHouseDetaliedInfoTopDescribeThree.setText(leaderboardDetailModelBean.getDescription());
        } else {
            List<HouseListDetailedInfoJson.ContentBean
                    .LeaderboardDetailModelBean.LeaderboardUnitCardListBean
                    .LeaderboardUnitCardItemListBean> beanList = leaderboardDetailModelBean.getLeaderboardUnitCardList()
                                                                                    .get(0)
                                                                                    .leaderboardUnitCardItemList;
            HouseListDetailedInfoJson.ContentBean.LeaderboardDetailModelBean
                    .LeaderboardUnitCardListBean
                    .LeaderboardUnitCardItemListBean bean = beanList.get(i - 1);

            itemView = inflater.inflate(itemShowViewResourceId, null);

            SimpleDraweeView imgHouseDetaliedInfoShowPicture = itemView.findViewById(R.id.img_house_detalied_info_show_picture);
            SimpleDraweeView imgHouseDetaliedInfoShowCountPicture = itemView.findViewById(R.id.img_house_detalied_info_show_count_picture);
            TextView txtHouseDetaliedInfoShowDescribeOne = itemView.findViewById(R.id.txt_house_detalied_info_show_describe_one);
            TextView txtHouseDetaliedInfoShowDescribeTwo = itemView.findViewById(R.id.txt_house_detalied_info_show_describe_two);

            imgHouseDetaliedInfoShowPicture.setImageURI(Uri.parse(bean.getPictureUrl()));
//            imgHouseDetaliedInfoShowCountPicture
            txtHouseDetaliedInfoShowDescribeOne.setText(bean.getSummary());
            txtHouseDetaliedInfoShowDescribeTwo.setText(bean.getDescription());
        }

        return itemView;
    }
}
