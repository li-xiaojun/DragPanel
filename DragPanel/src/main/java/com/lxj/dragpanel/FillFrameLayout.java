package com.lxj.dragpanel;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by hhkx01 on 2018/8/18.
 */

public class FillFrameLayout extends FrameLayout {
    public FillFrameLayout(@NonNull Context context) {
        super(context);
    }

    public FillFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FillFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxheight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            if(v.getVisibility()==GONE)continue;
            measureChild(v, widthMeasureSpec, heightMeasureSpec);

            ViewGroup.MarginLayoutParams params = (MarginLayoutParams) v.getLayoutParams();
            int totalHeight = v.getMeasuredHeight() + params.topMargin + params.bottomMargin;
            maxheight = Math.max(maxheight, totalHeight);
        }
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), maxheight);
    }
}
