package com.dan.cuenta.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MedioPago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String observacion;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pago_id")
    @JsonIgnore
    private Pago pago;
    @Column(insertable = false, updatable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dtype;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer numeroCheque;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate fechaCobro;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String banco;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer numeroRecibo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cbuOrigen;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cbuDestino;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long codigoTransferencia;

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

    public Integer getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(Integer numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
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

    public MedioPago() {}

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public MedioPago(String observacion, Pago pago) {
        this.observacion = observacion;
        this.pago = pago;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
