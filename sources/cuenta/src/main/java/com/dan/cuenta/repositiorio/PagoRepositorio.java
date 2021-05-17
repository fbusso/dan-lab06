package com.dan.cuenta.repositiorio;

import com.dan.cuenta.dominio.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepositorio extends JpaRepository<Pago, Integer> {
    List<Pago> findByClienteId(Integer clienteId);
}
