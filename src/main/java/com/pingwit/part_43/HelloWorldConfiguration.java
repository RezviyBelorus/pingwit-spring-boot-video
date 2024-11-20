package com.pingwit.part_43;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldService();
    }
}
