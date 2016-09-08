/**
* Resumen		
* Objeto			: ModuloDTO.java
* Descripción		: Clase DTO ModuloDTO
* Fecha de Creación	: 
* PR de Creación	: 
* Autor				: mdiosesf
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripción
* ---------------------------------------------------------------------------------------------------
* OSINE_SFS-598     25/07/2016      mdiosesf      				
* 
*/ 
package gob.osinergmin.myc.domain.dto;

public class ModuloDTO {
	private Long idModulo;
	private String ruta;
	private String descripcion;
	private String estado;
	private String observaciones;
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
