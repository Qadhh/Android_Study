package com.example.android_study.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_study.mvp.MvpPresenter;
import com.example.android_study.mvp.MvpView;

public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {
    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        presenter = initPresenter();
        if (presenter != null)
            presenter.attach(this);
        initialize();

    }

    protected void initialize() {
        initView();
        loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }


    @Override
    public Context getContext() {
        return getActivity();
    }

    /**
     * 获取布局资源文件
     */
    public abstract int getLayoutId();

    /**
     * 初始化presenter
     */
    protected abstract P initPresenter();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 绑定数据
     */
    protected abstract void loadData();

    protected Activity getActivity() {
        return this;
    }
}
