package dom.dan.pedido.dto;

public class ObraDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private ClienteDTO cliente;
    private TipoObraDTO tipoObra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public TipoObraDTO getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(TipoObraDTO tipoObra) {
        this.tipoObra = tipoObra;
    }
}
