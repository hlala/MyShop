package com.example.my_shop.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_shop.R;
import com.example.my_shop.bean.GoodsInfo;
import com.example.my_shop.bean.GoodsShow;
import com.example.my_shop.bean.ShoppingCart;
import com.example.my_shop.db.PreferenceUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.List;

import static android.content.ContentValues.TAG;

public class HotRecyclerAdapter extends RecyclerView.Adapter<HotRecyclerAdapter.HotRecyclerHolder> {
    private Context context;
    private Handler handler;
    private LayoutInflater inflater;

    private List<GoodsInfo> goodsInfoList;

    public static final int BUY_SHOPPING = 2;

    public HotRecyclerAdapter(Context context, List<GoodsInfo> goodsInfoList, Handler handler) {
        this.context = context;
        this.goodsInfoList = goodsInfoList;
        this.handler = handler;
    }

    @NonNull
    @Override
    public HotRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        Fresco.initialize(context);

        View view = inflater.inflate(R.layout.item_hot_goods_info, parent, false);

        return new HotRecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HotRecyclerHolder holder, int position) {
        if (goodsInfoList != null && goodsInfoList.size() > 0) {
            final GoodsInfo goodsInfo = goodsInfoList.get(position);
            holder.goodsInfoTitle.setText(goodsInfo.getName());
            holder.goodsInfoPrice.setText("$" + goodsInfo.getPrice());
            holder.goodsInfoImg.setImageURI(Uri.parse(goodsInfo.getImgUrl()));

            holder.btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "点击了" + goodsInfo.getName(), Toast.LENGTH_SHORT).show();
                    ShoppingCart sc = goodsInfo.toShoppingCart();

                    Message msg = new Message();
                    msg.what = BUY_SHOPPING;
                    msg.obj = sc;
                    handler.sendMessage(msg);
                    Toast.makeText(context, "消息发送了", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (goodsInfoList != null) {
            return goodsInfoList.size();
        }
        return 0;
    }

    class HotRecyclerHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView goodsInfoImg;
        private TextView goodsInfoTitle;
        private TextView goodsInfoPrice;
        private Button btnBuy;

        public HotRecyclerHolder(View itemView) {
            super(itemView);

            goodsInfoImg = itemView.findViewById(R.id.goods_info_img);
            goodsInfoTitle = itemView.findViewById(R.id.goods_info_title);
            goodsInfoPrice = itemView.findViewById(R.id.goods_info_price);
            btnBuy = itemView.findViewById(R.id.goods_info_buy);
        }

        private void addListener() {
            btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(context, "点击了购买", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
