package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.NpsEtapa;

public class SubEtapaNpsFilter {
	
	private Long idSubetapa;
    private String descripcion;
    private String estado;
    private Short tiempoDias;
    private String responsable;
    private NpsEtapa idEtapa;
    
    private Long idResponsable;

    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }
    
    
	public Long getIdSubetapa() {
		return idSubetapa;
	}
	public void setIdSubetapa(Long idSubetapa) {
		this.idSubetapa = idSubetapa;
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
	public Short getTiempoDias() {
		return tiempoDias;
	}
	public void setTiempoDias(Short tiempoDias) {
		this.tiempoDias = tiempoDias;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public NpsEtapa getIdEtapa() {
		return idEtapa;
	}
	public void setIdEtapa(NpsEtapa idEtapa) {
		this.idEtapa = idEtapa;
	}
    
    

}
