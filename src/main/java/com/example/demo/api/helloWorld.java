package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {
    //map the url to sayHello method
    @RequestMapping(value = "/hello")
    public String sayHello() {

        return "hello World";
    }
}
