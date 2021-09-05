package com.lingfan.springjms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class JmsReceiver {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springjms-receiver.xml");

        System.in.read();
        System.out.println("send successfully, please visit http://localhost:8161/admin to see it");

    }
}
