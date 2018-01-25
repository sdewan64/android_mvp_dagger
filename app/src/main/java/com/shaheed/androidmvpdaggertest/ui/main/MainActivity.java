package com.shaheed.androidmvpdaggertest.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.shaheed.androidmvpdaggertest.R;
import com.shaheed.androidmvpdaggertest.ui.base.BaseActivity;
import com.shaheed.androidmvpdaggertest.utils.MessageType;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.activityMain_editText_userName)
    EditText mEditTextUserName;
    @BindView(R.id.activityMain_editText_password)
    EditText mEditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        setUnbinder(ButterKnife.bind(this));
        mPresenter.onAttach(MainActivity.this);
    }

    @OnClick(R.id.activityMain_button_login)
    void onLoginClick(View v) {
        mPresenter.onLoginClick(mEditTextUserName.getText().toString(),
                mEditTextPassword.getText().toString());
    }

    @Override
    public void showLoginStatus() {
        showMessage(MessageType.SUCCESS, "SUCCESS");
    }

    @Override
    public void setUp() {
        Log.i(TAG, "setUp");
    }

    @Override
    public void onNetworkConnected() {
        Log.i(TAG, "onNetworkConnected");
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
