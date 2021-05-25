package com.dan.cuenta.repositiorio;

import com.dan.cuenta.dominio.MedioPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MedioPagoRepositorio extends JpaRepository<MedioPago, Integer> {
}

