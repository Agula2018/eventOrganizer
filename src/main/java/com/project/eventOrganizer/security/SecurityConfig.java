package com.project.eventOrganizer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("root")
                .password("root")
                .roles("ADMIN")
                .build();

        //jak zrobic rejestracje uzytkownika UserBuilderem User.builder()?
        //wczytywanie hasel i loginow z bazy danych.

        return new InMemoryUserDetailsManager(admin);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/event/add")
                .hasRole("ADMIN")
                .and()
                .formLogin()
                .permitAll()
                .defaultSuccessUrl("/user/add")
                .and()
                .logout()
                .permitAll();
    }
}
