package com.example.tablescrollview_master.view;

import android.support.annotation.NonNull;

import com.example.tablescrollview_master.util.LogUtils;

import java.util.ArrayList;

/**
 * Created by ZhangXinmin on 2018/1/8.
 * Copyright (c) 2018 . All rights reserved.
 * <p>
 * Provides methods for registering or unregistering arbitrary observers in an {@link ArrayList}.
 * <p>
 * This abstract class is intended to be subclassed and specialized to maintain
 * a registry of observers of specific types and dispatch notifications to them.
 */

public abstract class ScrollObservable<T> {
    private static final String TAG = ScrollObservable.class.getSimpleName();

    /**
     * The list of observers.  An observer can be in the list at most
     * once and will never be null.
     */
    protected final ArrayList<T> mObservers = new ArrayList<>();

    /**
     * Adds an observer to the list. The observer cannot be null and it must not already
     * be registered.
     *
     * @param observer the observer to register
     * @throws IllegalStateException the observer is already registered
     */
    public void registerObserver(@NonNull T observer) {

        synchronized (mObservers) {
            if (mObservers.contains(observer)) {
                LogUtils.logE(TAG, "Observer " + observer + " is already registered.");
                return;
            }
            mObservers.add(observer);
        }
    }

    /**
     * Removes a previously registered observer. The observer must not be null and it
     * must already have been registered.
     *
     * @param observer the observer to unregister
     */
    public void unregisterObserver(@NonNull T observer) {
        synchronized (mObservers) {
            int index = mObservers.indexOf(observer);
            if (index == -1) {
                LogUtils.logE(TAG, "Observer " + observer + " was not registered.");
                return;
            }
            mObservers.remove(index);
        }
    }

    /**
     * Remove all registered observers.
     */
    public void unregisterAll() {
        synchronized (mObservers) {
            mObservers.clear();
        }
    }

}
