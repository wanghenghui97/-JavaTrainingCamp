package com.henghui.demo.spring.service;


import com.henghui.demo.spring.WebProperties;
import com.henghui.demo.test.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    WebProperties webProperties;

    public String test(Student student){
        return student.getName();
    }


    public String getName(){
        return webProperties.getA();
    }

}
