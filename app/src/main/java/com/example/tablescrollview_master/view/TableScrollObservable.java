package com.example.tablescrollview_master.view;

/**
 * Created by ZhangXinmin on 2018/1/9.
 * Copyright (c) 2018 . All rights reserved.
 */

public class TableScrollObservable extends ScrollObservable<TableScrollObserver> {

    private static final String TAG = TableScrollObservable.class.getSimpleName();

    /**
     * Invokes {@link TableScrollObserver#onScrollChanged(int, int, int, int)} on each observer.
     * Called when occured an internal horizontal scroll in this view.
     */
    public void notifyOnScrollChanged(int l, int t, int oldl, int oldt) {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onScrollChanged(l, t, oldl, oldt);
            }
        }
    }
}
