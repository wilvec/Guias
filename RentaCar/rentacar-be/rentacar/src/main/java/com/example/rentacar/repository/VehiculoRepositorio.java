package com.example.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rentacar.entity.Vehiculo;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Integer> {

}
