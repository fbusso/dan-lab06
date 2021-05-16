package dom.dan.pedido.servicio;

import dom.dan.pedido.dominio.DetallePedido;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface DetallePedidoServicio {
    DetallePedido actualizar(DetallePedido detallePedido);
}
