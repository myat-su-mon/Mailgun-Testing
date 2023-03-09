package com.example.demomethodsecurity2.service;

import com.example.demomethodsecurity2.model.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private Map<String, Employee> records =
            Map.of("thomas",
                    new Employee("Thomas Thompson",
                            List.of("Karamazov Brothers"),
                            List.of("account", "reader")),
                    "john",
                    new Employee("John William",
                            List.of("Beautiful Paris"),
                            List.of("researcher"))
            );

    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name){
        return records.get(name);
    }
}
