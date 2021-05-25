package dom.dan.pedido.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ClienteDTO {
    private Integer id;
    private String cuit;
    private LocalDate fechaBaja;
    private String razonSocial;
    private BigDecimal saldo;
    private UsuarioDTO usuario;
    private TipoClienteDTO tipoCliente;
    private List<ObraDTO> obras;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public TipoClienteDTO getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoClienteDTO tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<ObraDTO> getObras() {
        return obras;
    }

    public void setObras(List<ObraDTO> obras) {
        this.obras = obras;
    }
}
