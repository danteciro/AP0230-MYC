/**
* Resumen.
* Objeto                            	:              UnidadObliSupTipoDTO.java.
* Descripción                   		:              DTO del Objeto UnidadObliSuptipo.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                   			RSIS25
*/
package gob.osinergmin.myc.domain.dto;

public class UnidadObliSubTipoDTO {
	private Long idUnidObliSubtipo;
	private UnidadSupervisadaDTO idUnidadSupervisada;
	private ObligacionSubTipoDTO idObligacionSubTipo;
	private String periodo;
	private String estado;
	private String tipoSeleccion;
	private String flagSupOrdenServicio;/* Inicio: OSINE_SFS-480 - RSIS27 */
	private Long idObligacionSubTipoF;
	
	public Long getIdUnidObliSubtipo() {
		return idUnidObliSubtipo;
	}
	public void setIdUnidObliSubtipo(Long idUnidObliSubtipo) {
		this.idUnidObliSubtipo = idUnidObliSubtipo;
	}	
	public UnidadSupervisadaDTO getIdUnidadSupervisada() {
		return idUnidadSupervisada;
	}
	public void setIdUnidadSupervisada(UnidadSupervisadaDTO idUnidadSupervisada) {
		this.idUnidadSupervisada = idUnidadSupervisada;
	}
	public ObligacionSubTipoDTO getIdObligacionSubTipo() {
		return idObligacionSubTipo;
	}
	public void setIdObligacionSubTipo(ObligacionSubTipoDTO idObligacionSubTipo) {
		this.idObligacionSubTipo = idObligacionSubTipo;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipoSeleccion() {
		return tipoSeleccion;
	}
	public void setTipoSeleccion(String tipoSeleccion) {
		this.tipoSeleccion = tipoSeleccion;
	}
	public Long getIdObligacionSubTipoF() {
		return idObligacionSubTipoF;
	}
	public void setIdObligacionSubTipoF(Long idObligacionSubTipoF) {
		this.idObligacionSubTipoF = idObligacionSubTipoF;
	}
	public String getFlagSupOrdenServicio() {
		return flagSupOrdenServicio;
	}
	public void setFlagSupOrdenServicio(String flagSupOrdenServicio) {
		this.flagSupOrdenServicio = flagSupOrdenServicio;
	}
	
	
}
