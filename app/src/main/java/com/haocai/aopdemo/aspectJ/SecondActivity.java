package com.haocai.aopdemo.aspectJ;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.haocai.aopdemo.MainActivity;
import com.haocai.aopdemo.R;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void SecondClick(View view) {
        Log.w("change=====", MainActivity.isLogin + "");
        MainActivity.isLogin = !MainActivity.isLogin;
        finish();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause======", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy======", "onDestroy");
    }
}
