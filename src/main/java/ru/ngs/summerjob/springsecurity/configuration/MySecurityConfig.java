package ru.ngs.summerjob.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable()
////                .authorizeHttpRequests()
////                .anyRequest().authenticated()
////                .and()
////                .httpBasic();
//
//        return http.build();
//    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder().username("sergey").password("sergey").roles("EMPLOYEE").build(),
                User.withDefaultPasswordEncoder().username("elena").password("elena").roles("HR").build(),
                User.withDefaultPasswordEncoder().username("ivan").password("ivan").roles("MANAGER", "HR").build());
    }

}
