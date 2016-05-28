/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.dto;

/**
 *
 * @author jpiro
 */
public class MaestroTablaDTO {
	private String apliDomi;
    private String dominio;
    private String aplicacion;
    private String descripcion;
    private String estado;
    private String esEditable;

    public String getEsEditable() {
        return esEditable;
    }

    public void setEsEditable(String esEditable) {
        this.esEditable = esEditable;
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
    
    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

	public String getApliDomi() {
		return apliDomi;
	}

	public void setApliDomi(String apliDomi) {
		this.apliDomi = apliDomi;
	}

}
