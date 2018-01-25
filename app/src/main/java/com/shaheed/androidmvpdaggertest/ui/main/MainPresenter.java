package com.shaheed.androidmvpdaggertest.ui.main;

import com.shaheed.androidmvpdaggertest.data.DataManager;
import com.shaheed.androidmvpdaggertest.ui.base.BasePresenter;
import com.shaheed.androidmvpdaggertest.utils.CommonUtils;
import com.shaheed.androidmvpdaggertest.utils.MessageType;

import javax.inject.Inject;

/**
 * Created by shaheed on 1/25/18.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    private static final String TAG = MainPresenter.class.getSimpleName();

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onLoginClick(String email, String password) {
        getMvpView().hideKeyboard();

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            getMvpView().showMessage(MessageType.ERROR, "Something is missing");
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
           getMvpView().showMessage(MessageType.ERROR, "Email is invalid");
           return;
        }

        getMvpView().showLoading();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getMvpView().hideLoading();
                getMvpView().showLoginStatus();
            }
        }, 3000);
    }
}
