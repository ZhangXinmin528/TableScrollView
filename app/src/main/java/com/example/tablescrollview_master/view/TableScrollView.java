package com.example.tablescrollview_master.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

import com.example.tablescrollview_master.util.LogUtils;

/**
 * Created by ZhangXinmin on 2018/1/8.
 * Copyright (c) 2018 . All rights reserved.
 * 双向滑动的列表控件
 */

public class TableScrollView extends HorizontalScrollView {
    private static final String TAG = TableScrollView.class.getSimpleName();

    private final TableScrollObservable mTableScrollObservable = new TableScrollObservable();

    public TableScrollView(Context context) {
        this(context, null, 0);
    }

    public TableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    /**
     * 注册水平滚动监听
     *
     * @param observer
     */
    public void registerHorizontalObserver(@NonNull TableScrollObserver observer) {
        mTableScrollObservable.registerObserver(observer);
    }

    /**
     * 解除注册水平滚动监听
     *
     * @param observer
     */
    public void unregisterHorizontalObserver(@NonNull TableScrollObserver observer) {
        mTableScrollObservable.unregisterObserver(observer);
    }

    public void unregisterAllObserver() {
        mTableScrollObservable.unregisterAll();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LogUtils.logI(TAG + ":onScrollChanged");
        mTableScrollObservable.notifyOnScrollChanged(l, t, oldl, oldt);
        super.onScrollChanged(l, t, oldl, oldt);

    }
}
