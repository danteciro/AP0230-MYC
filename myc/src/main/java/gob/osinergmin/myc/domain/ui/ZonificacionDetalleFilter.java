/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

/**
 *
 * @author lbarboza
 */
public class ZonificacionDetalleFilter {
    private Long idZonificacionDetalle;
    private Long idZonificacion;
    private String estado;

    public Long getIdZonificacionDetalle() {
        return idZonificacionDetalle;
    }

    public void setIdZonificacionDetalle(Long idZonificacionDetalle) {
        this.idZonificacionDetalle = idZonificacionDetalle;
    }

    public Long getIdZonificacion() {
        return idZonificacion;
    }

    public void setIdZonificacion(Long idZonificacion) {
        this.idZonificacion = idZonificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}