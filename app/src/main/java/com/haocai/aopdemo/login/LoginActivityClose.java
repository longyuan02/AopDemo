package com.haocai.aopdemo.login;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.haocai.aopdemo.MyApplication;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;

@Aspect
public class LoginActivityClose {
    @Around("execution(@com.haocai.aopdemo.login.LoginClose * *(..)) && @annotation(isClose)")
    public void close(ProceedingJoinPoint joinPoint, LoginClose isClose) {
        Log.e("loginclose===", isClose + "");
        if (isClose.close()) {
            HashMap<String, String> data = MyApplication.jumpList.pollLast();
            if (data != null) {
                String className = data.get("className");
                Log.e("loginclose===", className);
                try {
                    Class<Activity> jump = (Class<Activity>) Class.forName(className);
                    MyApplication.getInstance().getApplicationContext()
                            .startActivity(new Intent(MyApplication.getInstance().getApplicationContext(),
                                    jump));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            //一定要执行注解方法,本次注解作用于activity生命周期上,如果不执行,就会阻塞登录页面产生异常
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
