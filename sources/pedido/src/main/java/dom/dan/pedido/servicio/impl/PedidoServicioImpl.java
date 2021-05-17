package dom.dan.pedido.servicio.impl;

import dom.dan.pedido.dominio.Detalle;
import dom.dan.pedido.dominio.ErrorHandler;
import dom.dan.pedido.dominio.EstadoPedido;
import dom.dan.pedido.dominio.Pedido;
import dom.dan.pedido.excepcion.EstadoPedidoRechazadoException;
import dom.dan.pedido.repositorio.PedidoRepositorio;
import dom.dan.pedido.servicio.DetalleServicio;
import dom.dan.pedido.servicio.EstadoPedidoServicio;
import dom.dan.pedido.servicio.PedidoServicio;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class PedidoServicioImpl implements PedidoServicio {
    private final PedidoRepositorio pedidoRepositorio;
    private final EstadoPedidoServicio estadoPedidoServicio;
    private final DetalleServicio detalleServicio;

    public PedidoServicioImpl(PedidoRepositorio pedidoRepositorio, EstadoPedidoServicio estadoPedidoServicio, DetalleServicio detalleServicio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.estadoPedidoServicio = estadoPedidoServicio;
        this.detalleServicio = detalleServicio;
    }

    @Override
    public Pedido crear(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    @Override
    public List<Pedido> obtenerPorObra(Integer id) {
        return pedidoRepositorio.findByObra(id);
    }

    @Override
    public Pedido actualizarEstado(Integer id, EstadoPedido estadoPedido) throws EstadoPedidoRechazadoException {
        Optional<EstadoPedido> estadoPedidoOptional = estadoPedidoServicio.obtenerPorId(estadoPedido.getId());
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);

        if (estadoPedidoOptional.isPresent() && pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            if (!"CONFIRMADO".equalsIgnoreCase(estadoPedidoOptional.get().getNombre())) {
                pedido.setEstadoPedido(estadoPedidoOptional.get());
                return pedidoRepositorio.save(pedido);
            } else {
                return confirmarPedido(pedido);
            }
        } else {
            // TODO: Exception
        }

        return null;
    }

    @Override
    public Optional<Pedido> obtenerPorId(Integer id) {
        return pedidoRepositorio.findById(id);
    }

    @Override
    public List<Pedido> obtenerPorCliente(Integer idCliente) {
        final String uri = "http://localhost:9000/api/cliente/{idCliente}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("idCliente", String.valueOf(idCliente));

        restTemplate.setErrorHandler(new ErrorHandler());
        String result = restTemplate.getForObject(uri, String.class, params);

        // TODO: Aca obtener todas las obras de los clientes
        // TODO: Recorrer la lista de obras y matchear todos los pedidos;
        // TODO: Retornar todos los pedidos que esten en esas obras de esos clientes.

        return null;
    }

    @Override
    public List<Pedido> obtenerPorEstado(Integer id) {
        return pedidoRepositorio.findByEstadoPedido_Id(id);
    }

    private Pedido confirmarPedido(Pedido pedido) throws EstadoPedidoRechazadoException {
        boolean stockCheck = pedido.getDetallePedido().stream().noneMatch(d -> d.getCantidad().equals(0));
        boolean saldoDeudor = false;
        boolean situacionCrediticia = true;

        if (stockCheck && (!saldoDeudor || situacionCrediticia)) {
            pedido.setEstadoPedido(estadoPedidoServicio.obtenerPorNombre("ACEPTADO").get());
            return pedidoRepositorio.save(pedido);
        } else if (!stockCheck) {
            pedido.setEstadoPedido(estadoPedidoServicio.obtenerPorNombre("PENDIENTE").get());
            return pedidoRepositorio.save(pedido);
        } else if (!saldoDeudor && !situacionCrediticia) {
            pedido.setEstadoPedido(estadoPedidoServicio.obtenerPorNombre("RECHAZADO").get());
            pedidoRepositorio.save(pedido);

            throw new EstadoPedidoRechazadoException();
        }

        return null;
    }

    @Override
    public Pedido agregarDetalle(Integer id, Detalle detalle) {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            detalle.setPedido(pedido);
            pedido.getDetallePedido().add(detalle);
            return pedidoRepositorio.save(pedido);
        }

        return null;
    }

    @Override
    @Transactional
    public Pedido actualizarDetalle(Integer id, Set<Detalle> detalles) {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();

            pedido.getDetallePedido().clear();
            detalles.forEach(d -> d.setPedido(pedido));
            pedido.getDetallePedido().addAll(detalles);

            return pedidoRepositorio.save(pedido);
        }

        return null;
    }

    @Override
    public Pedido quitarItemDetalle(Integer id, Detalle detalle) {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            pedido.getDetallePedido().remove(detalleServicio.obtenerPorId(detalle.getId()).get());

            //detalleServicio.eliminarPorId(detalle.getId());
            //return pedidoOptional.get();
            return pedidoRepositorio.save(pedido);
        }

        return null;
    }
}