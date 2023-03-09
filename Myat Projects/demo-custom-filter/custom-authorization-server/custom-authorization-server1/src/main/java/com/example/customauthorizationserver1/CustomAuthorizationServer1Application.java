package com.example.customauthorizationserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomAuthorizationServer1Application {
    // curl -v -XPOST -u client:secret "http://localhost:8080/oauth/token?grant_type=authorization_code&scope=read"
    // curl -v -XPOST -u client:secret "http://localhost:8080/oauth/token?grant_type=authorization_code&scope=read&code=YowWwu"
    // for form login
    // http://localhost:8080/oauth/authorize?response_type=code&client_id=client&scope=read
    // curl -v -XPOST -u client:secret "http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read"

    // curl -v -XPOST -u client:secret "http://localhost:8080/oauth/token?grant_type=client_credentials&scope=info" //server 2

    // curl -v -XPOST -u client:secret "http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read" // server 3
    public static void main(String[] args) {
        SpringApplication.run(CustomAuthorizationServer1Application.class, args);
    }

}
