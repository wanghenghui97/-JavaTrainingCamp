package com.lingfan.homework;

import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Aspect
@Data
@Component
public class Aop1 implements Serializable, BeanNameAware, ApplicationContextAware {
    private String beanName;
    private ApplicationContext applicationContext;

    @Pointcut("execution(* com.lingfan.homework.*.*run(..))")
    public void point(){

    }

    @Before(value = "point()")
    public void before(){
        System.out.println("aop before//2");
    }

    @After(value = "point()")
    public void after(){
        System.out.println("aop after//4");
    }

    @Around(value = "point()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("aop around before//1");
        point.proceed();
        System.out.println("aop around after//3");
    }
}
