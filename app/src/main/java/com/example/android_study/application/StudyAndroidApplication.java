package com.example.android_study.application;

import android.app.Application;
import android.content.Context;

import com.example.lib_core_mvp.util.LogUtil;

public class StudyAndroidApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //log 开关
        LogUtil.DEBUG =true;
    }
}
