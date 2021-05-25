package com.dan.cuenta.repositiorio;


import com.dan.cuenta.dominio.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequeRepositorio extends JpaRepository<Cheque, Integer> {
}
