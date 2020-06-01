package com.udacity.xyzreader;

import android.app.Application;

import timber.log.Timber;

public class XYZApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
