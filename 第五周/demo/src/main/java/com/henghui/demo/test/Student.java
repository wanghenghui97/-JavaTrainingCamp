package com.henghui.demo.test;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class Student {
    private final String WENBEN="I'm bbz";
    private int id;
    private String name;


    public String getName() {
        return "I'm "+name;
    }
}
