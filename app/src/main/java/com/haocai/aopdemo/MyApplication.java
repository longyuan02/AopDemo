package com.haocai.aopdemo;

import android.app.Application;

import java.util.HashMap;
import java.util.LinkedList;

public class MyApplication extends Application {
    public static MyApplication myApplication;
    public static LinkedList<HashMap<String, String>> jumpList = null;

    @Override
    public void onCreate() {
        super.onCreate();
        this.myApplication = this;
        jumpList = new LinkedList<HashMap<String, String>>();
    }

    public static MyApplication getInstance() {
        return myApplication;
    }
}
