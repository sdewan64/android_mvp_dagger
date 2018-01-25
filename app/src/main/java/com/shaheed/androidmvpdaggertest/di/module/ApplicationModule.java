package com.shaheed.androidmvpdaggertest.di.module;

import android.app.Application;
import android.content.Context;

import com.shaheed.androidmvpdaggertest.data.AppDataManager;
import com.shaheed.androidmvpdaggertest.data.DataManager;
import com.shaheed.androidmvpdaggertest.di.ApplicationContext;
import com.shaheed.androidmvpdaggertest.di.SharedPreferenceInfo;
import com.shaheed.androidmvpdaggertest.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shaheed on 1/25/18.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @SharedPreferenceInfo
    String provideSharedPreferenceName() {
        return AppConstants.SHARED_PREFERENCE_NAME;
    }

}
