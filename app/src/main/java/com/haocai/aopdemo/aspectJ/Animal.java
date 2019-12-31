package com.haocai.aopdemo.aspectJ;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Animal {
    private Context context;

    public Animal(Context context) {
        this.context = context;
    }

    private String TAG = Animal.class.getSimpleName();

    public void fly() {
        Log.w(TAG, "animal fly method:===" + this.toString() + "#fly");
    }

    public void JumpToSecondActivity() {
        context.startActivity(new Intent(context, SecondActivity.class));
    }
}
