package gob.osinergmin.myc.domain.dto;

public class CnfObligacionDTO {
	private  Long idObligacion;
	private  Long idObligacionTipo;
	private  Long idProceso;
	private String estado;
	private Long idActividad;
	private Long idProOblTip;
	private Long idConfObligacion;
	
	/* Descripciones */
	private String nombreActividad;
	private String descripcionObligacionTipo;
	private String nombreProceso;
	
        private String codTrazabilidad;

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }
	
	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	public String getDescripcionObligacionTipo() {
		return descripcionObligacionTipo;
	}
	public void setDescripcionObligacionTipo(String descripcionObligacionTipo) {
		this.descripcionObligacionTipo = descripcionObligacionTipo;
	}
	public String getNombreProceso() {
		return nombreProceso;
	}
	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}
	public Long getIdObligacion() {
		return idObligacion;
	}
	public void setIdObligacion(Long idObligacion) {
		this.idObligacion = idObligacion;
	}
	public Long getIdObligacionTipo() {
		return idObligacionTipo;
	}
	public void setIdObligacionTipo(Long idObligacionTipo) {
		this.idObligacionTipo = idObligacionTipo;
	}
	public Long getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public Long getIdProOblTip() {
		return idProOblTip;
	}
	public void setIdProOblTip(Long idProOblTip) {
		this.idProOblTip = idProOblTip;
	}
	public Long getIdConfObligacion() {
		return idConfObligacion;
	}
	public void setIdConfObligacion(Long idConfObligacion) {
		this.idConfObligacion = idConfObligacion;
	}
	
}
