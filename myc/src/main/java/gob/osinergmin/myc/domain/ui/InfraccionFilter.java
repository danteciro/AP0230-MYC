package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class InfraccionFilter extends BasePaginatorFilter{
	private Long idDetalleObligacion;
    private String descripcion;

    public Long getIdDetalleObligacion() {
        return idDetalleObligacion;
    }

    public void setIdDetalleObligacion(Long idDetalleObligacion) {
        this.idDetalleObligacion = idDetalleObligacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
