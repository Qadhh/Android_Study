package com.example.lib_core_mvp.view;

import android.content.Context;

public interface MvpView {
    void showToast(String message);

    void succeed();

    void error();

    Context getContext();
}
