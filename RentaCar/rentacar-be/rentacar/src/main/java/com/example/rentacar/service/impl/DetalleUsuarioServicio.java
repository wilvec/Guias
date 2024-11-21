package com.example.rentacar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.rentacar.repository.UsuarioRepositorio;

@Service
public class DetalleUsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio repoUsuario;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repoUsuario.findByUsuario(username)
                .map(user -> User.builder().username(user.getUsuario())
                        .password(user.getPassword()).build())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }

}
