package com.example.rentacar.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;

    private String marca;

    private String modelo;

    private Integer anio;

    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipo;

    private Double precio;

    @Enumerated(EnumType.STRING)
    private EstadoVehiculo estado;

    @OneToMany(mappedBy = "idReserva", cascade = CascadeType.ALL)
    private List<Reserva> reservas;}
