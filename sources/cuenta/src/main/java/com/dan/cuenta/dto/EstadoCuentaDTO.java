package com.dan.cuenta.dto;

import com.dan.cuenta.dominio.Pago;

import java.util.List;

public class EstadoCuentaDTO {
    List<Pago> pagos;
    List<PedidoDTO> pedidos;

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }


}
