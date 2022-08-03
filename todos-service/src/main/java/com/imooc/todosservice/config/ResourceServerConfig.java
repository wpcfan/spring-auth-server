package com.imooc.todosservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .mvcMatcher("/todos/**")
            .authorizeRequests()
            .mvcMatchers("/todos/**").access("hasAuthority('SCOPE_todo.read')")
            .and()
            .oauth2ResourceServer()
            .jwt();
        return http.build();
    }
}
