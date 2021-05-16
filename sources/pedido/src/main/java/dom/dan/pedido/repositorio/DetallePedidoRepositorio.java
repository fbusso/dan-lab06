package dom.dan.pedido.repositorio;

import dom.dan.pedido.dominio.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer> {

}
