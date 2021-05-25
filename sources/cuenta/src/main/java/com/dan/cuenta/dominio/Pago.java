package com.dan.cuenta.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fechaPago;
    private Double monto;
    private Integer clienteId;
    @OneToOne(mappedBy = "pago", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, optional = false)
    private MedioPago medioPago;

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        if (medioPago == null) {
            if (this.medioPago != null) {
                this.medioPago.setPago(null);
            }
        }
        else {
            medioPago.setPago(this);
        }
        this.medioPago = medioPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
