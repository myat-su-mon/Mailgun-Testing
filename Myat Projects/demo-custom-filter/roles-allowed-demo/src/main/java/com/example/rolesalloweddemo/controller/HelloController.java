package com.example.rolesalloweddemo.controller;

import com.example.rolesalloweddemo.services.NameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private NameServices nameServices;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, " + nameServices.getName();
    }

}
