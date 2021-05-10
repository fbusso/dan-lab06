package com.dan.cliente.servicio.impl;

import com.dan.cliente.dominio.TipoCliente;
import com.dan.cliente.repositorio.TipoClienteRepositorio;
import com.dan.cliente.servicio.TipoClienteServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoClienteServicioImpl implements TipoClienteServicio {

    private final TipoClienteRepositorio tipoClienteRepositorio;

    public TipoClienteServicioImpl(TipoClienteRepositorio tipoClienteRepositorio) {
        this.tipoClienteRepositorio = tipoClienteRepositorio;
    }

    @Override
    public Optional<TipoCliente> obtenerPorId(Integer id) {
        return tipoClienteRepositorio.findById(id);
    }
}
