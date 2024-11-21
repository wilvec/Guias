package com.example.rentacar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentacar.dto.LoginDTO;
import com.example.rentacar.dto.UsuarioDTO;
import com.example.rentacar.service.impl.UsuarioServicioImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UsuarioControlador {

    @Autowired
    private UsuarioServicioImpl usuarioServicio;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO entity) {
        UsuarioDTO usuarioDTO = usuarioServicio.registro(entity);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO entity) {
        return ResponseEntity.ok().body(usuarioServicio.login(entity));
    }

}
