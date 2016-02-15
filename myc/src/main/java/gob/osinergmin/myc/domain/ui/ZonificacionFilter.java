/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author jpiro
 */
public class ZonificacionFilter extends BasePaginatorFilter {
    private Long idZonificacion;
    private String estado;
    private String nombre;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdZonificacion() {
        return idZonificacion;
    }

    public void setIdZonificacion(Long idZonificacion) {
        this.idZonificacion = idZonificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}