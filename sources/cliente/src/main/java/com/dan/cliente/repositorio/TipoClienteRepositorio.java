package com.dan.cliente.repositorio;

import com.dan.cliente.dominio.TipoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoClienteRepositorio extends JpaRepository<TipoCliente, Integer> {
}
