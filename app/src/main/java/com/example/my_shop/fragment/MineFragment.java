package com.example.my_shop.fragment;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.my_shop.R;
import com.example.my_shop.acvitity.AniActivity;
import com.example.my_shop.acvitity.DemoPathActivity;
import com.example.my_shop.acvitity.HouseListActivity;
import com.example.my_shop.bean.HouseListJson;
import com.example.my_shop.bean.RedEnvelopeInfo;
import com.example.my_shop.bean.TextModel;
import com.example.my_shop.view.ExpandableTextView;
import com.example.my_shop.view.RedEnvelopeDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import static android.support.constraint.Constraints.TAG;

public class MineFragment extends Fragment {
    private View view;

    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, container, false);

        button = view.findViewById(R.id.btn_get_red_envelope);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DemoPathActivity.class);
                startActivity(intent);
//                Intent intent = new Intent(getActivity().getApplicationContext(), AniActivity.class);
//                startActivity(intent);
//                Toast toast = Toast.makeText(getActivity(), "这是一个测试", Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
//                Log.d("", "pinghu:shu");

                String houseInfoStr = getJson("Test.json");
                Type type = new TypeToken<TextModel>(){}.getType();
                TextModel TextModel = new Gson().fromJson(houseInfoStr, type);
                Log.d(TAG, "onClick: pinghu:wancheng");
            }
        });

//        final EditText ed = view.findViewById(R.id.text);
//        ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if (b && !false) {
//                        Log.d(TAG, "onFocusChange:pinghu: ed");
//                        showNotCertificationDialog();
//                        ed.setEnabled(false);
//                }
//            }
//        });
//
//        EditText ed1 = view.findViewById(R.id.text_1);
//        ed1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if (b) {
//                    if (!false) {
//                        Log.d(TAG, "onFocusChange:pinghu: ed1");
//                        showNotCertificationDialog();
//                        return;
//                    }
//                }
//            }
//        });
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String redEnvelopeStr = getJson("RedEnvelope.json");
//                Log.d(TAG, "onCreate: pinghu:json:" + redEnvelopeStr);
//
//                Type type = new TypeToken<RedEnvelopeInfo>() {}.getType();
//                RedEnvelopeInfo redEnvelopeInfo = new Gson().fromJson(redEnvelopeStr, type);
//
//                new RedEnvelopeDialog(getActivity(), R.layout.view_redenvelope_dialog, redEnvelopeInfo).show();
//            }
//        });

//        final ExpandableTextView test = view.findViewById(R.id.ceshi);
//        if (test != null) {
//            test.setText("1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用\\n2、一次性使用，抵扣定金后的余额不能再使用\\n3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面");
//            test.setButtonOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    test.expandable(!test.isExpandable());
//                }
//            });
//        }

        return view;
    }

    private void showNotCertificationDialog() {
        Log.d(TAG, "showNotCertificationDialog:pinghu: 显示了一个dialog");
    }
    private String getJson(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assets = getActivity().getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assets.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    private void startChatActivity(boolean isC2C) {
//        Bundle bundle = new Bundle();
//        bundle.putLong(com.tujia.messagemodule.im.config.Constants.EXTRA_UNIT_ID, 14011390);
//        bundle.putString(com.tujia.messagemodule.im.config.Constants.EXTRA_UNIT_NAME, "Loft婚纱主题朝阳大悦城巨幕投影房机场");
//        bundle.putString(com.tujia.messagemodule.im.config.Constants.EXTRA_UNIT_LINK, "https://go.tujia.com/1054/?id=14011390&uid=14011390&tjmcode=6");
//        bundle.putString(com.tujia.messagemodule.im.config.Constants.EXTRA_UNIT_PIC, "https://pic.tujia.com/upload/landlordunit/day_190730/thumb/201907301719417822_700_467.jpg");
////
////        // TODO: 2019-05-13 房屋详情页缺少houseDetailModel.getHouseTypeName()字段
//        String descStr = "";
//        /*String descStr = (StringUtil.isNotEmpty(houseDetailModel.getHouseTypeName()) ? houseDetailModel.getHouseTypeName() + " " : "") +
//                (houseDetailModel.imSummary.houseSummary.recommendedGuests > 0 ? "宜住" + houseDetailModel.imSummary.houseSummary.recommendedGuests + "人" : "");*/
//
//        bundle.putString(com.tujia.messagemodule.im.config.Constants.EXTRA_UNIT_DESC, descStr);
//        bundle.putString(com.tujia.messagemodule.im.config.Constants.EXTRA_ACCOUNT, String.valueOf(39443613));
//        bundle.putInt(TeamChatUtil.KEY_CHAT_SESSION_TYPE, 0);
//        bundle.putString(TeamChatUtil.KEY_CHAT_TEAM_ID, "");
//        bundle.putInt(SyncStateContract.Constants.EXTRA_IM_GUIDANCE_PEOPLE, 0);
//        bundle.putBoolean(SyncStateContract.Constants.EXTRA_FROMPROMOTION, false);
//        bundle.putString("activity_info", null);
//        bundle.putLong("extra_product_id", 0);
//        bundle.putInt(com.tujia.messagemodule.im.config.Constants.EXTRA_HOTEL_ID, 5313372);
//        bundle.putInt("EXTRA_HOTEL_ID", 5313372);
//
//        bundle.putBoolean(SyncStateContract.Constants.EXTRA_IM_GUIDANCE, false);
//        Intent intent = new Intent(this, );
//        intent.putExtras(bundle);
//        startActivity(intent);
    }
}
