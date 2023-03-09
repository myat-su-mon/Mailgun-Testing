package com.example.businesslogicserver.controller;

import com.example.businesslogicserver.entities.Otp;
import com.example.businesslogicserver.entities.User;
import com.example.businesslogicserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    // curl -XPOST -H "content-type: application/json" -d "{\"username\":\"john\",\"password\":\"12345\"}" http://localhost:8080/user/add
    @PostMapping("/user/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    // curl -XPOST -H "content-type: application/json" -d "{\"username\":\"john\",\"password\":\"12345\"}" http://localhost:8080/user/auth
    @PostMapping("/user/auth")
    public void auth(@RequestBody User user){
        userService.auth(user);
    }

    // curl -v -XPOST -H "content-type: application/json" -d "{\"username\":\"john\", \"code\":\"8337\"}" http://localhost:8080/otp/check
    @PostMapping("/otp/check")
    public void check(@RequestBody Otp otp, HttpServletResponse response){
        if (userService.check(otp)){
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
