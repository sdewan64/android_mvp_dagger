package com.shaheed.androidmvpdaggertest.ui.main;

import com.shaheed.androidmvpdaggertest.di.PerActivity;
import com.shaheed.androidmvpdaggertest.ui.base.MvpPresenter;

/**
 * Created by shaheed on 1/25/18.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onLoginClick(String email, String password);

}
