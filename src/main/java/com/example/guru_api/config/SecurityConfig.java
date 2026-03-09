package com.example.guru_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Menggunakan BCrypt untuk enkripsi password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean untuk mengaktifkan AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // .cors(cors -> {})
                .cors(cors -> {
                })
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Izinkan endpoint login
                        .requestMatchers("/api/teachers/**").authenticated() // izinkan endpoint nya untuk dashboard
                        .anyRequest().permitAll())
                .httpBasic(basic -> basic
                        .authenticationEntryPoint((request, response, authException) -> {
                            // Kirim status 401 tanpa header WWW-Authenticate agar popup browser tidak
                            // muncul
                            response.sendError(jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED,
                                    "Unauthorized");
                        }));

        return http.build();

    }
}