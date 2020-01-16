package com.haocai.aopdemo.login;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.haocai.aopdemo.MyApplication;
import com.haocai.aopdemo.aspectJ.SecondActivity;
import com.haocai.aopdemo.h5.H5View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.HashMap;

@Aspect
public class AOPTest1 {
    @Pointcut("execution(@com.haocai.aopdemo.login.AOP1 * *(..))")
    public void annotationBehavior() {

    }

    @Around("annotationBehavior()")
    public void GOGO(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        AOP1 aop1 = methodSignature.getMethod().getAnnotation(AOP1.class);
        String str = aop1.aopValue();

        Object object = joinPoint.getTarget();
        Activity activity = null;
        HashMap data = new HashMap<String, String>();
        data.put("className", SecondActivity.class.getCanonicalName());
        MyApplication.getInstance().jumpList.add(data);
        if (object instanceof Activity) {
            activity = (Activity) object;
        } else if (object instanceof Fragment) {
            activity = ((Fragment) object).getActivity();
        }
        if (!TextUtils.isEmpty(str) && str.equals("111")) {
            activity.startActivity(new Intent(activity, H5View.class));
            joinPoint.proceed();
        }
        Log.e("AOPTest1=====", "AOPTest1" + aop1.aopValue());
    }

//    @AfterReturning("annotationBehavior()")
//    private void stop() {
//        Log.e("stop=====", "AfterReturning");
//    }
}
