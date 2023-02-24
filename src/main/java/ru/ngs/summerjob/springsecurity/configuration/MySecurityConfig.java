package ru.ngs.summerjob.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
public class MySecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        List<UserDetails> users = new ArrayList<>();
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("sergey")
                .password("sergey")
                .roles("EMPLOYEE")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("elena")
                .password("elena")
                .roles("HR")
                .build();
        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("ivan")
                .password("ivan")
                .roles("MANAGER", "HR")
                .build();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return new InMemoryUserDetailsManager(users);
    }

}
