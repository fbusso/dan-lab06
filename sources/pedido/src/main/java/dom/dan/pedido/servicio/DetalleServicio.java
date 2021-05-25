package dom.dan.pedido.servicio;

import dom.dan.pedido.dominio.Detalle;
import dom.dan.pedido.dominio.Pedido;

import java.util.List;
import java.util.Optional;

public interface DetalleServicio {
    Detalle guardar(Detalle detalle);
    Detalle actualizar(Detalle detalle);
    void eliminarPorPedido(Pedido pedido);
    void eliminarPorId(Integer id);
    List<Detalle> buscarPorPedido(Pedido pedido);
    Optional<Detalle> obtenerPorId(Integer id);
}
