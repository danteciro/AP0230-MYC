package gob.osinergmin.myc.domain.dto;

import java.util.Date;
import java.util.List;

public class BaseLegalConcordanciaDTO {
	
	private Long idListadoBaseLegal;
	private Long idBaseLegalOrigen;
	private Long idBaseLegalDestino;
	private String estado;
	
	private String codigoBaseLegal;
	private String descripcion;
	
        private String codTrazabilidad; 

    public String getCodTrazabilidad() {
        return codTrazabilidad;
    }

    public void setCodTrazabilidad(String codTrazabilidad) {
        this.codTrazabilidad = codTrazabilidad;
    }
	
	public String getCodigoBaseLegal() {
		return codigoBaseLegal;
	}
	public void setCodigoBaseLegal(String codigoBaseLegal) {
		this.codigoBaseLegal = codigoBaseLegal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public Long getIdListadoBaseLegal() {
		return idListadoBaseLegal;
	}
	public void setIdListadoBaseLegal(Long idListadoBaseLegal) {
		this.idListadoBaseLegal = idListadoBaseLegal;
	}
	

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdBaseLegalOrigen() {
		return idBaseLegalOrigen;
	}
	public void setIdBaseLegalOrigen(Long idBaseLegalOrigen) {
		this.idBaseLegalOrigen = idBaseLegalOrigen;
	}
	public Long getIdBaseLegalDestino() {
		return idBaseLegalDestino;
	}
	public void setIdBaseLegalDestino(Long idBaseLegalDestino) {
		this.idBaseLegalDestino = idBaseLegalDestino;
	}

	

}
