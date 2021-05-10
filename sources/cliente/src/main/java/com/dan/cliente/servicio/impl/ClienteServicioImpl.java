package com.dan.cliente.servicio.impl;

import com.dan.cliente.dominio.Cliente;
import com.dan.cliente.dominio.Usuario;
import com.dan.cliente.repositorio.ClienteRepositorio;
import com.dan.cliente.servicio.ClienteServicio;
import com.dan.cliente.servicio.UsuarioServicio;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    private final ClienteRepositorio clienteRepositorio;
    private final UsuarioServicio usuarioServicio;

    public ClienteServicioImpl(ClienteRepositorio clienteRepositorio,
                               UsuarioServicio usuarioServicio) {
        this.clienteRepositorio = clienteRepositorio;
        this.usuarioServicio = usuarioServicio;
    }

    @Override
    public Cliente crear(Cliente cliente) {
        Usuario usuario = usuarioServicio.crear(cliente.getUsuario());
        cliente.setUsuario(usuario);
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Optional<Cliente> obtenerPorCuit(String cuit) {
        return clienteRepositorio.findByCuitAndFechaBajaNotNull(cuit);
    }

    @Override
    public List<Cliente> obtenerPorRazonSocial(String razonSocial) {
        if (StringUtils.isNotBlank(razonSocial)) {
            return clienteRepositorio.findAllByRazonSocialAndFechaBajaNotNull(razonSocial);
        }

        return clienteRepositorio.findAllByFechaBajaNotNull();
    }

    @Override
    public Optional<Cliente> obtenerPorObraId(Integer obraId) {
        return clienteRepositorio.findByObras_idAndFechaBajaNotNull(obraId);
    }

    @Override
    public Optional<Cliente> eliminar(Integer clienteId) {
        Optional<Cliente> opcional = clienteRepositorio.findByIdAndFechaBajaNotNull(clienteId);
        return opcional.map(cliente -> {
            cliente.setFechaBaja(LocalDate.now());
            clienteRepositorio.save(cliente);
            return opcional;
        }).orElse(Optional.empty());
    }
}
