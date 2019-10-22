package com.example.my_shop.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_shop.R;
import com.example.my_shop.adapter.RedEnvelopInfoAdapter;
import com.example.my_shop.bean.Page;
import com.example.my_shop.bean.RedEnvelopeInfo;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class RedEnvelopeDialog extends Dialog {
    private Context context;//上下文

    private RedEnvelopeInfo redEnvelopeInfo;

    private View redEnvelopeDialogView;

    private TextView txtRedevenvelopDialogTitle;     //红包
    private Button btnRedevenvelopDialogClose;
    private TextView txtRedevenvelopDialogDesc;   //先领红包，更优惠～
    private RecyclerView redevenvelopDialogInfoList;

    public RedEnvelopeDialog(@NonNull Context context, int themeResId, RedEnvelopeInfo redEnvelopeInfo) {
        super(context, themeResId);

        this.context = context;
        this.redEnvelopeInfo = redEnvelopeInfo;
        initRedEnvelopeDialogViews(themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //提前设置Dialog的一些样式
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER);//设置dialog显示居中
        //dialogWindow.setWindowAnimations();设置动画效果

        Window window=this.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //  设置一些dialog在屏幕中显示位置与大小的参数
        WindowManager windowManager = ((Activity)context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = display.getWidth();          // 设置dialog宽度为屏幕的宽
        lp.height = display.getHeight()*3/5;    // 设置dialog宽度为屏幕的宽
        lp.y = 200;
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(false);        //点击外部Dialog消失

        setRedEnvelopeDialogViewInfo();
        setRedEnvelopeDialogViewListener();
        setContentView(redEnvelopeDialogView);
    }

    private void initRedEnvelopeDialogViews(int themeResId) {
        redEnvelopeDialogView = LayoutInflater.from(context).inflate(themeResId, new LinearLayout(context));

        txtRedevenvelopDialogTitle = redEnvelopeDialogView.findViewById(R.id.txt_redevenvelop_dialog_title);
        btnRedevenvelopDialogClose = redEnvelopeDialogView.findViewById(R.id.btn_redevenvelop_dialog_close);
        txtRedevenvelopDialogDesc = redEnvelopeDialogView.findViewById(R.id.txt_redevenvelop_dialog_desc);
        redevenvelopDialogInfoList = redEnvelopeDialogView.findViewById(R.id.recyclerView_redevenvelop_dialog_infos);
    }

    private void setRedEnvelopeDialogViewInfo() {
        txtRedevenvelopDialogTitle.setText(redEnvelopeInfo.getContent().getTitle());
        txtRedevenvelopDialogDesc.setText(redEnvelopeInfo.getContent().getDesc());
        List<RedEnvelopeInfo.ContentBean.ListBean.ItemsBean> itemsBeanList = redEnvelopeInfo.getContent().getList().get(0).items;

        RedEnvelopInfoAdapter redEnvelopInfoAdapter = new RedEnvelopInfoAdapter(context, itemsBeanList);
        redevenvelopDialogInfoList.setAdapter(redEnvelopInfoAdapter);
        redevenvelopDialogInfoList.setLayoutManager(new LinearLayoutManager(context));
    }

    private void setRedEnvelopeDialogViewListener() {
        btnRedevenvelopDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "关闭了", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }
}
