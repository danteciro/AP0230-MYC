/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author jpiro
 */
public class MaestroColumnaFilter extends BasePaginatorFilter {
    private Long idMaestroColumna;
    private String dominio;
    private String codigo;  /* OSINE_SFS-480 - RSIS09 - mdiosesf */
    private String aplicacion;
    private String descripcion;

    public MaestroColumnaFilter(){
    }
    
    public MaestroColumnaFilter(String aplicacion,String dominio,String descripcion){
        this.aplicacion=aplicacion;
        this.dominio=dominio;
        this.descripcion=descripcion;
    }
    
    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdMaestroColumna() {
        return idMaestroColumna;
    }

    public void setIdMaestroColumna(Long idMaestroColumna) {
        this.idMaestroColumna = idMaestroColumna;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

	public String getCodigo() { /* OSINE_SFS-480 - RSIS09 - mdiosesf - Inicio */
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	} /* OSINE_SFS-480 - RSIS09 - mdiosesf - Fin */
}
