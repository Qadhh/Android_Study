package com.example.lib_core_mvp.util;

import android.util.Log;

public class LogUtil {
    public  static boolean DEBUG ;

    private static final String TAG = "log_tag";

    public static void i(String TAG, String msg) {
        if (DEBUG) {
            Log.i(TAG, getFileLineMethod() + msg);
        }

    }

    public static void i(String msg) {
        if (DEBUG) {
            Log.i(TAG, getFileLineMethod() + msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (DEBUG) {
            Log.d(TAG, getFileLineMethod() + msg);
        }

    }

    public static void d(String msg) {
        if (DEBUG) {
            Log.d(TAG, getFileLineMethod() + msg);
        }
    }

    public static void e(String msg) {
        if (DEBUG) {
            Log.e(TAG, getFileLineMethod() + msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (DEBUG) {
            Log.e(TAG, getFileLineMethod() + msg);
        }
    }

    public static void v(String msg) {

        Log.i(TAG, msg);
    }

    public static void v(String TAG, String msg) {
        Log.i(TAG, msg);
    }

    public static void w(String msg) {
        Log.w(TAG, msg);
    }

    public static void w(String TAG, String msg) {
        Log.w(TAG, msg);
    }

    /**
     * [当前线程名][调用处方法名(调用处文件及行号)]
     * <p>
     * 可以直观看到调用所在的线程
     * 可以直接点击跳转到打印处
     */
    public static String getFileLineMethod() {
        Thread thread = Thread.currentThread();
        StackTraceElement traceElement = thread.getStackTrace()[4];
        return "[" + thread.getName() + "][" +
                traceElement.getMethodName() + "(" +
                traceElement.getFileName() + ":" +
                traceElement.getLineNumber() + ")" +
                "] ";
    }
}