package com.henghui.demo.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "web")
public class WebProperties {

    private String a = "aaa";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
