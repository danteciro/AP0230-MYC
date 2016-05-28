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
public class ProcedimientoTramiteFilter extends BasePaginatorFilter {
    Long idProcedimientoTramite;
    Long idProcedimiento;
    Long idTramite;
    String estado;
    
    public ProcedimientoTramiteFilter(){
    }
    
    public ProcedimientoTramiteFilter(Long idProcedimiento,Long idTramite,String estado){
        this.idProcedimiento=idProcedimiento;
        this.idTramite=idTramite;
        this.estado=estado;
    }

    public Long getIdProcedimientoTramite() {
        return idProcedimientoTramite;
    }

    public void setIdProcedimientoTramite(Long idProcedimientoTramite) {
        this.idProcedimientoTramite = idProcedimientoTramite;
    }

    public Long getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
