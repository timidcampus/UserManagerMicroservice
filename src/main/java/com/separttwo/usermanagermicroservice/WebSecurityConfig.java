package com.separttwo.usermanagermicroservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(new AntPathRequestMatcher("/car_rental/api/v1/users/register")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/car_rental/api/v1/users/authenticate")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/car_rental/api/v1/users/{id}")).permitAll()
                        .anyRequest().authenticated())
                .httpBasic();
        return http.build();
    }

}
