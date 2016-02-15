package gob.osinergmin.myc.domain.dto;

import java.util.List;

public class ObligacionTipoDTO {
	private Long idObligacionTipo;
	private String nombre;
	private String estado;
	
	public Long getIdObligacionTipo() {
		return idObligacionTipo;
	}
	public void setIdObligacionTipo(Long idObligacionTipo) {
		this.idObligacionTipo = idObligacionTipo;
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
}
