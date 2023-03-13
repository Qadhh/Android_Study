package com.example.android_study.mvp;

import android.content.Context;


public interface MvpView {
    void showArticleSuccess();

    void showArticleFail();

    Context getContext();
}
