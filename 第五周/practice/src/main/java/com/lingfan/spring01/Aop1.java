package com.lingfan.spring01;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aop1 {
    // 前置通知
    public void before(){
        System.out.println("    ====>begin ding... ");
    }


    // 环绕通知
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("    ====>around begin ding"); //1
        point.proceed();
        System.out.println("    ====>around finish ding"); //3
    }


    // 后置通知
    public void after(){
        System.out.println("    ====>finish ding... "); //4

    }

}
