/**
* Resumen.
* Objeto                            	:              ObligacionSubTipoDTO.java.
* Descripción                   		:              DTO del Objeto ObligacionSubTipo.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                   RSIS25
*/
package gob.osinergmin.myc.domain.dto;

public class ObligacionSubTipoDTO {
	private Long idObligacionSubTipo;
	private String nombre;
	private String estado;
	private String identificadorSeleccion;
	private ObligacionTipoDTO idObligacionTipo;
	
	public Long getIdObligacionSubTipo() {
		return idObligacionSubTipo;
	}
	public void setIdObligacionSubTipo(Long idObligacionSubTipo) {
		this.idObligacionSubTipo = idObligacionSubTipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIdentificadorSeleccion() {
		return identificadorSeleccion;
	}
	public void setIdentificadorSeleccion(String identificadorSeleccion) {
		this.identificadorSeleccion = identificadorSeleccion;
	}
	public ObligacionTipoDTO getIdObligacionTipo() {
		return idObligacionTipo;
	}
	public void setIdObligacionTipo(ObligacionTipoDTO idObligacionTipo) {
		this.idObligacionTipo = idObligacionTipo;
	}
	
}
