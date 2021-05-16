package dom.dan.pedido.repositorio;

import dom.dan.pedido.dominio.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepositorio extends JpaRepository<Detalle, Integer> {

}
