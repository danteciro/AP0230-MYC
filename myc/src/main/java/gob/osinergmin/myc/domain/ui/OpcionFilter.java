/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author jsifuentes
 */
public class OpcionFilter extends BasePaginatorFilter {
    private String estado;
    private String aplicacion;
    private Long idRubroOpcion;
    private Long idOpcion;
    private Long idActividad;
    private String identificadorOpcion;
    

    public OpcionFilter(){
    }

    public OpcionFilter(String estado, Long idRubroOpcion) {
		super();
		this.estado = estado;
		this.idRubroOpcion = idRubroOpcion;
	}

	public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
	public String getAplicacion() {
		return aplicacion;
	}
	
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public Long getIdRubroOpcion() {
		return idRubroOpcion;
	}

	public void setIdRubroOpcion(Long idRubroOpcion) {
		this.idRubroOpcion = idRubroOpcion;
	}

	public Long getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Long idOpcion) {
		this.idOpcion = idOpcion;
	}

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public String getIdentificadorOpcion() {
		return identificadorOpcion;
	}

	public void setIdentificadorOpcion(String identificadorOpcion) {
		this.identificadorOpcion = identificadorOpcion;
	}
	
    
}
