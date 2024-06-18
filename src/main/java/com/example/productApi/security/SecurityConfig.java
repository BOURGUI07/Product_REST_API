/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productApi.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author hp
 */
@Configuration
public class SecurityConfig {
    
    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){
        var x = new JdbcUserDetailsManager(datasource);
        
        x.setUsersByUsernameQuery("select user_id, pw, active from users where user_id=?");
        x.setAuthoritiesByUsernameQuery("select user_id, role from authorities where user_id=?");
        
        return x;
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
