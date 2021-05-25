package com.dan.cuenta.servicio;

import com.dan.cuenta.dto.EstadoCuentaDTO;
import com.dan.cuenta.dominio.Pago;

import java.util.Optional;

public interface PagoServicio {
    Optional<Pago> crear(Pago pago);
    Optional<EstadoCuentaDTO> estado(Integer clienteId);
}
