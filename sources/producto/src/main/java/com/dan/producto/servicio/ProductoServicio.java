package com.dan.producto.servicio;

import com.dan.producto.dominio.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductoServicio {
    Optional<Producto> crear(Producto producto);

    Optional<Producto> obtenerPorId(Integer id);

    List<Producto> obtenerPorRango(Integer stockDesde, Integer stockHasta);

    List<Producto> obtenerPorPrecio(BigDecimal precio);

    Producto actualizar(Producto producto);
}
