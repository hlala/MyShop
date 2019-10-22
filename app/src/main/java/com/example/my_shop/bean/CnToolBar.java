package com.example.my_shop.bean;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.my_shop.R;

public class CnToolBar extends Toolbar {
    private View view;

    private ImageButton ibtnBack;
    private TextView txtTitle;
    private EditText etxtSearch;

    public CnToolBar(Context context) {
        this(context, null);
    }

    public CnToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CnToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initCnToolBar();
    }

    private void initCnToolBar() {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        view = inflater.inflate(R.layout.toolbar, null);

        ibtnBack = view.findViewById(R.id.ibtn_back);
        txtTitle = view.findViewById(R.id.txt_title);
        etxtSearch = view.findViewById(R.id.etxt_search);

        //  在这里可以对这些控件做某些操作
    }

    /**
     * 这是对标题进行设置，当然依次类推可以对ToolBar内任意的控件属性进行编写
     * @param title
     */
    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    public void setTitle(int titleId) {
        txtTitle.setText(titleId);
    }

    public void setSearchOnClickListener(OnClickListener onClickListener) {
        etxtSearch.setOnClickListener(onClickListener);
    }
}
