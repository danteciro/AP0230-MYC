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
public class TipificacionSancionFilter extends BasePaginatorFilter{
    private Long idTipiSanc;
    private Long idTipificacion;
    private Long idTipoSancion;
    private String estado;
    private Long idCriterio;
    private Long nivel;
    private Long idDetalleCriterio;

    public TipificacionSancionFilter() {
    }

    public TipificacionSancionFilter(Long idDetalleCriterio,String estado) {
        this.estado = estado;
        this.idDetalleCriterio = idDetalleCriterio;
    }

    public Long getIdDetalleCriterio() {
        return idDetalleCriterio;
    }

    public void setIdDetalleCriterio(Long idDetalleCriterio) {
        this.idDetalleCriterio = idDetalleCriterio;
    }

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public Long getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Long idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Long getIdTipiSanc() {
        return idTipiSanc;
    }

    public void setIdTipiSanc(Long idTipiSanc) {
        this.idTipiSanc = idTipiSanc;
    }

    public Long getIdTipificacion() {
        return idTipificacion;
    }

    public void setIdTipificacion(Long idTipificacion) {
        this.idTipificacion = idTipificacion;
    }

    public Long getIdTipoSancion() {
        return idTipoSancion;
    }

    public void setIdTipoSancion(Long idTipoSancion) {
        this.idTipoSancion = idTipoSancion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}