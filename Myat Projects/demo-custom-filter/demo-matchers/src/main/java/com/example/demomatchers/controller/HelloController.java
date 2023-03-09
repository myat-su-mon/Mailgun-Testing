package com.example.demomatchers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/sayspring")
    public String saySpring(){
        return "Say Spring!";
    }

    @GetMapping("/mvc")
    public String sayMVC(){
        return "MVC";
    }
}
