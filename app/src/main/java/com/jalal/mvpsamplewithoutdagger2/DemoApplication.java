package com.jalal.mvpsamplewithoutdagger2;

import android.app.Application;
import android.content.Context;


import com.jalal.mvpsamplewithoutdagger2.data.DataManager;

/**
 * Created by janisharali on 25/12/16.
 */

public class DemoApplication extends Application {


    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
