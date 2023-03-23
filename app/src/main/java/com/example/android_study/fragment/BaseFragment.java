package com.example.android_study.fragment;


import com.example.android_study.view.HomeView;
import com.example.lib_core_mvp.fragment.MvpFragment;
import com.example.lib_core_mvp.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter<HomeView>> extends MvpFragment {
    public Unbinder mUnbinder = null;


    @Override
    public void initialize() {
        mUnbinder = ButterKnife.bind(this, getmRootView());
        super.initialize();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
