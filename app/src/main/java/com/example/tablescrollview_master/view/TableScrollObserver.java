package com.example.tablescrollview_master.view;

/**
 * Created by ZhangXinmin on 2018/1/8.
 * Copyright (c) 2018 . All rights reserved.
 */

public abstract class TableScrollObserver {
    /**
     * This is called in response to an internal horizontal scroll in this view (i.e., the
     * view scrolled its own contents).
     *
     * @param l    Current horizontal scroll origin.
     * @param t    Current vertical scroll origin.
     * @param oldl Previous horizontal scroll origin.
     * @param oldt Previous vertical scroll origin.
     */
   public void onScrollChanged(int l, int t, int oldl, int oldt) {

    }
}
