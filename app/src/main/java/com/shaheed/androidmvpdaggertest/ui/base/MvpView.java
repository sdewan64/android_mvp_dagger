package com.shaheed.androidmvpdaggertest.ui.base;

import com.shaheed.androidmvpdaggertest.utils.MessageType;

/**
 * Created by shaheed on 1/25/18.
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void showMessage(MessageType type, String message);

    boolean isNetworkConnected();

    void hideKeyboard();

}
