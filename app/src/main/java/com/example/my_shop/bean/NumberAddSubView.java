package com.example.my_shop.bean;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.my_shop.R;

public class NumberAddSubView extends LinearLayout {
    private Button btnAdd;
    private Button btnSub;
    private TextView txtValue;

    private int value;
    private int maxValue;
    private int minValue;
    private int defaultValue;

    private LayoutInflater inflater;
    private View view;

    public NumberAddSubView(Context context) {
        this(context, null);
    }

    public NumberAddSubView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberAddSubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.view_number_add_sub, this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NumberAddSubView);
        maxValue = typedArray.getInteger(R.styleable.NumberAddSubView_max_value, Integer.MAX_VALUE);
        minValue = typedArray.getInteger(R.styleable.NumberAddSubView_min_value, 0);
        defaultValue = typedArray.getInteger(R.styleable.NumberAddSubView_default_value, 1);

        typedArray.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initView();
        initData();
    }

    private void initData() {
        setTxtValue(defaultValue);
    }

    private void initView() {
        btnAdd = view.findViewById(R.id.btn_add);
        btnSub = view.findViewById(R.id.btn_sub);
        txtValue = view.findViewById(R.id.txt_show_value);
    }

    public void setOnClickListeners(final INumberAddSubOnClickListener iNumberAddSubOnClickListener) {
        btnAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iNumberAddSubOnClickListener.addOnClickListener();
            }
        });

        btnSub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                iNumberAddSubOnClickListener.subOnClickListener();
            }
        });
    }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; setTxtValue(this.value); }

    public void setValue(String value) { this.value = Integer.valueOf(value); setTxtValue(this.value); }

    private void setTxtValue(int value) {
        txtValue.setText(value + "");
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    interface INumberAddSubOnClickListener {
        void addOnClickListener();
        void subOnClickListener();
    }
}
