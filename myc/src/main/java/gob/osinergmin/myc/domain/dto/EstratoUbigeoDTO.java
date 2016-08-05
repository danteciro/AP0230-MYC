/**
* Resumen.
* Objeto                            	:              EstratoUbigeoDTO.java.
* Descripción                   		:              DTO del Objeto EstratoUbigeo.
* Fecha de Creación     				:              23/05/2016
* Autor                               	:              gvillanueva.
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo                                  	Fecha                             Nombre                              Descripción
* --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*  OSINE_SFS-480                          23/05/2016                        gvillanueva                  			RSIS25
*/
package gob.osinergmin.myc.domain.dto;

public class EstratoUbigeoDTO {
	private Long idEstratoUbigeo;
	private Long idEstrato;
	private String departamento;
	private String provincia;
	private String distrito;
	private String estado;
	public Long getIdEstratoUbigeo() {
		return idEstratoUbigeo;
	}
	public void setIdEstratoUbigeo(Long idEstratoUbigeo) {
		this.idEstratoUbigeo = idEstratoUbigeo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdEstrato() {
		return idEstrato;
	}
	public void setIdEstrato(Long idEstrato) {
		this.idEstrato = idEstrato;
	}
	
	
}
