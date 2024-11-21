package com.example.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentacar.entity.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

}
