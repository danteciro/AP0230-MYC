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
public class CriterioFilter extends BasePaginatorFilter{
    private Long idCriterio;
    private String descripcion;
    private String estado;
    private String tipoCriterio;
    private Long idTipificacion;
    
    private String flgBusqAvanzada;

    public Long getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Long idCriterio) {
        this.idCriterio = idCriterio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoCriterio() {
		return tipoCriterio;
	}

	public void setTipoCriterio(String tipoCriterio) {
		this.tipoCriterio = tipoCriterio;
	}

	public Long getIdTipificacion() {
		return idTipificacion;
	}

	public void setIdTipificacion(Long idTipificacion) {
		this.idTipificacion = idTipificacion;
	}

	public String getFlgBusqAvanzada() {
		return flgBusqAvanzada;
	}

	public void setFlgBusqAvanzada(String flgBusqAvanzada) {
		this.flgBusqAvanzada = flgBusqAvanzada;
	}
}