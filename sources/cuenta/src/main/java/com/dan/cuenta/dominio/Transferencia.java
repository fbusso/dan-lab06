package com.dan.cuenta.dominio;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "TRANSFERENCIA")
public class Transferencia extends MedioPago{
    private String cbuOrigen;
    private String cbuDestino;
    private Long codigoTransferencia;

    public Transferencia() {}

    public Transferencia(String observacion, Pago pago, String cbuOrigen, String cbuDestino, Long codigoTransferencia) {
        super(observacion, pago);
        this.cbuOrigen = cbuOrigen;
        this.cbuDestino = cbuDestino;
        this.codigoTransferencia = codigoTransferencia;
    }

    public String getCbuOrigen() {
        return cbuOrigen;
    }

    public void setCbuOrigen(String cbuOrigen) {
        this.cbuOrigen = cbuOrigen;
    }

    public String getCbuDestino() {
        return cbuDestino;
    }

    public void setCbuDestino(String cbuDestino) {
        this.cbuDestino = cbuDestino;
    }

    public Long getCodigoTransferencia() {
        return codigoTransferencia;
    }

    public void setCodigoTransferencia(Long codigoTransferencia) {
        this.codigoTransferencia = codigoTransferencia;
    }
}
