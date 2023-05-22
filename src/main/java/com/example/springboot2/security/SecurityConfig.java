package com.example.springboot2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("ravishanka")
                .password("1234")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeHttpRequests((auth)->auth
                        .anyRequest().authenticated())
                .httpBasic();
        return httpSecurity.build();

    }

}
