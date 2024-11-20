package com.pingwit.part_43;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HelloWorldMessageConverter {

    public String log(String message) {
        return "[" + LocalDateTime.now() + "] " + message;
    }
}
