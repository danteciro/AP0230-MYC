/**
* Resumen		
* Objeto			: SeccionDTO.java
* Descripci�n		: Clase DTO SeccionDTO
* Fecha de Creaci�n	: 25/07/2016
* PR de Creaci�n	: OSINE_SFS-598 - RSIS 04
* Autor				: mdiosesf
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                      Descripci�n
* ---------------------------------------------------------------------------------------------------				
* 
*/ 
package gob.osinergmin.myc.domain.dto;

public class SeccionDTO {
	private Long idSeccion;
	private String descripcion;
	private String descripcionLarga;
	private String ruta;
	private String observaciones;
	private String estado;
	
	public Long getIdSeccion() {
		return idSeccion;
	}
	public void setIdSeccion(Long idSeccion) {
		this.idSeccion = idSeccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcionLarga() {
		return descripcionLarga;
	}
	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}
	
}
