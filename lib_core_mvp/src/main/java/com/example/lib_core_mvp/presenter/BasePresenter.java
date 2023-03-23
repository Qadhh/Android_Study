package com.example.lib_core_mvp.presenter;

import android.content.Context;

import com.example.lib_core_mvp.view.MvpView;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    protected Context context;
    private WeakReference<V> viewRef;

    @Override
    public void start() {

    }

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<>(view);
        context = view.getContext();
    }

    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    /*
     * 每次调用业务请求的时候 即：getView().showXxx();时
     * 请先调用方法检查是否与View建立连接，没有则可能会空指针异常
     */
    public final boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        if (isViewAttached()) {
            detachView();
        }
    }
}
