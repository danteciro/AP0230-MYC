package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class DetalleCriterioImplFilter extends BasePaginatorFilter {
	
	private Long idDetalleCriterio;
	private Long idCriterio;	
	private String sancionEspecifica;
	private String estado;
	private String FlgBusqAvanzada;	
	
	public Long getIdDetalleCriterio() {
		return idDetalleCriterio;
	}
	public void setIdDetalleCriterio(Long idDetalleCriterio) {
		this.idDetalleCriterio = idDetalleCriterio;
	}
	public Long getIdCriterio() {
		return idCriterio;
	}
	public void setIdCriterio(Long idCriterio) {
		this.idCriterio = idCriterio;
	}
	public String getSancionEspecifica() {
		return sancionEspecifica;
	}
	public void setSancionEspecifica(String sancionEspecifica) {
		this.sancionEspecifica = sancionEspecifica;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFlgBusqAvanzada() {
		return FlgBusqAvanzada;
	}
	public void setFlgBusqAvanzada(String flgBusqAvanzada) {
		FlgBusqAvanzada = flgBusqAvanzada;
	}
	
}
