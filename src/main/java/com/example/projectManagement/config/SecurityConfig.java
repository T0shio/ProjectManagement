package com.example.projectManagement.config;

import com.example.projectManagement.config.filters.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config
    ) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain httpSecurity(HttpSecurity http, JwtFilter filter) throws Exception {

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/login").anonymous();
                    registry.requestMatchers("/testAuth").authenticated();
//                    registry.requestMatchers("/login").permitAll();

                    registry.anyRequest().permitAll();
//                    try {
//                        registry.anyRequest().authenticated().and()
//                                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
                });


        return http.build();
    }
}