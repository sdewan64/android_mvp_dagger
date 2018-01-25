package com.shaheed.androidmvpdaggertest.data;

import com.shaheed.androidmvpdaggertest.data.prefs.SharedPreference;

/**
 * Created by shaheed on 1/25/18.
 */

public interface DataManager extends SharedPreference {

    boolean isUserLoggedIn();

}
