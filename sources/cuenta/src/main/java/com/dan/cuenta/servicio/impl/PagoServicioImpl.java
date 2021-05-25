package com.dan.cuenta.servicio.impl;

import com.dan.cuenta.dominio.*;
import com.dan.cuenta.dto.EstadoCuentaDTO;
import com.dan.cuenta.repositiorio.MedioPagoRepositorio;
import com.dan.cuenta.repositiorio.PagoRepositorio;
import com.dan.cuenta.repositiorio.TransferenciaRepositorio;
import com.dan.cuenta.servicio.PagoServicio;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PagoServicioImpl implements PagoServicio {

    private final PagoRepositorio pagoRepositorio;
    private final TransferenciaRepositorio transferenciaRepositorio;

    public PagoServicioImpl(PagoRepositorio pagoRepositorio, TransferenciaRepositorio transferenciaRepositorio) {
        this.pagoRepositorio = pagoRepositorio;
        this.transferenciaRepositorio = transferenciaRepositorio;
    }

    @Override
    @Transactional
    public Optional<Pago> crear(Pago pago) {

        MedioPago medioPago = pago.getMedioPago();

        switch (medioPago.getDtype()){
            case "EFECTIVO":
                pago.setMedioPago(new Efectivo(medioPago.getObservacion(),medioPago.getPago(),medioPago.getNumeroRecibo()));
                break;
            case "CHEQUE":
                pago.setMedioPago(new Cheque("test",medioPago.getPago(), medioPago.getNumeroCheque(), medioPago.getFechaCobro(), medioPago.getBanco()));
                break;
            case "TRANSFERENCIA":
                pago.setMedioPago(new Transferencia("test",medioPago.getPago(), medioPago.getCbuOrigen(), medioPago.getCbuDestino(), medioPago.getCodigoTransferencia()));
                break;
            default:
        }
        return Optional.of(pagoRepositorio.save(pago));
    }

    @Override
    public Optional<EstadoCuentaDTO> estado(Integer clienteId) {
        EstadoCuentaDTO estadoCuentaDTO = new EstadoCuentaDTO();
        final String uri = "http://localhost:9002/api/pedido/cliente/{clienteId}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("clienteId", String.valueOf(clienteId));

        restTemplate.setErrorHandler(new ErrorHandler());
        List pedidos = restTemplate.getForObject(uri, List.class, params);

        estadoCuentaDTO.setPedidos(pedidos);
        estadoCuentaDTO.setPagos(pagoRepositorio.findByClienteId(clienteId));

        return Optional.of(estadoCuentaDTO);
    }
}
