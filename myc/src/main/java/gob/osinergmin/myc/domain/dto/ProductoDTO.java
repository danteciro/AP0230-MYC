package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author gvillanueva
 */
public class ProductoDTO {
    private Long idProducto;
    private String descripcionProducto;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
}
