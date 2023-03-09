package com.example.democustomfilter1.config;

import com.example.democustomfilter1.filter.AuthenticationLoggerFilter;
import com.example.democustomfilter1.filter.RequestValidationFilter;
import com.example.democustomfilter1.filter.StaticKeyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* http.addFilterBefore(new RequestValidationFilter(),
                BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthenticationLoggerFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest().permitAll();

         */
        http.addFilterAt(staticKeyAuthenticationFilter, BasicAuthenticationFilter.class)
                .authorizeRequests().anyRequest().permitAll();
    }
}
