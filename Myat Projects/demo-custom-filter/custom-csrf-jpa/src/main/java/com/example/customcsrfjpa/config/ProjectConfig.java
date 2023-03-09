package com.example.customcsrfjpa.config;

import com.example.customcsrfjpa.csrf.CustomCsrfTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomCsrfTokenRepository csrfTokenRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf(c -> {
           c.csrfTokenRepository(csrfTokenRepository);
           c.ignoringAntMatchers("/john");
       });

       http.authorizeRequests().anyRequest().permitAll();
    }
}
