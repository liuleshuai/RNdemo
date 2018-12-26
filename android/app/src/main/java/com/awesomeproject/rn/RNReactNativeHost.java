package com.awesomeproject.rn;

import android.app.Application;

import com.awesomeproject.BuildConfig;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

public class RNReactNativeHost extends ReactNativeHost {
    private List<ReactPackage> reactPackageList;

    public RNReactNativeHost(Application application) {
        super(application);
    }

    @Nullable
    @Override
    public String getJSBundleFile() {
        return super.getJSBundleFile();
    }

    @Override
    public boolean getUseDeveloperSupport() {
        //此处必须是gradle中的
        return BuildConfig.debug;
    }

    @Override
    public List<ReactPackage> getPackages() {
        reactPackageList = Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new CommonPackage()
        );
        return reactPackageList;
    }

    @Override
    protected String getJSMainModuleName() {
        return "index";
    }
}
