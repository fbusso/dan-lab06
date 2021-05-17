package com.dan.cuenta.dominio;

import java.util.List;

public class EstadoCuenta {
    List<Pago> pagos;
    List<Pedido> pedidos;

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


}
