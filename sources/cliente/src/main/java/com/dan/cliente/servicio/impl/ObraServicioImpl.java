package com.dan.cliente.servicio.impl;

import com.dan.cliente.dominio.Cliente;
import com.dan.cliente.dominio.Obra;
import com.dan.cliente.repositorio.ObraRepositorio;
import com.dan.cliente.servicio.ClienteServicio;
import com.dan.cliente.servicio.ObraServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObraServicioImpl implements ObraServicio {

    private final ObraRepositorio obraRepositorio;
    private final ClienteServicio clienteServicio;

    public ObraServicioImpl(ObraRepositorio obraRepositorio, ClienteServicio clienteServicio) {
        this.obraRepositorio = obraRepositorio;
        this.clienteServicio = clienteServicio;
    }

    @Override
    public Optional<Obra> crear(Obra obra) {
        Optional<Cliente> optionalCliente = clienteServicio.obtenerPorId(obra.getCliente().getId());
        return optionalCliente.map(cliente -> {
            obra.setCliente(cliente);
            return Optional.of(obraRepositorio.save(obra));
        }).orElse(Optional.empty());
    }

    @Override
    public Optional<Obra> obtenerPorId(Integer id) {
        return obraRepositorio.findById(id);
    }
}
