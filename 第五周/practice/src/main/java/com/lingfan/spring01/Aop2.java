package com.lingfan.spring01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Aop2 {

    @Pointcut(value = "execution(* com.lingfan.spring01.Clazz.*dong(..))")
    public void point(){

    }
    
    @Before(value = "point()")
    public void before(){
        System.out.println("========>begin klass dong... //2");

    }

    @Around(value = "point()")
     public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("========>around begin klass dong //1");
        joinPoint.proceed();
        System.out.println("========>around after klass dong //3");
     }

     @After(value = "point()")
     public void after(){
         System.out.println("========>after klass dong... //4");

     }
}
