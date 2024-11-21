package com.example.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rentacar.entity.Reserva;

public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {
    Iterable<Reserva> findByClienteIdCliente(Integer id);

    Iterable<Reserva> findByAutoIdVehiculo(Integer id);

}
