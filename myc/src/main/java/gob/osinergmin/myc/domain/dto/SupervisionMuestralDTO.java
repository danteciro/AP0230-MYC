/**
* Resumen.
* Objeto                            	:              SupervisionMuestralDTO.java.
* Descripción                   		:              DTO del Objeto Supervision Muestral.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                   			RSIS25
*/
package gob.osinergmin.myc.domain.dto;

public class SupervisionMuestralDTO {
	
	private Long idTipoSupervision;
	private Long idSubTipoSupervision;
	private double probEncontrarGES;
	private double porcSupContingencia;
	
	public Long getIdTipoSupervision() {
		return idTipoSupervision;
	}
	public void setIdTipoSupervision(Long idTipoSupervision) {
		this.idTipoSupervision = idTipoSupervision;
	}
	public Long getIdSubTipoSupervision() {
		return idSubTipoSupervision;
	}
	public void setIdSubTipoSupervision(Long idSubTipoSupervision) {
		this.idSubTipoSupervision = idSubTipoSupervision;
	}
	public double getProbEncontrarGES() {
		return probEncontrarGES;
	}
	public void setProbEncontrarGES(double probEncontrarGES) {
		this.probEncontrarGES = probEncontrarGES;
	}
	public double getPorcSupContingencia() {
		return porcSupContingencia;
	}
	public void setPorcSupContingencia(double porcSupContingencia) {
		this.porcSupContingencia = porcSupContingencia;
	}	
	
}
