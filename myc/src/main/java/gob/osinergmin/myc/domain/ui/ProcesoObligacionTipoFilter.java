package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class ProcesoObligacionTipoFilter  extends BasePaginatorFilter{
	private Long idActividad;
	private Long idProceso;
	private Long idObligacionTipo;
	private Long idProOblTip;
	private String estado;
	
	
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public Long getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}
	public Long getIdObligacionTipo() {
		return idObligacionTipo;
	}
	public void setIdObligacionTipo(Long idObligacionTipo) {
		this.idObligacionTipo = idObligacionTipo;
	}
	public Long getIdProOblTip() {
		return idProOblTip;
	}
	public void setIdProOblTip(Long idProOblTip) {
		this.idProOblTip = idProOblTip;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
