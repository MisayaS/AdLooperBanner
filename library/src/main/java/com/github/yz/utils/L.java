package com.github.yz.utils;

import android.util.Log;

/**
 * Print Log
 */
public class L {
    public static boolean deBug = false;
    public static String TAG = "yorki";

    public static void e(String msg) {
        if (deBug)
            Log.e(TAG, msg);
    }

    public static void e(String TAG, String msg) {
        if (deBug)
            Log.e(TAG, msg);
    }

    public static void e(String TAG, Throwable tr) {
        if (deBug)
            Log.e(TAG, "Error——", tr);
    }

    public static void e(String TAG, String msg, Throwable tr) {
        if (deBug)
            Log.e(TAG, msg, tr);
    }
}
