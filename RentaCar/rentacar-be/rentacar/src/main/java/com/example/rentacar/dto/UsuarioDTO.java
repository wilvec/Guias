package com.example.rentacar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDTO {
    private Integer idUsuario;
    private String usuario;
    private String password;
    private String nombre;
    private String email;
}
