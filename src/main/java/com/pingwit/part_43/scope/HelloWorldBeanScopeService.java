package com.pingwit.part_43.scope;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldBeanScopeService {

    private final HelloWorldSingletonService helloWorldSingletonService;
    private final HelloWorldPrototypeService helloWorldPrototypeService;

    public HelloWorldBeanScopeService(HelloWorldSingletonService helloWorldSingletonService, HelloWorldPrototypeService helloWorldPrototypeService) {
        this.helloWorldSingletonService = helloWorldSingletonService;
        this.helloWorldPrototypeService = helloWorldPrototypeService;

        System.out.println("===HelloWorldBeanScopeService===");
        System.out.println(helloWorldSingletonService);
        System.out.println(helloWorldPrototypeService);
    }
}
