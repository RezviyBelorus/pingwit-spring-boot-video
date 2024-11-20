package com.pingwit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
//@EnableJpaRepositories
@ConfigurationPropertiesScan
public class PingwitSpringBootVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PingwitSpringBootVideoApplication.class, args);
    }

}
