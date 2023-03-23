package com.example.android_study.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_study.presenter.MinePresenter;
import com.example.lib_core_mvp.presenter.MvpPresenter;

public class MineFragment extends BaseFragment<MinePresenter>  {
    public static MineFragment create() {
        return new MineFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView view = new TextView(getActivity());
        view.setText("我的");
        view .setGravity(Gravity.CENTER);
        view .setTextColor(Color.RED);
        return view;
    }

    @Override
    protected MvpPresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void loadData() {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void succeed() {

    }

    @Override
    public void error() {

    }
}
