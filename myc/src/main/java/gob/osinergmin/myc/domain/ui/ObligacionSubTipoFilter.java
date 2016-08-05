/**
* Resumen.
* Objeto                            	:              ObligacionSubTipoFilter.java.
* Descripción                   		:              Filter del Objeto ObligacionSubTipo.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                   			RSIS25
*/
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class ObligacionSubTipoFilter extends BasePaginatorFilter{
	private Long idObligacionSubtipo;
	private String nombre;
	private String estado;
	private String identificadorSeleccion;
	private Long idObligacionTipo;
	
	public Long getIdObligacionSubtipo() {
		return idObligacionSubtipo;
	}
	public void setIdObligacionSubtipo(Long idObligacionSubtipo) {
		this.idObligacionSubtipo = idObligacionSubtipo;
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
	public Long getIdObligacionTipo() {
		return idObligacionTipo;
	}
	public void setIdObligacionTipo(Long idObligacionTipo) {
		this.idObligacionTipo = idObligacionTipo;
	}
	
	
}
