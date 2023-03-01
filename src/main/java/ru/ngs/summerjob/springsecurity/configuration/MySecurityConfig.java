package ru.ngs.summerjob.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> {
                    try {
                        authz
                                .requestMatchers("/").hasAnyRole("EMPLOYEE", "MANAGER", "HR")
                                .requestMatchers("/hr_info").hasRole("HR")
                                .requestMatchers("/manager_info/**").hasRole("MANAGER")
                                .anyRequest().authenticated().and().formLogin().permitAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return http.build();
    }

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        return new InMemoryUserDetailsManager(
//                User.withDefaultPasswordEncoder().username("sergey").password("sergey").roles("EMPLOYEE").build(),
//                User.withDefaultPasswordEncoder().username("elena").password("elena").roles("HR").build(),
//                User.withDefaultPasswordEncoder().username("ivan").password("ivan").roles("MANAGER", "HR").build());
//    }

}
