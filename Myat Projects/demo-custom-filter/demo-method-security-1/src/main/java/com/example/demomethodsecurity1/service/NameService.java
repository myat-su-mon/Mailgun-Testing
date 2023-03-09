package com.example.demomethodsecurity1.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {

    @PreAuthorize("hasAuthority('write')")
    public String getName(){
        return "John Williamsom";
    }

    private Map<String, List<String>> secretNames = Map
            .of("john", List.of("Apple", "Orange"),
                    "thomas", List.of("Banana"));

    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecretNames(String name){
        return secretNames.get(name);
    }
}
