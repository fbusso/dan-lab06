package com.dan.cuenta.controlador;

import com.dan.cuenta.dto.EstadoCuentaDTO;
import com.dan.cuenta.dominio.Pago;
import com.dan.cuenta.servicio.PagoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cuenta")
public class PagoControlador {

    private final PagoServicio pagoServicio;

    public PagoControlador(PagoServicio pagoServicio) {
        this.pagoServicio = pagoServicio;
    }

    @PostMapping("/pago")
    public ResponseEntity<Pago> crear(@RequestBody Pago pago) {
        return pagoServicio
                .crear(pago)
                .map(entidad -> new ResponseEntity<>(entidad, HttpStatus.CREATED))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{cliente_id}")
    public ResponseEntity<EstadoCuentaDTO> estado(@PathVariable Integer clienteId){
        return pagoServicio
                .estado(clienteId)
                .map(entidad -> new ResponseEntity<>(entidad, HttpStatus.CREATED))
                .orElse(ResponseEntity.notFound().build());
    }
}
