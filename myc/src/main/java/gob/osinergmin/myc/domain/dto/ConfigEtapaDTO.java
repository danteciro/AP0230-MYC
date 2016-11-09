package gob.osinergmin.myc.domain.dto;

public class ConfigEtapaDTO {

	private Long numero;
	private Long idUnidadOrganica;
	private Long idActividad;
	private Long idSector;
	private Long idTramite;
	private Short notificacion;
	private String informeOrientacion;
	
	public Long getIdUnidadOrganica() {
		return idUnidadOrganica;
	}
	public void setIdUnidadOrganica(Long idUnidadOrganica) {
		this.idUnidadOrganica = idUnidadOrganica;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public Long getIdSector() {
		return idSector;
	}
	public void setIdSector(Long idSector) {
		this.idSector = idSector;
	}
	
	public Long getIdTramite() {
		return idTramite;
	}
	
	public void setIdTramite(Long idTramite) {
		this.idTramite = idTramite;
	}
	
	public Short getNotificacion() {
		return notificacion;
	}
	public void setNotificacion(Short notificacion) {
		this.notificacion = notificacion;
	}
	public String getInformeOrientacion() {
		return informeOrientacion;
	}
	public void setInformeOrientacion(String informeOrientacion) {
		this.informeOrientacion = informeOrientacion;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
}
