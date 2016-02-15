/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.domain.ui;

import gob.osinergmin.myc.domain.dto.MaestroColumnaDTO;
import gob.osinergmin.myc.domain.ui.base.BasePaginatorFilter;

/**
 *
 * @author jpiro
 */
public class ParametroFilter extends BasePaginatorFilter {
    private Long idParametro;
    private String nombre;
    private Long idAmbitoParametrico;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Long idParametro) {
        this.idParametro = idParametro;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdAmbitoParametrico() {
		return idAmbitoParametrico;
	}

	public void setIdAmbitoParametrico(Long idAmbitoParametrico) {
		this.idAmbitoParametrico = idAmbitoParametrico;
	}
    
    
    
}
