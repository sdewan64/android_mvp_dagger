package com.shaheed.androidmvpdaggertest.di.component;

import com.shaheed.androidmvpdaggertest.di.PerActivity;
import com.shaheed.androidmvpdaggertest.di.module.ActivityModule;
import com.shaheed.androidmvpdaggertest.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by shaheed on 1/25/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
