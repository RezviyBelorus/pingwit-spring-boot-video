package com.pingwit.part_43.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class HelloWorldPrototypeService {
}
