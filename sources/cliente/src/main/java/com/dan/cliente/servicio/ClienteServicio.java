package com.dan.cliente.servicio;

import com.dan.cliente.dominio.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteServicio {

    Optional<Cliente> crear(Cliente cliente);

    List<Cliente> obtenerPorRazonSocial(String razonSocial);

    Optional<Cliente> obtenerPorId(Integer id);

    Optional<Cliente> eliminar(Integer clienteId);

    Optional<Cliente> obtenerPorCuit(String cuit);

    Optional<Cliente> obtenerPorObraId(Integer obraId);
}
