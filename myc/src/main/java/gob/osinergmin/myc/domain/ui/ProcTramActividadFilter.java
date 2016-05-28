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
public class ProcTramActividadFilter extends BasePaginatorFilter{
    private Long idProcedimientoTramite;
    private Long idActividad;
    private String estado;

    public ProcTramActividadFilter(){
    }
    
    public ProcTramActividadFilter(Long idProcedimientoTramite,String estado){
        this.idProcedimientoTramite=idProcedimientoTramite;
        this.estado=estado;
    }
    
    public ProcTramActividadFilter(Long idProcedimientoTramite,Long idActividad,String estado){
        this.idProcedimientoTramite=idProcedimientoTramite;
        this.idActividad=idActividad;
        this.estado=estado;
    }
    
    public Long getIdProcedimientoTramite() {
        return idProcedimientoTramite;
    }

    public void setIdProcedimientoTramite(Long idProcedimientoTramite) {
        this.idProcedimientoTramite = idProcedimientoTramite;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
