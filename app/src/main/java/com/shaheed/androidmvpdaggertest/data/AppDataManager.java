package com.shaheed.androidmvpdaggertest.data;

import android.content.Context;

import com.shaheed.androidmvpdaggertest.data.prefs.SharedPreferenceHelper;
import com.shaheed.androidmvpdaggertest.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by shaheed on 1/25/18.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = AppDataManager.class.getSimpleName();

    private final Context mContext;
    private final SharedPreferenceHelper mSharedPreferenceHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          SharedPreferenceHelper sharedPreferenceHelper
                          ) {
        mContext = context;
        mSharedPreferenceHelper = sharedPreferenceHelper;
    }

    @Override
    public long getUserId() {
        return mSharedPreferenceHelper.getUserId();
    }

    @Override
    public void setUserId(long id) {
        mSharedPreferenceHelper.setUserId(id);
    }

    @Override
    public boolean isUserLoggedIn() {
        return mSharedPreferenceHelper.getUserId() != 0;
    }
}
