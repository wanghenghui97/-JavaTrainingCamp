package com.lingfan.spring01;

import com.lingfan.aop.ISchool;
import com.sun.xml.internal.bind.v2.schemagen.episode.Klass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring01Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student123 = (Student) context.getBean("student123");
        System.out.println(student123.toString());
        System.out.println(student123.getClass());
        student123.print();
        System.out.println("------------------------------------------------");
        Student student456 = (Student) context.getBean("student456");
        System.out.println(student456.toString());
        student456.print();
        System.out.println("------------------------------------------------");
        Clazz clazz = context.getBean(Clazz.class);
        clazz.dong();
        System.out.println(clazz);
        System.out.println("Klass对象AOP代理后的实际类型："+clazz.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类："+(clazz instanceof Clazz));


        System.out.println("------------------------------------------------");
        ISchool iSchool = context.getBean(ISchool.class);
        System.out.println(iSchool.toString());
        System.out.println("ISchool接口的对象AOP代理后的实际类型："+iSchool.getClass());
        iSchool.ding();

        System.out.println("------------------------------------------------");

        System.out.println("   context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));

        Student s101 = (Student) context.getBean("s101");
        if (s101 != null) {
            System.out.println(s101);
        }
    }
}
