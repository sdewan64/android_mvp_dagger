package com.shaheed.androidmvpdaggertest.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.shaheed.androidmvpdaggertest.di.ActivityContext;
import com.shaheed.androidmvpdaggertest.di.PerActivity;
import com.shaheed.androidmvpdaggertest.ui.main.MainMvpPresenter;
import com.shaheed.androidmvpdaggertest.ui.main.MainMvpView;
import com.shaheed.androidmvpdaggertest.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shaheed on 1/25/18.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mAppCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.mAppCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mAppCompatActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mAppCompatActivity;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

}
