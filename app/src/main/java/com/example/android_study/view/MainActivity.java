package com.example.android_study.view;

import com.example.android_study.R;
import com.example.android_study.mvp.MvpActivity;
import com.example.android_study.presenter.MainPresenter;

public class MainActivity extends MvpActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showArticleSuccess() {

    }

    @Override
    public void showArticleFail() {

    }
}