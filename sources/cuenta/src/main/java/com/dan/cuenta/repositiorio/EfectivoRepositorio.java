package com.dan.cuenta.repositiorio;


import com.dan.cuenta.dominio.Efectivo;
import com.dan.cuenta.dominio.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfectivoRepositorio extends JpaRepository<Efectivo, Integer> {
}
