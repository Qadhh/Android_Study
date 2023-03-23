package com.example.lib_core_mvp.util;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.MainThread;

import java.lang.ref.WeakReference;

public class ToastUtils {

    private static WeakReference<Toast> sToast;

    @MainThread
    public static void show(Context context, CharSequence text, int duration) {
        if (sToast != null && sToast.get() != null) {
            sToast.get().cancel();
        }
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        sToast = new WeakReference<>(toast);
    }
}

