package com.haocai.aopdemo.aspectJ;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.haocai.aopdemo.MainActivity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodAspect {
    private String TAG = MethodAspect.class.getSimpleName();

    @Pointcut("call(* com.haocai.aopdemo.aspectJ.Animal.fly(..))")
    public void callMethod() {
    }

    @Pointcut("call(* com.haocai.aopdemo.aspectJ.Animal.JumpToSecondActivity(..))")
    public void ToLogin() {

    }


    @Before("callMethod()")
    public void beforeMethodCall(JoinPoint joinPoint) {
        if (!MainActivity.isLogin) {
            Log.w(TAG, "login=====未登录=" + joinPoint.getTarget().toString() + "this:" + joinPoint.getThis()); //④
            Context context = (Context) joinPoint.getThis();
            Intent intent = new Intent(context, SecondActivity.class);
            context.startActivity(intent);
        } else {
            Log.w(TAG, "login======已登录=" + joinPoint.getTarget().toString()); //④
        }
        Log.w(TAG, "login=====dd=" + joinPoint.getTarget().toString() + "this:" + joinPoint.getThis());
    }

    @After("callMethod()")
    public void AToast() {

    }

    @AfterReturning("callMethod()")
    public void JumpActivity(JoinPoint point, Object returnValue) {
        Log.w("toLogin====", "login");
    }
}

