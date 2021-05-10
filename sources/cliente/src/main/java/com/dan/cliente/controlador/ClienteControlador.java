package com.dan.cliente.controlador;

import com.dan.cliente.dominio.Cliente;
import com.dan.cliente.servicio.ClienteServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteControlador {

    private final ClienteServicio clienteServicio;

    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        Cliente entidad = clienteServicio.crear(cliente);
        return new ResponseEntity<>(entidad, HttpStatus.CREATED);
    }

    @GetMapping("/cuit/{cuit}")
    public ResponseEntity<Cliente> obtenerPorCuit(@PathVariable String cuit) {
        return ResponseEntity.of(clienteServicio.obtenerPorCuit(cuit));
    }

    @GetMapping("/razonSocial")
    public ResponseEntity<List<Cliente>> obtenerPorRazonSocial(@RequestParam(required = false) String razonSocial) {
        return ResponseEntity.ok(clienteServicio.obtenerPorRazonSocial(razonSocial));
    }

    @GetMapping("/obra/{id}")
    public ResponseEntity<Cliente> obtenerPorObraId(@PathVariable Integer id) {
        return ResponseEntity.of(clienteServicio.obtenerPorObraId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable Integer id) {
        Optional<Cliente> opcional = clienteServicio.eliminar(id);
        return opcional.map(cliente -> ResponseEntity.of(opcional)).orElse(ResponseEntity.notFound().build());
    }
}
