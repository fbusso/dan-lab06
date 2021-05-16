package dom.dan.pedido.repositorio;

import dom.dan.pedido.dominio.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByObra(Integer id);

    List<Pedido> findByEstadoPedido_Id(Integer id);
}