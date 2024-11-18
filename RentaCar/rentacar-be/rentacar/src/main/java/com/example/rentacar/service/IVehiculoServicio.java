package com.example.rentacar.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.rentacar.entity.Vehiculo;

public interface IVehiculoServicio {

    Vehiculo crearVehiculo(Vehiculo datos);

    Optional<Vehiculo> obtenerVehiculo(Integer id) throws NoSuchElementException;

    Iterable<Vehiculo> obtenerVehiculos();

}
