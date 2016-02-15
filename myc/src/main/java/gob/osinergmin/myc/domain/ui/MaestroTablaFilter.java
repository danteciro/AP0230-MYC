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
public class MaestroTablaFilter extends BasePaginatorFilter {
    private String apliDomi;
    private String dominio;
    private String aplicacion;
    private String descripcion;

    public MaestroTablaFilter(){
    }
    
    public MaestroTablaFilter(String aplicacion,String dominio){
        this.aplicacion=aplicacion;
        this.dominio=dominio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getApliDomi() {
        return apliDomi;
    }

    public void setApliDomi(String apliDomi) {
        this.apliDomi = apliDomi;
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
    
    
}