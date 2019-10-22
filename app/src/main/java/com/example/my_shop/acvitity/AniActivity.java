package com.example.my_shop.acvitity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_shop.R;
import com.example.my_shop.util.AniManager;

public class AniActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AniActivity";

    private TextView top;
    private TextView button;
    private Button target;

    private AniManager aniManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);

        top = findViewById(R.id.img_ani_top);
        button = findViewById(R.id.img_ani_button);
        target = findViewById(R.id.btn_ani_target);

        ImageView a = new ImageView(this);
        a.setImageURI(Uri.parse(""));
        initListener();
    }

    private void initListener() {
        top.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: pinghu:点击了：" + view.toString());
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.unit_card_fav_true);

        int[] end_location = new int[2];
        target.getLocationInWindow(end_location);

        int[] start_location = new int[2];
        if (view == top) {
            top.getLocationInWindow(start_location);
        } else if (view == button) {
            button.getLocationInWindow(start_location);
        }

        if (aniManager == null) {
            aniManager = new AniManager();
        }
        aniManager.setAnim(this, img, start_location, end_location);// 开始执行动画
    }
}
