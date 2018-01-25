package com.shaheed.androidmvpdaggertest.di.component;

import android.app.Application;
import android.content.Context;

import com.shaheed.androidmvpdaggertest.MvpApp;
import com.shaheed.androidmvpdaggertest.data.DataManager;
import com.shaheed.androidmvpdaggertest.di.ApplicationContext;
import com.shaheed.androidmvpdaggertest.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shaheed on 1/25/18.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
