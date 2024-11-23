package com.example.rentacar.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.rentacar.service.impl.DetalleUsuarioServicio;

@Configuration
public class ApplicationConfig {

    @Autowired
    private DetalleUsuarioServicio detalleUsuarioServicio;

    @Bean
    public BCryptPasswordEncoder decodificador() {
        return new BCryptPasswordEncoder();
    };

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder)
            throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(detalleUsuarioServicio).passwordEncoder(bCryptPasswordEncoder);
        return auth.build();
    }
}
