package dom.dan.pedido.servicio;

import dom.dan.pedido.dominio.Detalle;
import dom.dan.pedido.dominio.EstadoPedido;
import dom.dan.pedido.dominio.Pedido;
import dom.dan.pedido.excepcion.EstadoPedidoRechazadoException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PedidoServicio {
    Pedido crear(Pedido pedido);

    Optional<Pedido> obtenerPorId(Integer id);

    List<Pedido> obtenerPorObra(Integer id);

    List<Pedido> obtenerPorEstado(Integer id);

    Pedido actualizarEstado(Integer id, EstadoPedido estadoPedido) throws EstadoPedidoRechazadoException;

    Pedido agregarDetalle(Integer id, Detalle detalle);

    Pedido actualizarDetalle(Integer id, Set<Detalle> detalle);

    Pedido quitarItemDetalle(Integer id, Detalle detalle);

    List<Pedido> obtenerPorCliente(Integer idCliente);
}