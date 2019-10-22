package com.example.my_shop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_shop.R;

import static android.support.constraint.Constraints.TAG;

public class ExpandableTextView extends LinearLayout {
    private Context context;

    private LayoutInflater inflater;
    private View view;

    private TextView textView;
    private ImageButton imageButton;

    private String text;

    /**
     * 默认不展开
     */
    private boolean isExpandable = false;

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;

        inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.view_expandable_text, this);
        textView = view.findViewById(R.id.txt_expand_text);
        imageButton = view.findViewById(R.id.ibtn_expand);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView);
        if (typedArray != null) {
            isExpandable = typedArray.getBoolean(R.styleable.ExpandableTextView_isExpandable, false);
        }

        typedArray.recycle();

        setImageButtonListener();
    }

    public void setText(String text) {
        this.text = text;

        showText();
    }

    /**
     * 根据传递进来的值决定界面是收起还是放下
     * true 收起
     * false 展开
     * @param expandable
     */
    public void expandable(boolean expandable) {
        if (isExpandable == expandable) {
            return;
        }

        this.isExpandable = expandable;
        showText();
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    private void showText() {
        if (textView == null || text == null) {
            return;
        }

        if (isExpandable == false) {
            Toast.makeText(context, "不展开", Toast.LENGTH_SHORT).show();

            int width = textView.getWidth();
            float textSize = textView.getTextSize();
            int res = width - (int) textSize;
            Log.d(TAG, "showText: pinghu:" + width + "-" + textSize + "=" + res);
            textView.setWidth(res);
            textView.setMaxLines(1);
        } else {
            Toast.makeText(context, "展开", Toast.LENGTH_SHORT).show();

            textView.setText(text);
            textView.setMaxLines(20);
        }
    }

    private void setImageButtonListener() {
        imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExpandable == false) {
                    // 原本是不展开的，现在设置为展开的
                    textView.setSingleLine(false);

                    imageButton.setBackgroundResource(R.mipmap.arrow_grey_up);
                    isExpandable = true;
                } else {
                    // 原本是展开的，现在设置为不展开的
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));

                    imageButton.setBackgroundResource(R.mipmap.arrow_down);
                    isExpandable = false;
                }
            }
        });
    }
}
