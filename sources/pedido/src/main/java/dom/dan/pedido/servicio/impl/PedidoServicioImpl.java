package dom.dan.pedido.servicio.impl;

import dom.dan.pedido.dominio.DetallePedido;
import dom.dan.pedido.dominio.EstadoPedido;
import dom.dan.pedido.dominio.Pedido;
import dom.dan.pedido.excepcion.EstadoPedidoRechazadoException;
import dom.dan.pedido.repositorio.PedidoRepositorio;
import dom.dan.pedido.servicio.EstadoPedidoServicio;
import dom.dan.pedido.servicio.PedidoServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServicioImpl implements PedidoServicio {
    private final PedidoRepositorio pedidoRepositorio;
    private final EstadoPedidoServicio estadoPedidoServicio;

    public PedidoServicioImpl(PedidoRepositorio pedidoRepositorio, EstadoPedidoServicio estadoPedidoServicio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.estadoPedidoServicio = estadoPedidoServicio;
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
    public Pedido actualizarEstado(Integer id, EstadoPedido estadoPedido) {
        Optional<EstadoPedido> estadoPedidoOptional = estadoPedidoServicio.obtenerPorId(estadoPedido.getId());
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);

        if(estadoPedidoOptional.isPresent() && pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            if(!"CONFIRMADO".equalsIgnoreCase(estadoPedidoOptional.get().getNombre())) {
                pedido.setEstadoPedido(estadoPedidoOptional.get());
                return pedidoRepositorio.save(pedido);
            }
            else {
                return confirmarPedido(pedido);
            }
        }
        else {
            // TODO: Exception
        }

        return null;
    }

    @Override
    public Pedido obtenerPorId(Integer id) {
        return pedidoRepositorio.findById(id);
    }

    @Override
    public List<Pedido> obtenerPorEstado(Integer id) {
        return pedidoRepositorio.findByEstadoPedido_Id(id);
    }

    private Pedido confirmarPedido(Pedido pedido) throws EstadoPedidoRechazadoException {
        boolean stockCheck = pedido.getDetalle().stream().noneMatch(d -> d.getCantidad().equals(0));
        boolean saldoDeudor = false;
        boolean situacionCrediticia = true;

        if(stockCheck && (!saldoDeudor || situacionCrediticia)) {
            pedido.setEstadoPedido(estadoPedidoServicio.obtenerPorNombre("ACEPTADO").get());
            pedidoRepositorio.save(pedido);
        }
        else (!stockCheck) {
            pedido.setEstadoPedido(estadoPedidoServicio.obtenerPorNombre("PENDIENTE").get());
            pedidoRepositorio.save(pedido);
        }
        else (!saldoDeudor && !situacionCrediticia) {
            pedido.setEstadoPedido(estadoPedidoServicio.obtenerPorNombre("RECHAZADO").get());
            pedidoRepositorio.save(pedido);

            throw new EstadoPedidoRechazadoException();
        }
    }

    @Override
    public Pedido agregarDetalle(Integer id, DetallePedido detallePedido) {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);
        Pedido pedido = null;

        if(pedidoOptional.isPresent()) {
            pedido = pedidoOptional.get();
            pedido.getDetalle().add(detallePedido);
            pedidoRepositorio.save(pedido);
        }

        return pedido;
    }

    @Override
    public Pedido actualizarDetalle(Integer id, List<DetallePedido> detallePedido) {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);
        Pedido pedido = null;

        if(pedidoOptional.isPresent()) {
            pedido = pedidoOptional.get();
            pedido.setDetalle(detallePedido);
            pedidoRepositorio.save(pedido);
        }

        return pedido;
    }

    @Override
    public Pedido quitarItemDetalle(Integer id, DetallePedido detallePedido) {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);
        Pedido pedido = null;

        if(pedidoOptional.isPresent()) {
            pedido = pedidoOptional.get();
            pedido.setDetalle(pedido.getDetalle().stream().filter(d -> !d.equals(detallePedido)).collect(Collectors.toList()));
            pedidoRepositorio.save(pedido);
        }

        return pedido;
    }
}