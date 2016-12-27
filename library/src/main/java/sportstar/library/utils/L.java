package sportstar.library.utils;

import android.util.Log;

/**
 * Print Log
 *
 */
public class L {
    public static boolean deBug = true;
    public static String TAG = "Edwin";

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
