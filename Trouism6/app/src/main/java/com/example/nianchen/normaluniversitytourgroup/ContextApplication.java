package com.example.nianchen.normaluniversitytourgroup;

import android.app.Application;
import android.content.Context;

/**
 * Created by lishuxing on 2016/12/5.
 */

public class ContextApplication extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        ContextApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return ContextApplication.context;
    }
}
