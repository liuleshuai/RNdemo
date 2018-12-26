package com.awesomeproject;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.awesomeproject.rn.RNReactNativeHost;
import com.facebook.react.ReactApplication;

import com.facebook.react.ReactNativeHost;
import com.facebook.soloader.SoLoader;

public class MainApplication extends Application implements ReactApplication {
    private static MainApplication instance;

    public static MainApplication getInstance() {
        return instance;
    }

    public RNReactNativeHost mReactNativeHost;

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
        instance = this;
        mReactNativeHost = new RNReactNativeHost(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    /**
     * 设置统一名称
     */
    public String getModuleName() {
        return "AwesomeProject";
    }
}
