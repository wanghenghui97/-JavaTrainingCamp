package com.lingfan.springjms;

import com.lingfan.spring01.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsSender {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springjms-sender.xml");
        SendService sendService = context.getBean(SendService.class);

        Student student = Student.create();
        sendService.send(student);

    }
}
