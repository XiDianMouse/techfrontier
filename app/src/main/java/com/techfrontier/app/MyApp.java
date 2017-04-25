package com.techfrontier.app;

import android.app.Application;

import org.techfrontier.db.DatabaseHelper;

/**
 * @auther gbh
 * Created on 2017/4/24.
 */

public class MyApp extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        DatabaseHelper.init(this);
    }
}
