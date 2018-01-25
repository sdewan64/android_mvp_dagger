package com.shaheed.androidmvpdaggertest.ui.base;

/**
 * Created by shaheed on 1/25/18.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

}
