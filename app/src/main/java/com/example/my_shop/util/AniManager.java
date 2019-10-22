package com.example.my_shop.util;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static android.support.constraint.Constraints.TAG;

public class AniManager {
    private ViewGroup aniGroup;

    public AniManager() {
    }

    private View init(View image, int[] start_location) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.width = start_location[0];
        layoutParams.height = start_location[1];

        image.setLayoutParams(layoutParams);
        return image;
    }

    public void setAnim(Activity activity, final View img, int[] start_location, int[] end_location) {
        if (aniGroup != null) {
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            decorView.removeView(aniGroup);
        }

        aniGroup = null;
        aniGroup = createAnimLayout(activity);
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();

        View image = init(img, start_location);

        int xoff = end_location[0] - start_location[0];
        int yoff = end_location[1] - start_location[1];
        TranslateAnimation xTranslateAnimation = new TranslateAnimation(0, xoff, 0, 0);
        xTranslateAnimation.setInterpolator(new LinearInterpolator());
        xTranslateAnimation.setRepeatCount(0);
        xTranslateAnimation.setFillAfter(true);

        TranslateAnimation yTranslateAnimation = new TranslateAnimation(0, 0, 0, yoff);
        yTranslateAnimation.setInterpolator(new AccelerateInterpolator());
        yTranslateAnimation.setRepeatCount(0);
        yTranslateAnimation.setFillAfter(true);

        ScaleAnimation animation = new ScaleAnimation(1.0f, 0f, 1.0f, 0f, 0.5f,  0.5f);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(false);
        animationSet.addAnimation(animation);
        animationSet.addAnimation(xTranslateAnimation);
        animationSet.addAnimation(yTranslateAnimation);
        animationSet.setDuration(1000);

        decorView.addView(image);
        image.startAnimation(animationSet);
    }

    private ViewGroup createAnimLayout(Activity activity) {


        return null;
    }
}
