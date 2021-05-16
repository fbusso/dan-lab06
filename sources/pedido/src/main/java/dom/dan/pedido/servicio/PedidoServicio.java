package dom.dan.pedido.servicio;

import dom.dan.pedido.dominio.DetallePedido;
import dom.dan.pedido.dominio.EstadoPedido;
import dom.dan.pedido.dominio.Pedido;

import java.util.List;

public interface PedidoServicio {
    Pedido crear(Pedido pedido);

    Pedido obtenerPorId(Integer id);

    List<Pedido> obtenerPorObra(Integer id);

    List<Pedido> obtenerPorEstado(Integer id);

    Pedido actualizarEstado(Integer id, EstadoPedido estadoPedido);

    Pedido agregarDetalle(Integer id, DetallePedido detallePedido);

    Pedido actualizarDetalle(Integer id, List<DetallePedido> detallePedido);

    Pedido quitarItemDetalle(Integer id, DetallePedido detallePedido);
}