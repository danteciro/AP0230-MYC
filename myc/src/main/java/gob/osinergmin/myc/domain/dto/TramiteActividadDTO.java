/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

import java.util.List;

import gob.osinergmin.myc.domain.MdiActividad;
import gob.osinergmin.myc.domain.PghTramite;

/**
 *
 * @author jpiro
 */
public class TramiteActividadDTO {
    private Long idTramiteActivdad;
    private String estado;
    private Long idTramite;
    private String descTramite;
    private ActividadDTO actividad;
    private Long idEtapa;
    private String descEtapa;
    private Long idProceso;
    private String descripcion;
    List<TramiteDTO> tramites;
    List<ActividadDTO> actividades;
    
    public TramiteActividadDTO(){
    	
    }

    public Long getIdTramiteActivdad() {
        return idTramiteActivdad;
    }

    public String getDescEtapa() {
        return descEtapa;
    }

    public void setDescEtapa(String descEtapa) {
        this.descEtapa = descEtapa;
    }

    public void setIdTramiteActivdad(Long idTramiteActivdad) {
        this.idTramiteActivdad = idTramiteActivdad;
    }
    public TramiteActividadDTO(Long idTramiteActivdad, Long idTramite, String estado) {
        this.idTramiteActivdad = idTramiteActivdad;
        this.idTramite=idTramite;
        this.estado=estado;
    }
    
    public TramiteActividadDTO(Long idTramiteActivdad, Long idTramite,Long idActividad,  String estado) {
        this.idTramiteActivdad = idTramiteActivdad;
        this.idTramite=idTramite;
        this.actividad=new ActividadDTO(idActividad);
        this.estado=estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public Long getIdEtapa() {
		return idEtapa;
	}

	public void setIdEtapa(Long idEtapa) {
		this.idEtapa = idEtapa;
	}

	public Long getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescTramite() {
		return descTramite;
	}

	public void setDescTramite(String descTramite) {
		this.descTramite = descTramite;
	}

	public List<TramiteDTO> getTramites() {
		return tramites;
	}

	public void setTramites(List<TramiteDTO> tramites) {
		this.tramites = tramites;
	}

	public List<ActividadDTO> getActividades() {
		return actividades;
	}

	public void setActividades(List<ActividadDTO> actividades) {
		this.actividades = actividades;
	}

	public ActividadDTO getActividad() {
		return actividad;
	}

	public void setActividad(ActividadDTO actividad) {
		this.actividad = actividad;
	}
    
        
}
