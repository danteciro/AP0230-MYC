package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class CriterioImplFilter extends BasePaginatorFilter {
	
	private Long idCriterio;
	private Long idTipificacion;
	private String descripcion;
	private String tipoCriterio;
	private String idsCriterios;
	
	public String getIdsCriterios() {
		return idsCriterios;
	}

	public void setIdsCriterios(String idsCriterios) {
		this.idsCriterios = idsCriterios;
	}

	private String flgBusqAvanzada;

	public Long getIdCriterio() {
		return idCriterio;
	}
	
	public void setIdCriterio(Long idCriterio) {
		this.idCriterio = idCriterio;
	}

	public Long getIdTipificacion() {
		return idTipificacion;
	}

	public void setIdTipificacion(Long idTipificacion) {
		this.idTipificacion = idTipificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFlgBusqAvanzada() {
		return flgBusqAvanzada;
	}

	public void setFlgBusqAvanzada(String flgBusqAvanzada) {
		this.flgBusqAvanzada = flgBusqAvanzada;
	}

	public String getTipoCriterio() {
		return tipoCriterio;
	}

	public void setTipoCriterio(String tipoCriterio) {
		this.tipoCriterio = tipoCriterio;
	}
	
}
