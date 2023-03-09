package com.example.authserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServer1Application {

    // curl -v -XPOST -u client:secret "http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read"
    // curl -XPOST -u resourceserver:resourceserversecret "http://localhost:8080/oauth/check_token?token=
    public static void main(String[] args) {
        SpringApplication.run(AuthServer1Application.class, args);
    }

}
