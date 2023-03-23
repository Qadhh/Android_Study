package com.example.lib_core_mvp.presenter;

import android.app.Activity;

import com.example.lib_core_mvp.view.MvpView;

public interface MvpPresenter<V extends MvpView> {
    /**
     * 调用在attachView(V view)之后，该方法被调用后，说明绑定的View已经初始化完毕了，
     * 可以安全的使用getView()调用View的各个方法了
     * 约定:</b>每个presenter在调其他业务方法之前，start()必须调用至少一次
     * 做一些初始化操作
     */
    void start();

    void attachView(V view);

    void detachView();

    /**
     * 在框架中 {@link Activity#onDestroy()} 时会默认调用 {@link IPresenter#onDestroy()}
     */
    void destroy();
}
