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
public class CnfRequProcedimientoFilter extends BasePaginatorFilter {
    private Long idProcedimiento;
    private String estado;
    private String flgGeneral;
    private Long idTramite;
    private Long idActividad;
    
    public CnfRequProcedimientoFilter(){
    }
    public CnfRequProcedimientoFilter(Long idProcedimiento,String estado){
        this.idProcedimiento=idProcedimiento;
        this.estado=estado;
    }
    public CnfRequProcedimientoFilter(Long idProcedimiento,Long idTramite,Long idActividad,String estado){
        this.idProcedimiento=idProcedimiento;
        this.idTramite=idTramite;
        this.idActividad=idActividad;
        this.estado=estado;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }
    
    public String getFlgGeneral() {
        return flgGeneral;
    }
    

    public void setFlgGeneral(String flgGeneral) {
        this.flgGeneral = flgGeneral;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }
    
}
