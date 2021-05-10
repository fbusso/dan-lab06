package com.dan.cliente.servicio;

import com.dan.cliente.dominio.Obra;

import java.util.Optional;

public interface ObraServicio {

    Optional<Obra> crear(Obra obra);

    Optional<Obra> obtenerPorId(Integer id);
}
