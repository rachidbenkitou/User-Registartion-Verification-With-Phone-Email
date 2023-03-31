package com.bokito.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity // If the configuration class is related to security we need to make this annotation.
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/api/v1/auth/**")// Here I give the list of requestts urls that I want allow using upp without authentication.
          .permitAll() // I permit all requests urls above given in requestMatchers to use the app without authentication.
        .anyRequest()// All other request urls
          .authenticated() // should authenticated.
        .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Here we choose the type of session we want to use, in our case we choosed STATELESS
        .and()
        .authenticationProvider(authenticationProvider) // I need to tell spring which authenticationProvider I want to use.
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class) // We made before to execute the filter given in parameter jwtAuthFilter before executing UsernamePasswordAuthenticationFilter.
        .logout()
        .logoutUrl("/api/v1/auth/logout")
        .addLogoutHandler(logoutHandler)
        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
    ;
    return http.build();
  }
}
