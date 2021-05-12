package com.dan.producto.repositorio;

import com.dan.producto.dominio.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    List<Producto> findByPrecio(BigDecimal precio);

    List<Producto> findByStockIsBetween(Integer stockDesde, Integer stockHasta);
}
