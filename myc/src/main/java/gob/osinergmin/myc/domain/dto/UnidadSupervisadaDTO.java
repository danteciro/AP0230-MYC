/**
* Resumen.
* Objeto                            	:              UnidadSupervisadaDTO.java.
* Descripción                   		:              DTO del Objeto UnidadSupervisada.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                   			RSIS25
*/
package gob.osinergmin.myc.domain.dto;

public class UnidadSupervisadaDTO {
	private Long idUnidadSupervisada;
	private String estado;
	public Long getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}
	public void setIdUnidadSupervisada(Long idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
