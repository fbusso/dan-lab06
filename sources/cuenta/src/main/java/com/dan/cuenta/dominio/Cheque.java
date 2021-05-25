package com.dan.cuenta.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "CHEQUE")
public class Cheque extends MedioPago{
    private Integer numeroCheque;
    private LocalDate fechaCobro;
    private String banco;

    public Cheque() {}

    public Cheque(String observacion, Pago pago, Integer numeroCheque, LocalDate fechaCobro, String banco) {
        super(observacion, pago);
        this.numeroCheque = numeroCheque;
        this.fechaCobro = fechaCobro;
        this.banco = banco;
    }

    public Integer getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(Integer numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public LocalDate getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(LocalDate fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
