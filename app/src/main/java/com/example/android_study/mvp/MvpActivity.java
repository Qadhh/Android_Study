package com.example.android_study.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_study.mvp.MvpPresenter;
import com.example.android_study.mvp.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {
    public P presenter;
    public Unbinder mUnbinder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏   继承AppCompatActivity无效
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//继承AppCompatActivity  去掉标题栏
        /*//去掉状态栏
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }*/
        initWindow();
        setContentView(getLayoutId());
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        mUnbinder = ButterKnife.bind(this);
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
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }


    @Override
    public Context getContext() {
        return getActivity();
    }

    protected abstract void initWindow();

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
