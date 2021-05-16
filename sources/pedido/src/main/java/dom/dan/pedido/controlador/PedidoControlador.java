package dom.dan.pedido.controlador;

import dom.dan.pedido.dominio.DetallePedido;
import dom.dan.pedido.dominio.ErrorHandler;
import dom.dan.pedido.dominio.EstadoPedido;
import dom.dan.pedido.dominio.Pedido;
import dom.dan.pedido.servicio.PedidoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedido")
public class PedidoControlador {

    private final PedidoServicio pedidoServicio;

    public PedidoControlador(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody Pedido pedido) {

        final String uri = "http://localhost:9000/api/cliente/{id}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(pedido.getObra()));

        restTemplate.setErrorHandler(new ErrorHandler());
        String result = restTemplate.getForObject(uri, String.class, params);

        //return pedidoServicio
          //      .crear(pedido)
            //    .map(entidad -> new ResponseEntity<>(entidad, HttpStatus.CREATED))
              //  .orElse(ResponseEntity.notFound().build());
        return ResponseEntity.ok(new Pedido());
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
        // TODO: consumir
        return null;//ResponseEntity.of(pedidoServicio.obtenerPorCliente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Integer id, @RequestBody EstadoPedido estadoPedido) {
        final String uri = "http://localhost:9000/api/cliente/{id}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(pedidoServicio.obtenerPorId(id)));

        restTemplate.setErrorHandler(new ErrorHandler());
        String result = restTemplate.getForObject(uri, String.class, params);

        return ResponseEntity.ok(pedidoServicio.actualizarEstado(id, estadoPedido));
    }

    @PostMapping("/{id}/detalle")
    public ResponseEntity<Pedido> agregarItem(@PathVariable Integer id, @RequestBody DetallePedido detallePedido) {
        return ResponseEntity.ok(pedidoServicio.agregarDetalle(id, detallePedido));
    }

    @PutMapping("/{id}/detalle")
    public ResponseEntity<Pedido> actualizarItem(@PathVariable Integer id, @RequestBody List<DetallePedido> detallesPedido) {
        return ResponseEntity.ok(pedidoServicio.actualizarDetalle(id, detallesPedido));
    }

    @DeleteMapping("/{id}/detalle")
    public ResponseEntity<Pedido> quitarItem(@PathVariable Integer id, @RequestBody DetallePedido detallePedido) {
        return ResponseEntity.ok(pedidoServicio.quitarItemDetalle(id, detallePedido));
    }
}
