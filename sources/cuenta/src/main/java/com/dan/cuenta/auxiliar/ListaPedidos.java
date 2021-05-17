package com.dan.cuenta.auxiliar;

import com.dan.cuenta.dto.PedidoDTO;

import java.util.ArrayList;
import java.util.List;

public class ListaPedidos {
    private List<PedidoDTO> pedidos;

    public ListaPedidos() {
        pedidos = new ArrayList<>();
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }
}
