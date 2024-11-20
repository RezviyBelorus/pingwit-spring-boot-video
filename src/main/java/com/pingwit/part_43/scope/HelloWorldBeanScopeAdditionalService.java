package com.pingwit.part_43.scope;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldBeanScopeAdditionalService {

    private final HelloWorldSingletonService helloWorldSingletonService;
    private final HelloWorldPrototypeService helloWorldPrototypeService;

    public HelloWorldBeanScopeAdditionalService(HelloWorldSingletonService helloWorldSingletonService, HelloWorldPrototypeService helloWorldPrototypeService) {
        this.helloWorldSingletonService = helloWorldSingletonService;
        this.helloWorldPrototypeService = helloWorldPrototypeService;

        System.out.println("===HelloWorldBeanScopeAdditionalService===");
        System.out.println(helloWorldSingletonService);
        System.out.println(helloWorldPrototypeService);
    }
}
