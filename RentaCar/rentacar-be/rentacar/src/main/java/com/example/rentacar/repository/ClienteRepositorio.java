package com.example.rentacar.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.rentacar.entity.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {

}
