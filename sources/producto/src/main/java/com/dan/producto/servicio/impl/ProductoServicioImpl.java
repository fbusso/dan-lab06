package com.dan.producto.servicio.impl;

import com.dan.producto.dominio.Producto;
import com.dan.producto.repositorio.ProductoRepositorio;
import com.dan.producto.servicio.ProductoServicio;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio {
    private final ProductoRepositorio productoRepositorio;

    public ProductoServicioImpl(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public Optional<Producto> crear(Producto producto) {
        return Optional.of(productoRepositorio.save(producto));
    }

    @Override
    public Optional<Producto> obtenerPorId(Integer id) {
        return productoRepositorio.findById(id);
    }

    @Override
    public List<Producto> obtenerPorRango(Integer stockDesde, Integer stockHasta) {
        return productoRepositorio.findByStockIsBetween(stockDesde, stockHasta);
    }

    @Override
    public List<Producto> obtenerPorPrecio(BigDecimal precio) {
        return productoRepositorio.findByPrecio(precio);
    }

    @Override
    public Producto actualizar(Producto producto) {
        return productoRepositorio.save(producto);
    }
}
