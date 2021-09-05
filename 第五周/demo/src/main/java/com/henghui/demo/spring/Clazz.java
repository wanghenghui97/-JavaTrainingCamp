package com.henghui.demo.spring;

import lombok.Data;

import java.util.List;


@Data
public class Clazz {

    List<Student> students;

    public void dong(){
        System.out.println("dong");
    }
}
