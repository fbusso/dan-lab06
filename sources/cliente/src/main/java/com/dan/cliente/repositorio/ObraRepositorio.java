package com.dan.cliente.repositorio;

import com.dan.cliente.dominio.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepositorio extends JpaRepository<Obra, Integer> {
}
