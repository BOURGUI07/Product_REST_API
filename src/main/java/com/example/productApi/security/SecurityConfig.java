/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author hp
 */
@Configuration
public class SecurityConfig {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails youness = User.builder()
                .username("youness")
                .password("{noop}youness")
                .roles("EMPLOYEE")
                .build();
        
        UserDetails yassine = User.builder()
                .username("yassine")
                .password("{noop}yassine")
                .roles("EMPLOYEE","MANAGER")
                .build();
        
        UserDetails omar = User.builder()
                .username("omar")
                .password("{noop}omar")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        
        return new InMemoryUserDetailsManager(youness, yassine, omar);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/api/items").hasAnyRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/items/**").hasAnyRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/items").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/items/**").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/items/**").hasAnyRole("ADMIN")
        );
        
        http.httpBasic(Customizer.withDefaults());
        http.csrf(x -> x.disable());
        return http.build();
    }
}
