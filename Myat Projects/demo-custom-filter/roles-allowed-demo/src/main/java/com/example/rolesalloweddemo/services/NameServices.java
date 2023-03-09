package com.example.rolesalloweddemo.services;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Service
public class NameServices {

    //@Secured("ROLE_ADMIN")
    @RolesAllowed("ROLE_ADMIN")
    public String getName(){
        return "Fantasia";
    }
}
