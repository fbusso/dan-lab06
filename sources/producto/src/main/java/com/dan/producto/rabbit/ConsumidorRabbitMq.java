package com.dan.producto.rabbit;

import com.dan.producto.dto.PedidoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorRabbitMq {

    @RabbitListener(queues = "COLA_PEDIDOS")
    public void mensajeRecibido(PedidoDto pedido) {
        System.out.println("Mensaje recibido desde RabbitMQ: " + pedido);
    }
}
