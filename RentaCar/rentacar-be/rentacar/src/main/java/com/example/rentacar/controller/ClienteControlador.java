package com.example.rentacar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentacar.entity.Cliente;
import com.example.rentacar.service.IClienteServicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> getAllClientes() {
        return ResponseEntity.ok().body(clienteServicio.obtenerClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientePorId(@PathVariable Integer id) {
        Optional<Cliente> opCliente = clienteServicio.obtenerClientePorId(id);

        if (opCliente.isPresent()) {
            return ResponseEntity.ok().body(opCliente.get());
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente entity) {
        Cliente nuevoCliente = clienteServicio.crearCliente(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> eliminarCliente(@PathVariable(name = "id") Integer id) {
        Optional<Cliente> cliente = clienteServicio.eliminarCliente(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok().body(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable(name = "id") Integer id,
            @RequestBody Cliente clienteOld) {
        Optional<Cliente> cliente = clienteServicio.obtenerClientePorId(id);
        if (cliente.isPresent()) {
            Cliente clienteNew = cliente.get();
            clienteNew.setDireccion(clienteOld.getDireccion());
            clienteNew.setEmail(clienteOld.getEmail());
            clienteNew.setNombre(clienteOld.getNombre());
            clienteNew.setTelefono(clienteOld.getTelefono());
            return ResponseEntity.ok(clienteServicio.crearCliente(clienteNew));
        }
        return ResponseEntity.notFound().build();
    }

}
