package com.example.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rentacar.entity.Pago;

public interface PagoRepositorio extends JpaRepository<Pago, Integer> {

}
