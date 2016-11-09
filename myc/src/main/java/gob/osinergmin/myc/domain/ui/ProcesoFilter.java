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
public class ProcesoFilter extends BasePaginatorFilter {
    private String estado;
    /* OSINE_SFS-1232 - REQF- - Inicio */
    private String identificadorProceso;
    /* OSINE_SFS-1232 - REQF- - Fin */
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public String getIdentificadorProceso() {
		return identificadorProceso;
	}

	public void setIdentificadorProceso(String identificadorProceso) {
		this.identificadorProceso = identificadorProceso;
	}
    
    
}
