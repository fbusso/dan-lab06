package com.dan.cuenta.repositiorio;

import com.dan.cuenta.dominio.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepositorio extends JpaRepository<Transferencia, Integer> {
}
