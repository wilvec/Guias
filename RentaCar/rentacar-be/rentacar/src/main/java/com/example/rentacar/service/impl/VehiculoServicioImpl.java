package com.example.rentacar.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentacar.entity.Vehiculo;
import com.example.rentacar.repository.VehiculoRepositorio;
import com.example.rentacar.service.IVehiculoServicio;

@Service
public class VehiculoServicioImpl implements IVehiculoServicio {

    @Autowired
    private VehiculoRepositorio repo;

    @Override
    public Optional<Vehiculo> obtenerVehiculo(Integer id) throws NoSuchElementException {
        return repo.findById(id);
    }

    @Override
    public Iterable<Vehiculo> obtenerVehiculos() {
        return repo.findAll();
    }

    @Override
    public Vehiculo crearVehiculo(Vehiculo datos) {
        return repo.save(datos);
    }
}