package com.example.rentacar.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.rentacar.entity.Reserva;

public interface ReservaRepositorio extends CrudRepository<Reserva, Integer> {
    Iterable<Reserva> findByClienteIdCliente(Integer id);

    Iterable<Reserva> findByAutoIdVehiculo(Integer id);

}
