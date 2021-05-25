package dom.dan.pedido.dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Detalle> detallePedido;
    private LocalDate fechaEnvio;
    private Integer obra;
    @OneToOne
    private EstadoPedido estadoPedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Integer getObra() {
        return obra;
    }

    public void setObra(Integer obra) {
        this.obra = obra;
    }

    public Set<Detalle> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(Set<Detalle> detallePedido) {
        this.detallePedido = detallePedido;
    }
}
