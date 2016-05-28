package gob.osinergmin.myc.domain.dto;

public class TemaDTO {
	private Long idTemOblMa;
	private Long idObligacion;
	private String estado;
	private Long idTemaObligacion;
        private String codTrazabilidad;

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }
        
	public Long getIdTemOblMa() {
		return idTemOblMa;
	}
	public void setIdTemOblMa(Long idTemOblMa) {
		this.idTemOblMa = idTemOblMa;
	}
	public Long getIdObligacion() {
		return idObligacion;
	}
	public void setIdObligacion(Long idObligacion) {
		this.idObligacion = idObligacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdTemaObligacion() {
		return idTemaObligacion;
	}
	public void setIdTemaObligacion(Long idTemaObligacion) {
		this.idTemaObligacion = idTemaObligacion;
	}
}
