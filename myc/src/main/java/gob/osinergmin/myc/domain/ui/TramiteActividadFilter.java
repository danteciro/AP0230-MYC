package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

public class TramiteActividadFilter extends BasePaginatorFilter{
    private Long idTramiteActividad;
    private String estado;
    private Long idEtapa;
    private Long idTramite;
    private Long idActividad;    
    private Long idProceso;
    public TramiteActividadFilter(){
    	
    }
    public TramiteActividadFilter(Long idTramiteActivdad, Long idTramite,Long idActividad,  String estado) {
        this.idTramiteActividad = idTramiteActivdad;
        this.idTramite=idTramite;
        this.idActividad=idActividad;
        this.estado=estado;
    }

    public Long getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }
    
	public Long getIdTramiteActividad() {
		return idTramiteActividad;
	}
	public void setIdTramiteActividad(Long idTramiteActividad) {
		this.idTramiteActividad = idTramiteActividad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdEtapa() {
		return idEtapa;
	}
	public void setIdEtapa(Long idEtapa) {
		this.idEtapa = idEtapa;
	}
	public Long getIdTramite() {
		return idTramite;
	}
	public void setIdTramite(Long idTramite) {
		this.idTramite = idTramite;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
    
    
}
