package gob.osinergmin.myc.domain.ui;

public class EtapaNpsFilter {
	private Long idEtapa;
    private Long idProceso;
    private String descripcion;
    private String estado;
    private Short plazo;
    private Long idConfTramite;
	
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Short getPlazo() {
		return plazo;
	}
	public void setPlazo(Short plazo) {
		this.plazo = plazo;
	}
	public Long getIdConfTramite() {
		return idConfTramite;
	}
	public void setIdConfTramite(Long idConfTramite) {
		this.idConfTramite = idConfTramite;
	}
    
    
}
