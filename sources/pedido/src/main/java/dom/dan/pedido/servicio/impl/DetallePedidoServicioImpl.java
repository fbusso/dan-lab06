package dom.dan.pedido.servicio.impl;

import dom.dan.pedido.dominio.DetallePedido;
import dom.dan.pedido.repositorio.DetallePedidoRepositorio;
import dom.dan.pedido.servicio.DetallePedidoServicio;

public class DetallePedidoServicioImpl implements DetallePedidoServicio {
    private final DetallePedidoRepositorio detallePedidoRepositorio;

    public DetallePedidoServicioImpl(DetallePedidoRepositorio detallePedidoRepositorio) {
        this.detallePedidoRepositorio = detallePedidoRepositorio;
    }

    @Override
    public DetallePedido actualizar(DetallePedido detallePedido) {
        return detallePedidoRepositorio.save(detallePedido);
    }
}
