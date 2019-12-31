
package com.haocai.aopdemo;

import android.Manifest;
import android.app.Activity;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;

import com.haocai.aopdemo.aspectJ.RequestPermissions;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main======";
    public static boolean isLogin = false;
    public static Activity activity;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.activity = this;
    }

    /**
     * 摇一摇的模块
     *
     * @param view
     */
//    @BehaviorTrace(value = "摇一摇", type = 1)
    @RequestPermissions(value = {Manifest.permission.READ_CONTACTS
            , Manifest.permission.WRITE_CONTACTS})
    public void mShake(View view) {
        //摇一摇的代码逻辑
//        {
//            Animal animal = new Animal(this);
//            animal.fly();
//            SystemClock.sleep(3000);
//            Log.i(TAG, " 摇到一个红包");
//
//        }
    }

    /**
     * 语音的模块
     *
     * @param view
     */
    @BehaviorTrace(value = "语音:", type = 1)
    public void mAudio(View view) {
        //语音代码逻辑
        {
            SystemClock.sleep(3000);
            Log.i(TAG, "发语音：我要到一个红包啦");
        }
    }

    /**
     * 打字模块
     *
     * @param view
     */
    @BehaviorTrace(value = "打字:", type = 1)
    public void mText(View view) {
        //打字模块逻辑
        {
            SystemClock.sleep(3000);
            Log.i(TAG, "打字逻辑，我摇到了一个大红包");
        }

    }

}
