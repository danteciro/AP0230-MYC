package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ModuloDTO;
import gob.osinergmin.myc.domain.dto.SeccionDTO;
import gob.osinergmin.myc.domain.dto.UnidadOrganicaDTO;
import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class OrgaActiModuSeccionFilter extends BasePaginatorFilter {
	private Long idOrgaActiModuSecc;
	private Long ordenComponente;
	private Long ordenSeccion;    
	private String estado;
	private SeccionDTO idSeccion;
	private ModuloDTO idModulo;
	private UnidadOrganicaDTO idUnidadOrganica;
	private UnidadOrganicaDTO idUnidadOrganicaSuperior;
	private ActividadDTO idActividad;
	
	public Long getIdOrgaActiModuSecc() {
		return idOrgaActiModuSecc;
	}
	public void setIdOrgaActiModuSecc(Long idOrgaActiModuSecc) {
		this.idOrgaActiModuSecc = idOrgaActiModuSecc;
	}
	public Long getOrdenComponente() {
		return ordenComponente;
	}
	public void setOrdenComponente(Long ordenComponente) {
		this.ordenComponente = ordenComponente;
	}
	public Long getOrdenSeccion() {
		return ordenSeccion;
	}
	public void setOrdenSeccion(Long ordenSeccion) {
		this.ordenSeccion = ordenSeccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public SeccionDTO getIdSeccion() {
		return idSeccion;
	}
	public void setIdSeccion(SeccionDTO idSeccion) {
		this.idSeccion = idSeccion;
	}
	public ModuloDTO getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(ModuloDTO idModulo) {
		this.idModulo = idModulo;
	}
	public UnidadOrganicaDTO getIdUnidadOrganica() {
		return idUnidadOrganica;
	}
	public void setIdUnidadOrganica(UnidadOrganicaDTO idUnidadOrganica) {
		this.idUnidadOrganica = idUnidadOrganica;
	}
	public ActividadDTO getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(ActividadDTO idActividad) {
		this.idActividad = idActividad;
	}
	public UnidadOrganicaDTO getIdUnidadOrganicaSuperior() {
		return idUnidadOrganicaSuperior;
	}
	public void setIdUnidadOrganicaSuperior(
			UnidadOrganicaDTO idUnidadOrganicaSuperior) {
		this.idUnidadOrganicaSuperior = idUnidadOrganicaSuperior;
	}
	
	
}