/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author lbarboza
 */
public class ObligacionTipificacionDTO {
	private Long idActividad;
    private Long idObligacion;
    private Long idTipificacion;
    private String estado;
    private Long idObliTipi;
    private String codigoTipificacion;
    private String descripcion;
    
    private String CodTrazabilidad;

    public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public String getCodTrazabilidad() {
        return CodTrazabilidad;
    }

    public void setCodTrazabilidad(String CodTrazabilidad) {
        this.CodTrazabilidad = CodTrazabilidad;
    }
    
    public Long getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Long idObligacion) {
        this.idObligacion = idObligacion;
    }

    public Long getIdTipificacion() {
        return idTipificacion;
    }

    public void setIdTipificacion(Long idTipificacion) {
        this.idTipificacion = idTipificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdObliTipi() {
        return idObliTipi;
    }

    public void setIdObliTipi(Long idObliTipi) {
        this.idObliTipi = idObliTipi;
    }

    public String getCodigoTipificacion() {
        return codigoTipificacion;
    }

    public void setCodigoTipificacion(String codigoTipificacion) {
        this.codigoTipificacion = codigoTipificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}