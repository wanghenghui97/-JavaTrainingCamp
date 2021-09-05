package com.lingfan.homework;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {
    private String name;
    private int age;
    private String gender;
}
