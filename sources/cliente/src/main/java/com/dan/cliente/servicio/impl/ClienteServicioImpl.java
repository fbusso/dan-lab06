package com.dan.cliente.servicio.impl;

import com.dan.cliente.dominio.Cliente;
import com.dan.cliente.dominio.Obra;
import com.dan.cliente.dominio.TipoCliente;
import com.dan.cliente.dominio.Usuario;
import com.dan.cliente.repositorio.ClienteRepositorio;
import com.dan.cliente.servicio.ClienteServicio;
import com.dan.cliente.servicio.ObraServicio;
import com.dan.cliente.servicio.TipoClienteServicio;
import com.dan.cliente.servicio.UsuarioServicio;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    private final ClienteRepositorio clienteRepositorio;
    private final ObraServicio obraServicio;
    private final TipoClienteServicio tipoClienteServicio;
    private final UsuarioServicio usuarioServicio;

    public ClienteServicioImpl(ClienteRepositorio clienteRepositorio,
                               @Lazy ObraServicio obraServicio,
                               TipoClienteServicio tipoClienteServicio,
                               UsuarioServicio usuarioServicio) {
        this.clienteRepositorio = clienteRepositorio;
        this.obraServicio = obraServicio;
        this.tipoClienteServicio = tipoClienteServicio;
        this.usuarioServicio = usuarioServicio;
    }

    @Override
    public Optional<Cliente> crear(Cliente cliente) {
        Usuario usuario = usuarioServicio.crear(cliente.getUsuario());
        Optional<TipoCliente> optionalTipoCliente = tipoClienteServicio.obtenerPorId(cliente.getTipoCliente().getId());
        return optionalTipoCliente.map(tipoCliente -> {
            cliente.setUsuario(usuario);
            cliente.setTipoCliente(tipoCliente);
            return Optional.of(clienteRepositorio.save(cliente));
        }).orElse(Optional.empty());
    }

    @Override
    public Optional<Cliente> obtenerPorCuit(String cuit) {
        return clienteRepositorio.findByCuitAndFechaBajaIsNull(cuit);
    }

    @Override
    public List<Cliente> obtenerPorRazonSocial(String razonSocial) {
        if (StringUtils.isNotBlank(razonSocial)) {
            return clienteRepositorio.findAllByRazonSocialLikeAndFechaBajaIsNull(razonSocial);
        }

        return clienteRepositorio.findAllByFechaBajaIsNull();
    }

    @Override
    public Optional<Cliente> obtenerPorId(Integer id) {
        return clienteRepositorio.findById(id);
    }

    @Override
    public Optional<Cliente> obtenerPorObraId(Integer obraId) {
        Optional<Obra> optionalObra = obraServicio.obtenerPorId(obraId);
        return optionalObra.map(Obra::getCliente);
    }

    @Override
    public Optional<Cliente> eliminar(Integer clienteId) {
        Optional<Cliente> opcional = clienteRepositorio.findByIdAndFechaBajaIsNull(clienteId);
        return opcional.map(cliente -> {
            cliente.setFechaBaja(LocalDate.now());
            clienteRepositorio.save(cliente);
            return opcional;
        }).orElse(Optional.empty());
    }
}
