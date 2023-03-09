package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // John john123
    // Tommy tommy123
    // Josh josh123

    @PostMapping(value = "/auth", consumes = "application/json")
    public ResponseEntity auth(@RequestBody User user, Model model) {
        User dbUser = userRepository.findUserByUsername(user.getUsername());
//        System.out.println(user.getUsername() + " " + user.getPassword());
//        System.out.println(dbUser.getUsername() + " " + dbUser.getPassword());

        if (dbUser.getUsername().equals(user.getUsername()) &&
                dbUser.getPassword().equals(user.getPassword())){
            System.out.println(ResponseEntity.ok().build());
            model.addAttribute("username", dbUser.getUsername());
            return ResponseEntity.ok().body(dbUser);
        } else {
            System.out.println(ResponseEntity.badRequest().build());
            return ResponseEntity.badRequest().build();
        }
    }
}
