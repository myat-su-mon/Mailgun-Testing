package com.example.demosecurityhandon.service;

import com.example.demosecurityhandon.entities.User;
import com.example.demosecurityhandon.model.CustomUserDetails;
import com.example.demosecurityhandon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findUserByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Problem during authentication."));
        return new CustomUserDetails(u);
    }
}
