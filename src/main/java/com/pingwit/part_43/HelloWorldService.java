package com.pingwit.part_43;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldService {

    @Autowired
    private HelloWorldMessageConverter helloWorldMessageConverter;

    public HelloWorldService() {
        System.out.println();
    }

    public String greetings() {
        return helloWorldMessageConverter.log("Hello from Spring Boot Application!");
    }

//    @Autowired
//    public void setHelloWorldMessageConverter(HelloWorldMessageConverter helloWorldMessageConverter) {
//        this.helloWorldMessageConverter = helloWorldMessageConverter;
//    }
}