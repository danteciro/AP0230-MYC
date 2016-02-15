/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author lbarboza
 */
public class DetalleObligacionFilter extends BasePaginatorFilter{
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