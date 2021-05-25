package com.dan.cuenta.dominio;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "EFECTIVO")
public class Efectivo extends MedioPago{
    private Integer numeroRecibo;

    public Efectivo() {}

    public Efectivo(String observacion, Pago pago, Integer numeroRecibo) {
        super(observacion, pago);
        this.numeroRecibo = numeroRecibo;
    }

    public Integer getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(Integer numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }
}
