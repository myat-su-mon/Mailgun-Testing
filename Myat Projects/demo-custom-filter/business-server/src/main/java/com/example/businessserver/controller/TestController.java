package com.example.businessserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // curl -H "username:john" -H "password:12345" http://localhost:9090/login
    // curl -H "username:john" -H "code:1887" http://localhost:9090/login
    // curl -H "Authorization: eUVPreWEC2kEpTfU7fSQbOTOiyh6C1aliWU9W9TqZYHQc802DuREBdafj4Y18lE" http://localhost:9090/login
    @GetMapping("/test")
    public String test(){
        return "TEST";
    }
}
