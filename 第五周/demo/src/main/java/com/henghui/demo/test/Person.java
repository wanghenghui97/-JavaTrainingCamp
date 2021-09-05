package com.henghui.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Student.class)
public class Person {
    String MOD="八宝粥";

    @Autowired
    Student student;

}
