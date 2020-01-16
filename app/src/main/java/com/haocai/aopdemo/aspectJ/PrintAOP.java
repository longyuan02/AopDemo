package com.haocai.aopdemo.aspectJ;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;

import com.haocai.aopdemo.BehaviorTrace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class PrintAOP {

    /**
     * 根据切点 切成什么样子
     */
    @Pointcut("execution(@com.haocai.aopdemo.aspectJ.SellingPoints * *(..))")
    public void annoBehavior() {

    }


    @Around("annoBehavior()")
    public Object printAOP(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        SellingPoints behaviorTrace = methodSignature.getMethod().getAnnotation(SellingPoints.class);
//        Log.e("PrintAOP====", behaviorTrace.printLog() + "**");
        Object target = proceedingJoinPoint.getTarget();
        Activity activity = null;
        activity = (Activity) target;
        if (target instanceof Activity) {
            activity = (Activity) target;
        } else if (target instanceof Fragment) {
            activity = ((Fragment) target).getActivity();
        }
        //方法执行时
        Object object = null;
        try {
            object = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }

    @Before("annoBehavior()")
    public void ToPrint(JoinPoint joinPoint) {
        Log.e("before======", "before print");

    }

//    @Around("execution(@com.haocai.aopdemo.aspectJ.PrintAOP * *(..)) && @annotation(printAOP)")
//    public void requestPermissions(final ProceedingJoinPoint proceedingJoinPoint, SellingPoints printAOP) throws Exception {
//        String permissions = printAOP.printLog();
//        Object target = proceedingJoinPoint.getTarget();
//        Activity activity = null;
//        if (target instanceof Activity) {
//            activity = (Activity) target;
//        } else if (target instanceof android.app.Fragment) {
//            activity = ((Fragment) target).getActivity();
//        }
//        /**
//         * 执行权限代码
//         */
//        Log.w("execution====", "printAOP:" + permissions);
//        try {
//            proceedingJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        } finally {
//        }
//    }
}
