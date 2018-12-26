package com.awesomeproject.rn;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awesomeproject.MainApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class RNBaseFragment extends Fragment implements DefaultHardwareBackBtnHandler {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        init(context);
    }

    private void init(Context context) {
        mReactRootView = new ReactRootView(context);
        if (mReactRootView.getReactInstanceManager() == null) {
            ReactInstanceManagerBuilder builder = ReactInstanceManager.builder()
                    .setApplication(MainApplication.getInstance());
            //服务器
            builder.setBundleAssetName("index.android.bundle");
            builder.setJSMainModulePath("index");
            mReactInstanceManager = builder.addPackages(MainApplication.getInstance().mReactNativeHost.getPackages())
                    .setUseDeveloperSupport(MainApplication.getInstance().mReactNativeHost.getUseDeveloperSupport())
                    .setInitialLifecycleState(LifecycleState.BEFORE_RESUME)
                    .build();
            mReactRootView.startReactApplication(mReactInstanceManager, getModuleName(), null);
            mReactInstanceManager.onHostResume(getActivity(), this);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return mReactRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    protected abstract String getModuleName();
}
