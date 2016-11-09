package gob.osinergmin.myc.domain.dto;

import gob.osinergmin.myc.domain.NpsTramite;
import gob.osinergmin.myc.domain.PghCnfActUniOrganica;

public class ConfTramiteDTO {
	
	private Long idConfTramite;
	private String estado;
	private String orientacion;
	private Short porcentajeNotificacion;
	private Long idResponsable;
	private TramiteNpsDTO idTramite;
	private CnfActUniOrganicaDTO idCnfActUniOrganica;
	
	
	public Long getIdConfTramite() {
		return idConfTramite;
	}
	public void setIdConfTramite(Long idConfTramite) {
		this.idConfTramite = idConfTramite;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}
	public Short getPorcentajeNotificacion() {
		return porcentajeNotificacion;
	}
	public void setPorcentajeNotificacion(Short porcentajeNotificacion) {
		this.porcentajeNotificacion = porcentajeNotificacion;
	}
	public Long getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(Long idResponsable) {
		this.idResponsable = idResponsable;
	}
    
	public TramiteNpsDTO getIdTramite() {
		return idTramite;
	}
	public void setIdTramite(TramiteNpsDTO idTramite) {
		this.idTramite = idTramite;
	}
	public CnfActUniOrganicaDTO getIdCnfActUniOrganica() {
		return idCnfActUniOrganica;
	}
	public void setIdCnfActUniOrganica(CnfActUniOrganicaDTO idCnfActUniOrganica) {
		this.idCnfActUniOrganica = idCnfActUniOrganica;
	}
	
	
}
