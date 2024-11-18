package com.example.rentacar.service;

import com.example.rentacar.entity.Reserva;

public interface IReservaServicio {

    Reserva crearReserva(Integer idVehiculo, Integer idCliente) throws Exception;

    Iterable<Reserva> listarReservaPorCliente(Integer idCliente) throws Exception;

    Iterable<Reserva> listarReservaPorVehiculo(Integer idVehiculo) throws Exception;

}
