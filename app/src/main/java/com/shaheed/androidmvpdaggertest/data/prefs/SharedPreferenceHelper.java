package com.shaheed.androidmvpdaggertest.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.shaheed.androidmvpdaggertest.di.ApplicationContext;
import com.shaheed.androidmvpdaggertest.di.SharedPreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by shaheed on 1/25/18.
 */

@Singleton
public class SharedPreferenceHelper implements SharedPreference {

    private static final String PREF_USER_ID = "PREF_USER_ID";

    private final SharedPreferences mSharedPreferences;

    @Inject
    public SharedPreferenceHelper(@ApplicationContext Context context,
                                  @SharedPreferenceInfo String sharedPreferenceName
                                 ) {
        mSharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
    }

    @Override
    public long getUserId() {
        return mSharedPreferences.getLong(PREF_USER_ID, 0);
    }

    @Override
    public void setUserId(long id) {
        mSharedPreferences.edit().putLong(PREF_USER_ID, id).apply();
    }
}
