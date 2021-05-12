package com.dan.producto.controlador;

import com.dan.producto.dominio.Producto;
import com.dan.producto.servicio.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {
    private final ProductoServicio productoServicio;

    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        return productoServicio
                .crear(producto)
                .map(entidad -> new ResponseEntity<>(entidad, HttpStatus.CREATED))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Producto> actualizar(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoServicio.actualizar(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.of(productoServicio.obtenerPorId(id));
    }

    @GetMapping("/rango")
    public ResponseEntity<List<Producto>> obtenerPorRango(@RequestParam Integer stockDesde, @RequestParam Integer stockHasta) {
        return ResponseEntity.ok(productoServicio.obtenerPorRango(stockDesde, stockHasta));
    }

    @GetMapping("/precio")
    public ResponseEntity<List<Producto>> obtenerPorPrecio(@RequestParam BigDecimal precio) {
        return ResponseEntity.ok(productoServicio.obtenerPorPrecio(precio));
    }
}
