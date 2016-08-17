/**
* Resumen           
* Objeto            : PrioridadNormaAgenteDTO.java
* Descripción       : Objeto DTO Prioridad Norma Agente
* Fecha de Creación : 28/06/2016.
* PR de Creación    : OSINE_SFS-600
* Autor             : Erick Ortiz Gil.
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
*/
package gob.osinergmin.myc.domain.dto;

public class PrioridadNormaAgenteDTO {	
	private Long idPrioridadNormaAgente;
	private BaseLegalDTO idBaseLegal;
	private ActividadDTO idAgente;
	private String codigoNormaLegal;
	private Long orden;
	private String estado;
	
	public Long getIdPrioridadNormaAgente() {
		return idPrioridadNormaAgente;
	}
	public void setIdPrioridadNormaAgente(Long idPrioridadNormaAgente) {
		this.idPrioridadNormaAgente = idPrioridadNormaAgente;
	}
	public String getCodigoNormaLegal() {
		return codigoNormaLegal;
	}
	public void setCodigoNormaLegal(String codigoNormaLegal) {
		this.codigoNormaLegal = codigoNormaLegal;
	}
	public Long getOrden() {
		return orden;
	}
	public void setOrden(Long orden) {
		this.orden = orden;
	}
	public BaseLegalDTO getIdBaseLegal() {
		return idBaseLegal;
	}
	public void setIdBaseLegal(BaseLegalDTO idBaseLegal) {
		this.idBaseLegal = idBaseLegal;
	}
	public ActividadDTO getIdAgente() {
		return idAgente;
	}
	public void setIdAgente(ActividadDTO idAgente) {
		this.idAgente = idAgente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}	
}
