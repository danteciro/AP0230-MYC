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
 * @author jsifuentes
 */
public class RubroOpcionDTO {
    private Long idRubroOpcion;
    private String estado;
    private OpcionDTO opcion;
    List<OpcionDTO> opciones;
    private Long idActividad;
    private String descActividad;
    
    public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public RubroOpcionDTO(){
    }

	public RubroOpcionDTO(Long idRubroOpcion, String estado, Long idOpcion, Long idActividad) {
		super();
		this.idRubroOpcion = idRubroOpcion;
		this.estado = estado;
		this.opcion = new OpcionDTO(idOpcion);
		this.idActividad = idActividad;
	}
	
	public Long getIdRubroOpcion() {
		return idRubroOpcion;
	}

	public void setIdRubroOpcion(Long idRubroOpcion) {
		this.idRubroOpcion = idRubroOpcion;
	}

	public List<OpcionDTO> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<OpcionDTO> opciones) {
		this.opciones = opciones;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public OpcionDTO getOpcion() {
		return opcion;
	}

	public void setOpcion(OpcionDTO opcion) {
		this.opcion = opcion;
	}
    
	public String getDescActividad() {
		return descActividad;
	}

	public void setDescActividad(String descActividad) {
		this.descActividad = descActividad;
	}

}
