package com.example.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rentacar.entity.Usuario;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsuario(String usuario);
}
