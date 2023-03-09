package com.example.demomethodsecurity2.model;

import java.util.List;

public class Employee {

    private String name;
    private List<String> books;
    private List<String> roles;

    public Employee(String name, List<String> books, List<String> roles) {
        this.name = name;
        this.books = books;
        this.roles = roles;
    }
}
