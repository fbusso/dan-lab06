package dom.dan.pedido.controlador;

import dom.dan.pedido.dominio.Detalle;
import dom.dan.pedido.dominio.EstadoPedido;
import dom.dan.pedido.dominio.Pedido;
import dom.dan.pedido.excepcion.EstadoPedidoRechazadoException;
import dom.dan.pedido.servicio.DetalleServicio;
import dom.dan.pedido.servicio.EstadoPedidoServicio;
import dom.dan.pedido.servicio.PedidoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/pedido")
public class PedidoControlador {

    private final PedidoServicio pedidoServicio;
    private final EstadoPedidoServicio estadoPedidoServicio;
    private final DetalleServicio detalleServicio;

    public PedidoControlador(PedidoServicio pedidoServicio, EstadoPedidoServicio estadoPedidoServicio, DetalleServicio detalleServicio) {
        this.pedidoServicio = pedidoServicio;
        this.estadoPedidoServicio = estadoPedidoServicio;
        this.detalleServicio = detalleServicio;
    }

    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody Pedido pedido) {
        if (pedido.getObra() != null && pedido.getObra() > 0
                && pedido.getDetallePedido() != null && pedido.getDetallePedido().size() > 0
                && pedido.getDetallePedido().stream().allMatch(p -> p.getCantidad() != null && p.getCantidad() > 0 && p.getMaterial() != null)) {

            pedido.setEstadoPedido(estadoPedidoServicio.obtenerPorNombre("NUEVO").get());
            pedido.getDetallePedido().stream().forEach(d -> d.setPedido(pedido));

            return ResponseEntity.ok(pedidoServicio.crear(pedido));
        }

        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/obra/{id}")
    public ResponseEntity<List<Pedido>> obtenerPorObra(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoServicio.obtenerPorObra(id));
    }

    @GetMapping("/estado/{id}")
    public ResponseEntity<List<Pedido>> obtenerPorEstado(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoServicio.obtenerPorEstado(id));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Pedido>> obtenerPorCliente(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoServicio.obtenerPorCliente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Integer id, @RequestBody EstadoPedido estadoPedido) throws EstadoPedidoRechazadoException {
        return ResponseEntity.ok(pedidoServicio.actualizarEstado(id, estadoPedido));
    }

    @PostMapping("/{id}/detalle")
    public ResponseEntity<Pedido> agregarItem(@PathVariable Integer id, @RequestBody Detalle detalle) {
        return ResponseEntity.ok(pedidoServicio.agregarDetalle(id, detalle));
    }

    @PutMapping("/{id}/detalle")
    public ResponseEntity<Pedido> actualizarItem(@PathVariable Integer id, @RequestBody Set<Detalle> detallesPedido) {
        return ResponseEntity.ok(pedidoServicio.actualizarDetalle(id, detallesPedido));
    }

    @DeleteMapping("/{id}/detalle")
    public ResponseEntity<Pedido> quitarItem(@PathVariable Integer id, @RequestBody Detalle detalle) {
        return ResponseEntity.ok(pedidoServicio.quitarItemDetalle(id, detalle));
    }
}
