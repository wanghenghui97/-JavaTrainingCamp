package com.lingfan.homework;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Timer;

public class Aop2 {
    public void around(ProceedingJoinPoint point) throws Throwable {
        long t1 = System.currentTimeMillis();
        point.proceed();
        long t2 = System.currentTimeMillis();
        System.out.println("执行时间："+(t2-t1));

    }
}
