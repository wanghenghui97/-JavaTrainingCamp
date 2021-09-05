package com.lingfan.homework;

import lombok.Data;

@Data
public class Car {
    private String brand;
    private int id;

    public void run(){
        System.out.println("run!");
    }
}
