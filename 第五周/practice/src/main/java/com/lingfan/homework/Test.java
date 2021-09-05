package com.lingfan.homework;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.Arrays;

@Data
public class Test{


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationBean.xml");
        Car car = context.getBean(Car.class);
        System.out.println(car);
        car.run();
        Person p1 = (Person) context.getBean("person1");
        System.out.println(p1);

        Aop1 aop1 = context.getBean(Aop1.class);
        System.out.println("所有的bean个数："+aop1.getApplicationContext().getBeanDefinitionCount());
        System.out.println("bean:"+ Arrays.toString(aop1.getApplicationContext().getBeanDefinitionNames()));

        System.out.println("----------------------------------------");
        DD bean = context.getBean(DD.class);
        System.out.println(bean);
    }


}
