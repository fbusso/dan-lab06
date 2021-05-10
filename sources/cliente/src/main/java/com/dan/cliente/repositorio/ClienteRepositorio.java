package com.dan.cliente.repositorio;

import com.dan.cliente.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCuitAndFechaBajaIsNull(String cuit);

    Optional<Cliente> findByIdAndFechaBajaIsNull(Integer id);

    List<Cliente> findAllByFechaBajaIsNull();

    List<Cliente> findAllByRazonSocialLikeAndFechaBajaIsNull(String razonSocial);
}
