package com.dan.cuenta.servicio.impl;

import com.dan.cuenta.auxiliar.ListaPedidos;
import com.dan.cuenta.dto.EstadoCuentaDTO;
import com.dan.cuenta.dominio.Pago;
import com.dan.cuenta.repositiorio.PagoRepositorio;
import com.dan.cuenta.servicio.PagoServicio;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.dan.cuenta.dominio.ErrorHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PagoServicioImpl implements PagoServicio {

    private final PagoRepositorio pagoRepositorio;

    public PagoServicioImpl(PagoRepositorio pagoRepositorio) {
        this.pagoRepositorio = pagoRepositorio;
    }

    @Override
    public Optional<Pago> crear(Pago pago) {
        Pago pagoNuevo = pago;
        pagoNuevo.setFechaPago(LocalDate.now());
        return Optional.of(pagoRepositorio.save(pagoNuevo));
    }

    @Override
    public Optional<EstadoCuentaDTO> estado(Integer clienteId) {
        EstadoCuentaDTO estadoCuentaDTO = new EstadoCuentaDTO();
        final String uri = "http://localhost:9002/api/pedido/cliente/{clienteId}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("clienteId", String.valueOf(clienteId));

        restTemplate.setErrorHandler(new ErrorHandler());
        ListaPedidos pedidos = restTemplate.getForObject(uri, ListaPedidos.class, params);

        estadoCuentaDTO.setPedidos(pedidos.getPedidos());
        estadoCuentaDTO.setPagos(pagoRepositorio.findByClienteId(clienteId));

        return Optional.of(estadoCuentaDTO);
    }
}
