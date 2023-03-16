package com.example.android_study.application;

import android.app.Application;
import android.content.Context;

public class StudyAndroidApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }
}
