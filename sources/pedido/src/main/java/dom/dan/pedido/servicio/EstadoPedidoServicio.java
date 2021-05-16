package dom.dan.pedido.servicio;

import dom.dan.pedido.dominio.EstadoPedido;

import java.util.Optional;

public interface EstadoPedidoServicio {
    Optional<EstadoPedido> obtenerPorId(Integer id);
    Optional<EstadoPedido> obtenerPorNombre(String nombre);
}
