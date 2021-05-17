package com.dan.cuenta.dto;

import com.dan.cuenta.dominio.Detalle;

import java.time.LocalDate;
import java.util.List;

public class PedidoDTO {
    private Integer id;
    private List<Detalle> detallePedido;
    private LocalDate fechaEnvio;
    private Integer obra;
    private EstadoPedidoDTO estadoPedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Detalle> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<Detalle> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Integer getObra() {
        return obra;
    }

    public void setObra(Integer obra) {
        this.obra = obra;
    }

    public EstadoPedidoDTO getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedidoDTO estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}
