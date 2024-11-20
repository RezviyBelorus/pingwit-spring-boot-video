package com.pingwit.part_43.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
//@Scope("request")
public class HelloWorldRequestScopeService {
}
