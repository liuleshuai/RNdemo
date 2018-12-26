package com.awesomeproject.rn;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommonModule extends ReactContextBaseJavaModule {
    private ReactApplicationContext mContext;

    public static final String EVENT_NAME = "nativeCallRn";
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public CommonModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
    }

    /**
     * 主动传递
     * Native调用RN
     */
    public void nativeCallRn(String msg) {
        mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(EVENT_NAME, msg);
    }

    /**
     * 主动传递
     * Native调用RN
     */
    public void sendEvent(Bundle bundle) {
        if (bundle != null) {
            Set<String> keySet = bundle.keySet();
            WritableMap map = Arguments.createMap();
            for (String key : keySet) {
                map.putString(key, bundle.get(key) + "");
            }

            if (mContext.hasActiveCatalystInstance()) {
                mContext
                        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit("EventReminder", map);
            }
        }
    }

    /**
     * Callback 方式
     * rn调用Native,并获取返回值
     *
     * @param msg
     * @param callback
     */
    @ReactMethod
    public void rnCallNativeFromCallback(String msg, Callback callback) {
        Log.e("lk ----", "rnCallNativeFromCallback");
        // 1.处理业务逻辑...
        String result = "处理结果：" + msg;
        // 2.回调RN,即将处理结果返回给RN
        callback.invoke(result);
    }

    /**
     * Promise
     *
     * @param msg
     * @param promise
     */
    @ReactMethod
    public void rnCallNativeFromPromise(String msg, Promise promise) {
        Log.e("lk ----", "rnCallNativeFromPromise");
        // 1.处理业务逻辑...
        String result = "处理结果：" + msg;
        // 2.回调RN,即将处理结果返回给RN
        promise.resolve(result);
    }

    /**
     * 向RN传递常量  返回了需要导出给JavaScript使用的常量
     */
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        //客户端类型
        constants.put("c", "Android");
        //包名
        constants.put("p", "mingonghui");
        //日志级别
        constants.put("l", "erro");
        //硬件型号
        constants.put("d", android.os.Build.MODEL);
        //系统版本号
        constants.put("s", android.os.Build.VERSION.RELEASE);
        return constants;
    }

    /**
     * 对象转化成map
     *
     * @param promise
     * @param object
     */
    public void resolveObjectToMap(Promise promise, Object object) {
        WritableMap map = Arguments.createMap();
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (null != value) {
                    map.putString(field.getName(), String.valueOf(value));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        promise.resolve(map);
    }

    /**
     * map转换成对象
     *
     * @param map
     * @param obj
     */
    public Object resolveMapToObject(ReadableMap map, Object obj) {
        if (map == null) {
            return null;
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            try {
                field.set(obj, map.getString(field.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }


    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
        nativeCallRn("原生-->RN");
    }

    /**
     * 用于返回一个字符串名字,就是js中的模块名
     */
    @Override
    public String getName() {
        return "CommonModule";
    }
}
