package com.example.android_study.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.android_study.presenter.UserArticlePresenter;

public class UserArticleFragment extends MvpFragment<UserArticlePresenter> {

    private TextView mTextView;

    public static UserArticleFragment create() {
        return new UserArticleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mTextView = new TextView(getActivity());
        mTextView.setText("广场");
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setTextSize(22);

        return mTextView;
    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected UserArticlePresenter initPresenter() {
        return new UserArticlePresenter();
    }

    @Override
    protected void loadData() {

    }
}
