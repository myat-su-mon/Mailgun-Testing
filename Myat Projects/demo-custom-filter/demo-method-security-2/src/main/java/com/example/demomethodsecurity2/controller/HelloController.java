package com.example.demomethodsecurity2.controller;

import com.example.demomethodsecurity2.model.Employee;
import com.example.demomethodsecurity2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable String name){
        return bookService.getBookDetails(name);
    }
}
