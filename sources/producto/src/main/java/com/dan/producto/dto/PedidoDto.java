package com.dan.producto.dto;

import java.time.LocalDate;
import java.util.Set;

public class PedidoDto {

    private Integer id;
    private Set<DetallePedidoDto> detallePedido;
    private LocalDate fechaEnvio;
    private Integer obra;
    private EstadoPedidoDto estadoPedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<DetallePedidoDto> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(Set<DetallePedidoDto> detallePedido) {
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

    public EstadoPedidoDto getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedidoDto estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}
