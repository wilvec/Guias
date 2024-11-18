package com.example.rentacar.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentacar.entity.Cliente;
import com.example.rentacar.repository.ClienteRepositorio;
import com.example.rentacar.service.IClienteServicio;

@Service
public class ClienteServicioImpl implements IClienteServicio {

    @Autowired
    private ClienteRepositorio repo;

    @Override
    public Cliente crearCliente(Cliente datosCliente) {
        return repo.save(datosCliente);
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<Cliente> obtenerClientes() {
        return repo.findAll();
    }

    @Override
    public Optional<Cliente> eliminarCliente(Integer id) {
        return repo.findById(id).map(cliente -> {
            repo.delete(cliente);
            return cliente;
        });
    }

}
