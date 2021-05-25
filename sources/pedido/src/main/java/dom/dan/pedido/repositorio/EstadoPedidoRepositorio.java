package dom.dan.pedido.repositorio;

import dom.dan.pedido.dominio.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoPedidoRepositorio extends JpaRepository<EstadoPedido, Integer> {
    Optional<EstadoPedido> findByNombre(String nombre);
}
