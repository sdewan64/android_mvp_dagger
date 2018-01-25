package com.shaheed.androidmvpdaggertest;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.shaheed.androidmvpdaggertest.data.DataManager;
import com.shaheed.androidmvpdaggertest.di.component.ApplicationComponent;
import com.shaheed.androidmvpdaggertest.di.component.DaggerApplicationComponent;
import com.shaheed.androidmvpdaggertest.di.module.ApplicationModule;
import com.shaheed.androidmvpdaggertest.utils.AppLogger;

import javax.inject.Inject;

/**
 * Created by shaheed on 1/25/18.
 */

public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    /*
    // Needed if test specific component is required
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }*/
}
