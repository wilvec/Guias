package com.example.rentacar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentacar.entity.Vehiculo;
import com.example.rentacar.service.IVehiculoServicio;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoControlador {

    private IVehiculoServicio vehiculoServicio;

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoPorId(@PathVariable Integer id) {
        Optional<Vehiculo> vehiculos = vehiculoServicio.obtenerVehiculo(id);

        if (vehiculos.isPresent()) {
            return ResponseEntity.ok().body(vehiculos.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Vehiculo> postMethodName(@RequestBody Vehiculo vehiculoNew) {
        Vehiculo vehiculo = vehiculoServicio.crearVehiculo(vehiculoNew);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable Integer id, @RequestBody Vehiculo entity) {
        Optional<Vehiculo> vehiculo = vehiculoServicio.obtenerVehiculo(id);
        if (vehiculo.isPresent()) {
            Vehiculo newVehiculo = vehiculo.get();
            newVehiculo.setAnio(entity.getAnio());
            newVehiculo.setEstado(entity.getEstado());
            newVehiculo.setMarca(entity.getMarca());
            newVehiculo.setModelo(entity.getModelo());
            newVehiculo.setPrecio(entity.getPrecio());
            newVehiculo.setTipo(entity.getTipo());
            return ResponseEntity.ok(vehiculoServicio.crearVehiculo(newVehiculo));
        }

        return ResponseEntity.notFound().build();
    }

}
