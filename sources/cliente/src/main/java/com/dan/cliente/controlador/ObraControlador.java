package com.dan.cliente.controlador;

import com.dan.cliente.dominio.Obra;
import com.dan.cliente.servicio.ObraServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/obra")
public class ObraControlador {

    private final ObraServicio obraServicio;

    public ObraControlador(ObraServicio obraServicio) {
        this.obraServicio = obraServicio;
    }

    @PostMapping
    public ResponseEntity<Obra> crear(@RequestBody Obra obra) {
        return obraServicio
                .crear(obra)
                .map(entidad -> new ResponseEntity<>(entidad, HttpStatus.CREATED))
                .orElse(ResponseEntity.notFound().build());
    }
}
