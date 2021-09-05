package com.example.hikari;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.hikari")
public class HikariApplication {
    public static void main(String[] args) {
        SpringApplication.run(HikariApplication.class,args);
    }
}
