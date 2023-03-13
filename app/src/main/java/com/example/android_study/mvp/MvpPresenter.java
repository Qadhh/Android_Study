package com.example.android_study.mvp;


import android.content.Context;


public abstract class MvpPresenter<V extends MvpView> {
    protected Context context;
    private V view;

    public V getView() {
        return view;
    }

    public Context getContext() {
        return context;
    }

    public void attach(V view) {
        this.view = getView();
        context = view.getContext();

    }


    public void detachView() {
        this.view = null;
        context = null;
    }

}
