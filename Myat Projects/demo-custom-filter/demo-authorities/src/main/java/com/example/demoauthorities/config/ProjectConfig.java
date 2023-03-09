package com.example.demoauthorities.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        var manager = new InMemoryUserDetailsManager();

        /* var user1 = User.withUsername("john")
                .password("12345")
                .authorities("READ")
                .build();

        var user2 = User.withUsername("jane")
                .password("12345")
                .authorities("WRITE", "READ", "DELETE")
                .build();
        */

        var user1 = User.withUsername("john")
                .password("12345")
                .authorities("ROLE_ADMIN")
                .build();

        var user2 = User.withUsername("jone")
                .password("12345")
                //.authorities("ROLE_MANAGER")
                .roles("MANAGER", "ADMIN")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    // role -ROLE_PREFIX
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        //http.authorizeRequests().anyRequest().access("hasAuthority('WRITE')");
        //http.authorizeRequests().anyRequest().hasAuthority("WRITE");
        //http.authorizeRequests().anyRequest().hasAnyAuthority("WRITE", "READ");

        /* String expression = "hasAuthority('READ') and !hasAuthority('DELETE')";
        http.authorizeRequests().anyRequest().access(expression); */

        //http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "MANAGER");
        http.authorizeRequests().anyRequest().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
