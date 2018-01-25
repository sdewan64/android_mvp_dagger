package com.shaheed.androidmvpdaggertest.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.shaheed.androidmvpdaggertest.MvpApp;
import com.shaheed.androidmvpdaggertest.R;
import com.shaheed.androidmvpdaggertest.di.component.ActivityComponent;
import com.shaheed.androidmvpdaggertest.di.component.DaggerActivityComponent;
import com.shaheed.androidmvpdaggertest.di.module.ActivityModule;
import com.shaheed.androidmvpdaggertest.utils.CommonUtils;
import com.shaheed.androidmvpdaggertest.utils.MessageType;
import com.shaheed.androidmvpdaggertest.utils.NetworkUtils;

import butterknife.Unbinder;

/**
 * Created by shaheed on 1/25/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    private ProgressDialog mProgressDialog;
    private ActivityComponent mActivityComponent;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApp) getApplication()).getComponent())
                .build();

    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void showMessage(MessageType type, String message) {
        if (message != null) {
            if (type == MessageType.SUCCESS || type == MessageType.UNDEFINED) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            } else {
                showSnackBar(getString(R.string.error_global));
            }
        } else {
            showSnackBar(getString(R.string.error_global));
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    public  ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    public void setUnbinder(Unbinder unbinder) {
        mUnbinder = unbinder;
    }

    public abstract void setUp();
    public abstract void onNetworkConnected();
}
