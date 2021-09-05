package com.lingfan.spring01;

import com.lingfan.aop.ISchool;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class School implements ISchool {
    // Resource
    @Autowired(required = true) //primary
            Clazz class1;

    @Resource(name = "student456")
    Student student456;

    public void ding() {
        System.out.println("My schoole ding");
    }
}
