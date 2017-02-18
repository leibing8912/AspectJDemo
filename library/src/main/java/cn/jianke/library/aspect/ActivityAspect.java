package cn.jianke.library.aspect;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @className: ActivityAspect
 * @classDescription: activity页面切点
 * @author: leibing
 * @createTime: 2017/2/18
 */
@Aspect
public class ActivityAspect {
    // 日志标识
    private final static String TAG = "ActivityAspect";

    @Before("execution(* cn.jianke.aspectjdemo.AspectJActivity.on*(android.os.Bundle))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onActivityMethodBefore: aspect:::" + key);
    }

    @After("execution(* cn.jianke.aspectjdemo.AspectJActivity.on*(android.os.Bundle))")
    public void onActivityMethodAfter(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onActivityMethodAfter: aspect:::" + key);
    }

    @After("call(* cn.jianke.aspectjdemo.AspectJClass.doSomeThing())")
    public void aspectJavaDemoAdvice(JoinPoint joinPoint) throws Throwable {
        Log.i(TAG, "aspect:::" + joinPoint.getSignature());
    }

    @After("execution(* android.view.View.OnClickListener.on**(..))")
    public void onClickMethod(JoinPoint joinPoint) throws Throwable {
        Log.i(TAG, "aspect:::" + "signature:"+ joinPoint.getSignature()
                + "-----fileName:" +joinPoint.getSourceLocation().getFileName()
                + "-----line:" + joinPoint.getSourceLocation().getLine());
    }
}
