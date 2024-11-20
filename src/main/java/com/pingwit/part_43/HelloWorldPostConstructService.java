package com.pingwit.part_43;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldPostConstructService {

    public HelloWorldPostConstructService() {
        System.out.println("Creating HelloWorldPostConstructService object");
    }

    @PostConstruct
    private void init() {
        System.out.println("Hello from PostConstruct method");
    }

    {
        System.out.println("Hello from non static block");
    }

    static {
        System.out.println("Hello from static block");
    }

}
