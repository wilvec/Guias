package com.example.rentacar.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.rentacar.entity.Vehiculo;

public interface VehiculoRepositorio extends CrudRepository<Vehiculo, Integer> {

}
