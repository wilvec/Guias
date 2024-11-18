package com.example.rentacar.service;

import java.util.Optional;

import com.example.rentacar.entity.Cliente;

public interface IClienteServicio {

    Cliente crearCliente(Cliente datosCliente);

    Optional<Cliente> obtenerClientePorId(Integer id);

    Iterable<Cliente> obtenerClientes();

    Optional<Cliente> eliminarCliente(Integer id);
}