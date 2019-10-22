package com.example.my_shop.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.my_shop.R;
import com.example.my_shop.bean.NumberAddSubView;
import com.example.my_shop.bean.ShoppingCart;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URI;
import java.util.List;

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.CartRecyclerHolder> {
    private Context context;
    private List<ShoppingCart> shoppingCartList;

    private LayoutInflater inflater;

    public CartRecyclerAdapter(Context context, List<ShoppingCart> shoppingCartList) {
        this.context = context;
        this.shoppingCartList = shoppingCartList;
    }

    @NonNull
    @Override
    public CartRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());

        Fresco.initialize(context);
        View view = inflater.inflate(R.layout.item_cart_order_info, parent, false);

        return new CartRecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartRecyclerHolder holder, int position) {
        ShoppingCart sc = shoppingCartList.get(position);

        holder.cbxSelectItem.setChecked(sc.isChecked());
        holder.imgOrder.setImageURI(Uri.parse(sc.getImgUrl()));
        holder.txtOrderTitle.setText(sc.getName());
        holder.nasOrderCount.setValue(sc.getCount());
        holder.txtOrderPrice.setText(sc.getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    class CartRecyclerHolder extends RecyclerView.ViewHolder {
        private CheckBox cbxSelectItem;
        private SimpleDraweeView imgOrder;
        private TextView txtOrderTitle;
        private NumberAddSubView nasOrderCount;
        private TextView txtOrderPrice;

        public CartRecyclerHolder(View itemView) {
            super(itemView);

            cbxSelectItem = itemView.findViewById(R.id.cbx_select_item);
            imgOrder = itemView.findViewById(R.id.img_order);
            txtOrderTitle = itemView.findViewById(R.id.txt_order_title);
            nasOrderCount = itemView.findViewById(R.id.nas_order_count);
            txtOrderPrice = itemView.findViewById(R.id.txt_order_price);
        }
    }
}
