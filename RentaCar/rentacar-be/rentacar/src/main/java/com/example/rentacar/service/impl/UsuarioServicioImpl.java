package com.example.rentacar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.rentacar.dto.LoginDTO;
import com.example.rentacar.dto.UsuarioDTO;
import com.example.rentacar.entity.Usuario;
import com.example.rentacar.repository.UsuarioRepositorio;
import com.example.rentacar.service.IUsuarioServicio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

    private final BCryptPasswordEncoder codificadorPassword = new BCryptPasswordEncoder();

    @Autowired
    private JwtServicio servicioJwt;

    @Autowired
    private AuthenticationManager managerAutenticacion;

    @Autowired
    private UsuarioRepositorio repo;

    @Override
    public UsuarioDTO registro(UsuarioDTO usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDto.getIdUsuario());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setPassword(codificadorPassword.encode(usuarioDto.getPassword()));
        usuario.setUsuario(usuarioDto.getUsuario());
        usuario = repo.save(usuario);
        return UsuarioDTO.builder()
                .email(usuario.getEmail())
                .idUsuario(usuario.getIdUsuario())
                .nombre(usuario.getNombre())
                .usuario(usuario.getUsuario())
                .password(usuario.getPassword())
                .build();

    }

    @Override
    public String login(LoginDTO login) {

        managerAutenticacion
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsuario(), login.getPassword()));
        Usuario usuario = repo.findByUsuario(login.getUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        return servicioJwt.generarToken(usuario);
    }

}
