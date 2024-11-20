package com.pingwit.part_43;

import com.pingwit.part_43.scope.HelloWorldRequestScopeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final HelloWorldService helloWorldService;
    private final HelloWorldRequestScopeService helloWorldRequestScopeService;

    public HelloWorldController(HelloWorldService helloWorldService, HelloWorldRequestScopeService helloWorldRequestScopeService) {
        this.helloWorldService = helloWorldService;
        this.helloWorldRequestScopeService = helloWorldRequestScopeService;
    }

    @GetMapping
    public String index() {
        return helloWorldService.greetings();
    }

    @GetMapping("/request")
    public String request() {
        return helloWorldRequestScopeService.toString();
    }
}
