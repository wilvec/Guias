package com.example.rentacar.service;

import com.example.rentacar.dto.LoginDTO;
import com.example.rentacar.dto.UsuarioDTO;

public interface IUsuarioServicio {

    UsuarioDTO registro(UsuarioDTO usuario);

    String login(LoginDTO login);

}
