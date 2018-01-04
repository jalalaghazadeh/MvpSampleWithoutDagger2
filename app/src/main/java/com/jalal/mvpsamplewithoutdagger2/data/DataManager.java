package com.jalal.mvpsamplewithoutdagger2.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;


import com.jalal.mvpsamplewithoutdagger2.data.model.User;


public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    public DataManager(Context context) {
        mContext = context;
        mDbHelper = new DbHelper(mContext, "demo-dagger.db", 2);
        mSharedPrefsHelper = new SharedPrefsHelper(mContext);
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }
}
