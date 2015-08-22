package com.hujiao.hujiao;

import android.app.Application;
import android.content.res.Configuration;

import com.hujiao.hujiao.util.ExceptionHandler;
import com.hujiao.hujiao.util.MyUtil;

/**
 * Created by hukunge on 2015/8/22.
 */
public class App extends Application{

    private static App instance;

    public static App getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        init();
    }

    private void init() {
        MyUtil.initImageLoader();
        ExceptionHandler.getInstence(instance);
    }


}
