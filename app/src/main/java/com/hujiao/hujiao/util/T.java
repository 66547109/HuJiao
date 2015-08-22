package com.hujiao.hujiao.util;

import android.widget.Toast;

import com.hujiao.hujiao.App;

/**
 * Toast相关
 */
public class T {

    /**
     * 短提示
     *
     * @param msg
     */
    public static void s(String msg) {
        Toast.makeText(App.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void l(String msg) {
        Toast.makeText(App.getInstance(), msg, Toast.LENGTH_LONG).show();
    }
}
