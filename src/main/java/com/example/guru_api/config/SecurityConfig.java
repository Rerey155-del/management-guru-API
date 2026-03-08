package com.example.guru_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // .cors(cors -> {})
            .cors(cors -> {})
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // endpoint guru harus login
                .requestMatchers("/api/teachers/**").authenticated()

                // endpoint lain bebas
                .anyRequest().permitAll()
            )
            .httpBasic(basic->{}); // menggunakan Basic Authentication

        return http.build();
    }
}