package com.dan.cliente.servicio.impl;

import com.dan.cliente.dominio.Usuario;
import com.dan.cliente.repositorio.UsuarioRepositorio;
import com.dan.cliente.servicio.UsuarioServicio;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario crear(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
