package com.dan.cliente.servicio;

import com.dan.cliente.dominio.TipoCliente;

import java.util.Optional;

public interface TipoClienteServicio {

    Optional<TipoCliente> obtenerPorId(Integer id);
}
