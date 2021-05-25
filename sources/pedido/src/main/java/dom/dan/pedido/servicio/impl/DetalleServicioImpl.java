package dom.dan.pedido.servicio.impl;

import dom.dan.pedido.dominio.Detalle;
import dom.dan.pedido.dominio.Pedido;
import dom.dan.pedido.repositorio.DetallePedidoRepositorio;
import dom.dan.pedido.servicio.DetalleServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServicioImpl implements DetalleServicio {
    private final DetallePedidoRepositorio detallePedidoRepositorio;

    public DetalleServicioImpl(DetallePedidoRepositorio detallePedidoRepositorio) {
        this.detallePedidoRepositorio = detallePedidoRepositorio;
    }

    @Override
    public Detalle guardar(Detalle detalle) {
        return detallePedidoRepositorio.save(detalle);
    }

    @Override
    public Detalle actualizar(Detalle detalle) {
        return detallePedidoRepositorio.save(detalle);
    }

    @Override
    public void eliminarPorPedido(Pedido pedido) {
        detallePedidoRepositorio.deleteByPedido(pedido);
    }

    @Override
    public void eliminarPorId(Integer id) {
        detallePedidoRepositorio.deleteById(id);
    }

    @Override
    public List<Detalle> buscarPorPedido(Pedido pedido) {
        return null;
    }

    @Override
    public Optional<Detalle> obtenerPorId(Integer id) {
        return detallePedidoRepositorio.findById(id);
    }
}
