package com.awesomeproject.rn;


import android.os.Bundle;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonPackage implements ReactPackage {
    public CommonModule mModule;

    public void sendEvent(Bundle bundle) {
        if (mModule != null) {
            mModule.sendEvent(bundle);
        }
    }

    /**
     * 创建Native Module
     *
     * @param reactContext
     * @return
     */
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        mModule = new CommonModule(reactContext);
        modules.add(mModule);
        return modules;
    }


    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }


}
