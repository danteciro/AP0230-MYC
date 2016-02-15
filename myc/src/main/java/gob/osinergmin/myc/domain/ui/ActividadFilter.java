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
public class ActividadFilter extends BasePaginatorFilter {
    private Long idActividad;
    private Long idProcedimiento;
    private Long idTramite;
    private String estado;
    private Long idTramiteActividad;

    public ActividadFilter(){
    }
    public ActividadFilter(Long idProcedimiento,String estado){
        this.idProcedimiento=idProcedimiento;
        this.estado=estado;
    }
    public ActividadFilter(String estado,Long idTramiteActividad){
        this.idTramiteActividad=idTramiteActividad;
        this.estado=estado;
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

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Long getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }
	public Long getIdTramiteActividad() {
		return idTramiteActividad;
	}
	public void setIdTramiteActividad(Long idTramiteActividad) {
		this.idTramiteActividad = idTramiteActividad;
	}
    
    
    
}
