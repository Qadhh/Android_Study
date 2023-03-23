package com.example.lib_core_mvp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lib_core_mvp.presenter.MvpPresenter;
import com.example.lib_core_mvp.view.MvpView;

public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {
    private P mPresenter;

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
        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initialize();

    }

    /**
     * 做一些窗口的设置
     */
    protected abstract void initWindow();

    /**
     * 获取布局资源文件
     */
    public abstract int getLayoutId();

    /**
     * 子类通过调用该方法，获得绑定的presenter
     */
    protected P getPresenter() {
        if (mPresenter == null) {
            mPresenter = createPresenter();
            mPresenter.attachView(this);
        }
        return mPresenter;
    }

    protected void initialize() {
        initView();
        loadData();
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 绑定数据
     */
    protected abstract void loadData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.destroy();
            mPresenter = null;
        }
    }

    @NonNull
    public abstract P createPresenter();

    protected Activity getActivity() {
        return this;
    }

}
