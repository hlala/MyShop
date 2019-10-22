package com.example.my_shop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_shop.R;
import com.example.my_shop.bean.GoodsShow;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.HomeRecyclerHolder> {
    private Context context;
    private LayoutInflater inflater;

    private List<GoodsShow> goodShowsDataList;

    public HomeRecyclerAdapter(List<GoodsShow> goodShowsDataList, Context context) {
        this.goodShowsDataList = goodShowsDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_home_cardview_left, parent, false);

        return new HomeRecyclerHolder(view);
    }

    /**
     * 将数据与Adapter绑定
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerHolder holder, int position) {
        GoodsShow goodsShow = goodShowsDataList.get(position);
        holder.goodsShoeTitle.setText(goodsShow.getTitle());

        Picasso.with(context).load(goodsShow.getCpOne().getImgUrl()).into(holder.imgBig);
        Picasso.with(context).load(goodsShow.getCpTwo().getImgUrl()).into(holder.imgSmall1);
        Picasso.with(context).load(goodsShow.getCpThree().getImgUrl()).into(holder.imgSmall2);
    }

    @Override
    public int getItemCount() {
        return goodShowsDataList.size();
    }

    class HomeRecyclerHolder extends RecyclerView.ViewHolder {
        private TextView goodsShoeTitle;
        private ImageView imgBig;
        private ImageView imgSmall1;
        private ImageView imgSmall2;

        public HomeRecyclerHolder(View itemView) {
            super(itemView);

            goodsShoeTitle = itemView.findViewById(R.id.goods_show_title);
            imgBig = itemView.findViewById(R.id.goods_show_big_img);
            imgSmall1 = itemView.findViewById(R.id.goods_show_small_img1);
            imgSmall2 = itemView.findViewById(R.id.goods_show_small_img2);
        }
    }
}
