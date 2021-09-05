package com.lingfan.spring01;

import lombok.Data;

import java.util.List;


@Data
public class Clazz {

    List<Student> students;

    public void dong(){
        System.out.println("dong");
    }
}
