package com.ra.ojt.shared.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.ra.ojt.shared.security.jwt.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Qualifier("rootDetailService")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new JWTAuthenticationEntryPoint();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(config ->config.configurationSource(request -> {
                    CorsConfiguration cf = new CorsConfiguration();
                    cf.setAllowedOrigins(List.of("http://localhost:5173/"));
                    cf.setAllowedHeaders(List.of("*"));
                    cf.setAllowCredentials(true);
                    cf.setAllowedMethods(List.of("*"));
                    cf.setExposedHeaders(List.of("*"));
                    return cf;
                })).csrf(csrf->csrf.disable())
                .exceptionHandling(excep -> excep.authenticationEntryPoint(authenticationEntryPoint()).accessDeniedHandler((request,response,accessDeniedException)->{
                    response.setStatus(403);
                    response.setHeader(HttpStatus.FORBIDDEN.toString(),"Forbidden");
                    Map<String,String> map = new HashMap<>();
                    map.put("error","For bidden");
                    new ObjectMapper().writeValue(response.getOutputStream(),map);
                }))
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(req->req
                        .requestMatchers("/api.myservice.com/v1/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api.myservice.com/v1/company/**").hasRole("COMPANY")
                        .requestMatchers("/api.myservice.com/v1/user/**").hasAnyRole("ADMIN","USER")
                        .anyRequest().permitAll())
                .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterAfter(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

}