package dom.dan.pedido.servicio.impl;

import dom.dan.pedido.dominio.EstadoPedido;
import dom.dan.pedido.repositorio.EstadoPedidoRepositorio;
import dom.dan.pedido.servicio.EstadoPedidoServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoPedidoServicioImpl implements EstadoPedidoServicio {
    private final EstadoPedidoRepositorio estadoPedidoRepositorio;

    public EstadoPedidoServicioImpl(EstadoPedidoRepositorio estadoPedidoRepositorio) {
        this.estadoPedidoRepositorio = estadoPedidoRepositorio;
    }

    @Override
    public Optional<EstadoPedido> obtenerPorId(Integer id) {
        return estadoPedidoRepositorio.findById(id);
    }

    @Override
    public Optional<EstadoPedido> obtenerPorNombre(String nombre) {
        return estadoPedidoRepositorio.findByNombre(nombre);
    }
}
