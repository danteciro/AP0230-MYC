/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

import java.util.List;

/**
 *
 * @author jpiro
 */
public class ParametroDinamicoDTO {
    private Long idParametroDinamico;
    private String nombre;
    private MaestroColumnaDTO idAmbitoParametrico;
    private String ambito;
    private String descripcion;
    private String comentario;
    private String estado;
    private MaestroColumnaDTO idTipoConsulta;
    private String pregunta;
    private List<ValorParametroDTO> valores;

    public List<ValorParametroDTO> getValores() {
        return valores;
    }

    public void setValores(List<ValorParametroDTO> valores) {
        this.valores = valores;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Long getIdParametroDinamico() {
        return idParametroDinamico;
    }

    public void setIdParametroDinamico(Long idParametroDinamico) {
        this.idParametroDinamico = idParametroDinamico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
    	if(nombre!=null)
        this.nombre = nombre.toUpperCase();
    }

    public MaestroColumnaDTO getIdAmbitoParametrico() {
        return idAmbitoParametrico;
    }

    public void setIdAmbitoParametrico(MaestroColumnaDTO idAmbitoParametrico) {
        this.idAmbitoParametrico = idAmbitoParametrico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public MaestroColumnaDTO getIdTipoConsulta() {
		return idTipoConsulta;
	}

	public void setIdTipoConsulta(MaestroColumnaDTO idTipoConsulta) {
		this.idTipoConsulta = idTipoConsulta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
    
    
    
}
