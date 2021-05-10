package com.dan.cliente.repositorio;

import com.dan.cliente.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCuitAndFechaBajaNotNull(String cuit);

    Optional<Cliente> findByIdAndFechaBajaNotNull(Integer id);

    Optional<Cliente> findByObras_idAndFechaBajaNotNull(Integer obraId);

    List<Cliente> findAllByFechaBajaNotNull();

    List<Cliente> findAllByRazonSocialAndFechaBajaNotNull(String razonSocial);
}
