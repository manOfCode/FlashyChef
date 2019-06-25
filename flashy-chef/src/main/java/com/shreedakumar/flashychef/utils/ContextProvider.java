package com.shreedakumar.flashychef.utils;

import android.app.Application;
import android.content.Context;

public class ContextProvider extends Application {
    private static ContextProvider instance;

    public static ContextProvider getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
        // or return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
