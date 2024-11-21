package com.example.rentacar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    private Integer idUsuario;
    private String usuario;
    private String password;
    private String nombre;
    private String email;

}
