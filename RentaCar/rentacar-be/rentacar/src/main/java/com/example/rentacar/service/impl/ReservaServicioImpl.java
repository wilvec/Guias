package com.example.rentacar.service.impl;

import java.util.Date;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentacar.entity.Cliente;
import com.example.rentacar.entity.Reserva;
import com.example.rentacar.entity.Vehiculo;
import com.example.rentacar.repository.ReservaRepositorio;
import com.example.rentacar.service.IClienteServicio;
import com.example.rentacar.service.IReservaServicio;
import com.example.rentacar.service.IVehiculoServicio;

@Service
public class ReservaServicioImpl implements IReservaServicio {

    @Autowired
    private ReservaRepositorio repo;

    @Autowired
    private IVehiculoServicio vehiculoServicio;

    @Autowired
    private IClienteServicio clienteServicio;

    @Override
    public Reserva crearReserva(Integer idVehiculo, Integer idCliente) throws NoSuchElementException {
        Vehiculo vehiculo = vehiculoServicio.obtenerVehiculo(idVehiculo)
                .orElseThrow(() -> new NoSuchElementException("Vehículo no encontrado"));
        Cliente cliente = clienteServicio.obtenerClientePorId(idCliente)
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));

        Reserva reserva = new Reserva();
        reserva.setAuto(vehiculo);
        reserva.setCliente(cliente);
        reserva.setFechaInicio(new Date());

        return repo.save(reserva);

    }

    @Override
    public Iterable<Reserva> listarReservaPorCliente(Integer idCliente) throws Exception {
        return repo.findByClienteIdCliente(idCliente);
    }

    @Override
    public Iterable<Reserva> listarReservaPorVehiculo(Integer idVehiculo) throws Exception {
        return repo.findByAutoIdVehiculo(idVehiculo);
    }
}
