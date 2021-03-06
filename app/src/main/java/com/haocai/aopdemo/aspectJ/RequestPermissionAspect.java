package com.haocai.aopdemo.aspectJ;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class RequestPermissionAspect {
    /*annotation(参数名) 参数名必须入接收参数一致*/
    @Around("execution(@com.haocai.aopdemo.aspectJ.RequestPermissions * *(..)) && @annotation(aaa)")
    public void requestPermissions(final ProceedingJoinPoint proceedingJoinPoint, RequestPermissions aaa) throws Exception {
        String[] permissions = aaa.value();

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        RequestPermissions requestPermissions = methodSignature.getMethod().getAnnotation(RequestPermissions.class);
        requestPermissions.value();

        Object target = proceedingJoinPoint.getTarget();
        Activity activity = null;
        if (target instanceof Activity) {
            activity = (Activity) target;
        } else if (target instanceof Fragment) {
            activity = ((Fragment) target).getActivity();
        }
        /**
         * 执行权限代码
         */
        Log.w("execution===", "permissions:" + permissions.length + "**" + requestPermissions.value()[0] + requestPermissions.value()[1]);
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
        }
    }
}
