package dom.dan.pedido.servicio.impl;

import dom.dan.pedido.dominio.Detalle;
import dom.dan.pedido.repositorio.DetallePedidoRepositorio;
import dom.dan.pedido.servicio.DetalleServicio;

public class DetalleServicioImpl implements DetalleServicio {
    private final DetallePedidoRepositorio detallePedidoRepositorio;

    public DetalleServicioImpl(DetallePedidoRepositorio detallePedidoRepositorio) {
        this.detallePedidoRepositorio = detallePedidoRepositorio;
    }

    @Override
    public Detalle actualizar(Detalle detalle) {
        return detallePedidoRepositorio.save(detalle);
    }
}
