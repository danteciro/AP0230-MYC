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
public class TramiteFilter extends BasePaginatorFilter {
    private Long idTramite;
    private Long idEtapa;
    private String estado;
    private Long idProcedimiento;
    private Long idTramiteActividad;
    private Long idActividad;
    private String descripcion;
    
    public TramiteFilter(){
    }
    public TramiteFilter(Long idProcedimiento,String estado){
        this.estado=estado;
        this.idProcedimiento=idProcedimiento;
    }
    public TramiteFilter(Long idProcedimiento,Long idActividad,String estado){
        this.estado=estado;
        this.idActividad=idActividad;
    }
    
    public TramiteFilter(String estado,Long idEtapa){
    	this.idEtapa=idEtapa;
    	this.estado=estado;
    }
    
    public TramiteFilter(Long idEtapa, String descripcion,String estado){
    	this.idEtapa=idEtapa;
    	this.descripcion=descripcion;
        this.estado=estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public Long getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Long idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }
    
    public Long getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Long idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
	public Long getIdTramiteActividad() {
		return idTramiteActividad;
	}
	public void setIdTramiteActividad(Long idTramiteActividad) {
		this.idTramiteActividad = idTramiteActividad;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }
}