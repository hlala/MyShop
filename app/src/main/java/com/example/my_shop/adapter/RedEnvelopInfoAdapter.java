package com.example.my_shop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_shop.R;
import com.example.my_shop.bean.RedEnvelopeInfo;
import com.example.my_shop.view.ExpandableTextView;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class RedEnvelopInfoAdapter extends RecyclerView.Adapter<RedEnvelopInfoAdapter.RedenvelopInfoHolder> {
    private Context context;
    private LayoutInflater inflater;

    private List<RedEnvelopeInfo.ContentBean.ListBean.ItemsBean> redEnvelopeInfoList;

    public RedEnvelopInfoAdapter(Context context, List<RedEnvelopeInfo.ContentBean.ListBean.ItemsBean> redEnvelopeInfoList) {
        this.context = context;
        this.redEnvelopeInfoList = redEnvelopeInfoList;
    }

    @NonNull
    @Override
    public RedEnvelopInfoAdapter.RedenvelopInfoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        Fresco.initialize(context);

        View view = inflater.inflate(R.layout.item_redenvelope_info, parent, false);

        return new RedEnvelopInfoAdapter.RedenvelopInfoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RedenvelopInfoHolder holder, int position) {
        if (redEnvelopeInfoList != null) {
            RedEnvelopeInfo.ContentBean.ListBean.ItemsBean info = redEnvelopeInfoList.get(position);

            holder.txtRedevenvelopPriceCurrency.setText(info.getCurrency());
            holder.txtRedevenvelopPriceAmount.setText(info.getAmount() + "");
            holder.txtRedevenvelopPriceTitle.setText(info.getTitle());
            holder.txtRedevenvelopContent.setText(info.getContent());
            holder.txtRedevenvelopValidPeriod.setText(info.getValidPeriod());

            List<String> expandableTexts = info.getLimitRules();
            holder.expandableTextView.setText(expandableTexts.get(0));

            holder.btnRedevenvelopReceiver.setText("  " + info.getLink().getText() + "  ");

            // 为true代表已领取
            if (info.isGray()) {
                holder.btnRedevenvelopReceiver.setEnabled(false);
                holder.btnRedevenvelopReceiver.setBackgroundResource(R.drawable.bt_shape_unavailable);
            } else {
                holder.btnRedevenvelopReceiver.setEnabled(true);
                holder.btnRedevenvelopReceiver.setBackgroundResource(R.drawable.bt_shape_available);
            }

            holder.btnRedevenvelopReceiver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button button = (Button) view;

                    // 在这里添加点击领取之后的逻辑代码
                    button.setEnabled(false);
                    button.setText("  已领取  ");
                    button.setBackgroundResource(R.drawable.bt_shape_unavailable);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (redEnvelopeInfoList != null) {
            return redEnvelopeInfoList.size();
        }
        return 0;
    }

    class RedenvelopInfoHolder extends RecyclerView.ViewHolder {
/*
                android:id="@+id/txt_redevenvelop_price_currency"
                android:text="$"/>

                android:id="@+id/txt_redevenvelop_price_amount"
                android:text="999"/>

                android:id="@+id/txt_redevenvelop_price_title"
                android:text="夏日专属券-平台通用"/>

                android:id="@+id/btn_redevenvelop_receiver"
                android:text="   领取红包   "/>

                android:id="@+id/txt_redevenvelop_content"
                android:text="满2800元减280元 满2000元减200元\n满1400元减140元 满1000元减100元\n满700元减70元"/>

                android:id="@+id/txt_redevenvelop_valid_period"
                android:text="有效期：2019-07-12至2019-07-23"/>
*/

        private TextView txtRedevenvelopPriceCurrency;
        private TextView txtRedevenvelopPriceAmount;
        private TextView txtRedevenvelopPriceTitle;
        private Button btnRedevenvelopReceiver;
        private TextView txtRedevenvelopContent;
        private TextView txtRedevenvelopValidPeriod;
        private ExpandableTextView expandableTextView;

        public RedenvelopInfoHolder(View itemView) {
            super(itemView);

            txtRedevenvelopPriceCurrency = itemView.findViewById(R.id.txt_redevenvelop_price_currency);
            txtRedevenvelopPriceAmount = itemView.findViewById(R.id.txt_redevenvelop_price_amount);
            txtRedevenvelopPriceTitle = itemView.findViewById(R.id.txt_redevenvelop_price_title);
            btnRedevenvelopReceiver = itemView.findViewById(R.id.btn_redevenvelop_receiver);
            txtRedevenvelopContent = itemView.findViewById(R.id.txt_redevenvelop_content);
            txtRedevenvelopValidPeriod = itemView.findViewById(R.id.txt_redevenvelop_valid_period);
            expandableTextView = itemView.findViewById(R.id.etxt_redevenvelop_limitRules);
        }
    }
}
