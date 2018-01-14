package com.example.tablescrollview_master.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.example.tablescrollview_master.util.LogUtils;

/**
 * Created by ZhangXinmin on 2018/1/9.
 * Copyright (c) 2018 . All rights reserved.
 */

public class SimpleLinearLayout extends LinearLayout {
    private static final String TAG = SimpleLinearLayout.class.getSimpleName();

    public SimpleLinearLayout(Context context) {
        super(context);
    }

    public SimpleLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtils.logI(TAG, "onInterceptTouchEvent");
        return true;
    }
}
