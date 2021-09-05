package com.henghui.demo.spring;

import com.henghui.demo.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebConfiguration.class)
@EnableConfigurationProperties(WebProperties.class)
//@ConditionalOnClass(TestService.class)// TestService这个类在类路径中时，且当前容器中没有这个Bean的情况下，开始自动配置

public class WebAutoConfiguration {

    @Autowired
    WebProperties properties;

    @Autowired
    WebConfiguration configuration;

    @Bean
    public WebInfo creatInfo(){
        return new WebInfo(configuration.name + "-"+properties.getA());
    }

}
