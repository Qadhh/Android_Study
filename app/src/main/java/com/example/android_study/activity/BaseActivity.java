package com.example.android_study.activity;

import com.example.lib_core_mvp.activity.MvpActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends MvpActivity {

    public Unbinder mUnbinder = null;

    @Override
    protected void initialize() {
        mUnbinder = ButterKnife.bind(this);
        super.initialize();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
