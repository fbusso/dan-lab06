package dom.dan.pedido.repositorio;

import dom.dan.pedido.dominio.Detalle;
import dom.dan.pedido.dominio.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallePedidoRepositorio extends JpaRepository<Detalle, Integer> {
    void deleteByPedido(Pedido pedido);
    List<Detalle> findByPedido(Pedido pedido);
}
